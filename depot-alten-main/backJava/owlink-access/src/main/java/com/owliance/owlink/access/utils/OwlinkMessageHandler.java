/*
 * Copyright Owliance © 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.access.utils;


import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;


/**
 * Description of the class OwlinkMessageHandler.java
 *
 * @author hbenizid
 * @since 0.3.0-Alpha
 * 
 * @see com.owliance.owlink.access.utils
 *
 *      <p>
 *      Created : 3 nov. 2016
 *      <p>
 *      Updated : 3 nov. 2016 by hbenizid (version 0.3.0-Alpha)
 *      <p>
 *      Updated : 7 nov. 2016 by hbenizid (version 0.3.0-Alpha)
 *
 */
public class OwlinkMessageHandler {

	@Autowired
	private ReloadableResourceBundleMessageSource messageSource;

	/**
	 * Default Mode is INFO
	 */
	private static final Logger						 logger = LoggerFactory.getLogger(OwlinkMessageHandler.class);

	/**
	 * Gets message.
	 *
	 * @param key the key
	 * @return {@link String} 11:56:20 by hbenizid
	 */
	public String getMessage(String key) {

		try {
			String message = messageSource.getMessage(key, null, Locale.FRANCE);
			logger.info("#### MESSAGEERROR = {} ####", message);
			return message;
		}
		catch (Exception e) {
			logger.error("Unresolved key ", e);
			return "Unresolved key : " + key;
		}

	}

}
