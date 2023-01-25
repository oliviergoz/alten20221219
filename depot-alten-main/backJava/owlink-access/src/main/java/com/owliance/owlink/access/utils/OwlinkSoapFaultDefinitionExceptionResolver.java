/*
 * Copyright Owliance © 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.access.utils;


import javax.xml.namespace.QName;

import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;


/**
 * Description of the Class OwlinkSoapFaultDefinitionExceptionResolver.
 *
 * @author hbenizid
 * @since 0.2.0-Alpha
 * @see com.owliance.owlink.access.utils
 * 
 *      <p>
 *      Created : 28 sept. 2016
 *      <p>
 *      Updated : 28 sept. 2016 by hbenizid (version 0.2.0-Alpha)
 */
public class OwlinkSoapFaultDefinitionExceptionResolver extends SoapFaultMappingExceptionResolver {

	private static final QName	CODE			= new QName("code");
	private static final QName	DESCRIPTION	= new QName("description");

	/*
	 * @see org.springframework.ws.soap.server.endpoint.AbstractSoapFaultDefinitionExceptionResolver#
	 * customizeFault(java.lang.Object, java.lang.Exception, org.springframework.ws.soap.SoapFault)
	 */
	@Override
	protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {

		logger.warn("SOAP Exception processed");
		if (ex instanceof OwlinkSoapFaultException) {
			OwlinkSoapFaultMessage messageServiceFault = ((OwlinkSoapFaultException) ex).getServiceFault();
			SoapFaultDetail detail = fault.addFaultDetail();
			detail.addFaultDetailElement(CODE).addText(messageServiceFault.getCode());
			detail.addFaultDetailElement(DESCRIPTION).addText(messageServiceFault.getDescription());
		}
	}

}
