package modulo2.orientacao.onetomany;

public class PessaTeste {
	public static void main(String[] args) {
		Endereco endereco = new Endereco("Rua 1");
		Endereco endereco2 = new Endereco("Rua 2");
		Pessoa p = new Pessoa("Fabio");
		
		p.adicionarEnderecos(endereco2);
		endereco.adicionarPessoa(p);
		
		for (Endereco e : p.enderecos) {
			System.out.println(e.getRua());
		}		
	
		System.out.println(endereco.pessoa.getNome());
	}
}
