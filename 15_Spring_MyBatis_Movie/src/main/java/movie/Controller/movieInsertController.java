package movie.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import movie.model.MovieBean;
import movie.model.MovieDao;

@Controller
public class movieInsertController {

	
	private final String command = "insert.mv";
	private String getPage = "/movieInsertForm";
	private String gotoPage = "redirect:list.mv";
	
	@Autowired
	private MovieDao dao;
	
	@RequestMapping(value= command , method = RequestMethod.GET)
	public String insert() {
		return getPage;
	}
	
	@RequestMapping(value = command , method = RequestMethod.POST)
	public String insert(@ModelAttribute("m") @Valid MovieBean mb,BindingResult result) {
		
		if(result.hasErrors()) {
			
			return getPage;
		}
		
		dao.insertMovie(mb);
		return gotoPage;
		
		
	}
}
