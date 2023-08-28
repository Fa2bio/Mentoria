package org.edu.unidep.domain.service;

import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.edu.unidep.api.dto.record.model.LivroModel;
import org.edu.unidep.api.dto.record.request.LivroRequest;
import org.edu.unidep.domain.exception.LivroNaoEncontradoException;
import org.edu.unidep.domain.model.Livro;
import org.edu.unidep.domain.model.VolumeInfo;
import org.edu.unidep.domain.repository.LivroRepository;

@ApplicationScoped
public class LivroService {

	@Inject
	private LivroRepository livroRepository;
	
	@Inject
	private IsbnService isbnService;
	
	@Inject
	private Validator validator;
	
	public void validarLivroRequest(LivroRequest livroRequest) {
		Set<ConstraintViolation<LivroRequest>> constraintViolations = validator.validate(livroRequest);
		if(constraintViolations.isEmpty()) return;
		else throw new ConstraintViolationException(constraintViolations);
	}
	
	public List<Livro> listarTodosLivros(){
		return livroRepository.listar();
	}
	
	@Transactional
	public void salvarLivro(LivroModel livroModel) {
		Livro livro = new Livro();
		VolumeInfo volumeInfo = isbnService.gerarVolumeInfo(livroModel.isbn());
		livro.setVolumeInfo(volumeInfo);
		livroRepository.salvar(livro);
	}
	
	@Transactional
	public void atualizarLivro(Long livroId, LivroModel livroAtualizado) {
		Livro livroEncontrado = buscarOuFalhar(livroId);
		VolumeInfo volumeInfo = isbnService.gerarVolumeInfo(livroAtualizado.isbn());
		livroEncontrado.setVolumeInfo(volumeInfo);
	}
	
	@Transactional
	public void excluirLivro(Long id) {
		Livro LivroEncontrado = buscarOuFalhar(id);
		livroRepository.deletar(LivroEncontrado);
	}
	
	public Livro buscarOuFalhar(Long id) {
		return livroRepository.buscarPorId(id)
				.orElseThrow(() -> new LivroNaoEncontradoException(id));
	}
}
