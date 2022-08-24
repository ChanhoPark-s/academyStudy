package album.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;
import utility.Paging;

@Controller
public class AlbumListcontroller {
	private final String command = "list.ab";
	private String getPage = "/AlbumList";
	
	@Autowired
	private AlbumDao albumDao;
	
	/*
	list.ab 요청하는곳
	
		1. start.jsp 에서 목록보기  아무것도 넘어오는값이 없음.
		2. 목록보기에서 검색할 때 넘어오는 값 2가지
	*/
	
	@RequestMapping(command)					// 기본값은 true ,false면 꼭 넘어오지 않아도된다.
	public ModelAndView doAction(@RequestParam(value="whatColumn",required = false) String whatColumn,
								@RequestParam(value="keyword", required = false) String keyword,
								@RequestParam(value="pageNumber",required = false) String pageNumber,
								HttpServletRequest request) {
		//select * from albums singer like '%a';
		
		
		System.out.println("whatColumn : "+whatColumn);
		System.out.println("keyword :"+keyword);
		System.out.println("pageNumber : "+pageNumber);
		//String whatColumn = request.getparameter("whatColumn");
		
		
		
		Map<String,String> map = new HashMap<String, String>();
		
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		// 페이지설정 	페이지설정 		페이지설정
		int totalCount = albumDao.getTotalCount(map);
		System.out.println("totalCount : "+totalCount);
		
		String url = request.getContextPath()+"/"+command;

		Paging pageInfo = new Paging(pageNumber,null,totalCount,url,whatColumn,keyword,null);
		
		ModelAndView mav = new ModelAndView(getPage);
		
		
		List<AlbumBean>lists = new ArrayList<AlbumBean>();
		lists = albumDao.getAlbumList(pageInfo,map);
		
		mav.addObject("lists",lists);
		mav.addObject("pageInfo",pageInfo);
		mav.addObject("totalCount",totalCount);
		
		
		return mav;
	}
}
