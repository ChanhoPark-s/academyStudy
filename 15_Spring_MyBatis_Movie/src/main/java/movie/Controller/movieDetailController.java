package movie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import movie.model.MovieBean;
import movie.model.MovieDao;

@Controller
public class movieDetailController {

	private final String command = "Detail.mv";
	private String gotoPage = "/Detail";
	
	@Autowired
	private MovieDao dao;
	
	@RequestMapping(command)
	public String detail(@RequestParam("pageNumber") String pageNumber,
						@RequestParam("num") String num,
							Model model) {
		
		MovieBean mb = dao.getMovieByNum(num);
		
		model.addAttribute("mb",mb);
		model.addAttribute("pageNumber",pageNumber);
		return gotoPage;
	}
}
