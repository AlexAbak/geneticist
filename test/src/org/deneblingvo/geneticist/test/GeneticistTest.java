/**
 * 
 */
package org.deneblingvo.geneticist.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import net.sf.saxon.xpath.XPathFactoryImpl;

/**
 * @author alex
 *
 */
public class GeneticistTest {

	private FileInputStream stream;

	private Reader reader;

	private Geneticist geneticist;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		File file = new File("../xml/geneticist.xml");
		this.stream = new FileInputStream(file);
		this.reader = new Reader(new XPathFactoryImpl());
		this.geneticist = new Geneticist();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.stream.close();
	}

	@Test
	public void test() {
		try {
			reader.read(this.stream, this.geneticist);
			Assert.assertNotNull(geneticist.operators);
			Assert.assertEquals(35, geneticist.operators.size());
			Assert.assertNotNull(geneticist.operators.get(0));
			Assert.assertEquals("assignment", geneticist.operators.get(0).name);
			Assert.assertEquals("void", geneticist.operators.get(0).output.kind);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
