package com.owliance.owlink.service;

import com.owliance.owlink.bvo.ActeRemboursementBVO;

import java.util.Date;
import java.util.List;

public interface IActeRemboursementService {

	/**
	 * Find acte remboursement by ID
	 *
	 * @param acte the acte remborsement with setted ID
	 * @return the requested {@link ActeRemboursementBVO}
	 */
	ActeRemboursementBVO find(ActeRemboursementBVO acte);

	/**
	 * Récupère les formules selon l'id organisme, l'id produit, l'id option, l'id risque et la date de fin du salaire annulé déclaré
	 *
	 * @param idOrg l'id organisme
	 * @param idProd l'id produit
	 * @param idOption l'id option
	 * @param idRisque l'id risque
	 * @param dateFin la date de fin du salaire annulé déclaré
	 * @return la liste des formules
	 */
	List<String> getFormulesForSinistreSalaire(Integer idOrg, String idProd, String idOption, String idRisque, Date dateFin);

	/**
	 * Récupère l'acte de remboursement selon l'organisme, le produit, l'option, le risque et l'acte
	 * @param idOrg l'identifiant de l'organisme
	 * @param idProd l'identifiant du produit
	 * @param idOption l'identifiant de l'option
	 * @param idRisque l'identifiant du risque
	 * @param idAct l'identifiant de l'acte
	 * @return Liste d'acte de remboursement
	 */
	List<ActeRemboursementBVO> getActRbtByActeAndRisque(Integer idOrg, String idProd, String idOption, String idRisque, String idAct);

	/**
	 * Récupère l'acte de remboursement selon l'organisme, le produit, l'option, et l'acte
	 * @param idOrg l'identifiant de l'organisme
	 * @param idProd l'identifiant du produit
	 * @param idOption l'identifiant de l'option
	 * @param idAct l'identifiant de l'acte
	 * @return Liste d'acte de remboursement
	 */
	List<ActeRemboursementBVO> getActRbtByActeAndOption(Integer idOrg, String idProd, String idOption, String idAct);
}
