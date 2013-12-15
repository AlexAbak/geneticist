
package org.deneblingvo.geneticist.settings.xml;
					
import org.deneblingvo.geneticist.settings.*;
import org.deneblingvo.serialization.xml.Xpath;
/**
 * 
 * @author Алексей Кляузер <drum@pisem.net>
 */
public class ParameterXml implements Parameter {
					
	/**
	 * Имя параметра
	 */
	@Xpath(path = "@name", value = true)
	public String name;
					
	/**
	 * Требования которым должен соответствовать параметр
	 */
	@Xpath(path = "gen:requirement", namespaces = {"gen", "http://deneblingvo.org/xsd/geneticist/1.0"})
	public RequirementXml requirement;
					
	/**
	 * Имя параметра
	 */
	public String getName() {
		return this.name;
	}
					
	/**
	 * Требования которым должен соответствовать параметр
	 */
	public Requirement getRequirement() {
		return this.requirement;
	}
					
}
				