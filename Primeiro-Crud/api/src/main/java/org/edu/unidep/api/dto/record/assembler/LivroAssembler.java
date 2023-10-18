package org.edu.unidep.api.dto.record.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.UriInfo;

import org.edu.unidep.api.dto.record.response.ClienteResumoResponse;
import org.edu.unidep.api.dto.record.response.LivroResponse;
import org.edu.unidep.api.dto.record.response.VolumeInfoResponse;
import org.edu.unidep.api.hypermedia.ApiLinks;
import org.edu.unidep.domain.model.Livro;

@ApplicationScoped
public class LivroAssembler {

	@Inject
	private ClienteRecordAssembler clienteRecordAssembler;
	
	@Inject
	private ApiLinks apiLinks;
	
	public LivroResponse toResponse(Livro livro, UriInfo uriInfo) {
		VolumeInfoResponse volumeInfoResponse = new VolumeInfoResponse(
				livro.getVolumeInfo().getTitulo(),
				livro.getVolumeInfo().getDataPublicacao(),
				livro.getVolumeInfo().getDescricao(),
				livro.getVolumeInfo().getLingua(),
				livro.getVolumeInfo().getQtdPags(),
				livro.getVolumeInfo().getIsbn10(),
				livro.getVolumeInfo().getIsbn13(),
				livro.getVolumeInfo().getAutores()				
				);
		
		List<Link> links = new ArrayList<>();
		links.add(apiLinks.linkToLivrosListar(uriInfo));
		links.add(apiLinks.linkToLivrosBuscar(livro.getId(), uriInfo));
		links.add(apiLinks.linkToLivrosBuscarPorIsbn(livro.getVolumeInfo().getIsbn10(), uriInfo));
		links.add(apiLinks.linkToLivrosAtualizar(livro.getId(), uriInfo));
		links.add(apiLinks.linkToLivrosRegistrar(uriInfo));
		links.add(apiLinks.linkToLivrosExcluir(livro.getId(), uriInfo));
		
		if(livro.getCliente() != null) {
			return new LivroResponse(				
					volumeInfoResponse,
					clienteRecordAssembler.toResumoResponse(livro.getCliente()),
					links
					);
		}else {
			ClienteResumoResponse cliente = new ClienteResumoResponse(null,null);
			return new LivroResponse(				
					volumeInfoResponse,
					cliente,
					links
					);
		}
		
	}
	
	public List<LivroResponse> toCollectionResponse(List<Livro> livros, UriInfo uriInfo){
		return livros.stream()
				.map(livro -> toResponse(livro, uriInfo))
				.collect(Collectors.toList());
	}
	
}
