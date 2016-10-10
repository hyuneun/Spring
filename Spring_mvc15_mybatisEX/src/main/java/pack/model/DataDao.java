package pack.model;

import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import pack.controller.SangpumBean;

@Repository
public class DataDao extends SqlSessionDaoSupport implements DataInter{
	
	@Autowired
	public DataDao(SqlSessionFactory factory) {
		setSqlSessionFactory(factory);
	}
	
	public List<SawonDto> list() throws DataAccessException {
	
		return getSqlSession().selectList("selectDataAll");
	}
	
	public List<SawonDto> search(String bean) throws DataAccessException {
		return getSqlSession().selectList("selectDataSearch",bean);
	}
	
	public List<BuserDto> search2(String bean) throws DataAccessException {
		return getSqlSession().selectList("selectDataSearch2",bean);
	}
}
