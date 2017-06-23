package com.jibinfo.finance.service.impl.email;


import com.jibinfo.finance.entity.email.EmailGateway;
import com.jibinfo.finance.entity.email.EmailGatewayExample;
import com.jibinfo.finance.mapper.email.EmailGatewayMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.email.EmailGatewayService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2017/4/24.
 */

@Service("emailGatewayService")
public class EmailGatewayServiceImpl extends AbstractBaseServiceEx<EmailGatewayExample, EmailGateway> implements EmailGatewayService {

    @Resource
    private EmailGatewayMapper emailGatewayMapper;

    @Override
    public BaseMapper<EmailGatewayExample, EmailGateway> getMapper() {
        return emailGatewayMapper;
    }


    @Override
    public PageModel<EmailGateway> getData(EmailGateway param, Integer pageNumber, Integer pageSize) {
        Paginator paginator = new Paginator().getPaginator(pageNumber, pageSize);
        EmailGatewayExample example = new EmailGatewayExample();
        example.setOrderByClause("ID DESC");
        example.setPaginator(paginator);
        EmailGatewayExample.Criteria criteria = example.createCriteria().andIsDelEqualTo(Constants.NO_DEL);
        if(null != param){
            if(StringUtils.isNotEmpty(param.getSender())){
                criteria.andSenderLike(""+param.getSender()+"");
            }
        }
        List<EmailGateway> emailGateways = emailGatewayMapper.selectByExample(example);
        int count = emailGatewayMapper.countByExample(example);
        PageModel<EmailGateway> pageModel = new PageModel<EmailGateway>(count,emailGateways);
        return pageModel;
    }

    @Override
    public ResponseVo saveOrUpdate(EmailGateway model) {
        ResponseVo responseVo = new ResponseVo().successResponse();
        Date date = new Date();
        try {
            model.setUpdatedDate(date);

            if(null == model.getId()){
                model.setIsDel(Constants.NO_DEL);
                model.setCreatedDate(date);
                emailGatewayMapper.insertSelective(model);
            }
            else{

                emailGatewayMapper.updateByPrimaryKeySelective(model);
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
            EmailGateway emailGateway = emailGatewayMapper.selectByPrimaryKey(id);
            if("0".equals(emailGateway.getOnOff())){
                emailGateway.setOnOff("1");
            }
            else{
                emailGateway.setOnOff("0");
            }
            emailGateway.setUpdatedDate(new Date());
            emailGatewayMapper.updateByPrimaryKeySelective(emailGateway);

        } catch (Exception e) {
            e.printStackTrace();
            responseVo = new ResponseVo().failureResponse();
        }

        return responseVo;
    }

    @Override
    public ResponseVo delete(String ids) {
        ResponseVo responseVo = new ResponseVo().successResponse();

        try {
            if(StringUtils.isNotEmpty(ids)){
                String[] idsArr = ids.split(",");
                for (String id : idsArr) {
                    EmailGateway emailGateway = emailGatewayMapper.selectByPrimaryKey(new Long(id));
                    emailGateway.setUpdatedDate(new Date());
                    emailGateway.setIsDel(Constants.YES_DEL);
                    emailGatewayMapper.updateByPrimaryKeySelective(emailGateway);
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            responseVo = new ResponseVo().failureResponse();
        }

        return responseVo;
    }

    @Override
    public EmailGateway getEmailGateway() {
        EmailGatewayExample example = new EmailGatewayExample();
        example.createCriteria().andIsDelEqualTo(Constants.NO_DEL).andOnOffEqualTo(Constants.OPEN);
        List<EmailGateway> emailGateways = emailGatewayMapper.selectByExample(example);
        if(emailGateways.size() > 0){
            return emailGateways.get(0);
        }
        return null;
    }

    public static void main(String[] args) {
        String str = "我叫%s";
        System.out.println(String.format(str,"GE"));
    }
}
