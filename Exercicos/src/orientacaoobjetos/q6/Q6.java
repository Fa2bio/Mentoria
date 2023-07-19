package orientacaoobjetos.q6;

public class Q6 {

	public static void main(String[] args) {
		Invoice i = new Invoice("123","Produto de beleza",10,10.9);
		System.out.println(i.getInvoiceAmount());
	}
}
