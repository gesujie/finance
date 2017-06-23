package com.jibinfo.finance.service.impl.surveys;


import com.jibinfo.finance.entity.surveys.SurveysMaterials;
import com.jibinfo.finance.entity.surveys.SurveysMaterialsExample;
import com.jibinfo.finance.mapper.surveys.SurveysMaterialsMapper;
import com.jibinfo.finance.service.surveys.SurveysMaterialsService;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by admin on 2017/4/24.
 */
@Service("surveysMaterialsService")
public class SurveysMaterialsServiceImpl extends AbstractBaseServiceEx<SurveysMaterialsExample, SurveysMaterials> implements SurveysMaterialsService {

    @Resource
    private SurveysMaterialsMapper surveysMaterialsMapper;

    @Override
    public BaseMapper<SurveysMaterialsExample, SurveysMaterials> getMapper() {
        return surveysMaterialsMapper;
    }


    
}
