package com.jibinfo.finance.service.impl.demo;

import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jibinfo.finance.entity.demo.Demo;
import com.jibinfo.finance.entity.demo.DemoExample;
import com.jibinfo.finance.mapper.demo.DemoMapper;
import com.jibinfo.finance.service.demo.DemoService;
import com.jibinfo.finance.utils.FinanceAvatarUtils;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.service.AbstractBaseServiceEx;


@Service("demoService")
public class DemoServiceImpl extends AbstractBaseServiceEx<DemoExample, Demo> implements DemoService {
	
	@Resource
	private DemoMapper demoMapper;
	
	@Override
	public BaseMapper<DemoExample, Demo> getMapper() {
		return demoMapper;
	}

	@Override
	public Demo getDemo() {
		Demo demo = new Demo();
		demo.setId(1L);
		demo.setName("HelloWord");
		return demo;
	}

	@Override
	public ResponseVo save(Long id, String name) {
		ResponseVo response = new ResponseVo();
		response.setCode(ResponseVo.SUCCESS);
		response.setMsg("成功!");
		try {
			Demo record = new Demo();
			record.setId(id);
			record.setName(name);
			demoMapper.insertSelective(record);
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(ResponseVo.FAILURE);
			response.setMsg("异常!");
		}
		return response;
	}

	@Override
	public ResponseVo createAvatar() {
		ResponseVo responseVo = new ResponseVo();
		responseVo.setCode(ResponseVo.SUCCESS);
		responseVo.setMsg("成功!");
		try {
			String domain = "http://img.finance.cn";
			String pictureUrl = FinanceAvatarUtils.createAvatar("abcdefghi".charAt(new Random().nextInt(9))+"");
			responseVo.setBody(domain + pictureUrl);
		} catch (Exception e) {
			e.printStackTrace();
			responseVo.setCode(ResponseVo.FAILURE);
			responseVo.setMsg("异常!");
		}
		return responseVo;
	}

}
