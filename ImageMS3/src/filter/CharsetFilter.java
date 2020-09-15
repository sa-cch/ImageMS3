package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class CharsetFilter
 */
@WebFilter("/*")
public class CharsetFilter implements Filter {

    /**
     * Default constructor.
     */
    public CharsetFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		// 前処理（文字エンコーディングの設定）
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		// 前処理2
		/*PrintWriter out = response.getWriter();
		out.println("<p>前処理</p>");*/

		// pass the request along the filter chain
		chain.doFilter(request, response);

		// 後処理
		/*out.println("<p>後処理</p>");*/
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
