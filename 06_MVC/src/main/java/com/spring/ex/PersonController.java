package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {
	
	
	//http://localhost:8080/ex/person/input?name=kim&age=20
	// => person/result.jsp
	@RequestMapping("person/input")
	public String asd(Model model ,HttpServletRequest request) {
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("name : "+name);
		System.out.println("age : "+age);
		
		model.addAttribute("name2",name+"��!");
		
		
		return "person/result1";
	}
	//person/input ��û => person/result1.jsp�� �̵�
	
	
	
	//  http://localhost:8080/ex/person/form
	@RequestMapping("form")
	public String form() {
		
		return "person/form";
		
	}
	@RequestMapping("person/join1")
	//String a = request.getparameter("id");
	public String join1(@RequestParam("id") String id,
						@RequestParam("pw") String pw,
						@RequestParam("name") String irum,
						@RequestParam("addr") String addr,Model model) {
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(irum);
		System.out.println(addr);
		
		PersonBean pb = new PersonBean();
		pb.setId(id);
		pb.setPw(pw);
		pb.setName(irum);
		pb.setAddr(addr);
		
		model.addAttribute("pb",pb);
		
		return "person/personView1";
	}
	
	
	@RequestMapping("person/join2")
	public String join2(PersonBean pb) { // 내부적으로 PersonBean 객체가 만들어지고 parameter받아서 setter메서드로 넘겨서 실행됨.
		//command 객체
		//PersonBean pb : 객체 생성이 되어 get parameter 받아지고 setter메서드로 넘겨주고 속성설정까지 됨.
		//model.addAttribute("personBean",pb);
		System.out.println(pb.getId());
		
		return "person/personView2";
	}
	
	@RequestMapping("person/join3")
	public String join3(@ModelAttribute("abcd") PersonBean pb) {
		
		System.out.println(pb.getId());
		
		return "person/personView3";
	}
	
}
