package orientacaoobjetos.q15;

public class FuncionarioTeste {

	public static void main(String[] args) {
		Funcionario f = new Funcionario("Fabio","Correa",10000.50);
		System.out.println(f.getSalarioAnual());
		System.out.println(Funcionario.getTotal_funcionarios());
		f.aumentarSalario();
		System.out.println(f.getSalarioAnual());
		
		Funcionario f2 = new Funcionario("Rosangela", "brb", 50000);		
		System.out.println(f2.getSalarioAnual());
		System.out.println(Funcionario.getTotal_funcionarios());
		f2.aumentarSalario();
		System.out.println(f2.getSalarioAnual());
		
		Funcionario f3 = new Funcionario("Rosangela", "brb", 50000);
		System.out.println(Funcionario.getTotal_funcionarios());
		
		Funcionario f4 = new Funcionario("Rosangela", "brb", 50000);
		Funcionario f5 = new Funcionario("Rosangela", "brb", 50000);
		Funcionario f6 = new Funcionario("Rosangela", "brb", 50000);
		Funcionario f7 = new Funcionario("Rosangela", "brb", 50000);
		
		System.out.println(Funcionario.getTotal_funcionarios());
		
		}
}
