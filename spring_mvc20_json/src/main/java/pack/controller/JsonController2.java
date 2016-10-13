package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pack.model.Mymodel;

@Controller
@RequestMapping("list2")
public class JsonController2 {
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody//반환객체를 브라우저에 뿌린다
	public Map jsons(){
		List<Map<String, String>> datalist = new ArrayList<Map<String,String>>();
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", "읻동규");
		data.put("age", "아재");
		datalist.add(data);
		
		data = new HashMap<String, String>();
		data.put("name", "읻동규");
		data.put("age", "아재");
		datalist.add(data);
		
		data = new HashMap<String, String>();
		data.put("name", "읻동규");
		data.put("age", "아재");
		datalist.add(data);
		
		//return data;
		Map<String, Object> data2 = new HashMap<String, Object>();
		data2.put("datas", datalist);
		return data2;
	}
}
