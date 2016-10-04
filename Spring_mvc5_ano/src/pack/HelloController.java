package pack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*@Controller
public class HelloController{
	//@RequestMapping("hello.do")
	@RequestMapping(value="hello3.do", method=RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("hello controller 수행");
		
		ModelAndView andView = new ModelAndView();
		andView.addObject("message","오노우 헬러");
		andView.setViewName("view1");
		return andView;
	}
	
	@RequestMapping(value="hello.do", method=RequestMethod.POST)
	public ModelAndView handleRequest2(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("hello controller 수행");
		
		ModelAndView andView = new ModelAndView();
		andView.addObject("message","오노우 헬러 post");
		andView.setViewName("view1");
		return andView;
	}
	
}*/


@Controller
@RequestMapping({"hello*","mbc/hi"})
public class HelloController{
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("hello controller 수행");
		
		ModelAndView andView = new ModelAndView();
		andView.addObject("message","오노우 헬러");
		andView.setViewName("view1");
		return andView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView handleRequest2(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("hello controller 수행");
		
		ModelAndView andView = new ModelAndView();
		andView.addObject("message","오노우 헬러 post");
		andView.setViewName("view1");
		return andView;
	}
	
}
