package travel.controller;

import java.lang.reflect.Method;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelInsertController {
	
	private final String command = "/insert.tv";
	private String getPage = "/travelInsertForm";
	private String gotoPage="redirect:list.tv";
	
	@Autowired
	private TravelDao traveldao;
	
	//Travel_start.jsp에서 요청
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String insert() {
		return getPage;
	}
	
	//travelInsertForm.jsp에서 submit 요청
	@RequestMapping(value=command, method =RequestMethod.POST ) 
	public String insert(@ModelAttribute("t") @Valid TravelBean tb,BindingResult result) {
		
		if(result.hasErrors()) {
			return getPage;
		}
		
		traveldao.insertTravel(tb);
		return gotoPage;
		
	}
}
