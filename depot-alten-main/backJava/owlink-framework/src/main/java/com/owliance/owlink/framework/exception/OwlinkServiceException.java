/*
 * Copyright Owliance © 2016 - 2017 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.framework.exception;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.owliance.owlink.framework.common.Msg;
import com.owliance.owlink.framework.common.MsgList;


/**
 * Class for business exceptions.
 *
 * @author fmartinez
 * @since 0.2.2-Alpha
 * @see com.owliance.owlink.framework.exception
 *      <p>
 *      Created : 13 juil 2016
 *      <p>
 *      Updated : 11 nov. 2016 by hbenizid (version 0.3.0-Alpha)
 *      <p>
 *      Updated : 08 feb. 2017 by fmartinez (version 0.3.5-Alpha) : rename getMessages => getMsgList
 *      <p>
 *      Updated : 31 mar. 2017 by fmartinez (version 0.4.1-Alpha) : rename message key
 *      "msg.error.tech.detail.system" => "msg.tech.general.ko.detail.system"
 */
public class OwlinkServiceException extends BaseException implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2972730356826582019L;

	/** Liste des messages associée à l'exception. */
	private final MsgList	  msgList;

	/**
	 * Instantiates a new owlink service exception.
	 *
	 * @param message the message
	 * @param msgList the msg list
	 */
	public OwlinkServiceException(String message, MsgList msgList) {
		super(message);
		this.msgList = msgList;
	}

	/**
	 * Constructor.
	 * 
	 * Si la cause est une autre OwlinkBOException, on récupère ses messages
	 * 
	 * <p>
	 * Exemple :
	 * <p>
	 * Created : 13 juil 2016 by fmartinez (version
	 *
	 * @param message the message
	 * @param cause the cause
	 * @param msgList the msg list
	 */
	public OwlinkServiceException(String message, Throwable cause, MsgList msgList) {
		super(message, cause);
		this.msgList = msgList;
	}

	/**
	 * Constructor. Si la cause est une autre OwlinkBOException, on récupère ses messages.
	 * 
	 * 
	 * <p>
	 * Created : 13 juil 2016 by fmartinez (version 0.2.2-Alpha)
	 * <p>
	 * Updated : xx xxxx xxxx by xxx (version x.x.x)
	 *
	 * @param cause the cause
	 * @param msgList the msg list
	 */
	public OwlinkServiceException(Throwable cause, MsgList msgList) {
		super(cause);
		this.msgList = msgList;
	}

	/**
	 * Constructor. Ajout d'une liste de messages à l'exception.
	 * 
	 * <p>
	 * Created : 13 juil 2016 by fmartinez (version 0.2.2-Alpha)
	 * <p>
	 * Updated : xx xxxx xxxx by xxx (version x.x.x)
	 * 
	 * @param msgList Message list
	 */
	public OwlinkServiceException(MsgList msgList) {
		super();
		this.msgList = msgList;
	}

	/**
	 * Constructor. Si la cause est une autre OwlinkBOException, on ajoute ses messages à la suite
	 * des nouveaux messages.
	 *
	 * @param msgList the msg list
	 * @param cause
	 *           <p>
	 *           Created : 13 juil 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public OwlinkServiceException(MsgList msgList, Throwable cause) {
		super(cause);
		this.msgList = msgList;
	}

	/**
	 * Retourne la liste des messages métiers associée à l'exception en cours uniquement.
	 * 
	 * @return MsgList liste des messages Msg
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 13 juil 2016 by fmartinez (version 0.2.2-Alpha)
	 *         <p>
	 *         Updated : 08 feb. 2017 by fmartinez (version 0.3.5-Alpha) : rename
	 */
	@Override
	public MsgList getMsgList() {

		return this.msgList;
	}

	/**
	 * Retourne la liste des messages métiers associée à l'exception en cours et les messages métiers
	 * des exceptions mères.
	 * 
	 * @return MsgList liste des MsgService
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 13 juil 2016 by fmartinez (version 0.2.2-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public MsgList getAllMessages() {

		return buildMsgList(this, new MsgList());
	}

	/**
	 * Retourne la liste des messages métiers associée à l'exception en cours et les messages métiers
	 * des exceptions mères sous forme d'une ArrayList.
	 * 
	 * @return ArrayList liste des messages MsgService
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 13 juil 2016 by fmartinez (version 0.2.2-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public ArrayList<Object> getAllMsgArrayList() {

		return getAllMessages().getMsgArrayList();
	}

	/**
	 * Retourne la liste des messages métiers associée à l'exception en cours uniquement sous forme
	 * d'une ArrayList.
	 *
	 * @return ArrayList<Message> liste des messages MsgService
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 13 juil 2016 by fmartinez (version 0.2.2-Alpha)
	 *         <p>
	 *         Updated : 08 feb. 2017 by fmartinez (version 0.3.5-Alpha) : getMessages => getMsgList
	 */
	public ArrayList<Object> getMsgArrayList() {

		return getMsgList().getMsgArrayList();
	}

	/**
	 * Retourne la liste des messages sous formes d'ArrayList.
	 * 
	 * @return ArrayList Liste de tous objets stockés dans le MessageList.
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 13 juil 2016 by fmartinez (version 0.2.2-Alpha)
	 *         <p>
	 *         Updated : 08 feb. 2017 by fmartinez (version 0.3.5-Alpha) : getMessages => getMsgList
	 */
	public ArrayList<Object> getObjectsArrayList() {

		return getMsgList().getObjectsArrayList();
	}

	/**
	 * Méthode permettant de récupérer la liste des <Message, Objet> attachés à un cas fonctionnel
	 * businessKey.
	 *
	 * @param businessKey String - Cas fonctionnel.
	 * @return List <[Message, Object]>
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 13 juil 2016 by fmartinez (version 0.2.2-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public List<Object> getMsgListByKey(String businessKey) {

		return this.msgList.getMsgListByKey(businessKey);
	}

	/**
	 * Méthode permettant de récupérer les Message attachés à un cas fonctionnel.
	 *
	 * @param businessKey String - Cas fonctionnel.
	 * @return {@link List} of {@link Object}
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 13 juil 2016 by fmartinez (version 0.2.2-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public List<Object> getMsgByKey(String businessKey) {

		return this.msgList.getMsgByKey(businessKey);
	}

	/**
	 * Méthode permettant de récupérer l'ensemble des objets attachés à un cas fonctionnel.
	 *
	 * @param businessKey String - Cas fonctionnel.
	 * @return {@link List} of {@link Object}
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 13 juil 2016 by fmartinez (version 0.2.2-Alpha)
	 *         <p>
	 *         Updated : xx xxxx xxxx by xxx (version x.x.x)
	 */
	public List<Object> getObjectsByKey(String businessKey) {

		return this.msgList.getObjectsByKey(businessKey);
	}

	/**
	 * Méthode permettant d'ajouter un message d'erreur à la liste <code>MsgList</code> des messages
	 * associés à l'exception courante. <b>Cette méthode NE DOIT PAS ETRE UTILISEE dans la couche
	 * métier.</b>
	 *
	 * @param code String Message Id
	 * @param messageKey String Message key in resource file
	 * @param argsMessage String[] Message arguments
	 * @param e : Exception
	 *           <p>
	 *           Created : 13 juil 2016 by fmartinez (version 0.2.2-Alpha)
	 *           <p>
	 *           Updated : 08 feb. 2017 by fmartinez (version 0.3.5-Alpha) : message key
	 *           <p>
	 *           Updated : 31 mar. 2017 by fmartinez (version 0.4.1-Alpha) : rename message key
	 *           "msg.error.tech.detail.system" => "msg.tech.general.ko.detail.system"
	 */
	protected void addMsgBusnErr(String code, String messageKey, String[] argsMessage, Exception e) {

		this.msgList.addMsg(new Msg(code, Msg.MSGERR_BUSNERROR, messageKey, argsMessage,
				"msg.tech.general.ko.detail.system", new String[] { BaseException.toStringStackTrace(e) }));
	}
}
