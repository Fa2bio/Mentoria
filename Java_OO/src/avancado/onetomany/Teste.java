package avancado.onetomany;

public class Teste {
	public static void main(String[] args) {
		Endereco e1 = new Endereco("Rua 1");
		Endereco e2 = new Endereco("Rua 2");
		
		Pessoa p = new Pessoa("Fabio");
		p.adicionar(e1);
		p.adicionar(e2);
		
		System.out.println("Meu nome é Fábio e meu enderecos sao: ");
		for (Endereco e : p.enderecos) {
			System.out.println(e.rua);
		}
	}
}