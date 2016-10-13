package pack.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardDao;
import pack.model.BoardDto;


@Controller
public class SearchController {

	@Autowired
	private BoardDao boardDao;
	private String sname;
	private String svalue;
	private Integer count;
	private int pagesize;
	private int currentPage;
	private int startRow;
	private int good;
	
	
	@ModelAttribute("command")
	public BoardBean formBack(){
		return new BoardBean();
	}
	
	@RequestMapping("search")
	public ModelAndView listProcess(BoardBean bean,@RequestParam(value="pagenum",defaultValue="1")String pagenum){
		List<BoardDto> list;
		Map<String,String> map = new HashMap();
		ModelAndView view = new ModelAndView();
		
		pagesize = 5;
		currentPage = Integer.parseInt(pagenum);
		startRow = (currentPage - 1) * pagesize;
		//count = boardDao.getMemberCount();
		
		
		if(bean.getSearchName() != null){
			
			sname = bean.getSearchName();
			svalue = bean.getSearchValue();
			
		}
	
		map.put("key1", sname);
		map.put("key2", svalue);		
		map.put("key3", Integer.toString(startRow));
		
		if(sname.equals("author")){
			list = boardDao.search(map);
			count = boardDao.search3(map);
			if(count != null){
				good = count;
			}
			//System.out.println("a");
		}else if(sname.equals("title")){
			list = boardDao.search2(map);
			count = boardDao.search4(map);
			if(count != null){
				good = count;
			}
			//System.out.println("b");
		}else{
			list = boardDao.search2(map);
			//System.out.println("c");
		}
		System.out.println(good + "godddddddddd");
		System.out.println(count + "asdasdasd");
		
		view.setViewName("search");
		view.addObject("list", list);
		view.addObject("currentPage", currentPage);
		if(count == null){
			view.addObject("count", good);

		}else{
			
			view.addObject("count", count);
		}
		view.addObject("pagesize", pagesize);
		return view;
	}
	
	@RequestMapping("detail")
	public ModelAndView detailProcess(@RequestParam("num") int num,@RequestParam("page") int page){
		ModelAndView view = new ModelAndView();
		BoardDto boardDto;
		boardDto = boardDao.detail(num);
		boardDao.viewUp(boardDto);
		boardDto = boardDao.detail(num);
		view.addObject("list", boardDto);
		view.addObject("page", page);
		view.setViewName("detail");
		return view;
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
