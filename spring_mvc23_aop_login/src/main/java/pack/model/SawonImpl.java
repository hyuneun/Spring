package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class SawonImpl extends SqlSessionDaoSupport implements SawonInter{
	@Autowired
	public SawonImpl(SqlSessionFactory factory) {
		setSqlSessionFactory(factory);
	}

	@Override
	public List<SawonDto> sawonList() {
		return getSqlSession().selectList("selectDataAll");
	}

	@Override
	public SawonDto getLoginInfo(String id) {
		return getSqlSession().selectOne("selectLogin",id);
	}

}
