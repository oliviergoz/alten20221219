/*
 * Copyright Owliance © 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.framework.entity;

/**
 * Class base for all VO objects
 *
 * @author fmartinez
 * @since 0.1.5-Alpha
 * @see BaseObject
 *      <p>
 *      Created : 08 juil 2016
 *      </p>
 *      <p>
 *      Updated : 13 juil 2016 by hbenizid (version 0.1.5-Alpha)
 *      <p>
 *      Updated : 23 juil 2016 by fmartinez (version 0.2.3-Alpha)
 */
public class BaseVO extends BaseObject implements java.io.Serializable {

	private static final long	serialVersionUID = -1786729758109159427L;

	/**
	 * Suffix utilisé pour désigner les classes héritant de <code>BaseVO</code>.
	 */
	public static final String	CLASS_SUFFIX	  = "VO";

	/**
	 * Norme de nommage de l'attribut constituant la clé primaire (pk)
	 */
	public static final String	ID_NAME			  = "id";

	/**
	 * Constructor.
	 */
	public BaseVO() {
		super();
	}
}
