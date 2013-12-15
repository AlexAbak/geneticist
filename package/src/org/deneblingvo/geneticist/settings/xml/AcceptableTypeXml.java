
package org.deneblingvo.geneticist.settings.xml;
					
import org.deneblingvo.geneticist.settings.*;
import org.deneblingvo.serialization.xml.Xpath;
/**
 * Тип расширяемый до указанного
 * @author Алексей Кляузер <drum@pisem.net>
 */
public class AcceptableTypeXml implements AcceptableType {
					
	/**
	 * Уникальное имя типа
	 */
	@Xpath(path = "@name", value = true)
	public String name;
					
	/**
	 * Уникальное имя типа
	 */
	public String getName() {
		return this.name;
	}
					
}
				