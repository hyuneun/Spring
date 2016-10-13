package pack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardDao;
@Controller
public class ReinsertController {

	
	@Autowired
	private BoardDao inter;
	
	@ModelAttribute("command")
	public BoardBean formBack(){
		return new BoardBean();
	}
	
	@RequestMapping(value="reinsert",method=RequestMethod.GET)
	public ModelAndView insert(@RequestParam("num") int num){
		ModelAndView view = new ModelAndView();
		view.setViewName("reinsform");
		view.addObject("num", num);
		return view;
	}
	
	@RequestMapping(value="reinsert",method=RequestMethod.POST)
	public String insert(BoardBean bean){
		bean.setOnum(inter.count2(bean.getNum()) + 1);
		boolean b = inter.writeData2(bean);
		if(b){
			return "redirect:/list";
		}else{
			return "redirect:/error.jsp";
		}
}

}
