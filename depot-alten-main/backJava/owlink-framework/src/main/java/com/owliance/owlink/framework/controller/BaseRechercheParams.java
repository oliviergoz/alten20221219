package com.owliance.owlink.framework.controller;

public abstract class BaseRechercheParams {
    /**
     * Numéro de la page
     */
    protected Integer pageNum = 0;

    /**
     * Nombre d'éléments dans la page
     */
    protected Integer pageSize = 10;


    /**
     * Champs sur lequel effectuer le tri
     */
    protected String sortField = "";

    /**
     * Ordre de tri des éléments
     */
    protected SortOrder sortOrder = SortOrder.ASC;

    /**
     * Récupère le numéro de page
     * @return Numéro de page
     */
    public Integer getPageNum() {
        return pageNum;
    }

    /**
     * Attribut le numéro de page
     * @param pageNum Numéro de page
     */
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * Récupère le nombre d'éléments par page
     * @return Nombre d'éléments par page
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Attribut le nombre d'éléments par page
     * @param pageSize Nombre d'éléments par page
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Récupère l'ordre de triage des éléments
     * @return Ordre de triage des éléments
     */
    public SortOrder getSortOrder() {
        return sortOrder;
    }

    /**
     * Récupère le nom du champs sur lequel effectuer le tri
     * @return le nom du champs sur lequel effectuer le tri
     */
    public String getSortField() {
        return sortField;
    }

    /**
     * attribue le nom du champs sur lequel effectuer le tri
     * @param sortField le nom du champs sur lequel effectuer le tri
     */
    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    /**
     * Attribut l'ordre de triage des éléments
     * @param sortOrder Ordre de triage des éléments
     */
    public void setSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

}
