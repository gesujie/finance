package com.jibinfo.finance.mapper.system;

import com.jibinfo.finance.entity.system.SystemUserRoleRef;
import com.jibinfo.finance.entity.system.SystemUserRoleRefExample;
import com.jibinfo.framework.dao.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan("systemUserRoleRefMapper")
public interface SystemUserRoleRefMapper extends BaseMapper<SystemUserRoleRefExample, SystemUserRoleRef> {
    int countByExample(SystemUserRoleRefExample example);

    int deleteByExample(SystemUserRoleRefExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemUserRoleRef record);

    int insertSelective(SystemUserRoleRef record);

    List<SystemUserRoleRef> selectByExample(SystemUserRoleRefExample example);

    SystemUserRoleRef selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemUserRoleRef record, @Param("example") SystemUserRoleRefExample example);

    int updateByExample(@Param("record") SystemUserRoleRef record, @Param("example") SystemUserRoleRefExample example);

    int updateByPrimaryKeySelective(SystemUserRoleRef record);

    int updateByPrimaryKey(SystemUserRoleRef record);
}