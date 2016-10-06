package pack;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class Datavalidater implements Validator{
	
	public boolean supports(Class<?> arg0) {
		//Validator가 해당 클래스에 대한 값 검증
		
		return loginFormBean.class.isAssignableFrom(arg0);
	}
	
	public void validate(Object target, Errors errors) {
		// target에 대한 검증 지원,에러발생시 Errors 객체에 저장
		loginFormBean command = (loginFormBean)target;
		
		//입력자료확인
		System.out.println(command.getUserid() + " " + command.getPasswd());
		
		//입력자료검증(방법1)
		if(command.getUserid() == null || command.getUserid().trim().isEmpty()){
			errors.rejectValue("userid", "err.userid");
		}
		//방법2
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwd", "err.passwd");
	}
}
