package com.jibinfo.finance.mapper.sms;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.jibinfo.finance.entity.sms.SmsTemplate;
import com.jibinfo.finance.entity.sms.SmsTemplateExample;
import com.jibinfo.framework.dao.base.BaseMapper;

@MapperScan("smsTemplateMapper")
public interface SmsTemplateMapper extends BaseMapper<SmsTemplateExample, SmsTemplate>{
    int countByExample(SmsTemplateExample example);

    int deleteByExample(SmsTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsTemplate record);

    int insertSelective(SmsTemplate record);

    List<SmsTemplate> selectByExample(SmsTemplateExample example);

    SmsTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsTemplate record, @Param("example") SmsTemplateExample example);

    int updateByExample(@Param("record") SmsTemplate record, @Param("example") SmsTemplateExample example);

    int updateByPrimaryKeySelective(SmsTemplate record);

    int updateByPrimaryKey(SmsTemplate record);
}