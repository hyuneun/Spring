package pack;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	
	@ModelAttribute("command")//다른어노테이션보다 먼저 수행된다
	public loginFormBean forBack(){
		return new loginFormBean();
	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String form(){
		return "loginform";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String sumit(@Validated @ModelAttribute("command") loginFormBean formBean,BindingResult result){
		//BindingResult - 입력자료오류검사수행
		if(formBean.getUserid().equals("aa") && formBean.getPasswd().equals("11")){
			//컨트롤러 내에서 강제에러발생 exception
			//int a = 10 /0;
			return "redirect:/list";//목록보기
		}else{
			
			return "loginform";
		}
	}
	
	@InitBinder
	public void initbinder(WebDataBinder binder){
		binder.setValidator(new Datavalidater());
	}
}
