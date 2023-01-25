/*
 * Copyright Owliance © 2016 - 28 sept. 2016 ,All right reserved <p>Owliance
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.owliance.owlink.access.utils;


import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.soap.server.endpoint.SoapFaultDefinition;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;


/**
 * Description of the class OwlinkSoapSpringConfig
 *
 * @author hbenizid
 * @since 0.2.0-Alpha
 * 
 * @see com.owliance.owlink.access.utils
 *
 *      <p>
 *      Created : 28 sept. 2016
 *      <p>
 *      Updated : 28 sept. 2016 by hbenizid (version 0.2.0-Alpha)
 * 
 */
@EnableWs
@Configuration
public class OwlinkSoapSpringConfig extends WsConfigurerAdapter {

	/**
	 * Exception resolver soap fault mapping exception resolver.
	 *
	 * @return the soap fault mapping exception resolver
	 */
	@Bean
	public SoapFaultMappingExceptionResolver exceptionResolver() {

		SoapFaultMappingExceptionResolver exceptionResolver = new OwlinkSoapFaultDefinitionExceptionResolver();

		SoapFaultDefinition faultDefinition = new SoapFaultDefinition();
		faultDefinition.setFaultCode(SoapFaultDefinition.SERVER);
		exceptionResolver.setDefaultFault(faultDefinition);

		Properties errorMappings = new Properties();
		errorMappings.setProperty(Exception.class.getName(), SoapFaultDefinition.SERVER.toString());
		errorMappings.setProperty(OwlinkSoapFaultException.class.getName(), SoapFaultDefinition.SERVER.toString());

		exceptionResolver.setExceptionMappings(errorMappings);
		exceptionResolver.setOrder(1);
		return exceptionResolver;
	}

}
