package travel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelUpdateController {
	
	private final String command = "update.tv";
	private String getPage = "/TravelUpdateForm";
	private String gotoPage = "redirect:list.tv";
	
	
	@Autowired
	private TravelDao traveldao;
	
	
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String detail(@RequestParam("num") String num,
						@RequestParam("pageNumber") String pageNumber,
						Model model) {
		
		TravelBean tb = traveldao.getDataByNum(num);
		
		model.addAttribute("t",tb);
		model.addAttribute("pageNumber",pageNumber);
		
		return getPage;
	}
	
	
	
	@RequestMapping(value=command,method = RequestMethod.POST)
	public String detail(@ModelAttribute("t") @Valid TravelBean tb , BindingResult result,
						@RequestParam("pageNumber") String pageNumber,
						Model model) {
		System.out.println("num : "+tb.getNum());
		System.out.println("name : "+tb.getName());
		System.out.println("style : "+tb.getStyle());
		System.out.println("getAge : "+tb.getAge());
		System.out.println("getArea : "+tb.getArea());
		System.out.println("getPrice : "+tb.getPrice());
		
		
		if(result.hasErrors()) {
			model.addAttribute("pageNumber",pageNumber);
			return getPage;
		}
		
		traveldao.updateData(tb);
		
		model.addAttribute("pageNumber",pageNumber);
		return gotoPage;
	}
}
	
