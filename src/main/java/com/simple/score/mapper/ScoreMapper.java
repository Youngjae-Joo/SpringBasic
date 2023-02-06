package com.simple.score.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.simple.command.ScoreVO;

@Mapper //mybatis-scan
public interface ScoreMapper {
	
	public void regist(ScoreVO vo);
	public ArrayList<ScoreVO> getList();
	public void delete(int num);
	public void modify(@Param("a")int num, @Param("b")String name, @Param("c")String kor, @Param("d")String eng);
	
}
