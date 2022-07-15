package eu.horasion.basics.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileHandlingDemo
 */
public class FileHandlingDemo {

	static final String FILE_NAME = "filehandlingdemo_output.txt";
	// Even on Windows it's possible to use forward slashes, these are valid:
	// "C:/prg/test.txt"
	// "/prg/test.txt"

	public static void main(String[] args) {
		System.out.printf("New file created? %b\n", initFile());
		System.out.printf("Directory listing:\n--------\n");
		listDirectory(".");
		System.out.printf("\n\nWriting to file...\n");
		dataIntoFile();
	}

	static boolean initFile() {
		try {
			File myObj = new File(FILE_NAME);

			if(myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
				System.out.println("Listing files in current directory:");
				return true;
			}
			else {
				System.out.println("File already exists.");
			}
		}
		catch(IOException e) {
			System.out.printf("An error occurred, reason: %s\n", e.getMessage());
			e.printStackTrace();
		}

		return false;
	}

	static void listDirectory(String path) {
		File pathObj = new File(path);
		String[] files = pathObj.list();

		if(pathObj.exists() && pathObj.isDirectory()) {
			for(String s : files) {
				System.out.println(s);
			}
			return;
		}

		System.out.printf("Cannot list directory, provided path: \"%s\"\n", path);
	}

	static void dataIntoFile() {
		FileWriter myWriter;
		try {
			myWriter = new FileWriter(FILE_NAME, true);
			myWriter.write("A new line with text and 2 newlines.\n\n");
			myWriter.close();
			System.out.printf("Successfully wrote to file %s", FILE_NAME);
		}
		catch(IOException e) {
			System.out.println("An error occurred while writing to file.");
			e.printStackTrace();
		}
	}

}

/*

File created: filehandlingdemo_output.txt
Listing files in current directory:
New file created? true
Directory listing:
--------
.vscode
bin
filehandlingdemo_output.txt
lib
LICENSE
README.md
src


Writing to file...
Successfully wrote to file filehandlingdemo_output.txt

*/
