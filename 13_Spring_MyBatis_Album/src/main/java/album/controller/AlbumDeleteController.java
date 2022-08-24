package album.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import album.model.AlbumDao;

@Controller
public class AlbumDeleteController {

	
	private final String command = "delete.ab";
	private String gotoPage = "redirect:list.ab";
	
	@Autowired
	private AlbumDao albumdao;
	
	@RequestMapping(command)
	public String delete(@RequestParam("num") int num) {
		
		albumdao.deleteAlbum(num);
		
		return gotoPage;
	}
}
