package com.spring.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spring.ex.dto.PDto;

public class PDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String id = "jspid";
    String pw = "jsppw";
    Connection conn = null;
    PreparedStatement ps =null;
    ResultSet rs = null;
    
	private static PDao instance;
	
	public static PDao getInstance() {
		if(instance==null) {
			instance = new PDao();
		}
		return instance;
	}
	
	private PDao(){
        try {
           Class.forName(driver);
           conn = DriverManager.getConnection(url, id, pw);
           System.out.println("연결 성공");
        } catch (ClassNotFoundException | SQLException e) {
           System.out.println("연결 실패");
        }
     }//


	
	//===========================================================================
	
	public void write(String id,String name, String age) {
		
		String sql = "insert into person values(person_seq.nextval,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
		
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, age);
			
			ps.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println("write sql error");
		}finally {
			try {
				if(ps!=null)
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
	}//write
	
//============================================================================================
	
	public ArrayList<PDto> getAllData() {

		ArrayList<PDto> lists = new ArrayList<PDto>();

		String sql = "select * from person order by num";
		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			
			while(rs.next()) {
				PDto pdto = new PDto();
				
				pdto.setNum(rs.getInt("num"));
				pdto.setId(rs.getString("id"));
				pdto.setName(rs.getString("name"));
				pdto.setAge(rs.getInt("age"));
				
				lists.add(pdto);
			}

		} catch (SQLException e) {
			System.out.println("getAllData sql error");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return lists;
	}//getAllData
//============================================================================================
	public PDto getDataByNum(String num) {
		
		PDto p = null;
		
		String sql = "select * from person where num=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, num);

			rs = ps.executeQuery();
			
			if(rs.next()) {
				p = new PDto();
				
				p.setNum(rs.getInt("num"));
				p.setId(rs.getString("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				
			}

		} catch (SQLException e) {
			System.out.println("getDataByNum sql error");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
	
//============================================================================================
	public void updateData(String num,String id,String name,String age) {
		
		String sql = "update person set id=?,name=?,age=? where num=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, age);
			ps.setString(4, num);

			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("updateData sql error");
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}//updateData
	
	
//============================================================================================

	public void deleteByNum(String num) {
		
		String sql = "delete person where num=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, num);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("deleteByNum sql error");
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
//============================================================================================
//============================================================================================

}
