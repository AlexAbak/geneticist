
package org.deneblingvo.geneticist.settings.xml;
					
import java.util.Vector;
					
import org.deneblingvo.geneticist.settings.*;
import org.deneblingvo.serialization.xml.Xpath;
/**
 * Список операторов которые могут использоваться Генетиком
 * @author Алексей Кляузер <drum@pisem.net>
 */
public class OperatorsXml implements Operators {
					
	/**
	 * Оператор используемый Генетиком
	 */
	@Xpath(path = "gen:operator", itemClass = OperatorXml.class, namespaces = {"gen", "http://deneblingvo.org/xsd/geneticist/1.0"})
	public Vector<OperatorXml>  operator;
					
	/**
	 * Оператор используемый Генетиком
	 */
	public Vector<Operator> getOperator() {
		Vector<Operator> ret = new Vector<Operator>();
		for (OperatorXml i : this.operator) {
			ret.add(i);
		}
		return ret;
	}
					
}
				