package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import pack.GogekImpl.SangRowMapper;

@Component
@Aspect
public class Login extends JdbcDaoSupport{
	
	@Autowired
	public Login(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	
	@Around("execution(public void dataList(..))")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println("사번");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.nextLine();
		System.out.println("이름");
		String password = scanner.nextLine();
		//scanner.close();

		for (GogekDto s : selectList(id,password)) {
			  System.out.println("사원 성공!. 작업을 시작합니다."+s.getSawon_no()+s.getSawon_name());
	          
	         if ( (id.equals(s.getSawon_no()) && password.equals(s.getSawon_name()) ) ) {
	            Object object = joinPoint.proceed();
	            
	            System.out.println("aop종료");
	            return object;
	            
	        }
	     }
		
		System.out.println("사원 인증실패!. 작업을 종료합니다.");
		
		return null;
	}
	

	
	public List<GogekDto> selectList(String a,String b) throws DataAccessException {
		RowMapper rowMapper = new SangRowMapper();
		return getJdbcTemplate().query("select * from sawon where sawon_no='" + a + "' and sawon_name='" + b + "'", rowMapper);
		
	}
	
	class SangRowMapper implements RowMapper{
		
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// select 실행결과를 한 레코드씩 전달받아 처리하는 메소드.(rs.next 필요없다)
			//System.out.println(rowNum);//레코드의갯수
			GogekDto dto = new GogekDto();
			dto.setSawon_no(rs.getString("sawon_no"));
			dto.setSawon_name(rs.getString("sawon_name"));
			dto.setBuser_num(rs.getString("buser_num"));
			dto.setSawon_jik(rs.getString("sawon_jik"));
			return dto;
		}
	}
}
