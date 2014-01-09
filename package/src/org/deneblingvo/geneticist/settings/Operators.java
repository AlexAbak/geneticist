package org.deneblingvo.geneticist.settings;

/**
 * @author Алексей Кляузер <drum@pisem.net> 
 * Список операторов которые могут использоваться Генетиком
 */

import java.util.Vector;

public interface Operators {

	/**
	 * Оператор используемый Генетиком
	 */
	public Vector<Operator> getOperator();


}