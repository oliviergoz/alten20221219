/*
 * Copyright Owliance © 2016 - 2016 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.framework.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * Class base for Message List
 *
 * @author fmartinez
 * @since 0.2.2-Alpha
 * @see com.owliance.owlink.framework.common
 *      <p>
 *      Created : 13 juil 2016
 *      <p>
 *      Updated : 11 nov. 2016 by hbenizid (version 0.3.0-Alpha)
 *      <p>
 *      Updated : 08 feb. 2017 by fmartinez (version 0.3.5-Alpha) : extractMsgList and message key
 *      <p>
 *      Updated : 10 feb. 2017 by fmartinez (version 0.3.5-Alpha) : size(), size(businessCase)
 *      <p>
 *      Updated : 08 mar. 2017 by fmartinez (version 0.3.6-Alpha) : DEFAULT_DAOCASE
 */
public class MsgList implements java.io.Serializable {

	private static final long	 serialVersionUID	= -6203817078272253059L;

	/** The <code>Logger</code> instance for this class. */
	private static final Logger logger				= LoggerFactory.getLogger(MsgList.class);

	/**
	 * Default key for message
	 */
	public static final String	 DEFAULT_BUSNCASE	= "DEFAULT_BUSNCASE";
	/**
	 * The Default daocase.
	 */
	public static final String	 DEFAULT_DAOCASE	= "DEFAULT_DAOCASE";

	/**
	 * Structure Map [businessCase -> List <[Msg, Objet]> : cette map permet de regrouper des
	 * <Msg,Object> par identifiant métier
	 */
	private Map<Object, Object> msgMap;

	/**
	 * Structure List <[Msg, Objet]> -> Contient l'ensemble de tous les <Msg,Object> ajoutés
	 */
	private List<Object>			 msgList;

	/**
	 * Constructor.
	 * <p/>
	 * Created : 13 juil 2016 by fmartinez (version 0.1.6-Alpha)
	 * <p/>
	 * Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	public MsgList() {
		super();
		this.msgMap = new HashMap<>();
		this.msgList = new ArrayList<>();
	}

	/**
	 * Constructeur.
	 * <p/>
	 * Created : 13 juil 2016 by fmartinez (version 0.1.6-Alpha)
	 * <p/>
	 * Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 *
	 * @param msgList the msg list
	 */
	public MsgList(MsgList msgList) {
		super();
		this.msgMap = new HashMap<>();
		this.msgList = new ArrayList<>();
		add(msgList);
	}

	/**
	 * Clear.
	 * <p/>
	 * Example :
	 * <p/>
	 * Created : 13 juil 2016 by fmartinez (version 0.1.6-Alpha)
	 * <p/>
	 * Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	public void clear() {

		this.msgMap.clear();
		this.msgList.clear();
	}

	/**
	 * Remove all items for businessCase.
	 *
	 * @param businessCase Business case.
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 13 juil 2016 by fmartinez (version 0.1.6-Alpha)
	 *           <p>
	 *           Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	@SuppressWarnings("unchecked")
	public void clear(String businessCase) {

		// Récupération des éléments attachés au cas métier.
		List<Object> listMsgObject = (List<Object>) this.msgMap.get(businessCase);
		for (int i = listMsgObject.size() - 1; i > -1; i--) {
			Object msgObject = listMsgObject.get(i);
			this.msgList.remove(msgObject);
		}
		this.msgMap.remove(businessCase);
	}

	/**
	 * Nombre de messages dans la Map.
	 *
	 * @return int Nombre de messages dans la Map.
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 13 juil 2016 by fmartinez (version 0.1.6-Alpha)
	 *         <p>
	 *         Updated : 10 feb. 2017 by fmartinez (version 0.3.5-Alpha) : returns incorrect value
	 */
	public int size() {

		int size = 0;
		if (this.msgList != null) {
			size = this.msgList.size();
		}
		logger.debug("size= {}", size);
		return size;
	}

	/**
	 * Nombre de messages liés à un cas métier dans la Map.
	 *
	 * @param businessCase String Identifiant du cas métier dans lequel on est.
	 *
	 * @return int Nombre de messages dans la Map.
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 13 juil 2016 by fmartinez (version 0.1.6-Alpha)
	 *         <p>
	 *         Updated : 10 feb. 2017 by fmartinez (version 0.3.5-Alpha) : returns incorrect value
	 */
	public int size(String businessCase) {

		int size = 0;
		if (this.msgMap != null) {
			size = getMsgListByKey(businessCase).size();
		}
		logger.debug("size() = {}", size);
		return size;
	}

	/**
	 * Add a message.
	 *
	 * @param msg Message to add
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 13 juil 2016 by fmartinez (version 0.1.6-Alpha)
	 *           <p>
	 *           Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	public void addMsg(Msg msg) {

		addMsg(msg, null);
	}

	/**
	 * Add a message <Msg,Object>.
	 *
	 * @param msg Message to add
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 13 juil 2016 by fmartinez (version 0.1.6-Alpha)
	 *           <p>
	 *           Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 * @param object the object
	 */
	public void addMsg(Msg msg, Object object) {

		addMsg(DEFAULT_BUSNCASE, msg, object);
	}

	/**
	 * Add a message <Msg,Object> for a Business case
	 *
	 * @param businessCase Business case.
	 * @param msg Message.
	 * @param object Objet.
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 13 juil 2016 by fmartinez (version 0.1.6-Alpha)
	 *           <p>
	 *           Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	public void addMsg(String businessCase, Msg msg, Object object) {

		addToMsgListByKey(businessCase, msg, object, true);
	}

	/**
	 * Add a message <Msg,Object> for a Business case
	 * 
	 * @param businessCase Business case.
	 * @param msg Message.
	 * @param object Objet.
	 * @param addToList Add to message list.
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 13 juil 2016 by fmartinez (version 0.1.6-Alpha)
	 *           <p>
	 *           Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void addToMsgListByKey(String businessCase, Msg msg, Object object, boolean addToList) {

		if (this.msgMap == null) {
			this.msgMap = new HashMap<>();
		}

		// Messages for this business case
		List<Object> msgList = (List<Object>) msgMap.get(businessCase);

		// Instanciation dans le cas où il n'y a pas de message associé à cette
		// clé métier.
		if (msgList == null) {
			msgList = new ArrayList();
		}

		// Ajout du message à la liste pour cette clé métier
		Object msgObject = new Object[] { msg, object };
		msgList.add(msgObject);

		// Réinsertion de la liste des messages dans la map
		this.msgMap.put(businessCase, msgList);

		if (addToList) {
			if (this.msgList == null) {
				this.msgList = new ArrayList();
			}
			// Ajout du message dans la liste totale des messages
			this.msgList.add(msgObject);
		}
	}

	/**
	 * Add a MsgList into this.
	 *
	 * @param srcMsgList Source list
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 13 juil 2016 by fmartinez (version 0.1.6-Alpha)
	 *           <p>
	 *           Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	public void add(MsgList srcMsgList) {

		if (srcMsgList != null) {
			// On boucle sur la liste des cleMetier de la liste à ajouter
			for (Iterator<Object> itrMsgMap = srcMsgList.msgMap.keySet().iterator(); itrMsgMap.hasNext();) {
				String businessCase = (String) itrMsgMap.next();

				// Récupération de la liste des paires [Msg, Object] associée à
				// cette clé Métier
				List<Object> msgObjectList = srcMsgList.getMsgListByKey(businessCase);
				for (Iterator<Object> itrMsgObjectList = msgObjectList.iterator(); itrMsgObjectList.hasNext();) {
					Object[] msgObject = (Object[]) itrMsgObjectList.next();
					// Ajout dans la Map this.msgsMap.
					// L'ajout à la liste des messages (this.msgList) ne se
					// fait pas à ce niveau là afin de garder l'ordre contenu
					// dans le srcMsgList passé en paramètre
					this.addToMsgListByKey(businessCase, (Msg) msgObject[0], msgObject[1], false);
				}
				// Ajout de la liste des msgObject(s).
			}
			this.msgList.addAll(srcMsgList.msgList);
		}
	}

	/**
	 * Add a message list.
	 *
	 * @param msgList List to add
	 *           <p>
	 *           Example :
	 *           <p>
	 *           Created : 13 juil 2016 by fmartinez (version 0.1.6-Alpha)
	 *           <p>
	 *           Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	public void addMsgList(List<Object> msgList) {

		if (msgList != null) {
			for (Iterator<Object> itrMsg = msgList.iterator(); itrMsg.hasNext();) {
				Msg msg = (Msg) itrMsg.next();
				addMsg(msg);
			}
		}
	}

	/**
	 * Retourne la liste des messages sous formes d'ArrayList.
	 *
	 * @return ArrayList<Msg> Liste de tous les messages stockés
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 30 sept 2016 by fmartinez (version 0.1.6-Alpha)
	 *         <p>
	 *         Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	public ArrayList<Object> getMsgArrayList() {

		return (ArrayList<Object>) extractMsgList(this.msgList);
	}

	/**
	 * Retourne la liste des messages sous formes d'ArrayList.
	 *
	 * @return ArrayList<Object> Liste de tous objets stockés dans le MsgList.
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 30 sept 2016 by fmartinez (version 0.1.6-Alpha)
	 *         <p>
	 *         Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	public ArrayList<Object> getObjectsArrayList() {

		return (ArrayList<Object>) extractObjectsList(this.msgList);
	}

	/**
	 * Méthode permettant de récupérer la liste des paires [Msg, Object] associée à un cas métier
	 * identifié par businessCase.
	 *
	 * @param businessCase String Identifiant d'un cas métier.
	 *
	 * @return List <[Msg, Object]>
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 30 sept 2016 by fmartinez (version 0.1.6-Alpha)
	 *         <p>
	 *         Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	@SuppressWarnings("unchecked")
	public List<Object> getMsgListByKey(String businessCase) {

		if (this.msgMap == null) {
			this.msgMap = new HashMap<>();
		}
		// Recuperation des messages stockés sous la clé key
		List<Object> msgObjectList = (List<Object>) msgMap.get(businessCase);

		// Instanciation dans le cas où il n'y en a pas.
		if (msgObjectList == null) {
			msgObjectList = new ArrayList<>();
		}
		return msgObjectList;
	}

	/**
	 * Méthode permettant de récupérer le Message attaché à un cas métier.
	 *
	 * @param businessCase String Identifiant d'un cas métier.
	 *
	 * @return List<Msg> - Liste des messages.
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 30 sept 2016 by fmartinez (version 0.1.6-Alpha)
	 *         <p>
	 *         Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	public List<Object> getMsgByKey(String businessCase) {

		return extractMsgList(getMsgListByKey(businessCase));
	}

	/**
	 * Méthode permettant de récupérer l'ensemble des objets attaché à un cas métier.
	 *
	 * @param businessCase String Identifiant d'un cas métier.
	 *
	 * @return List<Object> Liste des objets attachés au cas métier.
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 30 sept 2016 by fmartinez (version 0.1.6-Alpha)
	 *         <p>
	 *         Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	public List<Object> getObjectsByKey(String businessCase) {

		return extractObjectsList(getMsgListByKey(businessCase));
	}

	/**
	 * Méthode permettant d'extraire à partir d'une liste d'elements (dont la structure est [Msg,
	 * Object]) l'ensemble des Messages stockés.
	 * 
	 * @param msgObjectList List<[Msg, Object]>.
	 * @return List<Msg>
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 30 sept 2016 by fmartinez (version 0.1.6-Alpha)
	 *         <p>
	 *         Updated : 08 feb. 2017 by fmartinez (version 0.3.5-Alpha) : for and log
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<Object> extractMsgList(List<Object> msgObjectList) {

		List<Object> msgList = null;
		if (msgObjectList != null) {

			logger.debug("msgObjectList().size={}", msgObjectList.size());

			msgList = new ArrayList();

			for (Object o: msgObjectList) {
				Msg msg = (Msg) ((Object[]) o)[0];
				msgList.add(msg);
			}
			logger.debug("RETURN MsgList().size={}", msgList.size());
		}

		return msgList;
	}

	/**
	 * Méthode permettant d'extraire à partir d'une liste d'elements (dont la structure est [Msg,
	 * Object]) l'ensemble des "Object" stockés associés aux messages.
	 * 
	 * @param msgObjectList List<[Msg, Object]>.
	 * @return List<Msg>
	 *         <p>
	 *         Example :
	 *         <p>
	 *         Created : 30 sept 2016 by fmartinez (version 0.1.6-Alpha)
	 *         <p>
	 *         Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<Object> extractObjectsList(List<Object> msgObjectList) {

		List<Object> objectList = null;
		if (msgObjectList != null) {
			objectList = new ArrayList();
			for (Iterator<Object> itrMsgList = msgObjectList.iterator(); itrMsgList.hasNext();) {
				Object object = ((Object[]) itrMsgList.next())[1];
				objectList.add(object);
			}
		}
		return objectList;
	}
}
