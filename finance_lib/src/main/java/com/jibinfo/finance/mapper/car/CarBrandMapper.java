package com.jibinfo.finance.mapper.car;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.jibinfo.finance.entity.car.CarBrand;
import com.jibinfo.finance.entity.car.CarBrandExample;
import com.jibinfo.framework.dao.base.BaseMapper;

@MapperScan("carBrandMapper")
public interface CarBrandMapper extends BaseMapper<CarBrandExample, CarBrand> {
	int countByExample(CarBrandExample example);

	int deleteByExample(CarBrandExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CarBrand record);

	int insertSelective(CarBrand record);

	List<CarBrand> selectByExample(CarBrandExample example);

	CarBrand selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") CarBrand record,
			@Param("example") CarBrandExample example);

	int updateByExample(@Param("record") CarBrand record,
			@Param("example") CarBrandExample example);

	int updateByPrimaryKeySelective(CarBrand record);

	int updateByPrimaryKey(CarBrand record);
}