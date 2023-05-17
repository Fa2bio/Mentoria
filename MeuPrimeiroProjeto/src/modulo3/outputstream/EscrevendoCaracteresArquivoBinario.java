package modulo3.outputstream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscrevendoCaracteresArquivoBinario {
	public static void main(String[] args) {
		String s = "Olá, eu sou um arquivo texto binário sequencial em formato .dat";
		try {
			FileOutputStream file = new FileOutputStream("FileOutputDat.dat");
			DataOutputStream fileWrite = new DataOutputStream(file);
			fileWrite.writeChars(s);
			
			fileWrite.close();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
}
