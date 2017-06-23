/**
 * Created by admin on 2017/3/23.
 * 管理后台的Controller
 * 规范：
 * 1:所有的管理后台(AdminWeb)的Controller都必须带上 "Admin" 字样 ,如：DemoAdminController,区别网站(Web)的Controller,DemoController
 * 2:@Controller,@RequestMapping 里的路径必须带上 "/",如：@Controller("/demo/admin"),@RequestMapping("/list")
 * 3:@Controller 里的路径禁止出现大写，正确写法：@Controller("/demo/admin"),错误写法：@Controller("/demoAdmin")
 * 4:如果是返回的JSON格式，必须加上@ResponseBody的Annotation
 * 5:所有的业务逻辑必须放在Service层，禁止在Controller出现业务代码，如果出现一律重构代码！
 * 
 */
package com.jibinfo.finance.controller;

