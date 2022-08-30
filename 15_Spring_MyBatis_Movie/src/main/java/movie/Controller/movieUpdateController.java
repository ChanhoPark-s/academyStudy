package movie.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import movie.model.MovieBean;
import movie.model.MovieDao;

@Controller
public class movieUpdateController {

	private final String command = "update.mv";
	private String getPage = "/movieUpdateForm";
	private String gotoPage = "redirect:list.mv";
	
	@Autowired
	private MovieDao dao;
	
	@RequestMapping(value= command , method = RequestMethod.GET)
	public String update(@RequestParam(value="pageNumber",required = false)String pageNumber,@RequestParam(value="num",required = false)String num, Model model) {
		
		MovieBean mb = dao.getMovieByNum(num);
		
		model.addAttribute("movie",mb);
		model.addAttribute("pageNumber",pageNumber);
		
		return getPage;
	}
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView updateProc(@ModelAttribute("movie") @Valid MovieBean movie,
			BindingResult result,@RequestParam(value="pageNumber",required = false) String pageNumber) {
		
		
		
		ModelAndView mav=new ModelAndView();
		if(result.hasErrors()) {
			mav.addObject("pageNumber", pageNumber);
			mav.setViewName(getPage);
			return mav;
		}
		dao.updateMovie(movie);
		mav.setViewName(gotoPage+"?pageNumber="+pageNumber);
		
		return mav;
	}

}
