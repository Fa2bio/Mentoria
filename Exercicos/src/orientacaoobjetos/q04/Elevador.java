package orientacaoobjetos.q04;

public class Elevador {
	private int andarAtual;
	private int capacidade;
	private int totalAndares;
    private int pessoasPresentes;
    

    public Elevador(int capacidade, int totalAndares) {
        inicializar(capacidade, totalAndares);
    }
    
    public boolean entrar(int qtdPessoas) {
    	int totalPessoas = this.pessoasPresentes + qtdPessoas;
    	if(totalPessoas <= this.capacidade) {
    		setPessoasPresentes(totalPessoas);
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public boolean sai(int qtdPessoas) {
    	if(this.pessoasPresentes > 0) {
    		setPessoasPresentes(this.pessoasPresentes - qtdPessoas);
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public boolean sobe() {
    	if(this.andarAtual == this.totalAndares) {
    		return false;
    	}else {
    		setAndarAtual(++this.andarAtual);
    		return true;
    	}
    }
    
    public boolean desce() {
    	if(this.andarAtual == 0) {
    		return false;
    	}else {
    		setAndarAtual(--this.andarAtual);
    		return true;
    	}
    }
    
    private void inicializar(int capacidade, int totalAndares ) {
        this.capacidade = capacidade;
        this.totalAndares = totalAndares;
        this.andarAtual = 0;
        this.pessoasPresentes = 0;
	}
    
	public int getAndarAtual() {
		return andarAtual;
	}
	public void setAndarAtual(int andarAtual) {
		this.andarAtual = andarAtual;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public int getTotalAndares() {
		return totalAndares;
	}
	public void setTotalAndares(int totalAndares) {
		this.totalAndares = totalAndares;
	}
	public int getPessoasPresentes() {
		return pessoasPresentes;
	}
	public void setPessoasPresentes(int pessoasPresentes) {
		this.pessoasPresentes = pessoasPresentes;
	}
}
