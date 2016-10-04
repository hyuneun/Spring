package controller;

import model.DataDao;
import model.DataDaoimpl;

public class Main {
	public static void main(String[] args) {
		//db처리
		//DataDaoimpl dataDaoimpl = new DataDaoimpl();
		//DataDao dataDao = dataDaoimpl;
		DataDao dao = new DataDaoimpl();
		
		
		
		//비스니스 로직용
		SelectServiceImpl sel = new SelectServiceImpl(dao);
		SelectService selectService = sel;
		selectService.selectProcess();
	}
}
