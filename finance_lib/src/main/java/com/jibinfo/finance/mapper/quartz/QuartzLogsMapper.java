package com.jibinfo.finance.mapper.quartz;

import com.jibinfo.finance.entity.quartz.QuartzLogs;
import com.jibinfo.finance.entity.quartz.QuartzLogsExample;
import com.jibinfo.framework.dao.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan("quartzLogsMapper")
public interface QuartzLogsMapper extends BaseMapper<QuartzLogsExample, QuartzLogs> {
    int countByExample(QuartzLogsExample example);

    int deleteByExample(QuartzLogsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(QuartzLogs record);

    int insertSelective(QuartzLogs record);

    List<QuartzLogs> selectByExample(QuartzLogsExample example);

    QuartzLogs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") QuartzLogs record, @Param("example") QuartzLogsExample example);

    int updateByExample(@Param("record") QuartzLogs record, @Param("example") QuartzLogsExample example);

    int updateByPrimaryKeySelective(QuartzLogs record);

    int updateByPrimaryKey(QuartzLogs record);
}