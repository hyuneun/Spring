package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import pack.resouce.SqlMapConfig;

@Component
public class SangpumDao implements DaoInter{
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	private SqlSession session = factory.openSession();
	
	@Override
	public List<SawonDto> selectDataSawon() {
		
		List<SawonDto> list = null;
		
		try {
			list = session.selectList("selectDataSawon");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	@Override
	public List<BuserDto> selectDataBuserCount() {
		
		List<BuserDto> list2 = null;
		
		try {
			list2 = session.selectList("selectDataBuser");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list2;
	}
	
	@Override
	public List<BuserDto> selectDataBuserPay() {
	
		List<BuserDto> list3 = null;
		
		try {
			list3 = session.selectList("selectDataPay");
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(session != null) session.close();
		}
		
		return list3;
	}
}
