/**
 * 
 */
package org.deneblingvo.geneticist;

import java.io.Serializable;
import java.util.Vector;

import org.deneblingvo.serialization.xml.Xpath;

/**
 * @author alex
 *
 */
@Xpath(path = "//gen:geneticist", namespaces = {"gen", "http://deneblingvo.org/xsd/geneticist/1.0"}) 
public class Geneticist implements Serializable {
	
	private static final long serialVersionUID = -198870368451458463L;

	@Xpath(path = "gen:operators/gen:operator", itemClass = Operator.class, namespaces = {"gen", "http://deneblingvo.org/xsd/geneticist/1.0"})
	public Vector<Operator> operators;

	@Xpath(path = "gen:connections/gen:connection", itemClass = Connection.class, namespaces = {"gen", "http://deneblingvo.org/xsd/geneticist/1.0"})
	public Vector<Connection> connections;

	public Connection findConnection (String kind) {
		for (Connection connection : this.connections) {
			if (kind.equals(connection.type.kind)) {
				return connection;
			}
		}
		return null;
	}

}
