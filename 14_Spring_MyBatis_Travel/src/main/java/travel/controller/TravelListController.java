package travel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import travel.model.TravelBean;
import travel.model.TravelDao;
import utility.Paging;

@Controller
public class TravelListController {
	
	//travelList.jsp로 이동
	private final String command = "/list.tv";
	private String getPage= "/travelList";
	
	@Autowired
	private TravelDao traveldao;
	
	@RequestMapping(command)
	public String list(@RequestParam(value="whatColumn",required=false) String whatColumn,
						@RequestParam(value="keyword",required=false) String keyword,
						@RequestParam(value="pageNumber",required = false) String pageNumber,
						Model model,HttpServletRequest request) {
		System.out.println("whatColumn :"+whatColumn);
		System.out.println("keyword :"+keyword);
		
		Map<String,String>map = new HashMap<String,String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		int count = traveldao.countTravel(map);
		String url = request.getContextPath()+command;
		
		Paging page = new Paging(pageNumber, "3", count, url, whatColumn, keyword, null);
		
		
		List<TravelBean> lists =  traveldao.getAllData(map,page);
		
		model.addAttribute("count",count);
		model.addAttribute("page",page);
		model.addAttribute("lists",lists);
		return getPage;
	}
	
}
