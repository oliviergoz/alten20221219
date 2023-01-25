package com.owliance.owlink.service.impl;

import com.google.common.base.Preconditions;
import com.owliance.owlink.bvo.ActeRemboursementBVO;
import com.owliance.owlink.framework.constants.OwlinkMessages;
import com.owliance.owlink.framework.exception.OwlinkServiceException;
import com.owliance.owlink.framework.service.BaseService;
import com.owliance.owlink.repository.ActeRemboursementDAO;
import com.owliance.owlink.service.IActeRemboursementService;
import com.owliance.owlink.vo.ActeRemboursementVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ActeRemboursementServiceImpl extends BaseService implements IActeRemboursementService {

    /**
     * Logger class for ActeRemboursementServiceImpl, Default Mode is INFO.
     */
    private static final Logger logger = LoggerFactory.getLogger(ActeRemboursementServiceImpl.class);

    /**
     * The Constant LOCALIZED_ENTITY_TYPE.
     */
    public static final String LOCALIZED_ENTITY_TYPE = "msg.error.type.acte.remboursement";

    /**
     * Constante MSG_ERROR_GET_ACTE_REMBOURSEMENT
     */
    public static final String MSG_ERROR_GET_ACTE_REMBOURSEMENT = "msg.cause.get.acte.remboursement";

    /**
     * ActeRemboursement repository.
     */
    @Resource
    private ActeRemboursementDAO repository;

    /**
     * @see IActeRemboursementService#find(ActeRemboursementBVO)
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ActeRemboursementBVO find(ActeRemboursementBVO acte) {

        logger.info(OwlinkMessages.ARGUMENT_TEST_AGAINST_NULL);
        Preconditions.checkArgument(acte != null);
        Preconditions.checkArgument(acte.getId() != null);
        logger.info(OwlinkMessages.RETRIEVING_ELEMENT_FROM_DB);
        ActeRemboursementVO acteResult = repository.findById(acte.getId()).orElse(null);
        logger.info(OwlinkMessages.DATA_INTEGRITY_CHECK1);
        if (acteResult == null) {
            logger.info(OwlinkMessages.NOT_FOUND_OBJECT_IDENTIFIER1, "idActeRebt", acte.getId());
            addMsgKo("", MSG_ERROR_GET_ACTE_REMBOURSEMENT, new String[]{String.valueOf(acte.getId())},
                    new OwlinkServiceException(getMessage(MSG_ERROR_GET_ACTE_REMBOURSEMENT) + acte.getId(), null));
            addMsgUnableToGet(getMessage(LOCALIZED_ENTITY_TYPE), "", "",
                    new OwlinkServiceException(getMessage(MSG_ERROR_GET_ACTE_REMBOURSEMENT) + acte.getId(), null));
            throw new OwlinkServiceException(getOwlinkContext().getMsgList());
        }
        logger.info("creating new Object ActeRemboursementBVO");
        return voToBvo(acteResult, ActeRemboursementBVO.class);
    }

    /**
     * @see IActeRemboursementService#getFormulesForSinistreSalaire(Integer, String, String, String, Date)
     */
    @Override
    public List<String> getFormulesForSinistreSalaire(Integer idOrg, String idProd, String idOption, String idRisque, Date dateFin) {
        logger.info(OwlinkMessages.ARGUMENT_TEST_AGAINST_NULL);
        Preconditions.checkArgument(idOrg != null);
        Preconditions.checkArgument(idProd != null);
        Preconditions.checkArgument(idOption != null);
        Preconditions.checkArgument(dateFin != null);
        logger.info(OwlinkMessages.RETRIEVING_ELEMENT_FROM_DB);
        return repository.getFormulesForSinistreSalaire(dateFin);
    }

    /**
     * @see IActeRemboursementService#getActRbtByActeAndRisque(Integer, String, String, String, String)
     */
    @Override
    public List<ActeRemboursementBVO> getActRbtByActeAndRisque(Integer idOrg, String idProd, String idOption, String idRisque, String idAct) {
        logger.info(OwlinkMessages.ARGUMENT_TEST_AGAINST_NULL);
        Preconditions.checkNotNull(idOrg);
        Preconditions.checkNotNull(idProd);
        Preconditions.checkNotNull(idOption);
        Preconditions.checkNotNull(idRisque);
        Preconditions.checkNotNull(idAct);
        logger.info(OwlinkMessages.RETRIEVING_ELEMENT_FROM_DB);
        return listVoToBvo(repository.getActRbtByActeAndRisque(idAct), ActeRemboursementBVO.class);
    }

    /**
     * @see IActeRemboursementService#getActRbtByActeAndOption(Integer, String, String, String)
     */
    @Override
    public List<ActeRemboursementBVO> getActRbtByActeAndOption(Integer idOrg, String idProd, String idOption, String idAct) {
        logger.info(OwlinkMessages.ARGUMENT_TEST_AGAINST_NULL);
        Preconditions.checkNotNull(idOrg);
        Preconditions.checkNotNull(idProd);
        Preconditions.checkNotNull(idOption);
        Preconditions.checkNotNull(idAct);
        logger.info(OwlinkMessages.RETRIEVING_ELEMENT_FROM_DB);
        return listVoToBvo(repository.getActRbtByActeAndOption(), ActeRemboursementBVO.class);
    }
}
