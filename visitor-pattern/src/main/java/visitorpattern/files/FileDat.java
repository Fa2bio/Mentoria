package visitorpattern.files;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import visitorpattern.visitor.Visitor;

public class FileDat implements FileManipulator{

	private String fileInputPath;
	
	private String fileOutputPath;
	
	public FileDat(String fileInputPath,String fileOutputPath) {
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
	public String fileReader(String fileInputPath) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		try {
			FileInputStream  file = new FileInputStream (fileInputPath);
			DataInputStream fileReader = new DataInputStream(file);
			
			boolean over = false;
			
			while(!over) {
				try {
					int k = fileReader.readInt();
					for(int i=0;i<k;i++) {
						sb.append(fileReader.readChar());
					}
					
				} catch (EOFException e) {
					over = true;
				}
			}
			
			file.close();
			fileReader.close();			
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
