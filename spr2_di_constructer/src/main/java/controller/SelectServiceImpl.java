package controller;

import model.DataDao;

public class SelectServiceImpl implements SelectService{
	
	private DataDao dataDao;
	public SelectServiceImpl(DataDao dataDao) {
		// 생성자를 통해 인스턴스 주소를 치환
		this.dataDao = dataDao;
	}
	
	@Override
	public void selectProcess() {
		System.out.println("select process 수행");
		dataDao.selectData();
		
	}
}
