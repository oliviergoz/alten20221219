/*
 * Copyright Owliance © 2016 - 2017 ,All right reserved <p>Owliance PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.owliance.owlink.framework.translator;


import com.owliance.owlink.framework.entity.BaseBVO;
import com.owliance.owlink.framework.entity.BaseObject;
import com.owliance.owlink.framework.entity.BaseVO;


/**
 * Class base for all TO (Translator Object).
 *
 * @since 0.1.6-Alpha
 * @see BaseObject
 *      <p>
 *      Created : 25 juil 2016
 *      <p>
 *      Updated : 25 juil 2016 by fmartinez (version 0.1.6-Alpha)
 *      <p>
 *      Updated : 22 août 2016 by hbenizid (version 0.2.0-Alpha)
 */
public abstract class BaseTO implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -142558545919671821L;

	/**
	 * Constructor.
	 * <p/>
	 * Created : 25 juil 2016 by fmartinez (version 0.1.6-Alpha)
	 * <p/>
	 * Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	protected BaseTO() {
		super();
	}

	/**
	 * Convert a VO to a BVO.
	 *
	 * @param vo : BaseVO
	 * @param bvo : BaseBVO
	 *           <p>
	 *           Created : 25 juil 2016 by fmartinez (version 0.1.6-Alpha)
	 *           <p>
	 *           Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	public void voToBvo(BaseVO vo, BaseBVO bvo) {

	}

	/**
	 * Convert a BVO to a VO.
	 *
	 * @param bvo : BaseBVO
	 * @param vo : BaseVO
	 *           <p>
	 *           Created : 25 juil 2016 by fmartinez (version 0.1.6-Alpha)
	 *           <p>
	 *           Modifiée le : xx xxxx xxxx par xxxxx (version x.xx)
	 */
	public void bvoToVo(BaseBVO bvo, BaseVO vo) {

	}
}
