package com.spring.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("exam")
public class ExamController {
	
	//exam/list 요청 => exam/list.jsp로 이동
	@RequestMapping("/exam/list")
	public ModelAndView qwe() {
		
		ModelAndView mav = new ModelAndView("/list");
		
		return mav;
	}
	
	/*exam/result 요청 => exam/result.jsp 로 이동
			
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
