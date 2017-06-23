package com.jibinfo.finance.mapper.car;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.jibinfo.finance.entity.car.CarSeries;
import com.jibinfo.finance.entity.car.CarSeriesExample;
import com.jibinfo.framework.dao.base.BaseMapper;

@MapperScan("carSeriesMapper")
public interface CarSeriesMapper extends BaseMapper<CarSeriesExample, CarSeries>{
    int countByExample(CarSeriesExample example);

    int deleteByExample(CarSeriesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CarSeries record);

    int insertSelective(CarSeries record);

    List<CarSeries> selectByExample(CarSeriesExample example);

    CarSeries selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CarSeries record, @Param("example") CarSeriesExample example);

    int updateByExample(@Param("record") CarSeries record, @Param("example") CarSeriesExample example);

    int updateByPrimaryKeySelective(CarSeries record);

    int updateByPrimaryKey(CarSeries record);
}