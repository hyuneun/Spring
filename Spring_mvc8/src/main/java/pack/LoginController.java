package pack;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public ModelAndView abc(HttpServletRequest request){
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String data = "";
		if(id.equalsIgnoreCase("aa") && pwd.equals("11")){
			data = id + "님 로그인 성공";
		}else{
			data = "로그인실패";
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("showMessage");
		modelAndView.addObject("message", data);
		return modelAndView;
	}
}
