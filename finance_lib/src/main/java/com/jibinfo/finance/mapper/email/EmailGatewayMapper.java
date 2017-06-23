package com.jibinfo.finance.mapper.email;

import com.jibinfo.finance.entity.email.EmailGateway;
import com.jibinfo.finance.entity.email.EmailGatewayExample;
import com.jibinfo.framework.dao.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan("emailGatewayMapper")
public interface EmailGatewayMapper extends BaseMapper<EmailGatewayExample,EmailGateway> {
    int countByExample(EmailGatewayExample example);

    int deleteByExample(EmailGatewayExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EmailGateway record);

    int insertSelective(EmailGateway record);

    List<EmailGateway> selectByExample(EmailGatewayExample example);

    EmailGateway selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EmailGateway record, @Param("example") EmailGatewayExample example);

    int updateByExample(@Param("record") EmailGateway record, @Param("example") EmailGatewayExample example);

    int updateByPrimaryKeySelective(EmailGateway record);

    int updateByPrimaryKey(EmailGateway record);
}