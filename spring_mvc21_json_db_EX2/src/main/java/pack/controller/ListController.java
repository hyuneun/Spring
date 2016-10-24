package pack.controller;

import java.sql.SQLException;
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
import pack.model.GogekDto;
import pack.model.SangpumDto;

@Controller
public class ListController {
   @Autowired
   private DataDao dataDao; //사실은 interface를 써야하는데 생략
   
   @RequestMapping("index")
   @ResponseBody
   public Map<String, Object> listProcess(@RequestParam("buser_name") String buser_name) throws SQLException{
      List<Map<String,String>> list = new ArrayList<Map<String,String>>();
      Map<String, String> data = null;
      List<SangpumDto> sangList = dataDao.getDataAll(buser_name);
      /*List<SangpumDto> sangList2 = dataDao.getDataAll3("홍길동", "1");
      for(SangpumDto s : sangList){
    	  System.out.println(s.getSawon_no());
      }*/
      for(SangpumDto s : sangList){
    	  data = new HashMap<String, String>();
    	  data.put("sawon_no", s.getSawon_no());
    	  data.put("sawon_name", s.getSawon_name());
    	  data.put("buser_tel", s.getBuser_tel());
    	  data.put("sawon_jik", s.getSawon_jik());
    	  data.put("sawon_count", s.getSawon_count());
    	  System.out.println(s.getSawon_name());
    	  list.add(data);
      }
      Map<String, Object> sangdata = new HashMap<String, Object>();
      sangdata.put("datas", list);
      return sangdata;
   }
   
   @RequestMapping("index2")
   @ResponseBody
   public Map<String, Object> listProcess2(@RequestParam("sawon_name") String sawon_name){
      List<Map<String,String>> list = new ArrayList<Map<String,String>>();
      Map<String, String> data = null;
      List<GogekDto> sangList = dataDao.getDataAll2(sawon_name);
      
      for(GogekDto s : sangList){
    	  data = new HashMap<String, String>();
    	  data.put("gogek_no", s.getGogek_no());
    	  data.put("gogek_name", s.getGogek_name());
    	  data.put("gogek_tel", s.getGogek_tel());
    	  data.put("gogek_jumin", s.getGogek_jumin());
    	  list.add(data);
      }
      Map<String, Object> sangdata2 = new HashMap<String, Object>();
      sangdata2.put("datas2", list);
      return sangdata2;
   }
   
}