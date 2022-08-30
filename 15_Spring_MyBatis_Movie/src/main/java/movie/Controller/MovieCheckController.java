package movie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import movie.model.MovieDao;

@Controller
public class MovieCheckController {

	@Autowired MovieDao movieDao;
	
	private final String command = "title_check_proc.mv";
	//private String getPage = "insert.mv";
	
	@RequestMapping(command)
	@ResponseBody
	public String check(@RequestParam("inputtitle") String title) {
		
		int cnt = -1;
		cnt = movieDao.checkDupl(title); //yes:사용가능, no:사용불가
		
		if(cnt == 0 ) 
			return "YES"; // ResponseBody 쓰면 글자 자체를 넘김
		
		else
			return "NO";
	
		
	}
}
