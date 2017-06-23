package com.jibinfo.finance.mapper.system;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.jibinfo.finance.entity.system.SystemCity;
import com.jibinfo.finance.entity.system.SystemCityExample;
import com.jibinfo.framework.dao.base.BaseMapper;

@MapperScan("systemCityMapper")
public interface SystemCityMapper extends BaseMapper<SystemCityExample,SystemCity>{
    int countByExample(SystemCityExample example);

    int deleteByExample(SystemCityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemCity record);

    int insertSelective(SystemCity record);

    List<SystemCity> selectByExample(SystemCityExample example);

    SystemCity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemCity record, @Param("example") SystemCityExample example);

    int updateByExample(@Param("record") SystemCity record, @Param("example") SystemCityExample example);

    int updateByPrimaryKeySelective(SystemCity record);

    int updateByPrimaryKey(SystemCity record);

	Long findMaxId();
}