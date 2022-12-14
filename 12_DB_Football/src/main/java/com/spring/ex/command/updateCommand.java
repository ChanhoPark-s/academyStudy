package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.dao.footBallDao;
import com.spring.ex.dto.footBallDto;

public class updateCommand implements pCommand{

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request =  (HttpServletRequest)map.get("request");
		String num = request.getParameter("num");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String win = request.getParameter("win");
		
		String[] round16 = request.getParameterValues("round16");
		String round="";
		for(int i=0;i<round16.length;i++) {
			round+= round16[i]+" ";
		}
		
		footBallDao fdao = footBallDao.getInstance();
		fdao.updateData(num,id,pw,win,round); 
		
	}
	
}
