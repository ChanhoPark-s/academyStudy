package com.spring.ex.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.dao.PDao;
import com.spring.ex.dto.PDto;

public class PUpdateFormCommand implements PCommand{

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request =  (HttpServletRequest)map.get("request");
		String num = request.getParameter("num");
		
		PDao dao = PDao.getInstance();
		PDto p =  dao.getDataByNum(num);
		
		model.addAttribute("p",p);
		
	}
	
}
