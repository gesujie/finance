package com.jibinfo.finance.mapper.surveys;

import com.jibinfo.finance.entity.surveys.SurveysQuestions;
import com.jibinfo.finance.entity.surveys.SurveysQuestionsExample;
import com.jibinfo.framework.dao.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan("surveysQuestionsMapper")
public interface SurveysQuestionsMapper extends BaseMapper<SurveysQuestionsExample, SurveysQuestions> {
    int countByExample(SurveysQuestionsExample example);

    int deleteByExample(SurveysQuestionsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SurveysQuestions record);

    int insertSelective(SurveysQuestions record);

    List<SurveysQuestions> selectByExample(SurveysQuestionsExample example);

    SurveysQuestions selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SurveysQuestions record, @Param("example") SurveysQuestionsExample example);

    int updateByExample(@Param("record") SurveysQuestions record, @Param("example") SurveysQuestionsExample example);

    int updateByPrimaryKeySelective(SurveysQuestions record);

    int updateByPrimaryKey(SurveysQuestions record);
}