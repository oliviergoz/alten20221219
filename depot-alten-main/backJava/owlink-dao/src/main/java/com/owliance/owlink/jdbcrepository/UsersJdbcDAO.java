/**
 * Copyright Owliance © 2016 - 2017 ,All right reserved
 * <p>
 * Owliance PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.owliance.owlink.jdbcrepository;


import java.sql.SQLException;


/**
 * Description of the class AdcJdbcDAO.java
 *
 * @author aabdennabi
 * @since 0.6.6-Alpha
 * @see com.owliance.owlink.jdbcrepository
 *
 *      <p>
 *      Created : 23 mars 2018 - 14:48:15 by aabdennabi (version 0.6.6-Alpha)
 */
public interface UsersJdbcDAO {

	/**
	 * Alter user for new pass word.
	 *
	 * @param userName the user name
	 * @param newPassword the new password
	 * @param oldPassword the old password
	 * @throws SQLException
	 *
	 *            23 mars 2018 - 16:11:27 by aabdennabi
	 */
	void alterUserForNewPassWord(String userName, String newPassword, String oldPassword) throws SQLException;


	/**
	 * block or unblock user
	 *
	 * @param userName the user name
	 * @param action the block or unblock
	 * @throws SQLException
	 *
	 *            23 mars 2018 - 16:11:27 by aabdennabi
	 */
	void blockOrUnblockUser(String userName, String action) throws SQLException;

    /**
     * Drop User using userName
     *
     * @param userName userName
     */
    void dropUserByUserName(String userName);

	/**
	 * check Existing Table User Requete
	 * @return res the var to check existance of table user requête
	 * @throws SQLException the SQL Exception
	 */
	boolean checkExistingTableUserRequete() throws SQLException;

	/**
	 * drop Existing Table User Requete
	 * @throws SQLException the SQL Exception
	 */
	void dropExistingTableUserRequete() throws SQLException;

	/**
	 * create Table User Requete
	 * @throws SQLException the SQL Exception
	 */
	void createTableUserRequete() throws SQLException;

	/**
	 * check Existing Table User Menu
	 * @return res the var to check existance of table user Menu
	 * @throws SQLException the SQL Exception
	 */
	boolean checkExistingTableUserMenu() throws SQLException;

	/**
	 * drop Existing Table User Menu
	 * @throws SQLException the SQL Exception
	 */
	void dropExistingTableUserMenu() throws SQLException;

	/**
	 * create Table User Menu
	 * @throws SQLException the SQL Exception
	 */
	void createTableUserMenu() throws SQLException;
}
