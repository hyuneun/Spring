package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class SangpumImpl extends JdbcDaoSupport implements SangpumInter{
	
	@Override
	public List<sangpumDto> selectList() throws DataAccessException {
		RowMapper rowMapper = new SangRowMapper();
		return getJdbcTemplate().query("select * from sangdata", rowMapper);
	}
	
	class SangRowMapper implements RowMapper{
		
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// select 실행결과를 한 레코드씩 전달받아 처리하는 메소드.(re.next 필요없다)
			System.out.println(rowNum);//레코드의갯수
			sangpumDto dto = new sangpumDto();
			dto.setCode(rs.getString("code"));
			dto.setSang(rs.getString("sang"));
			dto.setSu(rs.getString("su"));
			dto.setDan(rs.getString("dan"));
			return dto;
		}
	}
}
