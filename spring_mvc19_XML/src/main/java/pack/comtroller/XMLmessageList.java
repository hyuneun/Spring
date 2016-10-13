package pack.comtroller;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="msg-list")//root element name
public class XMLmessageList {
	
	@XmlElement(name="msg")//element name
	private List<Xmlmessage> message;
	
	public XMLmessageList() {
	
	}
	
	public XMLmessageList(List<Xmlmessage> message) {
		this.message = message;
	}
	
	public List<Xmlmessage> getMessage() {
		return message;
	}
}
