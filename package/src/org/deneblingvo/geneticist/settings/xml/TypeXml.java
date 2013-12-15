
package org.deneblingvo.geneticist.settings.xml;
					
import org.deneblingvo.geneticist.settings.*;
/**
 * Тип используемый Генетиком
 * @author Алексей Кляузер <drum@pisem.net>
 */
public class TypeXml implements Type {
					
	/**
	 * Уникальное имя типа
	 */
	public String getName();
					
	/**
	 * Список типов расширяемых до указанного
	 */
	public AcceptableTypes getAcceptableTypes();
					
}
				