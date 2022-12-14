package com.spring.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		//request.setAttribute("serverTime",formattedDate);
		return "home";
	}
	
	// http://localhost:8080/ex/member/view
	// method 안적으면 get이랑 post 방식 모두 처리
	@RequestMapping(value = "/member/view")
	public String view() {
		return "member/memberView";
		// WEB-INF/views/member/memberView.jsp
	}
	
	//  /member/result 요청 => member/memberResult.jsp 로 이동
	
	@RequestMapping(value="/member/result")
	public String view1(Model model,HttpServletRequest request) {
		
		//model.addAttribute("id","kim"); // id에 kim을 넣어서 속성설정
		request.setAttribute("id","kim");
		
		return "member/memberResult";
	}
	
	//member/list 요청 => member/memberList.jsp로 이동
	
	@RequestMapping("/member/list")
	public ModelAndView asd() {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name","태연");
		mav.addObject("age",30);
		mav.setViewName("member/memberList");
		
		return mav;
	}
}
