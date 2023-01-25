/*
 * Copyright Owliance 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.configuration.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;


/**
 * Description of the class OwlinkWebServerConfig.java
 *
 * @author hbenizid
 * @since 0.3.1-Alpha
 * 
 * @see com.owliance.owlink.configuration.security
 *
 *      <p>
 *      Created : 21 nov. 2016
 *      <p>
 *      Updated : 28 nov. 2016 by hbenizid (version 0.3.1-Alpha)
 *
 */
@Configuration
public class OwlinkWebServerConfig {

	/**
	 * The Constant OWLINK_WEB_RESOURCE_ID.
	 */
	public static final String OWLINK_WEB_RESOURCE_ID = "owlink-access";

	/**
	 * Description of the class OwlinkWebServerConfig.java
	 *
	 * @author hbenizid
	 * @since 0.3.1-Alpha
	 * 
	 * @see com.owliance.owlink.configuration.security
	 *
	 *      <p>
	 *      Created : 21 nov. 2016
	 *      <p>
	 *      Updated : 23 nov. 2016 by hbenizid (version 0.3.1-Alpha)
	 *
	 */
	@Configuration
	@EnableResourceServer
	protected static class ResourceServerConfig extends ResourceServerConfigurerAdapter {

		/*
		 * @see org.springframework.security.oauth2.config.annotation.web.configuration.
		 * ResourceServerConfigurerAdapter#configure(org.springframework.security.oauth2.config.
		 * annotation.web.configurers.ResourceServerSecurityConfigurer)
		 */
		@Override
		public void configure(ResourceServerSecurityConfigurer resources) {

			resources.resourceId(OWLINK_WEB_RESOURCE_ID).stateless(true);
		}

		/*
		 * @see org.springframework.security.oauth2.config.annotation.web.configuration.
		 * ResourceServerConfigurerAdapter#configure(org.springframework.security.config.annotation.
		 * web.builders.HttpSecurity)
		 */
		@Override
		public void configure(HttpSecurity http) throws Exception {

			// @formatter:off
			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().requestMatchers()
					.antMatchers("/api/**").and().authorizeRequests().antMatchers("/api/**")
					.access("#oauth2.hasScope('read') or (!#oauth2.isOAuth() and hasRole('USER'))");
			// @formatter:on
		}

	}

	/**
	 * Description of the class OwlinkWebServerConfig.java
	 *
	 * @author hbenizid
	 * @see com.owliance.owlink.configuration.security
	 *      <p>
	 *      Created : 21 nov. 2016
	 *      <p>
	 *      Updated : 23 nov. 2016 by hbenizid (version 0.3.1-Alpha)
	 * @since 0.3.1 -Alpha
	 */
	@Configuration
	@EnableAuthorizationServer
	protected static class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

		/** The datasource. */
		@Autowired
		private DataSource				datasource;

		/** The authentication manager. */
		@Autowired
		@Qualifier("authenticationManagerBean")
		private AuthenticationManager	authenticationManager;

		/** The schema script. */
		@Value("classpath:security-schema.sql")
		private Resource					schemaScript;

		/**
		 * Token store.
		 *
		 * @return the token store
		 */
		@Bean
		public TokenStore tokenStore() {

			return new JdbcTokenStore(datasource);
		}

		/*
		 * @see org.springframework.security.oauth2.config.annotation.web.configuration.
		 * AuthorizationServerConfigurerAdapter#configure(org.springframework.security.oauth2.config.
		 * annotation.configurers.ClientDetailsServiceConfigurer)
		 */
		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

			clients.jdbc(datasource);

		}

		/*
		 * @see org.springframework.security.oauth2.config.annotation.web.configuration.
		 * AuthorizationServerConfigurerAdapter#configure(org.springframework.security.oauth2.config.
		 * annotation.web.configurers.AuthorizationServerEndpointsConfigurer)
		 */
		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

			endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager);
		}

		/**
		 * Data source initializer.
		 *
		 * @param dataSource the data source
		 * @return the data source initializer
		 */
		// @Bean
		// public DataSourceInitializer dataSourceInitializer (final DataSource dataSource) {
		//
		// final DataSourceInitializer initializer = new DataSourceInitializer();
		// initializer.setDataSource(dataSource);
		// initializer.setDatabasePopulator(databasePopulator());
		// return initializer;
		// }

		/**
		 * Database populator.
		 *
		 * @return the database populator
		 */
		// private DatabasePopulator databasePopulator () {
		//
		// final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		// populator.addScript(schemaScript);
		// return populator;
		// }

	}

}
