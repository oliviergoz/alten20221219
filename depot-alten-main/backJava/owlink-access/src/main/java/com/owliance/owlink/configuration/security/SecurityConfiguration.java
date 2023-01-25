/*
 * Copyright Owliance © 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.configuration.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Description of the class SecurityConfiguration.java
 * @author hbenizid
 * @see com.owliance.owlink.configuration.security
 *
 * <p>
 * Created : 21 nov. 2016
 * <p>
 * Updated : 28 nov. 2016 by hbenizid (version 0.3.1-Alpha)
 * @since 0.3.1-Alpha
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * The user authentication provider.
     */
    @Autowired
    public AuthenticationProvider userAuthenticationProvider;

    /**
     * The user details service.
     */
    @Autowired
    public UserDetailsService userDetailsService;

    /**
     * The Constant LOG.
     */
    public static final Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);

    /**
     * Global user details.
     * @param auth the auth
     * @throws Exception the exception
     */
    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {

        logger.info("AuthenticationManagerBuilder");
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }

    /**
     * Password encoder.
     * @return the password encoder
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        logger.info("Returning BCryptPasswordEncoder PasswordEncoder");
        return new BCryptPasswordEncoder();
    }

    /**
     * get encoder bean
     * @return encoder bean
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new OwlinkWebEncoder();
    }

    /**
     * Authentication provider.
     * @return the dao authentication provider
     * @throws Exception the exception
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() throws Exception {

        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsServiceBean());
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        logger.info("Returning DaoAuthenticationProvider ");
        return authenticationProvider;
    }

    /*
     * @see
     * org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#
     * configure(org.springframework.security.config.annotation.web.builders.WebSecurity)
     */
    @Override
    public void configure(WebSecurity web) throws Exception {

        logger.info("Configure (WebSecurity web)");
        web.ignoring().antMatchers(
            "/resources/**",
            "/v2/api-docs",
            "/configuration/**",
            "/swagger-resources/**",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/api/**"
        );
    }

    /*
     * @see
     * org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#
     * authenticationManagerBean()
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {

        logger.info("Returning AuthenticationManager ");
        return super.authenticationManagerBean();
    }

    /*
     * @see
     * org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#
     * configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        logger.info("SecurityConfiguration : Method = configure (HttpSecurity http) ");
        http.authorizeRequests().antMatchers("/swagger-ui.html").permitAll().anyRequest().hasRole("USER");
        http.csrf().disable();

    }

    /*
     * @see
     * org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#
     * userDetailsServiceBean()
     */
    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {

        logger.info("SecurityConfiguration : Method = userDetailsServiceBean");
        return new OwlinkWebUserDetailService();
    }
}
