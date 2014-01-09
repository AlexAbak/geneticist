package org.deneblingvo.geneticist.settings;

/**
 * @author Алексей Кляузер <drum@pisem.net> 
 * Список типов расширяемых до указанного
 */

import java.util.Vector;

public interface AcceptableTypes {

	/**
	 * Тип расширяемый до указанного
	 */
	public Vector<AcceptableType> getAcceptableType();


}