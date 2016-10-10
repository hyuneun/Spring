package pack.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

import pack.controller.SangpumBean;

public interface DataInter {
	List<ProductDto> list() throws DataAccessException;
	List<ProductDto> search(SangpumBean bean) throws DataAccessException;
	
}
