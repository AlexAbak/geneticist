
package org.deneblingvo.geneticist.settings.xml;
					
import org.deneblingvo.geneticist.settings.*;
import org.deneblingvo.serialization.xml.Xpath;
/**
 * Корневой элемент настроек Генетика
 * @author Алексей Кляузер <drum@pisem.net>
 */
public class GeneticistXml implements Geneticist {
					
	/**
	 * Список типов которые могут использоваться Генетиком
	 */
	@Xpath(path = "gen:types", namespaces = {"gen", "http://deneblingvo.org/xsd/geneticist/1.0"})
	public TypesXml types;
					
	/**
	 * Список операторов которые могут использоваться Генетиком
	 */
	@Xpath(path = "gen:operators", namespaces = {"gen", "http://deneblingvo.org/xsd/geneticist/1.0"})
	public OperatorsXml operators;
					
	/**
	 * Список типов которые могут использоваться Генетиком
	 */
	public Types getTypes() {
		return this.types;
	}
					
	/**
	 * Список операторов которые могут использоваться Генетиком
	 */
	public Operators getOperators() {
		return this.operators;
	}
					
}
				