package movie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import movie.model.MovieDao;

@Controller
public class movieDeleteController {

	
	private final String command = "delete.mv";
	private String gotoPage = "redirect:list.mv";
	
	@Autowired
	private MovieDao dao;
	
	@RequestMapping(value= command , method = RequestMethod.GET)
	public String insert(@RequestParam("num")String num , @RequestParam("pageNumber")String pageNumber,Model model) {
		
		dao.deleteMovie(num);
		
		model.addAttribute("pageNumber", pageNumber);
		return gotoPage;
	}
}
