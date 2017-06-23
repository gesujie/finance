package com.jibinfo.finance.mapper.sms;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.jibinfo.finance.entity.sms.SmsCaptcha;
import com.jibinfo.finance.entity.sms.SmsCaptchaExample;
import com.jibinfo.framework.dao.base.BaseMapper;

@MapperScan("smsCaptchaMapper")
public interface SmsCaptchaMapper extends BaseMapper<SmsCaptchaExample, SmsCaptcha>{
    int countByExample(SmsCaptchaExample example);

    int deleteByExample(SmsCaptchaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsCaptcha record);

    int insertSelective(SmsCaptcha record);

    List<SmsCaptcha> selectByExample(SmsCaptchaExample example);

    SmsCaptcha selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsCaptcha record, @Param("example") SmsCaptchaExample example);

    int updateByExample(@Param("record") SmsCaptcha record, @Param("example") SmsCaptchaExample example);

    int updateByPrimaryKeySelective(SmsCaptcha record);

    int updateByPrimaryKey(SmsCaptcha record);
}