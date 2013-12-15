
package org.deneblingvo.geneticist.settings.xml;
					
import java.util.Vector;
					
import org.deneblingvo.geneticist.settings.*;
/**
 * Список типов расширяемых до указанного
 * @author Алексей Кляузер <drum@pisem.net>
 */
public class AcceptableTypesXml implements AcceptableTypes {
	
	public Vector<AcceptableType> acceptableType;
					
	/**
	 * Тип расширяемый до указанного
	 */
	public Vector<AcceptableType> getAcceptableType() {
		return this.acceptableType;
	}
					
}
				