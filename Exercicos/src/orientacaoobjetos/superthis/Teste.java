package orientacaoobjetos.superthis;

public class Teste {

	public static void main(String[] args) {
		TesteFilho testeFilho = new TesteFilho("Fabio");
		testeFilho.brincar();
		System.out.println(testeFilho.getNome());
		System.out.println(testeFilho.getSobreNome());
	}
}
