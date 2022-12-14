package com.spring.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spring.ex.dto.footBallDto;

public class footBallDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";
	Connection  conn = null;
	PreparedStatement  ps =null;
	ResultSet  rs = null;

	private static footBallDao instance;

	private footBallDao(){
	    try {
	       Class.forName(driver);
	       conn = DriverManager.getConnection(url, id, pw);
	       System.out.println("연결 성공");
	    } catch (ClassNotFoundException | SQLException e) {
	       System.out.println("연결 실패");
	    }
	 }// 

	public static footBallDao getInstance() {
		if(instance==null) {
			instance = new footBallDao();
		}
		return instance;
	}
//==================================================================================================
	
	public ArrayList<footBallDto> getAllData(){
		
		ArrayList<footBallDto> lists = new ArrayList<footBallDto>();
		
		String sql = "select * from football order by num";
		
		try {
			ps = conn.prepareStatement(sql);
		
			rs= ps.executeQuery();
			
			while(rs.next()) {
				footBallDto f = new footBallDto();
				
				f.setNum(rs.getInt("num"));
				f.setId(rs.getString("id"));
				f.setPw(rs.getString("pw"));
				f.setWin(rs.getString("win"));
				f.setRound16(rs.getString("round16"));
				
				lists.add(f);
			}
			
		} catch (SQLException e) {
			System.out.println("getAllData sql error");
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.out.println("close error");
			}
		}
		
		return lists;
	}
	
//==================================================================================================
	public void writeData(footBallDto f) {
		
		String sql = "insert into football values(fb_seq.nextval,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, f.getId());
			ps.setString(2, f.getPw());
			ps.setString(3, f.getWin());
			ps.setString(4, f.getRound16());
		
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("writeData sql error");
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.out.println("close error");
			}
		}

	}//writeData
//==================================================================================================

	public footBallDto getDataByNum(String num) {
		
		footBallDto f = null;
		
		String sql = "select * from football where num="+num;
		
		try {
			ps = conn.prepareStatement(sql);
		
			rs= ps.executeQuery();
			
			if(rs.next()) {
				f = new footBallDto();
				
				f.setNum(rs.getInt("num"));
				f.setId(rs.getString("id"));
				f.setPw(rs.getString("pw"));
				f.setWin(rs.getString("win"));
				f.setRound16(rs.getString("round16"));
				
			}
			
		} catch (SQLException e) {
			System.out.println("getDataByNum sql error");
		} finally {
			try {
				if(rs !=null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.out.println("close error");
			}
		}
		return f;
	}
	
	//==================================================================================================
	public void updateData(String num,String id,String pw, String win, String round16) {
		
		System.out.println("num :"+num);
		System.out.println("id :"+id);
		System.out.println("pw :"+pw);
		System.out.println("win :"+win);
		System.out.println("round16 :"+round16);
		
		String sql = "update football set id=?,pw=?,win=?,round16=? where num=?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, win);
			ps.setString(4, round16);
			ps.setString(5, num);
		
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("updateData sql error");
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.out.println("close error");
			}
		}
	}
	
	
	//==================================================================================================
	
	public void deleteByNum(String num) {
		
		String sql = "delete football where num="+num;

		try {
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("deleteByNum sql error");
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.out.println("close error");
			}
		}
	}
	
	//==================================================================================================
}
