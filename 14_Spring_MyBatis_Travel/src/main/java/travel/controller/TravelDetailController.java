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
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelDetailController {
	
	private final String command = "detail.tv";
	private String gotoPage = "/TravelDetailView";
	
	@Autowired
	private TravelDao traveldao;
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam(value="num", required=true) String num,
								@RequestParam(value="pageNumber",required=false) String pageNumber) {
		
		ModelAndView mav = new ModelAndView(gotoPage);
		
		TravelBean tb =  traveldao.getDataByNum(num);
		
		mav.addObject("tb",tb);
		mav.addObject("pageNumber",pageNumber);
		
		return mav;
	}
	
}
