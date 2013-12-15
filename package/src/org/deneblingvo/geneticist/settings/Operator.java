
package org.deneblingvo.geneticist.settings;
					
/**
 * Оператор используемый Генетиком
 * @author Алексей Кляузер <drum@pisem.net>
 */
public interface Operator {
					
	/**
	 * Уникальное имя оператора
	 */
	public String getName();
					
	/**
	 * Параметры оператора
	 */
	public Parameters getParameters();
					
	/**
	 * Требования которым удовлетворяет оператор
	 */
	public Requirement getRequirement();
					
	/**
	 * Шаблон текста оператора
	 */
	public String getTemplate();
					
}
				