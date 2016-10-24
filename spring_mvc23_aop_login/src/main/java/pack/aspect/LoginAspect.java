package pack.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

@Repository
public class LoginAspect {
	public boolean logincheck(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		
		if(session.getAttribute("name") == null){
			response.sendRedirect("login");
			return false;
		}else{
			return true;
		}
	}
}
