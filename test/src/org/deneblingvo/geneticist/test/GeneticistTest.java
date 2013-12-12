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

import org.deneblingvo.geneticist.Algorithm;
import org.deneblingvo.geneticist.Geneticist;
import org.deneblingvo.geneticist.Operator;
import org.deneblingvo.geneticist.Type;
import org.deneblingvo.serialization.xml.Reader;

import net.sf.saxon.xpath.XPathFactoryImpl;

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
		File source_dir = new File(System.getProperty("user.dir"));
		source_dir = new File(source_dir.getParent() + "/source");
		String absolutePath = source_dir.getAbsolutePath();
		System.setProperty("user.dir", absolutePath);
		File file = new File("../xml/geneticist.xml");
		FileInputStream stream = new FileInputStream(file);
		Reader reader = new Reader(new XPathFactoryImpl());
		Geneticist object = new Geneticist();
		reader.read(stream, object);
		Assert.assertNotNull(object.operators);
		Assert.assertEquals(35, object.operators.size());
		Assert.assertNotNull(object.operators.get(0));
		Assert.assertEquals("assignment", object.operators.get(0).name);
		Assert.assertEquals("void", object.operators.get(0).output.kind);
		Operator v1 = Algorithm.getIntegerInput(1);
		Operator v2 = Algorithm.getIntegerInput(2);
		Operator v3 = Algorithm.getIntegerInput(3);
		Operator bTrue = Algorithm.getConst("true", "boolean");
		Operator bFalse = Algorithm.getConst("false", "boolean");
		object.operators.add(v1);
		object.operators.add(v2);
		object.operators.add(v3);
		object.operators.add(bTrue);
		object.operators.add(bFalse);
		Type type = new Type();
		type.kind = "void";
		type.var = false;
		type.ref = "";
		Algorithm a = Algorithm.randomAlgorithmCount(object, type, 0, 10);
		if (a != null) {
			System.out.println("ok");
			Object obj = a.asObject("1", "template.java", "src/org/deneblingvo/geneticist/test/AlgorithmTest1.java");
		} else {
			System.out.println("null");
		}
	}

	public void test(int v1, int v2) {

	}
}
