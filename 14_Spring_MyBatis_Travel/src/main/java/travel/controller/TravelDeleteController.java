package travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import travel.model.TravelDao;

@Controller
public class TravelDeleteController {
	
	
	private final String command = "delete.tv";
	private String gotoPage = "redirect:list.tv";
	
	@Autowired
	private TravelDao traveldao;
	
	
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String detail(@RequestParam("num") String num,
						@RequestParam("pageNumber") String pageNumber,
						Model model) {
		
		traveldao.deleteByNum(num); 
		
		model.addAttribute("pageNumber",pageNumber);
		return gotoPage;
	}
}
