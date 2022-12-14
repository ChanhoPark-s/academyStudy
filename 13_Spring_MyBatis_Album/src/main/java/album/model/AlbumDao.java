package album.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

// AlbumDao myAlbumDao = new AlbumDao()
@Component("myAlbumDao") //객체 생성
public class AlbumDao {
	
	private final String namespace = "album.AlbumBean";
	
	@Autowired // 객체 주입 root-context 객체를 집어넣어라.
	SqlSessionTemplate sqlSessionTemplate; //오라클 접속해라 정보도 있음.
	// root-context.xml에서 객체 생성했음.
	
	public int insertAlbum(AlbumBean album) {
		
		int cnt= -1;
		cnt = sqlSessionTemplate.insert("album.AlbumBean.InsertAlbum",album); // xml 파일
		// root-context 에 mapperLocations 위치를 찾아서 album.AlbumBean.InsertAlbum 있는 지 찾는다.
		//실행끝나면 돌아옴 insert메서드는 정수를 리턴함
		
		System.out.println("cnt : +"+cnt);
		return cnt;
	}
	
	public List<AlbumBean> getAlbumList(Paging pageInfo , Map<String,String> map) {
		
		List<AlbumBean> lists = new ArrayList<AlbumBean>();
		
		System.out.println("offset : "+pageInfo.getOffset());//건너뛸 레코드갯수
		System.out.println("limit : "+pageInfo.getLimit()); // limit : pageSize 한페이지에 보여줄 레코드갯수
		
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		
		lists = sqlSessionTemplate.selectList("album.AlbumBean.GetAllData",map,rowBounds);
		//rowBounds 보내면 현재페이지에 보여줄 레코드갯수만 가져옴
		
		System.out.println("lists.size:"+lists.size());
		
		return lists;
	}
	
	public AlbumBean getAlbum(int num) {
		
		AlbumBean album = sqlSessionTemplate.selectOne(namespace+".GetAlbum",num );
		
		
		return album;
	}
	public int deleteAlbum(int num) {
		
	int cnt = sqlSessionTemplate.delete(namespace+".DeleteAlbum",num);
	
	System.out.println("삭제 결과 :"+cnt);
	
	return cnt;
	}
	
	public void updateAlbum(AlbumBean ab) {
		
		int cnt = sqlSessionTemplate.update(namespace+".UpdateAlbum",ab);
		System.out.println("Update cnt :"+cnt);
	}

	public int getTotalCount(Map<String, String> map) {
		
		int totalCount = sqlSessionTemplate.selectOne(namespace+".GetTotalCount",map);
		
		return totalCount;
	}
	
}//AlbumDao
