package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.MemberDao;

@Controller
public class DeleteController {
	@Autowired
	@Qualifier("memberDao")
	private MemberDao dao;
	
	@RequestMapping("delete")
	public ModelAndView del(@RequestParam("id")String id){
		dao.delData(id);
		return new ModelAndView("redirect:/list");
	}
}
