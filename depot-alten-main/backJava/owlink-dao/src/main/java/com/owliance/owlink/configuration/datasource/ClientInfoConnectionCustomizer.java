package com.owliance.owlink.configuration.datasource;

import com.mchange.v2.c3p0.ConnectionCustomizer;
import com.owliance.owlink.framework.constants.OwlinkConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ConnectionCustomizer that set the CLIENT_INFO information for the connection
 * each time it is checked out
 */
public class ClientInfoConnectionCustomizer implements ConnectionCustomizer {
    /**
     * The Constant logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(ClientInfoConnectionCustomizer.class);

    private static final String APPLICATION_NAME = "OwlinkByTessi";

    @Override
    public void onAcquire(Connection c, String parentDataSourceIdentityToken) {
        logger.trace("Acquired " + c + " [" + parentDataSourceIdentityToken + "]");
        String setModuleSql = "{ call DBMS_APPLICATION_INFO.SET_MODULE( module_name => '" + APPLICATION_NAME + "', action_name => '" + APPLICATION_NAME + "')}";
        try (Statement stmt2 = c.createStatement()) {
            logger.debug("call to {}", setModuleSql);
            stmt2.executeUpdate(setModuleSql);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void onDestroy(Connection c, String parentDataSourceIdentityToken) {
        logger.trace("Destroying " + c + " [" + parentDataSourceIdentityToken + "]");
    }

    @Override
    public void onCheckOut(Connection c, String parentDataSourceIdentityToken) throws Exception {
        logger.trace("Checked out " + c + " [" + parentDataSourceIdentityToken + "]");
        String setClientInfoSql = "{ call DBMS_APPLICATION_INFO.SET_CLIENT_INFO (client_info=>'" + getUserName() + "') }";
        try (Statement stmt = c.createStatement()) {
            logger.debug("call to {}", setClientInfoSql);
            stmt.executeUpdate(setClientInfoSql);
        }
    }

    @Override
    public void onCheckIn(Connection c, String parentDataSourceIdentityToken) {
        logger.trace("Checking in " + c + " [" + parentDataSourceIdentityToken + "]");
    }

    /**
     * Get the connected userName from the security context.
     * If not found or if "owl" then return "MUTIX"
     *
     * @return the connected username
     */
    private String getUserName() {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            return OwlinkConstants.ADMIN;
        } else {
            return SecurityContextHolder.getContext().getAuthentication().getName().toUpperCase();
        }
    }
}
