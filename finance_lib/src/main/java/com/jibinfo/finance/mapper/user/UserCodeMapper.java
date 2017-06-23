package com.jibinfo.finance.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.jibinfo.finance.entity.user.UserCode;
import com.jibinfo.finance.entity.user.UserCodeExample;
import com.jibinfo.framework.dao.base.BaseMapper;

@MapperScan("userCodeMapper")
public interface UserCodeMapper extends BaseMapper<UserCodeExample,UserCode>{
    int countByExample(UserCodeExample example);

    int deleteByExample(UserCodeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserCode record);

    int insertSelective(UserCode record);

    List<UserCode> selectByExample(UserCodeExample example);

    UserCode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserCode record, @Param("example") UserCodeExample example);

    int updateByExample(@Param("record") UserCode record, @Param("example") UserCodeExample example);

    int updateByPrimaryKeySelective(UserCode record);

    int updateByPrimaryKey(UserCode record);
}