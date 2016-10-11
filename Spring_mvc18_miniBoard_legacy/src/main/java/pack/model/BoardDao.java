package pack.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.Controller.BoardBean;

@Repository
public class BoardDao {
	private DataSource ds;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Autowired	
	public BoardDao(DataSource dataSource) {
		try {
			ds = dataSource;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<BoardDto> list(){
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		try {
			String sql = "select * from springboard order by num desc";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDto dto = new BoardDto();
				dto.setNum(rs.getInt("num"));
				dto.setAuthor(rs.getString("author"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setBwrite(rs.getString("bwrite"));
				dto.setReadcnt(rs.getInt("readcnt"));
				list.add(dto);
				
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}
	
	public boolean writeData(BoardBean bean){
		boolean b = false;
		try {
			String sql = "insert into springboard(author,title,content,bwrite) values(?,?,?,now())";			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getAuthor());
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getContent());
		
			int t = pstmt.executeUpdate();
			
			if(t >= 1){
				b = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}
	
	public List<BoardDto> search(String name,String value){

		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		try {
			String sql = "select * from springboard where author like '%"+ name +"%' or title like '%" + value + "%'";			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(sql);
				BoardDto dto = new BoardDto();
				dto.setNum(rs.getInt("num"));
				dto.setAuthor(rs.getString("author"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setBwrite(rs.getString("bwrite"));
				dto.setReadcnt(rs.getInt("readcnt"));
				list.add(dto);
				
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	
	}
	
	public BoardDto detail(int num){
		BoardDto dto = new BoardDto();
		try {
			String sql = "select * from springboard where num=" + num;			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			while (rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setAuthor(rs.getString("author"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setBwrite(rs.getString("bwrite"));
				dto.setReadcnt(rs.getInt("readcnt"));
				
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return dto;
	}
	
	public boolean updateData(BoardBean bean){
		boolean b = false;
		try {
			String sql = "update springboard set author=?,title=?,content=? where num=?";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getAuthor());
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getContent());
			pstmt.setInt(4, bean.getNum());
			int p = pstmt.executeUpdate();
			if(p >= 1){
				b = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}
	
	public boolean delete(String num){
		boolean b = false;
		try {
			String sql = "delete from springboard where num=?";			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			int t = pstmt.executeUpdate();
			
			if(t >= 1){
				b = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}
	
	public void viewUp(BoardDto dto){

		try {
			String sql = "update springboard set readcnt=? where num=?";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getReadcnt() + 1);
			pstmt.setInt(2, dto.getNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

