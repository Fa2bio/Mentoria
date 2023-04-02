package intermediario.acesso;

public class TesteAcesso {
	public static void main(String[] args) {
		Mae mae = new Mae();
		Filho filho = new Filho();
		
		System.out.println(filho.nomeAvo);
		System.out.println(filho.nomeMae);
		System.out.println(filho.nomeAvo);
		
		System.out.println(mae.nomeMae);
		System.out.println(mae.nomeAvo);
		
	}
}
