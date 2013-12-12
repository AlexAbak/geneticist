package org.deneblingvo.geneticist.test;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.deneblingvo.geneticist.ModuleLoader;

public class ModuleLoaderTest {
	
	private ModuleLoader moduleLoader; 

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		String userDir = System.getProperty("user.dir");
		File userDirFile = new File(userDir).getCanonicalFile();
		File binDirFile = new File(userDirFile.getPath() + "/../source/bin").getCanonicalFile();
		this.moduleLoader = new ModuleLoader(binDirFile, ClassLoader.getSystemClassLoader());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.moduleLoader = null;
	}

	@Test
	public void test() {
		try {
			Class<?> instanceClass = this.moduleLoader.findClass("org.deneblingvo.geneticist.test.Test");
			Assert.assertNotNull(instanceClass);
			Object instance = instanceClass.newInstance();
			Assert.assertNotNull(instance);
			ITest test = (ITest) instance;
			Assert.assertEquals(4, test.test(2, 2));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
