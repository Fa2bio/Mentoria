package org.edu.unidep.domain.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.edu.unidep.domain.exception.NegocioException;
import org.edu.unidep.domain.exception.PessoaNaoEncontradaException;
import org.edu.unidep.domain.model.Endereco;
import org.edu.unidep.domain.model.Pessoa;
import org.edu.unidep.domain.model.PessoaViaCep;
import org.edu.unidep.domain.repository.PessoaRepository;

import com.google.gson.Gson;

@ApplicationScoped
public class PessoaService {

	@Inject
	private PessoaRepository pessoaRepository;
	
	@Transactional
	public void registrar(Pessoa pessoa) {
		pessoaRepository.salvar(pessoa);
	}
	
    @Transactional
    public Pessoa atualizar(Long id, Pessoa pessoa) {
        Pessoa pessoaEncontrado = acharOuFalhar(id);
        pessoaEncontrado.setNome(pessoa.getNome());
        pessoaEncontrado.setSangue(pessoa.getSangue());
        pessoaEncontrado.setDataAniversario(pessoa.getDataAniversario());
        pessoaEncontrado.setEndereco(pessoa.getEndereco());

        return pessoaEncontrado;
    }
    
    @Transactional
    public void deletarPessoa(Long id) {
    	Pessoa pessoaEncontrado = acharOuFalhar(id);
    	pessoaRepository.deletar(pessoaEncontrado);
    }
    
    public Pessoa acharOuFalhar(Long id) {
    	return pessoaRepository.listarPessoaPeloCodigo(id)
    			.orElseThrow(()->new PessoaNaoEncontradaException(id));
    }
    
    public Pessoa viaCep(PessoaViaCep pessoaInput, String cep) {
    	try {
			URL url = new URL(String.format("https://viacep.com.br/ws/%s/json/", cep));
			URLConnection connection = url.openConnection();
			InputStream input = connection.getInputStream();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(input, "UTF-8"));
			StringBuilder jsonCep = new StringBuilder();
			
			String laco;
			while((laco = buffer.readLine())!=null){
				jsonCep.append(laco);
			}
			
			Gson gson = new Gson();	
			Endereco endereco = gson.fromJson(jsonCep.toString(), Endereco.class);

			if(endereco.getCep() == null) {
				throw new NegocioException(String.format("Não existe endereco para o cep %s", cep));	
			}
	
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(pessoaInput.getNome());
				pessoa.setDataAniversario(pessoaInput.getDataAniversario());
				pessoa.setSangue(pessoaInput.getSangue());
				pessoa.setEndereco(endereco);
				return pessoa;
			
		} catch (IOException e) {
			throw new NegocioException("O endereço não pode ser formado");
		}
    }
}
