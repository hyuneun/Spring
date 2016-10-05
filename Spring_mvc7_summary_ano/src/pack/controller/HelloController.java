package pack.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/*
public class HelloController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
	
		return null;
	}
}
*/

import pack.model.HelloModel;

@Controller
//@RequestMapping(value="/hello.do")
@RequestMapping({"hello.do","hi","abc/world.do","k*","mbc","sbs"})
public class HelloController{
	@Autowired
	private HelloModel hellomodel;
	
	/*@RequestMapping(method=RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		String result = hellomodel.getGreeting();//모델과 통신
		
		ModelAndView view = new ModelAndView("hello");//forward 방식(기본값)
		view.addObject("result",result);
		return view;
	}*/
	
	/*@RequestMapping(method=RequestMethod.GET)//map 리턴 요청명이 곧 파일명이된다!
	protected Map<String,Object> handleRequestInternal(){
		String result = hellomodel.getGreeting();
		HashMap<String, Object> map = new HashMap<>();
		map.put("result", result);
		return map;
	}*/
	
	@RequestMapping(method=RequestMethod.GET)//모델 리턴 요청명이 곧 파일명이된다!
	protected Model handleRequestInternal(Model model){
		String result = hellomodel.getGreeting();
		model.addAttribute("result", result);
		return model;
	}
}