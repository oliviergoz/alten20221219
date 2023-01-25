package com.owliance.owlink.repository;

import com.owliance.owlink.vo.ActeRemboursementVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The ActeRemboursement repository
 *
 * @author ybahri
 * @since 0.6.0-Alpha
 *
 * @see com.owliance.owlink.repository
 *
 *      <p>
 *      Created : 17 dec. 2017
 *      <p>
 *      Updated : 17 dec. 2017 by ybahri (version 0.6.0-Alpha)
 *
 */
@Repository
public interface ActeRemboursementDAO extends JpaRepository<ActeRemboursementVO, Integer>, CrudRepository<ActeRemboursementVO, Integer>,
        PagingAndSortingRepository<ActeRemboursementVO, Integer>, QuerydslPredicateExecutor<ActeRemboursementVO> {

    /**
     * Récupère les formules selon l'id organisme, l'id produit, l'id option, l'id risque et la date de fin du salaire annulé déclaré
     *
     * @param dateFin la date de fin du salaire annulé déclaré
     * @return la liste des formules
     */
    @Query(value = "select actRbt.formule from ActeRemboursementVO actRbt"
            + " where actRbt.dateEffet < :dateFin"
            + " order by actRbt.dateEffet desc")
    List<String> getFormulesForSinistreSalaire(@Param("dateFin") Date dateFin);

    /**
     * Récupère l'acte de remboursement selon l'organisme, le produit, l'option, le risque et l'acte
     * @param idAct l'identifiant de l'acte
     * @return Liste d'acte de remboursement
     */
    @Query(value = "select actRbt from ActeRemboursementVO actRbt where actRbt.idAct = :idAct")
    List<ActeRemboursementVO> getActRbtByActeAndRisque(@Param("idAct") String idAct);

    /**
     * Récupère l'acte de remboursement selon l'organisme, le produit, l'option et l'acte
     * @return Liste d'acte de remboursement
     */
    @Query(value = "select actRbt from ActeRemboursementVO actRbt")
    List<ActeRemboursementVO> getActRbtByActeAndOption();
}
