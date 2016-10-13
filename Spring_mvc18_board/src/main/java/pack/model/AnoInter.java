package pack.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pack.Controller.BoardBean;

public interface AnoInter {
	
	//@Select("select * from springboard order by num desc")
	@Select("select * from springboard order by gnum,onum limit #{startRow},5")
	public List<BoardDto> select(int startRow);
	
	@Insert("insert into springboard(author,title,content,bwrite,gnum) values(#{author},#{title},#{content},now(),#{gnum})")
	public boolean Insert(BoardBean bean);
	
	@Insert("insert into springboard(author,title,content,bwrite,onum,gnum) values(#{author},#{title},#{content},now(),#{onum},#{gnum})")
	public boolean Insert2(BoardBean bean);
	//
	@Select("select * from springboard where author like concat('%',#{key2},'%') order by gnum,onum limit #{key3},5")
	public List<BoardDto> search(Map<String,String> map);
	
	@Select("select * from springboard where title like concat('%',#{key2},'%') order by gnum,onum limit #{key3},5")
	public List<BoardDto> search2(Map<String,String> map);
	
	@Select("select count(*) from springboard where author like concat('%',#{key2},'%') order by gnum,onum limit #{key3},5")
	public Integer search3(Map<String,String> map);
	
	@Select("select count(*) from springboard where title like concat('%',#{key2},'%') order by gnum,onum limit #{key3},5")
	public Integer search4(Map<String,String> map);
	//
	@Select("select * from springboard where num=#{num}")
	public BoardDto detail(int num);
	
	@Update("update springboard set author=#{author},title=#{title},content=#{content} where num=#{num}")
	public boolean updateData(BoardDto bean);
	
	@Delete("delete from springboard where num=#{num}")
	public boolean delete(String num);
	
	@Update("update springboard set readcnt=#{readcnt}+1 where num=#{num}")
	public void viewUp(BoardDto dto);
	
	@Select("select count(*) from springboard")
	public int getMemberCount();
		
	@Select("select count(gnum) from springboard where num=#{num}")
	public int count2(int startRow);
}
