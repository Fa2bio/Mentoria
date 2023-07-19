package orientacaoobjetos.q4;

public class Q4 {

	public static void main(String[] args) {
		Elevador e = new Elevador(18, 5);
		System.out.println("A capacidade total eh " + e.getCapacidade());
		System.out.println("O total de andares eh " + e.getTotalAndares());
		System.out.println("O andar atual eh: " + e.getAndarAtual());
		
		System.out.println(e.entrar(18));
		System.out.println("O total de pessoas presentes eh "+ e.getPessoasPresentes());
	
		System.out.println(e.sai(10));
		System.out.println("O total de pessoas presentes eh "+ e.getPessoasPresentes());
		
		System.out.println(e.sobe());
		System.out.println(e.sobe());
		System.out.println(e.sobe());
		System.out.println(e.sobe());
		System.out.println(e.sobe());
		System.out.println(e.desce());
		System.out.println(e.getAndarAtual());
	}
}
