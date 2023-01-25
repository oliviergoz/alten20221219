/*
 * Copyright Owliance © 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.access.utils;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.MDC;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


/**
 * MDC stands for Mapped Diagnostic Context, and is a feature that is offered by both plain Log4J
 * and SLF4J with Logback or Log4J as the backing logging framework. It is a map that holds String
 * values keyed by Strings, which is associated with the current thread (using a ThreadLocal).
 * 
 * In this class we will add entries to the MDC; typically these represent info about the context of
 * the current request, like the user and IP address, which will be used for logging.
 *
 * @author hbouslah
 * @since 0.3.2-Alpha
 * @see com.owliance.owlink.access.utils
 * 
 *      <p>
 *      Created : 21 dec. 2016
 */
public class MDCFilter implements Filter {

	/*
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {
			/*
			 * get IP request
			 */
			MDC.put("ipAddress", request.getRemoteAddr());
			/*
			 * get PC name
			 */
			// InetAddress addr = InetAddress.getByName(request.getRemoteAddr())
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication != null) {
				MDC.put("user", authentication.getName());
			}

			/*
			 * get host Name
			 */
			MDC.put("hostName", request.getServerName());
			chain.doFilter(request, response);
		}
		finally {
			MDC.remove("ipAddress");
			MDC.remove("hostName");
			MDC.remove("user");
			MDC.clear();
		}
	}

	/*
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {

		/*
		 * 
		 */
	}

	/*
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {

		/*
		 * 
		 */
	}
}
