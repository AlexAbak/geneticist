/**
 * 
 */
package org.deneblingvo.geneticist.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;
import org.deneblingvo.geneticist.Geneticist;
import org.deneblingvo.serialization.xml.Reader;

/**
 * @author alex
 *
 */
public class GeneticistTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		File file = new File("../xml/geneticist.xml");
		FileInputStream stream = new FileInputStream(file);
		Reader reader = new Reader();
		Geneticist object = new Geneticist();
		reader.read(stream, object);
		Assert.assertNotNull(object.operators);
		Assert.assertEquals(35, object.operators.size());
		Assert.assertNotNull(object.operators.get(0));
		Assert.assertEquals("assignment", object.operators.get(0).name);
	}

}
