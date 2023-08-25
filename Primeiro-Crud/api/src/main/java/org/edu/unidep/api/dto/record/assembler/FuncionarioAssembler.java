package org.edu.unidep.api.dto.record.assembler;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.edu.unidep.api.dto.record.response.EnderecoResponse;
import org.edu.unidep.api.dto.record.response.FuncionarioResponse;
import org.edu.unidep.domain.model.Funcionario;

@ApplicationScoped
public class FuncionarioAssembler {

	@Inject
	private ClienteRecordAssembler clienteRecordAssembler;
	
	public FuncionarioResponse toResponse(Funcionario funcionario) {
		
		EnderecoResponse enderecoResponse = new EnderecoResponse(
				funcionario.getEndereco().getCep(),
				funcionario.getEndereco().getBairro(),
				funcionario.getEndereco().getLocalidade(),
				funcionario.getEndereco().getLogradouro(),
				funcionario.getEndereco().getComplemento()
				);
		
		return new FuncionarioResponse(
				funcionario.getNome(),
				funcionario.getCpf(),
				enderecoResponse,
				clienteRecordAssembler.toCollectionResumoResponse(funcionario.getClientes())
				);
	}
	
	
	public List<FuncionarioResponse> toCollectionResponse(List<Funcionario> funcionarios){
		return funcionarios.stream()
				.map(funcionario -> toResponse(funcionario))
				.collect(Collectors.toList());
	}
}
