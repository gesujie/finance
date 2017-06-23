package com.jibinfo.finance.controller.redis;

import com.jibinfo.finance.constants.ModuleAdminPath;
import com.jibinfo.finance.entity.redis.Redis;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.redis.RedisService;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(ModuleAdminPath.REDIS_ADMIN + "/")
public class RedisAdminController extends BaseController {
	@Resource
	private RedisService redisService;

	private static final String LIST = "redis/list";
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request) {
		return LIST;
	}
	
	/**
	 * 分页列表
	 * 
	 */
	@RequestMapping("/getData")
	@ResponseBody
	public PageModel<Redis> getData(HttpServletRequest request,
			Integer pageNumber, Integer pageSize) {
		Redis financeRedis = super.getRequestParam(request,
				Redis.class);
		return redisService.getData(pageNumber, pageSize, financeRedis);
	}
	
	/**
	 * 删除/批量删除
	 * 
	 */
	@RequestMapping("/delete")
	public void delete(HttpServletResponse response, String keys) {
		ResponseVo result = redisService.delete(keys);
		outputJSON(result, response);
	}


	/**
	 * 清空所有
	 */
	@RequestMapping("/flushDb")
	public void flushDb(HttpServletResponse response) {
		ResponseVo result = redisService.flushDb();
		outputJSON(result, response);
	}

}
