package org.edu.unidep.api.dto.record.assembler;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.edu.unidep.api.dto.record.response.LivroResponse;
import org.edu.unidep.api.dto.record.response.VolumeInfoResponse;
import org.edu.unidep.domain.model.Livro;

@ApplicationScoped
public class LivroAssembler {

	@Inject
	private ClienteRecordAssembler clienteRecordAssembler;
	
	public LivroResponse toResponse(Livro livro) {
		VolumeInfoResponse volumeInfoResponse = new VolumeInfoResponse(
				livro.getVolumeInfo().getTitulo(),
				livro.getVolumeInfo().getDataPublicacao(),
				livro.getVolumeInfo().getDescricao(),
				livro.getVolumeInfo().getLingua(),
				livro.getVolumeInfo().getQtdPags(),
				livro.getVolumeInfo().getAutores()				
				);
		
		return new LivroResponse(				
				livro.getIsbn(),
				volumeInfoResponse,
				clienteRecordAssembler.toResumoResponse(livro.getCliente())
				);
	}
	
	public List<LivroResponse> toCollectionResponse(List<Livro> livros){
		return livros.stream()
				.map(livro -> toResponse(livro))
				.collect(Collectors.toList());
	}
	
}
