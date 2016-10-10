package pack.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

import pack.controller.SangpumBean;

public interface DataInter {
	List<SawonDto> list() throws DataAccessException;
	List<SawonDto> search(String bean) throws DataAccessException;
	List<BuserDto> search2(String bean) throws DataAccessException;
	
}
