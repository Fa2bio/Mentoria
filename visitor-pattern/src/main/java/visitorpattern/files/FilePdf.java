package visitorpattern.files;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import visitorpattern.visitor.Visitor;

public class FilePdf implements FileManipulator{

	private String fileInputPath;
	private String fileOutputPath;
	
	public FilePdf(String fileInputPath,String fileOutputPath) {
		this.fileInputPath = fileInputPath;
		this.fileOutputPath = fileOutputPath;
	}
	
	@Override
	public void fileWriter(String fileInputPath, String fileOutputPath) throws IOException{
		
		try {
			FileWriter file = new FileWriter(fileOutputPath, true);
			PrintWriter writefile = new PrintWriter(file);
			String charcs = fileReader(fileInputPath);			
			writefile.println(charcs.replace("\n", "\r\n"));	
		
			writefile.close();
			file.close();
		} catch (IOException e) {
			throw e;
		}
		
	}

	@Override
	public String fileReader(String fileInputPath) throws IOException {
		
		PDDocument pdf = null;
		File pdfFile = new File(fileInputPath);
		
		try {
			pdf = PDDocument.load(pdfFile);
			PDFTextStripper stripper = new PDFTextStripper();
			return stripper.getText(pdf);
		} catch (Exception e) {
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

	public String getFileOutputPath() {
		return fileOutputPath;
	}

	public void setFileOutputPath(String fileOutputPath) {
		this.fileOutputPath = fileOutputPath;
	}

}
