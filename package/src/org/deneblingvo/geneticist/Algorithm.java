/**
 *
 */
package org.deneblingvo.geneticist;

import java.util.*;

/**
 * @author alex
 *
 */
public class Algorithm
{
	
	public Operator operator;
	
	public Vector<Algorithm> operands;
	
	public String asString() {
		String temp = this.operator.format;
		for (int i = 0; i < this.operator.parameters.size(); i++) {
			Parameter parameter = this.operator.parameters.get(i);
			/*String expression = "{$".concat(parameter.name).concat("}");
			Algorithm operand = this.operands.get(i);
			String value = operand.asString();
			temp = temp.replaceAll(expression, value);*/
		}
		return temp;
	}
}
