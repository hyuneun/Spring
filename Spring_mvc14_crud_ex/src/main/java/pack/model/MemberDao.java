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



@Repository
public class MemberDao  extends JdbcDaoSupport{
	
	@Autowired
	private DataSource dataSource;
	
	
	@PostConstruct
	public void init(){
		setDataSource(dataSource);
	}
	
	public List<SawonDto> getMemberList(){
		String sql = "select distinct sawon_no,sawon_name,sawon_jik,buser_name,case when gogek_damsano = sawon_no then 'O' else 'X' end gogek_ok from sawon left join buser on buser_no=buser_num left join gogek on gogek_damsano = sawon_no";
		List<SawonDto> list = getJdbcTemplate().query(sql, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				SawonDto dto = new SawonDto();
				dto.setSawon_no(rs.getString(1));
				dto.setSawon_name(rs.getString(2));
				dto.setSawon_jik(rs.getString(3));
				dto.setBuser_name(rs.getString(4));
				dto.setGogek_ok(rs.getString(5));
				return dto;
			}
		});
		return list;
	}

	public List<GogekDto> getMember(String id){
		String sql = "select sawon_name,sawon_jik,gogek_no,gogek_name,case when gogek_jumin like '%-1%' then '남' when gogek_jumin like '%-2%' then '여'end gogek_gen,(YEAR(now())) - (SUBSTR(gogek_jumin,1,2)+1900) gogek_age,gogek_tel from gogek left join sawon on sawon_no=gogek_damsano where gogek_damsano=?";
		List<GogekDto> list = getJdbcTemplate().query(sql, new Object[]{id},new RowMapper(){
			@Override
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				GogekDto dto = new GogekDto();
				dto.setSawon_name(rs.getString(1));
				dto.setSawon_jik(rs.getString(2));
				dto.setGogek_no(rs.getString(3));
				dto.setGogek_name(rs.getString(4));
				dto.setGogek_gen(rs.getString(5));
				dto.setGogek_age(rs.getString(6));
				dto.setGogek_tel(rs.getString(7));
				
				return dto;
			}
		});
		return list;
	}
}


