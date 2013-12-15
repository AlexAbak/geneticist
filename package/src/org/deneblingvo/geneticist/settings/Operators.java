
package org.deneblingvo.geneticist.settings;
					
import java.util.Vector;
					
/**
 * Список операторов которые могут использоваться Генетиком
 * @author Алексей Кляузер <drum@pisem.net>
 */
public interface Operators {
					
	/**
	 * Оператор используемый Генетиком
	 */
	public Vector<Operator> getOperator();
					
}
				