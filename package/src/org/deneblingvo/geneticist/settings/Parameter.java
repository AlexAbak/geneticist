
package org.deneblingvo.geneticist.settings;
					
/**
 * 
 * @author Алексей Кляузер <drum@pisem.net>
 */
public interface Parameter {
					
	/**
	 * Имя параметра
	 */
	public String getName();
					
	/**
	 * Требования которым должен соответствовать параметр
	 */
	public Requirement getRequirement();
					
}
				