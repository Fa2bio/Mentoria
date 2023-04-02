package intermediario.polimorfismo.estatico;

public class TesteArea {
	public static void main(String[] args) {
		Area a = new Area();
		System.out.println(a.soma(2, 3));
		System.out.println(a.soma(3.1, 4.2));
	}
}
