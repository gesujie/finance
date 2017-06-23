package com.jibinfo.finance.service.system;

import com.jibinfo.finance.entity.system.SystemDic;
import com.jibinfo.finance.entity.system.SystemDicExample;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.service.BaseService;

public interface SystemDicService extends BaseService<SystemDicExample, SystemDic> {

    ResponseVo getTreeJson();

    ResponseVo delete(Long id);

    String findMaxCode();

    ResponseVo saveOrUpdate(SystemDic model);
}
