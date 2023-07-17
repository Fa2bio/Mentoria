package modulo2.orientacao.polimorfismo.estatico;

public class Data implements DataMetodos{
	
	int dia, mes, ano;
	
	public Data() {
		this(10,12,2023);
	}
	
	public Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public int diferencaEntreDias(int dia1, int dia2) {
		
		return dia2-dia1;
	}
	
	
}
