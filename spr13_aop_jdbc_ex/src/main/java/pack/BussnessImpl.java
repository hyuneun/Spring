package pack;

import org.springframework.stereotype.Service;

@Service
public class BussnessImpl implements BussinessInter{
	private GogekInter inter;
	int count = 0;
	public void setInter(GogekInter inter) {
		this.inter = inter;
	}
	@Override
	public void dataList() {
		for(GogekDto s:inter.selectList()){
			if(count == 0){
				System.out.println("고객번호\t고객명\t고객전화");		
			}
			System.out.print(s.getGogek_no()+"\t");
			System.out.print(s.getGogek_name()+"\t");
			System.out.print(s.getGogek_tel() + "\n");
			count++;
		}
		
	}
	
}
