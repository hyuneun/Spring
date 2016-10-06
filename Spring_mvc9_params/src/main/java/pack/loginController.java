package pack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class loginController {
	@RequestMapping(value="kbs/login",params="type=admin")
	public ModelAndView ddingho(){
		ModelAndView view = new ModelAndView();
		view.setViewName("showMessage");
		view.addObject("message", "관리자임");
		return view;
	}
	
	@RequestMapping(value="kbs/login",params="type=user")
	public ModelAndView ddingho2(){
		ModelAndView view = new ModelAndView();
		view.setViewName("showMessage");
		view.addObject("message", "평민");
		return view;
	}
	
	@RequestMapping(value="kbs/login",params="!type")
	public ModelAndView ddingho3(){
		ModelAndView view = new ModelAndView();
		view.setViewName("showMessage");
		view.addObject("message", "인자가 없네요");
		return view;
	}
	
	@RequestMapping(value="kbs/{url}")
	public ModelAndView ddingho4(@RequestParam("type") String type, @PathVariable String url){
		ModelAndView view = new ModelAndView();
		view.setViewName("showMessage");
		view.addObject("message", url + "--" + type);
		return view;
	}
	
	@RequestMapping(value="{a}/{b}/{c}/{d}")
	public ModelAndView ddingho5(@RequestParam("title") String type, @PathVariable String a,@PathVariable String b,@PathVariable String c,@PathVariable String d){
		ModelAndView view = new ModelAndView();
		view.setViewName("showMessage");
		view.addObject("message", a + "--" + b + "--" + c + "--" + d + type);
		return view;
	}
	
}
