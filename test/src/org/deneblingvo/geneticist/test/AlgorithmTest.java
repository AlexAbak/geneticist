package org.deneblingvo.geneticist.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import org.deneblingvo.geneticist.Operator;
import org.deneblingvo.geneticist.Algorithm;
import org.deneblingvo.geneticist.Type;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author alex
 *
 */
public class AlgorithmTest {

	private GeneticistMock geneticistMock;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.geneticistMock = new GeneticistMock(true);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test1() {
		Operator v1 = Algorithm.getIntegerInput(1);
		Operator v2 = Algorithm.getIntegerInput(2);
		Operator v3 = Algorithm.getIntegerInput(3);
		Algorithm a1 = Algorithm.getOperator(v1);
		Algorithm a2 = Algorithm.getOperator(v2);
		Algorithm a3 = Algorithm.getOperator(v3);
		Algorithm addition = Algorithm.getOperator(this.geneticistMock.getGeneticist().operators.get(17));
		addition.operands.add(a1);
		addition.operands.add(a2);
		Algorithm assignment = Algorithm.getOperator(this.geneticistMock.getGeneticist().operators.get(0));
		assignment.operator = this.geneticistMock.getGeneticist().operators.get(0);
		assignment.operands = new Vector<Algorithm>();
		assignment.operands.add(addition);
		assignment.operands.add(a3);
		Assert.assertNotNull(addition);
		String userDir = System.getProperty("user.dir");
		File userDirFile = new File(userDir).getAbsoluteFile();
		File sourceDirFile = new File(userDirFile, "../source").getAbsoluteFile();
		assignment.asJava(sourceDirFile, "template.java", "org.deneblingvo.geneticist.test.AlgorithmTestAdd");
		assignment.asClass(sourceDirFile, "template.java", "org.deneblingvo.geneticist.test.AlgorithmTestAdd");
		Object obj = assignment.asObject(sourceDirFile, "template.java", "org.deneblingvo.geneticist.test.AlgorithmTestAdd");
		Assert.assertNotNull(obj);
	}

	@Test
	public void test2() {
		try {
			Operator v1 = Algorithm.getIntegerInput(1);
			Operator v2 = Algorithm.getIntegerInput(2);
			Operator v3 = Algorithm.getIntegerInput(3);
			Operator bTrue = Algorithm.getConst("true", "boolean");
			Operator bFalse = Algorithm.getConst("false", "boolean");
			this.geneticistMock.getGeneticist().operators.add(v1);
			this.geneticistMock.getGeneticist().operators.add(v2);
			this.geneticistMock.getGeneticist().operators.add(v3);
			this.geneticistMock.getGeneticist().operators.add(bTrue);
			this.geneticistMock.getGeneticist().operators.add(bFalse);
			Type type = new Type();
			type.kind = "void";
			type.var = false;
			type.ref = "";
			Algorithm a = Algorithm.randomAlgorithmCount(this.geneticistMock.getGeneticist(), type, 0, 10);
			Assert.assertNotNull(a);
			String userDir = System.getProperty("user.dir");
			File userDirFile = new File(userDir).getCanonicalFile();
			File sourceDirFile = new File(userDirFile, "../source").getCanonicalFile();
			Object obj = a.asObject(sourceDirFile, "template.java", "org.deneblingvo.geneticist.test.AlgorithmTest1");
			Assert.assertNotNull(obj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}