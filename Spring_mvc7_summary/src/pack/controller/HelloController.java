package pack.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;
/*
public class HelloController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
	
		return null;
	}
}
*/

import pack.model.HelloModel;

public class HelloController extends AbstractController{
	private HelloModel hellomodel;
	
	public void setHellomodel(HelloModel hellomodel) {
		this.hellomodel = hellomodel;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		String result = hellomodel.getGreeting();//모델과 통신
		
		//ModelAndView view = new ModelAndView("hello");//forward 방식(기본값)
		ModelAndView view = new ModelAndView("redirect:/hello.jsp");//리다이렉트방식
		view.addObject("result",result);
		return view;
	}
}