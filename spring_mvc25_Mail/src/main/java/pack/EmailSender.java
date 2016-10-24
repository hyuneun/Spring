package pack;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(Email email) throws Exception{
		MimeMessage msg = javaMailSender.createMimeMessage();//메일발송기능
		msg.setSubject(email.getSubject());//제목
		msg.setText(email.getContent());//내용
		msg.setRecipient(RecipientType.TO, new InternetAddress(email.getReceiver()));//대상
		javaMailSender.send(msg);
	}
}




