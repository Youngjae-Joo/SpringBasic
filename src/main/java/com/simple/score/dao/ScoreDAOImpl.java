package com.simple.score.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.simple.command.ScoreVO;

@Repository("scoreDAO")
public class ScoreDAOImpl implements ScoreDAO{
	
	//데이터베이스
	ArrayList<ScoreVO> list=new ArrayList<>();
	
	
	
	@Override
	public void regist(ScoreVO vo) {
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
}
