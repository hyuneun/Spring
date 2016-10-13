package pack.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.Controller.BoardBean;

@Repository
public class BoardDao{

	@Autowired
	private AnoInter inter;
	
	public List<BoardDto> list(int startRow){
		return inter.select(startRow);
	}
	
	public boolean writeData(BoardBean bean){
		return inter.Insert(bean);
	}
	
	public boolean writeData2(BoardBean bean){
		return inter.Insert2(bean);
	}
	
	public List<BoardDto> search(Map<String,String> map){
		//System.out.println(map);
		return inter.search(map);
	}
	
	public List<BoardDto> search2(Map<String,String> map){
		//System.out.println(map);
		return inter.search2(map);
	}
	
	public Integer search3(Map<String,String> map){
		System.out.println(map);
		return inter.search3(map);
	}
	
	public Integer search4(Map<String,String> map){
		//System.out.println(map);
		return inter.search4(map);
	}
	
	
	public BoardDto detail(int num){
		return inter.detail(num);
	}
	
	public boolean updateData(BoardDto bean){
		return inter.updateData(bean);
	}
	
	public boolean delete(String num){
		return inter.delete(num);
	}
	
	public void viewUp(BoardDto dto){
		inter.viewUp(dto);
	}
	
	public int getMemberCount(){
		return inter.getMemberCount();
	}
	
	public int count2(int startRow){
		return inter.count2(startRow);
	}
}

