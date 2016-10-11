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
public class DataDao implements DataInter{
	
	@Autowired
	private SangpumAnoInter inter;
	
	public List<ProductDto> list() throws DataAccessException {
	
		return inter.selectDataAll();
	}
	
	public List<ProductDto> search(SangpumBean bean) throws DataAccessException {
		return inter.selectSearch(bean);
	}
}
