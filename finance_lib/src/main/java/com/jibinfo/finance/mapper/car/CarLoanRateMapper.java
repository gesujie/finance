package com.jibinfo.finance.mapper.car;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jibinfo.finance.entity.car.CarLoanRate;
import com.jibinfo.finance.entity.car.CarLoanRateExample;
import com.jibinfo.framework.dao.base.BaseMapper;

public interface CarLoanRateMapper extends BaseMapper<CarLoanRateExample,CarLoanRate>{
    int countByExample(CarLoanRateExample example);

    int deleteByExample(CarLoanRateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CarLoanRate record);

    int insertSelective(CarLoanRate record);

    List<CarLoanRate> selectByExample(CarLoanRateExample example);

    CarLoanRate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CarLoanRate record, @Param("example") CarLoanRateExample example);

    int updateByExample(@Param("record") CarLoanRate record, @Param("example") CarLoanRateExample example);

    int updateByPrimaryKeySelective(CarLoanRate record);

    int updateByPrimaryKey(CarLoanRate record);
}