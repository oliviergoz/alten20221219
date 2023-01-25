package com.owliance.owlink.endpoints.rest;

import com.owliance.owlink.bvo.ActeRemboursementBVO;
import com.owliance.owlink.framework.constants.OwlinkURLConstants;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;


public interface ActeRemboursementEndPoint {

    /**
     * Récupère les formules selon l'id organisme, l'id produit, l'id option, l'id risque et la date de fin du salaire annulé déclaré
     *
     * @param idOrg    l'id organisme
     * @param idProd   l'id produit
     * @param idOption l'id option
     * @param idRisque l'id risque
     * @param dateFin  la date de fin du salaire annulé déclaré
     * @return la liste des formules
     */
    @GetMapping(value = OwlinkURLConstants.ACTE_REMBOURSEMENT_ENDPOINT_GET_FORMULES_FOR_SINISTRE_SALAIRE, produces = MediaType.APPLICATION_JSON_VALUE)
    List<String> getFormulesForSinistreSalaire(@RequestParam("idOrg") Integer idOrg,
                                               @RequestParam("idProd") String idProd,
                                               @RequestParam("idOption") String idOption,
                                               @RequestParam(value = "idRisque", required = false) String idRisque,
                                               @RequestParam("dateFin") Date dateFin);

    /**
     * Récupère l'acte de remboursement selon l'organisme, le produit, l'option, le risque et l'acte
     *
     * @param idOrg    l'identifiant de l'organisme
     * @param idProd   l'identifiant du produit
     * @param idOption l'identifiant de l'option
     * @param idRisque l'identifiant du risque
     * @param idAct    l'identifiant de l'acte
     * @return Liste d'acte de remboursement
     */
    @GetMapping(value = OwlinkURLConstants.ACTE_REMBOURSEMENT_ENDPOINT_GET_ACTRBT_BY_ACTE_AND_RISQUE, produces = MediaType.APPLICATION_JSON_VALUE)
    List<ActeRemboursementBVO> getActRbtByActeAndRisque(@RequestParam("idOrg") Integer idOrg,
                                                        @RequestParam("idProd") String idProd,
                                                        @RequestParam("idOption") String idOption,
                                                        @RequestParam("idRisque") String idRisque,
                                                        @RequestParam("idAct") String idAct);

    /**
     * Récupère l'acte de remboursement selon l'organisme, le produit, l'option, et l'acte
     *
     * @param idOrg    l'identifiant de l'organisme
     * @param idProd   l'identifiant du produit
     * @param idOption l'identifiant de l'option
     * @param idAct    l'identifiant de l'acte
     * @return Liste d'acte de remboursement
     */
    @GetMapping(value = OwlinkURLConstants.ACTE_REMBOURSEMENT_ENDPOINT_GET_ACTRBT_BY_ACTE_AND_OPTION, produces = MediaType.APPLICATION_JSON_VALUE)
    List<ActeRemboursementBVO> getActRbtByActeAndOption(
            @RequestParam("idOrg") Integer idOrg,
            @RequestParam("idProd") String idProd,
            @RequestParam("idOption") String idOption,
            @RequestParam("idAct") String idAct
    );
}
