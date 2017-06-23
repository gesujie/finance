package com.jibinfo.finance.mapper.system;

import com.jibinfo.finance.entity.system.SystemDicDetail;
import com.jibinfo.finance.entity.system.SystemDicDetailExample;
import com.jibinfo.framework.dao.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan("systemDicDetailMapper")
public interface SystemDicDetailMapper extends BaseMapper<SystemDicDetailExample, SystemDicDetail> {
    int countByExample(SystemDicDetailExample example);

    int deleteByExample(SystemDicDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemDicDetail record);

    int insertSelective(SystemDicDetail record);

    List<SystemDicDetail> selectByExample(SystemDicDetailExample example);

    SystemDicDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemDicDetail record, @Param("example") SystemDicDetailExample example);

    int updateByExample(@Param("record") SystemDicDetail record, @Param("example") SystemDicDetailExample example);

    int updateByPrimaryKeySelective(SystemDicDetail record);

    int updateByPrimaryKey(SystemDicDetail record);

}