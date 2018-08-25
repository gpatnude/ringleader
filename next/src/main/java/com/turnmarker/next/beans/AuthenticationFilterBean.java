package com.turnmarker.next.beans;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@Component
@Order(0)
public class AuthenticationFilterBean extends AbstractBean implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8592924875474194043L;
	
	@SuppressWarnings("unused")
	private FilterConfig fc;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
  
    	// CAST INTO SOMETHING WE CAN MANIPULATE:
        HttpServletRequest req = (HttpServletRequest) request;
        Map<String, String[]> params = request.getParameterMap();

        // if (req.getHeader("x-turn-nonce") == null || req.getHeader("x-signature-signature") == null) {
        // if (req.getHeader("TURN") == null) {
        // if (req.getParameter("TURN") == null ) {
        if (params.get("TURN") == null) {
        	
        	trace("AuthenticationFilterBean::doFilter() --> HttpServletRequest is missing a required parameter.");

        	// JUST FUCKING GO-AWAY:
        	response.reset();
        	// response.getOutputStream().close();
        
        	// INSTANTIATE:
        	HttpServletResponse res = (HttpServletResponse) response;
        	
        	// CONFIGURE:
            // res.setContentType("application/json");
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Required headers not specified in the request");
            
            // GOODBYE, CRUEL WORLD:
            res.getOutputStream().flush();

        	// JUST FUCKING GO-AWAY:
            res.getOutputStream().close();
        	
            // AND RETURN:
            return;
        
        } else {
        	
        	trace("AuthenticationFilterBean::doFilter() --> Required parameter located on HttpServletRequest.");
        	
        }

        // OTHERWISE:
        chain.doFilter(request, response);
    
    }

	@Override
	public void destroy() {
		
		trace("AuthenticationFilterBean::destroy() --> Method called");
		
	}

	@Override
	public void init(FilterConfig conf) throws ServletException {
		
		trace("AuthenticationFilterBean::init() --> Method called");

		// STORE:
		this.fc = conf;
		
	}

}