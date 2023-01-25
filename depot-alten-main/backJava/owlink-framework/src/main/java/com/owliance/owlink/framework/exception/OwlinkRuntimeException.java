package com.owliance.owlink.framework.exception;


import com.owliance.owlink.framework.common.MsgList;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Class for runtime exceptions
 *
 * @author fmartinez
 * @since 0.2.2-Alpha
 * @see com.owliance.owlink.framework.exception
 *      <p>
 *      Created : 20 oct. 2016
 *      <p>
 *      Updated : 11 nov. 2016 by hbenizid (version 0.3.0-Alpha)
 *      <p>
 *      Updated : 08 feb. 2017 by fmartinez (version 0.3.5-Alpha) : rename getMessages => getMsgList
 */
public class OwlinkRuntimeException extends BaseException implements Serializable {

	private static final long serialVersionUID = 1003197495172923234L;

	/** Liste des messages associée à l'exception */
	private final MsgList msgList;

	/**
	 * Constructor.
	 *
	 * @param message the message
	 * @param msgList the msg list
	 */
	public OwlinkRuntimeException(String message, MsgList msgList) {
		super(message);
		this.msgList = msgList;
	}

	/**
	 * Constructor. Si la cause est une autre OwlinkBOException, on récupère ses messages
	 *
	 * @param message the message
	 * @param cause the cause
	 * @param msgList the msg list
	 */
	public OwlinkRuntimeException(String message, Throwable cause, MsgList msgList) {
		super(message, cause);
		this.msgList = msgList;
	}

	/**
	 * Constructor. Si la cause est une autre OwlinkBOException, on récupère ses messages.
	 *
	 * @param cause the cause error
	 * @param msgList the msg list
	 */
	public OwlinkRuntimeException(Throwable cause, MsgList msgList) {
		super(cause);
		this.msgList = msgList;
	}

	/**
	 * Constructor. Ajout d'une liste de messages à l'exception.
	 *
	 * @param msgList Message list
	 */
	public OwlinkRuntimeException(MsgList msgList) {
		super();
		this.msgList = msgList;
	}

	/**
	 * Constructor. Si la cause est une autre OwlinkBOException, on ajoute ses messages à la suite
	 * des nouveaux messages.
	 *
	 * @param msgList the msg list
	 * @param cause the cause
	 */
	public OwlinkRuntimeException(MsgList msgList, Throwable cause) {
		super(cause);
		this.msgList = msgList;
	}

	/**
	 * Retourne la liste des messages Runtime associée à l'exception en cours uniquement.
	 *
	 * @return MsgList liste des messages Msg
	 */
	@Override
	public MsgList getMsgList() {

		return this.msgList;
	}

	/**
	 * Retourne la liste des messages métiers associée à l'exception en cours et les messages métiers
	 * des exceptions mères.
	 *
	 * @return MsgList liste des Msg
	 */
	public MsgList getAllMessages() {

		return buildMsgList(this, new MsgList());
	}

	/**
	 * Retourne la liste des messages associée à l'exception en cours et les messages métiers des
	 * exceptions mères sous forme d'une ArrayList.
	 *
	 * @return ArrayList liste des messages Msg
	 */
	public ArrayList<Object> getAllMsgArrayList() {

		return getAllMessages().getMsgArrayList();
	}
}
