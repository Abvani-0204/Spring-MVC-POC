package com.pp.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.apache.log4j.Logger;
import com.pp.model.User;

@Component
public class SessionInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = Logger.getLogger(SessionInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("inside pre handle method of Session called at 1");
		
		User usrlog=(User)request.getSession().getAttribute("LoginSession");
		
		if (usrlog == null || usrlog.equals("")) {
			response.sendRedirect("userSignIn.do");
			return false;
		}
		logger.info("This is preHandle in Session Interceptor !");
		return true;
		}
	
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		System.out.println("inside post handle method of Session called at 2");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{
		System.out.println("inside after completion method of Session called at 3");
	}	
}
