package org.edu.unidep.domain.orm;

import java.util.List;

public class IsbnInputModel {

	private List<LivroInfo> items;

	public List<LivroInfo> getItens() {
		return items;
	}

	public void setItens(List<LivroInfo> itens) {
		this.items = itens;
	}
}
