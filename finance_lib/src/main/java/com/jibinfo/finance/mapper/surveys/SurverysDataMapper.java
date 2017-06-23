package com.jibinfo.finance.mapper.surveys;

import com.jibinfo.finance.entity.surveys.SurverysData;
import com.jibinfo.finance.entity.surveys.SurverysDataExample;
import com.jibinfo.framework.dao.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan("surverysDataMapper")
public interface SurverysDataMapper extends BaseMapper<SurverysDataExample, SurverysData> {
    int countByExample(SurverysDataExample example);

    int deleteByExample(SurverysDataExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SurverysData record);

    int insertSelective(SurverysData record);

    List<SurverysData> selectByExample(SurverysDataExample example);

    SurverysData selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SurverysData record, @Param("example") SurverysDataExample example);

    int updateByExample(@Param("record") SurverysData record, @Param("example") SurverysDataExample example);

    int updateByPrimaryKeySelective(SurverysData record);

    int updateByPrimaryKey(SurverysData record);

    long findMaxId();
}