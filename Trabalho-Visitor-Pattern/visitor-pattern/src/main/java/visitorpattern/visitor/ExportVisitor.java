package visitorpattern.visitor;

import java.io.IOException;

import visitorpattern.files.FileDat;
import visitorpattern.files.FilePdf;
import visitorpattern.files.FileManipulator;
import visitorpattern.files.FileTxt;

public class ExportVisitor implements Visitor{
	
	public String export(FileManipulator... args) {
		StringBuilder sb = new StringBuilder();
		for (FileManipulator fileManipulator : args) {
			try {
				sb.append(String.format("The %s file has been read",
						fileManipulator.getClass().getSimpleName()))
				.append("\r\n")
				.append(fileManipulator.accept(this))
				.append(String.format("The %s file has been written",
						fileManipulator.getClass().getSimpleName()))
				.append("\r\n\r\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	@Override
	public String visit(FileDat file) throws IOException {
		String result = file.fileReader(file.getFileInputPath());
		file.fileWriter(file.getFileInputPath(), file.getFileOutputPath());
		result = "";
		return result;
	}

	@Override
	public String visit(FilePdf file) throws IOException{
		String result = file.fileReader(file.getFileInputPath());
		file.fileWriter(file.getFileInputPath(), file.getFileOutputPath());
		result = "";
		return result;
	}

	@Override
	public String visit(FileTxt file) throws IOException {
		String result = file.fileReader(file.getFileInputPath());
		file.fileWriter(file.getFileInputPath(), file.getFileOutputPath());
		result = "";
		return result;
	}

}
