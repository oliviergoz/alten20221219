package com.owliance.owlink.framework.controller;

import com.owliance.owlink.framework.entity.BaseObject;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;


/**
 * Cette classe permet de former le résultat pour une réponse de requête avec de la pagination
 * @param <T> N'importe quel objet Base... (BaseVO, BaseBVO, BaseWVO...)
 */
public abstract class BaseRechercheContent<T extends BaseObject> implements Serializable {

    /**
     * Liste des éléments à renvoyer
     */
    private List<T> elements;

    /**
     * Nombre total d'éléments disponibles (pour la pagination)
     */
    private Long totalElements;

    /**
     * Nombre total de pages disponibles (pour la pagination)
     */
    private Integer totalPages;

    /**
     * Permet de construire l'objet
     */
    protected BaseRechercheContent() {

    }

    /**
     * Permet de construire l'objet avec un objet Page en paramètre
     * @param page Page
     */
    protected BaseRechercheContent(Page<T> page) {
        this.elements = page.getContent();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
    }

    /**
     * Permet de construire l'objet
     * @param elements Les éléments à renvoyer
     * @param totalElements Nombre total d'éléments disponibles
     * @param totalPages Nombre total de pages disponibles
     */
    protected BaseRechercheContent(List<T> elements, Long totalElements, Integer totalPages) {
        this.elements = elements;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    /**
     * Récupère les éléments
     * @return Les élements
     */
    public List<T> getElements() {
        return elements;
    }

    /**
     * Attribut les éléments
     * @param elements Les éléments
     */
    public void setElements(List<T> elements) {
        this.elements = elements;
    }

    /**
     * Récupère le nombre total d'éléments (pour la pagination)
     * @return Nombre total d'éléments
     */
    public Long getTotalElements() {
        return totalElements;
    }

    /**
     * Attribut le nombre total d'éléments (pour la pagination)
     * @param totalElements Nombre total d'éléments
     */
    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    /**
     * Récupère le nombre total de pages (pour la pagination)
     * @return Nombre total de pages
     */
    public Integer getTotalPages() {
        return totalPages;
    }

    /**
     * Attribut le nombre total de pages (pour la pagination)
     * @param totalPages Nombre total de pages
     */
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

}
