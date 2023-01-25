/*
 * Copyright Owliance © 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.framework.controller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import com.owliance.owlink.framework.entity.BaseBVO;
import com.owliance.owlink.framework.entity.BaseUI;
import com.owliance.owlink.framework.webservices.BaseWVO;


/**
 * Class base for all Controllers
 *
 * @author fmartinez
 * @since 0.3.2-Alpha
 * @see com.owliance.owlink.framework.controller
 *      <p>
 *      Created : 12 dec. 2016
 *      <p>
 *      Updated : 14 dec. 2016 by fmartinez (version 0.3.2-Alpha)
 *      <p>
 *      Updated : 26 dec. 2016 by hbenizid (version 0.3.2-Alpha)
 *      <p>
 *      Updated : 07 mar. 2017 by fmartinez (version 0.3.6-Alpha) : add constructors
 */
public abstract class BaseController {

	/**
	 * Logger class for BaseService, Default Mode is INFO
	 */
	private static final Logger						 logger = LoggerFactory.getLogger(BaseController.class);

	/*
	 * Injecting Mapper
	 */
	@Resource
	private Mapper											 mapper;

	/** The message source. */
	@Autowired
	private ReloadableResourceBundleMessageSource messageSource;

	/**
	 * default constructor
	 */
	public BaseController() {
	}

	/**
	 * constructor with parameters
	 *
	 * @param mapper {@link Mapper}
	 */
	public BaseController(Mapper mapper) {
		this.mapper = mapper;
	}

	/**
	 * Convert a UI to a BVO.
	 *
	 * @param <T> the type parameter
	 * @param <S> the type parameter
	 * @param ui the ui
	 * @param bvoClass the bvo class
	 *
	 * @return {@link BaseBVO}
	 *         <p>
	 *         Example : TarifBVO bvo = uiToBvo(ui, TarifBVO.class);
	 *         <p>
	 *         Created : 12 dec. 2016 by fmartinez (version 0.3.2-Alpha)
	 *         <p>
	 *         Updated : 14 dec. 2016 by fmartinez (version 0.3.2-Alpha) : checks whether UI is not
	 *         null. 09:59:26 by hbenizid
	 */
	@SuppressWarnings("unchecked")
	public <T extends BaseBVO, S extends BaseUI> T uiToBvo(S ui, Class<? extends BaseBVO> bvoClass) {

		if (ui != null) {
			return (T) mapper.map(ui, bvoClass);
		}
		else {
			return null;
		}
	}

	/**
	 * Convert a BVO to a UI.
	 *
	 * @param <T> the type parameter
	 * @param <S> the type parameter
	 * @param bvo the bvo
	 * @param uiClass the ui class
	 *
	 * @return {@link BaseUI}
	 *         <p>
	 *         Example : TarifUI ui = bvoToUi(bvo, TarifUI.class);
	 *         <p>
	 *         Created : 12 dec. 2016 by fmartinez (version 0.3.2-Alpha)
	 *         <p>
	 *         Updated : 14 dec. 2016 by fmartinez (version 0.3.2-Alpha) : checks whether BVO is not
	 *         null. 10:00:38 by hbenizid
	 */
	@SuppressWarnings("unchecked")
	public <T extends BaseUI, S extends BaseBVO> T bvoToUi(S bvo, Class<? extends BaseUI> uiClass) {

		if (bvo != null) {
			return (T) mapper.map(bvo, uiClass);
		}
		else {
			return null;
		}
	}

	/**
	 * Convert a WVO to a BVO.
	 *
	 * @param <T> the type parameter
	 * @param <S> the type parameter
	 * @param wvo the wvo
	 * @param bvoClass the bvo class
	 *
	 * @return {@link BaseUI}
	 *         <p>
	 *         Example : TarifBVO bvo = wvoToBvo(wvo, TarifBVO.class);
	 *         <p>
	 *         Created : 21 dec. 2016 by fmartinez (version 0.3.2-Alpha) 10:01:31 by hbenizid
	 */
	@SuppressWarnings("unchecked")
	public <T extends BaseBVO, S extends BaseWVO> T wvoToBvo(S wvo, Class<? extends BaseBVO> bvoClass) {

		if (wvo != null) {
			return (T) mapper.map(wvo, bvoClass);
		}
		else {
			return null;
		}
	}

	/**
	 * Convert a BVO to a WVO.
	 *
	 * @param <T> the type parameter
	 * @param <S> the type parameter
	 * @param bvo the bvo
	 * @param wvoClass the wvo class
	 *
	 * @return {@link BaseWVO}
	 *         <p>
	 *         Example : TarifWVO wvo = bvoToWvo(bvo, TarifWVO.class);
	 *         <p>
	 *         Created : 21 dec. 2016 by fmartinez (version 0.3.2-Alpha) 10:02:18 by hbenizid
	 */
	@SuppressWarnings("unchecked")
	public <T extends BaseWVO, S extends BaseBVO> T bvoToWvo(S bvo, Class<? extends BaseWVO> wvoClass) {

		if (bvo != null) {
			return (T) mapper.map(bvo, wvoClass);
		}
		else {
			return null;
		}
	}

	/**
	 * Convert a UI list to a BVO list.
	 *
	 * @param <T> the type parameter
	 * @param <S> the type parameter
	 * @param uiList the ui list
	 * @param bvoClass the bvo class
	 *
	 * @return {@link List} of {@link BaseBVO}
	 *         <p>
	 *         Example : return listUiToBvo(tarifsUI, TarifBVO.class);
	 *         <p>
	 *         Created : 12 dec. 2016 by fmartinez (version 0.3.2-Alpha) 10:02:56 by hbenizid
	 */
	@SuppressWarnings("unchecked")
	public <T extends BaseBVO, S extends BaseUI> List<T> listUiToBvo(List<S> uiList, Class<? extends BaseBVO> bvoClass) {

		List<T> list = new ArrayList<>();

		if (uiList != null) {
			logger.info("Class is :  {} | Size is : {}", bvoClass.getSimpleName(), uiList.size());
			for (S ui: uiList) {
				if (ui != null) {
					list.add((T) uiToBvo((S) ui, bvoClass));
				}
			}
		}
		return list;
	}

	/**
	 * Convert a BVO list to a UI list.
	 *
	 * @param <T> the type parameter
	 * @param <S> the type parameter
	 * @param bvoList the bvo list
	 * @param uiClass the ui class
	 *
	 * @return {@link List} of {@link BaseUI}
	 *         <p>
	 *         Example : return listBvoToUi(tarifsBVO, TarifUI.class);
	 *         <p>
	 *         Created : 12 dec. 2016 by fmartinez (version 0.3.2-Alpha) 10:03:59 by hbenizid
	 */
	@SuppressWarnings("unchecked")
	public <T extends BaseUI, S extends BaseBVO> List<T> listBvoToUi(List<S> bvoList, Class<? extends BaseUI> uiClass) {

		List<T> list = new ArrayList<>();
		if (bvoList != null) {
			logger.info("Class is :  {} | Size is : {}", uiClass.getSimpleName(), bvoList.size());
			for (S bvo: bvoList) {
				if (bvo != null) {
					list.add((T) bvoToUi((S) bvo, uiClass));
				}
			}
		}
		return list;
	}

	/**
	 * Convert a WVO list to a BVO list.
	 *
	 * @param <T> the type parameter
	 * @param <S> the type parameter
	 * @param wvoList the wvo list
	 * @param bvoClass the bvo class
	 *
	 * @return {@link List} of {@link BaseBVO}
	 *         <p>
	 *         Example : return listWvoToBvo(tarifsWVO, TarifBVO.class);
	 *         <p>
	 *         Created : 21 dec. 2016 by fmartinez (version 0.3.2-Alpha) 10:04:41 by hbenizid
	 */
	@SuppressWarnings("unchecked")
	public <T extends BaseBVO, S extends BaseWVO> List<T> listWvoToBvo(List<S> wvoList,
			Class<? extends BaseBVO> bvoClass) {

		List<T> list = new ArrayList<>();

		if (wvoList != null) {
			logger.info("Class is :  {} | Size is : {}", bvoClass.getSimpleName(), wvoList.size());
			for (S wvo: wvoList) {
				if (wvo != null) {
					list.add((T) wvoToBvo((S) wvo, bvoClass));
				}
			}
		}
		return list;
	}

	/**
	 * Convert a BVO list to a WVO list.
	 *
	 * @param <T> the type parameter
	 * @param <S> the type parameter
	 * @param bvoList the bvo list
	 * @param wvoClass the wvo class
	 *
	 * @return {@link List} of {@link BaseWVO}
	 *         <p>
	 *         Example : return listBvoToWvo(tarifsBVO, TarifWVO.class);
	 *         <p>
	 *         Created : 21 dec. 2016 by fmartinez (version 0.3.2-Alpha) 10:05:22 by hbenizid
	 */
	@SuppressWarnings("unchecked")
	public <T extends BaseWVO, S extends BaseBVO> List<T> listBvoToWvo(List<S> bvoList,
			Class<? extends BaseWVO> wvoClass) {

		List<T> list = new ArrayList<>();
		if (bvoList != null) {
			logger.info("Class is :  {} | Size is : {}", wvoClass.getSimpleName(), bvoList.size());
			for (S bvo: bvoList) {
				if (bvo != null) {
					list.add((T) bvoToWvo((S) bvo, wvoClass));
				}
			}
		}
		return list;
	}

	/**
	 * Set the Message Source (only for test class).
	 *
	 * @param messageSource the new message source
	 */
	public void setMessageSource(ReloadableResourceBundleMessageSource messageSource) {

		this.messageSource = messageSource;
	}

	/**
	 * Get the Message Source (only for test class).
	 *
	 * @return the message source
	 */
	public ReloadableResourceBundleMessageSource getMessageSource() {

		return messageSource;
	}
}
