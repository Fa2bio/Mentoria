package orientacaoobjetos.Q10;

import java.time.LocalDate;

public class Q10 {

	public static void main(String[] args) {
		LocalDate data = LocalDate.of(1990, 1, 20);
		Jogador j = new Jogador("Fabio", "Meio-campo", data,"Brasileiro",1.83,75.4);
		System.out.println(j.toString());
		int idade = j.idadeJogador(2023);
		System.out.println(idade);
		System.out.println(j.anosRestastantes(idade));
	}
}
