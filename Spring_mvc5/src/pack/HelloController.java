package pack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("hello controller 수행");
		
		ModelAndView andView = new ModelAndView();
		andView.addObject("message","헬러");
		andView.setViewName("view1");
		return andView;
	}
	
}
