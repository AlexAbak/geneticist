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
public class Connection {

	@Xpath(path = "gen:type", namespaces = {"gen", "http://deneblingvo.org/xsd/geneticist/1.0"})
	public Type type;

	@Xpath(path = "gen:types/gen:type", itemClass = Type.class, namespaces = {"gen", "http://deneblingvo.org/xsd/geneticist/1.0"})
	public Vector<Type> types;

	public boolean hasType(String kind) {
		for (Type type : this.types) {
			if (kind.equals(type.kind)) {
				return true;
			}
		}
		return false;
	}
}
