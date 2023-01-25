/*
 * Copyright Owliance © 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.framework.common;


import com.owliance.owlink.framework.constants.OwlinkConstants;


/**
 * Class base for Messages
 *
 * @author fmartinez
 * @since 0.2.2-Alpha
 * @see com.owliance.owlink.framework.common
 *      <p>
 *      Created : 13 juil 2016
 *      <p>
 *      Updated : 11 nov. 2016 by hbenizid (version 0.3.0-Alpha)
 */
public class Msg implements java.io.Serializable {

	private static final long	serialVersionUID	 = 5703704441227949377L;

	/** Type of message */
	/**
	 * Technical
	 */
	public static final String	MSGERR_TECHCONFIRM = OwlinkConstants.MSGERR_TECHCONFIRM;
	/**
	 * The constant MSGERR_TECHINFO.
	 */
	public static final String	MSGERR_TECHINFO	 = OwlinkConstants.MSGERR_TECHINFO;
	/**
	 * The constant MSGERR_TECHWARN.
	 */
	public static final String	MSGERR_TECHWARN	 = OwlinkConstants.MSGERR_TECHWARN;
	/**
	 * The constant MSGERR_TECHERROR.
	 */
	public static final String	MSGERR_TECHERROR	 = OwlinkConstants.MSGERR_TECHERROR;
	/**
	 * The constant MSGERR_TECHSUCCESS.
	 */
	public static final String	MSGERR_TECHSUCCESS = OwlinkConstants.MSGERR_TECHSUCCESS;
	/**
	 * Business
	 */
	public static final String	MSGERR_BUSNCONFIRM = OwlinkConstants.MSGERR_BUSNCONFIRM;
	/**
	 * The constant MSGERR_BUSNINFO.
	 */
	public static final String	MSGERR_BUSNINFO	 = OwlinkConstants.MSGERR_BUSNINFO;
	/**
	 * The constant MSGERR_BUSNWARN.
	 */
	public static final String	MSGERR_BUSNWARN	 = OwlinkConstants.MSGERR_BUSNWARN;
	/**
	 * The constant MSGERR_BUSNERROR.
	 */
	public static final String	MSGERR_BUSNERROR	 = OwlinkConstants.MSGERR_BUSNERROR;
	/**
	 * The constant MSGERR_BUSNSUCCESS.
	 */
	public static final String	MSGERR_BUSNSUCCESS = OwlinkConstants.MSGERR_BUSNSUCCESS;

	/**
	 * <code>true</code> The message entry exist for message ID <code>false</code> The message entry
	 * does not exist for message ID.
	 */
	private boolean				resolved;

	/** Message Id */
	private String					code;
	/** Type of message (Error, Warning, Info,...) */
	private String					type;
	/** Message key in resource file */
	private String					messageKey;
	/** Message arguments */
	private String[]				argsMessage;
	/** Message detail key in resource file */
	private String					detailKey;
	/** Detail arguments */
	private String[]				argsDetail;

	/**
	 * Constructor
	 */
	public Msg() {
		super();
	}

	/**
	 * Constructor.
	 *
	 * @param code String Message Id
	 * @param type String Type of message
	 * @param messageKey String Message key in resource file
	 * @param detailKey String Message detail key in resource file
	 *           <p>
	 *           Example :
	 *           <code>new Msg("0001", Msg.MSGERR_BUSNCONFIRM, "msg.confirm.admin.deleteprofile", "Are you sure
	 *                   you want to delete this profile ?"}) </code>
	 *           <p>
	 *           Created : 13 juil 2016 by fmartinez (version 0.1.6-Alpha)
	 *           <p>
	 *           Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	public Msg(String code, String type, String messageKey, String detailKey) {
		this.resolved = false;
		this.code = code;
		this.type = type;
		this.messageKey = messageKey;
		this.argsMessage = null;
		this.detailKey = detailKey;
		this.argsDetail = null;
	}

	/**
	 * Constructor.
	 *
	 * @param code String Message Id
	 * @param type String Type of message
	 * @param messageKey String Message key in resource file
	 * @param argsMessage String[] Message arguments
	 *           <p>
	 *           Example : <code>new Msg("0001",
	 *                    Msg.MSGERR_BUSNCONFIRM, "msg.confirm.admin.deleteprofile", new String[]{profile.getId})
	 *                    </code>
	 *           <p>
	 *           Created : 13 juil 2016 by fmartinez (version 0.1.6-Alpha)
	 *           <p>
	 *           Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	public Msg(String code, String type, String messageKey, String[] argsMessage) {
		this.resolved = false;
		this.code = code;
		this.type = type;
		this.messageKey = messageKey;
		this.argsMessage = argsMessage;
		this.detailKey = null;
		this.argsDetail = null;
	}

	/**
	 * Constructor.
	 *
	 * @param code String Message Id
	 * @param type String Type of message
	 * @param messageKey String Message key in resource file
	 * @param argsMessage String[] Message arguments
	 * @param detailKey String Message detail key in resource file
	 * @param argsDetail String[] Detail arguments
	 *           <p>
	 *           Example : <code>new Msg("0001",
	 *                    Msg.MSGERR_BUSNCONFIRM, "msg.confirm.admin.deleteprofile", new String[]{profile.getId}, "Are
	 *                    you sure you want to delete {0} ?", new String[]{profile.getId})</code>
	 *           <p>
	 *           Created : 13 juil 2016 by fmartinez (version 0.1.6-Alpha)
	 *           <p>
	 *           Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	public Msg(String code, String type, String messageKey, String[] argsMessage, String detailKey,
			String[] argsDetail) {
		this.resolved = false;
		this.code = code;
		this.type = type;
		this.messageKey = messageKey;
		this.argsMessage = argsMessage;
		this.detailKey = detailKey;
		this.argsDetail = argsDetail;
	}

	/**
	 * Gets detail key.
	 *
	 * @return String Message detail key in resource file
	 */
	public String getDetailKey() {

		return detailKey;
	}

	/**
	 * Gets code.
	 *
	 * @return String Message Id
	 */
	public String getCode() {

		return code;
	}

	/**
	 * Gets message key.
	 *
	 * @return String Message key in resource file
	 */
	public String getMessageKey() {

		return messageKey;
	}

	/**
	 * Gets type.
	 *
	 * @return String Type of message
	 */
	public String getType() {

		return type;
	}

	/**
	 * Get args detail string [ ].
	 *
	 * @return String[] Detail arguments
	 */
	public String[] getArgsDetail() {

		return argsDetail;
	}

	/**
	 * Get args message string [ ].
	 *
	 * @return String[] Message arguments
	 */
	public String[] getArgsMessage() {

		return argsMessage;
	}

	/**
	 * Is resolved boolean.
	 *
	 * @return boolean The message entry exist for message ID
	 */
	public boolean isResolved() {

		return resolved;
	}

	/**
	 * Sets resolved.
	 *
	 * @param b boolean The message entry does not exist for message ID
	 */
	public void setResolved(boolean b) {

		resolved = b;
	}
}
