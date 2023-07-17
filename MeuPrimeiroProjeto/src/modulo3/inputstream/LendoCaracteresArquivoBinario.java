package modulo3.inputstream;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class LendoCaracteresArquivoBinario {

    public static void main(String[] args) {
        try {
        	FileInputStream inpuStream = new FileInputStream("FileInputDat.dat");
        	DataInputStream inpuStreamReader = new DataInputStream(inpuStream);
        	boolean over = false;
			while(!over) {				
				try {
					int k = inpuStreamReader.readInt();
					for(int i=0;i<k;i++) {
						System.out.print(inpuStreamReader.readChar());
					}					
				} catch (EOFException e) {
					over = true;
				}
			}
			inpuStream.close();
			inpuStreamReader.close();
        } catch (IOException e) {
               e.printStackTrace();
        }

  }
}
