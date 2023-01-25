package com.owliance.owlink.jdbcrepository;

import java.sql.SQLException;

/**
 * L'interface ConnectDbDAO est utilisée pour connecter à la base de données
 *
 * @author dabida
 * Created: 03 Aout. 2021
 */
public interface ConnectDbDAO {

    /**
     * connect jdbc oracle
     * @param password the password
     * @param username the username
     * @throws SQLException exception sql levée si l'authentification échoue
     * @return the boolean
     */
    boolean connectJdbcOracle(String password, String username) throws SQLException;
}
