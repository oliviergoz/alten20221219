/*
 * Copyright Owliance © 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.access.provider;


import com.owliance.owlink.framework.constants.OwlinkConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jdbc.support.ConnectionUsernameProvider;
import org.springframework.security.core.context.SecurityContextHolder;


/**
 * Description of the class UserProvider.java
 *
 * @author hbenizid
 * @see com.owliance.owlink.access.provider
 *
 * <p>
 * Created : 10 nov. 2016
 * <p>
 * Updated : 11 nov. 2016 by hbenizid (version 0.3.0-Alpha)
 * <p>
 * Updated : 28 nov. 2016 by hbenizid (version 0.3.1-Alpha)
 * @since 0.3.0-Alpha
 */
public class UserProvider implements ConnectionUsernameProvider {

    /**
     * Default Mode is INFO
     */
    private static final Logger logger = LoggerFactory.getLogger(UserProvider.class);

    /**
     * return the username of the current security context
     * the user provided by the current request
     *
     * @return {@link String}
     */
    @Override
    public String getUserName() {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            return OwlinkConstants.ADMIN;
        } else if ("owl".equalsIgnoreCase(SecurityContextHolder.getContext().getAuthentication().getName())) {
            logger.warn("### - Check Client-ID : [{}]",
                    SecurityContextHolder.getContext().getAuthentication().getName().toUpperCase());
            return OwlinkConstants.ADMIN;
        } else {
            return SecurityContextHolder.getContext().getAuthentication().getName().toUpperCase();
        }
    }
}
