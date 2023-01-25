/*
 * Copyright Owliance © 2016 - 2017 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.configuration.app;


import com.owliance.owlink.configuration.swagger.SwaggerConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;


/**
 * class AppConfig.java
 *
 * @author hbenizid
 * @since 0.5.6-Alpha
 *
 * @see com.owliance.owlink.configuration.app
 *
 *      <p>
 *      Created : 18 oct. 2017
 *      <p>
 *      Updated : 18 oct. 2017 by hbenizid (version 0.5.6-Alpha)
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.owliance.owlink.controller" })
@Import(SwaggerConfig.class)
public class AppConfig implements WebMvcConfigurer {

	/*
	 * @see
	 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.
	 * springframework.web.servlet.config.annotation.InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LocaleChangeInterceptor());
	}
}
