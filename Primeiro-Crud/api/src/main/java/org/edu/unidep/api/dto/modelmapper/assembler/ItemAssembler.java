package org.edu.unidep.api.dto.modelmapper.assembler;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.edu.unidep.api.dto.modelmapper.request.ItemRequest;
import org.edu.unidep.domain.model.Item;
import org.edu.unidep.domain.model.Livro;
import org.edu.unidep.domain.model.Pedido;
import org.edu.unidep.domain.service.LivroService;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class ItemAssembler {

	@Inject
	private ModelMapper modelMapper;
	
	@Inject
	private LivroService livroService;
	
	public Item toModel(ItemRequest itemRequest, Pedido pedido){
		Item item = modelMapper.map(itemRequest, Item.class);
		Livro livro = livroService.buscarOuFalhar(itemRequest.getLivro_id());
		livro.setCliente(pedido.getCliente());
		
		item.setId(null);
		item.setLivro(livro);
		item.setPedido(pedido);
		return item;
	}
	
	public List<Item> toCollectionModel(List<ItemRequest> itens, Pedido pedido){
		return itens.stream()
				.map(itemRequest -> toModel(itemRequest, pedido))
				.collect(Collectors.toList());
	}

}
