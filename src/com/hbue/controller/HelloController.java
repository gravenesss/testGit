package com.hbue.controller;

import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hbue.pojo.User;


@SessionAttributes({"user"})
@Controller
@RequestMapping("/springmvc")
public class HelloController {
	private static final String SUCCESS = "success";
	
	@ModelAttribute//�����Ȱ��������SessionAttributesע��ȡ�������򱨴�������ԭ��
	public void getUser(@RequestParam(value="id",required=false) Integer id, 
		Map<String, Object> map){
	    System.out.println("modelAttribute method");
	    if(id != null){//ģ��  �����ݿ��л�ȡ����(id��Ϊ��)
	        User curUser = new User(1, "Tom", "123456", "tom@atguigu.com", 12);
	        System.out.println("�����ݿ��л�ȡһ������: " + curUser);

	        map.put("user", curUser);
	    }
	}
	//���������ModelAttribute���˴�����new�¶��󣻼��Ϻ󣬸����ÿ�����ӵ���ǰ���������ǰ���ModelAttribute������
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User tmpUser){
	    System.out.println("�޸�: " + tmpUser);
	    return SUCCESS;
	}
	
	
	@RequestMapping("/testSessionAttributes")
	public String testSessionAttributes(Map<String, Object> map){
	    User user = new User("Tom", "123456", "tom@atguigu.com", 15);
	    map.put("user", user);
	    map.put("school", "atguigu");
	    return SUCCESS;
	}
	
	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map){
	    System.out.println(map.getClass().getName()); 
	    map.put("names", Arrays.asList("Tom", "Jerry", "Mike"));
	    return SUCCESS;
	}
	
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView(){
	    String viewName = SUCCESS;
	    ModelAndView modelAndView = new ModelAndView(viewName);
	    //���ģ�����ݵ� ModelAndView ��.
	    modelAndView.addObject("time", new Date());

	    return modelAndView;
	}
	
	
	@RequestMapping("/testServletAPI")
	public void testServletAPI(HttpServletRequest request, Writer out) throws Exception {
		System.out.println("ServletAPI:"+request+","+out);
		out.write("hello SpringMVC!");
	}
	
	@RequestMapping("/testPojo")
	public String testPojo(User user) {
		System.out.println("testPojo: " + user);
		return SUCCESS;
	}
	
	
	@RequestMapping("testRequestParam")
	public String testRequestParam(@RequestParam("username")String un,
			@RequestParam(value="age",required = false,defaultValue="0")Integer age) {
		System.out.println(un+":"+age);
		return SUCCESS;
	}
	
	
	@RequestMapping(value = "test2", params = {"!username","age!=10"}, headers = {"Accept-Language=en-US,zh;q=0.8"})
	public String testParamsAndHeaders() {
		System.out.println("testParamsAndHeaders");
		return SUCCESS;
	}
	
	@RequestMapping("/hello")
	public String Hello(String[] args) {
		System.out.println("Hello Frist");
		return SUCCESS;
	}
}