package com.jibinfo.finance.service.surveys;

import com.jibinfo.finance.dto.SurverysDataDTO;
import com.jibinfo.finance.entity.surveys.SurverysData;
import com.jibinfo.finance.entity.surveys.SurverysDataExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.model.SurverysResult;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

import java.util.List;

/**
 * Created by admin on 2017/4/24.
 */
public interface SurverysDataService extends BaseService<SurverysDataExample, SurverysData> {

    PageModel<SurverysDataDTO> getData(Integer pageNumber, Integer pageSize, SurverysData surverysData);

    ResponseVo saveOrUpdate(SurverysData requestParam);

    String getCode();

    List<SurverysData> getDataType();

    /**
     * 获取答题完成的代金券额度
     * @param jsonData  答题数据,json格式
     * @return
     */
    SurverysResult getSurverysResult(String jsonData);

}
