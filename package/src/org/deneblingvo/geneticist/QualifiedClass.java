package org.deneblingvo.geneticist;

import java.io.File;

public class QualifiedClass {

	public File root;

	public String packageName;

	public String className;

	public QualifiedClass (File root, String qualifiedClassName) {
		this.root = root;
		String[] paths = qualifiedClassName.split("\\.");
		this.className = paths[paths.length - 1];
		this.packageName = qualifiedClassName.split("\\." + this.className)[0];
	}

	public File getClassSrcDir() {
		File classSrcDir = new File(this.root, "src");
		String[] paths = this.packageName.split("\\.");
		for (String step : paths) {
			classSrcDir = new File(classSrcDir, step);
		}
		return classSrcDir;
	}

	public File getJavaFile() {
		File javaFile = this.getClassSrcDir();
		javaFile = new File(javaFile, this.className + ".java");
		return javaFile;
	}

}