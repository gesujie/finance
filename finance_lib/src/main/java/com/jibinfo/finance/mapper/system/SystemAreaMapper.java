package com.jibinfo.finance.mapper.system;

import com.jibinfo.finance.entity.system.SystemArea;
import com.jibinfo.finance.entity.system.SystemAreaExample;
import com.jibinfo.framework.dao.base.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan("systemAreaMapper")
public interface SystemAreaMapper extends BaseMapper<SystemAreaExample,SystemArea>{
    int countByExample(SystemAreaExample example);

    int deleteByExample(SystemAreaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemArea record);

    int insertSelective(SystemArea record);

    List<SystemArea> selectByExample(SystemAreaExample example);

    SystemArea selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemArea record, @Param("example") SystemAreaExample example);

    int updateByExample(@Param("record") SystemArea record, @Param("example") SystemAreaExample example);

    int updateByPrimaryKeySelective(SystemArea record);

    int updateByPrimaryKey(SystemArea record);

	Long findMaxId();
}