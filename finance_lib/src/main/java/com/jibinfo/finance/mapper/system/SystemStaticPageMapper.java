package com.jibinfo.finance.mapper.system;

import com.jibinfo.finance.entity.system.SystemStaticPage;
import com.jibinfo.finance.entity.system.SystemStaticPageExample;
import com.jibinfo.framework.dao.base.BaseMapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan("systemStaticPageMapper")
public interface SystemStaticPageMapper extends BaseMapper<SystemStaticPageExample, SystemStaticPage> {
    int countByExample(SystemStaticPageExample example);

    int deleteByExample(SystemStaticPageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemStaticPage record);

    int insertSelective(SystemStaticPage record);

    List<SystemStaticPage> selectByExample(SystemStaticPageExample example);

    SystemStaticPage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemStaticPage record, @Param("example") SystemStaticPageExample example);

    int updateByExample(@Param("record") SystemStaticPage record, @Param("example") SystemStaticPageExample example);

    int updateByPrimaryKeySelective(SystemStaticPage record);

    int updateByPrimaryKey(SystemStaticPage record);
}