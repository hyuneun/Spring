package pack.bissuness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.BuserDto;
import pack.model.DaoInter;
import pack.model.SawonDto;

@Service
public class ProcessInterImpl implements ProcessInter{
	@Autowired
	private DaoInter daoInter;
	
	@Override
	public void dataShow() {
		List<SawonDto> list = daoInter.selectDataSawon();
		List<BuserDto> list2 = daoInter.selectDataBuserCount();
		List<BuserDto> list3 = daoInter.selectDataBuserPay();
		
		
		for(SawonDto s:list){
			System.out.print(s.getSawon_no() + "\t");
			System.out.print(s.getSawon_name() + "\t");
			System.out.print(s.getBuser_num() + "\t");
			System.out.print(s.getSawon_ibsail() + "\n");
		}
		System.out.println();
		for(BuserDto s1:list2){
			System.out.print(s1.getBuser_name() + "\t");
			System.out.print(s1.getBuser_count() + "\n");
		}
		System.out.println();
		for(BuserDto s2:list3){
			System.out.print(s2.getBuser_name() + "\t");
			System.out.print(s2.getSawon_name() + "\t");
			System.out.print(s2.getSawon_pay() + "\n");
		}
		
	}
	
}
