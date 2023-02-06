package com.simple.basic.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.simple.command.ScoreVO;

@Mapper //마이바티스 지칭 -(스프링에서는 생략가능)
public interface TestMapper {
	
	public String getTime(); 
	
	public ArrayList<ScoreVO> getScore();
	public ScoreVO getOne(int a);
	
	public Map<String, Object> selectMap(int num); //1행
	public ArrayList<Map<String, Object>> selectTwo(); //맵을 통한 다중행 조회
	
	public int insertOne(String s); //단일값
	public int insertTwo(ScoreVO vo); //다중값 -vo
	public int insertThree(Map<String, String> map); //다중값 -map
	
	public boolean updateOne(ScoreVO vo);//update
	
	public void insertFour(@Param("변수명1")String name, @Param("변수명2")int kor);
	
}
