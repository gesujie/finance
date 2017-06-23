package com.jibinfo.finance.mapper.surveys;

import com.jibinfo.finance.entity.surveys.SurveysMaterials;
import com.jibinfo.finance.entity.surveys.SurveysMaterialsExample;
import com.jibinfo.framework.dao.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;


@MapperScan("surveysMaterialsMapper")
public interface SurveysMaterialsMapper extends BaseMapper<SurveysMaterialsExample, SurveysMaterials> {
    int countByExample(SurveysMaterialsExample example);

    int deleteByExample(SurveysMaterialsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SurveysMaterials record);

    int insertSelective(SurveysMaterials record);

    List<SurveysMaterials> selectByExample(SurveysMaterialsExample example);

    SurveysMaterials selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SurveysMaterials record, @Param("example") SurveysMaterialsExample example);

    int updateByExample(@Param("record") SurveysMaterials record, @Param("example") SurveysMaterialsExample example);

    int updateByPrimaryKeySelective(SurveysMaterials record);

    int updateByPrimaryKey(SurveysMaterials record);
}