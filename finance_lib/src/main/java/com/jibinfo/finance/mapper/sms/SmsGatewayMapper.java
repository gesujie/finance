package com.jibinfo.finance.mapper.sms;

import com.jibinfo.finance.entity.sms.SmsGateway;
import com.jibinfo.finance.entity.sms.SmsGatewayExample;
import com.jibinfo.framework.dao.base.BaseMapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan("smsGatewayMapper")
public interface SmsGatewayMapper extends BaseMapper<SmsGatewayExample, SmsGateway>{
    int countByExample(SmsGatewayExample example);

    int deleteByExample(SmsGatewayExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsGateway record);

    int insertSelective(SmsGateway record);

    List<SmsGateway> selectByExample(SmsGatewayExample example);

    SmsGateway selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsGateway record, @Param("example") SmsGatewayExample example);

    int updateByExample(@Param("record") SmsGateway record, @Param("example") SmsGatewayExample example);

	int updateByPrimaryKeySelective(SmsGateway record);

	int updateByPrimaryKey(SmsGateway record);
}