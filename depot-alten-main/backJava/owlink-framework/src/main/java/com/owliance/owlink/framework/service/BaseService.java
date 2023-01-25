/*
 * Copyright Owliance © 2016 - 2017 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.framework.service;


import com.owliance.owlink.framework.common.MsgList;
import com.owliance.owlink.framework.common.OwlinkContext;
import com.owliance.owlink.framework.constants.OwlinkConstants;
import com.owliance.owlink.framework.entity.BaseBVO;
import com.owliance.owlink.framework.entity.BaseVO;
import org.dozer.Mapper;
import org.dozer.util.HibernateProxyResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * Class base for all Services.
 *
 * @author fmartinez
 * @see com.owliance.owlink.framework.service
 *
 * <p>
 * Created : 20 oct. 2016
 * <p>
 * Updated : 28 oct. 2016 by hbenizid (version 0.3.0-Alpha)
 * <p>
 * Updated : 11 nov. 2016 by hbenizid (version 0.3.1-Alpha)
 * <p>
 * Updated : 18 nov. 2016 by fmartinez (version 0.3.1-Alpha) : add methods
 * getMessage(),getMessageSource()
 * <p>
 * Updated : 12 dec. 2016 by fmartinez (version 0.3.2-Alpha) : add methods voToBvo(),bvoToVo(),
 * listVoToBvo(), listBvoToVo()
 * <p>
 * Updated : 14 dec. 2016 by fmartinez (version 0.3.2-Alpha)
 * <p>
 * Updated : 26 dec. 2016 by hbenizid (version 0.3.2-Alpha)
 * <p>
 * Updated : 20 jan. 2017 by fmartinez (version 0.3.4-Alpha) : add methods
 * addMsgNoRowWasFound(), addMsgCreateKo(), addMsgUpdateKo(), addMsgDeleteKo(),
 * addMsgUnableToDelete()
 * <p>
 * Updated : 23 jan. 2017 by fmartinez (version 0.3.4-Alpha) : add method
 * addMsgUnableToDelete()
 * <p>
 * Updated : 25 jan. 2017 by fmartinez (version 0.3.4-Alpha) : add methods
 * addMsgCheckBeforeSaveKo(), addMsgUnableToSave()
 * <p>
 * Updated : 16 feb. 2017 by fmartinez (version 0.3.5-Alpha) : add setRequest() and
 * setMessageSource()
 * @since 0.2.2-Alpha
 */
public abstract class BaseService {

    /**
     * Logger class for BaseService, Default Mode is INFO.
     */
    private static final Logger logger = LoggerFactory.getLogger(BaseService.class);

    /**
     * The request.
     */
    @Autowired(required = true)
    private HttpServletRequest request;

    /**
     * The message source.
     */
    @Autowired
    private ReloadableResourceBundleMessageSource messageSource;

    /**
     * The mapper.
     */
    /*
     * Injecting Mapper
     */
    @Resource
    private Mapper mapper;

    /**
     * default constructor. default constructor
     */
    public BaseService() {
        // Constructeur vide
    }

    /**
     * constructor with parameters.
     *
     * @param mapper {@link Mapper}
     */
    public BaseService(Mapper mapper) {
        this.mapper = mapper;
    }


    /**
     * Set le mapper à utiliser dans le service.
     *
     * @param mapper le mapper à utiliser
     */
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Add a business message : Check id KO.
     *
     * @param type        Business object
     * @param description Object description
     * @param code        Object Id
     * @param e           Exception
     *
     *                    <p>
     *                    Example :
     *                    <p>
     *                    Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
     *                    <p>
     *                    Updated : xx xxxx xxxx by xxx (version x.x.x)
     */
    protected void addMsgCheckIdKo(String type, String description, String code, Exception e) {

        if (type == null) {
            type = "";
        }

        if (description == null) {
            description = "";
        }

        if (code == null) {
            code = "";
        }

        getOwlinkContext().addMsgBusnErr("msg.general.checkid.ko.id", "msg.general.checkid.ko",
                new String[]{type, description}, e);
    }

    /**
     * Add a generic error message
     *
     * @param title      the error title
     * @param messageKey the I18N error message key
     * @param params     the list of parameters used in the error message
     * @param e          the exception
     */
    protected void addMsgKo(String title, String messageKey, String[] params, Exception e) {

        if (title == null) {
            title = "";
        }
        if (messageKey == null) {
            messageKey = "";
        }
        if (params == null) {
            params = new String[]{};
        }
        getOwlinkContext().addMsgBusnErr(title, messageKey, params, e);
    }

    /**
     * Add a generic error message
     *
     * @param title      the error title
     * @param messageKey the I18N error message key
     * @param params     the list of parameters used in the error message
     */
    protected void addMsgOK(String title, String messageKey, String[] params) {

        if (title == null) {
            title = "";
        }
        if (messageKey == null) {
            messageKey = "";
        }
        if (params == null) {
            params = new String[]{};
        }
        getOwlinkContext().addMsgBusnInfo(title, messageKey, params, null);
    }

    /**
     * Add a business message : Check field KO.
     *
     * @param field       The field
     * @param description Object description
     * @param e           Exception
     *                    <p>
     *                    Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
     *                    <p>
     *                    Updated : xx xxxx xxxx by xxx (version x.x.x)
     */
    protected void addMsgCheckFieldKo(String field, String description, Exception e) {

        if (field == null) {
            field = "";
        }

        if (description == null) {
            description = "";
        }

        getOwlinkContext().addMsgBusnErr("msg.general.check.field.ko.id", "msg.general.check.field.ko",
                new String[]{field, description}, e);
    }

    /**
     * add business message type informative passant
     * used to display informatives messages after success creation
     *
     * @param detailsMessage the message details to set after creation
     */
    protected void addMsgTechInformativePassant(String detailsMessage) {


        getOwlinkContext().addMsgBusnInfo("msg.general.create.info.id", "msg.general.create.info.details",
                new String[]{detailsMessage}, "msg.general.create.info.details", new String[]{detailsMessage});
    }

    /**
     * Add a business message : Bad field format.
     *
     * @param value  The object value
     * @param format The regex format
     * @param e      Exception
     *               <p>
     *               Created : 21 nov. 2016 by fmartinez (version 0.3.1-Alpha)
     *               <p>
     *               Updated : xx xxxx xxxx by xxx (version x.x.x)
     */
    protected void addMsgCheckFieldRegexKo(String value, String format, Exception e) {

        if (value == null) {
            value = "";
        }

        if (format == null) {
            format = "";
        }

        getOwlinkContext().addMsgBusnErr("msg.general.check.field.ko.format.invalid.regex.id",
                "msg.general.check.field.ko.format.invalid.regex", new String[]{value, format}, e);
    }

    /**
     * Add a business message : Bad field type.
     *
     * @param field The field
     * @param value The object value
     * @param type  The object type
     * @param e     Exception Created : 21 nov. 2016 by fmartinez (version 0.3.1-Alpha)
     *              <p>
     *              Updated : xx xxxx xxxx by xxx (version x.x.x)
     */
    protected void addMsgCheckFieldTypeKo(String field, String value, String type, Exception e) {

        if (field == null) {
            field = "";
        }

        if (value == null) {
            value = "";
        }

        if (type == null) {
            type = "";
        }

        getOwlinkContext().addMsgBusnErr("msg.general.check.field.ko.type.invalid.id",
                "msg.general.check.field.ko.type.invalid", new String[]{value, field, type}, e);
    }

    /**
     * Add a business message : method Check KO.
     *
     * @param type        Business object
     * @param description Object description
     * @param code        Object Id
     * @param e           Exception
     *                    <p>
     *                    Example :
     *                    <p>
     *                    Created : 20 oct. 2016 by fmartinez (version 0.2.2-Alpha)
     *                    <p>
     *                    Updated : xx xxxx xxxx by xxx (version x.x.x)
     */
    protected void addMsgCheckKo(String type, String description, String code, Exception e) {

        if (type == null) {
            type = "";
        }

        if (description == null) {
            description = "";
        }

        if (code == null) {
            code = "";
        }

        getOwlinkContext().addMsgBusnErr("msg.general.check.ko.id", "msg.general.check.ko",
                new String[]{type, description, code}, e);
    }

    /**
     * Add a business message : method Check Before Save KO.
     *
     * @param type        Business object
     * @param description Object description
     * @param code        Object Id
     * @param e           Exception
     *                    <p>
     *                    Example :
     *                    <p>
     *                    Created : 25 jan. 2017 by fmartinez (version 0.3.4-Alpha)
     *                    <p>
     *                    Updated : xx xxxx xxxx by xxx (version x.x.x)
     */
    protected void addMsgCheckBeforeSaveKo(String type, String description, String code, Exception e) {

        if (type == null) {
            type = "";
        }

        if (description == null) {
            description = "";
        }

        if (code == null) {
            code = "";
        }

        getOwlinkContext().addMsgBusnErr("msg.general.checkbeforesave.ko.id", "msg.general.checkbeforesave.ko",
                new String[]{type, description, code}, e);
    }

    /**
     * Add a business message : no row was found.
     *
     * @param type        Business object
     * @param description Object description
     * @param code        Object Id
     * @param e           Exception
     *                    <p>
     *                    Example :
     *                    <p>
     *                    Created : 20 jan. 2016 by fmartinez (version 0.3.4-Alpha)
     *                    <p>
     *                    Updated : xx xxxx xxxx by xxx (version x.x.x)
     */
    protected void addMsgNoRowWasFound(String type, String description, String code, Exception e) {

        if (type == null) {
            type = "";
        }

        if (description == null) {
            description = "";
        }

        if (code == null) {
            code = "";
        }
        getOwlinkContext().addMsgBusnErr("msg.general.find.ko.id", "msg.general.find.ko",
                new String[]{type, description, code}, e);
    }

    /**
     * Add a business message : no row was found.
     *
     * @param type        Business object
     * @param description Object description
     * @param code        Object Id
     * @param e           Exception
     *                    <p>
     *                    Example :
     *                    <p>
     *                    Created : 20 jan. 2016 by fmartinez (version 0.3.4-Alpha)
     *                    <p>
     *                    Updated : xx xxxx xxxx by xxx (version x.x.x)
     */
    protected void addMsgCreateKo(String type, String description, String code, Exception e) {

        if (type == null) {
            type = "";
        }

        if (description == null) {
            description = "";
        }

        if (code == null) {
            code = "";
        }
        getOwlinkContext().addMsgBusnErr("msg.general.create.ko.id", "msg.general.create.ko",
                new String[]{type, description, code}, e);
    }

    /**
     * Add a business message : no row was found.
     *
     * @param type        Business object
     * @param description Object description
     * @param code        Object Id
     *                    <p>
     *                    Example :
     *                    <p>
     *                    Created : 20 jan. 2016 by fmartinez (version 0.3.4-Alpha)
     *                    <p>
     *                    Updated : xx xxxx xxxx by xxx (version x.x.x)
     */
    protected void addMsgCreateOK(String type, String description, String code) {

        if (type == null) {
            type = "";
        }

        if (description == null) {
            description = "";
        }

        if (code == null) {
            code = "";
        }
        getOwlinkContext().addMsgBusnInfo("msg.general.create.ok.id", "msg.general.create.ok.details",
                new String[]{type, description, code}, null);
    }

    /**
     * Add a business message : no row was found.
     *
     * @param type        Business object
     * @param description Object description
     * @param code        Object Id
     * @param e           Exception
     *                    <p>
     *                    Example :
     *                    <p>
     *                    Created : 20 jan. 2016 by fmartinez (version 0.3.4-Alpha)
     *                    <p>
     *                    Updated : xx xxxx xxxx by xxx (version x.x.x)
     */
    protected void addMsgUpdateKo(String type, String description, String code, Exception e) {

        if (type == null) {
            type = "";
        }

        if (description == null) {
            description = "";
        }

        if (code == null) {
            code = "";
        }
        getOwlinkContext().addMsgBusnErr("msg.general.update.ko.id", "msg.general.update.ko",
                new String[]{type, description, code}, e);
    }

    /**
     * Add a business message : can't save row.
     *
     * @param type  Business object
     * @param code  Object Id
     * @param cause Cause
     * @param e     Exception
     *              <p>
     *              Example :
     *              <p>
     *              Created : 25 jan. 2016 by fmartinez (version 0.3.4-Alpha)
     *              <p>
     *              Updated : xx xxxx xxxx by xxx (version x.x.x)
     */
    protected void addMsgUnableToSave(String type, String code, String cause, Exception e) {

        if (type == null) {
            type = "";
        }

        if (cause == null) {
            cause = "";
        }

        if (code == null) {
            code = "";
        }
        getOwlinkContext().addMsgBusnErr("msg.general.save.unabletosave.id", "msg.general.save.unabletosave",
                new String[]{type, code, cause}, e);
    }

    /**
     * Add a business message : can't get row.
     *
     * @param type  Business object
     * @param code  Object Id
     * @param cause Cause
     * @param e     Exception
     *              <p>
     *              12:47:05 by lneji
     */
    protected void addMsgUnableToGet(String type, String code, String cause, Exception e) {

        if (type == null) {
            type = "";
        }

        if (cause == null) {
            cause = "";
        }

        if (code == null) {
            code = "";
        }
        getOwlinkContext().addMsgBusnErr("msg.general.get.unabletoget.id", "msg.general.get.unabletoget",
                new String[]{type, code, cause}, e);
    }

    /**
     * Add a business message : no row was found.
     *
     * @param type        Business object
     * @param description Object description
     * @param code        Object Id
     * @param e           Exception
     *                    <p>
     *                    Example :
     *                    <p>
     *                    Created : 20 jan. 2016 by fmartinez (version 0.3.4-Alpha)
     *                    <p>
     *                    Updated : xx xxxx xxxx by xxx (version x.x.x)
     */
    protected void addMsgDeleteKo(String type, String description, String code, Exception e) {

        if (type == null) {
            type = "";
        }
        if (description == null) {
            description = "";
        }
        if (code == null) {
            code = "";
        }
        getOwlinkContext().addMsgBusnErr("msg.general.delete.ko.id", "msg.general.delete.ko",
                new String[]{type, description, code}, e);
    }

    /**
     * Add a business message : can't delete row.
     *
     * @param type  Business object
     * @param code  Object Id
     * @param cause Cause
     * @param e     Exception
     *              <p>
     *              Example :
     *              <p>
     *              Created : 23 jan. 2016 by fmartinez (version 0.3.4-Alpha)
     *              <p>
     *              Updated : xx xxxx xxxx by xxx (version x.x.x)
     */
    protected void addMsgUnableToDelete(String type, String code, String cause, Exception e) {

        if (type == null) {
            type = "";
        }

        if (cause == null) {
            cause = "";
        }

        if (code == null) {
            code = "";
        }
        getOwlinkContext().addMsgBusnErr("msg.general.delete.unabletodelete.id", "msg.general.delete.unabletodelete",
                new String[]{type, code, cause}, e);
    }

    /**
     * Get current Owlink context.
     *
     * @return the owlink context
     */
    public OwlinkContext getOwlinkContext() {

        if ((request.getAttribute(OwlinkConstants.REQATTR_OWLINKCONTEXT) == null)
                || (request.getAttribute(OwlinkConstants.REQATTR_OWLINKCONTEXT).toString().length() == 0)) {
            request.setAttribute(OwlinkConstants.REQATTR_OWLINKCONTEXT, new OwlinkContext(this.request));
        }
        return (OwlinkContext) request.getAttribute(OwlinkConstants.REQATTR_OWLINKCONTEXT);
    }

    /**
     * Convert a VO to a BVO.
     *
     * @param <T>      the generic type
     * @param <S>      the generic type
     * @param vo       the vo
     * @param bvoClass the bvo class
     * @return {@link BaseBVO}
     *
     * <p>
     * Example : AdresseBVO bvo = voToBvo(vo, AdresseBVO.class);
     * <p>
     * Created : 12 dec. 2016 by fmartinez (version 0.3.2-Alpha)
     * <p>
     * Updated : 14 dec. 2016 by fmartinez (version 0.3.2-Alpha) : checks whether VO is not
     * null
     */
    @SuppressWarnings("unchecked")
    public <T extends BaseBVO, S extends BaseVO> T voToBvo(S vo, Class<? extends BaseBVO> bvoClass) {

        if (vo != null) {
            HibernateProxyResolver proxyResolver = new HibernateProxyResolver();
            S voWithoutProxy = proxyResolver.unenhanceObject(vo);
            return (T) mapper.map(voWithoutProxy, bvoClass);
        } else {
            return null;
        }
    }

    /**
     * Convert a BVO to a VO.
     *
     * @param <T>     the generic type
     * @param <S>     the generic type
     * @param bvo     the bvo
     * @param voClass the vo class
     * @return {@link BaseVO}
     *
     * <p>
     * Example : AdrVO vo = bvoToVo(bvo, AdrVO.class);
     * <p>
     * Created : 12 dec. 2016 by fmartinez (version 0.3.2-Alpha)
     * <p>
     * Updated : 14 dec. 2016 by fmartinez (version 0.3.2-Alpha) : checks whether BVO is not
     * null.
     */
    @SuppressWarnings("unchecked")
    public <T extends BaseVO, S extends BaseBVO> T bvoToVo(S bvo, Class<? extends BaseVO> voClass) {

        if (bvo != null) {
            return (T) mapper.map(bvo, voClass);
        } else {
            return null;
        }
    }

    /**
     * Convert a VO list to a BVO list.
     *
     * @param <T>      the generic type
     * @param <S>      the generic type
     * @param voList   the vo list
     * @param bvoClass the bvo class
     * @return {@link List} of {@link BaseBVO}
     * <p>
     * Example : return listVoToBvo(adressesVO, AdresseBVO.class);
     * <p>
     * Created : 12 dec. 2016 by fmartinez (version 0.3.2-Alpha)
     * <p>
     * Updated : xx xxxx xxxx by xxx (version x.x.x)
     */
    @SuppressWarnings("unchecked")
    public <T extends BaseBVO, S extends BaseVO> List<T> listVoToBvo(List<S> voList, Class<? extends BaseBVO> bvoClass) {

        List<T> list = new ArrayList<>();
        if (voList != null) {
            logger.info("Class is :  {} | Size is : {}", bvoClass.getSimpleName(), voList.size());
            for (S vo : voList) {
                if (vo != null) {
                    list.add((T) voToBvo(vo, bvoClass));
                }
            }
        }
        return list;
    }

    /**
     * Convert a BVO list to a VO list.
     *
     * @param <T>     the generic type
     * @param <S>     the generic type
     * @param bvoList the bvo list
     * @param voClass the vo class
     * @return {@link List} of {@link BaseVO}
     * <p>
     * Example : return listBvoToVo(adressesBVO, AdrVO.class);
     * <p>
     * Created : 12 dec. 2016 by fmartinez (version 0.3.2-Alpha)
     * <p>
     * Updated : xx xxxx xxxx by xxx (version x.x.x)
     */
    @SuppressWarnings("unchecked")
    public <T extends BaseVO, S extends BaseBVO> List<T> listBvoToVo(List<S> bvoList, Class<? extends BaseVO> voClass) {

        List<T> list = new ArrayList<>();

        if (bvoList != null) {
            logger.info("Class is :  {} | Size is : {}", voClass.getSimpleName(), bvoList.size());
            for (S bvo : bvoList) {
                if (bvo != null) {
                    list.add((T) bvoToVo((S) bvo, voClass));
                }
            }
        }
        return list;
    }

    /**
     * Gets the message list.
     *
     * @return The message list
     */
    public MsgList getMsgList() {

        return getOwlinkContext().getMsgList();
    }

    /**
     * Set the HttpServletRequest.
     *
     * @param request the new request
     */
    public void setRequest(HttpServletRequest request) {

        this.request = request;
    }

    /**
     * Get the HttpServletRequest.
     *
     * @return the request
     */
    public HttpServletRequest getRequest() {

        return request;
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

    /**
     * Get the Message.
     *
     * @param code the code
     * @return the message
     */
    public String getMessage(String code) {

        return getMessage(code, null);
    }

    /**
     * Get the Message.
     *
     * @param code the code
     * @param args the args
     * @return the message
     */
    public String getMessage(String code, Object[] args) {
        Locale locale;
        try {
            locale = getRequest().getLocale();
        } catch (Exception e) {
            locale = Locale.FRANCE;
        }
        return getMessageSource().getMessage(code, args, locale);
    }

    /**
     * returns the message in english.
     *
     * @param code the code
     * @return {@link String}
     * <p>
     * 15:33:22 by lneji
     */
    public String getDefaultMessage(String code) {

        return getMessageSource().getMessage(code, null, Locale.ENGLISH);
    }
}
