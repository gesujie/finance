package com.jibinfo.finance.mapper.email;

import com.jibinfo.finance.entity.email.EmailContent;
import com.jibinfo.finance.entity.email.EmailContentExample;
import com.jibinfo.framework.dao.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan("emailContentMapper")
public interface EmailContentMapper extends BaseMapper<EmailContentExample,EmailContent>{
    int countByExample(EmailContentExample example);

    int deleteByExample(EmailContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EmailContent record);

    int insertSelective(EmailContent record);

    List<EmailContent> selectByExample(EmailContentExample example);

    EmailContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EmailContent record, @Param("example") EmailContentExample example);

    int updateByExample(@Param("record") EmailContent record, @Param("example") EmailContentExample example);

    int updateByPrimaryKeySelective(EmailContent record);

    int updateByPrimaryKey(EmailContent record);
}