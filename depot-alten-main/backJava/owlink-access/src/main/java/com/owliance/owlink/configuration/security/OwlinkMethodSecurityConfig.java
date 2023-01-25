/*
 * Copyright Owliance 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.configuration.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;


/**
 * Description of the class OwlinkMethodSecurityConfig.java
 *
 * @author hbenizid
 * @since 0.3.1-Alpha
 * 
 * @see com.owliance.owlink.configuration.security
 *
 *      <p>
 *      Created : 21 nov. 2016
 *      <p>
 *      Updated : 28 nov. 2016 by hbenizid (version 0.3.1-Alpha)
 *
 */
@SuppressWarnings(value = "unused")
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class OwlinkMethodSecurityConfig extends GlobalMethodSecurityConfiguration {

	/** The security config. */
	@Autowired
	private SecurityConfiguration securityConfig;

	/*
	 * @see org.springframework.security.config.annotation.method.configuration.
	 * GlobalMethodSecurityConfiguration# createExpressionHandler()
	 */
	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {

		return new OAuth2MethodSecurityExpressionHandler();
	}
}
