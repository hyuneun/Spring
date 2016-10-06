package pack;

import org.springframework.stereotype.Controller;
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
	public String sumit(loginFormBean formBean){
		if(formBean.getUserid().equals("aa") && formBean.getPasswd().equals("11")){
			return "redirect:/list";//목록보기
		}else{
			
			return "loginform";
		}
	}
}
