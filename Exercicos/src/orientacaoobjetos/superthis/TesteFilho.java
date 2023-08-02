package orientacaoobjetos.superthis;

public class TesteFilho extends TestePai{
	
	public TesteFilho(String nome) {
		this(nome, "ABC");
	}
	
	public TesteFilho(String nome, String sobreNome) {
		super(nome);
	}
	
	public void brincar() {
		this.nome = "Rosangela";
		System.out.println(super.nome);
		super.sobreNome = "Bg";
	}


	
}
