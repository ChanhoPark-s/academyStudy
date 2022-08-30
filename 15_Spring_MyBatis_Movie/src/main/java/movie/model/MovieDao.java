package movie.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;


@Component("MovieDao")
public class MovieDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private String namespace="movie.MovieBean";
	
	public List<MovieBean> getMovieList( Paging page,Map<String,String> map) {
		List<MovieBean> list = new ArrayList<MovieBean>();
		RowBounds rb = new RowBounds(page.getOffset(),page.getLimit());
		
		
		list = sqlSessionTemplate.selectList(namespace+".getMovieList", map,rb);
		return list;
	}
	
	public int countMovie(Map<String,String> map) { 
		int count = sqlSessionTemplate.selectOne(namespace+".CountMovie", map);
		return count;
	}
	
	public void insertMovie(MovieBean mb) {
		
		int cnt = sqlSessionTemplate.insert(namespace+".InsertMovie",mb);
		System.out.println("삽입 결과 : "+cnt);
	}
	
	public MovieBean getMovieByNum(String num) {
		
		MovieBean mb = sqlSessionTemplate.selectOne(namespace+".getMovieOne",num);
		
		return mb;
	}
	
	public int checkDupl(String title) {
		int cnt= sqlSessionTemplate.selectOne(namespace+".checkTitle",title);
		System.out.println("title 존재 갯수 :"+cnt);
		return cnt;
	}
	public void updateMovie(MovieBean mb) {
		
		int cnt = sqlSessionTemplate.update(namespace+".UpdateMovie",mb);
		System.out.println("업데이트한 결과 : "+cnt );
	}
	public void deleteMovie(String num) {
		
		int cnt = sqlSessionTemplate.delete(namespace+".DeleteMovie",num);
		System.out.println("삭제한 결과 : "+cnt);
	}
}
