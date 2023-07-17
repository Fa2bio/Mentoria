package modulo3.outputstream;

import java.io.FileOutputStream;
import java.io.IOException;

public class EscrevendoBytes {

    public static void main(String[] args) {
        try {
        	FileOutputStream output = new FileOutputStream("FileOutputDat.dat");
            int[] s = {79,108,195,161,44,32};

           for(int i = 0; i < s.length; i++) {
        	   System.out.println(s[i]);
        	   output.write(s[i]);
            }
            output.close();
        } catch (IOException e) {
               e.printStackTrace();
        }

  }
}
