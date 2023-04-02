package basico;

public class TesteData {
	public static void main(String[] args) {
		Data d = new Data();
		d.setDia(31);
		System.out.println(String.format("%d/%d/%d", d.getDia(),d.mes,d.ano));
		
		Carro c = new Carro();
		c.acelerar();
		c.acelerar();
		System.out.println(c.velocidade);
		
//		Data d2 = new Data(10,01,2023);
//		System.out.println(String.format("%d/%d/%d", d2.dia,d2.mes,d2.ano));
	}
}
