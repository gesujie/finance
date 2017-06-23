package com.jibinfo.finance.mapper.email;

import com.jibinfo.finance.entity.email.EmailTemplate;
import com.jibinfo.finance.entity.email.EmailTemplateExample;
import com.jibinfo.framework.dao.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan("emailTemplateMapper")
public interface EmailTemplateMapper extends BaseMapper<EmailTemplateExample,EmailTemplate> {
    int countByExample(EmailTemplateExample example);

    int deleteByExample(EmailTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EmailTemplate record);

    int insertSelective(EmailTemplate record);

    List<EmailTemplate> selectByExample(EmailTemplateExample example);

    EmailTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EmailTemplate record, @Param("example") EmailTemplateExample example);

    int updateByExample(@Param("record") EmailTemplate record, @Param("example") EmailTemplateExample example);

    int updateByPrimaryKeySelective(EmailTemplate record);

    int updateByPrimaryKey(EmailTemplate record);
}