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
	
	@Xpath(path = "@type", value = true)
	public String type;
	
	@Xpath(path = "@ref", value = true)
	public String ref;

	@Xpath(path = "@isVar", value = true)
	public boolean isVar;

}
