package com.jibinfo.finance.controller.demo;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jibinfo.finance.constants.ModulePath;
import com.jibinfo.finance.entity.demo.Demo;
import com.jibinfo.finance.service.demo.DemoService;
import com.jibinfo.finance.service.demo.ProducerService;
import com.jibinfo.framework.activemq.ActivemqSendMessage;
import com.jibinfo.framework.controller.BaseController;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.support.utility.Configuration;
import com.jibinfo.framework.support.utility.DateUtility;



@Controller
@RequestMapping(ModulePath.DEMO)
public class DemoController extends BaseController{
	
	private static final String INDEX = "index";
	
	@Resource
	private DemoService demoService;
	
	@Resource
	private ProducerService producerService;
	
	
	@RequestMapping("/index")
	public String index(){
		return INDEX;
	}
	
	
	@RequestMapping("/avatar")
	@ResponseBody
	public void avatar(HttpServletResponse resp){
		ResponseVo response = demoService.createAvatar();
		super.outputJSON(response, resp);
	}
	
	
	@RequestMapping("/list")
	@ResponseBody
	public void listJson(HttpServletResponse resp){
		/**
		 * 错误写法，禁止在Controller里写逻辑代码
		 */
		//=======================================
		//Demo demo = new Demo();
		//demo.setId(1L);
		//demo.setName("HelloWord");
		//=======================================
		
		
		//正确写法如下：
		Demo demo = demoService.getDemo();
		super.outputJSON(demo, resp);
	}
	

	
	@RequestMapping("/save")
	@ResponseBody
	public void save(Long id,String name,HttpServletResponse resp){
		ResponseVo response = demoService.save(id,name);
		super.outputJSON(response, resp);
	}
	
	/**
	 * 发送特定的目的地的消息
	 * @param resp
	 */
	@RequestMapping("/send")
	@ResponseBody
	public void send(HttpServletResponse resp){
		ActivemqSendMessage sendMessage = null;
		try {
			String demoQueue = Configuration.getProperty("common", "activemq_demo_queue");
			sendMessage = new ActivemqSendMessage("demo_queue", "测试消息类型", DateUtility.format("yyyy-MM-dd HH:mm:ss", new Date()));
			producerService.sendMessage(demoQueue, sendMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.outputJSON(sendMessage, resp);
	}
	
	/**
	 * 发送默认的目的地的消息
	 * @param resp
	 */
	@RequestMapping("/send1")
	@ResponseBody
	public void send1(HttpServletResponse resp){
		ActivemqSendMessage sendMessage = null;
		try {
			sendMessage = new ActivemqSendMessage("demo", "测试消息类型", DateUtility.format("yyyy-MM-dd HH:mm:ss", new Date()));
			producerService.sendMessage(sendMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.outputJSON(sendMessage, resp);
	}
	
	
	
}
