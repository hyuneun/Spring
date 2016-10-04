package pack;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface GogekInter {
	List<GogekDto> selectList() throws DataAccessException;
}
