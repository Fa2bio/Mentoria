package org.edu.unidep.domain.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.edu.unidep.domain.exception.LivroNaoEncontradoException;
import org.edu.unidep.domain.model.Livro;
import org.edu.unidep.domain.repository.LivroRepository;

@ApplicationScoped
public class LivroService {

	@Inject
	private LivroRepository livroRepository;
	
	public List<Livro> listarTodosLivros(){
		return livroRepository.listar();
	}
	
	public Livro buscarLivroPorId(Long id) {
		return buscarOuFalhar(id);
	}
	
	@Transactional
	public void salvarLivro(Livro Livro) {
		livroRepository.salvar(Livro);
	}
	
	@Transactional
	public void atualizarLivro(Long livroId, Livro livroAtualizado) {
		Livro livroEncontrado = buscarOuFalhar(livroId);
		livroEncontrado.setIsbn(livroAtualizado.getIsbn());
		livroEncontrado.setVolumeInfo(livroAtualizado.getVolumeInfo());
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
