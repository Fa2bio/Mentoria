package org.edu.unidep.domain.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.edu.unidep.api.dto.record.model.LivroModel;
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
	
	public List<Livro> listarTodosLivros(){
		return livroRepository.listar();
	}
	
	public Livro buscarLivroPorId(Long id) {
		return buscarOuFalhar(id);
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
