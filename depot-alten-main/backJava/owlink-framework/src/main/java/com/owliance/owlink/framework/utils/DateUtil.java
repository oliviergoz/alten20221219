/*
 * Copyright Owliance © 2016 - 2017 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.framework.utils;

import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Utility class for Date manipulation.
 *
 * @author fmartinez
 * @since 0.1.5-Alpha
 * @see com.owliance.owlink.framework.utils
 *
 *      <p>
 *      Created : 08 juil 2016
 *      <p>
 *      Updated : 13 juil 2016 by hbenizid (version 0.1.5-Alpha)
 *      <p>
 *      Updated : 24 Oct. 2016 by lneji (version 0.2.2-Alpha)
 *      <p>
 *      Updated : 28 féb. 2017 by fmartinez (version 0.3.6-Alpha)
 *      <p>
 *      Updated : 01 mar. 2017 by fmartinez (version 0.3.6-Alpha) =>
 *      getDiffYears()
 *      <p>
 *      Updated : 17 juil. 2017 by hbenizid (version 0.4.8-Alpha)
 */
public final class DateUtil implements java.io.Serializable {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 5999021449738544362L;

	/**
	 * The <code>Logger</code> instance for this class.
	 */
	private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

	/**
	 * Date format.
	 */
	public static final String DATE_FORMAT = "dd/MM/yyyy";

	/**
	 * Hour format.
	 */
	public static final String TIME_FORMAT = "HH:mm:ss";

	/**
	 * Datetime format.
	 */
	public static final String DATETIME_FORMAT = "dd/MM/yyyy HH:mm:ss";

	/**
	 * Day and month format.
	 */
	public static final String DATE_FORMAT_DAY_AND_MONTH = "dd/MM";

	/**
	 * Date params not null
	 */
	public static final String DATE_PARAMS_NOT_NULL = "Date params should be not null";

	/**
	 * Date utilisable comme une date maximum.
	 */
	public static final String MAX_DATE = "2999-01-01T00:00:00.00Z";

	/**
	 * Date utilisable comme une date minimum.
	 */
	public static final String MIN_DATE = "1200-01-01T00:00:00.00Z";

	/**
	 * Convertie une chaine date en GregorianCalendar.
	 *
	 * @param sdate Chaine date
	 *
	 * @return GregorianCalendar. gregorian calendar
	 *
	 * @throws ParseException Si une erreur survient.
	 *                        <p>
	 *                        Example :
	 *                        <p>
	 *                        String s = "01/01/2004"
	 *                        <p>
	 *                        convertToTimestamp(s) retourne 2004-01-01 00:00:00
	 *                        <p>
	 *                        String s = "01/01/2004 12:30:30"
	 *                        <p>
	 *                        convertToTimestamp(s) retourne 2004-01-01 12:30:30
	 *                        <p>
	 *                        Created : 08 juil 2016 by fmartinez (version
	 *                        0.1.5-Alpha)
	 *                        <p>
	 *                        Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static GregorianCalendar convertToGregorianCalendar(String sdate) throws ParseException {

		return toGregorianCalendar(toTimestamp(sdate));
	}

	/**
	 * Convertie un Timestamp en chaine au format JJ/MM/AAAA.
	 *
	 * @param timestamp Timestamp
	 *
	 * @return Chaine date.
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Timestamp t = Timestamp.valueOf("2004-01-01 00:00:00");
	 *         <p>
	 *         toString(t) retourne "01/01/2004"
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static String toString(Timestamp timestamp) {

		if (timestamp != null) {
			Date date = timestamp;
			return new SimpleDateFormat(DATE_FORMAT).format(date);
		} else {
			return null;
		}
	}

	/**
	 * Convertie un Timestamp en chaine respectant le format spécifié.
	 *
	 * @param timestamp Timestamp
	 * @param format    Chaine de formatage
	 *
	 * @return Chaine date au format spécifié.
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static String toString(Timestamp timestamp, String format) {

		if ((timestamp != null) && (format != null) && (format.length() > 0)) {
			Date date = timestamp;
			SimpleDateFormat currentdateFormat = new SimpleDateFormat(format);
			return currentdateFormat.format(date);
		} else {
			return null;
		}
	}

	/**
	 * Convertie un GregorianCalendar en chaine au format JJ/MM/AAAA.
	 *
	 * @param calendar GregorianCalendar
	 *
	 * @return JJ /MM/AAAA.
	 *         <p>
	 *         Example :
	 *         <p>
	 *         getDateAsString(calendar) retourne "01/01/2004"
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static String toString(Calendar calendar) {

		String tempDate = null;
		if (calendar != null) {
			int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
			String szDay;
			if (dayOfMonth < 10) {
				szDay = "0" + dayOfMonth;
			} else {
				szDay = "" + dayOfMonth;
			}
			// Dans la classe GregorianCalendar le mois commence à 0 d'ou l'incrementation
			// de 1.
			int month = calendar.get(Calendar.MONTH) + 1;
			String szMonth;
			if (month < 10) {
				szMonth = "0" + month;
			} else {
				szMonth = "" + month;
			}
			int year = calendar.get(Calendar.YEAR);
			tempDate = "" + szDay + "/" + szMonth + "/" + year;
		}
		return tempDate;
	}

	/**
	 * Convertie un GregorianCalendar en chaine au format JJ/MM/AAAA..
	 *
	 * @param calendar GregorianCalendar
	 *
	 * @return JJ /MM/AAAA.
	 *         <p>
	 *         Example :
	 *         <p>
	 *         toString(calendar) retourne "01/01/2004"
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static String toString(GregorianCalendar calendar) {

		String tempDate = null;
		if (calendar != null) {
			tempDate = new SimpleDateFormat(DATETIME_FORMAT).format(calendar.getTime());
			// On vérifie que le restant de la date ne sois pas 00:00:00 auquel cas on le
			// vire.
			if (tempDate.substring(11).equals("00:00:00")) {
				tempDate = tempDate.substring(0, 10);
			}
		}
		return tempDate;
	}

	/**
	 * Convertie un GregorianCalendar en chaine au format JJ/MM/AAAA..
	 *
	 * @param calendar GregorianCalendar
	 * @param format   Chaine de formatage
	 *
	 * @return Chaine date au format spécifié.
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static String toString(GregorianCalendar calendar, String format) {

		if ((calendar != null) && (format != null) && (format.length() > 0)) {
			return new SimpleDateFormat(format).format(calendar.getTime());
		} else {
			return null;
		}
	}

	/**
	 * Format or return default date.
	 *
	 * @param date        Date
	 * @param defaultDate String
	 *
	 * @return String.
	 *         <p>
	 *         Created : 11 oct 2016 by abayoudh (version 0.2.0-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static String toStringOrDefault(Date date, String defaultDate) {

		if (date != null) {
			return new SimpleDateFormat(DATE_FORMAT).format(date);
		} else {
			return defaultDate;
		}
	}

	/**
	 * Convertie une Date en chaine au format JJ/MM/AAAA.
	 *
	 * @param date Date
	 *
	 * @return Chaine date.
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static String toString(Date date) {

		if (date != null) {
			return new SimpleDateFormat(DATE_FORMAT).format(date);
		} else {
			return null;
		}
	}

	/**
	 * Convertie une Date en chaine respectant le format spécifié.
	 *
	 * @param date   Date
	 * @param format Chaine de formatage
	 *
	 * @return Chaine date au format spécifié.
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static String toString(Date date, String format) {

		if ((date != null) && (format != null) && (format.length() > 0)) {
			SimpleDateFormat currentdateFormat = new SimpleDateFormat(format);
			return currentdateFormat.format(date);
		} else {
			return null;
		}
	}

	/**
	 * Convertie un Timestamp en chaine au format HH:MM:SS.
	 *
	 * @param timestamp Timestamp
	 *
	 * @return Heure.
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static String getTime(Timestamp timestamp) {

		if (timestamp != null) {
			String time = "";
			GregorianCalendar calendar = new GregorianCalendar();
			Date date = timestamp;
			calendar.setTime(date);
			int value = calendar.get(Calendar.HOUR_OF_DAY);
			if (value < 10) {

				time = time + "0" + value;
			} else {
				time = time + value;
			}
			value = calendar.get(Calendar.MINUTE);
			if (value < 10) {

				time = time + ":0" + value;
			} else {
				time = time + ":" + value;

			}
			value = calendar.get(Calendar.SECOND);
			if (value < 10) {

				time = time + ":0" + value;
			} else {
				time = time + ":" + value;
			}

			return time;
		} else {
			return null;
		}
	}

	/**
	 * Convertie un GregorianCalendar en chaine au format HH:MM:SS.
	 *
	 * @param calendar GregorianCalendar
	 *
	 * @return Heure.
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static String getTime(GregorianCalendar calendar) {

		if (calendar != null) {
			String time = "";
			int value = calendar.get(Calendar.HOUR_OF_DAY);
			if (value < 10) {

				time = time + "0" + value;
			} else {
				time = time + value;
			}
			value = calendar.get(Calendar.MINUTE);
			if (value < 10) {

				time = time + ":0" + value;
			} else {
				time = time + ":" + value;
			}
			value = calendar.get(Calendar.SECOND);
			if (value < 10) {

				time = time + ":0" + value;
			} else {
				time = time + ":" + value;
			}
			return time;
		} else {
			return null;
		}
	}

	/**
	 * Retourne le Timestamp correspondant à la date et l'heure courante.
	 *
	 * @return Timestamp courant.
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static Timestamp getCurrentTimestamp() {

		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * Retourne la date courante sous forme de Date.
	 *
	 * @return Date courante.
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static Date getDate() {

		return new Date(System.currentTimeMillis());
	}

	/**
	 * Retourne la date courante sous forme de GregorianCalendar.
	 *
	 * @return Date courante.
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static GregorianCalendar getCurrentGregorianCalendar() {

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return calendar;
	}

	/**
	 * Retourne la date courante sous forme de chaine au format JJ/MM/AAAA.
	 *
	 * @return Date courante.
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static String getCurrentDate() {

		Date currentDate = new Date(System.currentTimeMillis());
		return new SimpleDateFormat(DATE_FORMAT).format(currentDate);
	}

	/**
	 * Retourne la date courante sous forme de chaine au format dd/MM/yyyy HH:mm:ss.
	 *
	 * @return Date courante.
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static String getCurrentDateTime() {

		Date currentDate = new Date(System.currentTimeMillis());
		return new SimpleDateFormat(DATETIME_FORMAT).format(currentDate);
	}

	/**
	 * Retourne l'heure courante sous forme de chaine au format HH:MM:SS.
	 *
	 * @return Heure courante.
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static String getCurrentTime() {

		Date currentDate = new Date(System.currentTimeMillis());
		return new SimpleDateFormat(TIME_FORMAT).format(currentDate);
	}

	/**
	 * Ajoute un nombre de jours à une date.
	 *
	 * @param date Date
	 * @param days Nombre de jour
	 *
	 * @return Nouvelle date.
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static Date add(Date date, int days) {

		if (date != null) {
			GregorianCalendar calendar = toGregorianCalendar(date);
			calendar.add(Calendar.DATE, days);
			return calendar.getTime();
		} else {
			return null;
		}
	}

	/**
	 * Ajoute un nombre de mois à une date.
	 *
	 * @param date   the date
	 * @param months the months
	 *
	 * @return Nouvelle date. 15:33:18 by lneji
	 */
	public static Date addMonths(Date date, int months) {

		if (date != null) {
			GregorianCalendar calendar = toGregorianCalendar(date);
			calendar.add(Calendar.MONTH, months);
			return calendar.getTime();
		} else {
			return null;
		}
	}

	/**
	 * Ajoute un nombre de jours à une chaine date au format JJ/MM/AAAA.
	 *
	 * @param sdate Chaine date
	 * @param days  Nombre de jours
	 *
	 * @return Nouvelle chaine date.
	 *
	 * @throws ParseException Si une erreur survient.
	 *                        <p>
	 *                        Created : 08 juil 2016 by fmartinez (version
	 *                        0.1.5-Alpha)
	 *                        <p>
	 *                        Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static String add(String sdate, int days) throws ParseException {

		GregorianCalendar calendar = convertToGregorianCalendar(sdate);
		if (calendar != null) {
			calendar.add(Calendar.DATE, days);
		} else {
			throw new ParseException("Failed to add [" + days + "] day(s) to date [" + sdate + "].", 0);
		}
		return new SimpleDateFormat(DATE_FORMAT).format(calendar.getTime());
	}

	/**
	 * Ajoute un nombre de jours à une chaine date en respectant le formatage
	 * spécifié.
	 *
	 * @param sdate  Chaine date
	 * @param format Chaine de formatage
	 * @param days   Nombre de jours
	 *
	 * @return Nouvelle chaine date.
	 *
	 * @throws ParseException Si une erreur survient.
	 *                        <p>
	 *                        Created : 08 juil 2016 by fmartinez (version
	 *                        0.1.5-Alpha)
	 *                        <p>
	 *                        Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static String add(String sdate, String format, int days) throws ParseException {

		if ((sdate != null) && (sdate.length() > 0) && (format != null) && (format.length() > 0)) {
			GregorianCalendar calendar = toGregorianCalendar(sdate, format);
			if (calendar != null) {
				calendar.add(Calendar.DATE, days);
			} else {
				throw new ParseException(
						"Failed to add [" + days + "] day(s) to date [" + sdate + "] with format [" + format + "].", 0);
			}
			return new SimpleDateFormat(DATE_FORMAT).format(calendar.getTime());
		} else {
			return null;
		}
	}

	/**
	 * Convertie une Date en GregorianCalendar.
	 *
	 * @param date Date à convertir
	 *
	 * @return GregorianCalendar.
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static GregorianCalendar toGregorianCalendar(Date date) {

		if (date != null) {
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			return calendar;
		} else {
			return null;
		}
	}

	/**
	 * Convertie un Timestamp en GregorianCalendar.
	 *
	 * @param timestamp Timestamp à convertir
	 *
	 * @return GregorianCalendar.
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static GregorianCalendar toGregorianCalendar(Timestamp timestamp) {

		if (timestamp != null) {
			Date date = timestamp;
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			return calendar;
		} else {
			return null;
		}
	}

	/**
	 * Convertie une chaine date en Timestamp.
	 *
	 * @param sdate Chaine date
	 *
	 * @return Timestamp. timestamp
	 *
	 * @throws ParseException Si une erreur survient.
	 *                        <p>
	 *                        Example :
	 *                        <p>
	 *                        String s = "01/01/2004"
	 *                        <p>
	 *                        convertToTimestamp(s) retourne 2004-01-01 00:00:00
	 *                        <p>
	 *                        String s = "01/01/2004 12:30:30"
	 *                        <p>
	 *                        convertToTimestamp(s) retourne 2004-01-01 12:30:30
	 *                        <p>
	 *                        Created : 08 juil 2016 by fmartinez (version
	 *                        0.1.5-Alpha)
	 *                        <p>
	 *                        Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static Timestamp toTimestamp(String sdate) throws ParseException {

		Timestamp timeStamp = null;

		if (sdate != null && sdate.length() > 0) {
			String newdate = toString(sdate.substring(0, 10), "yyyy-MM-dd");
			try {
				if (sdate.length() > 10) {
					newdate = newdate + sdate.substring(10);
					timeStamp = Timestamp.valueOf(newdate);
				} else {
					newdate = newdate + " 00:00:00";
					timeStamp = Timestamp.valueOf(newdate);
				}
			} catch (IllegalArgumentException e) {
				if (e.getMessage() != null) {
					logger.error("convertToTimestamp : IllegalArgumentException : [{}]", e.getMessage());
					throw e;
				} else {
					logger.error(
							"convertToTimestamp : IllegalArgumentException : Timestamp format must be yyyy-mm-dd hh:mm:ss or yyyy-mm-dd hh:mm:ss");
					throw new IllegalArgumentException(
							"convertToTimestamp : IllegalArgumentException : Timestamp format must be yyyy-mm-dd hh:mm:ss or yyyy-mm-dd hh:mm:ss");
				}
			}
		}
		return timeStamp;
	}

	/**
	 * Convertie un GregorianCalendar en Timestamp.
	 *
	 * @param calendar GregorianCalendar à convertir
	 *
	 * @return Timestamp.
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static Timestamp toTimestamp(GregorianCalendar calendar) {

		if (calendar != null) {
			return new Timestamp(calendar.getTime().getTime());
		} else {
			return null;
		}
	}

	/**
	 * Convertie un GregorianCalendar en Date.
	 *
	 * @param calendar GregorianCalendar à convertir
	 *
	 * @return Timestamp.
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static Date toDate(GregorianCalendar calendar) {

		if (calendar != null) {
			return calendar.getTime();
		} else {
			return null;
		}
	}

	/**
	 * Convertie une Date en Timestamp.
	 *
	 * @param date Date à convertir
	 *
	 * @return Timestamp.
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static Timestamp toTimestamp(Date date) {

		if (date != null) {
			return new Timestamp(date.getTime());
		} else {
			return null;
		}
	}

	/**
	 * Convertie une chaine date au format JJ/MM/AAAA en GregorianCalendar.
	 *
	 * @param sdate Chaine date
	 *
	 * @return GregorianCalendar. gregorian calendar
	 *
	 * @throws ParseException Si une erreur survient.
	 *                        <p>
	 *                        Created : 08 juil 2016 by fmartinez (version
	 *                        0.1.5-Alpha)
	 *                        <p>
	 *                        Updated : 18 juil 2016 by fmartinez (version
	 *                        0.1.6-Alpha) : erreur stricte sur les conversions de
	 *                        date
	 */
	public static GregorianCalendar toGregorianCalendar(String sdate) throws ParseException {

		if ((sdate != null) && (sdate.length() > 0)) {
			Date currentDate = null;

			if (sdate.trim().length() > 10) {
				// Cas d'une date (jour + heure) ou que le jour.
				SimpleDateFormat currentdateFormat = new SimpleDateFormat(DATETIME_FORMAT);
				// Erreur stricte sur les conversions de date : si non positionné "33/01/2011"
				// n'est pas
				// en erreur
				// et retourne "02/02/2011"
				currentdateFormat.setLenient(false);
				currentDate = currentdateFormat.parse(sdate);
			} else if (sdate.trim().length() == 8) {
				// Cas d'une date ne contenant que l'heure (hh:mm:ss).
				getTimeFormat().setLenient(false); // Erreur stricte sur les conversions de date
				currentDate = getTimeFormat().parse(sdate);
			} else {
				currentDate = toDate(sdate.trim());
			}
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(currentDate);
			return calendar;
		} else {
			return null;
		}
	}

	/**
	 * Convertie une chaine date en GregorianCalendar.
	 *
	 * @param sdate  Chaine date
	 * @param format Chaine de formatage
	 *
	 * @return GregorianCalendar. gregorian calendar
	 *
	 * @throws ParseException Si une erreur survient.
	 *                        <p>
	 *                        Created : 08 juil 2016 by fmartinez (version
	 *                        0.1.5-Alpha)
	 *                        <p>
	 *                        Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static GregorianCalendar toGregorianCalendar(String sdate, String format) throws ParseException {

		if ((sdate != null) && (sdate.length() > 0) && (format != null) && (format.length() > 0)) {
			Date date = toDate(sdate, format);
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			return calendar;
		} else {
			return null;
		}
	}

	/**
	 * Convertie une chaine date en une Date au format JJ/MM/AAAA.
	 *
	 * @param sdate Chaine date
	 *
	 * @return Date formatée.
	 *
	 * @throws ParseException Si une erreur survient.
	 *                        <p>
	 *                        Created : 08 juil 2016 by fmartinez (version
	 *                        0.1.5-Alpha)
	 *                        <p>
	 *                        Updated : 18 juil 2016 by fmartinez (version
	 *                        0.1.6-Alpha) : erreur stricte sur les conversions de
	 *                        date
	 */
	public static Date toDate(String sdate) throws ParseException {

		Date currentDate = null;
		if ((sdate != null) && (sdate.trim().length() == 10)) {
			SimpleDateFormat currentdateFormat = new SimpleDateFormat(DATE_FORMAT);
			// Erreur stricte sur les conversions de date : si non positionné "33/01/2011"
			// n'est pas en
			// erreur
			// et retourne "02/02/2011"
			currentdateFormat.setLenient(false); // Erreur stricte sur les conversions de date
			currentDate = currentdateFormat.parse(sdate);
		} else if ((sdate != null) && (sdate.trim().length() > 10)) {
			SimpleDateFormat currentdateFormat = new SimpleDateFormat(DATETIME_FORMAT);
			// Erreur stricte sur les conversions de date : si non positionné "33/01/2011"
			// n'est pas en
			// erreur
			// et retourne "02/02/2011"
			currentdateFormat.setLenient(false);
			currentDate = currentdateFormat.parse(sdate);
		}
		return currentDate;
	}

	/**
	 * Convertie une chaine date en une Date formatée.
	 *
	 * @param sdate  Chaine date
	 * @param format Chaine de formatage
	 *
	 * @return Date formatée.
	 *
	 * @throws ParseException Si une erreur survient.
	 *                        <p>
	 *                        Created : 08 juil 2016 by fmartinez (version
	 *                        0.1.5-Alpha)
	 *                        <p>
	 *                        Updated : 18 juil 2016 by fmartinez (version
	 *                        0.1.6-Alpha) : erreur stricte sur les conversions de
	 *                        date
	 */
	public static Date toDate(String sdate, String format) throws ParseException {

		if ((sdate != null) && (sdate.length() > 0) && (format != null) && (format.length() > 0)) {
			SimpleDateFormat currentdateFormat = new SimpleDateFormat(format);
			currentdateFormat.setLenient(false);
			return currentdateFormat.parse(sdate);
		} else {
			return null;
		}
	}

	/**
	 * Convertie une chaine date en une Date au format JJ/MM/AAAA.
	 *
	 * @param sdate Chaine date
	 *
	 * @return LocalDate formatee.
	 *
	 * @throws ParseException Si une erreur survient.
	 */
	public static LocalDate toLocalDate(String sdate) {

		LocalDate currentDate = null;
		if ((sdate != null) && (sdate.trim().length() == 10)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
			currentDate = LocalDate.parse(sdate, formatter);
		} else if ((sdate != null) && (sdate.trim().length() > 10)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATETIME_FORMAT);
			currentDate = LocalDate.parse(sdate, formatter);
		}
		return currentDate;
	}

	/**
	 * Formate une chaine date à partir d'une chaine de formatage.
	 *
	 * @param sdate         Chaine date
	 * @param newDateFormat Chaine de formatage
	 *
	 * @return Chaine date formatée.
	 *
	 * @throws ParseException Si une erreur survient.
	 *                        <p>
	 *                        Created : 08 juil 2016 by fmartinez (version
	 *                        0.1.5-Alpha)
	 *                        <p>
	 *                        Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static String toString(String sdate, String newDateFormat) throws ParseException {

		if ((sdate != null) && (sdate.length() > 0) && (newDateFormat != null) && (newDateFormat.length() > 0)) {
			SimpleDateFormat currentdateFormat = new SimpleDateFormat(newDateFormat);
			return currentdateFormat.format(new SimpleDateFormat(DATE_FORMAT).parse(sdate));
		} else {
			return null;
		}
	}

	/**
	 * Gets date format.
	 *
	 * @return SimpleDateFormat dateFormat Format de standard pour une date
	 *         "dd/MM/yyyy"
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static SimpleDateFormat getDateFormat() {

		return new SimpleDateFormat(DATE_FORMAT);
	}

	/**
	 * Gets time format.
	 *
	 * @return SimpleDateFormat timeFormat Format de standard pour l'heure
	 *         "HH:mm:ss"
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static SimpleDateFormat getTimeFormat() {

		return new SimpleDateFormat(TIME_FORMAT);
	}

	/**
	 * Gets date time format.
	 *
	 * @return SimpleDateFormat dateTimeFormat Format stantdard pour la date / heure
	 *         "dd/MM/yyyy HH:mm:ss"
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public static SimpleDateFormat getDateTimeFormat() {

		return new SimpleDateFormat(DATETIME_FORMAT);
	}

	/**
	 * Convertie une date en XMLGregorianCalendar.
	 * <p/>
	 * <p/>
	 * Created : 27 sept. 2016 by hbenizid (version 0.2.0-Alpha)
	 * <p/>
	 * Updated : xx xxxx xxxx by xxx (version x.x.x)
	 *
	 * @param date the date
	 *
	 * @return {@link XMLGregorianCalendar}
	 */
	public static XMLGregorianCalendar toXMLGregorianCalendar(Date date) {

		logger.info("Convert Date to XMLGregorianCalendar");
		try {
			GregorianCalendar gregory = new GregorianCalendar();
			gregory.setTime(date);
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);

		} catch (DatatypeConfigurationException e) {
			logger.info("Failed to convert Date to XMLGregorianCalendar", e);
			return null;
		}

	}

	/**
	 * compare two dates : returns value greater than 0 if firstDate is greater than
	 * secondDate, value less than 0 if secondDate is greater than firstDate, 0 if
	 * equals.
	 *
	 * @param firstDate  the first date
	 * @param secondDate the second date
	 * @return {@link Integer}
	 */
	public static int compareDate(Date firstDate, Date secondDate) {

		if (firstDate == null || secondDate == null) {
			throw new IllegalArgumentException(DATE_PARAMS_NOT_NULL);
		}
		return toTimestamp(firstDate).compareTo(toTimestamp(secondDate));
	}

	/**
	 * compare two dates : returns value greater than 0 if firstDate is greater than
	 * secondDate, value less than 0 if secondDate is greater than firstDate, 0 if
	 * equals.
	 *
	 * @param firstDate  the first date
	 * @param secondDate the second date
	 * @return {@link Integer}
	 */
	public static int compareLocalDate(LocalDate firstDate, LocalDate secondDate) {

		if (firstDate == null || secondDate == null) {
			throw new IllegalArgumentException(DATE_PARAMS_NOT_NULL);
		}
		if (firstDate.equals(secondDate)) {
			return 0;
		}
		if (firstDate.isAfter(secondDate)) {
			return 1;
		}
		return -1;
	}

	/**
	 * Compare Date Without Time
	 *
	 * @param firstDate  the first date
	 * @param secondDate the second date
	 * @return {@link Integer} 21 fév. 2017 - 12:27:48 by abdennabi
	 */
	public static int compareDateWithoutTime(Date firstDate, Date secondDate) {

		if (firstDate == null || secondDate == null) {
			throw new IllegalArgumentException(DATE_PARAMS_NOT_NULL);
		}
		Calendar calendarDebut = getCalendar(firstDate);
		calendarDebut.set(Calendar.HOUR_OF_DAY, 0);
		calendarDebut.set(Calendar.MINUTE, 0);
		calendarDebut.set(Calendar.SECOND, 0);
		calendarDebut.set(Calendar.MILLISECOND, 0);

		Calendar calendarFin = getCalendar(secondDate);
		calendarFin.setTime(secondDate);
		calendarFin.set(Calendar.HOUR_OF_DAY, 0);
		calendarFin.set(Calendar.MINUTE, 0);
		calendarFin.set(Calendar.SECOND, 0);
		calendarFin.set(Calendar.MILLISECOND, 0);

		return compareDate(calendarDebut.getTime(), calendarFin.getTime());
	}

	/**
	 * Number of years between two dates.
	 *
	 * @param first date
	 * @param last  date
	 * @return nbr of years between first date and last date if (first < last), else
	 *         return 0 13:17:37 by abayoudh
	 */
	public static int getDiffYears(Date first, Date last) {

		int diff = 0;
		Calendar a = getCalendar(first);
		Calendar b = getCalendar(last);
		if (a.compareTo(b) > 0) {
			a = getCalendar(last);
			b = getCalendar(first);
		}
		diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
		if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH)
				|| (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
			diff--;
		}
		return diff;
	}

	/**
	 * transform date to calender.
	 *
	 * @param date the date
	 * @return Calender 13:19:55 by abayoudh
	 */
	public static Calendar getCalendar(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	/**
	 * Gets year from date.
	 *
	 * @param date the date
	 *
	 * @return int Value of YEAR from given Date 11:49:35 by hbenizid
	 */
	public static int getYearFromDate(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	/**
	 * Gets month from date.
	 *
	 * @param date the date
	 *
	 * @return int Value of MONTH from given Date 11:50:11 by hbenizid
	 */
	public static int getMonthFromDate(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * Gets day from date.
	 *
	 * @param date the date
	 *
	 * @return int Value of DAY_OF_MONTH from given Date 11:50:14 by hbenizid
	 */
	public static int getDayFromDate(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Set the time part of a date to 00:00:00.000
	 *
	 * @param date the date to trunc
	 * @return {@link Date}
	 */
	public static Date truncDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}


	/**
	 * Count number of days between start date and end date.
	 *
	 * @param startDate the start date
	 * @param endDate   the end date
	 * @return {@link Integer}
	 *
	 *         19 :55:16 by tboudiche
	 */
	public static int calculateNbreDaysBetweenTwoDates(Date startDate, Date endDate) {

		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		int workDays = 0;

		/*
		 * Return 0 if start and end are the same
		 */
		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			return 0;
		}

		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(endDate);
			endCal.setTime(startDate);
		}

		do {
			/*
			 * excluding start date
			 */
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				++workDays;
			}
		} while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); // excluding end date

		return workDays;
	}

	/**
	 * Count number of days between start date and end date.
	 *
	 * @param startDate the start date
	 * @param endDate   the end date
	 * @return {@link Integer}
	 *
	 *         19 :55:16 by tboudiche
	 */
	public static int getNbreDaysBetweenTwoDates(Date startDate, Date endDate) {

		Preconditions.checkArgument(startDate != null);
		Preconditions.checkArgument(endDate != null);

		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(endDate);
			endCal.setTime(startDate);
		}
		return (int) ChronoUnit.DAYS.between(startCal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
				endCal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
	}

	/**
	 * get last Date of year by given Date.
	 *
	 * @param date the date
	 * @return {@link Date} 2 mars 2017 - 15:45:31 by hbenizid
	 */
	public static Date getLastDateOfYear(Date date) {

		int year = getYearFromDate(date);
		Calendar calendarEnd = Calendar.getInstance();
		calendarEnd.set(Calendar.YEAR, year);
		calendarEnd.set(Calendar.MONTH, 11);
		calendarEnd.set(Calendar.DAY_OF_MONTH, 31);

		// returning the last date
		return calendarEnd.getTime();
	}

	/**
	 * get last Date of year by given year.
	 *
	 * @param year the year
	 * @return {@link Date} 17:39:32 by lneji
	 */
	public static Date getLastDateOfYear(Integer year) {

		Calendar calendarEnd = Calendar.getInstance();
		calendarEnd.set(Calendar.YEAR, year);
		calendarEnd.set(Calendar.MONTH, 11);
		calendarEnd.set(Calendar.DAY_OF_MONTH, 31);

		// returning the last date
		return calendarEnd.getTime();
	}

	/**
	 * get Difference Between Two Dates In Months.
	 *
	 * @param startDate the start date
	 * @param endDate   the end date
	 * @return {@link Integer} 4 avr. 2017 - 12:27:48 by hbenizid
	 */
	public static int getDifferenceBetweenTwoDatesInMonths(Date startDate, Date endDate) {

		Calendar startCalendar = new GregorianCalendar();
		startCalendar.setTime(startDate);
		Calendar endCalendar = new GregorianCalendar();
		endCalendar.setTime(endDate);

		int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);

		return (diffYear * 12) + (endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH));
	}

	/**
	 * get Difference Between Two Dates In Months And days.
	 *
	 * @param startDate the start date
	 * @param endDate   the end date
	 * @return {@link float}
	 */
	public static float getDifferenceBetweenTwoDatesInMonthsInDay(Date startDate, Date endDate) {

		Calendar startCalendar = new GregorianCalendar();
		startCalendar.setTime(startDate);
		Calendar endCalendar = new GregorianCalendar();
		endCalendar.setTime(endDate);

		int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);

		return (diffYear * 12) + (endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH))
				+ (float) (endCalendar.get(Calendar.DATE) - startCalendar.get(Calendar.DATE))
						/ endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * get Difference Between Two Dates In Years.
	 *
	 * @param startDate the start date
	 * @param endDate   the end date
	 * @return {@link Integer} 4 avr. 2017 - 12:27:48 by hbenizid
	 */
	public static int getDifferenceBetweenTwoDatesInYears(Date startDate, Date endDate) {

		Calendar startCalendar = new GregorianCalendar();
		startCalendar.setTime(startDate);
		Calendar endCalendar = new GregorianCalendar();
		endCalendar.setTime(endDate);

		return endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
	}

	/**
	 * returns the last day of month from given date.
	 *
	 * @param date the date
	 * @return {@link Integer} 12:09:29 by lneji
	 */
	@SuppressWarnings("deprecation")
	public static Date getLastDayOfMonth(Date date) {

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		date.setDate(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return date;
	}

	/**
	 * Get Last Day For Given Date
	 *
	 * @param date date
	 * @return {@link Integer}
	 */
	public static int getLastDayForGivenDate(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * returns the last day of month from given date.
	 *
	 * @param date the local date
	 * @return {@link LocalDate}
	 */
	public static LocalDate getLastDayOfMonth(LocalDate date) {

		return date.withDayOfMonth(date.lengthOfMonth());
	}

	/**
	 * returns the first day of month from given date.
	 *
	 * @param date the date
	 * @return {@link Integer} 10:11:12 by tboudiche
	 */
	@SuppressWarnings("deprecation")
	public static Date getFirstDayOfMonth(Date date) {

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		date.setDate(calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		return date;
	}

	/**
	 * returns the first day of month from given date.
	 *
	 * @param date the local date
	 * @return {@link LocalDate}
	 */
	public static LocalDate getFirstDayOfMonth(LocalDate date) {

		return date.withDayOfMonth(1);
	}

	/**
	 * Converter given Date to Date in format dd/MM/yyyy.
	 *
	 * @param date the date
	 * @return {@link Date} in format dd/mm/yyyy
	 *
	 *         17 juil. 2017 - 16:10:46 by hbenizid
	 */
	public static Date toDate(Date date) {

		Date dateOut = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
			String dateString = formatter.format(date);
			dateOut = formatter.parse(dateString);
		} catch (ParseException e) {
			logger.error("Failed to parse String to Date", e);
		}
		return dateOut;
	}

	/**
	 * return the biggest date value from list of dates.
	 *
	 * @param dates array list of dates
	 * @return the higher value of dates
	 */
	public static Date maxDateFromListDates(List<Date> dates) {

		try {
			if (!dates.isEmpty()) {
				return Collections.max(dates);
			} else {
				return null;
			}

		} catch (Exception e) {
			logger.error("Failed to extract the maximum element of the given collection", e);
			return null;
		}
	}

	/**
	 * return the lower date value from list of dates.
	 *
	 * @param dates array list of dates
	 * @return the lower value of dates
	 */
	public static Date minDateFromListDates(List<Date> dates) {

		try {
			if (!dates.isEmpty()) {
				return Collections.min(dates);
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error("Failed to extract the minimum element of the given collection", e);
			return null;
		}
	}

	/**
	 * Add days to a date: positive number would increment the days minus number
	 * would decrement the days
	 *
	 * @param date the date to increment
	 * @param days the number of days to add
	 * @return the incremented date with x days
	 */
	public static Date addDays(Date date, int days) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	/**
	 * Converts a Date to LocalDate
	 *
	 * @param date the date to convert
	 * @return converted date
	 */
	public static LocalDate dateToLocalDate(Date date) {

		if (date == null) {
			return null;
		}
		// Pour ne pas avoir UnsupportedOperationException dans le cas ou "date" est de
		// type java.sql.Date
		java.util.Date safeDate = new Date(date.getTime());
		return safeDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	/**
	 * Converts a LocalDate to Date
	 *
	 * @param date the date to convert
	 * @return converted date
	 */
	public static Date localDateToDate(LocalDate date) {

		if (date == null) {
			return null;
		}
		return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Gets month from date.
	 *
	 * @param date the date
	 * @return int Value of MONTH from given Date
	 */
	public static int getExactMonthFromDate(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}

	/**
	 * Convertie une Date en chaine au format JJ/MM.
	 *
	 * @param date Date
	 * @return Chaine date.
	 */
	public static String toStringDateAndMonth(Date date) {

		if (date != null) {
			return new SimpleDateFormat(DATE_FORMAT_DAY_AND_MONTH).format(date);
		} else {
			return null;
		}
	}

	/**
	 * return the previous day date
	 *
	 * @param date param date
	 * @return Date the previous day
	 */
	public static Date getDayBefore(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}

	/**
	 * return the day after date
	 *
	 * @param date param date
	 * @return Date the previous day
	 */
	public static Date getDayAfter(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, +1);
		return calendar.getTime();
	}

	/**
	 *
	 * @param date   date
	 * @param short1 number of days time
	 * @return date
	 */
	public static Date getNDaysBefore(Date date, Short short1) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, (-1) * short1);
		return calendar.getTime();
	}

	/**
	 * Get current date without time
	 * @return the current date
	 */
	public static Date getDateWithoutTimeUsingCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * Retourne la date passée en paramètre et {@link #MAX_DATE} si null.
	 * @param date la date à tester
	 * @return la date ou {@link #MAX_DATE} si null
	 */
	public static Date getMaxDateIfNull(Date date) {
		return date == null ? Date.from(Instant.parse(MAX_DATE)) : date;
	}

	/**
	 * Retourne la date passée en paramètre et {@link #MIN_DATE} si null.
	 * @param date la date à tester
	 * @return la date ou {@link #MIN_DATE} si null
	 */
	public static Date getMinDateIfNull(Date date) {
		return date == null ? Date.from(Instant.parse(MIN_DATE)) : date;
	}
}
