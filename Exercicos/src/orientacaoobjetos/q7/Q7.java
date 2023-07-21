package orientacaoobjetos.q7;

public class Q7 {

	public static void main(String[] args) {
	Funcionario funcionario1 = new Funcionario("Marcelo", "Nunes",4500.00);
        Funcionario funcionario2 = new Funcionario("Nayara", "Andrade", 9500.00);
        
       
        System.out.println("Funcionario 1: "+ funcionario1.getPrimeiroNome()
        +" recebe um salario anual de: "+ funcionario1.getSalarioAnual());
        
        funcionario1.darAumento(10.0);  
        System.out.println("com o aumento de 10% passou a receber : " + funcionario1.getSalarioAnual());
        
        System.out.println("O nome do funcionario 2:" + funcionario2.getPrimeiroNome()
        +"recebe um salario anual de:"
        +funcionario2.getSalarioAnual());

        funcionario2.darAumento(10.0); 
        System.out.println("Salário anual do funcionário 2 após o aumento: " 
        + funcionario2.getSalarioAnual());
	}
}
