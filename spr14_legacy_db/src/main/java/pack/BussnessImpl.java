package pack;

public class BussnessImpl implements BussinessInter{
	private SangpumInter inter;
	
	public void setInter(SangpumInter inter) {
		this.inter = inter;
	}
	
	@Override
	public void dataList() {
		inter.selectList();
		
	}
	
}
