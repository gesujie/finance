package com.jibinfo.finance.mapper.quartz;

import com.jibinfo.finance.entity.quartz.Quartz;
import com.jibinfo.finance.entity.quartz.QuartzExample;
import com.jibinfo.framework.dao.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan("quartzMapper")
public interface QuartzMapper extends BaseMapper<QuartzExample, Quartz> {
    int countByExample(QuartzExample example);

    int deleteByExample(QuartzExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Quartz record);

    int insertSelective(Quartz record);

    List<Quartz> selectByExample(QuartzExample example);

    Quartz selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Quartz record, @Param("example") QuartzExample example);

    int updateByExample(@Param("record") Quartz record, @Param("example") QuartzExample example);

    int updateByPrimaryKeySelective(Quartz record);

    int updateByPrimaryKey(Quartz record);
}