package com.jibinfo.finance.mapper.system;

import com.jibinfo.finance.entity.system.SystemRoleMenuRef;
import com.jibinfo.finance.entity.system.SystemRoleMenuRefExample;
import com.jibinfo.framework.dao.base.BaseMapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan("systemRoleMenuRefMapper")
public interface SystemRoleMenuRefMapper extends BaseMapper<SystemRoleMenuRefExample, SystemRoleMenuRef>{
    int countByExample(SystemRoleMenuRefExample example);

    int deleteByExample(SystemRoleMenuRefExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemRoleMenuRef record);

    int insertSelective(SystemRoleMenuRef record);

    List<SystemRoleMenuRef> selectByExample(SystemRoleMenuRefExample example);

    SystemRoleMenuRef selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemRoleMenuRef record, @Param("example") SystemRoleMenuRefExample example);

    int updateByExample(@Param("record") SystemRoleMenuRef record, @Param("example") SystemRoleMenuRefExample example);

    int updateByPrimaryKeySelective(SystemRoleMenuRef record);

    int updateByPrimaryKey(SystemRoleMenuRef record);
}