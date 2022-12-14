package com.spring.ex.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ex.command.PCommand;
import com.spring.ex.command.PDeleteCommand;
import com.spring.ex.command.PListCommand;
import com.spring.ex.command.PUpdateCommand;
import com.spring.ex.command.PUpdateFormCommand;
import com.spring.ex.command.PWriteCommand;
import com.spring.ex.dto.PDto;

@Controller
public class PController {
	
	PCommand command = null;
	
	@RequestMapping("form")
	public String form() {
		return "write_view";
	}
	
	@RequestMapping("write")
	public String write(HttpServletRequest request,Model model) {
		
		model.addAttribute("req",request);//모델속성설정 근데 왜 모델로 속성? request response?
		command = new PWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("list")
	public String list(Model model) {
		
		command = new PListCommand(); 
		command.execute(model);//모델에 담긴건 없지만 execute가 model을 받아야하기때문
		
		return "list";
	}
	
	@RequestMapping("updateForm")
	public String updateForm(HttpServletRequest request,Model model) {
		
		model.addAttribute("request",request);
		command = new PUpdateFormCommand();
		command.execute(model);//모델에 담긴건 없지만 execute가 model을 받아야하기때문
		
		return "updateForm";
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request,Model model) {
		
		model.addAttribute("request",request);
		command = new PUpdateCommand(); 
		command.execute(model);//모델에 담긴건 없지만 execute가 model을 받아야하기때문
		
		return "redirect:list";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
		
		model.addAttribute("request",request);
		command = new PDeleteCommand();  
		command.execute(model);//모델에 담긴건 없지만 execute가 model을 받아야하기때문
		return "redirect:list";
	}
	
	
	
}
