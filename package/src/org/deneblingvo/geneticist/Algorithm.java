/**
 *
 */
package org.deneblingvo.geneticist;

import java.io.*;
import java.util.*;
/**
 * @author alex
 *
 */
public class Algorithm
{

	public static Operator getConst(String name, String type) {
		Operator operator = new Operator();
		operator.name = name;
		operator.output = new Type();
		operator.output.kind = type;
		operator.output.var = false;
		operator.output.ref = "";
		operator.parameters = new Vector<Parameter>();
		operator.format = name;
		return operator;
	}

	public static Operator getInput(String name, String type) {
		Operator operator = new Operator();
		operator.name = name;
		operator.output = new Type();
		operator.output.kind = type;
		operator.output.var = true;
		operator.output.ref = "";
		operator.parameters = new Vector<Parameter>();
		operator.format = name;
		return operator;
	}

	public static Operator getNumInput(int number, String type) {
		return getInput("v" + number, type);
	}

	public static Operator getIntegerInput(int number) {
		return getNumInput(number, "integer");
	}

	public static Algorithm getOperator(Operator operator) {
		Algorithm algorithm = new Algorithm();
		algorithm.operator = operator;
		algorithm.operands = new Vector<Algorithm>();
		return algorithm;
	}

	public static boolean isOperatorType(Geneticist geneticist, Type expected, Type found) {
		if (expected.var && (!found.var)) {
			return false;
		}
		Connection connection = geneticist.findConnection(expected.kind);
		if (connection == null) {
			System.out.println(expected.kind);
		}
		return connection.hasType(found.kind);
	}

	public static Algorithm randomAlgorithmCount(Geneticist geneticist, Type type, int deep, int count) {
		for (int i = 0; i < count; i++) {
			Algorithm algorithm = randomAlgorithm(geneticist, type, deep);
			if (algorithm != null) {
				return algorithm;
			}
		}
		return null;
	}

	public Type unlinkRef(Type type) {
		if (type.kind.equals("ref")) {
			type = type.clone();
			for (int i = 0; i < this.operator.parameters.size(); i++) {
				Parameter parameter = this.operator.parameters.get(i);
				if (type.ref.equals(parameter.name)) {
					Algorithm operand = this.operands.get(i);
					type.kind = operand.operator.output.kind;
					type.ref = "";
					return type;
				}
			}
			return null;
		} else {
			return type.clone();
		}
	}
	
	public static Algorithm randomAlgorithm(Geneticist geneticist, Type type, int deep) {
		if (deep > 10) {
			return null;
		}
		Vector<Operator> typeOperators = new Vector<Operator>();
		for (Operator operator : geneticist.operators) {
			if (isOperatorType(geneticist, type, operator.output)) {
				typeOperators.add(operator);
			}
		}
		if (typeOperators.size() > 0) {
			Random random = new Random();
			int i = random.nextInt(typeOperators.size());
			Operator operator = typeOperators.get(i);
			Algorithm algorithm = getOperator(operator);
			for (Parameter parameter : algorithm.operator.parameters) {
				Type parameterType = algorithm.unlinkRef(parameter.type);				
				if (parameterType == null) {
					return null;
				}
				Algorithm operand = randomAlgorithmCount(geneticist, parameterType, deep + 1, 10);
				if (operand == null) {
					return null;
				}
				algorithm.operands.add(operand);
			}
			return algorithm;
		} else {
			return null;
		}
	}

	public Operator operator;

	public Vector<Algorithm> operands;

	public String asString() {
		String temp = this.operator.format;
		for (int i = 0; i < this.operator.parameters.size(); i++) {
			Parameter parameter = this.operator.parameters.get(i);
			String expression = "{$".concat(parameter.name).concat("}");
			Algorithm operand = this.operands.get(i);
			String value = operand.asString();
			temp = temp.replace(expression, value);
		}
		return temp;
	}

	public String FileToString(File file) {
		String s = "";
		InputStreamReader isr = null;
		try {
			File f = new File(file.getCanonicalPath());
			final int length = (int) f.length();
			if (length != 0) {
				char[] cbuf = new char[length];
				isr = new InputStreamReader(new FileInputStream(f), "UTF-8");
				final int read = isr.read(cbuf);
				s = new String(cbuf, 0, read);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return s;
	}

	public void StringToFile(File file, String source) {
		FileWriter writeFile = null;
		try {
			File destFile = new File(file.getCanonicalPath());	
			writeFile = new FileWriter(destFile);
			writeFile.write(source);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(writeFile != null) {
				try {
					writeFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void asJava(File rootDir, String template, String qualifiedClassName) {
		File templateFile = new File(rootDir, template);
		String s = FileToString(templateFile);
		QualifiedClass qualifiedClass = new QualifiedClass(rootDir, qualifiedClassName); 
		s = s.replace("{$package}", qualifiedClass.packageName);
		s = s.replace("{$class}", qualifiedClass.className);
		s = s.replace("{$code}", this.asString());
		File classSrcDir = qualifiedClass.getClassSrcDir();
		classSrcDir.mkdirs();
		File javaFile = qualifiedClass.getJavaFile();
		StringToFile(javaFile, s);
	}

	public void asClass(File rootDir, String template, String qualifiedClassName) {
		this.asJava(rootDir, template, qualifiedClassName);
		try {
			QualifiedClass qualifiedClass = new QualifiedClass(rootDir, qualifiedClassName); 
			File binDir = new File(rootDir.getCanonicalPath(), "bin");
			File srcDir = new File(rootDir.getCanonicalPath(), "src");
			binDir.mkdirs();
			File javaFile = qualifiedClass.getJavaFile();
			ProcessBuilder procBuilder = new ProcessBuilder("javac", "-classpath", srcDir.getPath(), "-d", binDir.getPath(), javaFile.getPath());
			procBuilder.directory(rootDir);
			procBuilder.redirectErrorStream(true);
			Process process = procBuilder.start();
			InputStream stdout = process.getInputStream();
			InputStreamReader isrStdout = new InputStreamReader(stdout);
			BufferedReader brStdout = new BufferedReader(isrStdout);
			String line = null;
			while((line = brStdout.readLine()) != null) {
				System.out.println(line);
			}
			process.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Object asObject(File rootDir, String template, String qualifiedClassName) {
		this.asClass(rootDir, template, qualifiedClassName);
		File binDirFile = new File(rootDir, "bin");
		ModuleLoader moduleLoader = new ModuleLoader(binDirFile, ClassLoader.getSystemClassLoader());
		Object instance = null;
		try {
			Class<?> insstanceClass = moduleLoader.loadClass(qualifiedClassName);
			instance = insstanceClass.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return instance;
	}

}