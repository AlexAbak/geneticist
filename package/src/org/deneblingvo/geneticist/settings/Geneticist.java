
package org.deneblingvo.geneticist.settings;
					
/**
 * Корневой элемент настроек Генетика
 * @author Алексей Кляузер <drum@pisem.net>
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
				