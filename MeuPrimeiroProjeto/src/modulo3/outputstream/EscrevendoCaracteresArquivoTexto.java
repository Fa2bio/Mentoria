package modulo3.outputstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscrevendoCaracteresArquivoTexto {
	public static void main(String[] args) {
		String s = "Olá, eu sou um arquivo de texto de output padrão no formato .txt";
		try {
			FileWriter file = new FileWriter("FileOutputTxt.txt");
			PrintWriter writefile = new PrintWriter(file);
			
			writefile.println(s);
			System.out.println("Arquivo gravado com sucesso");
			writefile.close();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
