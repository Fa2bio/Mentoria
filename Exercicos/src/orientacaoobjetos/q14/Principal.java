package orientacaoobjetos.q14;

public class Principal {

	public static void main(String[] args) {
		Fatura f = new Fatura("1234","primeiro pedido",-10,2.9);
		System.out.println(f.getTotalFatura());
	}
}
