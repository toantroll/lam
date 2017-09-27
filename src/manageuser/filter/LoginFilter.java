/**
 * Copyright(C) 2017 Jul 12, 2017 Luvina
 * CharacterEncodingFilter.java, Jul 12, 2017, CTA
 */
package manageuser.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manageuser.utils.Common;

/**
 * Class Filter xử lý kiểm tra login cho các trang.
 * 
 * @author CTA
 *
 */
@WebFilter(urlPatterns = "*.do")
public class LoginFilter implements Filter {
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse respone = (HttpServletResponse) resp;
		HttpSession session = request.getSession(false);
		if ("success".equals(Common.checkLogin(session))) {
			// Cho phép request vượt qua Filter
			chain.doFilter(req, resp);
		} else {
			respone.sendRedirect(request.getContextPath() + "/login");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}