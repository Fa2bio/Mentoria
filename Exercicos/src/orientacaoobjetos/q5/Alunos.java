package orientacaoobjetos.q5;

public class Alunos {

	private String matricula;
    private String nome;
    private double notaProva1;
    private double notaProva2;
    private double notaTrabalho;
   
    
  public Alunos(String matricula, String nome, double notaProva1, double notaProva2,
		  double notaTrabalho) 
     {
        this.matricula = matricula;
        this.nome = nome;
        this.notaProva1 = notaProva1;
        this.notaProva2 = notaProva2;
        this.notaTrabalho = notaTrabalho;
     }
      public double media() {
      double mediaProvas = (notaProva1 * 2.5 + notaProva2 * 2.5) / 5.0;
      double mediaFinal = (mediaProvas + notaTrabalho * 2.0) / 3.0;
      return mediaFinal;
      }

  
      public double mediafinal() {
      double mediaFinal = media();
      double notaProvaFinal = mediaFinal < 7.0 ? 10.0 - mediaFinal : 0.0;
      return notaProvaFinal;

      }
 
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getNotaProva1() {
		return notaProva1;
	}
	public void setNotaProva1(double notaProva1) {
		this.notaProva1 = notaProva1;
	}
	public double getNotaProva2() {
		return notaProva2;
	}
	public void setNotaProva2(double notaProva2) {
		this.notaProva2 = notaProva2;
	}
	public double getNotaTrabalho() {
		return notaTrabalho;
	}
	public void setNotaTrabalho(double notaTrabalho) {
		this.notaTrabalho = notaTrabalho;
	}
}
