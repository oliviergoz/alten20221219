/*
 * Copyright Owliance © 2016 - 2018 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.framework.constants;

/**
 * Description of the class ...
 *
 * @author hbenizid
 * @see com.owliance.owlink.framework.constants
 *      <p>
 *      <p>
 * Created : 20 juil. 2016
 *      <p>
 *      Updated : 20 juil. 2016 by hbenizid (version 0.2.0-Alpha)
 *      <p>
 *      Updated : 02 nov. 2016 by tboudiche (version 0.3.0-Alpha)
 *      <p>
 *      Updated : 21 déc. 2016 by abayoudh (version 0.3.2-Alpha)
 * @since 0.2.0-Alpha
 */
public class OwlinkQuery {

	/**
	 * Query to check existing table with name user_requete
	 */
	public static final String CHECK_EXISTING_TABLE_USER_REQUETE = "select count(*) from user_tables WHERE table_name = 'USER_REQUETE'";

	/**
	 * Query to drop table with name user_requete
	 */
	public static final String DROP_TABLE_USER_REQUETE = "drop table USER_REQUETE";

	/**
	 * Query to create table with name user_requete
	 */
	public static final String CREATE_TABLE_USER_REQUETE = "create table USER_REQUETE(USER_NOM VARCHAR2(31), ID_REQUETE NUMBER)";

	/**
	 * Query to check existing table with name user_menu
	 */
	public static final String CHECK_EXISTING_TABLE_USER_MENU = "select count(*) from user_tables WHERE table_name = 'USER_MENU'";

	/**
	 * Query to drop table with name user_menu
	 */
	public static final String DROP_TABLE_USER_MENU = "drop table USER_MENU";

	/**
	 * Query to create table with name user_menu
	 */
	public static final String CREATE_TABLE_USER_MENU = "create table USER_MENU(USER_NOM VARCHAR2(31), ID_MENU NUMBER)";
}
