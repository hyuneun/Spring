package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class GogekImpl extends JdbcDaoSupport implements GogekInter{
	
	@Override
	public List<GogekDto> selectList() throws DataAccessException {
		RowMapper rowMapper = new SangRowMapper();
		return getJdbcTemplate().query("select gogek_no,gogek_name,gogek_tel from gogek where gogek_jumin like '%-1%'", rowMapper);
	}
	
	class SangRowMapper implements RowMapper{
		
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// select 실행결과를 한 레코드씩 전달받아 처리하는 메소드.(re.next 필요없다)
			//System.out.println(rowNum);//레코드의갯수
			GogekDto dto = new GogekDto();
			dto.setGogek_no(rs.getString("gogek_no"));
			dto.setGogek_name(rs.getString("gogek_name"));
			dto.setGogek_tel(rs.getString("gogek_tel"));
			return dto;
		}
	}
}
