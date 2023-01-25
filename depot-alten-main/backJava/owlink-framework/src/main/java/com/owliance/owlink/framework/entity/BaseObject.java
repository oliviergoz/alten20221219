/*
 * Copyright Owliance © 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.framework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.owliance.owlink.framework.exception.BaseException;
import com.owliance.owlink.framework.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyDescriptor;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;

/**
 * Class base for Data transfer object
 *
 * @author fmartinez
 * @since 0.1.5-Alpha
 * @see com.owliance.owlink.framework.entity
 *
 *      <p>
 *      Created : 08 juil 2016
 *      <p>
 *      Updated : 13 juil 2016 by hbenizid (version 0.1.5-Alpha)
 *      <p>
 *      Updated : 31 aout 2016 by fmartinez (version 0.2.2-Alpha)
 *      <p>
 *      Updated : 26 dec. 2016 by hbenizid (version 0.3.2-Alpha)
 *      <p>
 *      Updated : 10 mar. 2017 by fmartinez (version 0.3.6-Alpha) : new generic methods set(), get()
 *      <p>
 *      Updated : 13 mar. 2017 by fmartinez (version 0.3.6-Alpha) : new method isInheritingClass()
 */
public class BaseObject implements java.io.Serializable {

	private static final long	 serialVersionUID	= -6451257118941830845L;

	/** The <code>Logger</code> instance for this class. */
	private static final Logger logger				= LoggerFactory.getLogger(BaseObject.class);

	/**
	 * Sets the value of an attribute on the current object.
	 *
	 * @param attribute Attribute name
	 * @param value New value
	 *
	 *           <p>
	 *           Example : <code>bvo.set("id", new Long(1))</code>
	 *           <p>
	 *           Created : 10 mar. 2017 by fmartinez (version 0.3.6-Alpha)
	 *           <p>
	 *           updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	public void set(String attribute, Object value) {

		BaseObject.set(this, attribute, value);
	}

	/**
	 * Sets the value of an attribute on this object.
	 *
	 * @param o Object
	 * @param attribute Attribute name
	 * @param value New value
	 *
	 *           <p>
	 *           Example : <code>BaseObject.set(bvo, "id", new Long(1))</code>
	 *           <p>
	 *           Created : 10 mar. 2017 by fmartinez (version 0.3.6-Alpha)
	 *           <p>
	 *           updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	public static void set(Object o, String attribute, Object value) {

		if (o == null) {
			throw new IllegalArgumentException("set(Object o, String attribute, Object value) : o == null");
		}
		if (attribute == null || attribute.trim().length() == 0) {
			throw new IllegalArgumentException(
					"set(Object o, String attribute, Object value) : attribute == null || attribute.trim().length() == 0");
		}

		try {
			if (!hasBeanSetter(o, attribute)) {
				throw new IllegalArgumentException(
						"set(Object o, String attribute, Object value) - No setter found for property [" + attribute
								+ "] in class [" + o.getClass() + "].");
			}
			else {
				Method setter = getBeanSetter(o, attribute);
				if (setter != null) {
					setter.invoke(o, new Object[]{value});
				}
				else {
					throw new IllegalArgumentException("Bean setter is undefined for property [" + attribute
							+ "] in class [" + o.getClass() + "].");
				}
			}
		}
		catch (Exception e) {
			logger.warn("set(Object o, String attribute, Object value) - " + BaseException.toStringStackTrace(e));
			throw new IllegalArgumentException(BaseException.toStringStackTrace(e));
		}
	}

	/**
	 * Sets the value of an attribute on this object.
	 *
	 * @param o Object
	 * @param attribute Attribute name
	 * @param value New value
	 *
	 *           <p>
	 *           Example : <code>BaseObject.set(bvo, "id", "1"))</code>
	 *           <p>
	 *           Created : 10 mar. 2017 by fmartinez (version 0.3.6-Alpha)
	 *           <p>
	 *           updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	@SuppressWarnings("rawtypes")
	public static void set(Object o, String attribute, String value) {

		if (o == null) {
			throw new IllegalArgumentException("set(Object o, String attribute, String value) : o == null");
		}
		if (attribute == null || attribute.trim().length() == 0) {
			throw new IllegalArgumentException(
					"set(Object o, String attribute, String value) : attribute == null || attribute.trim().length() == 0");
		}

		try {
			Method setter;
			String searchattribute = attribute;
			if (!hasBeanSetter(o, searchattribute)) {
				throw new IllegalArgumentException(
						"set(Object o, String attribute, String value) - No setter found for property [" + searchattribute
								+ "] in class [" + o.getClass() + "].");
			}
			else {
				Class fieldClass = BaseObject.getClass(o.getClass(), searchattribute);
				setter = getBeanSetter(o, searchattribute);
				if (setter != null) {
					if (fieldClass == null && setter.getParameterTypes().length > 0) {
						// Cas ou le setter est déclaré mais aucun Field n'est déclaré : récupération du
						// premier type Class trouvé en paramètre du Setter
						fieldClass = setter.getParameterTypes()[0];
					}
					Object newvalue = toType(fieldClass, value);
					setter.invoke(o, new Object[] { newvalue });
				}
				else {
					throw new IllegalArgumentException("Bean setter is undefined for property [" + attribute
							+ "] in class [" + o.getClass() + "].");
				}
			}
		}
		catch (Exception e) {
			logger.warn("set(Object o, String attribute) - " + BaseException.toStringStackTrace(e));
			throw new IllegalArgumentException(BaseException.toStringStackTrace(e));
		}
	}

	/**
	 * Gets the value of an attribute on the current object.
	 *
	 * @param attribute Attribute name
	 * @return {@link Object}
	 *
	 *         <p>
	 *         Example : <code>bvo.get("id")</code> returns 1
	 *         <p>
	 *         Created : 10 mar. 2017 by fmartinez (version 0.3.6-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	public Object get(String attribute) {

		return BaseObject.get(this, attribute);
	}

	/**
	 * Gets the value of a field on this object.
	 *
	 * @param o Object
	 * @param field Field
	 *
	 * @return {@link Object}
	 *
	 *         <p>
	 *         Example : <code>BaseObject.get(bvo, fielId)</code> returns 1
	 *         <p>
	 *         Created : 10 mar. 2017 by fmartinez (version 0.3.6-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	public static Object get(Object o, Field field) {

		if (field == null) {
			throw new IllegalArgumentException("get(Object o, Field field). field == null.");
		}
		return get(o, field.getName());
	}

	/**
	 * Gets the value of an attribute on this object.
	 *
	 * @param o Object
	 * @param attribute Attribute name
	 *
	 * @return {@link Object}
	 *
	 *         <p>
	 *         Example : <code>BaseObject.get(bvo, "id")</code> returns 1
	 *         <p>
	 *         Created : 10 mar. 2017 by fmartinez (version 0.3.6-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	public static Object get(Object o, String attribute) {

		if (o == null) {
			throw new IllegalArgumentException("get(Object o, String attribute) : o == null");
		}

		if (attribute == null || attribute.trim().length() == 0) {
			throw new IllegalArgumentException(
					"get(Object o, String attribute) : attribute == null || attribute.trim().length() == 0");
		}

		Object value = null;
		Method getter = null;

		try {
			String searchattribute = attribute;
			if (!hasBeanGetter(o, searchattribute)) {
				throw new IllegalArgumentException("get(Object o, String attribute) : No getter found for property ["
						+ searchattribute + "] in class [" + o.getClass() + "].");
			}
			else {
				getter = getBeanGetter(o, searchattribute);
				if (getter != null) {
					value = executeMethod(o, getter.getName(), null);
				}
				else {
					throw new IllegalArgumentException("Bean getter is undefined for property [" + searchattribute
							+ "] in class [" + o.getClass() + "].");
				}
			}
		}
		catch (Exception e) {
			logger.warn("get(Object o, String attribute) - " + BaseException.toStringStackTrace(e));
			throw new IllegalArgumentException(BaseException.toStringStackTrace(e));
		}
		return value;
	}

	/**
	 * Convert a string to an Object [Clazz].
	 *
	 * @param clazz the clazz
	 * @param value the value
	 * @return Object object 10:08:43 by hbenizid
	 */
	@SuppressWarnings("rawtypes")
	public static Object toType(Class clazz, String value) {

		Object obj = null;

		if (clazz == String.class) {
			obj = value;
		}
		else if (clazz == Byte.class || clazz == byte.class) {
			if (value != null) {
				obj = new Byte(value);
			}
			else if (clazz == byte.class) {
				obj = new Byte((byte) 0);
			}
		}
		else if (clazz == Character.class || clazz == char.class) {
			if (value != null) {
				obj = new Character(value.charAt(0));
			}
			else if (clazz == char.class) {
				obj = new Character(' ');
			}
		}
		else if (clazz == Short.class || clazz == short.class) {
			if (value != null) {
				obj = new Short(value);
			}
			else if (clazz == short.class) {
				obj = Short.valueOf((short) 0);
			}
		}
		else if (clazz == Integer.class || clazz == int.class) {
			if (value != null) {
				obj = new Integer(value);
			}
			else if (clazz == int.class) {
				obj = Integer.valueOf(0);
			}
		}
		else if (clazz == Long.class || clazz == long.class) {
			if (value != null) {
				obj = new Long(value);
			}
			else if (clazz == long.class) {
				obj = Long.valueOf(0L);
			}
		}
		else if (clazz == Float.class || clazz == float.class) {
			if (value != null) {
				obj = new Float(value);
			}
			else if (clazz == float.class) {
				obj = new Float(0.0);
			}
		}
		else if (clazz == Double.class || clazz == double.class) {
			if (value != null) {
				obj = new Double(value);
			}
			else if (clazz == double.class) {
				obj = Double.valueOf(0.0);
			}
		}
		else if (clazz == BigDecimal.class) {
			if (value != null) {
				obj = new BigDecimal(value);
			}
		}
		else if (clazz == Date.class) {
			if (value != null) {
				try {
					obj = DateUtil.toDate(value);
				}
				catch (ParseException e) {
					logger.info("Parsing Exception into Date");
					throw new IllegalArgumentException(
							"toTypedValue(Class clazz,  String value) - " + BaseException.toStringStackTrace(e));
				}
			}
		}
		else if (clazz == GregorianCalendar.class) {
			if (value != null) {
				try {
					obj = DateUtil.toGregorianCalendar(value);
				}
				catch (ParseException e) {
					logger.info("Parsing Exception into GregorianCalendar");
					throw new IllegalArgumentException(
							"toTypedValue(Class clazz, String value) - " + BaseException.toStringStackTrace(e));
				}
			}
		}
		else if (clazz == Timestamp.class) {
			if (value != null) {
				/*
				 * Timestamp "dd/MM/yyyy HH:mm:ss"
				 */
				try {
					obj = DateUtil.toTimestamp(value);
				}
				catch (ParseException e) {
					throw new IllegalArgumentException(
							"toTypedValue(Class  clazz, String value) - " + BaseException.toStringStackTrace(e));
				}
			}
		}
		else if (clazz == Object.class) {
			if (value != null) {
				obj = value;
			}
		}
		else {
			throw new IllegalArgumentException(
					"toTypedValue(Class clazz, String value) - class >" + clazz + "< not supported.");
		}
		return obj;
	}

	/**
	 * Test if an Object [Clazz] implements a certain interface.
	 *
	 * @param o Object
	 * @param interf Interface
	 * @return <code>true</code> : interface is implemented, <code>false</code> : interface is not
	 *         implemented
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 31 aout 2016 by fmartinez (version 0.2.3-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isImplementingInterface(Object o, Class interf) {

		if (o == null) {
			throw new IllegalArgumentException("isImplementingInterface (Object o, Class interf) : o is null");
		}
		if (interf == null) {
			throw new IllegalArgumentException("isImplementingInterface (Object o, Class interf) : interf is null");
		}
		return isImplementingInterface(o.getClass(), interf);
	}

	/**
	 * Test if an Object [Clazz] implements a certain interface.
	 *
	 * @param clazz Class
	 * @param interf Interface
	 *
	 * @return <code>true</code> : interface is implemented, <code>false</code> : interface is not
	 *         implemented
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 31 aout 2016 by fmartinez (version 0.2.3-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isImplementingInterface(Class clazz, Class interf) {

		if (clazz == null) {
			throw new IllegalArgumentException("isImplementingInterface (Class clazz, Class interf) : clazz is null");
		}
		if (interf == null) {
			throw new IllegalArgumentException("isImplementingInterface (Class clazz, Class interf) : interf is null");
		}

		boolean found = false;

		logger.trace("isImplementingInterface - search name {}", interf.getName());
		Class[] listInterfaces = clazz.getInterfaces();
		if (listInterfaces != null && listInterfaces.length > 0) {
			int i = 0;
			while (!found && i < listInterfaces.length) {
				logger.trace("[{}]public interface name found {}", i, listInterfaces[i].getName());
				if (listInterfaces[i] == interf) {
					found = true;
				}
				i++;
			}
		}
		return found;
	}

	/**
	 * Check if an Object [o] is inheriting from a specific Class [parent].
	 *
	 * @param o Object
	 * @param parent Class
	 *
	 * @return <code>true</code> : class is inherited, <code>false</code> : class is not inherited
	 *         <p>
	 *         Example : <code>isInheritingClass(bvo , BaseObject.class)</code>return
	 *         <code>true</code>
	 *         <p>
	 *         Created : 13 mar. 2017 by fmartinez (version 0.3.6-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isInheritingClass(Object o, Class parent) {

		if (o == null) {
			throw new IllegalArgumentException("isInheritingClass (Object o, Class parent) : o is null");

		}
		if (parent == null) {
			throw new IllegalArgumentException("isInheritingClass (Object o, Class parent) : parent is null");
		}
		return isInheritingClass(o.getClass(), parent);
	}

	/**
	 * Check if a Class [clazz] is inheriting from a specific Class [parent].
	 *
	 * @param clazz Class
	 * @param parent Class
	 * @return <code>true</code> : class is inherited, <code>false</code> : class is not inherited
	 *
	 *         <p>
	 *         Example : <code>isInheritingClass(BaseBVO.class , BaseObject.class)</code>return
	 *         <code>true</code>
	 *         <p>
	 *         Created : 13 mar. 2017 by fmartinez (version 0.3.6-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isInheritingClass(Class clazz, Class parent) {

		if (clazz == null) {
			throw new IllegalArgumentException("isInheritingClass (Class clazz, Class parent) : clazz is null");

		}
		if (parent == null) {
			throw new IllegalArgumentException("isInheritingClass (Class clazz, Class parent) : parent is null");
		}

		boolean found = false;

		logger.trace("search name {}", parent.getSimpleName());
		Class currentclazz = clazz.getSuperclass();
		while (!found && currentclazz != null) {
			logger.trace("class name found {}", currentclazz.getSimpleName());
			if (currentclazz == parent) {
				found = true;
			}
			currentclazz = currentclazz.getSuperclass();
		}
		return found;
	}

	/**
	 * Returns the type to this attribute
	 *
	 * @param attribute String
	 * @return The class name to this attribute
	 *
	 *         <p>
	 *         Example : <code>o.getClass("name")</code> returns String.class
	 *         <p>
	 *         Created : 31 aout 2016 by fmartinez (version 0.2.3-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	@SuppressWarnings("rawtypes")
	public Class getClass(String attribute) {

		return getClass(this, attribute);
	}

	/**
	 * Returns the type to this attribute
	 *
	 * @param o Object
	 * @param attribute String
	 * @return The class name to this attribute
	 *
	 *         <p>
	 *         Example : <code>BaseObjet.getClass(person, "name")</code> returns String.class
	 *         <p>
	 *         Created : 31 aout 2016 by fmartinez (version 0.2.3-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	@SuppressWarnings("rawtypes")
	public static Class getClass(Object o, String attribute) {

		return getClass(o.getClass(), attribute);
	}

	/**
	 * Returns the type to this attribute
	 *
	 * @param clazz Class
	 * @param attribute String
	 * @return The class to this attribute
	 *
	 *         <p>
	 *         Example : <code>BaseObjet.getClass(Person.class, "name")</code> returns String.class
	 *         <p>
	 *         Created : 31 aout 2016 by fmartinez (version 0.2.3-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	@SuppressWarnings("rawtypes")
	public static Class getClass(Class clazz, String attribute) {

		Class cl = null;
		Field field = getField(clazz, attribute);
		if (field != null) {
			cl = field.getType();
		}
		return cl;
	}

	/**
	 * Returns the field
	 *
	 * @param attribute Field name
	 * @return The Field object
	 *
	 *         <p>
	 *         Example : <code>Field field = person.getField("name")</code>
	 *         <p>
	 *         Created : 31 aout 2016 by fmartinez (version 0.2.3-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	public Field getField(String attribute) {

		return BaseObject.getField(this, attribute);
	}

	/**
	 * Returns the type to this attribute
	 *
	 * @param o Objet
	 * @param attribute Field name
	 * @return The Field object
	 *
	 *         <p>
	 *         Example : <code>Field field = BaseObject.getField(person, "name")</code>
	 *         <p>
	 *         Created : 31 aout 2016 by fmartinez (version 0.2.3-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	public static Field getField(Object o, String attribute) {

		Field field = null;
		if (o != null) {
			field = getField(o.getClass(), attribute); // # 18/01/2006
		}
		return field;
	}

	/**
	 * Returns the type to this attribute
	 *
	 * @param clazz Class
	 * @param attribute Field name
	 * @return The Field object
	 *
	 *         <p>
	 *         Example : <code>BaseObjet.getField(Person.class, "name")</code> returns String.class
	 *         <p>
	 *         Created : 31 aout 2016 by fmartinez (version 0.2.3-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	@SuppressWarnings("rawtypes")
	public static Field getField(Class clazz, String attribute) {

		Field field = null;
		Class cl = clazz;
		if ((attribute != null) && (attribute.length() > 0)) {
			while ((field == null) && (cl != null)) {
				try {
					field = cl.getDeclaredField(attribute);
				}
				catch (NoSuchFieldException e) {
					cl = cl.getSuperclass();
					logger.warn("getField(Class clazz, String attribute) : {}", BaseException.toStringStackTrace(e));
				}
			}
		}
		return field;
	}

	/**
	 * Returns an array of Field objects reflecting all the fields declared by the class or interface
	 * represented by this Class object
	 *
	 * @return array of Field objects
	 *
	 *         <p>
	 *         Example : <code>Field[] fields = BaseObjet.getFields(Person.class)</code>
	 *         <p>
	 *         Created : 25 nov. 2016 by fmartinez (version 0.3.1-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	@JsonIgnore
	public Field[] getFields() {

		return BaseObject.getFields(this, -1);
	}

	/**
	 * Returns an array of Field objects reflecting all the fields declared by the class or interface
	 * represented by this Class object
	 *
	 * @param o Object
	 * @return array of Field objects
	 *         <p>
	 *         Example : <code>Field[] fields = BaseObjet.getFields(o)</code>
	 *         <p>
	 *         Created : 25 nov. 2016 by fmartinez (version 0.3.1-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	@JsonIgnore
	public static Field[] getFields(Object o) {

		Field[] fields = null;
		if (o != null) {
			fields = getFields(o.getClass()); // # 18/01/2006
		}
		return fields;
	}

	/**
	 * Returns an array of Field objects reflecting all the fields declared by the class or interface
	 * represented by this Class object
	 *
	 * @param clazz Class
	 * @return array of Field objects
	 *
	 *         <p>
	 *         Example : <code>Field[] fields = BaseObjet.getFields(Person.class)</code>
	 *         <p>
	 *         Created : 25 nov. 2016 by fmartinez (version 0.3.1-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	@SuppressWarnings("rawtypes")
	@JsonIgnore
	public static Field[] getFields(Class clazz) {

		return getFields(clazz, -1);
	}

	/**
	 * Returns an array of Field objects reflecting all the fields declared by the class or interface
	 * represented by this Class object
	 *
	 * @param level levels of inheritance : -1 not limit, 0 current class, 1 first level...
	 * @return array of Field objects
	 *
	 *         <p>
	 *         Example : <code>Field[] fields = o.getFields(0)</code>
	 *         <p>
	 *         Created : 25 nov. 2016 by fmartinez (version 0.3.1-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	@JsonIgnore
	public Field[] getFields(int level) {

		return BaseObject.getFields(this, level);
	}

	/**
	 * Returns an array of Field objects reflecting all the fields declared by the class or interface
	 * represented by this Class object
	 *
	 * @param o object
	 * @param level levels of inheritance : -1 not limit, 0 current class, 1 first level...
	 * @return array of Field objects
	 *
	 *         <p>
	 *         Example : <code>Field[] fields = BaseObjet.getFields(Person.class, 0)</code>
	 *         <p>
	 *         Created : 25 nov. 2016 by fmartinez (version 0.3.1-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	@JsonIgnore
	private static Field[] getFields(Object o, int level) {

		Field[] fields = null;
		if (o != null) {
			fields = getFields(o.getClass(), level);
		}
		return fields;
	}

	/**
	 * Returns an array of Field objects reflecting all the fields declared by the class or interface
	 * represented by this Class object
	 *
	 * @param clazz Class
	 * @param level levels of inheritance : -1 not limit, 0 current class, 1 first level...
	 * @return array of Field objects
	 *         <p>
	 *         Example : <code>Field[] fields = BaseObjet.getFields(Person.class, 0)</code>
	 *         <p>
	 *         Created : 25 nov. 2016 by fmartinez (version 0.3.1-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@JsonIgnore
	public static Field[] getFields(Class clazz, int level) {

		int i = 0;
		Field[] fields = null;
		ArrayList list = new ArrayList();
		Class cl = clazz;
		while (cl != null && cl != Object.class && (level == -1 || i <= level)) {
			try {
				fields = cl.getDeclaredFields();
				if (fields != null) {
					int nbr = fields.length;
					for (int cpt = 0; cpt < nbr; cpt++) {
						list.add(fields[cpt]);
					}
				}
			}
			catch (SecurityException e) {
				logger.warn("getFields(Class clazz) - " + BaseException.toStringStackTrace(e));
			}
			cl = cl.getSuperclass();
			i++;
		}
		if (!(list.isEmpty())) {
			int nbr = list.size();
			fields = new Field[nbr];
			for (int cpt = 0; cpt < nbr; cpt++) {
				fields[cpt] = (Field) list.get(cpt);
			}
		}
		return fields;
	}

	/**
	 * Execute a method
	 *
	 * @param methodName Method name
	 * @param args Method aguments
	 * @return The result of the method call
	 *
	 * @throws Exception exception
	 *            <p>
	 *            Example : <code>BaseObjet.getClass(Person.class, "name")</code> returns
	 *            String.class
	 *            <p>
	 *            Created : 31 aout 2016 by fmartinez (version 0.2.3-Alpha)
	 *            <p>
	 *            updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	public Object executeMethod(String methodName, Object[] args) throws Exception {

		return executeMethod(this, methodName, args);
	}

	/**
	 * Returns the type to this attribute
	 *
	 * @param o Object
	 * @param methodName Method name
	 * @param args Method aguments
	 * @return The result of the method call
	 *
	 * @throws Exception exception
	 *            <p>
	 *            Example : <code>BaseObjet.getClass(Person.class, "name")</code> returns
	 *            String.class
	 *            <p>
	 *            Created : 31 aout 2016 by fmartinez (version 0.2.3-Alpha)
	 *            <p>
	 *            updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	@SuppressWarnings("rawtypes")
	public static Object executeMethod(Object o, String methodName, Object[] args) throws Exception {

		Class[] paramTypes = null;
		if (args != null) {
			paramTypes = new Class[args.length];
			for (int cpt = 0; cpt < args.length; ++cpt) {
				/*
				 * Si un paramètre implémente une interface particulière => on utilise le type de
				 * l'interface pour l'appel de la méthode
				 */
				if (isImplementingInterface(args[cpt], HttpServletRequest.class)) {
					/*
					 * Cas de l'interface HttpServletRequest
					 */
					paramTypes[cpt] = HttpServletRequest.class;
				}
				else {
					paramTypes[cpt] = args[cpt].getClass();
				}
			}
		}
		logger.trace("executeMethod : methodName= {}", methodName);
		Method m = o.getClass().getMethod(methodName, paramTypes);
		return m.invoke(o, args);
	}

	/**
	 * Returns the getter to this attribute
	 *
	 * @param o Object
	 * @param attribute Field name
	 *
	 * @return Method get()
	 *
	 * @throws IllegalAccessException the illegal access exception
	 * @throws InvocationTargetException the invocation target exception
	 * @throws NoSuchMethodException
	 *            <p>
	 *            Example : <code>BaseObjet.getBeanGetter(person, "name")</code> returns method
	 *            "getName()"
	 *            <p>
	 *            Created : 31 aout 2016 by fmartinez (version 0.2.3-Alpha)
	 *            <p>
	 *            updated : 10 mar. 2017 by fmartinez (version 0.3.6-Alpha)
	 */
	public static Method getBeanGetter(Object o, String attribute)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {

		Method method = null;
		PropertyDescriptor propertyDescriptor = org.apache.commons.beanutils.PropertyUtils.getPropertyDescriptor(o,
				attribute);

		if (propertyDescriptor != null) {
			logger.debug("propertyDescriptor not null : {}", propertyDescriptor.getShortDescription());
			logger.debug("method of {} : {}", attribute, propertyDescriptor.getReadMethod().getName());
			method = propertyDescriptor.getReadMethod();
		}
		return method;
	}

	/**
	 * Returns the setter to this attribute
	 *
	 * @param o Object
	 * @param attribute Field name
	 *
	 * @return Method set()
	 *
	 * @throws IllegalAccessException the illegal access exception
	 * @throws InvocationTargetException the invocation target exception
	 * @throws NoSuchMethodException
	 *            <p>
	 *            Example : <code>BaseObjet.getBeanSetter(person, "name")</code> returns method
	 *            "setName(String s)"
	 *            <p>
	 *            Created : 31 aout 2016 by fmartinez (version 0.2.3-Alpha)
	 *            <p>
	 *            updated : 10 mar. 2017 by fmartinez (version 0.3.6-Alpha)
	 */
	public static Method getBeanSetter(Object o, String attribute)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {

		Method method = null;
		PropertyDescriptor propertyDescriptor = org.apache.commons.beanutils.PropertyUtils.getPropertyDescriptor(o,
				attribute);

		if (propertyDescriptor != null) {
			logger.debug("propertyDescriptor not null : {}", propertyDescriptor.getShortDescription());
			logger.debug("method of {} : {}", attribute, propertyDescriptor.getWriteMethod().getName());
			method = propertyDescriptor.getWriteMethod();
		}
		return method;
	}

	/**
	 * Test if getter and setter exist
	 *
	 * @param o Object
	 * @param attribute Field name
	 *
	 * @return <code>true</code> : methods exist, <code>false</code> : methods does not exist
	 *
	 *         <p>
	 *         Example : <code>BaseObjet.hasBeanSetterGetter(person, "name")</code> returns true
	 *         <p>
	 *         Created : 31 aout 2016 by fmartinez (version 0.2.3-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	public static boolean hasBeanSetterGetter(Object o, String attribute) {

		return hasBeanGetter(o, attribute) && hasBeanSetter(o, attribute);
	}

	/**
	 * Test if getter exist
	 *
	 * @param o Object
	 * @param attribute Field name
	 * @return <code>true</code> : method get() exist, <code>false</code> : methods get() does not
	 *         exist
	 *         <p>
	 *         Example : <code>BaseObjet.hasBeanSetterGetter(person, "name")</code> returns true
	 *         <p>
	 *         Created : 31 aout 2016 by fmartinez (version 0.2.3-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	public static boolean hasBeanGetter(Object o, String attribute) {

		try {
			Method getter = getBeanGetter(o, attribute);
			if (getter != null) {
				return true;
			}
			else {
				String clsname = null;
				if (o != null) {
					clsname = o.getClass().getName();
				}

				logger.debug("hasBeanGetter=false, class {} : attribute {}", clsname, attribute);
				return false;
			}
		}
		catch (Exception e) {
			logger.warn("hasBeanGetter=false, attribute={} : getBeanGetter Exception {}", attribute,
					BaseException.toStringStackTrace(e));
			return false;
		}
	}

	/**
	 * Test if setter exist
	 *
	 * @param o Object
	 * @param attribute Field name
	 * @return <code>true</code> : method set() exist, <code>false</code> : methods set() does not
	 *         exist
	 *         <p>
	 *         Example : <code>BaseObjet.hasBeanSetterGetter(person, "name")</code> returns true
	 *         <p>
	 *         Created : 31 aout 2016 by fmartinez (version 0.2.3-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	public static boolean hasBeanSetter(Object o, String attribute) {

		try {
			Method setter = getBeanSetter(o, attribute);
			if (setter != null) {
				return true;
			}
			else {
				String clsname = null;
				if (o != null) {
					clsname = o.getClass().getName();
				}
				logger.debug("hasBeanSetter=false, class {} : attribute {}", clsname, attribute);
				return false;
			}
		}
		catch (Exception e) {
			logger.warn("hasBeanSetter=false, attribute={} : getBeanSetter Exception {}", attribute,
					BaseException.toStringStackTrace(e));
			return false;
		}
	}

	/**
	 * Test if class is complex
	 *
	 * @param clazz Class
	 * @return <code>true</code> : class is complex, <code>false</code> : class is primitive
	 *         <p>
	 *         Example : <code>BaseObjet.isComplex(Personn.class)</code> returns true
	 *         <p>
	 *         Created : 25 nov. 2016 by fmartinez (version 0.3.1-Alpha)
	 *         <p>
	 *         updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	@SuppressWarnings("rawtypes")
	private static boolean isComplex(Class clazz) {

		return !(clazz.isPrimitive() || clazz == String.class || clazz == Timestamp.class || clazz == Date.class
				|| clazz == GregorianCalendar.class || clazz == BigDecimal.class || clazz == Double.class
				|| clazz == Float.class || clazz == Long.class || clazz == Integer.class || clazz == Short.class
				|| clazz == Character.class || clazz == Byte.class || clazz == Boolean.class || clazz == double.class
				|| clazz == float.class || clazz == long.class || clazz == int.class || clazz == short.class
				|| clazz == char.class || clazz == byte.class || clazz == boolean.class);
	}

	/**
	 * Test if class is complex
	 *
	 * @param logger the logger
	 * @param o object
	 * @param methode method name
	 *
	 *           <p>
	 *           return <code>true</code> : class is complex, <code>false</code> : class is primitive
	 *           <p>
	 *           Example : <code>BaseObjet.display(logger, personnBVO, "create()")</code>
	 *           <p>
	 *           Created : 25 nov. 2016 by fmartinez (version 0.3.1-Alpha)
	 *           <p>
	 *           updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void display(Logger logger, Object o, String methode) {

		try {
			if (logger != null) {
				if (o != null) {
					String header = "==== ";
					logger.info("================================================================================");
					int objHashCode = o.hashCode();
					String name = o.getClass().getName();
					logger.info("==== Method <" + methode + ">");
					logger.info("==== Details [" + name + "]<" + objHashCode + ">");
					Hashtable ht = new Hashtable();
					ht.put(o, o);
					display(logger, o, ht, header, "", "", "");
					logger.info("==== End [" + name + "]<" + objHashCode + ">");
					logger.info("================================================================================");
				}
				else {
					logger.info("Can't display null object !");
				}
			}
		}
		catch (Exception e) {
			if (logger != null && logger.isWarnEnabled()) {
				logger.warn("BaseObject.trace - ", BaseException.toStringStackTrace(e));
			}
		}
	}

	/**
	 * Displays contents of an object
	 *
	 * @param logger Logger
	 * @param o Object to log
	 * @param ht Hashtable
	 * @param header Text header
	 * @param branch Branch symbol
	 * @param tabulation Tabulation
	 * @param var Field name
	 * @throws IllegalArgumentException IllegalArgumentException
	 * @throws IllegalAccessException IllegalAccessException
	 *            <p>
	 *            Created : 25 nov. 2016 by fmartinez (version 0.3.1-Alpha)
	 *            <p>
	 *            updated : xx xxxx xxxx by xxxxx (version 0.x.x-Alpha)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void display(Logger logger, Object o, Hashtable ht, String header, String branch, String tabulation,
			String var) throws IllegalArgumentException, IllegalAccessException {

		if (logger == null || ht == null || tabulation == null || var == null) {
			throw new IllegalArgumentException("ht==null");
		}

		if (o != null) {
			Class clazz = o.getClass();

			/*
			 * Simple class name
			 */
			String clName = clazz.getSimpleName();
			if (clazz.isArray()) {
				clName = "[" + clName + "]";
			}

			if (isComplex(clazz)) {
				if (!clName.startsWith("this$")) {
					logger.info("{}{}{}", header, tabulation, branch + var + "[" + clName + "]" + "<" + o.hashCode() + ">");
				}
				String newBranch = "|-";

				for (int i = 0; i < newBranch.length() + 1; i++) {
					tabulation = tabulation + " ";
				}

				Object value = null;
				/*
				 * Array
				 */
				if (clazz.isArray() && o.getClass() != byte[].class) {
					int size = ((Object[]) o).length;
					if (size > 10) {
						size = 10;
						logger.info("{}{}{} Only the first 10 elements will be displayed...", header, tabulation, newBranch);
					}
					for (int i = 0; i < size; i++) {
						value = ((Object[]) o)[i];
						if (value != null) {
							if (ht.get(value) == null) {
								ht.put(value, value);
								display(logger, value, ht, header, newBranch, tabulation, "[" + i + "]");
							}
							else {
								logger.info("{}{}{} [{}] @see <{}>", header, tabulation, newBranch, i, value.hashCode());
							}
						}
						else {
							logger.info("{}{}{} [{}]='null'", header, tabulation, newBranch, i);
						}
					}
				}
				else if (isImplementingInterface(o, List.class)) {
					/*
					 * List
					 */
					int size = ((List) o).size();
					if (size > 10) {
						size = 10;
						logger.info("{}{}{} Only the first 10 elements will be displayed...", header, tabulation, newBranch);
					}
					for (int i = 0; i < size; i++) {
						value = ((List) o).get(i);
						if (value != null) {
							if (ht.get(value) == null) {
								ht.put(value, value);
								display(logger, value, ht, header, newBranch, tabulation, "[" + i + "]");
							}
							else {
								logger.info("{}{}{} [{}] @see <{}>", header, tabulation, newBranch, i, value.hashCode());
							}
						}
						else {
							logger.info("{}{}{} [{}]='null'", header, tabulation, newBranch, i);
						}
					}
				}
				else {
					/*
					 * Others
					 */
					int level = 0;
					if (isInheritingClass(clazz, BaseObject.class)) {
						level = 2;
					}
					Field[] fields = BaseObject.getFields(o, level);
					if (fields != null) {
						String fieldName = null;
						AccessibleObject.setAccessible(fields, true);
						int nbr = fields.length;
						for (int i = 0; i < nbr; i++) {
							fieldName = fields[i].getName();
							if (!fieldName.startsWith("class$") && !Modifier.isStatic(fields[i].getModifiers())) {
								value = fields[i].get(o);
								String type = fields[i].getType().getSimpleName();
								if (value != null) {
									if (ht.get(value) == null) {
										ht.put(value, value);
										display(logger, value, ht, header, newBranch, tabulation, fieldName);
									}
									else {
										if (isComplex(value.getClass())) {
											if (!fieldName.startsWith("this$")) {
												logger.info("{}{}{}{} [{}] @see <{}>", header, tabulation, newBranch, fieldName,
														type, value.hashCode());
											}
										}
										else {
											display(logger, value, ht, header, newBranch, tabulation, fieldName);
										}
									}
								}
								else {
									logger.info("{}{}{}{} [{}]='null'", header, tabulation, newBranch, fieldName, type);
								}
							}
						}
					}
				}
			}
			else {
				String logValue = null;
				if (clazz == GregorianCalendar.class) {
					logValue = ((GregorianCalendar) o).getTime().toString();
				}
				else {
					/*
					 * Others types String, Timestamp, Date, GregorianCalendar, BigDecimal, Double,
					 * Float, Long, Integer.class Short, Character, Byte, Boolean, double, float, long,
					 * int, short, char, byte, boolean
					 */
					logValue = o.toString();
				}
				logger.info("{}{}{}{} [{}]='{}'", header, tabulation, branch, var, clName, logValue);
			}
		}
	}
}
