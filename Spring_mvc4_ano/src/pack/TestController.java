package pack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController{
	@RequestMapping("index.do")//index라는 요청이 들어오면 이메소드를수행
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// mvc 중 컨트롤러 영역
		System.out.println("TestController 수행");
		//return new ModelAndView("list");//뷰파일명 반환
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("say","hou"); //request.setAttribute("say","ho") 와 같은의미
		modelAndView.setViewName("list");
		return modelAndView;
	}
}
