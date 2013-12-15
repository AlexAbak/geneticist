
package org.deneblingvo.geneticist.settings.xml;
					
import org.deneblingvo.geneticist.settings.*;
/**
 * Требования
 * @author Алексей Кляузер <drum@pisem.net>
 */
public class RequirementXml implements Requirement {
					
	/**
	 * Тип используемый Генетиком
	 */
	public String getType();
					
	/**
	 * Доступность на чтение
	 */
	public Boolean getIsRead();
					
	/**
	 * Доступность на запись
	 */
	public Boolean getIsWrite();
					
	/**
	 * Ссылка на параметр
	 */
	public String getRef();
					
}
				