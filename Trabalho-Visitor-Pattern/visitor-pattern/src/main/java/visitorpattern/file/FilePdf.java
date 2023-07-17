package visitorpattern.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import visitorpattern.visitor.Visitor;

public class FilePdf implements FileManipulator{

	private String fileInputPath;
	private String fileOutPath;
	
	public FilePdf(String fileInputPath, String fileOutPath) {
		this.fileInputPath = fileInputPath;
		this.fileOutPath = fileOutPath;
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
		try {
			PDDocument pdf = null;
			File pdfFile = new File(fileInputPath);
			
			pdf = PDDocument.load(pdfFile);
			PDFTextStripper stripper = new PDFTextStripper();
			return stripper.getText(pdf);
		} catch (IOException e) {
			throw e;
		}
	}

	@Override
	public String accept(Visitor visitor) throws IOException{
		return visitor.visit(this);
	}
	
	
}
