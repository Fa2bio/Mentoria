package orientacaoobjetos.q8;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Data implements Cloneable{

	private String dia;
	private String mes;
	private String mesExtenso;
	private String ano;
	private LocalDate data;
	
	public Data(String dia, String mes, String ano) {
		if(isValido(dia, mes, ano)) {
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
		}else {
			isValido("01", "01", "0001");
		}
	}
	
	public boolean isBissexto() {
		int anoCorrente = Integer.parseInt(this.ano);
		if(anoCorrente%4 == 0) {
			if(anoCorrente%100 == 0) return false;
			return true;
		}else {
			if(anoCorrente%400==0) return true;
			else return false;
		}
	}
	
	public int coparar(Data data) {
		
		int anoCorrente = Integer.parseInt(this.ano);
		int anoParamentro = Integer.parseInt(data.getAno());
		if(anoCorrente > anoParamentro) return 1;
		else if(anoCorrente < anoParamentro) return -1;
		else {
			int mesCorrente = Integer.parseInt(this.mes);
			int mesParamentro = Integer.parseInt(data.getMes());
			if(mesCorrente > mesParamentro) return 1;
			else if(mesCorrente < mesParamentro) return -1;
			else {
				int diaCorrente = Integer.parseInt(this.dia);
				int diaParamentro = Integer.parseInt(data.getDia());
				if(diaCorrente > diaParamentro) return 1;
				else if(diaCorrente < diaParamentro) return -1;
			}
		}
		return 0;
	}
	
    @Override
    public Data clone() throws CloneNotSupportedException {
        return (Data) super.clone();
    }
	
	private boolean isValido(String dia, String mes, String ano) {
		try {
			LocalDate dataValida = LocalDate
					.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));
			this.mesExtenso = dataValida.getMonth().name();
			this.data = dataValida;
			return true;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return false;
		} catch(DateTimeException e) {
			return false;
		}		
	}
	public String getDia() {
		return this.dia;
	}
	
	public String getMes() {
		return this.mes;
	}
	
	public String getMesExtenso() {
		return this.mesExtenso;
	}
	
	public String getAno() {
		return this.ano;
	}
	
	public LocalDate getData() {
		return this.data;
	}
	
	public String getDataFormatada() {
		DateTimeFormatter formatadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return this.data.format(formatadorBarra);
	}
}
