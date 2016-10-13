package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import pack.controller.SangpumBean;

public interface SangpumAnoInter {
	
	@Select("select * from sangdata")
	public List<ProductDto> selectDataAll();
		
	@Select("select * from sangdata where sang like concat('%',#{searchValue},'%')")
	public List<ProductDto> selectSearch(SangpumBean bean);
		
	
}
