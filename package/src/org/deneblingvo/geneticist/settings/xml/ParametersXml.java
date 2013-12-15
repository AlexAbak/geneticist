
package org.deneblingvo.geneticist.settings.xml;
					
import java.util.Vector;
					
import org.deneblingvo.geneticist.settings.*;
import org.deneblingvo.serialization.xml.Xpath;
/**
 * Параметры оператора
 * @author Алексей Кляузер <drum@pisem.net>
 */
public class ParametersXml implements Parameters {
					
	/**
	 * Параметр оператора
	 */
	@Xpath(path = "gen:parameter", itemClass = ParameterXml.class, namespaces = {"gen", "http://deneblingvo.org/xsd/geneticist/1.0"})
	public Vector<ParameterXml>  parameter;
					
	/**
	 * Параметр оператора
	 */
	public Vector<Parameter> getParameter() {
		Vector<Parameter> ret = new Vector<Parameter>();
		for (ParameterXml i : this.parameter) {
			ret.add(i);
		}
		return ret;
	}
					
}
				