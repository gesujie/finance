package com.jibinfo.finance.service.system;

import java.util.List;

import com.jibinfo.finance.entity.system.SystemDicDetail;
import com.jibinfo.finance.entity.system.SystemDicDetailExample;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface SystemDicDetailService extends BaseService<SystemDicDetailExample, SystemDicDetail> {

    PageModel<SystemDicDetail> getData(Integer pageNo, Integer rows, SystemDicDetail model);


    ResponseVo delete(String ids);

    ResponseVo saveOrUpdate(SystemDicDetail model);
    
    SystemDicDetail findByCode(String code);

	List<SystemDicDetail> getGatewaySourceDicDetail(Long dicId);
}
