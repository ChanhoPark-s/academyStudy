package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.dao.PDao;

public class PWriteCommand implements PCommand{

	@Override
	public void execute(Model model) {
		//model.addAttribute("req",request);
		
		Map<String,Object>map = model.asMap();//모델을 맵으로 바꿔서 String 에는 req가 들어가고 Object에는 request가 들어감.
		
		HttpServletRequest request =(HttpServletRequest)map.get("req");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		PDao dao = PDao.getInstance();
		dao.write(id,name,age);
		
		
	}
	
	
}
