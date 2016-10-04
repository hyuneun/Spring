package pack.bissuness;

import java.util.List;

import pack.model.DaoInter;
import pack.model.SangpumDto;

public class ProcessInterImpl implements ProcessInter{
	private DaoInter daoInter;
	
	public ProcessInterImpl(DaoInter daoInter) {
		this.daoInter = daoInter;
	}
	
	@Override
	public void dataShow() {
		List<SangpumDto> list = daoInter.selectDataAll();
		
		for(SangpumDto s:list){
			System.out.print(s.getCode() + "\t");
			System.out.print(s.getSang() + "\t");
			System.out.print(s.getSu() + "\t");
			System.out.print(s.getDan() + "\n");
		}
	}
	
}
