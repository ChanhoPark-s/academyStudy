package com.spring.ex;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	
	@RequestMapping("form")
	public String form() {
		return "redirect/form";
	}
	
	@RequestMapping("input")
	public String input(HttpServletRequest request, Model model) {
		System.out.println("input 요청처리");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		model.addAttribute("name2",name);
		model.addAttribute("age2",age);
		model.addAttribute("addr2","서울");
		
		
		return "redirect:/last";
	}
	
	@RequestMapping("last")
	public String last() {
		System.out.println("input 요청처리");
		
		return "redirect/last";
	}
}
