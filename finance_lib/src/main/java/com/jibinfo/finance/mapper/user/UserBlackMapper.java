package com.jibinfo.finance.mapper.user;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.jibinfo.finance.entity.user.UserBlack;
import com.jibinfo.finance.entity.user.UserBlackExample;
import com.jibinfo.framework.dao.base.BaseMapper;

@MapperScan("userBlackMapper")
public interface UserBlackMapper extends BaseMapper<UserBlackExample, UserBlack>{
    int countByExample(UserBlackExample example);

    int deleteByExample(UserBlackExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserBlack record);

    int insertSelective(UserBlack record);

    List<UserBlack> selectByExample(UserBlackExample example);

    UserBlack selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserBlack record, @Param("example") UserBlackExample example);

    int updateByExample(@Param("record") UserBlack record, @Param("example") UserBlackExample example);

    int updateByPrimaryKeySelective(UserBlack record);

    int updateByPrimaryKey(UserBlack record);
}