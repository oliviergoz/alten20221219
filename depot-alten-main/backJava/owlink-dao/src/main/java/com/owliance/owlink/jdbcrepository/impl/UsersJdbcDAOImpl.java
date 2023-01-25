/*
 * Copyright Owliance © 2016 - 2018 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.jdbcrepository.impl;


import com.owliance.owlink.framework.constants.OwlinkConstants;
import com.owliance.owlink.framework.constants.OwlinkMessages;
import com.owliance.owlink.framework.constants.OwlinkQuery;
import com.owliance.owlink.framework.exception.OwlinkRuntimeException;
import com.owliance.owlink.framework.service.BaseService;
import com.owliance.owlink.jdbcrepository.UsersJdbcDAO;
import com.owliance.owlink.jdbcrepository.utils.CheckUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Description of the class AdcJdbcDAOImpl.java
 *
 * @author aabdennabi
 * @see com.owliance.owlink.jdbcrepository.impl
 *
 *
 * <p>
 * Created : 23 mars 2018 - 14:48:15 by aabdennabi (version 0.6.6-Alpha)
 * @since 0.6.6-Alpha
 */
@Repository
public class UsersJdbcDAOImpl extends BaseService implements UsersJdbcDAO {

    /**
     * Logger class for AdcJdbcDAOImpl, Default Mode is INFO.
     */
    private static final Logger logger = LoggerFactory.getLogger(UsersJdbcDAOImpl.class);

    /**
     * The localized entity value.
     */
    public static final String SQL_REQUEST_ALTER_USER = "ALTER USER ";

    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * @see UsersJdbcDAO#alterUserForNewPassWord(String, String, String)
     */
    @Override
    public void alterUserForNewPassWord(String userName, String newPassword, String oldPassword) throws SQLException {
        CheckUtils.checkJdbcTemplateNotNull(logger, jdbcTemplate);
        Statement st = null;
        DataSource dataSource = jdbcTemplate.getDataSource();
        if (dataSource == null) {
            return;
        }
        try (Connection dbConnection = dataSource.getConnection()) {
            st = dbConnection.createStatement();
            String query = oldPassword != null && !"".equals(oldPassword) ? SQL_REQUEST_ALTER_USER + userName + " IDENTIFIED BY \"" + newPassword + "\" REPLACE \"" + oldPassword + "\""
                    : SQL_REQUEST_ALTER_USER + userName + " IDENTIFIED BY " + newPassword;
            st.execute(query);
            logger.info("Password changed.");
        } catch (SQLException e) {
            logger.error(OwlinkMessages.ERROR_SQLEXCEPTION_OCCURED, e);
            logger.error(OwlinkMessages.ERROR_CODE, e.getErrorCode());
            logger.error(OwlinkMessages.ERROR_MSG, e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(OwlinkMessages.DATA_INTEGRITY_CHECK1, e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e1) {
                    logger.error(OwlinkMessages.ERROR_CLOSING_STATEMENT, e1);
                }
            }
        }
    }

    /**
     * @see UsersJdbcDAO#blockOrUnblockUser(String, String)
     */
    @Override
    public void blockOrUnblockUser(String userName, String action) throws SQLException {
        CheckUtils.checkJdbcTemplateNotNull(logger, jdbcTemplate);
        Statement st = null;
        DataSource dataSource = jdbcTemplate.getDataSource();
        if (dataSource == null) {
            return;
        }
        try (Connection dbConnection = dataSource.getConnection()) {
            st = dbConnection.createStatement();
            String lockOrUnlock = OwlinkConstants.UNLOCK_USER.equals(action) ? " ACCOUNT UNLOCK" : " ACCOUNT LOCK";
            st.execute(SQL_REQUEST_ALTER_USER + userName + lockOrUnlock);
            String message = OwlinkConstants.UNLOCK_USER.equals(action) ? "USER OPEN" : "USER LOCKED";
            logger.info(message);
        } catch (SQLException e) {
            logger.error(OwlinkMessages.ERROR_SQLEXCEPTION_OCCURED, e);
            logger.error(OwlinkMessages.ERROR_CODE, e.getErrorCode());
            logger.error(OwlinkMessages.ERROR_MSG, e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(OwlinkMessages.DATA_INTEGRITY_CHECK1, e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e1) {
                    logger.error(OwlinkMessages.ERROR_CLOSING_STATEMENT, e1);
                }
            }
        }
    }

    /**
     * @see UsersJdbcDAO#dropUserByUserName(String)
     */
    @Override
    public void dropUserByUserName(String userName) {
        logger.info("Execute function Securite.Drop_User to Delete User");
        try {
            if (jdbcTemplate == null) {
                logger.info(OwlinkMessages.NOT_FOUND_OBJECT, "Jdbc");
                throw new OwlinkRuntimeException(OwlinkMessages.ERROR_NO_JDBC_WAS_FOUND, null);
            }
            logger.info(OwlinkMessages.EXECUTE_PROCEDURE_P_CHGCODETIERS);
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(OwlinkConstants.ADMIN).withCatalogName("Securite").withProcedureName("Drop_User");
            SqlParameterSource in = new MapSqlParameterSource().addValue("Nom", userName);
            simpleJdbcCall.execute(in);
            logger.info(OwlinkMessages.PROCEDURE_SUCCESSFULLY_EXECUTED);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(OwlinkMessages.DATA_INTEGRITY_CHECK1, e);
        }
    }

    /**
     * check Existing Table User Requete
     * @return res the var to check existance of table user requête
     * @throws SQLException the SQL exception
     */
    public boolean checkExistingTableUserRequete() throws SQLException {
        CheckUtils.checkJdbcTemplateNotNull(logger, jdbcTemplate);
        Statement st = null;
        DataSource dataSource = jdbcTemplate.getDataSource();
        if (dataSource == null) {
            return false;
        }
        try (Connection dbConnection = dataSource.getConnection()) {
            st = dbConnection.createStatement();
            return st.execute(OwlinkQuery.CHECK_EXISTING_TABLE_USER_REQUETE);
        } catch (SQLException e) {
            logger.error(OwlinkMessages.ERROR_SQLEXCEPTION_OCCURED, e);
            logger.error(OwlinkMessages.ERROR_CODE, e.getErrorCode());
            logger.error(OwlinkMessages.ERROR_MSG, e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(OwlinkMessages.DATA_INTEGRITY_CHECK1, e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e1) {
                    logger.error(OwlinkMessages.ERROR_CLOSING_STATEMENT, e1);
                }
            }
        }
        return false;
    }


    /**
     * drop Existing Table User Requete
     * @throws SQLException the SQL exception
     */
    public void dropExistingTableUserRequete() throws SQLException {
        CheckUtils.checkJdbcTemplateNotNull(logger, jdbcTemplate);
        Statement st = null;
        DataSource dataSource = jdbcTemplate.getDataSource();
        if (dataSource == null) {
            return;
        }
        try (Connection dbConnection = dataSource.getConnection()) {
            st = dbConnection.createStatement();
            st.execute(OwlinkQuery.DROP_TABLE_USER_REQUETE);
        } catch (SQLException e) {
            logger.error(OwlinkMessages.ERROR_SQLEXCEPTION_OCCURED, e);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(OwlinkMessages.DATA_INTEGRITY_CHECK1, e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e1) {
                    logger.error(OwlinkMessages.ERROR_CLOSING_STATEMENT, e1);
                }
            }
        }
    }

    /**
     * create Table User Requete
     * @throws SQLException the SQL exception
     */
    public void createTableUserRequete() throws SQLException {
        CheckUtils.checkJdbcTemplateNotNull(logger, jdbcTemplate);
        Statement st = null;
        DataSource dataSource = jdbcTemplate.getDataSource();
        if (dataSource == null) {
            return;
        }
        try (Connection dbConnection = dataSource.getConnection()) {
            st = dbConnection.createStatement();
            st.execute(OwlinkQuery.CREATE_TABLE_USER_REQUETE);
        } catch (SQLException e) {
            logger.error(OwlinkMessages.ERROR_SQLEXCEPTION_OCCURED, e);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(OwlinkMessages.DATA_INTEGRITY_CHECK1, e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e1) {
                    logger.error(OwlinkMessages.ERROR_CLOSING_STATEMENT, e1);
                }
            }
        }
    }

    /**
     * check Existing Table User Menu
     * @return res the var to check existance of table user Menu
     * @throws SQLException the SQL exception
     */
    public boolean checkExistingTableUserMenu() throws SQLException {
        CheckUtils.checkJdbcTemplateNotNull(logger, jdbcTemplate);
        Statement st = null;
        DataSource dataSource = jdbcTemplate.getDataSource();
        if (dataSource == null) {
            return false;
        }
        try (Connection dbConnection = dataSource.getConnection()) {
            st = dbConnection.createStatement();
            return st.execute(OwlinkQuery.CHECK_EXISTING_TABLE_USER_MENU);
        } catch (SQLException e) {
            logger.error(OwlinkMessages.ERROR_SQLEXCEPTION_OCCURED, e);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(OwlinkMessages.DATA_INTEGRITY_CHECK1, e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e1) {
                    logger.error(OwlinkMessages.ERROR_CLOSING_STATEMENT, e1);
                }
            }
        }
        return false;
    }

    /**
     * drop Existing Table User Menu
     * @throws SQLException the SQL exception
     */
    public void dropExistingTableUserMenu() throws SQLException {
        CheckUtils.checkJdbcTemplateNotNull(logger, jdbcTemplate);
        Statement st = null;
        DataSource dataSource = jdbcTemplate.getDataSource();
        if (dataSource == null) {
            return;
        }
        try (Connection dbConnection = dataSource.getConnection()) {
            st = dbConnection.createStatement();
            st.execute(OwlinkQuery.DROP_TABLE_USER_MENU);
        } catch (SQLException e) {
            logger.error(OwlinkMessages.ERROR_SQLEXCEPTION_OCCURED, e);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(OwlinkMessages.DATA_INTEGRITY_CHECK1, e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e1) {
                    logger.error(OwlinkMessages.ERROR_CLOSING_STATEMENT, e1);
                }
            }
        }
    }

    /**
     * create Table User Menu
     * @throws SQLException the SQL exception
     */
    public void createTableUserMenu() throws SQLException {
        CheckUtils.checkJdbcTemplateNotNull(logger, jdbcTemplate);
        Statement st = null;
        DataSource dataSource = jdbcTemplate.getDataSource();
        if (dataSource == null) {
            return;
        }
        try (Connection dbConnection = dataSource.getConnection()) {
            st = dbConnection.createStatement();
            st.execute(OwlinkQuery.CREATE_TABLE_USER_MENU);
        } catch (SQLException e) {
            logger.error(OwlinkMessages.ERROR_SQLEXCEPTION_OCCURED, e);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(OwlinkMessages.DATA_INTEGRITY_CHECK1, e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e1) {
                    logger.error(OwlinkMessages.ERROR_CLOSING_STATEMENT, e1);
                }
            }
        }
    }
}
