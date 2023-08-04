package orientacaoobjetos.q03;

public class Q3 {

	public static void main(String[] args) {
		BombaCombustivel b1 = new BombaCombustivel();
		b1.setQtdCombustivel(1000.00);
		b1.setTipoCombustivel("Gasolina");
		b1.setValorLitro(5.49);
		
		System.out.println("O tipo de combustivel na bomba eh " + b1.getTipoCombustivel() + " a quantidade de litros dispinovel eh de: " + b1.getQtdCombustivel()
		+ " e o valor do combustivel na bomba eh de " + b1.getValorLitro());
		
		System.out.println(b1.abastecerPorValor(50));
		System.out.println(b1.getQtdCombustivel());
		System.out.println(b1.abastecerPorLitro(9.10));
		System.out.println(b1.getQtdCombustivel());
		b1.alterarValor(5.50);
		System.out.println(b1.getValorLitro());
		b1.alterarCombustivel("Alcool");
		System.out.println(b1.getTipoCombustivel());
		b1.alterarQuantidadeCombustivel(10);
		System.out.println(b1.getQtdCombustivel());
	}
}
