package com.spring.ex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ex.command.ListCommand;
import com.spring.ex.command.deleteCommand;
import com.spring.ex.command.pCommand;
import com.spring.ex.command.updateCommand;
import com.spring.ex.command.updateFormCommand;
import com.spring.ex.command.writeCommand;
import com.spring.ex.dto.footBallDto;

@Controller
public class fController {
	
	pCommand pc =null;
	
	
	@RequestMapping("form")
	public String form(@Valid footBallDto fd,BindingResult result) {
		
		return "form";
	}
	@RequestMapping("list")
	public String list(Model model) {
		
		pc = new ListCommand();
		pc.execute(model);
		
		return "list";
	}
	@RequestMapping("write")
	public String write(@ModelAttribute("fb") @Valid footBallDto fdto,BindingResult result ,HttpServletRequest request,Model model) {
		
		if(result.hasErrors()) {
			System.out.println("누락발생");
			return "form";
			}
		System.out.println("이상없음");
		
		//model.addAttribute("request",request);
		//model.addAttribute("fdto",fdto); modelAttribute해준거 그냥 넘겨짐.
		
		pc = new writeCommand(); 
		pc.execute(model);
		return "redirect:list";
	}
	
	
	@RequestMapping("updateForm")
	public String updateForm(HttpServletRequest request,Model model) {
		
		model.addAttribute("request",request);
		
		pc = new updateFormCommand();  
		pc.execute(model);
		
		return "updateForm";
	}
	@RequestMapping("update")
	public String update(HttpServletRequest request,Model model) {
		
		model.addAttribute("request",request);
		
		pc = new updateCommand(); 
		pc.execute(model);
		
		return "redirect:list";
	}
	@RequestMapping("delete")
	public String delete(HttpServletRequest request,Model model) {
		
		model.addAttribute("request",request);
		
		pc = new deleteCommand(); 
		pc.execute(model);
		
		return "redirect:list";
	}
}
