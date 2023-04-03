package modulo1.primeiro;

public class For {
	public static void main(String[] args) {
		char[] c = {'F','A'};
		for(int i=0;i<c.length;i++) {
			System.out.println(c[i]);
		}
		
		for (char d : c) {
			System.out.print(d);
		}
	}
}
