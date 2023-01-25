/*
 * Copyright Owliance © 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.framework.common;

/**
 * Class for Message Service
 *
 * @author fmartinez
 * @see com.owliance.owlink.framework.common
 *      <p>
 *      Created : 13 juil 2016
 *      <p>
 *      Updated : 11 nov. 2016 by hbenizid (version 0.3.0-Alpha)
 * @since 0.2.2 -Alpha
 */
public class MsgService extends Msg implements java.io.Serializable {

	private static final long serialVersionUID = -993802690263723793L;

	/**
	 * Constructor.
	 *
	 * @param code String Message Id
	 * @param type String Type of message
	 * @param message String Text
	 * @param detail String Message detail
	 *           <p>
	 *           Example : <code>new MsgBO("0001",
	 *                Msg.MSGERR_BUSNCONFIRM, "msg.confirm.admin.deleteprofile", "Are you sure you want to delete this
	 *                profile ?"}) </code>
	 *           <p>
	 *           Created : 13 juil 2016 by fmartinez (version 0.1.6-Alpha)
	 *           <p>
	 *           Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	public MsgService(String code, String type, String message, String detail) {
		super(code, type, message, detail);
	}

	/**
	 * Constructor.
	 *
	 * @param code String Message Id
	 * @param type String Type of message
	 * @param message String Text
	 * @param argsMessage String[] Message arguments
	 *           <p>
	 *           Example : <code>new MsgBO("0001",
	 *                    Msg.MSGERR_BUSNCONFIRM, "msg.confirm.admin.deleteprofile", new String[]{profile.getId})
	 *                    </code>
	 *           <p>
	 *           Created : 13 juil 2016 by fmartinez (version 0.1.6-Alpha)
	 *           <p>
	 *           Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	public MsgService(String code, String type, String message, String[] argsMessage) {
		super(code, type, message, argsMessage);
	}

	/**
	 * Constructor.
	 *
	 * @param code String Message Id
	 * @param type String Type of message
	 * @param message String Text
	 * @param argsMessage String[] Message arguments
	 * @param detail String Message detail
	 * @param argsDetail String[] Detail arguments
	 *           <p>
	 *           Example : <code>new MsgBO("0001",
	 *                    Msg.MSGERR_BUSNCONFIRM, "msg.confirm.admin.deleteprofile", new String[]{profile.getId}, "Are
	 *                    you sure you want to delete {0} ?", new String[]{profile.getId})</code>
	 *           <p>
	 *           Created : 13 juil 2016 by fmartinez (version 0.1.6-Alpha)
	 *           <p>
	 *           Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	public MsgService(String code, String type, String message, String[] argsMessage, String detail,
			String[] argsDetail) {
		super(code, type, message, argsMessage, detail, argsDetail);
	}
}
