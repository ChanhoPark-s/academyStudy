package com.spring.ex.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.dao.footBallDao;
import com.spring.ex.dto.footBallDto;

public class updateFormCommand implements pCommand{

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request =  (HttpServletRequest)map.get("request");
		String num = request.getParameter("num");
		
		footBallDao fdao = footBallDao.getInstance();
		footBallDto f =  fdao.getDataByNum(num);
		
		model.addAttribute("f",f);
	}
	
}
