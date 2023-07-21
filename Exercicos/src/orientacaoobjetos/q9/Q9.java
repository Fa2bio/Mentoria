package orientacaoobjetos.q9;

import java.time.LocalDate;

public class Q9 {

	public static void main(String[] args) {
		LocalDate data = LocalDate.of(2023, 7, 20);
		Voo voo = new Voo("Londres1234",data);
		voo.ocupa(0);
		System.out.println("O proximo assento livre tem o numero: " + voo.proximoLivre());
		System.out.println("O numero de vagas disponiveis nesse voo eh de: " + voo.vagas());
		
		System.out.println("Este assento esta ocupado ?: " + voo.verifica(1));
		voo.ocupa(1);
		System.out.println("Este assento esta ocupado ?: " + voo.verifica(1));
		System.out.println("O proximo assento livre tem o numero: " + voo.proximoLivre());
	}
}
