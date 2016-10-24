package pack.upload;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class FileValidator implements Validator {
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void validate(Object upbean, Errors error) {
		UploadBean bean = (UploadBean)upbean;
		
		if (bean.getFile().getSize() == 0) {
			error.rejectValue("file", "","업로드 할 파일을 선택하시오.");
		}
		
	}
}
