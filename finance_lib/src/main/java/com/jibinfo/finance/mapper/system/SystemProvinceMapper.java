package com.jibinfo.finance.mapper.system;


import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.jibinfo.finance.entity.system.SystemProvince;
import com.jibinfo.finance.entity.system.SystemProvinceExample;
import com.jibinfo.framework.dao.base.BaseMapper;

@MapperScan("systemProvinceMapper")
public interface SystemProvinceMapper  extends BaseMapper<SystemProvinceExample,SystemProvince>{
    int countByExample(SystemProvinceExample example);

    int deleteByExample(SystemProvinceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemProvince record);

    int insertSelective(SystemProvince record);

    List<SystemProvince> selectByExample(SystemProvinceExample example);

    SystemProvince selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemProvince record, @Param("example") SystemProvinceExample example);

    int updateByExample(@Param("record") SystemProvince record, @Param("example") SystemProvinceExample example);

    int updateByPrimaryKeySelective(SystemProvince record);

    int updateByPrimaryKey(SystemProvince record);
    
    Long findMaxId();
}