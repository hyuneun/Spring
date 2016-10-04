package pack;

public class BussnessImpl implements BussinessInter{
	private SangpumInter inter;
	
	public void setInter(SangpumInter inter) {
		this.inter = inter;
	}
	
	@Override
	public void dataList() {
		for(sangpumDto s:inter.selectList()){
			System.out.println(s.getCode());
			System.out.println(s.getSang());
			System.out.println(s.getSu());
			System.out.println(s.getDan());
		}
		
	}
	
}
