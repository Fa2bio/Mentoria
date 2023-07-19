package orientacaoobjetos.q6;

public class Invoice {

	private String numeroItem;
	private String descricao;
	private int qtdItem;
	private double precoUnitario;
			
	public Invoice(String numeroItem, String descricao, int qtdItem, double precoUnitario) {
		
		this.numeroItem = numeroItem;
		this.descricao = descricao;
		
		if(qtdItem > 0) {
			this.qtdItem = qtdItem;
		}else {
			this.qtdItem = 0;
		}
		
		if(precoUnitario > 0) {
			this.precoUnitario = precoUnitario;
		}else {
			this.precoUnitario = 0.0;
		}
	}
	
	public double getInvoiceAmount() {
		double valorTotal = this.precoUnitario * this.qtdItem;
		return valorTotal;
	}

	public String getNumeroItem() {
		return numeroItem;
	}

	public void setNumeroItem(String numeroItem) {
		this.numeroItem = numeroItem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtdItem() {
		return qtdItem;
	}

	public void setQtdItem(int qtdItem) {
		this.qtdItem = qtdItem;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	
}
