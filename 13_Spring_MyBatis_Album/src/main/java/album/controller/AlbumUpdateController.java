package album.controller;

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

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumUpdateController {

	private final String command = "update.ab";
	private String getPage = "/AlbumUpdateForm";
	private String gotoPage = "redirect:list.ab";
	
	@Autowired
	private AlbumDao albumdao;
	
	
	@RequestMapping(command)
	public String updateForm(@RequestParam("num") int num,
							@RequestParam(value="pageNumber",required = false) String pageNumber,
							Model model) {
		
		AlbumBean  album = albumdao.getAlbum(num);
		
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("album",album);
		
		return getPage;
	}
	
	@RequestMapping(value=command,method = RequestMethod.POST)
	public ModelAndView update(
			@RequestParam(value="pageNumber",required = false) String pageNumber,
			@ModelAttribute("album") @Valid AlbumBean ab,BindingResult result) {
		
	
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			
			mav.addObject("pageNumber"+pageNumber); // 받아주는 updateForm이 바로 Table 안에 ${} 작성하니 addObject로 속성설정해서 보내야함.
			mav.setViewName(getPage);
			return mav;
			//return getPage;
		}
		
		albumdao.updateAlbum(ab);
		
		mav.setViewName(gotoPage+"?pageNumber="+pageNumber); // 받아주는 list.ab 에서 RequestParam 형태로 받아주니 parameter 형태로 넘겨야한다.
		return mav;
		//return gotoPage;
	}
}
