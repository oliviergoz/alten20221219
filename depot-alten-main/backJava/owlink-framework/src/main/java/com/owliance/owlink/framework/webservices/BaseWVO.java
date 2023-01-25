/*
 * Copyright Owliance © 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.framework.webservices;

import com.owliance.owlink.framework.entity.BaseObject;

/**
 * Class base for all WVO objects
 *
 * @author fmartinez
 * @since 0.1.5-Alpha
 * @see com.owliance.owlink.framework.webservices
 * 
 *      <p>
 *      Created : 08 juil 2016
 *      <p>
 *      Updated : 13 juil 2016 by hbenizid (version 0.1.5-Alpha)
 */
public abstract class BaseWVO extends BaseObject implements java.io.Serializable {

	private static final long	serialVersionUID = -7995362451937163348L;

	/**
	 * Suffix utilisé pour désigner les classes héritant de <code>BaseWVO</code>.
	 */
	public static final String	CLASS_SUFFIX	  = "WVO";

	/**
	 * Constructor.
	 */
	protected BaseWVO() {
		/*
		 * empty
		 */
	}
}
