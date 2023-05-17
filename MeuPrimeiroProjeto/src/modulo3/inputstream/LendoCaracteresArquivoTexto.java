package modulo3.inputstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LendoCaracteresArquivoTexto {
	public static void main(String[] args) {
		try {
			FileReader file = new FileReader("FileInputTxt.txt");
			BufferedReader fileReader = new BufferedReader(file);
			String line;
			while((line = fileReader.readLine()) != null) {
				System.out.println(line);				
			}
			
			fileReader.close();
			file.close();

		} catch (IOException e) {
			 e.printStackTrace();
		}
	}

}
