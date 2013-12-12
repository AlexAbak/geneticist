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
		if (deep > 20) {
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

	public String FileToString(String fileName) {
		String s = "";
		InputStreamReader isr = null;
		try {
			File f = new File(fileName);
			f = new File(f.getAbsolutePath());
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

	public void StringToFile(String fileName, String source) {
		FileWriter writeFile = null;
		try {
			File logFile = new File(fileName);
			logFile = new File(logFile.getAbsolutePath());	
			writeFile = new FileWriter(logFile);
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

	public void asJava(String number, String template, String result) {
		String s = FileToString(template);
		s = s.replace("{$number}", number);
		s = s.replace("{$code}", this.asString());
		StringToFile(result, s);
	}

	public void asClass(String number, String template, String result) {
		this.asJava(number, template, result);
		try {
			File source_dir = new File(System.getProperty("user.dir"));
			File bin_dir = new File(source_dir.getAbsolutePath() + "/bin");
			bin_dir.mkdir();
			ProcessBuilder procBuilder = new ProcessBuilder("javac", "-classpath", "src", "-d", "bin", result);
			procBuilder.directory(source_dir);
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

	public Object asObject(String number, String template, String result) {
		//this.asClass(number, template, result);
		File sourceDir = new File(System.getProperty("user.dir"));
		File binDir = new File(sourceDir.getAbsolutePath() + "/bin");
		File resultFile = new File(sourceDir.getAbsolutePath() + "/" + result);
		//String modulePath = binDir.getAbsolutePath();
		String modulePath = resultFile.getParent().replace("src", "bin") + "/";
		String module = resultFile.getName();
		String moduleName = module.split(".java")[0];
		ModuleLoader loader = new ModuleLoader(modulePath, ClassLoader.getSystemClassLoader());
		Object instance = null;
		try {
			loader.loadClass("AlgorithmTest");
			Class<?> clazz = loader.loadClass(moduleName);
			instance = clazz.newInstance();
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