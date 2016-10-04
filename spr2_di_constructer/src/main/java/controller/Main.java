package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.DataDao;
import model.DataDaoimpl;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app_init.xml");
		
		
		SelectService selectService = (SelectService)context.getBean("SelectServiceImpl");
		selectService.selectProcess();
	}
}
