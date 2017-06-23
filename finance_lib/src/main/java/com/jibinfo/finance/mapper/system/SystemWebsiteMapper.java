package com.jibinfo.finance.mapper.system;

import com.jibinfo.finance.entity.system.SystemWebsite;
import com.jibinfo.finance.entity.system.SystemWebsiteExample;
import com.jibinfo.framework.dao.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan("systemWebsiteMapper")
public interface SystemWebsiteMapper extends BaseMapper<SystemWebsiteExample, SystemWebsite> {
    int countByExample(SystemWebsiteExample example);

    int deleteByExample(SystemWebsiteExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemWebsite record);

    int insertSelective(SystemWebsite record);

    List<SystemWebsite> selectByExample(SystemWebsiteExample example);

    SystemWebsite selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemWebsite record, @Param("example") SystemWebsiteExample example);

    int updateByExample(@Param("record") SystemWebsite record, @Param("example") SystemWebsiteExample example);

    int updateByPrimaryKeySelective(SystemWebsite record);

    int updateByPrimaryKey(SystemWebsite record);
}