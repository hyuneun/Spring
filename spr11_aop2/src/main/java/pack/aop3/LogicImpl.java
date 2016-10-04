package pack.aop3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogicImpl implements LogicInter{
	@Autowired
	private ArticleInter articleInter;
	
	@Override
	public void selectData_process() {
		System.out.println("selectDataProcess 수행");
		articleInter.selectAll();
	}
	
}
