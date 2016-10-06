package pack.model;

import org.springframework.stereotype.Component;

import pack.controller.SangpumBean;

@Component
public class SangpumModel {
	public String computer(SangpumBean bean){
		String ss = "품명" + bean.getSang() + " " + "금액" + (bean.getSu() * bean.getDan());
		return ss;
 	}
}
