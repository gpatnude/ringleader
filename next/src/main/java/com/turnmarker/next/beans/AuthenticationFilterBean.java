
package com.turnmarker.next.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.turnmarker.next.models.DistributedSessionModel;
import com.turnmarker.next.models.PayloadModel;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

@Component
@Order(0)
public class AuthenticationFilterBean extends AbstractBean implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8592924875474194043L;

	@SuppressWarnings("unused")
	private FilterConfig fc;

	// TODO: CHANGE THIS SO THAT SESSION's ARE STORED/RETRIEVED FROM A DISTRIBUTED-SESSION-MAP:
	@Autowired
	private DistributedSessionModel sessions; // = DistributedSessionModel.getInstance();

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// CAST INTO SOMETHING WE CAN MANIPULATE:
		HttpServletRequest req = (HttpServletRequest) request;
		Map<String, String[]> params = request.getParameterMap();

		// SESSION's ARE STORED/RETRIEVED FROM THE DISTRIBUTED-SESSION-MAP:
		HttpSession session = req.getSession(false);

		if ((null != session) && (sessions.contains(session.getId()))) {

			getLogger().warn("I found your session: " + session.getId());

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

	// LOGGER IMPLEMENTATION:
	protected Logger logger = LoggerFactory.getLogger(PayloadModel.class);

	protected Logger getLogger() {

		return logger;

	}

	protected void setLogger(Logger logger) {

		this.logger = logger;

	}

}
