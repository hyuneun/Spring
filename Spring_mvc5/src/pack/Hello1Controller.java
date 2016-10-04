package pack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Hello1Controller implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("world controller 수행");
		
		ModelAndView andView = new ModelAndView();
		andView.addObject("message","월도");
		andView.setViewName("view2");
		return andView;
	}
	
}
