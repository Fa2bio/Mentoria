package visitorpattern.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import visitorpattern.visitor.Visitor;

public class FileTxt implements FileManipulator{

	private String fileInputPath;
	private String fileOutPath;
	
	public FileTxt(String fileInputPath, String fileOutPath) {
		this.fileInputPath = fileInputPath;
		this.fileOutPath = fileOutPath;
	}

	@Override
	public void fileWriter(String fileInputPath, String fileOutputPath) throws IOException{
		
		try {
			FileWriter file = new FileWriter(fileOutputPath, true);
			PrintWriter writerFile = new PrintWriter(file);
			
			String characs = fileReader(fileInputPath);	
			writerFile.println(characs);	
			
			file.close();
			writerFile.close();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public String fileReader(String fileInputPath) throws IOException{
		StringBuilder sb = new StringBuilder();
		
		try {
			FileReader file = new FileReader(fileInputPath);
			BufferedReader fileReader = new BufferedReader(file);
			
			String line;
			while((line = fileReader.readLine()) != null) {
				sb.append(line);
			}
			
			file.close();
			fileReader.close();
			return sb.toString();
		} catch (IOException e) {
			throw e;
		}
	}

	@Override
	public String accept(Visitor visitor) throws IOException{
		return visitor.visit(this);
	}
	
	public String getFileInputPath() {
		return fileInputPath;
	}

	public void setFileInputPath(String fileInputPath) {
		this.fileInputPath = fileInputPath;
	}

	public String getFileOutPath() {
		return fileOutPath;
	}

	public void setFileOutPath(String fileOutPath) {
		this.fileOutPath = fileOutPath;
	}
}
