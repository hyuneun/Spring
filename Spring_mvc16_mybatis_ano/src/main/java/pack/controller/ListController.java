package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pack.model.DataInter;

@Controller
@ComponentScan("pack.model")
public class ListController {
	@Autowired
	private DataInter inter;
	
	@RequestMapping("list")
	public Model processSelect(Model model){
		model.addAttribute("data",inter.list());
		return model;
	}
}
