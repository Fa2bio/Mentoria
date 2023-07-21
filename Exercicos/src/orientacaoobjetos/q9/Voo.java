package orientacaoobjetos.q9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Voo {

	private LocalDate data;
	private String numeroVoo;
	private List <Vaga> vagas = new ArrayList<>();
	
	public Voo (String numeroVoo, LocalDate data) {
		this.numeroVoo = numeroVoo;
		this.data = data;
		gerarVagas();
	}
	
	public int proximoLivre() {
		for(int numeroVaga = 0; numeroVaga < 100; numeroVaga++) {
			Vaga vaga = vagas.get(numeroVaga);
			if(!vaga.isOcupado()) {
				return numeroVaga;
			}
		}
		return -1;
	}
	
	public boolean verifica(int numeroVaga) {
			if(numeroVaga >= 0) {
				if(numeroVaga == 100) --numeroVaga;
			}else {
				return true;
			}
			Vaga vaga = vagas.get(numeroVaga);
			if(vaga.isOcupado()) {
				return true;
			}else {
				return false;
			}
	
	}
	
	public boolean ocupa(int numeroVaga) {
		if(!verifica(numeroVaga)) {
			Vaga vaga = vagas.get(numeroVaga);
			vaga.setOcupado(true);
			return true;
		}else {
			return false;
		}
	}
	
	public int vagas() {
		int numeroVagasLivres = 0;
		
		for(int numeroVaga = 0; numeroVaga < 100; numeroVaga++) {
			if(!verifica(numeroVaga)) {
				numeroVagasLivres++;
			}
		}
		
		return numeroVagasLivres;
	}

	private void gerarVagas() {
		for(int numeroVaga = 0; numeroVaga < 100; numeroVaga++) {
			Vaga vaga = new Vaga(numeroVaga,false,this);
			vagas.add(vaga);
			vagas.remove(vaga);
		}
		
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getNumeroVoo() {
		return numeroVoo;
	}

	public void setNumeroVoo(String numeroVoo) {
		this.numeroVoo = numeroVoo;
	}

	public List<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}
	
}
