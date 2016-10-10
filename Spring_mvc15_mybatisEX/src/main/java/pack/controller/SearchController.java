package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BuserDto;
import pack.model.DataInter;
import pack.model.SawonDto;
@Controller
public class SearchController {
	@Autowired
	private DataInter inter;
	
	@RequestMapping(value="search",method=RequestMethod.GET)
	public ModelAndView processSearch(@RequestParam("search")String bean){
		List<BuserDto> list = inter.search2(bean);
		return new ModelAndView("search","data",list);
	}
	
	@RequestMapping(value="search2",method=RequestMethod.POST)
	public ModelAndView processSearch2(@RequestParam("searchValue")String bean){
			List<SawonDto> list;
		if(bean.equals("전체")){
			list = inter.list();
		}else{
			
			list = inter.search(bean);
		}
		return new ModelAndView("list","data",list);
	}
}
