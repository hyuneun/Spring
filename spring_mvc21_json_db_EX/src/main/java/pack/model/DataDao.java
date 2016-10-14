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
	
	 public List<SangpumDto> getDataAll(String gogek_no,String gogek_name){
	      String sql = "select sawon_name,sawon_jik,buser_name,buser_tel from sawon left join buser on buser_num=buser_no left join gogek on gogek_damsano=sawon_no where gogek_no="+gogek_no+" and gogek_name='" + gogek_name + "'";                         
	      System.out.println(sql);
	      return getJdbcTemplate().query(sql, new ItemRowMapper());
	   }
	   
	   //내부 클래스
	   class ItemRowMapper implements RowMapper{
	      
	      public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	         SangpumDto dto = new SangpumDto();
	         dto.setSawon_name(rs.getString(1));
	         dto.setSawon_jik(rs.getString(2));
	         dto.setBuser_name(rs.getString(3));
	         dto.setBuser_tel(rs.getString(4));
	         return dto;
	      }
	   }

}
