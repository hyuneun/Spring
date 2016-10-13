package pack.comtroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class XmlController {
   @RequestMapping(value="member_xml", method=RequestMethod.GET)
   public String formBack(){
      return "myform";
   }
   
   @RequestMapping(value="member_xml", method=RequestMethod.POST)
   @ResponseBody
   public XMLmessageList abc(@RequestParam("name") String name ,@RequestParam("age") String age){
	   return getxml(name, age);
   }
   
   public XMLmessageList getxml(String name,String age){
	   List<Xmlmessage> meXmlmessages = Arrays.asList(//들어오는놈들을 리스트로변환해줌
			   new Xmlmessage(name,age),
			   new Xmlmessage("oscar","32"),
			   new Xmlmessage("moonjong","32")
			   );
	   return new XMLmessageList(meXmlmessages);
   }
}