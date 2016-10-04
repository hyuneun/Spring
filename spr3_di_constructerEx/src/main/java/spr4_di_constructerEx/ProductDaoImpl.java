package spr4_di_constructerEx;

public class ProductDaoImpl implements ProductDao{
	
	@Override
	public String Calc(String sang,int su,int dan) {
		int hap = su * dan;
		
		return sang + "에 대한 금액은" + hap;
	}
}
