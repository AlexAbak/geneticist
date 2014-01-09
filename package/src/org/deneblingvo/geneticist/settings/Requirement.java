package org.deneblingvo.geneticist.settings;

/**
 * @author Алексей Кляузер <drum@pisem.net> 
 * Требования
 */

public interface Requirement {

	/**
	 * Тип используемый Генетиком
	 */
	public String getType();

	/**
	 * Доступность на чтение
	 */
	public boolean getIsRead();

	/**
	 * Доступность на запись
	 */
	public boolean getIsWrite();

	/**
	 * Ссылка на параметр
	 */
	public String getRef();


}