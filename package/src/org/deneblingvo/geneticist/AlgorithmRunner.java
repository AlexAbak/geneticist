/**
 * 
 */
package org.deneblingvo.geneticist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;

/**
 * @author alex
 *
 */
public class AlgorithmRunner {

	private Algorithm algorithm;

	public AlgorithmRunner (Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	public void saveToStream(OutputStream outputStream) {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(this.algorithm);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveToFile(File file) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			this.saveToStream(fileOutputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
