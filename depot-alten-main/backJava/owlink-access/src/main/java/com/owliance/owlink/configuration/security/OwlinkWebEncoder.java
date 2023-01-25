package com.owliance.owlink.configuration.security;

import com.owliance.owlink.framework.constants.OwlinkMessages;
import com.owliance.owlink.jdbcrepository.ConnectDbDAO;
import com.owliance.owlink.jdbcrepository.UsersJdbcDAO;
import com.owliance.owlink.repository.UsersRepositoryPDAO;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.sql.SQLException;

public class OwlinkWebEncoder implements PasswordEncoder {

    @Resource
    private ConnectDbDAO connectDbDAO;

    @Resource
    private UsersRepositoryPDAO usersRepositoryPDAO;

    @Resource
    private UsersJdbcDAO usersJdbcDAO;

    /**
     * encode plain password
     *
     * @param rawPassword non encoded password
     * @return encoded password
     */
    @Override
    public String encode(CharSequence rawPassword) {
        //TODO cryptage pas encore développer LOT3
        return "test";
    }

    /**
     * encode the rawpassword
     *
     * @param rawPassword     password not encoded
     * @param encodedPassword encoded password it's the spare4 value
     * @return match status
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            return connectDbDAO.connectJdbcOracle(rawPassword.toString(), username);
        } catch (SQLException e) {
            checkException(e, username);
        }
        return false;
    }

    /**
     * Méthode interprétant l'exception sql retournée et lance le traitement approprié selon l'erreur
     * @param ex l'exception sql
     * @param username le nom d'utilisateur
     */
    private void checkException(SQLException ex, String username) {
        if (ex.getErrorCode() == 1017) {
            // Au bout de 3 tentatives ratees on bloque le compte
            if (usersRepositoryPDAO.getNumberOfInvalidLoginAttempts(username) == 3) {
                try {
                    usersJdbcDAO.blockOrUnblockUser(username, "LOCK");
                    throw new LockedException(OwlinkMessages.USER_BLOCKED);
                } catch (SQLException e) {
                    ex.printStackTrace();
                }
            }
        } else if (ex.getErrorCode() == 28000) {
            throw new LockedException(OwlinkMessages.USER_BLOCKED);
        } else {
            ex.printStackTrace();
        }
    }
}
