/*
 * Copyright Owliance © 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.framework.common;


import com.owliance.owlink.framework.constants.OwlinkError;


/**
 * ErrorInfo define the structure of reject message.
 *
 * @author hbenizid
 * @see com.owliance.owlink.framework.common
 *      <p>
 *      Created : 10 mai. 2016
 *      <p>
 *      Updated : 4 juil. 2016 by hbenizid (version 0.1.5-Alpha)
 *      <p>
 *      Updated : 09 aout 2016 by hbouslah (version 0.1.6-Alpha)
 *      <p>
 *      Updated : 22 août 2016 by hbenizid (version 0.2.0-Alpha)
 * @since 0.1.3 -Alpha
 */
public class ErrorInfo {

	private String	code;
	private String	message;
	private String	technicalMessage;
	private String	url;

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {

		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the url to set
	 */
	public void setUrl(String url) {

		this.url = url;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {

		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the message to set
	 */
	public void setMessage(String message) {

		this.message = message;
	}

	/**
	 * Gets code.
	 *
	 * @return the code
	 */
	public String getCode() {

		return code;
	}

	/**
	 * Sets code.
	 *
	 * @param code the code to set
	 */
	public void setCode(String code) {

		this.code = code;
	}

	/**
	 * Gets technical message.
	 *
	 * @return the technicalMessage
	 */
	public String getTechnicalMessage() {

		return technicalMessage;
	}

	/**
	 * Sets technical message.
	 *
	 * @param technicalMessage the technicalMessage to set
	 */
	public void setTechnicalMessage(String technicalMessage) {

		this.technicalMessage = technicalMessage;
	}

	/**
	 * Sets error.
	 *
	 * @param owlinkError the owlink error
	 */
	public void setError(OwlinkError owlinkError) {

		this.code = owlinkError.getCode();
		this.message = owlinkError.getReason();
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "ErrorInfo [" + (code != null ? "code=" + code + ", " : "")
				+ (message != null ? "message=" + message + ", " : "")
				+ (technicalMessage != null ? "technicalMessage=" + technicalMessage + ", " : "")
				+ (url != null ? "url=" + url : "") + "]";
	}

}
