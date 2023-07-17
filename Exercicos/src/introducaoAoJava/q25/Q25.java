package introducaoAoJava.q25;

import java.util.Scanner;

public class Q25 {

	public static void main(String[] args) {
				
		
		Scanner entrada=new Scanner(System.in);
		
		int n1,n2;
		
		System.out.println("Digite o primeiro numero: ");
	    n1=entrada.nextInt();
	    System.out.println("Digite o primeiro numero: ");
	    n2=entrada.nextInt();
	    
	    
	    	    
	    if( n1==n2) {
	    	
	    	System.out.println("numeros iguais");
	    }else {
	    	System.out.println("numeros diferentes");
	
	    	if(n1>n2) {
	    		System.out.println(n1+"é maior que "+n2);
	    	}else {
	    		
	    		System.out.println(n2 +"é maior que"+n1 );
	    	}
	    }
	    entrada.close();
	}
}
