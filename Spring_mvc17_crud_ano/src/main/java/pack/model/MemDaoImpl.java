package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.MemBean;

@Repository
public class MemDaoImpl implements MemDaoInter{
	
	@Autowired
	private SangpumAnoInter inter;
	
	
	
	public List<MemDto> getdataAll() {
		return inter.selectDataAll();
	
	}
	
	public boolean deleteData(String num) {
	
		try {
			inter.delete(num);
			return true;
		} catch (Exception e) {
			System.out.println("인서트 에러" + e);
			return false;
		}
	}
	
	public boolean insertData(MemBean bean) {
		try {
			inter.insert(bean);
			return true;
		} catch (Exception e) {
			System.out.println("인서트 에러" + e);
			return false;
		}
	}
	
	public MemDto selectPart(String num) {
		return inter.selectSearch(num);
		
	}
	
	public boolean updateData(MemBean bean) {
		try {
			inter.update(bean);
			return true;
		} catch (Exception e) {
			System.out.println("인서트 에러" + e);
			return false;
		}
	}
}
