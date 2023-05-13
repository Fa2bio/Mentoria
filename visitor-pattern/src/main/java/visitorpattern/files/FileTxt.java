package visitorpattern.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import visitorpattern.visitor.Visitor;

public class FileTxt implements FileManipulator{
	
	private String fileInputPath;
	private String fileOutputPath;
	
	public FileTxt(String fileInputPath,String fileOutputPath) {
		this.fileInputPath = fileInputPath;
		this.fileOutputPath = fileOutputPath;
	}

	@Override
	public void fileWriter(String fileInputPath, String fileOutputPath) throws IOException{
		try {
			FileWriter file = new FileWriter(fileOutputPath, true);
			PrintWriter writefile = new PrintWriter(file);
			String charcs = fileReader(fileInputPath);
			
			writefile.println(charcs);	
		
			writefile.close();
			file.close();
		} catch (IOException e) {
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
				sb.append(line.replace("\n", "\r\n"));
			}
			
			fileReader.close();
			file.close();			
			return sb.toString();
		} catch (IOException e) {
			 throw e;
		}
	}

	@Override
	public String accept(Visitor visitor) throws IOException {
		return visitor.visit(this);
	}

	public String getFileInputPath() {
		return fileInputPath;
	}

	public void setFileInputPath(String fileInputPath) {
		this.fileInputPath = fileInputPath;
	}

	public String getFileOutputPath() {
		return fileOutputPath;
	}

	public void setFileOutputPath(String fileOutputPath) {
		this.fileOutputPath = fileOutputPath;
	}

}
