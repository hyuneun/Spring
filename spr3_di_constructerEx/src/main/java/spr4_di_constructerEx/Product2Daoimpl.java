package spr4_di_constructerEx;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Product2Daoimpl implements Product2Dao{
	private ProductDao productDao;
	String data;
	int data2=0,data3=0;
	
	public Product2Daoimpl(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Override
	public void showData() {
		try {
			InputStreamReader reader = new InputStreamReader(System.in);
			BufferedReader bReader = new BufferedReader(reader);
			
			System.out.println("상품");
			data = bReader.readLine();
			System.out.println("수량");
			data2 = Integer.parseInt(bReader.readLine());
			System.out.println("단가");
			data3 = Integer.parseInt(bReader.readLine());
			
			System.out.println(data3);
			
			String re = productDao.Calc(data, data2, data3);
			System.out.println(re);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
