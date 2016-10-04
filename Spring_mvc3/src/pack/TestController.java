package pack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class TestController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// mvc 중 컨트롤러 영역
		System.out.println("TestController 수행");
		//return new ModelAndView("list");//뷰파일명 반환
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("say","ho"); //request.setAttribute("say","ho") 와 같은의미
		modelAndView.setViewName("list");
		return modelAndView;
	}
}
