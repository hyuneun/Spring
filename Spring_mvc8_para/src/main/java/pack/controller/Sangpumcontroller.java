package pack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pack.model.SangpumModel;

@Controller
public class Sangpumcontroller {
	//모델사용
	@Autowired
	private SangpumModel sangpumModel;
	
	@RequestMapping(value="sangpum",method=RequestMethod.POST)
//	public ModelAndView submit(SangpumBean bean){
	public ModelAndView submit(@ModelAttribute("my") SangpumBean bean){
		ModelAndView view = new ModelAndView();
		view.setViewName("showMessage");
		view.addObject("data", sangpumModel.computer(bean));
		return view;
	}
	
	//뷰에서 직접접근가능
	@ModelAttribute("mylist")
	public List<String> abc(){
		List<String> list = new ArrayList<String>();
		list.add("한국인");
		list.add("한국인2");
		list.add("한국인3");
		return list;
		
	}
	
}
