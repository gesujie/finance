package com.jibinfo.finance.service.redis;

import com.jibinfo.finance.entity.redis.Redis;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.framework.controller.ResponseVo;

public interface RedisService {
	PageModel<Redis> getData(Integer pageNumber, Integer pageSize, Redis Redis);

	ResponseVo delete(String keys);

	ResponseVo flushDb();

}
