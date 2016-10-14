package pack.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao extends JdbcDaoSupport{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Autowired
	private DataSource dataSource;
	
	
	@PostConstruct
	public void init(){
		setDataSource(dataSource);
	}
	
	public DataDao() {
	
	}
	
	 public List<SangpumDto> getDataAll(String buser_name){
	      String sql = "select sawon_no,sawon_name,buser_tel,sawon_jik,count(gogek_damsano) sawon_count from sawon left join gogek on gogek_damsano=sawon_no left join buser on buser_num=buser_no where buser_name='"+buser_name+"' group by sawon_name order by sawon_no";                         
	      System.out.println(sql);
	      return getJdbcTemplate().query(sql, new ItemRowMapper());
	   }
	   
	   //내부 클래스
	   class ItemRowMapper implements RowMapper{
	      
	      public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	         SangpumDto dto = new SangpumDto();
	         dto.setSawon_no(rs.getString(1));
	         dto.setSawon_name(rs.getString(2));
	         dto.setBuser_tel(rs.getString(3));
	         dto.setSawon_jik(rs.getString(4));
	         dto.setSawon_count(rs.getString(5));
	         return dto;
	      }
	   }
	   
	   //------------------------------------
	   public List<GogekDto> getDataAll2(String sawon_name){
		      String sql = "select gogek_no,gogek_name,gogek_tel,gogek_jumin from gogek left join sawon on gogek_damsano=sawon_no where sawon_name='"+sawon_name+"'";                         
		      System.out.println(sql);
		      return getJdbcTemplate().query(sql, new ItemRowMapper2());
		   }
		   
		   //내부 클래스
		   class ItemRowMapper2 implements RowMapper{
		      
		      public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		         GogekDto dto = new GogekDto();
		         dto.setGogek_no(rs.getString(1));
		         dto.setGogek_name(rs.getString(2));
		         dto.setGogek_tel(rs.getString(3));
		         dto.setGogek_jumin(rs.getString(4));
		         return dto;
		      }
		   }
		   
		   //-----------------------------------
		   
		   public List<SangpumDto> getDataAll3(String sawon_name,String sawon_no){
			      String sql = "select sawon_name from sawon where sawon_name='"+sawon_name+"' and sawon_no='"+ sawon_no +"'";                         
			      System.out.println(sql);
			      return getJdbcTemplate().query(sql, new ItemRowMapper3());
			   }
			   
			   //내부 클래스
			   class ItemRowMapper3 implements RowMapper{
			      
			      public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			         SangpumDto dto = new SangpumDto();
			         dto.setSawon_no(rs.getString(1));
			         return dto;
			      }
			   }

}
