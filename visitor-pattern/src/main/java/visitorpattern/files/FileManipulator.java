package visitorpattern.files;

import java.io.IOException;

import visitorpattern.visitor.Visitor;

public interface FileManipulator {
	void fileWriter(String fileInputPath, String fileOutputPath) throws IOException;
	String fileReader(String fileInputPath) throws IOException;
	String accept(Visitor visitor) throws IOException;
}
