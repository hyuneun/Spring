package pack.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardDao;
import pack.model.BoardDto;

@Controller
public class ListController {
	
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping("list")
	public ModelAndView listProcess(@RequestParam(value="pagenum",defaultValue="1")String pagenum){
		ModelAndView view = new ModelAndView();
		int pagesize = 5;
		int currentPage = Integer.parseInt(pagenum);
		int startRow = (currentPage - 1) * pagesize;
		int count = boardDao.getMemberCount();
		
		List<BoardDto> list = boardDao.list(startRow);
		view.setViewName("list");
		view.addObject("list", list);
		view.addObject("currentPage", currentPage);
		view.addObject("count", count);
		view.addObject("pagesize", pagesize);
		return view;
	}
}
