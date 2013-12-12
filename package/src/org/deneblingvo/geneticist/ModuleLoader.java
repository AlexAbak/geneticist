/**
 * 
 */
package org.deneblingvo.geneticist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author alex
 *
 */
public class ModuleLoader extends ClassLoader {
	 
	/**
	 * Путь до директории с модулями.
	 */
	private File path;
	  
	public ModuleLoader(File path, ClassLoader parent) {
		super(parent);    
		this.path = path;    
	}

	@Override
	public Class<?> findClass(String className) throws ClassNotFoundException {
		try {
			String[] subPaths = className.split("\\.");
			String path = this.path.getAbsolutePath();
			for (String step : subPaths) {
				path = path + "/" + step;
			}
			path = path + ".class";
			byte b[] = fetchClassFromFS(path);
			return defineClass(className, b, 0, b.length);
	    } catch (FileNotFoundException ex) {
	      return super.findClass(className);
	    } catch (IOException ex) {
	      return super.findClass(className);
	    }
	    
	  }
	  
	  /**
	   * Взято из www.java-tips.org/java-se-tips/java.io/reading-a-file-into-a-byte-array.html
	   */
	  private byte[] fetchClassFromFS(String path) throws FileNotFoundException, IOException {
	    InputStream is = new FileInputStream(new File(path));
	    
	    // Get the size of the file
	    long length = new File(path).length();
	  
	    if (length > Integer.MAX_VALUE) {
	      // File is too large
	    }
	  
	    // Create the byte array to hold the data
	    byte[] bytes = new byte[(int)length];
	  
	    // Read in the bytes
	    int offset = 0;
	    int numRead = 0;
	    while (offset < bytes.length
	        && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	      offset += numRead;
	    }
	  
	    // Ensure all the bytes have been read in
	    if (offset < bytes.length) {
	      throwIOException(path);
	    }
	  
	    // Close the input stream and return bytes
	    is.close();
	    return bytes;

	  }

	private void throwIOException(String path) throws IOException {
		throw new IOException("Could not completely read file "+path);
	}
}
