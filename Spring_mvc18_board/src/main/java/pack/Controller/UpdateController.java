package pack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardDao;
import pack.model.BoardDto;

@Controller
public class UpdateController {

	
	@Autowired
	private BoardDao inter;

	@RequestMapping(value="update",method=RequestMethod.GET)
	public ModelAndView insert(@RequestParam("num") int num){
		BoardDto dto = inter.detail(num);
		return new ModelAndView("upform","dto",dto);
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String insert(BoardDto bean){
		boolean b = inter.updateData(bean);
		if(b){
			return "redirect:/list";
		}else{
			return "redirect:/error.jsp";
		}
	}
	

	
	
	
	

}
