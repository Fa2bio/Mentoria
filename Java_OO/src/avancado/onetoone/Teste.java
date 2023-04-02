package avancado.onetoone;

public class Teste {
	public static void main(String[] args) {
		Endereco endereco = new Endereco("Rua 1");
		Pessoa pessoa = new Pessoa("Fabio",endereco);
		
		System.out.println(pessoa.endereco.getRua());
	}
}
