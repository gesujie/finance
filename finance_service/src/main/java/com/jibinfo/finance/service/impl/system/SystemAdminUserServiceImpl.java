package com.jibinfo.finance.service.impl.system;


import com.jibinfo.finance.entity.system.SystemAdminUser;
import com.jibinfo.finance.entity.system.SystemAdminUserExample;
import com.jibinfo.finance.mapper.system.SystemAdminUserMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.system.SystemAdminUserService;
import com.jibinfo.finance.utils.FinanceAvatarUtils;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.security.Authorization;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.support.utility.Configuration;
import com.jibinfo.framework.utils.SessionUtils;
import com.jibinfo.framework.utils.StringUtils;
import com.jibinfo.framework.utils.security.PasswordEncryptionUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service("systemAdminUserService")
public class SystemAdminUserServiceImpl extends AbstractBaseServiceEx<SystemAdminUserExample, SystemAdminUser> implements SystemAdminUserService {
	
	@Resource
	private SystemAdminUserMapper systemAdminUserMapper;
	
	@Resource
	private SessionUtils sessionUtils;

	public static final String DEFAULT_PASSWORD = Configuration.getProperty("common", "password.default.all","111111");

	@Override
	public BaseMapper<SystemAdminUserExample, SystemAdminUser> getMapper() {
		return systemAdminUserMapper;
	}

	@Override
	public ResponseVo login(String userName, String password,String session) {
		if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password))
			return new ResponseVo().failureResponse("用户名或者密码为空!");
		
		ResponseVo result = new ResponseVo().successResponse();
		try {
			password = PasswordEncryptionUtil.md5Base64(password);
			
			SystemAdminUserExample example = new SystemAdminUserExample();
			example.createCriteria().andIsDelEqualTo(Constants.NO_DEL)//判断删除状态
									.andStatEqualTo(Constants.ENABLE)//判断禁用状态
									.andUserNameEqualTo(userName)//用户名
									.andUserPwdEqualTo(password);//密码
			List<SystemAdminUser> userList = systemAdminUserMapper.selectByExample(example);
			if(null == userList || userList.size() == 0){
				result = new ResponseVo().failureResponse("用户不存在或已禁用!");
			}
			else{
				SystemAdminUser systemAdminUser = userList.get(0);
				Authorization authorization = new Authorization();
				authorization.setId(systemAdminUser.getId());
				authorization.setUsername(systemAdminUser.getUserName());
				authorization.setSession(session);
				sessionUtils.sessionPut(session, authorization);
				result.setBody(authorization);
			}
		} catch (Exception e) {
			result = new ResponseVo().failureResponse("登录异常!");
			e.printStackTrace();
		}
		return result;
	}
	
	
	public void logout(String session){
		sessionUtils.removeSession(session);
	}

	@Override
	public PageModel<SystemAdminUser> getData(Integer pageNumber, Integer pageSize, SystemAdminUser model) {
		Paginator paginator = new Paginator().getPaginator(pageNumber, pageSize);

		SystemAdminUserExample example = new SystemAdminUserExample();
		SystemAdminUserExample.Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);
		example.setOrderByClause("id desc");

		if (model != null) {
			if(!StringUtils.isEmpty(model.getName())){
				criteria.andNameLike("%"+model.getName()+"%");
			}
			if(!StringUtils.isEmpty(model.getMobile())){
				criteria.andMobileLike("%"+model.getMobile()+"%");
			}
			if(!StringUtils.isEmpty(model.getEmail())){
				criteria.andEmailLike("%"+model.getEmail()+"%");
			}
		}

		example.setPaginator(paginator);

		List<SystemAdminUser> systemAdminUsers = systemAdminUserMapper.selectByExample(example);
		int total = systemAdminUserMapper.countByExample(example);
		PageModel<SystemAdminUser> pageModel = new PageModel<>(total, systemAdminUsers);
		return pageModel;
	}

	@Override
	public ResponseVo saveOrUpdate(SystemAdminUser model) {
		ResponseVo responseVo = new ResponseVo().successResponse();
		try {
			Date date = new Date();
			model.setUpdatedDate(date);
			if(check(model)){
				//设置头像
				if(StringUtils.isEmpty(model.getUserIcon())){
					String avatarPath = FinanceAvatarUtils.createAvatar(model.getUserName().substring(0,1));
					model.setUserIcon(avatarPath);
				}
				if(null == model.getId()){
					//获取默认的密码信息
					String defaultPwd = PasswordEncryptionUtil.md5Base64(DEFAULT_PASSWORD);
					model.setUserPwd(defaultPwd);
					model.setCreatedDate(date);
					systemAdminUserMapper.insertSelective(model);

				}
				else{
					systemAdminUserMapper.updateByPrimaryKeySelective(model);

				}
			}
			else{
				return new ResponseVo().failureResponse("用户名重复!");
			}


		} catch (Exception e) {
			e.printStackTrace();
			responseVo = new ResponseVo().failureResponse("保存异常!");
		}

		return responseVo;
	}

	//校验用户名重复
	private boolean check(SystemAdminUser adminUser){
		SystemAdminUserExample example = new SystemAdminUserExample();
		example.createCriteria().andIsDelEqualTo(Constants.NO_DEL).andUserNameEqualTo(adminUser.getUserName());
		List<SystemAdminUser> systemAdminUsers = systemAdminUserMapper.selectByExample(example);
		if(null == systemAdminUsers || systemAdminUsers.size() == 0 ){
			return true;
		}
		else{
			SystemAdminUser systemAdminUser = systemAdminUsers.get(0);
			if(null == adminUser.getId()){
				return false;
			}
			else if(systemAdminUser.getId().longValue() == adminUser.getId().longValue()){
				return true;
			}
		}
		return false;
	}


	@Override
	public ResponseVo delete(String ids) {
		ResponseVo result = new ResponseVo().successResponse();
		try {
			String[] idArr = StringUtils.split(ids,",");
			if(null != idArr && idArr.length > 0){
				for (String id : idArr) {
					SystemAdminUser model = systemAdminUserMapper.selectByPrimaryKey(new Long(id));
					model.setUpdatedDate(new Date());
					model.setIsDel(Constants.YES_DEL);
					systemAdminUserMapper.updateByPrimaryKeySelective(model);
				}
			}
		} catch (Exception e) {
			result = result.failureResponse("异常");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResponseVo changeState(Long id) {
		ResponseVo responseVo = new ResponseVo().successResponse();
		try {
			SystemAdminUser systemAdminUser = systemAdminUserMapper.selectByPrimaryKey(id);
			if("0".equals(systemAdminUser.getStat())){
                systemAdminUser.setStat("1");
            }
            else{
                systemAdminUser.setStat("0");
            }
			systemAdminUserMapper.updateByPrimaryKeySelective(systemAdminUser);
		} catch (Exception e) {
			e.printStackTrace();
			responseVo = new ResponseVo().failureResponse("修改状态异常!");
		}
		return responseVo;
	}

	@Override
	public ResponseVo getUserInfo(Long id) {
		ResponseVo responseVo = new ResponseVo().successResponse();
		SystemAdminUser systemAdminUser = systemAdminUserMapper.selectByPrimaryKey(id);
		responseVo.setBody(systemAdminUser);
		return responseVo;
	}


	@Override
	public ResponseVo resetPwd(String ids) {
		ResponseVo responseVo = new ResponseVo().successResponse();
		try {
			String[] idArr = StringUtils.split(ids,",");
			if(null != idArr && idArr.length > 0){
				for (String id : idArr) {
					SystemAdminUser systemAdminUser = systemAdminUserMapper.selectByPrimaryKey(new Long(id));
					String defaultPwd = PasswordEncryptionUtil.md5Base64(DEFAULT_PASSWORD);
					systemAdminUser.setUserPwd(defaultPwd);
					systemAdminUser.setUpdatedDate(new Date());
					systemAdminUserMapper.updateByPrimaryKeySelective(systemAdminUser);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			responseVo = new ResponseVo().failureResponse("充值密码异常!");
		}

		return responseVo;
	}

	@Override
	public ResponseVo updatePwd(Long id,String oldPwd,String newPwd) {
		ResponseVo responseVo = new ResponseVo().successResponse();

		SystemAdminUser systemAdminUser = systemAdminUserMapper.selectByPrimaryKey(id);
		oldPwd = PasswordEncryptionUtil.md5Base64(oldPwd);
		if(oldPwd.equals(systemAdminUser.getUserPwd())){
			systemAdminUser.setUpdatedDate(new Date());
			systemAdminUser.setUserPwd(PasswordEncryptionUtil.md5Base64(newPwd));
			systemAdminUserMapper.updateByPrimaryKeySelective(systemAdminUser);
		}
		else{
			responseVo = new ResponseVo().failureResponse("原始密码错误!");
		}
		return responseVo;
	}


}
