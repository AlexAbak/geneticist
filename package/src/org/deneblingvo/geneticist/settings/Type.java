
package org.deneblingvo.geneticist.settings;
					
/**
 * Тип используемый Генетиком
 * @author Алексей Кляузер <drum@pisem.net>
 */
public interface Type {
					
	/**
	 * Уникальное имя типа
	 */
	public String getName();
					
	/**
	 * Список типов расширяемых до указанного
	 */
	public AcceptableTypes getAcceptableTypes();
					
}
				