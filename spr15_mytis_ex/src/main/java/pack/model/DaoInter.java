package pack.model;

import java.util.List;

public interface DaoInter {
	List<SawonDto> selectDataSawon();
	List<BuserDto> selectDataBuserCount();
	List<BuserDto> selectDataBuserPay();
}
