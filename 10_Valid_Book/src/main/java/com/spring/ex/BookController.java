package com.spring.ex;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
	
	@RequestMapping("form")
	public String form() {
		return "form";
	}
	
	@RequestMapping("inputProc")
	public String inputProc(@ModelAttribute("bb") @Valid BookBean bb , BindingResult result) {
		
		if(result.hasErrors()) {
			return "form";
		}
			return "result";
	}
	
}
