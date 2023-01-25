/*
 * Copyright Owliance © 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.framework.entity;

/**
 * Class base for all UI objects
 *
 * @author fmartinez
 * @since 0.3.2-Alpha
 * @see BaseObject
 *      <p>
 *      Created : 12 dec. 2016
 *      </p>
 *      <p>
 *      Updated : xx xxxx xxxx by xxxxx (version 0.x.x)
 */
public class BaseUI extends BaseObject implements java.io.Serializable {

	/**
	 * long
	 */
	private static final long	serialVersionUID = -3582104836754524697L;

	/**
	 * Suffix utilisé pour désigner les classes héritant de <code>BaseUI</code>.
	 */
	public static final String	CLASS_SUFFIX	  = "UI";

	/**
	 * Constructor.
	 */
	public BaseUI() {
		super();
	}
}
