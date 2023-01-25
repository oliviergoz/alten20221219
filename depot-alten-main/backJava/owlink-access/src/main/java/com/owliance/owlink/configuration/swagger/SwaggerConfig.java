/*
 * Copyright Owliance © 2016 - 2017 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.configuration.swagger;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * class SwaggerConfig.java
 *
 * @author hbenizid
 * @since 0.5.6-Alpha
 *
 * @see com.owliance.owlink.configuration.swagger
 *
 *      <p>
 *      Created : 18 oct. 2017
 *      <p>
 *      Updated : 18 oct. 2017 by hbenizid (version 0.5.6-Alpha)
 *
 */
@Configuration
@ConditionalOnExpression(value = "${useSwagger:false}")
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

	/** The title. */
	@Value(value = "${owlink.swagger.title}")
	private String	title;

	/** The description. */
	@Value(value = "${owlink.swagger.description}")
	private String	description;

	/** The version. */
	@Value(value = "${owlink.swagger.version}")
	private String	version;

	/** The terms of service url. */
	@Value(value = "${owlink.swagger.termsOfServiceUrl}")
	private String	termsOfServiceUrl;

	/** The contact name. */
	@Value(value = "${owlink.swagger.contactName}")
	private String	contactName;

	/** The contact mail. */
	@Value(value = "${owlink.swagger.contactMail}")
	private String	contactMail;

	/** The contact url. */
	@Value(value = "${owlink.swagger.contactUrl}")
	private String	contactUrl;

	/** The license. */
	@Value(value = "${owlink.swagger.license}")
	private String	license;

	/** The license url. */
	@Value(value = "${owlink.swagger.licenseUrl}")
	private String	licenseUrl;

	/**
	 * owlink-manager ws - Api.
	 *
	 * ++ scan All package : .apis(RequestHandlerSelectors.any())
	 *
	 * ++ scan specific package :
	 * .apis(RequestHandlerSelectors.basePackage("com.owliance.owlink.controller"))
	 *
	 * ++ All ws : .paths(PathSelectors.any()) / .paths(PathSelectors.regex("/api/*"))
	 *
	 * @return the docket
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex("/api.*")).build().apiInfo(metaData());
	}

	/**
	 * Meta data.
	 *
	 * @return the api info
	 */
	private ApiInfo metaData() {
		return new ApiInfoBuilder().title(title).description(description).version(version).license(license)
				.licenseUrl(licenseUrl).contact(new Contact(contactName, contactUrl, contactMail)).build();
	}

	/*
	 * @see
	 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers(
	 * org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
