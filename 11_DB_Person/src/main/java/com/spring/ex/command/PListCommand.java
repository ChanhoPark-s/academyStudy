package com.spring.ex.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.spring.ex.dao.PDao;
import com.spring.ex.dto.PDto;

public class PListCommand implements PCommand{

	@Override
	public void execute(Model model) {
		
		PDao dao = PDao.getInstance();
		ArrayList<PDto> lists =  dao.getAllData();
		model.addAttribute("lists",lists);
	}

}
