package orientacaoobjetos.q08;

public class Q8 {
	public static void main(String[] args) {
		Data d1 = new Data("10","02","2024");
		System.out.println(d1.getDia());
		System.out.println(d1.getDataFormatada());
		System.out.println(d1.getMesExtenso());
		System.out.println(d1.isBissexto());
		System.out.println(d1.coparar(new Data("10","03","2024")));

		try {
			Data d2 = d1.clone();
			System.out.println(d2.getDataFormatada());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
