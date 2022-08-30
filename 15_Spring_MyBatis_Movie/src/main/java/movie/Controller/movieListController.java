package movie.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import movie.model.MovieBean;
import movie.model.MovieDao;
import utility.Paging;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class movieListController {

	private final String command="list.mv";
	private String getPage="/MovieList";
	
	@Autowired
	MovieDao movieDao;
	
	@RequestMapping(command)
	public ModelAndView list(@RequestParam(value="whatColumn",required = false) String whatColumn,
			@RequestParam(value="keyword",required = false) String keyword,
			@RequestParam(value="pageNumber",required = false) String pageNumber,
			HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		
		Map<String, String> map=new HashMap<String, String>();//검색어 담기위한 map
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		int totalCount = movieDao.countMovie(map);
		
		String url=request.getContextPath()+"/"+command;
		
		Paging pageInfo = new Paging(pageNumber, null, totalCount, url, whatColumn, keyword, null);
		
		List<MovieBean> lists= new ArrayList<MovieBean>();		
		
		lists=movieDao.getMovieList(pageInfo,map);  
		 
		mav.addObject("lists", lists);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName(getPage);
		return mav;
	}

	}

