package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.dao.PDao;
import com.spring.ex.dto.PDto;

public class PUpdateCommand implements PCommand{

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request =  (HttpServletRequest)map.get("request");
		String num = request.getParameter("num");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		PDao dao = PDao.getInstance();
		dao.updateData(num,id,name,age); 
	}

}
