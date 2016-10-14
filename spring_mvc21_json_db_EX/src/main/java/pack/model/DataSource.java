package pack.model;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Repository;

@Repository("dataSource")
public class DataSource  extends BasicDataSource{
	public DataSource() {
		this.setDriverClassName("org.mariadb.jdbc.Driver");
		this.setUrl("jdbc:mysql://localhost:3306/test");
		this.setUsername("root");
		this.setPassword("123");
	}
}
