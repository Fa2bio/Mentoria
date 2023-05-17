package modulo3.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LendoBytes {
	
	public static void main(String[] args) {
        
        try {
        	FileInputStream inputstream = new FileInputStream("FileInputDat.dat");
//        	FileInputStream inputstream = new FileInputStream("FileInputTxt.txt");
            int data = inputstream.read();
            while (data != -1) {
            	System.out.println(data);
            	data = inputstream.read();
            }
            inputstream.close();
        } catch (FileNotFoundException e1) {
               e1.printStackTrace();
        } catch (IOException e) {
               e.printStackTrace();
        }

  }
}
