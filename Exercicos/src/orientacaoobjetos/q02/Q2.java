package orientacaoobjetos.q02;

public class Q2 {

	public static void main(String[] args) {
		ContaCorrente c1 = new ContaCorrente("123","Fabio");
		ContaCorrente c2 = new ContaCorrente("456","Rosangela",1050.50);
		
//		System.out.println("O nome do correntista eh " + c1.getNome());
//		c1.alterarNome("Roberto");
//		System.out.println("O nome do correntista eh " + c1.getNome());
//		
//		
//		System.out.println("O saldo do correntista 1 " + c1.getSaldo());
//		c1.deposito(100.00);
//		System.out.println("O saldo do correntista 1 " + c1.getSaldo());
//	
//		c1.saque(100.00);
//		System.out.println("Realizando um saque para correntista 1 " + c1.getSaldo());
//	
	
		System.out.println("O saldo do correntista 2 " + c2.getSaldo());
		c2.deposito(50.00);
		System.out.println("O saldo do correntista 2 " + c2.getSaldo());
		
		c2.saque(1000.0);
		System.out.println(c2.getSaldo());
	}
}
