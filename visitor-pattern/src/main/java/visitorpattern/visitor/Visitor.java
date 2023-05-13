package visitorpattern.visitor;

import java.io.IOException;

import visitorpattern.files.FileDat;
import visitorpattern.files.FilePdf;
import visitorpattern.files.FileTxt;

public interface Visitor {
	String visit(FileDat file) throws IOException;
	String visit(FilePdf file) throws IOException;
	String visit(FileTxt file) throws IOException;
}
