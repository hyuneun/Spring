package pack.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardDao;
import pack.model.BoardDto;


@Controller
public class SearchController {

	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping("search")
	public ModelAndView listProcess(@RequestParam("searchName") String name,@RequestParam("searchValue") String value){
		List<BoardDto> list;
		if(name.equalsIgnoreCase("author")){
			list = boardDao.search(value, "sdfa3");
			
		}else{
			list = boardDao.search("sdfa3", value);
		}
		return new ModelAndView("list","list",list);
	}
	
	@RequestMapping("detail")
	public ModelAndView detailProcess(@RequestParam("num") int num){
		BoardDto boardDto;
		boardDto = boardDao.detail(num);
		boardDao.viewUp(boardDto);
		boardDto = boardDao.detail(num);
		return new ModelAndView("detail","list",boardDto);
	}
	
	@RequestMapping("delete")
	public String deleteProcess(@RequestParam("num") String num){
		BoardDto boardDto;
		boolean b = boardDao.delete(num);
		if(b){
			return "redirect:/list";
		}else{
			return "redirect:/error.jsp";
		}

	}
	
	
}
