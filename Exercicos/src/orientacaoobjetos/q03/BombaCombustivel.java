package orientacaoobjetos.q03;

public class BombaCombustivel {

	private String tipoCombustivel;
	private double valorLitro;
	private double qtdCombustivel;
	
	public double abastecerPorValor(double valor) {
		double qtdLitrosAbastecidos = valor/getValorLitro();
		double novoValorRestanteNaBomba = getQtdCombustivel()-qtdLitrosAbastecidos;
		setQtdCombustivel(novoValorRestanteNaBomba);
		return qtdLitrosAbastecidos;
	}
	
	public double abastecerPorLitro(double qtdCombustivel) {
		double valorASerPago = qtdCombustivel * getValorLitro();
		double novoValorRestanteNaBomba = getQtdCombustivel()-qtdCombustivel;
		setQtdCombustivel(novoValorRestanteNaBomba);
		return valorASerPago;
	}
	
	public void alterarValor(double novoValor) {
		setValorLitro(novoValor);
	}
	
	public void alterarCombustivel(String novoTipoCombustivel) {
		setTipoCombustivel(novoTipoCombustivel);
	}
	
	public void alterarQuantidadeCombustivel(double qtdCombustivel) {
		setQtdCombustivel(qtdCombustivel);
	}
	
	public String getTipoCombustivel() {
		return tipoCombustivel;
	}
	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}
	public double getValorLitro() {
		return valorLitro;
	}
	public void setValorLitro(double valorLitro) {
		this.valorLitro = valorLitro;
	}
	public double getQtdCombustivel() {
		return qtdCombustivel;
	}
	public void setQtdCombustivel(double qtdCombustivel) {
		this.qtdCombustivel = qtdCombustivel;
	}
	
	
}
