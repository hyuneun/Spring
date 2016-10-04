package transaction_spring;

import java.util.ArrayList;
import java.util.List;

public class FooInterImpl implements FooInter{
	@Override
	public List<FooDto> getFoo() {
		List<FooDto> list = new ArrayList<FooDto>();
		System.out.println("셀렉트수행");
		return list;
	}
	
	@Override
	public FooDto getFoo(String name) {
		FooDto dto = new FooDto();
		System.out.println("일부셀렉트처리");
		return dto;
				
	}
	
	@Override
	public void insertFoo(FooDto fooDto) {
		try {
			System.out.println("인써트");
		} catch (Exception e) {
			throw new SibalException("에러");
		}
		
	}
	
	@Override
	public void updateFoo(FooDto fooDto) {
		try {
			System.out.println("업데이뜨");
		} catch (Exception e) {
			throw new SibalException("에러");
		}
		
	}

}
