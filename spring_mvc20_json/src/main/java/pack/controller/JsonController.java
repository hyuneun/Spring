package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pack.model.Mymodel;

@Controller
@RequestMapping("list")
public class JsonController {
	@Autowired
	private Mymodel mymodel;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody//반환객체를 브라우저에 뿌린다
	public Mymodel json(@RequestParam("name") String name){
		mymodel.setName(name);
		mymodel.setSkills(new String[]{"자바존문가","db간리자","웬전문가"});
		return mymodel;
	}
}
