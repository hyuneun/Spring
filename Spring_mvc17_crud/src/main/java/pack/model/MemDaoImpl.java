package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.MemBean;

@Repository
public class MemDaoImpl extends SqlSessionDaoSupport implements MemDaoInter{
	
	@Autowired
	public MemDaoImpl(SqlSessionFactory factory) {
		setSqlSessionFactory(factory);
	}
	
	public List<MemDto> getdataAll() {
		return getSqlSession().selectList("selectDataAll");
	
	}
	
	public boolean deleteData(String num) {
	
		try {
			getSqlSession().delete("deleteData", num);
			return true;
		} catch (Exception e) {
			System.out.println("인서트 에러" + e);
			return false;
		}
	}
	
	public boolean insertData(MemBean bean) {
		try {
			getSqlSession().insert("insertData", bean);
			return true;
		} catch (Exception e) {
			System.out.println("인서트 에러" + e);
			return false;
		}
	}
	
	public MemDto selectPart(String num) {
		return getSqlSession().selectOne("selectDataPart",num);
		
	}
	
	public boolean updateData(MemBean bean) {
		try {
			getSqlSession().update("updateData", bean);
			return true;
		} catch (Exception e) {
			System.out.println("인서트 에러" + e);
			return false;
		}
	}
}
