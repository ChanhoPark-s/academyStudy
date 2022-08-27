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
}
