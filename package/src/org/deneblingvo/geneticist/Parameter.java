/**
 * 
 */
package org.deneblingvo.geneticist;

import org.deneblingvo.serialization.xml.Xpath;

/**
 * @author alex
 *
 */
public class Parameter {

	@Xpath(path = "@name", value = true)
	public String name;

	@Xpath(path = "gen:type", namespaces = {"gen", "http://deneblingvo.org/xsd/geneticist/1.0"})
	public Type type;

}
