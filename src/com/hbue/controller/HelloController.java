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
	
	@ModelAttribute//这里先把类上面的SessionAttributes注解取消，否则报错，后面有原因
	public void getUser(@RequestParam(value="id",required=false) Integer id, 
		Map<String, Object> map){
	    System.out.println("modelAttribute method");
	    if(id != null){//模拟  从数据库中获取对象(id不为空)
	        User curUser = new User(1, "Tom", "123456", "tom@atguigu.com", 12);
	        System.out.println("从数据库中获取一个对象: " + curUser);

	        map.put("user", curUser);
	    }
	}
	//不加上面的ModelAttribute，此处就是new新对象；加上后，该类的每个链接调用前，都会访问前面的ModelAttribute方法。
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User tmpUser){
	    System.out.println("修改: " + tmpUser);
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
	    //添加模型数据到 ModelAndView 中.
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