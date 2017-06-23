package com.jibinfo.finance.mapper.system;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.jibinfo.finance.entity.system.SystemSensitive;
import com.jibinfo.finance.entity.system.SystemSensitiveExample;
import com.jibinfo.framework.dao.base.BaseMapper;

@MapperScan("systemSensitiveMapper")
public interface SystemSensitiveMapper extends BaseMapper<SystemSensitiveExample,SystemSensitive>{
    int countByExample(SystemSensitiveExample example);

    int deleteByExample(SystemSensitiveExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemSensitive record);

    int insertSelective(SystemSensitive record);

    List<SystemSensitive> selectByExample(SystemSensitiveExample example);

    SystemSensitive selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemSensitive record, @Param("example") SystemSensitiveExample example);

    int updateByExample(@Param("record") SystemSensitive record, @Param("example") SystemSensitiveExample example);

    int updateByPrimaryKeySelective(SystemSensitive record);

    int updateByPrimaryKey(SystemSensitive record);
}