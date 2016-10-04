package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BussnessImpl implements BussinessInter{
	
	@Autowired
	private GogekInter inter;
	
	public void setInter(GogekInter inter) {
		this.inter = inter;
	}
	
	@Override
	public void dataList() {
		inter.selectList();
		
	}
	
}
