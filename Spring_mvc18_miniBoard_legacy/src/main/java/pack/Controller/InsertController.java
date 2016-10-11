package pack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.model.BoardDao;

@Controller
public class InsertController {
	
	@Autowired
	private BoardDao inter;
	
	@ModelAttribute("command")
	public BoardBean formBack(){
		return new BoardBean();
	}
	
	@RequestMapping(value="insert",method=RequestMethod.GET)
	public String insert(){
		return "insform";
	}
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String insert(BoardBean bean){
		boolean b = inter.writeData(bean);
		if(b){
			return "redirect:/list";
		}else{
			return "redirect:/error.jsp";
		}
}
}
