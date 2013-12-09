/**
 * 
 */
package org.deneblingvo.geneticist;

import java.util.Vector;

import org.deneblingvo.serialization.xml.Xpath;

/**
 * @author alex
 *
 */
@Xpath(path = "//gen:geneticist", namespaces = {"gen", "http://deneblingvo.org/xsd/geneticist/1.0"}) 
public class Geneticist {
	
	@Xpath(path = "gen:operators/gen:operator", itemClass = Operator.class, namespaces = {"gen", "http://deneblingvo.org/xsd/geneticist/1.0"})
	public Vector<Operator> operators;

}
