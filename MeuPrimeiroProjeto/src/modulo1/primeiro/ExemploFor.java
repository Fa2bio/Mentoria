package modulo1.primeiro;

public class ExemploFor {
	public static void main(String[] args) {
		char[] c = {'F','A','B','I','O'};
		for(int i = 0; i<c.length; ++i) {
			System.out.print(i+" ");
			System.out.println(c[i]);
		}
		
		for (char d : c) {
			System.out.println(d); // Cometario
			/* ollla 
			 * aksalks
			 */
		}
	}
}
