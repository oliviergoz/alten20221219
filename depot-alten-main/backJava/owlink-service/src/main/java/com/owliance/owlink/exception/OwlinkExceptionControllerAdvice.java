/*
 * Copyright Owliance © 2016 - 2017 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.exception;


import com.owliance.owlink.framework.common.ErrorInfo;
import com.owliance.owlink.framework.common.Msg;
import com.owliance.owlink.framework.constants.OwlinkError;
import com.owliance.owlink.framework.exception.BaseException;
import com.owliance.owlink.framework.exception.OwlinkServiceException;
import com.owliance.owlink.framework.utils.OwlinkExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.dao.NonTransientDataAccessResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * used to apply the same exception handling techniques across the whole application.
 *
 * @author hbenizid
 *
 *         <p>
 *         Updated : 5 juil. 2016 by hbenizid (version 0.1.5-Alpha)
 *         <p>
 *         Updated : 10 aout. 2016 by hbouslah (version 0.1.6-Alpha)
 *         <p>
 *         Updated : 14 oct. 2016 by hbenizid (version 0.2.2-Alpha)
 *         <p>
 *         Updated : 17 nov. 2016 by fmartinez (version 0.3.1-Alpha) : OwlinkServiceException
 *         <p>
 *         Updated : 08 feb. 2017 by fmartinez (version 0.3.5-Alpha) : getMessages => getMsgList
 */
@ControllerAdvice
public class OwlinkExceptionControllerAdvice {

	/**
	 * Logger class for OwlinkExceptionControllerAdvice, Default Mode is INFO.
	 */
	public static final Logger							 logger = LoggerFactory
			.getLogger(OwlinkExceptionControllerAdvice.class);

	/** The message source. */
	@Autowired
	private ReloadableResourceBundleMessageSource messageSource;

	/**
	 * Default Owlink Exception.
	 *
	 * @param request the request
	 * @param exception the ex
	 * @return {@link ErrorInfo}
	 */
	@ExceptionHandler(OwlinkException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR) // Code HTTP 500
	@ResponseBody
	public ErrorInfo handleOwlinkException(HttpServletRequest request, OwlinkException exception) {

		logger.warn("*** handleOwlinkException ***");
		ErrorInfo response = new ErrorInfo();
		response.setUrl(request.getRequestURL().toString());
		response.setCode(exception.getCode());
		response.setMessage(exception.getMessage());
		response.setTechnicalMessage(exception.getTechnicalMessage());

		logger.info("Exception Occured : [{}] ", response.toString());
		return response;
	}

	/**
	 * Default Owlink Exception.
	 *
	 * @param request the request
	 * @param exception the ex
	 * @return {@link ErrorInfo}
	 */
	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.BAD_REQUEST) // Code HTTP 400
	@ResponseBody
	public ErrorInfo handleException(HttpServletRequest request, Exception exception) {

		ErrorInfo response = null;
		logger.warn("*** Exception  {} ", exception.toString());

		if (exception instanceof MissingServletRequestParameterException) {
			response = new ErrorInfo();
			response.setUrl(request.getRequestURL().toString());
			response.setError(OwlinkError.WRONG_MISSED_PARAMETER);
			response.setTechnicalMessage(((MissingServletRequestParameterException) exception).getMessage());
		}
		else if (exception instanceof MethodArgumentTypeMismatchException) {
			response = new ErrorInfo();
			response.setUrl(request.getRequestURL().toString());
			response.setError(OwlinkError.PARAMETER_TYPE_MISMATCH);
			response.setTechnicalMessage(((MethodArgumentTypeMismatchException) exception).getMessage());
		}
		else if (exception instanceof InvalidDataAccessApiUsageException) {
			response = new ErrorInfo();
			response.setUrl(request.getRequestURL().toString());
			response.setError(OwlinkError.PARAMETER_TYPE_MISMATCH);
			response.setTechnicalMessage(((InvalidDataAccessApiUsageException) exception).getMessage());
		}

		logger.info("Exception Occured : [{}]", response);
		return response;
	}

	/**
	 * To handle locked user Exception.
	 *
	 * @param request   the request
	 * @param exception the ex
	 * @return {@link ErrorInfo}
	 */
	@ExceptionHandler({NonTransientDataAccessResourceException.class, CannotCreateTransactionException.class})
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED) // Code HTTP 401
	@ResponseBody
	public ErrorInfo customHandleException(HttpServletRequest request, Exception exception) {

		ErrorInfo response = null;
		response = new ErrorInfo();
		response.setUrl(request.getRequestURL().toString());
		response.setError(OwlinkError.LOCK_ACCOUNT_ERROR);
		response.setTechnicalMessage(exception.getMessage());
		logger.info("Exception Occured : [{}]", response);
		return response;
	}

	/**
	 * To handle Owlink Exception.
	 *
	 * @param request the request
	 * @param exception the ex
	 * @return {@link ErrorInfo}
	 */
	@SuppressWarnings("deprecation")
	@ExceptionHandler(OwlinkHandlerException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR) // Code HTTP 500
	@ResponseBody
	public ErrorInfo handleOwlinkHandlerException(HttpServletRequest request, OwlinkHandlerException exception) {

		logger.warn("*** handleOwlinkNotFoundException ***");

		ErrorInfo response = new ErrorInfo();
		response.setUrl(request.getRequestURL().toString());
		response.setCode(exception.getCode());
		response.setMessage(exception.getMessage());
		response.setTechnicalMessage(exception.getTechnicalMessage());

		logger.info("Exception Occured : [{}]", response);
		return response;
	}

	/**
	 * To handle Illegal Argument Exception.
	 *
	 * @param request the request
	 * @param exception the ex
	 * @return {@link ErrorInfo}
	 */
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED) // Code HTTP 412
	@ResponseBody
	public ErrorInfo handleDataIntegrityViolationException(HttpServletRequest request,
			DataIntegrityViolationException exception) {

		logger.error("DataIntegrityViolationException Occured : Cause = [{}] ", exception.getCause().toString());

		ErrorInfo response = new ErrorInfo();
		response.setUrl(request.getRequestURL().toString());
		response.setError(OwlinkError.INVALID_DATA);
		response.setTechnicalMessage(exception.getMessage());

		logger.info("Exception Occured : [{}]", response);
		return response;
	}

	/**
	 * To handle Illegal Argument Exception.
	 *
	 * @param request the request
	 * @param exception the ex
	 * @return {@link ErrorInfo}
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED) // Code HTTP 412
	@ResponseBody
	public ErrorInfo handleIllegalArgumentException(HttpServletRequest request, IllegalArgumentException exception) {

		logger.error("IllegalArgumentException Occured : Cause = [{}] ", exception.getCause().toString());

		ErrorInfo response = new ErrorInfo();
		response.setUrl(request.getRequestURL().toString());
		response.setError(OwlinkError.INVALID_DATA);
		response.setTechnicalMessage(exception.getMessage());

		logger.info("IllegalArgumentException Occured : {} ", response.getMessage());
		return response;
	}

	/**
	 * handle JpaSystemException.
	 *
	 * @param request the request
	 * @param exception the exception
	 * @return {@link ErrorInfo}
	 */
	@ExceptionHandler(JpaSystemException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND,
			reason = "For some Reasons the data you are looking for is not found. Try again later.")
	@ResponseBody
	public ErrorInfo handleJpaSystemException(HttpServletRequest request, JpaSystemException exception) {

		logger.warn("*** handleJpaSystemException ***");
		logger.error("handleJpaSystemException Occured :: Cause = {} ", OwlinkExceptionUtils.getMessage(exception));
		ErrorInfo response = new ErrorInfo();
		response.setUrl(request.getRequestURL().toString());
		response.setError(OwlinkError.DATA_NOT_FOUND);
		response.setTechnicalMessage(exception.getMessage());

		logger.info("handleJpaSystemException Occured : {}", exception.getCause().getMessage());
		return response;
	}

	/**
	 * To handle SQL Exception.
	 *
	 * @param request the request
	 * @param exception the ex
	 * @return {@link ErrorInfo}
	 *
	 *         Code HTTP 404
	 */
	@ExceptionHandler(SQLException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND,
			reason = "For some Reasons the data you are looking for is not found. Try again later.")
	@ResponseBody
	public ErrorInfo handleSQLException(HttpServletRequest request, SQLException exception) {

		logger.warn("*** handleSQLException ***");
		logger.error("SQLException Occured :: Cause =" + exception.getCause());

		ErrorInfo response = new ErrorInfo();
		response.setUrl(request.getRequestURL().toString());
		response.setMessage(exception.getMessage());

		logger.info("SQLException Occured : {}", response.getMessage());
		return response;
	}

	/**
	 * To handle java.sql.BatchUpdateException
	 *
	 * @param request the request
	 * @param ex the ex
	 * @return {@link ErrorInfo}
	 */
	@ExceptionHandler(java.sql.BatchUpdateException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR) // Code HTTP 500
	@ResponseBody
	public ErrorInfo batchUpdateException(HttpServletRequest request, java.sql.BatchUpdateException ex) {

		logger.warn("*** batchUpdateException ***");

		logger.error("batchUpdateException Occured :: Cause ={}", ex.getCause().toString());
		logger.error("batchUpdateException Occured :: Message ={}", ex.getErrorCode());

		ErrorInfo response = new ErrorInfo();
		response.setUrl(request.getRequestURL().toString());
		response.setMessage("Error while Executing query, you have to verify missing parameters");

		logger.info("Exception Occured : {}", response.getMessage());
		return response;
	}

	/**
	 * Service Owlink Exception.
	 *
	 * @param request the request
	 * @param exception the ex
	 * @return {@link ErrorInfo}
	 *         <p>
	 *         Updated : 08 feb. 2017 by fmartinez (version 0.3.5-Alpha) : getMessages => getMsgList
	 */
	@ExceptionHandler(OwlinkServiceException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR) // Code HTTP 500
	@ResponseBody
	public List<String> handleOwlinkException(HttpServletRequest request, OwlinkServiceException exception) {

		logger.warn("*** handleOwlinkServiceException ***");

		/* Liste des messages résolus */
		ArrayList<String> resList = new ArrayList<>();

		/* Liste des messages associée à l'exception */
		ArrayList<Object> tmpList = exception.getMsgList().getMsgArrayList();

		/* Constitution de la liste des messages formatés */
		Msg msg;
		String message;
		for (int i = tmpList.size() - 1; i >= 0; i--) {
			msg = (Msg) tmpList.get(i);

			try {
				message = messageSource.getMessage(msg.getMessageKey(), msg.getArgsMessage(), request.getLocale());
				resList.add(message);
				logger.info("#### handleOwlinkServiceException : Msg[{}]= {}", i, message);
			}
			catch (Exception e) {
				logger.error("#### handleOwlinkServiceException : unresolved message [{}] #### [{}]", i,
						BaseException.toStringStackTrace(e));
			}
		}

		return resList;
	}
}
