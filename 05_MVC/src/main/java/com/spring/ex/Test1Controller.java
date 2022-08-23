package com.spring.ex;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test1Controller {

	
	@RequestMapping("form")
	public String asd() {
		return "test1/test1Form";
	}
	
	
	// test1/test1Form.jsp -> submit -> test1/join1 -> test1/result
	@RequestMapping("test1/join1")
	public String join1() {
		
		return "test1/result";
	}
}
