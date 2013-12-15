
package org.deneblingvo.geneticist.settings.xml;
					
import org.deneblingvo.geneticist.settings.*;
import org.deneblingvo.serialization.xml.Xpath;
/**
 * Оператор используемый Генетиком
 * @author Алексей Кляузер <drum@pisem.net>
 */
public class OperatorXml implements Operator {
					
	/**
	 * Уникальное имя оператора
	 */
	@Xpath(path = "@name", value = true)
	public String name;
					
	/**
	 * Параметры оператора
	 */
	@Xpath(path = "gen:parameters", namespaces = {"gen", "http://deneblingvo.org/xsd/geneticist/1.0"})
	public ParametersXml parameters;
					
	/**
	 * Требования которым удовлетворяет оператор
	 */
	@Xpath(path = "gen:requirement", namespaces = {"gen", "http://deneblingvo.org/xsd/geneticist/1.0"})
	public RequirementXml requirement;
					
	/**
	 * Шаблон текста оператора
	 */
	@Xpath(path = "gen:template", namespaces = {"gen", "http://deneblingvo.org/xsd/geneticist/1.0"})
	public String template;
					
	/**
	 * Уникальное имя оператора
	 */
	public String getName() {
		return this.name;
	}
					
	/**
	 * Параметры оператора
	 */
	public Parameters getParameters() {
		return this.parameters;
	}
					
	/**
	 * Требования которым удовлетворяет оператор
	 */
	public Requirement getRequirement() {
		return this.requirement;
	}
					
	/**
	 * Шаблон текста оператора
	 */
	public String getTemplate() {
		return this.template;
	}
					
}
				