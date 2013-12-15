
package org.deneblingvo.geneticist.settings.xml;
					
import org.deneblingvo.geneticist.settings.*;
import org.deneblingvo.serialization.xml.Xpath;
/**
 * Требования
 * @author Алексей Кляузер <drum@pisem.net>
 */
public class RequirementXml implements Requirement {
					
	/**
	 * Тип используемый Генетиком
	 */
	@Xpath(path = "@type", value = true)
	public String type;
					
	/**
	 * Доступность на чтение
	 */
	@Xpath(path = "@isRead", value = true)
	public boolean isRead;
					
	/**
	 * Доступность на запись
	 */
	@Xpath(path = "@isWrite", value = true)
	public boolean isWrite;
					
	/**
	 * Ссылка на параметр
	 */
	@Xpath(path = "@ref", value = true)
	public String ref;
					
	/**
	 * Тип используемый Генетиком
	 */
	public String getType() {
		return this.type;
	}
					
	/**
	 * Доступность на чтение
	 */
	public boolean getIsRead() {
		return this.isRead;
	}
					
	/**
	 * Доступность на запись
	 */
	public boolean getIsWrite() {
		return this.isWrite;
	}
					
	/**
	 * Ссылка на параметр
	 */
	public String getRef() {
		return this.ref;
	}
					
}
				