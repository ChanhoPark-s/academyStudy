package com.spring.ex.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.spring.ex.dao.footBallDao;
import com.spring.ex.dto.footBallDto;

public class ListCommand implements pCommand{

	@Override
	public void execute(Model model) {
		
		footBallDao f = footBallDao.getInstance();
		ArrayList<footBallDto> lists =  f.getAllData();
		
		model.addAttribute("lists",lists);
		
	}

}
