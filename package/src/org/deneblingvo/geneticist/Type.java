/**
 * 
 */
package org.deneblingvo.geneticist;

import org.deneblingvo.serialization.xml.Xpath;

/**
 * @author alex
 *
 */
public class Type {

	@Xpath(path = "@kind", value = true)
	public String kind;

	@Xpath(path = "@var", value = true)
	public boolean var;

	@Xpath(path = "@ref", value = true)
	public String ref;

	public Type clone() {
		Type type = new Type();
		type.kind = this.kind;
		type.var = this.var;
		type.ref = this.ref;
		return type;
	}

}
