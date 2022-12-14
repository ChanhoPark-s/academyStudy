package com.spring.ex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MusicController {

	@RequestMapping("myform")
	public String myform() {
		return "music/form";
	}
	
	@RequestMapping("input1")
	public String input1() {
		return "music/result1";
	}
	
	
	@RequestMapping("input2")
	public String input2(@RequestParam("title") String title,
						 @RequestParam("singer")String singer,
						 @RequestParam("price") int price, Model model) {
	
		MusicBean mb = new MusicBean();
		mb.setTitle(title);
		mb.setSinger(singer);
		mb.setPrice(price);
		
		model.addAttribute("mb",mb);
		model.addAttribute("s","sdasd");
		
		
		return "music/result2";
	}
	@RequestMapping("input3")
	public String input3(MusicBean mb) {
		
		
		return "music/result3";
	}
	
	
	@RequestMapping("input4")
	public String input4(@ModelAttribute("mb") MusicBean mb) {
		
		
		return "music/result4";
	}
	
	
	
	/*
	form요청
	
	input1요청=>result1.jsp에서 결과 출력
		request
		
	input2요청
		@RequestParam
		bean으로 만들어서 
		result2.jsp에서 bean 출력
		
	input3요청
		command 객체
		result3.jsp에서 command 객체 출력
	
	input4요청
		command 객체 별칭설정
		result4.jsp에서 별칭 출력
*/

}
