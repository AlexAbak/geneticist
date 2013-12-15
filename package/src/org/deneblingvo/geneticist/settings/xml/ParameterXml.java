
package org.deneblingvo.geneticist.settings.xml;
					
import org.deneblingvo.geneticist.settings.*;
/**
 * 
 * @author Алексей Кляузер <drum@pisem.net>
 */
public class ParameterXml implements Parameter {
					
	/**
	 * Имя параметра
	 */
	public String getName();
					
	/**
	 * Требования которым должен соответствовать параметр
	 */
	public Requirement getRequirement();
					
}
				