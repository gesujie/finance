package com.jibinfo.finance.mapper.system;

import com.jibinfo.finance.entity.system.SystemMenu;
import com.jibinfo.finance.entity.system.SystemMenuExample;
import com.jibinfo.framework.dao.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan("systemMenuMapper")
public interface SystemMenuMapper extends BaseMapper<SystemMenuExample, SystemMenu>{
    int countByExample(SystemMenuExample example);

    int deleteByExample(SystemMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemMenu record);

    int insertSelective(SystemMenu record);

    List<SystemMenu> selectByExample(SystemMenuExample example);

    SystemMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemMenu record, @Param("example") SystemMenuExample example);

    int updateByExample(@Param("record") SystemMenu record, @Param("example") SystemMenuExample example);

    int updateByPrimaryKeySelective(SystemMenu record);

    int updateByPrimaryKey(SystemMenu record);

    List<Long> findAllPidByMids(List<Long> menuIdList);
}