package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pack.model.DataDao;
import pack.model.SangpumDto;

@Controller
public class ListController {
   @Autowired
   private DataDao dataDao; //사실은 interface를 써야하는데 생략
   
   @RequestMapping("sangpum")
   @ResponseBody
   public Map<String, Object> listProcess(){
      List<Map<String,String>> list = new ArrayList<Map<String,String>>();
      Map<String, String> data = null;
      
      List<SangpumDto> sangList = dataDao.getDataAll();
      for(SangpumDto s : sangList){
    	  data = new HashMap<String, String>();
    	  data.put("code", s.getCode());
    	  data.put("sang", s.getSang());
    	  data.put("su", s.getSu());
    	  data.put("dan", s.getDan());
    	  list.add(data);
      }
      Map<String, Object> sangdata = new HashMap<String, Object>();
      sangdata.put("datas", list);
      return sangdata;
   }
   
}