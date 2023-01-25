/*
 * Copyright Owliance © 2016 - 2017 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.exception;

/**
 * Description of the Class OwlinkCustomException.
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
 *      Updated : 09 aout. 2016 by hbouslah (version 0.1.6-Alpha)
 *      <p>
 *      Updated : 14 oct. 2016 by hbenizid (version 0.2.2-Alpha)
 */
public abstract class OwlinkCustomException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8278942199710255741L;

	/** The code. */
	private String				  code;

	/** The technical message. */
	private String				  technicalMessage;

	/**
	 * Instantiates a new owlink custom exception.
	 */
	public OwlinkCustomException() {
		super();
	}

	/**
	 * Instantiates a new owlink custom exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public OwlinkCustomException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new owlink custom exception.
	 *
	 * @param message the message
	 */
	public OwlinkCustomException(String message) {
		super(message);
	}

	/**
	 * Constructs a new OwlinkCustomException with the specified detail code, message and
	 * technicalMessage.
	 *
	 * @param code the code
	 * @param message the message
	 * @param technicalMessage the technical message
	 */

	public OwlinkCustomException(String code, String message, String technicalMessage) {
		super(message);
		this.code = code;
		this.technicalMessage = technicalMessage;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {

		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the code to set
	 */
	public void setCode(String code) {

		this.code = code;
	}

	/**
	 * Gets the technical message.
	 *
	 * @return the technicalMessage
	 */
	public String getTechnicalMessage() {

		return technicalMessage;
	}

	/**
	 * Sets the technical message.
	 *
	 * @param technicalMessage the technicalMessage to set
	 */
	public void setTechnicalMessage(String technicalMessage) {

		this.technicalMessage = technicalMessage;
	}

}
