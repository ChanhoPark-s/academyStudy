package album.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumInsertController {
	
	private final String command = "/insert.ab";
	// final 쓰는 이유 : 변하지 않게해야 함 안하면 에러뜸
	private String getPage = "/AlbumInsertForm";
	private String gotoPage = "redirect:list.ab";
	
	@Autowired
	private AlbumDao albumDao; // AlbumDao 가져옴
	
	
	@RequestMapping(value=command,method= RequestMethod.GET)//get방식 요청
	public String doActionfGet() {
		return getPage;
		// /WEB-INF/album/AlbumInsertForm.jsp
	}//doget
	
	
	
	@RequestMapping(value=command,method= RequestMethod.POST)//get방식 요청
	public ModelAndView doActionPost(@ModelAttribute("album") @Valid AlbumBean album,BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			
			mav.setViewName(getPage);
			return mav;
		}
		
		//AlbumDao dao = new AlbumDao(); Conponent로 만듬 위에서 가져오기만 하면 됨.
		int cnt = albumDao.insertAlbum(album);
		System.out.println("Album Insert cnt :"+cnt);
		
		mav.setViewName(gotoPage);
		return mav;
		
	}
}
