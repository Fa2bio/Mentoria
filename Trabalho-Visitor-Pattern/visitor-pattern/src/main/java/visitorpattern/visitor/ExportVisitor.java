package visitorpattern.visitor;

import java.io.IOException;

import visitorpattern.file.FileDat;
import visitorpattern.file.FileManipulator;
import visitorpattern.file.FilePdf;
import visitorpattern.file.FileTxt;

public class ExportVisitor implements Visitor{
	
	public String export(FileManipulator... args) {
		StringBuilder sb = new StringBuilder();
		
		for (FileManipulator fileManipulator : args) {
			try {
				sb.append(String.format("O arquivo %s foi lido com sucesso",
						fileManipulator.getClass().getSimpleName()))
				.append("\n")
				.append(fileManipulator.accept(this))
				.append(String.format("O conteudo de %s foi escrito com sucesso no arquivo de saída",
						fileManipulator.getClass().getSimpleName()))
				.append("\n\n");
				;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	@Override
	public String visit(FileDat file) throws IOException{
		String result = file.fileReader(file.getFileInputPath());
		file.fileWriter(file.getFileInputPath(), file.getFileOutPath());
		result = "";
		return result;
	}

	@Override
	public String visit(FilePdf file) throws IOException{
		String result = file.fileReader(file.getFileInputPath());
		file.fileWriter(file.getFileInputPath(), file.getFileOutPath());
		result = "";
		return result;
	}

	@Override
	public String visit(FileTxt file) throws IOException{
		String result = file.fileReader(file.getFileInputPath());
		file.fileWriter(file.getFileInputPath(), file.getFileOutPath());
		result = "";
		return result;
	}

}
