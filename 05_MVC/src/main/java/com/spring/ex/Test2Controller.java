package com.spring.ex;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test2Controller {

	//http://localhost:8080/ex/form2
	@RequestMapping("test2/form2")
	public String asd() {
		return "test2/test2Form";
	}
	
	
	// test1/test1Form.jsp -> submit -> test1/join1 -> test1/result
	
	//http://localhost:8080/ex/test2/join2?name=123
	@RequestMapping("test2/join2")
	public String join1() {
		
		return "test2/result";
	}
}
