package com.jibinfo.finance.mapper.car;

import com.jibinfo.finance.entity.car.CarModel;
import com.jibinfo.finance.entity.car.CarModelExample;
import com.jibinfo.framework.dao.base.BaseMapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan("carModelMapper")
public interface CarModelMapper extends BaseMapper<CarModelExample, CarModel>{
    int countByExample(CarModelExample example);

    int deleteByExample(CarModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CarModel record);

    int insertSelective(CarModel record);

    List<CarModel> selectByExample(CarModelExample example);

    CarModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CarModel record, @Param("example") CarModelExample example);

    int updateByExample(@Param("record") CarModel record, @Param("example") CarModelExample example);

    int updateByPrimaryKeySelective(CarModel record);

    int updateByPrimaryKey(CarModel record);
}