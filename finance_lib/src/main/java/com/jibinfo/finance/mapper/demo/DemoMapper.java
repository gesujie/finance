package com.jibinfo.finance.mapper.demo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.finance.entity.demo.Demo;
import com.jibinfo.finance.entity.demo.DemoExample;

@MapperScan("demoMapper")
public interface DemoMapper extends BaseMapper<DemoExample, Demo> {
	int countByExample(DemoExample example);

	int deleteByExample(DemoExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Demo record);

	int insertSelective(Demo record);

	List<Demo> selectByExample(DemoExample example);

	Demo selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Demo record,
			@Param("example") DemoExample example);

	int updateByExample(@Param("record") Demo record,
			@Param("example") DemoExample example);

	int updateByPrimaryKeySelective(Demo record);

	int updateByPrimaryKey(Demo record);

	int count(DemoExample example);
}