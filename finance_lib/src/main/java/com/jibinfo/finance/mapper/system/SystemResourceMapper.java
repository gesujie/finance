package com.jibinfo.finance.mapper.system;

import com.jibinfo.finance.entity.system.SystemResource;
import com.jibinfo.finance.entity.system.SystemResourceExample;
import com.jibinfo.framework.dao.base.BaseMapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan("systemResourceMapper")
public interface SystemResourceMapper extends BaseMapper<SystemResourceExample, SystemResource>{
    int countByExample(SystemResourceExample example);

    int deleteByExample(SystemResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemResource record);

    int insertSelective(SystemResource record);

    List<SystemResource> selectByExample(SystemResourceExample example);

    SystemResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemResource record, @Param("example") SystemResourceExample example);

    int updateByExample(@Param("record") SystemResource record, @Param("example") SystemResourceExample example);

    int updateByPrimaryKeySelective(SystemResource record);

    int updateByPrimaryKey(SystemResource record);
}