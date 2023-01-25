/*
 * Copyright Owliance © 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.framework.exception;


import com.owliance.owlink.framework.common.MsgList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;


/**
 * Base class for all exceptions
 *
 * @author fmartinez
 * @see com.owliance.owlink.framework.exception
 * @see com.owliance.owlink.framework.common.MsgList
 *
 * <p>
 * Created : 08 juil 2016
 * <p>
 * Updated : 13 juil 2016 by hbenizid (version 0.1.5-Alpha)
 * <p>
 * Updated : 13 juil 2016 by fmartinez (version 0.2.3-Alpha)
 * <p>
 * Updated : 17 nov. 2016 by fmartinez (version 0.3.1-Alpha)
 * <p>
 * Updated : 08 mar. 2017 by fmartinez (version 0.3.6-Alpha) : getLastMessage
 */
public abstract class BaseException extends RuntimeException implements java.io.Serializable {

    private static final long serialVersionUID = -4720836906840849871L;

    /**
     * Logger
     **/
    private static final Logger logger = LoggerFactory.getLogger(BaseException.class);

    /**
     * Constructor.
     * <p/>
     * Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
     * <p/>
     * Updated : xx xxxx xxxx by xxx (version x.x.x)
     */
    public BaseException() {
        super();
    }

    /**
     * Constructor.
     * <p/>
     * Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
     * <p/>
     * Updated : xx xxxx xxxx by xxx (version x.x.x)
     *
     * @param message the message
     */
    public BaseException(String message) {
        super(message);
    }

    /**
     * Constructor.
     * <p/>
     * Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
     * <p/>
     * Updated : xx xxxx xxxx by xxx (version x.x.x)
     *
     * @param message the message
     * @param cause   the cause
     */
    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor.
     * <p/>
     * Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
     * <p/>
     * Updated : xx xxxx xxxx by xxx (version x.x.x)
     *
     * @param cause the cause
     */
    public BaseException(Throwable cause) {
        super(cause);
    }

    /**
     * Return the stack trace of an exception as a String
     *
     * @param e the e
     * @return String printStackTrace
     * <p>
     * Example :
     * <p>
     * Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
     * <p>
     * Updated : 13 juil 2016 by hbenizid (version 0.1.5-Alpha)
     */
    public static String toStringStackTrace(Throwable e) {
        logger.debug("Method : toStringStackTrace");
        String stacktrace = "Exception == null";
        if (e != null) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            stacktrace = sw.toString();
        }
        return stacktrace;
    }

    /**
     * Description.
     *
     * @param e Throwable
     * @return String dernier message de l'Exception en cours
     * <p>
     * Example :
     * <p>
     * Created : 23 juil 2016 by fmartinez (version 0.2.3-Alpha)
     * <p>
     * Updated : 08 mar. 2017 by fmartinez (version 0.3.6-Alpha) : initialize lastMessage
     */
    public static String getLastMessage(Throwable e) {
        String lastMessage = null;
        if (e != null) {
            Throwable cause = e.getCause();
            lastMessage = e.getMessage();

            while (cause != null) {
                lastMessage = cause.getMessage();
                cause = cause.getCause();
            }
        }
        return lastMessage;
    }

    /**
     * Complète la liste des messages en ajoutant les messages métiers associés à l'exception passée
     * en paramètre et les messages métiers des exceptions mères (héritées de BaseException).
     *
     * @param e       Throwable exception contenant les messages
     * @param msgList MsgList liste utilisée pour empiler les messages
     * @return MsgList liste complète des messages
     * <p>
     * Example :
     * <p>
     * Created : 23 juil 2016 by fmartinez (version 0.2.3-Alpha)
     * <p>
     * Updated : xx xxxx xxxx by xxx (version x.x.x)
     */
    protected static MsgList buildMsgList(Throwable e, MsgList msgList) {
        Throwable cause = e;
        logger.debug("buildMsgList - " + cause.getClass().getName());
        MsgList tmpList = ((BaseException) cause).getMsgList();
        if (tmpList != null) {
            msgList.add(tmpList);
        }

        cause = cause.getCause();
        while (cause != null) {
            logger.debug("buildMsgList - " + cause.getClass().getName());
            if (cause.getClass().isAssignableFrom(BaseException.class)) {
                tmpList = ((BaseException) cause).getMsgList();
                if (tmpList != null) {
                    msgList.add(tmpList);
                }
            }
            cause = cause.getCause();
        }
        return msgList;
    }

    /**
     * Return the stack trace of an exception as a String.
     *
     * @return String printStackTrace
     * <p>
     * Example :
     * <p>
     * Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
     * <p>
     * Updated : xx xxxx xxxx by xxx (version x.x.x)
     */
    public String toStringStackTrace() {
        return toStringStackTrace(this);
    }

    /**
     * Retourne la liste des messages standards associée à l'Exception en cours. A surcharger
     * uniquement dans les Exceptions qui stoquent des messages d'application
     *
     * @return MsgList liste de messages standards
     * <p>
     * Example :
     * <p>
     * Created : 23 juil 2016 by fmartinez (version 0.2.3-Alpha)
     * <p>
     * Updated : xx xxxx xxxx by xxx (version x.x.x)
     */
    public MsgList getMsgList() {
        return null;
    }

    /**
     * Retourne la liste des messages métiers associée à l'exception en cours et les messages métiers
     * des exceptions mères (héritées de BaseException).
     *
     * @return MsgList liste des Messages
     * <p>
     * Example :
     * <p>
     * Created : 23 juil 2016 by fmartinez (version 0.2.3-Alpha)
     * <p>
     * Updated : xx xxxx xxxx by xxx (version x.x.x)
     */
    public MsgList getAllMsg() {
        return buildMsgList(this, new MsgList());
    }
}
