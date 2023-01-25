/*
 * Copyright Owliance Â© 2016 - 2017 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use
 * is subject to license terms.
 */
package com.owliance.owlink.framework.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Description of the Retention CheckVerrou.
 *
 * @author ozarrougui
 * @since 0.5.1-Alpha
 * @see com.owliance.owlink.framework.annotation
 *
 *      <p>
 *      Created : 9 août 2017
 *      <p>
 *      Updated : 9 août 2017 by ozarrougui (version 0.5.1-Alpha)
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckVerrou {

	/**
	 * the Type object
	 * @return the Type object
	 */
	String typeObject() default "FamVO";

	/**
	 * Id fonct pattern.
	 * @return the id fonct pattern
	 */
	String idFonctPatern() default "idFam";

	/**
	 * Complex id.
	 * @return Complex id.
	 */
	boolean complexId() default false;

}
