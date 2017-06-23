package com.jibinfo.finance.service.impl.user;


import com.jibinfo.finance.dto.UserChartDTO;
import com.jibinfo.finance.entity.user.User;
import com.jibinfo.finance.entity.user.UserBlack;
import com.jibinfo.finance.entity.user.UserExample;
import com.jibinfo.finance.mapper.user.UserMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.user.UserBlackService;
import com.jibinfo.finance.service.user.UserService;
import com.jibinfo.finance.utils.DateUtils;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


@Service("userService")
public class UserServiceImpl extends AbstractBaseServiceEx<UserExample,User> implements UserService {
	
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private UserBlackService userBlackService;
	
	@Override
	public BaseMapper<UserExample, User> getMapper() {
		return userMapper;
	}


	@Override
	public PageModel<User> getData(User user, Integer pageNumber, Integer pageSize) {

		Paginator paginator = new Paginator().getPaginator(pageNumber, pageSize);
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria().andIsDelEqualTo(Constants.NO_DEL);
		if (user != null) {
			if(StringUtils.isNotEmpty(user.getUserName())){
				criteria.andUserNameLike("%"+user.getUserName()+"%");
			}
			if(StringUtils.isNotEmpty(user.getEmail())){
				criteria.andEmailLike("%"+user.getEmail()+"%");
			}
			if(StringUtils.isNotEmpty(user.getMobile())){
				criteria.andMobileLike("%"+user.getMobile()+"%");
			}

		}

		example.setPaginator(paginator);
		example.setOrderByClause("ID DESC");
		List<User> list = userMapper.selectByExample(example);
		int count = userMapper.countByExample(example);
		PageModel<User> pageModel = new PageModel<User>(count,list);
		return pageModel;
	}

	@Override
	public ResponseVo enableDisable(String ids) {
		ResponseVo responseVo = new ResponseVo().successResponse();
		try {
			if(StringUtils.isNotEmpty(ids)){
                String[] strings = ids.split(",");
                for (String string : strings) {
					this.updateStatus(new Long(string));
                }
            }
		} catch (Exception e) {
			e.printStackTrace();
			responseVo = new ResponseVo().failureResponse();
		}


		return responseVo;
	}

	@Override
	public ResponseVo changeState(Long id) {
		ResponseVo responseVo = new ResponseVo().successResponse();
		try {
			this.updateStatus(id);
		} catch (Exception e) {
			e.printStackTrace();
			responseVo = new ResponseVo().failureResponse();
		}

		return responseVo;
	}


	/**
	 * 修改状态
	 * @param id
	 */
	private void updateStatus(Long id){
		User user = userMapper.selectByPrimaryKey(id);
		user.setUpdatedDate(new Date());
		if(Constants.ENABLE.equals(user.getStatus())){
			user.setStatus(Constants.DISABLE);
		}
		else{
			user.setStatus(Constants.ENABLE);
		}
		userMapper.updateByPrimaryKeySelective(user);
	}


	@Override
	public ResponseVo setBlack(Long id,String remark) {
		ResponseVo responseVo = new ResponseVo().successResponse();
		try {
			this.updateStatus(id);
			UserBlack userBlack = new UserBlack();
			userBlack.setCreatedDate(new Date());
			userBlack.setIsDel(Constants.NO_DEL);
			userBlack.setRemark(remark);
			userBlack.setUpdatedDate(new Date());
			userBlack.setUserId(id);
			userBlackService.insertSelective(userBlack);
		} catch (Exception e) {
			e.printStackTrace();
			responseVo = new ResponseVo().failureResponse();
		}

		return responseVo;
	}

    @Override
    public ResponseVo findByChart() {
		ResponseVo responseVo = new ResponseVo().successResponse();
		Map<String,Object> body = new HashMap<>();
		Date date = new Date();//当前时间
		Date beforeDate = DateUtils.getDate(date, 0, -3);
		List<String> lables = this.getLables(date, beforeDate);
		body.put("lables",lables);
		List<UserChartDTO> groupUser= userMapper.groupByCreateDate(beforeDate,date);
		this.setDatas(date,beforeDate,groupUser);
		body.put("datas",groupUser);
		responseVo.setBody(body);
		return responseVo;
    }

	/**
	 * 设置数据信息
	 * @param date
	 * @param beforeDate
	 * @param groupUser
	 */
    private void setDatas(Date date,Date beforeDate,List<UserChartDTO> groupUser){
		StringBuilder sb = new StringBuilder("");
		if(null != groupUser && groupUser.size() > 0){
			for (UserChartDTO userChartDTO : groupUser) {
				sb.append(userChartDTO.getDate()+",");
			}
		}
		long count = DateUtils.count(beforeDate, date, DateUtils.TYPE_DAY);
		UserChartDTO user = null;
		for (int i = 0; i < count; i++){
			Date newDay = DateUtils.getDate(beforeDate, 0, 0, i);
			String dateStr = DateUtils.dateToStr(newDay, "yyyy-MM-dd");
			if(!sb.toString().contains(dateStr)){
				user = new UserChartDTO(dateStr,0);
				sb.append(dateStr+",");
				groupUser.add(user);
			}
		}
		if (null != groupUser && !groupUser.isEmpty()) {
			Collections.sort(groupUser, new Comparator<UserChartDTO>() {
				@Override
				public int compare(UserChartDTO o1, UserChartDTO o2) {
					String date1 = o1.getDate();
					String date2 = o2.getDate();
					return date1.compareTo(date2);
				}
			});
		}

	}


    private List<String> getLables(Date date,Date beforeDate){
		List<String> list = new ArrayList<>(12);

		list.add(DateUtils.dateToStr(beforeDate,"MM-dd"));
		long count = DateUtils.count(beforeDate, date, DateUtils.TYPE_DAY);
		long dvalue = count / 10;
		for(int i = 1;i < 11; i++){
			int days = (int)dvalue * i;
			Date newDay = DateUtils.getDate(beforeDate, 0, 0, days);
			list.add(DateUtils.dateToStr(newDay,"MM-dd"));
		}
		list.add(DateUtils.dateToStr(date,"MM-dd"));
		return list;

	}


}
