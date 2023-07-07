package orientacaoobjetos.q8;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Data implements Cloneable{

	private int dia;
	private int mes; 
	private int ano;
	private String data;
	private String mesExtenso;
	
	public Data(String dia, String mes, String ano) {
		if(isValido(dia, mes, ano)) {
			this.dia = Integer.parseInt(dia);
			this.mes = Integer.parseInt(mes);
			this.ano = Integer.parseInt(ano);
		}else isValido("01","01","0001");
	}
	
	public int compara(Data data) {
		if(this.ano > data.getAno()) return 1;
		else if(this.ano < data.getAno()) return -1;
		else {
			if(this.mes > data.getMes()) return 1;
			else if(this.mes < data.getMes()) return -1;
			else {
				if(this.dia > data.getDia()) return 1;
				else if(this.dia < data.getDia()) return -1;
			}
		}
		return 0;
	}
	
	public boolean isBissexto() {
		if(this.ano%4 == 0) {
			if(this.ano%100 == 0) return false;
			return true;
		}else {
			if(this.ano%400==0) return true;
			else return false;
		}
	}
	
    @Override
    public Data clone() throws CloneNotSupportedException {
        return (Data) super.clone();
    }
    
	private boolean isValido(String dia, String mes, String ano) {
		if(dia.length() == 2 && mes.length() == 2 && ano.length() == 4) {
			try {
				LocalDate dataValida = LocalDate
						.of(Integer.parseInt(ano),
							Integer.parseInt(mes),
							Integer.parseInt(dia));
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
				this.data = formatter.format(dataValida);
				this.mesExtenso = dataValida.getMonth().toString();
				return true;
			} catch (NumberFormatException e) {
				return false;
			} catch(DateTimeException e) {
				return false;
			}
			
		}else return false;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}

	public String getData() {
		return data;
	}

	public String getMesExtenso() {
		return mesExtenso;
	}	
	
}
