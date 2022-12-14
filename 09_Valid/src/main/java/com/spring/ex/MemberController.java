package com.spring.ex;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@RequestMapping("form")
	public String form() {
		
		return "form";
	}
	@RequestMapping("input")
	public String input(@ModelAttribute("mb") @Valid MemberBean mb, // 커맨드 먼저 쓰고 , BindingResult 써야함
			BindingResult result) {//커맨드객체를 ~주입 setter통한 주입 
		//id,pw
		if(result.hasErrors()) { // Boolean 리턴함. 에러있으면 true 정보를 result에 담음
			
			return "form";
		}
		else 
			return "result";
		
	}
}

