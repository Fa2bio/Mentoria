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
		return data.isLeapYear();
	}
	
	public int coparar(Data data) {
		if(this.data.isEqual(data.getData())) {
			return 0;
		}else if(this.data.isAfter(data.getData())) {
			return 1;
		}else return -1;
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
