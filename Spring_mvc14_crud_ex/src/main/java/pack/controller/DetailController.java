package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.GogekDto;
import pack.model.MemberDao;

@Controller
public class DetailController {
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping("detail")
	public ModelAndView detail(@RequestParam("id")String id){
		List<GogekDto> list = memberDao.getMember(id);
		return new ModelAndView("detail","member",list);
	}
}
