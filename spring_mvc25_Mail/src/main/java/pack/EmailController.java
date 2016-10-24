package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {
	@Autowired
	private EmailSender sender;
	
	@RequestMapping(value="send", method=RequestMethod.GET)
	public String formbank(){
		return "mailform";
	}
	
	@RequestMapping(value="send", method=RequestMethod.POST)
	public String formbank2(@RequestParam("receiver")String receiver,@RequestParam("subject")String subject,@RequestParam("content")String content) throws Exception{
		Email email = new Email();
		email.setReceiver(receiver);
		email.setSubject(subject);
		email.setContent(content);
		sender.sendEmail(email);
		return "success";
	}
}
