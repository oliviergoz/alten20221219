package com.owliance.owlink.controller;

import com.owliance.owlink.bvo.ActeRemboursementBVO;
import com.owliance.owlink.endpoints.rest.ActeRemboursementEndPoint;
import com.owliance.owlink.framework.constants.OwlinkURLConstants;
import com.owliance.owlink.framework.controller.BaseController;
import com.owliance.owlink.service.IActeRemboursementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = OwlinkURLConstants.ACTE_REMBOURSEMENT_ENDPOINT_ROOT)
public class ActeRemboursementController extends BaseController implements ActeRemboursementEndPoint {

    /**
     * Logger class for ActeRemboursementController, Default Mode is INFO
     */
    private static final Logger logger = LoggerFactory.getLogger(ActeRemboursementController.class);

    @Resource
    private IActeRemboursementService acteRemboursementService;

    /**
     * @see ActeRemboursementEndPoint#getFormulesForSinistreSalaire(Integer, String, String, String, Date)
     */
    @Override
    public List<String> getFormulesForSinistreSalaire(Integer idOrg, String idProd, String idOption, String idRisque, Date dateFin) {
        return acteRemboursementService.getFormulesForSinistreSalaire(idOrg, idProd, idOption, idRisque, dateFin);
    }

    /**
     * @see ActeRemboursementEndPoint#getActRbtByActeAndRisque(Integer, String, String, String, String)
     */
    @Override
    public List<ActeRemboursementBVO> getActRbtByActeAndRisque(Integer idOrg, String idProd, String idOption, String idRisque, String idAct) {
        return acteRemboursementService.getActRbtByActeAndRisque(idOrg, idProd, idOption, idRisque, idAct);
    }

    /**
     * @see ActeRemboursementEndPoint#getActRbtByActeAndRisque(Integer, String, String, String, String)
     */
    @Override
    public List<ActeRemboursementBVO> getActRbtByActeAndOption(Integer idOrg, String idProd, String idOption, String idAct) {
        return acteRemboursementService.getActRbtByActeAndOption(idOrg, idProd, idOption, idAct);
    }
}
