package pack;

import org.springframework.stereotype.Service;

@Service
public class LogicImpl implements LogicInter{
	public LogicImpl() {
	
	}
	
	@Override
	public void startProcess() {
		System.out.println("로긴성공 로직수행~!~!~!~!~~!~!~!");
		
	}
}
