package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.MemberDao;
import pack.model.MemberDto;

@Controller
public class ListController {
	
	@Autowired
	private MemberDao memberDao;
	
	/*@RequestMapping("list")
	public ModelAndView asd(){
		List<MemberDto> list = memberDao.getMemberList();
		ModelAndView view = new ModelAndView();
		view.setViewName("list");
		view.addObject("list", list);
		return view;
	}*/
	
	//페이지 나누기
	private int pagesize = 3; //한페이지에 출력행 수
	@RequestMapping("list")
	public ModelAndView asd(@RequestParam(value="pagenum",defaultValue="1")String pagenum){
		int currentPage = Integer.parseInt(pagenum);
		int startRow = (currentPage - 1) * pagesize;//0,3,
		int endRow = pagesize;
		int count = memberDao.getMemberCount();
		List<MemberDto> list = memberDao.getMemberList(startRow,endRow);
		ModelAndView view = new ModelAndView();
		view.setViewName("list");
		view.addObject("list", list);
		view.addObject("currentPage", currentPage);
		view.addObject("count", count);
		view.addObject("pagesize", pagesize);
		return view;
	}
}
