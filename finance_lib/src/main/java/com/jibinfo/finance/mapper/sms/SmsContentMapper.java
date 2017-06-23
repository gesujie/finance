package com.jibinfo.finance.mapper.sms;

import com.jibinfo.finance.entity.sms.SmsContent;
import com.jibinfo.finance.entity.sms.SmsContentExample;
import com.jibinfo.framework.dao.base.BaseMapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan("smsContentMapper")
public interface SmsContentMapper extends BaseMapper<SmsContentExample, SmsContent> {
    int countByExample(SmsContentExample example);

    int deleteByExample(SmsContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsContent record);

    int insertSelective(SmsContent record);

    List<SmsContent> selectByExample(SmsContentExample example);

    SmsContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsContent record, @Param("example") SmsContentExample example);

    int updateByExample(@Param("record") SmsContent record, @Param("example") SmsContentExample example);

    int updateByPrimaryKeySelective(SmsContent record);

    int updateByPrimaryKey(SmsContent record);
}