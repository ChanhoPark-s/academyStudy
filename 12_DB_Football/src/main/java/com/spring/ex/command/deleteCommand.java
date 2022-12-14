package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.dao.footBallDao;

public class deleteCommand implements pCommand{

	@Override
	public void execute(Model model) {
		
		
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request =  (HttpServletRequest)map.get("request");
		String num = request.getParameter("num");
		
		footBallDao fdao = footBallDao.getInstance();
		fdao.deleteByNum(num);
		
	}

	
}
