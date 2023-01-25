/*
 * Copyright Owliance © 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.framework.entity;


import java.io.Serializable;


/**
 * Class base for all BVO objects
 * 
 * @since 0.1.5-Alpha
 * @see BaseObject
 *      <p>
 *      Created : 11 juil 2016
 *      <p>
 *      Updated : 13 juil 2016 by hbenizid (version 0.1.5-Alpha)
 *      <p>
 *      Updated : 14 oct. 2016 by hbenizid (version 0.2.2-Alpha)
 *      <p>
 *      Updated : 19 oct. 2016 by fmartinez (version 0.2.3-Alpha)
 */
public abstract class BaseBVO extends BaseObject implements Serializable {

	private static final long	serialVersionUID = -6400336008472201879L;

	/**
	 * Le BVO n'a pas de statut de persistance. Cet état correspond à la majorité des cas c-à-d
	 * lorsque qu'il est inutile de gérer l'état de persistance pour faire un traitement.
	 */
	public static final int		STATE_NONE		  = 0;

	/**
	 * Le BVO est persistant avec la source de données.
	 */
	public static final int		STATE_PERSISTENT = 1;

	/**
	 * Le BVO n'existe pas dans la source de données et y doit-être créé.
	 */
	public static final int		STATE_CREATED	  = 2;

	/**
	 * Le BVO existe dans la source de données et y doit-être mise à jour.
	 */
	public static final int		STATE_MODIFIED	  = 3;

	/**
	 * Le BVO existe dans la source de données et y doit-être supprimé.
	 */
	public static final int		STATE_DELETED	  = 4;

	/**
	 * Etat de persistence du BVO. Voir les constantes STATE_*. Cet attribut permet de savoir l'état
	 * de persistance entre le BVO et la source de données. Par défaut state==STATE_NONE : donc sans
	 * état.
	 */
	private int						state;

	/** Indique si le BVO est complet ou partiel. */
	private boolean				full;

	/**
	 * Suffix utilisé pour désigner les classes héritant de <code>BaseBVO</code> .
	 */
	public static final String	CLASS_SUFFIX	  = "BVO";

	/**
	 * Constror.
	 * <p/>
	 * Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 * <p/>
	 * Modifiée le : 13 juil 2016 by hbenizid (version 0.1.5-Alpha)
	 * <p/>
	 * Modifiée le : 19 oct. 2016 by fmartinez (version 0.2.3-Alpha)
	 */
	public BaseBVO() {
		super();
		setState(STATE_NONE);
	}

	/**
	 * Description.
	 *
	 * @return <code>true</code> : BVO complet, <code>false</code> : BVO incomplet
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	public boolean isFull() {

		return full;
	}

	/**
	 * Description.
	 *
	 * @param b <code>true</code> : BVO complet, <code>false</code> : BVO incomplet
	 *           <p>
	 *           Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *           <p>
	 *           Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	public void setFull(boolean b) {

		full = b;
	}

	/**
	 * Description.
	 *
	 * @return int état de persistance du BVO
	 *         <p>
	 *         Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *         <p>
	 *         Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	public int getState() {

		return state;
	}

	/**
	 * Description.
	 *
	 * @param state int état de persistance du BVO
	 *           <p>
	 *           Created : 08 juil 2016 by fmartinez (version 0.1.5-Alpha)
	 *           <p>
	 *           Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	public void setState(int state) {

		if (this.state != STATE_NONE && this.state != STATE_PERSISTENT && this.state != STATE_CREATED
				&& this.state != STATE_MODIFIED && this.state != STATE_DELETED) {
			throw new IllegalArgumentException("setState - invalid state= " + state);
		}
		else {
			this.state = state;
		}
	}
}
