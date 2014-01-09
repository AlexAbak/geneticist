package org.deneblingvo.geneticist.settings;

/**
 * @author Алексей Кляузер <drum@pisem.net> 
 * Корневой элемент настроек Генетика
 */

public interface Geneticist {

	/**
	 * Список типов которые могут использоваться Генетиком
	 */
	public Types getTypes();

	/**
	 * Список операторов которые могут использоваться Генетиком
	 */
	public Operators getOperators();


}