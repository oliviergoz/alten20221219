/*
 * Copyright Owliance © 2016 - 2017 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.exception;


import com.owliance.owlink.framework.constants.OwlinkError;


/**
 * Description of the Class OwlinkException.
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
 *      Updated : 9 aout. 2016 by hbouslah (version 0.1.6-Alpha)
 *      <p>
 *      Updated : 9 sept. 2016 by hbenizid (version 0.2.0-Alpha)
 *      <p>
 *      Updated : 14 oct. 2016 by hbenizid (version 0.2.2-Alpha)
 */
public class OwlinkException extends OwlinkCustomException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7174873124320492300L;

	/**
	 * Instantiates a new owlink exception.
	 */
	public OwlinkException() {
		super();
	}

	/**
	 * Instantiates a new owlink exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public OwlinkException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new owlink exception.
	 *
	 * @param message the message
	 */
	public OwlinkException(String message) {
		super(message);
	}

	/**
	 * Constructs a new OwlinkException with the specified detail code, message and technicalMessage.
	 *
	 * @param code the code
	 * @param message the message
	 * @param technicalMessage the technical message
	 */
	public OwlinkException(String code, String message, String technicalMessage) {
		super(code, message, technicalMessage);
	}

	/**
	 * Instantiates a new owlink exception.
	 *
	 * @param owlinkError the owlink error
	 * @param technicalMessage the technical message
	 */
	public OwlinkException(OwlinkError owlinkError, String technicalMessage) {
		super(owlinkError.getCode(), owlinkError.getReason(), technicalMessage);
	}
}
