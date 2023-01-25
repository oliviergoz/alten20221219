/*
 * Copyright Owliance © 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.framework.common;


import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.owliance.owlink.framework.exception.BaseException;


/**
 * Business context for all Services.
 *
 * @author fmartinez
 * @see com.owliance.owlink.framework.common
 *      <p>
 *      Created : 20 oct. 2016
 *      <p>
 *      Updated : 11 nov. 2016 by hbenizid (version 0.3.0-Alpha)
 *      <p>
 *      Updated : 08 feb. 2017 by fmartinez (version 0.3.5-Alpha) : message key
 *      <p>
 *      Updated : 02 mar. 2017 by fmartinez (version 0.3.6-Alpha) : addMsgGeneralErr()
 *      <p>
 *      Updated : 31 mar. 2017 by fmartinez (version 0.4.1-Alpha) : rename message key
 *      "msg.error.tech.detail.system" => "msg.tech.general.ko.detail.system"
 * @since 0.2.2 -Alpha
 */
public class OwlinkContext implements Serializable {

	private static final long	 serialVersionUID	= 8887369245535597556L;

	/** Logger */
	private static final Logger logger				= LoggerFactory.getLogger(OwlinkContext.class);

	/** HttpServletRequest à l'origine de l'appel au service métier */
	private HttpServletRequest	 request;

	/** Liste des messages associés au context */
	private MsgList				 msgList;

	/**
	 * Instantiates a new Owlink context.
	 */
	public OwlinkContext() {
		super();
	}

	/**
	 * Instantiates a new Owlink context.
	 *
	 * @param request the request
	 */
	public OwlinkContext(HttpServletRequest request) {
		super();
		this.request = request;
	}

	/**
	 * Add a MsgList into this and return the completed MsgList.
	 *
	 * @param srcMsgList Source list
	 *
	 * @return Completed MsgList
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public MsgList addMsgList(MsgList srcMsgList) {

		if (this.msgList != null) {
			this.msgList.add(srcMsgList);
		}
		return this.msgList;
	}

	/**
	 * Clear MsgList.
	 */
	public void clearMsgList() {

		if (this.msgList != null) {
			this.msgList.clear();
		}
	}

	/**
	 * Add a business message into this context.
	 *
	 * @param msg Business message
	 *
	 * @return Business message
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public MsgService addBusinessMsg(MsgService msg) {

		logger.debug("addBusinessMsg - Begin");
		addBusinessMsg(msg, null);
		logger.debug("addBusinessMsg - End");
		return msg;
	}

	/**
	 * Add a business message into this context.
	 *
	 * @param msg Business message
	 * @param object Object
	 *
	 * @return Business message
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public MsgService addBusinessMsg(MsgService msg, Object object) {

		logger.debug("addBusinessMsg - Begin");
		addBusinessMsg(MsgList.DEFAULT_BUSNCASE, msg, object);
		logger.debug("addBusinessMsg - End");
		return msg;
	}

	/**
	 * Add a message for a business case into this context.
	 *
	 * @param businessKey Business case
	 * @param msg Business message
	 * @param object Object
	 *
	 * @return Business message
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public MsgService addBusinessMsg(String businessKey, MsgService msg, Object object) {

		logger.debug("addBusinessMsg - Begin");
		if (this.msgList == null) {
			this.msgList = new MsgList();
		}
		this.msgList.addMsg(businessKey, msg, object);
		logger.debug("addBusinessMsg - End");
		return msg;
	}

	/**
	 * Add a technical message, type "CONFIRM".
	 *
	 * @param id Message Id
	 * @param messageKey Key in properties file
	 * @param argsMessage Message arguments
	 * @param detailKey Message detail
	 * @param argsDetail Detail arguments
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public void addMsgTechConfirm(String id, String messageKey, String[] argsMessage, String detailKey,
			String[] argsDetail) {

		addBusinessMsg(new MsgService(id, Msg.MSGERR_TECHCONFIRM, messageKey, argsMessage, detailKey, argsDetail));
	}

	/**
	 * Add a technical message, type "CONFIRM".
	 *
	 * @param id Message Id
	 * @param messageKey Key in properties file
	 * @param argsMessage Message arguments
	 * @param e Exception
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : 08 feb. 2017 by fmartinez (version 0.3.5-Alpha) : message key
	 */
	public void addMsgTechConfirm(String id, String messageKey, String[] argsMessage, Exception e) {

		addBusinessMsg(new MsgService(id, Msg.MSGERR_TECHCONFIRM, messageKey, argsMessage,
				"msg.tech.general.ko.detail.system", new String[] { BaseException.toStringStackTrace(e) }));
	}

	/**
	 * Add a business message, type "CONFIRM".
	 *
	 * @param id Message Id
	 * @param messageKey Key in properties file
	 * @param argsMessage Message arguments
	 * @param detailKey Message detail
	 * @param argsDetail Detail arguments
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public void addMsgBusnConfirm(String id, String messageKey, String[] argsMessage, String detailKey,
			String[] argsDetail) {

		addBusinessMsg(new MsgService(id, Msg.MSGERR_BUSNCONFIRM, messageKey, argsMessage, detailKey, argsDetail));
	}

	/**
	 * Add a business message, type "CONFIRM".
	 *
	 * @param id Message Id
	 * @param messageKey Key in properties file
	 * @param argsMessage Message arguments
	 * @param e Exception
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : 08 feb. 2017 by fmartinez (version 0.3.5-Alpha) : message key
	 */
	public void addMsgBusnConfirm(String id, String messageKey, String[] argsMessage, Exception e) {

		addBusinessMsg(new MsgService(id, Msg.MSGERR_BUSNCONFIRM, messageKey, argsMessage,
				"msg.tech.general.ko.detail.system", new String[] { BaseException.toStringStackTrace(e) }));
	}

	/**
	 * Add a technical message, type "INFO".
	 *
	 * @param id Message Id
	 * @param messageKey Key in properties file
	 * @param argsMessage Message arguments
	 * @param detailKey Message detail
	 * @param argsDetail Detail arguments
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public void addMsgTechInfo(String id, String messageKey, String[] argsMessage, String detailKey,
			String[] argsDetail) {

		addBusinessMsg(new MsgService(id, Msg.MSGERR_TECHINFO, messageKey, argsMessage, detailKey, argsDetail));
	}

	/**
	 * Add a technical message, type "INFO".
	 *
	 * @param id Message Id
	 * @param messageKey Key in properties file
	 * @param argsMessage Message arguments
	 * @param e Exception
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : 08 feb. 2017 by fmartinez (version 0.3.5-Alpha) : message key
	 */
	public void addMsgTechInfo(String id, String messageKey, String[] argsMessage, Exception e) {

		addBusinessMsg(new MsgService(id, Msg.MSGERR_TECHINFO, messageKey, argsMessage,
				"msg.tech.general.ko.detail.system", new String[] { BaseException.toStringStackTrace(e) }));
	}

	/**
	 * Add a business message, type "INFO".
	 *
	 * @param id Message Id
	 * @param messageKey Key in properties file
	 * @param argsMessage Message arguments
	 * @param detailKey Message detail
	 * @param argsDetail Detail arguments
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public void addMsgBusnInfo(String id, String messageKey, String[] argsMessage, String detailKey,
			String[] argsDetail) {

		addBusinessMsg(new MsgService(id, Msg.MSGERR_BUSNINFO, messageKey, argsMessage, detailKey, argsDetail));
	}

	/**
	 * Add a business message, type "INFO".
	 *
	 * @param id Message Id
	 * @param messageKey Key in properties file
	 * @param argsMessage Message arguments
	 * @param e Exception
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : 08 feb. 2017 by fmartinez (version 0.3.5-Alpha) : message key
	 */
	public void addMsgBusnInfo(String id, String messageKey, String[] argsMessage, Exception e) {

		addBusinessMsg(new MsgService(id, Msg.MSGERR_BUSNINFO, messageKey, argsMessage,
				"msg.tech.general.ko.detail.system", new String[] { BaseException.toStringStackTrace(e) }));
	}

	/**
	 * Add a technical message, type "WARNING".
	 *
	 * @param id Message Id
	 * @param messageKey Key in properties file
	 * @param argsMessage Message arguments
	 * @param detailKey Message detail
	 * @param argsDetail Detail arguments
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public void addMsgTechWarn(String id, String messageKey, String[] argsMessage, String detailKey,
			String[] argsDetail) {

		addBusinessMsg(new MsgService(id, Msg.MSGERR_TECHWARN, messageKey, argsMessage, detailKey, argsDetail));
	}

	/**
	 * Add a technical message, type "WARNING".
	 *
	 * @param id Message Id
	 * @param messageKey Key in properties file
	 * @param argsMessage Message arguments
	 * @param e Exception
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : 08 feb. 2017 by fmartinez (version 0.3.5-Alpha) : message key
	 */
	public void addMsgTechWarn(String id, String messageKey, String[] argsMessage, Exception e) {

		addBusinessMsg(new MsgService(id, Msg.MSGERR_TECHWARN, messageKey, argsMessage,
				"msg.tech.general.ko.detail.system", new String[] { BaseException.toStringStackTrace(e) }));
	}

	/**
	 * Add a business message, type "WARNING".
	 *
	 * @param id Message Id
	 * @param messageKey Key in properties file
	 * @param argsMessage Message arguments
	 * @param detailKey Message detail
	 * @param argsDetail Detail arguments
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public void addMsgBusnWarn(String id, String messageKey, String[] argsMessage, String detailKey,
			String[] argsDetail) {

		addBusinessMsg(new MsgService(id, Msg.MSGERR_BUSNWARN, messageKey, argsMessage, detailKey, argsDetail));
	}

	/**
	 * Add a business message, type "WARNING".
	 *
	 * @param id Message Id
	 * @param messageKey Key in properties file
	 * @param argsMessage Message arguments
	 * @param e Exception
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : 08 feb. 2017 by fmartinez (version 0.3.5-Alpha) : message key
	 */
	public void addMsgBusnWarn(String id, String messageKey, String[] argsMessage, Exception e) {

		addBusinessMsg(new MsgService(id, Msg.MSGERR_BUSNWARN, messageKey, argsMessage,
				"msg.tech.general.ko.detail.system", new String[] { BaseException.toStringStackTrace(e) }));
	}

	/**
	 * Add a technical message, type "ERROR".
	 *
	 * @param id Message Id
	 * @param messageKey Key in properties file
	 * @param argsMessage Message arguments
	 * @param detailKey Message detail
	 * @param argsDetail Detail arguments
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public void addMsgTechErr(String id, String messageKey, String[] argsMessage, String detailKey,
			String[] argsDetail) {

		addBusinessMsg(new MsgService(id, Msg.MSGERR_TECHERROR, messageKey, argsMessage, detailKey, argsDetail));
	}

	/**
	 * Add a technical message, type "ERROR".
	 *
	 * @param id Message Id
	 * @param messageKey Key in properties file
	 * @param argsMessage Message arguments
	 * @param e Exception
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : 08 feb. 2017 by fmartinez (version 0.3.5-Alpha) : message key
	 */
	public void addMsgTechErr(String id, String messageKey, String[] argsMessage, Exception e) {

		addBusinessMsg(new MsgService(id, Msg.MSGERR_TECHERROR, messageKey, argsMessage,
				"msg.tech.general.ko.detail.system", new String[] { BaseException.toStringStackTrace(e) }));
	}

	/**
	 * Add a business message, type "ERROR".
	 *
	 * @param id Message Id
	 * @param messageKey Key in properties file
	 * @param argsMessage Message arguments
	 * @param detailKey Message detail
	 * @param argsDetail Detail arguments
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public void addMsgBusnErr(String id, String messageKey, String[] argsMessage, String detailKey,
			String[] argsDetail) {

		addBusinessMsg(new MsgService(id, Msg.MSGERR_BUSNERROR, messageKey, argsMessage, detailKey, argsDetail));
	}

	/**
	 * Add a business message, type "ERROR".
	 *
	 * @param id Message Id
	 * @param messageKey Key in properties file
	 * @param argsMessage Message arguments
	 * @param e Exception
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : 08 feb. 2017 by fmartinez (version 0.3.5-Alpha) : message key
	 */
	public void addMsgBusnErr(String id, String messageKey, String[] argsMessage, Exception e) {

		String[] detailException = null;
		if (e != null) {
			detailException = new String[] { BaseException.toStringStackTrace(e) };
		}
		addBusinessMsg(new MsgService(id, Msg.MSGERR_BUSNERROR, messageKey, argsMessage,
				"msg.tech.general.ko.detail.system", detailException));
	}

	/**
	 * Add a general message, type "ERROR".
	 *
	 * @param type Business object
	 * @param description Object description
	 * @param code Object Id
	 * @param e Exception
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : 02 mar. 2017 by fmartinez (version 0.3.6-Alpha)
	 */
	public void addMsgGeneralErr(String type, String description, String code, Exception e) {

		addMsgBusnErr("msg.busn.general.ko.id", "msg.busn.general.ko", new String[] { type, description, code }, e);
	}

	/**
	 * Add a technical message, type "SUCCESS".
	 *
	 * @param id Message Id
	 * @param messageKey Key in properties file
	 * @param argsMessage Message arguments
	 * @param detailKey Message detail
	 * @param argsDetail Detail arguments
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public void addMsgTechSuccess(String id, String messageKey, String[] argsMessage, String detailKey,
			String[] argsDetail) {

		addBusinessMsg(new MsgService(id, Msg.MSGERR_TECHSUCCESS, messageKey, argsMessage, detailKey, argsDetail));
	}

	/**
	 * Add a technical message, type "SUCCESS".
	 *
	 * @param id Message Id
	 * @param messageKey Key in properties file
	 * @param argsMessage Message arguments
	 * @param e Exception
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : 08 feb. 2017 by fmartinez (version 0.3.5-Alpha) : message key
	 */
	public void addMsgTechSuccess(String id, String messageKey, String[] argsMessage, Exception e) {

		addBusinessMsg(new MsgService(id, Msg.MSGERR_TECHSUCCESS, messageKey, argsMessage,
				"msg.tech.general.ko.detail.system", new String[] { BaseException.toStringStackTrace(e) }));
	}

	/**
	 * Add a business message, type "SUCCESS".
	 *
	 * @param id Message Id
	 * @param messageKey Key in properties file
	 * @param argsMessage Message arguments
	 * @param detailKey Message detail
	 * @param argsDetail Detail arguments
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public void addMsgBusnSuccess(String id, String messageKey, String[] argsMessage, String detailKey,
			String[] argsDetail) {

		addBusinessMsg(new MsgService(id, Msg.MSGERR_BUSNSUCCESS, messageKey, argsMessage, detailKey, argsDetail));
	}

	/**
	 * Add a business message, type "SUCCESS".
	 *
	 * @param id Message Id
	 * @param messageKey Key in properties file
	 * @param argsMessage Message arguments
	 * @param e Exception
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : 08 feb. 2017 by fmartinez (version 0.3.5-Alpha) : message key
	 */
	public void addMsgBusnSuccess(String id, String messageKey, String[] argsMessage, Exception e) {

		addBusinessMsg(new MsgService(id, Msg.MSGERR_BUSNSUCCESS, messageKey, argsMessage,
				"msg.tech.general.ko.detail.system", new String[] { BaseException.toStringStackTrace(e) }));
	}

	/**
	 * Add a business message, type "CONFIRM".
	 *
	 * @param id Message Id
	 * @param messageKey Key in properties file
	 * @param argsMessage Message arguments
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public void addMsgBusnSuccess(String id, String messageKey, String[] argsMessage) {

		addBusinessMsg(new MsgService(id, Msg.MSGERR_BUSNSUCCESS, messageKey, argsMessage));
	}

	/**
	 * Gets the HttpServletRequest.
	 *
	 * @return The HttpServletRequest
	 */
	public HttpServletRequest getRequest() {

		return request;
	}

	/**
	 * Gets the message list.
	 *
	 * @return The message list
	 */
	public MsgList getMsgList() {

		return msgList;
	}
}
