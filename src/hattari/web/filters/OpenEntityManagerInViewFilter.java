package hattari.web.filters;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.transaction.UserTransaction;

public class OpenEntityManagerInViewFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		UserTransaction tx = null;

		try {
			tx = (UserTransaction) new InitialContext()
					.lookup("java:comp/UserTransaction");
			
			tx.begin();
			filterChain.doFilter(request, response);
			tx.commit();
		} catch (Exception exception) {
			if (tx != null) {
				try {
					tx.rollback();
				} catch (Exception e) {
                     System.out.println(e.getMessage());
				}
			}
		} 
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

}
