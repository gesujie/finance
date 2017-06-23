package com.jibinfo.finance.mapper.system;

import com.jibinfo.finance.entity.system.SystemChannel;
import com.jibinfo.finance.entity.system.SystemChannelExample;
import com.jibinfo.framework.dao.base.BaseMapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
@MapperScan("systemChannelMapper")
public interface SystemChannelMapper extends BaseMapper<SystemChannelExample,SystemChannel>{
    int countByExample(SystemChannelExample example);

    int deleteByExample(SystemChannelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemChannel record);

    int insertSelective(SystemChannel record);

    List<SystemChannel> selectByExample(SystemChannelExample example);

    SystemChannel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemChannel record, @Param("example") SystemChannelExample example);

    int updateByExample(@Param("record") SystemChannel record, @Param("example") SystemChannelExample example);

    int updateByPrimaryKeySelective(SystemChannel record);

    int updateByPrimaryKey(SystemChannel record);
}