package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pack.model.MyModelInter;

@Controller
public class TestController {
	@Autowired
	@Qualifier("myModel")//이름으로매칭
	private MyModelInter inter;
	
	@RequestMapping("test")
	public ModelAndView abc(){
		String result1 = inter.businessMsg();
		String result2 = inter.processMsg();
		
		ModelAndView view = new ModelAndView();
		view.setViewName("showMessage");
		view.addObject("data1", result1);
		view.addObject("data2", result2);
		
		return view;
	}
}
