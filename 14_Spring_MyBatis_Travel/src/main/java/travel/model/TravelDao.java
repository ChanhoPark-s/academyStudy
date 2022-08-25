package travel.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myTravelDao") //객체 생성
public class TravelDao {
	
	private final String namespace = "travel.TravelBean";

	@Autowired // 객체 주입 root-context 객체를 집어넣어라.
	SqlSessionTemplate sqlSessionTemplate; //오라클 접속해라 정보도 있음.
	
//====================================================================================
public List<TravelBean> getAllData(Map<String,String>map,Paging page){
		
		RowBounds rowBounds = 
				new RowBounds(page.getOffset(),page.getLimit());

		List<TravelBean>lists = sqlSessionTemplate.selectList(namespace+".GetAllData",map,rowBounds);
		
		return lists;
	}
	
//====================================================================================
	public void insertTravel(TravelBean tb) {
		
		int cnt = sqlSessionTemplate.insert(namespace+".insertTravel",tb);
		System.out.println("insert 결과 : "+cnt);
	}
	
//====================================================================================
	public int countTravel(Map<String,String>map){
		

		int count = sqlSessionTemplate.selectOne(namespace+".GetCount",map);
		System.out.println("가져온 레코드 갯수 : "+count);
		return count;
	}
	

}//TravelDao
