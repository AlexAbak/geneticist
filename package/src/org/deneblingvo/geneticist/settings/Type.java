package org.deneblingvo.geneticist.settings;

/**
 * @author Алексей Кляузер <drum@pisem.net> 
 * Тип используемый Генетиком
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