package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.MemberDao;
import pack.model.SawonDto;

@Controller
public class ListController {
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping("list")
	public ModelAndView asd(){
		List<SawonDto> list = memberDao.getMemberList();
		ModelAndView view = new ModelAndView();
		view.setViewName("list");
		view.addObject("list", list);
		return view;
	}
}
