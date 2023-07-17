package orientacaoobjetos.q1;

import java.time.LocalDate;

public class Q1 {

	public static void main(String[] args) {
		LocalDate dataNascimento = LocalDate.of(1990, 1, 30);
		Pessoa p1 = new Pessoa("Fabio",dataNascimento, 1.85);
		
		System.out.println(p1.imprimir());
		System.out.println(p1.calcularIdade(2023));
	}
}
