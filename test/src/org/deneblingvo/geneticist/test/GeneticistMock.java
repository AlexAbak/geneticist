package org.deneblingvo.geneticist.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import net.sf.saxon.xpath.XPathFactoryImpl;

import org.deneblingvo.geneticist.Geneticist;
import org.deneblingvo.serialization.xml.Reader;
import org.xml.sax.SAXException;

public class GeneticistMock {

	private InputStream inputStream;

	private Reader reader;

	private Geneticist geneticist;

	public InputStream getInputStream () {
		return this.inputStream;
	}

	public Reader getReader () {
		return this.reader;
	}

	public Geneticist getGeneticist () {
		return this.geneticist;
	}

	public GeneticistMock () {
		try {
			File file = new File("../xml/geneticist.xml");
			this.inputStream = new FileInputStream(file);
			this.reader = new Reader(new XPathFactoryImpl());
			this.geneticist = new Geneticist();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public GeneticistMock (boolean isRead) {
		try {
			File file = new File("../xml/geneticist.xml");
			this.inputStream = new FileInputStream(file);
			this.reader = new Reader(new XPathFactoryImpl());
			this.geneticist = new Geneticist();
			this.reader.read(this.inputStream, this.geneticist);
			this.inputStream.close();
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