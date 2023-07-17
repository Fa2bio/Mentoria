package org.edu.unidep.api.dto.assembler;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.edu.unidep.api.dto.request.ItemRequest;
import org.edu.unidep.api.dto.response.ItemResponse;
import org.edu.unidep.domain.model.Item;
import org.edu.unidep.domain.model.Orcamento;
import org.edu.unidep.domain.model.Produto;
import org.edu.unidep.domain.service.ProdutoService;

@ApplicationScoped
public class ItemAssembler {

	@Inject
	private ProdutoAssembler produtoAssembler;
	
	@Inject
	private ProdutoService produtoService;
	
	public ItemResponse toResponse(Item item) {
		return new ItemResponse(
				item.getId(),
				item.getQuantidade(),
				item.getValorTotal(),
				item.getValorUnitario(),
				produtoAssembler.toResponse(item.getProduto())				
				);				
	}
	
	public Item toDomainObject(ItemRequest itemRequest, Orcamento orcamento) {
		Item item = new Item();		
		item.setQuantidade(itemRequest.quantidade());
		item.setValorUnitario(itemRequest.valorUnitario());
		item.calcularValorTotal();
		item.setOrcamento(orcamento);
		Produto produto = produtoService.buscarPorCodigo(itemRequest.produto().id());
		item.setProduto(produto);
		return item;
	}
	
	public List<ItemResponse> toCollectionResponse (List<Item> itens){
		return itens.stream()
				.map(item -> toResponse(item))
				.collect(Collectors.toList());
	}
	
	public List<Item> toCollectionDomainObject(List<ItemRequest> itens, Orcamento orcamento){
		return itens.stream()
				.map(item -> toDomainObject(item, orcamento))
				.collect(Collectors.toList());
	}
}
