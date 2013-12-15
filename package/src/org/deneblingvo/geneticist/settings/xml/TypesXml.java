
package org.deneblingvo.geneticist.settings.xml;
					
import java.util.Vector;
					
import org.deneblingvo.geneticist.settings.*;
import org.deneblingvo.serialization.xml.Xpath;
/**
 * Список типов которые могут использоваться Генетиком
 * @author Алексей Кляузер <drum@pisem.net>
 */
public class TypesXml implements Types {
					
	/**
	 * Тип используемый Генетиком
	 */
	@Xpath(path = "gen:type", itemClass = TypeXml.class, namespaces = {"gen", "http://deneblingvo.org/xsd/geneticist/1.0"})
	public Vector<TypeXml>  type;
					
	/**
	 * Тип используемый Генетиком
	 */
	public Vector<Type> getType() {
		Vector<Type> ret = new Vector<Type>();
		for (TypeXml i : this.type) {
			ret.add(i);
		}
		return ret;
	}
					
}
				