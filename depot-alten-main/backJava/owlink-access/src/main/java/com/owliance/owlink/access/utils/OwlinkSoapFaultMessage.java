/*
 * Copyright Owliance © 2016 - 28 sept. 2016 ,All right reserved <p>Owliance
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.owliance.owlink.access.utils;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Description of the class ...
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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OwlinkSoapFaultMessage", propOrder = { "code", "description" })
public class OwlinkSoapFaultMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6785493113542403066L;
	private String				  code;
	private String				  description;

	/**
	 * Instantiates a new service fault.
	 */
	public OwlinkSoapFaultMessage() {
		/*
		 * empty
		 */
	}

	/**
	 * Instantiates a new service fault.
	 *
	 * @param code the code
	 * @param description the description
	 */
	public OwlinkSoapFaultMessage(String code, String description) {
		this.code = code;
		this.description = description;
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
	 * @param code the new code
	 */
	public void setCode(String code) {

		this.code = code;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {

		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {

		this.description = description;
	}
}
