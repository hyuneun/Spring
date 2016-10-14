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
	
	 public List<SangpumDto> getDataAll(){
	      String sql = "select * from sangdata";
	      
	      return getJdbcTemplate().query(sql, new ItemRowMapper());
	   }
	   
	   //내부 클래스
	   class ItemRowMapper implements RowMapper{
	      
	      public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	         SangpumDto dto = new SangpumDto();
	         dto.setCode(rs.getString(1));
	         dto.setSang(rs.getString(2));
	         dto.setSu(rs.getString(3));
	         dto.setDan(rs.getString(4));
	         return dto;
	      }
	   }

}
