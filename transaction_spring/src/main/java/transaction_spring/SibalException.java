package transaction_spring;

import org.springframework.dao.DataAccessException;

public class SibalException extends DataAccessException{

	public SibalException(String msg) {
		super("개열받네"+msg);
	}
}
