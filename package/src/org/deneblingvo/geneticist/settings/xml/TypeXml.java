
package org.deneblingvo.geneticist.settings.xml;
					
import org.deneblingvo.geneticist.settings.*;
import org.deneblingvo.serialization.xml.Xpath;
/**
 * Тип используемый Генетиком
 * @author Алексей Кляузер <drum@pisem.net>
 */
public class TypeXml implements Type {
					
	/**
	 * Уникальное имя типа
	 */
	@Xpath(path = "@name", value = true)
	public String name;
					
	/**
	 * Список типов расширяемых до указанного
	 */
	@Xpath(path = "gen:acceptableTypes", namespaces = {"gen", "http://deneblingvo.org/xsd/geneticist/1.0"})
	public AcceptableTypesXml acceptableTypes;
					
	/**
	 * Уникальное имя типа
	 */
	public String getName() {
		return this.name;
	}
					
	/**
	 * Список типов расширяемых до указанного
	 */
	public AcceptableTypes getAcceptableTypes() {
		return this.acceptableTypes;
	}
					
}
				