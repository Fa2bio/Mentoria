package org.edu.unidep.api.dto.record.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.UriInfo;

import org.edu.unidep.api.dto.modelmapper.assembler.PedidoAssembler;
import org.edu.unidep.api.dto.record.response.EnderecoResponse;
import org.edu.unidep.api.dto.record.response.FuncionarioResponse;
import org.edu.unidep.api.hypermedia.ApiLinks;
import org.edu.unidep.domain.model.Funcionario;

@ApplicationScoped
public class FuncionarioAssembler {

	@Inject
	private ClienteRecordAssembler clienteRecordAssembler;
	
	@Inject
	private PedidoAssembler pedidoAssembler;
	
	@Inject
	private ApiLinks apiLinks;
	
	public FuncionarioResponse toResponse(Funcionario funcionario, UriInfo uriInfo) {
		
		EnderecoResponse enderecoResponse = new EnderecoResponse(
				funcionario.getEndereco().getCep(),
				funcionario.getEndereco().getBairro(),
				funcionario.getEndereco().getLocalidade(),
				funcionario.getEndereco().getLogradouro(),
				funcionario.getEndereco().getComplemento()
				);
		
		List<Link> links = new ArrayList<>();
		links.add(apiLinks.linkToFuncionariosListar(uriInfo));
		links.add(apiLinks.linkToFuncionariosBuscar(uriInfo, funcionario.getId()));
		links.add(apiLinks.linkToFuncionariosAtualizar(uriInfo, funcionario.getId()));
		links.add(apiLinks.linkToFuncionariosRegistrar(uriInfo));
		links.add(apiLinks.linkToFuncionariosExcluir(uriInfo, funcionario.getId()));
		
		return new FuncionarioResponse(
				funcionario.getNome(),
				funcionario.getCpf(),
				enderecoResponse,
				clienteRecordAssembler.toCollectionResumoResponse(funcionario.getClientes()),
				pedidoAssembler.toCollectionResumoResponse(funcionario.getPedidos()),
				links
				);
	}
	
	
	public List<FuncionarioResponse> toCollectionResponse(List<Funcionario> funcionarios, UriInfo uriInfo){
		return funcionarios.stream()
				.map(funcionario -> toResponse(funcionario, uriInfo))
				.collect(Collectors.toList());
	}
}
