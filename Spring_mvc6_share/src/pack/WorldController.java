package pack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class WorldController implements Controller{
	private ShareData data;
	
	public void setData(ShareData data) {
		this.data = data;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView view = new ModelAndView();
		view.addObject("msg","Hello" + data.getShared());
		view.setViewName("list");
		return view;
	}

}
