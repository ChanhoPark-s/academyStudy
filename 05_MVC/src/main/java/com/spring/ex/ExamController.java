package com.spring.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("exam")
public class ExamController {
	
	//exam/list ��û => exam/list.jsp�� �̵�
	@RequestMapping("/exam/list")
	public ModelAndView qwe() {
		
		ModelAndView mav = new ModelAndView("/list");
		
		return mav;
	}
	
	/*exam/result ��û => exam/result.jsp �� �̵�
			
			id : kim
			pw : 1234
			ModelAndView
	*/
	@RequestMapping("/result")
	public ModelAndView asd() {
	
		ModelAndView mav = new ModelAndView("exam/result");
		
		mav.addObject("id", "kim");
		mav.addObject("pw",1234);
		
		return mav;
		
	}
			


}