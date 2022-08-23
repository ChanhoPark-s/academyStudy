package album.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	
	public List<AlbumBean> getAlbumList() {
		
		List<AlbumBean> lists = new ArrayList<AlbumBean>();
		lists = sqlSessionTemplate.selectList("album.AlbumBean.GetAllData");
		
		System.out.println("lists.size:"+lists.size());
		return lists;
	}
	
}//AlbumDao