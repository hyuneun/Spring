package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.MemberDao;
import pack.model.MemberDto;

@Controller
public class UpdateController {
	
	@Autowired
	private MemberDao memberDao;
	
	@ModelAttribute("upcommand")
	public MemberBean formBank(){
		return new MemberBean();
	}
	
	private String formName = "upform";
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public ModelAndView form(@RequestParam("id")String id){
		MemberDto dto = memberDao.getMember(id);
		return new ModelAndView(formName,"update",dto);
		
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String sumit(MemberBean bean){
		memberDao.upData(bean);
		return "redirect:/list";
		
	}
}
