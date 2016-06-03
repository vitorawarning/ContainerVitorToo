package br.dftrans.wiki.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.dftrans.wiki.domain.Usuario;

/**
 * Servlet Filter implementation class HierarqFilter
 */
public class HierarqFilter implements Filter {

    /**
     * Default constructor. 
     */
    public HierarqFilter() {
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
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession sessao = req.getSession(false);

		if(sessao == null || (sessao.getAttribute("usuario") == null) ){
			resp.sendRedirect("../login.xhtml");
		}else{
			Usuario user = (Usuario) sessao.getAttribute("usuario");
			if(user.getTipoAcesso().getTipo() != 1){
				resp.sendRedirect("../login.xhtml");
			}
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
