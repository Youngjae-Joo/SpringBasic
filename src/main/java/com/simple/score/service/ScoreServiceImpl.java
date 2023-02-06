package com.simple.score.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.score.dao.ScoreDAO;
import com.simple.score.mapper.ScoreMapper;

//@Controller
//@Repository
//@Component
@Service("service") //빈의 이름명시
public class ScoreServiceImpl implements ScoreService {

//	@Autowired
//	@Qualifier("scoreDAO")
//	private ScoreDAO scoreDAO;
//	
//	
//	public void regist(ScoreVO vo) {
//		scoreDAO.regist(vo);
//	}
//
//	public ArrayList<ScoreVO> getList() {
//		//ArrayList<ScoreVO> list=scoreDAO.getList();
//		
//		return scoreDAO.getList();
//	}
//
//	@Override
//	public void delete(int num) {
//		scoreDAO.delete(num);
//	}
//
//	@Override
//	public void modify(int num, String name, String kor, String eng) {
//		scoreDAO.modify(num,name,kor,eng);		
//	}
	
	@Autowired
	ScoreMapper scoreMapper;

	@Override
	public void regist(ScoreVO vo) {
		
		scoreMapper.regist(vo);
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		//ArrayList<ScoreVO> list=scoreMapper.getList();
		return scoreMapper.getList();
	}

	@Override
	public void delete(int num) {
		scoreMapper.delete(num);
	}

	@Override
	public void modify(int num, String name, String kor, String eng) {
		
		scoreMapper.modify(num, name, kor, eng);
	}

	
	
	
	
}
