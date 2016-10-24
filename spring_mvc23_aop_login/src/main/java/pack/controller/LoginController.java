package pack.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.SawonDto;
import pack.model.SawonInter;

@Controller
public class LoginController {
	
	@Autowired
	private SawonInter inter;
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String gologin(){
		return "login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String gologin2(HttpSession session,@RequestParam("no") String no,@RequestParam("name") String name){
		SawonDto dto = inter.getLoginInfo(no);
		
		if(dto != null){
			String result = dto.getSawon_name();
			if(result.equals(name)){
				session.setAttribute("name", name);
			}
		}
		return "redirect:/sawon";
	}
}
