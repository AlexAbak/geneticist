
package org.deneblingvo.geneticist.settings.xml;
					
import java.util.Vector;
					
import org.deneblingvo.geneticist.settings.*;
import org.deneblingvo.serialization.xml.Xpath;
/**
 * Список типов расширяемых до указанного
 * @author Алексей Кляузер <drum@pisem.net>
 */
public class AcceptableTypesXml implements AcceptableTypes {
					
	/**
	 * Тип расширяемый до указанного
	 */
	@Xpath(path = "gen:acceptableType", itemClass = AcceptableTypeXml.class, namespaces = {"gen", "http://deneblingvo.org/xsd/geneticist/1.0"})
	public Vector<AcceptableTypeXml>  acceptableType;
					
	/**
	 * Тип расширяемый до указанного
	 */
	public Vector<AcceptableType> getAcceptableType() {
		Vector<AcceptableType> ret = new Vector<AcceptableType>();
		for (AcceptableTypeXml i : this.acceptableType) {
			ret.add(i);
		}
		return ret;
	}
					
}
				