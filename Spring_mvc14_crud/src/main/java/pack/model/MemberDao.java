package pack.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pack.controller.MemberBean;

@Repository
public class MemberDao  extends JdbcDaoSupport{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Autowired
	private DataSource dataSource;
	
	
	@PostConstruct
	public void init(){
		setDataSource(dataSource);
	}
	
	public List<MemberDto> getMemberList(int startRow,int endRow){
		String sql = "select * from member order by id desc limit ?,?";
		List<MemberDto> list = getJdbcTemplate().query(sql,new Object[]{startRow,endRow}, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				MemberDto dto = new MemberDto();
				dto.setId(rs.getString(1));
				dto.setPasswd(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setReg_date(rs.getString(4));
				return dto;
			}
		});
		return list;
	}
	
	public int getMemberCount(){//전체건수(페이징처리)
		String sql = "select count(*) from member";
		return getJdbcTemplate().queryForObject(sql, Integer.class);
	}
	
	public void insData(MemberBean bean){
		String sql = "insert into member values(?,?,?,now())";
		Object[] param = {bean.getId(),bean.getPasswd(),bean.getName()};
		getJdbcTemplate().update(sql,param);
	}
	
	public void upData(MemberBean bean){
		String sql = "update member set passwd=?,name=? where id=?";
		getJdbcTemplate().update(sql,new Object[]{bean.getPasswd(),bean.getName(),bean.getId()});
	}
	
	public void delData(String id){
		String sql = "delete from member where id=?";
		getJdbcTemplate().update(sql,new Object[]{id});
	}

	public MemberDto getMember(String id){
		String sql = "select * from member where id=?";
		MemberDto dto = (MemberDto)getJdbcTemplate().queryForObject(sql, new Object[]{id},new RowMapper(){
			@Override
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				MemberDto dto = new MemberDto();
				dto.setId(rs.getString(1));
				dto.setPasswd(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setReg_date(rs.getString(4));
				return dto;
			}
		});
		return dto;
	}
}


