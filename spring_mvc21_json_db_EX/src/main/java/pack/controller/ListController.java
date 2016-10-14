package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pack.model.DataDao;
import pack.model.SangpumDto;

@Controller
public class ListController {
   @Autowired
   private DataDao dataDao; //사실은 interface를 써야하는데 생략
   
   @RequestMapping("index")
   @ResponseBody
   public Map<String, Object> listProcess(@RequestParam("gogek_no") String gogek_no,@RequestParam("gogek_name") String gogek_name){
      List<Map<String,String>> list = new ArrayList<Map<String,String>>();
      Map<String, String> data = null;
      List<SangpumDto> sangList = dataDao.getDataAll(gogek_no,gogek_name);
      
      for(SangpumDto s : sangList){
    	  data = new HashMap<String, String>();
    	  data.put("sawon_name", s.getSawon_name());
    	  data.put("sawon_jik", s.getSawon_jik());
    	  data.put("buser_name", s.getBuser_name());
    	  data.put("buser_tel", s.getBuser_tel());
    	  System.out.println(s.getSawon_name());
    	  list.add(data);
      }
      Map<String, Object> sangdata = new HashMap<String, Object>();
      sangdata.put("datas", list);
      return sangdata;
   }
   
}