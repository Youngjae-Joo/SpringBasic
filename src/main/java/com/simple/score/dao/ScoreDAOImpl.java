package com.simple.score.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simple.command.ScoreVO;

@Repository("scoreDAO")
public class ScoreDAOImpl implements ScoreDAO{


	/*
	//데이터베이스
	ArrayList<ScoreVO> list=new ArrayList<>();
	
	
	
	@Override
	public void regist(ScoreVO vo) {
		
		//연결....
		//connect
		//Class.forName("드라이버클래스");
		
		
		//System.out.println("DAO영역:"+vo.toString());
		list.add(vo); //insert역할
		System.out.println(list.toString());
	}



	@Override
	public ArrayList<ScoreVO> getList() {
		//데이터조회...
		return list;
	}



	@Override
	public void delete(int num) {
		//삭제작업
		list.remove(num);
		
	}
	*/
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void regist(ScoreVO vo) {
		
		String sql="insert into score(name, kor, eng) values(?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getKor());
			pstmt.setString(3, vo.getEng());
			
			pstmt.executeUpdate(); //insert, update, delete
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn !=null) conn.close();
				if(pstmt !=null) pstmt.close();
			} catch (Exception e2) {
			}
		}
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		
		ArrayList<ScoreVO> list=new ArrayList<>();
		
		String sql="select * from score order by num desc";
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;   
		
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			//ORM->Object Relational Mapping 객체와 데이터에서 나온 것들을 붙여주는 작업
			while(rs.next()) {
				ScoreVO vo=new ScoreVO();
				//자동형변환된다
				vo.setNum(rs.getInt("num")); //column명. 대소문자를 구별한다면 하나하나 중요해진다.
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getString("kor"));
				vo.setEng(rs.getString("eng"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn !=null) conn.close();
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			} catch (Exception e2) {
			}
		
		}
		
		return list;
	}

	@Override
	public void delete(int num) {
		//삭제기능-num는 key가 아니라 index가 넘어옵니다. (화면에서 key를 넘기도록 변경)
		//delete기능 구현.
		
		String sql="delete from score where num=?";
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1,num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn !=null) conn.close();
				if(pstmt !=null) pstmt.close();
			} catch (Exception e2) {
			}
		}
		
	}

	@Override
	public void modify(int num, String name, String kor, String eng) {
		String sql="update score set name=?, kor=?, eng=? where num=?";
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, name );
			pstmt.setString(2, kor);
			pstmt.setString(3, eng);
			pstmt.setInt(4,num );
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn !=null) conn.close();
				if(pstmt !=null) pstmt.close();
			} catch (Exception e2) {
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
