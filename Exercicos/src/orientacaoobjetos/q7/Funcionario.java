package orientacaoobjetos.q7;

public class Funcionario{ 
    private String primeiroNome;
    private String sobrenome;
    private double salarioMensal;

    public Funcionario(String primeiroNome, String sobrenome, double salarioMensal) {
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.salarioMensal = salarioMensal;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public double getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(double salarioMensal) {
        if (salarioMensal <= 0) {
            this.salarioMensal = 0.0;
        } else {
            this.salarioMensal = salarioMensal;
        }
    }

    public double getSalarioAnual() {
        return salarioMensal * 12;
    }

    public void darAumento(double porcentagem) {
        salarioMensal = salarioMensal * (1 + porcentagem / 100);
    }
}

