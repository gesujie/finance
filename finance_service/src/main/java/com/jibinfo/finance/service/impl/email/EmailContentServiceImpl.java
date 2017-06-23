package com.jibinfo.finance.service.impl.email;


import com.jibinfo.finance.entity.email.EmailContent;
import com.jibinfo.finance.entity.email.EmailContentExample;
import com.jibinfo.finance.mapper.email.EmailContentMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.email.EmailContentService;
import com.jibinfo.finance.vo.email.EmailVO;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2017/4/24.
 */

@Service("emailContentService")
public class EmailContentServiceImpl extends AbstractBaseServiceEx<EmailContentExample, EmailContent> implements EmailContentService {

    @Resource
    private EmailContentMapper emailContentMapper;

    private static final Integer AGAIN_COUNTS_INIT = 0;//邮件发送失败重试次数

    @Override
    public BaseMapper<EmailContentExample, EmailContent> getMapper() {
        return emailContentMapper;
    }


    /**
     * 保存发送的内容
     * @param emailVO
     * @param receivers
     */
    public void saveEmailContent(Long eid, EmailVO emailVO, int type,String code,String msg,String... receivers){
        String receiver = StringUtils.join(receivers, ",");
        EmailContent emailContent = new EmailContent();
        Date date = new Date();
        emailContent.setUpdatedDate(date);
        emailContent.setCreatedDate(date);
        emailContent.setIsDel(Constants.NO_DEL);
        emailContent.setEid(eid);
        emailContent.setToUser(receiver);
        emailContent.setSubject(emailVO.getSubject());
        emailContent.setContent(EmailVO.composeMessage(emailVO.getMessage(),emailVO.getParams()));
        emailContent.setAgainCounts(AGAIN_COUNTS_INIT);
        emailContent.setStatus(type+"");
        emailContent.setResultCode(code);
        emailContent.setResultMsg(msg);
        emailContentMapper.insertSelective(emailContent);
    }

    @Override
    public PageModel<EmailContent> getData(EmailContent param, Integer pageNumber, Integer pageSize) {

        EmailContentExample example = new EmailContentExample();
        EmailContentExample.Criteria criteria = example.createCriteria().andIsDelEqualTo(Constants.NO_DEL);
        if (param != null) {
            if(StringUtils.isNotEmpty(param.getSubject())){
                criteria.andSubjectLike("%"+param.getSubject()+"%");
            }
            if(StringUtils.isNotEmpty(param.getStatus())){
                criteria.andStatusEqualTo(param.getStatus());
            }
        }
        List<EmailContent> emailContents = emailContentMapper.selectByExample(example);
        int count = emailContentMapper.countByExample(example);
        PageModel<EmailContent> pageModel = new PageModel<>(count,emailContents);

        return pageModel;
    }

    @Override
    public ResponseVo delete(String ids) {
        ResponseVo responseVo = new ResponseVo().successResponse();
        if(StringUtils.isNotEmpty(ids)){
            String[] idsArr = ids.split(",");
            for (String id : idsArr) {
                EmailContent emailContent = emailContentMapper.selectByPrimaryKey(new Long(id));
                emailContent.setIsDel(Constants.YES_DEL);
                emailContent.setUpdatedDate(new Date());
                emailContentMapper.updateByPrimaryKeySelective(emailContent);
            }
        }
        return responseVo;
    }


}
