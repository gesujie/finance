package com.jibinfo.finance.mapper.system;

import com.jibinfo.finance.entity.system.SystemDic;
import com.jibinfo.finance.entity.system.SystemDicExample;
import com.jibinfo.framework.dao.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan("systemDicMapper")
public interface SystemDicMapper  extends BaseMapper<SystemDicExample, SystemDic> {
    int countByExample(SystemDicExample example);

    int deleteByExample(SystemDicExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemDic record);

    int insertSelective(SystemDic record);

    List<SystemDic> selectByExample(SystemDicExample example);

    SystemDic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemDic record, @Param("example") SystemDicExample example);

    int updateByExample(@Param("record") SystemDic record, @Param("example") SystemDicExample example);

    int updateByPrimaryKeySelective(SystemDic record);

    int updateByPrimaryKey(SystemDic record);

    Long findMaxId();
}