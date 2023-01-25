package com.owliance.owlink.jdbcrepository.utils;

import com.owliance.owlink.framework.constants.OwlinkMessages;
import com.owliance.owlink.framework.exception.OwlinkRuntimeException;
import org.slf4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

public class CheckUtils {

    /**
     * Check if JDBCTemplate is null
     * if it is then throws a @{@link OwlinkRuntimeException}
     *
     * @param logger       a logger to log...
     * @param jdbcTemplate the jdbcTemplate to test
     */
    public static void checkJdbcTemplateNotNull(Logger logger, JdbcTemplate jdbcTemplate) {
        logger.info(OwlinkMessages.CHECK_JDBCTEMPLATE_IS_NULL);
        if (jdbcTemplate == null) {
            logger.info(OwlinkMessages.NOT_FOUND_OBJECT, "JDBC");
            throw new OwlinkRuntimeException(OwlinkMessages.ERROR_NO_JDBC_WAS_FOUND, null);
        }
    }
}
