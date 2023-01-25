/*
 * Copyright Owliance © 2016 - 2017 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.exception;

/**
 * Description of the Class OwlinkHandlerException.
 *
 * @author hbenizid
 * @since 0.1.2-Alpha
 * @see com.owliance.owlink.exception
 * 
 *      <p>
 *      Created : 25 avr. 2016
 *      <p>
 *      Updated : 4 juil. 2016 by hbenizid (version 0.1.5-Alpha)
 *      <p>
 *      Updated : 14 oct. 2016 by hbenizid (version 0.2.2-Alpha)
 */

@Deprecated
public class OwlinkHandlerException extends OwlinkException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1897315115147132706L;

	/**
	 * Instantiates a new owlink handler exception.
	 */
	public OwlinkHandlerException() {
		super();
	}

	/**
	 * Instantiates a new owlink handler exception.
	 *
	 * @param message the message
	 */
	public OwlinkHandlerException(String message) {
		super(message);
	}
}
