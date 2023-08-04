package orientacaoobjetos.q09;

public class Vaga {

	private int numeroVaga;
	private boolean ocupado;
	private final Voo voo;	
	
	public Vaga(int numeroVaga, boolean ocupado, Voo voo) {
		this.numeroVaga = numeroVaga;
		this.ocupado = ocupado;
		this.voo = voo;
	}

	public int getNumeroVaga() {
		return numeroVaga;
	}

	public void setNumeroVaga(int numeroVaga) {
		this.numeroVaga = numeroVaga;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public Voo getVoo() {
		return voo;
	}

}
