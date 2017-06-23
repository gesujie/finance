package com.jibinfo.finance.service.impl.surveys;


import com.jibinfo.finance.entity.surveys.SurveysQuestions;
import com.jibinfo.finance.entity.surveys.SurveysQuestionsExample;
import com.jibinfo.finance.mapper.surveys.SurveysQuestionsMapper;
import com.jibinfo.finance.service.surveys.SurveysQuestionsService;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by admin on 2017/4/24.
 */

@Service("surveysQuestionsService")
public class SurveysQuestionsServiceImpl extends AbstractBaseServiceEx<SurveysQuestionsExample, SurveysQuestions> implements SurveysQuestionsService {

    @Resource
    private SurveysQuestionsMapper surveysQuestionsMapper;

    @Override
    public BaseMapper<SurveysQuestionsExample, SurveysQuestions> getMapper() {
        return surveysQuestionsMapper;
    }


    
}
