package modulo2.orientacao.polimorfismo.estatico;

public class TesteData {
	public static void main(String[] args) {
		Data novaData = new Data();
		Data segundaData = new Data(01,03,2023);
		
		System.out.println(String.format("%d/%d/%d", novaData.getDia(), novaData.getMes(),novaData.getAno()));
		System.out.println(String.format("%d/%d/%d", segundaData.getDia(), segundaData.getMes(),segundaData.getAno()));
		System.out.println(novaData.diferencaEntreDias(10, 20));
	}
}
