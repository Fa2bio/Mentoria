package visitorpattern;

import visitorpattern.file.FileDat;
import visitorpattern.file.FileManipulator;
import visitorpattern.file.FilePdf;
import visitorpattern.file.FileTxt;
import visitorpattern.visitor.ExportVisitor;

public class Console {
	public static void main(String[] args) {
		FileTxt fileTxt = new FileTxt("FileTxt.txt", "FileOutput.txt");
		FileDat fileDat = new FileDat("FileDat.dat", "FileOutput.txt");
		FilePdf filePdf = new FilePdf("FilePdf.pdf", "FileOutput.txt");
		
		export(fileTxt, fileDat, filePdf);
	}
	
	private static void export(FileManipulator... files) {
		ExportVisitor exportVisitor = new ExportVisitor();
		System.out.println(exportVisitor.export(files));
	}
}
