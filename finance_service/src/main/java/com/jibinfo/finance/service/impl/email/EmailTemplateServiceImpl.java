package com.jibinfo.finance.service.impl.email;


import com.jibinfo.finance.entity.email.EmailTemplate;
import com.jibinfo.finance.entity.email.EmailTemplateExample;
import com.jibinfo.finance.mapper.email.EmailTemplateMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.email.EmailTemplateService;
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

@Service("emailTemplateService")
public class EmailTemplateServiceImpl extends AbstractBaseServiceEx<EmailTemplateExample, EmailTemplate> implements EmailTemplateService {

    @Resource
    private EmailTemplateMapper emailTemplateMapper;

    @Override
    public BaseMapper<EmailTemplateExample, EmailTemplate> getMapper() {
        return emailTemplateMapper;
    }


    @Override
    public PageModel<EmailTemplate> getData(EmailTemplate param, Integer pageNumber, Integer pageSize) {
        Paginator paginator = new Paginator().getPaginator(pageNumber,pageSize);
        EmailTemplateExample example = new EmailTemplateExample();
        EmailTemplateExample.Criteria criteria = example.createCriteria().andIsDelEqualTo(Constants.NO_DEL);
        example.setOrderByClause("ID DESC");
        example.setPaginator(paginator);
        if(null != param){
            if(StringUtils.isNotEmpty(param.getName())){
                criteria.andNameLike("%"+param.getName()+"%");
            }
        }

        List<EmailTemplate> emailTemplates = emailTemplateMapper.selectByExample(example);
        int count = emailTemplateMapper.countByExample(example);
        PageModel<EmailTemplate> pageModel = new PageModel<EmailTemplate>(count,emailTemplates);

        return pageModel;
    }

    @Override
    public ResponseVo saveOrUpdate(EmailTemplate model) {
        ResponseVo responseVo = new ResponseVo().successResponse();
        Date date = new Date();
        try {
            if(StringUtils.isEmpty(model.getContent())){
                responseVo = new ResponseVo().failureResponse("请输入正确的邮件模板");
                return responseVo;
            }
            model.setUpdatedDate(date);
            if(null == model.getId()){
                model.setCreatedDate(date);
                model.setIsDel(Constants.NO_DEL);
                emailTemplateMapper.insertSelective(model);

            }
            else{
                emailTemplateMapper.updateByPrimaryKeySelective(model);
            }
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
                    EmailTemplate emailTemplate = emailTemplateMapper.selectByPrimaryKey(new Long(id));
                    emailTemplate.setIsDel(Constants.YES_DEL);
                    emailTemplate.setUpdatedDate(new Date());
                    emailTemplateMapper.updateByPrimaryKeySelective(emailTemplate);
                }

            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            responseVo = new ResponseVo().failureResponse();
        }
        return responseVo;
    }

    @Override
    public EmailTemplate getTemplateByCode(String code) {
        EmailTemplateExample example = new EmailTemplateExample();
        example.createCriteria().andIsDelEqualTo(Constants.NO_DEL).andCodeEqualTo(code);
        List<EmailTemplate> emailTemplates = emailTemplateMapper.selectByExample(example);
        return emailTemplates.size() > 0 ? emailTemplates.get(0) : null;
    }
}
