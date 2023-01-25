/*
 * Copyright Owliance © 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.access.utils;

/**
 * Description of the class MessageFaultSOAPException
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
public class OwlinkSoapFaultException extends RuntimeException {

	/**
	 * 
	 */
	private static final long				 serialVersionUID	= 4440805642765824112L;
	private final OwlinkSoapFaultMessage serviceFault;

	/**
	 * Instantiates a new owlink custom exception.
	 *
	 * @param serviceFault the service fault
	 */
	public OwlinkSoapFaultException(OwlinkSoapFaultMessage serviceFault) {
		super();
		this.serviceFault = serviceFault;
	}

	/**
	 * Instantiates a new service fault exception.
	 *
	 * @param message the message
	 * @param serviceFault the service fault
	 */
	public OwlinkSoapFaultException(String message, OwlinkSoapFaultMessage serviceFault) {
		super(message);
		this.serviceFault = serviceFault;
	}

	/**
	 * Instantiates a new service fault exception.
	 *
	 * @param message the message
	 * @param e the e
	 * @param serviceFault the service fault
	 */
	public OwlinkSoapFaultException(String message, Throwable e, OwlinkSoapFaultMessage serviceFault) {
		super(message, e);
		this.serviceFault = serviceFault;
	}

	/**
	 * Gets service fault.
	 *
	 * @return the serviceFault
	 */
	public OwlinkSoapFaultMessage getServiceFault() {

		return serviceFault;
	}

}
