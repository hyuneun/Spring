package transaction_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TransactionTest {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public TransactionTest() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123");
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
		
		try {
			stmt = conn.createStatement();
			
			//트랜젝션 시작
			conn.setAutoCommit(false);
			try {
				String ins = "insert into sangdata values(103,'메디안4',33,1)";
				stmt.executeUpdate(ins);
				//이런저런 작업을 하다가..
				
				//레코드 수정
				String up = "update sangdata set sang='똥' where code=103";
				stmt.executeUpdate(up);
				conn.commit();
			} catch (Exception e) {
				System.out.println("err" + e);
				conn.rollback();
			
			}finally {
				conn.setAutoCommit(true);
			}
				String sql = "select * from sangdata";
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					System.out.print(rs.getString(1) + "\t");
					System.out.print(rs.getString(2) + "\t");
					System.out.print(rs.getString(3) + "\t");
					System.out.print(rs.getString(4) + "\n");
					
				}
				
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		new TransactionTest();

	}

}
