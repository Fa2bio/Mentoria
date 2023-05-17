package visitorpattern.visitor;

import java.io.IOException;

import visitorpattern.file.FileDat;
import visitorpattern.file.FilePdf;
import visitorpattern.file.FileTxt;

public interface Visitor {
	String visit(FileDat file) throws IOException;
	String visit(FilePdf file) throws IOException;
	String visit(FileTxt file) throws IOException;
}
