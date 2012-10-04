package hattari.web.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technobel.domain.entity.User;


public class HattariFilter implements Filter {


    public HattariFilter() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}


	@SuppressWarnings("unused")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		HttpServletRequest httpRequest = (HttpServletRequest)request;
//		HttpServletResponse httpResponse = (HttpServletResponse)response;
//
//		User loggedUser = (User) httpRequest.getSession().getAttribute("loggedUser");
//		
//		String error = null;
//		System.out.println("------------------------  " + httpRequest.getServletPath());
//		if(httpRequest.getServletPath().contains("index")){
//			if(loggedUser!=null){
//				error = "You are already logged with username '"+loggedUser.getUsername()+"' !";
//				request.setAttribute("error", error);
//				request.getRequestDispatcher("/Index").forward(request, response);
//				return;
//			}
//		}
//		
//		if(error!=null && !error.isEmpty()){
//			request.setAttribute("error", error);
//			request.setAttribute("wantedUrl", httpRequest.getServletPath());
//			httpRequest.getRequestDispatcher("/index.jsp").forward(httpRequest, httpResponse);
//		}
//		else{
			chain.doFilter(request, response);
//		}
		

	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
