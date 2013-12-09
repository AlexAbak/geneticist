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
public class Operator {

	@Xpath(path = "@name", value = true)
	public String name;
	
	@Xpath(path = "@output", value = true)
	public String output;
	
	@Xpath(path = "gen:parameters/gen:parameter", itemClass = Parameter.class, namespaces = {"gen", "http://deneblingvo.org/xsd/geneticist/1.0"})
	public Vector<Parameter> parameters;

	@Xpath(path = "gen:format", namespaces = {"gen", "http://deneblingvo.org/xsd/geneticist/1.0"}, value = true)
	public String format;
	
}
