package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;


@Component
public class GogekImpl extends JdbcDaoSupport implements GogekInter{
	@Autowired
	public GogekImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	@Override
	public List<GogekDto> selectList() throws DataAccessException {
		RowMapper rowMapper = new SangRowMapper();
		Scanner scanner = new Scanner(System.in);
		System.out.println("부서번호입력");
		String a = scanner.nextLine();
		return getJdbcTemplate().query("select sawon_no,sawon_name,case when buser_num='10' then '총무부' when buser_num='20' then '영업부' when buser_num='30' then '전산부' when buser_num='40' then '관리부' end buser_num,sawon_jik from sawon where buser_num='" + a + "'", rowMapper);
		
	}
	
	class SangRowMapper implements RowMapper{
		
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// select 실행결과를 한 레코드씩 전달받아 처리하는 메소드.(re.next 필요없다)
		
			GogekDto dto = new GogekDto();
			dto.setSawon_no(rs.getString("sawon_no"));
			dto.setSawon_name(rs.getString("sawon_name"));
			dto.setBuser_num(rs.getString("buser_num"));
			dto.setSawon_jik(rs.getString("sawon_jik"));
			return dto;
			
		}
	}
}
