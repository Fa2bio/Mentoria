package org.edu.unidep.domain.service.manytomany;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.edu.unidep.domain.exception.manytomany.AlunoNaoEncontradoException;
import org.edu.unidep.domain.model.manytomany.Aluno;
import org.edu.unidep.domain.model.manytomany.Curso;
import org.edu.unidep.domain.repository.manytomany.AlunoRepository;

@ApplicationScoped
public class AlunoService {

	@Inject
	private AlunoRepository alunoRepository;
	
	@Inject
	private CursoService cursoService;
	
	public Aluno acharOuFalhar(Long id) {
		return alunoRepository.buscarAlunoPorId(id)
				.orElseThrow(()-> new AlunoNaoEncontradoException(id));
	}
	
	@Transactional
	public void registrar(Aluno aluno) {
		alunoRepository.salvar(aluno);
	}
	
	@Transactional
	public void excluirAluno(Long id) {		
		Aluno aluno = acharOuFalhar(id);
		alunoRepository.excluir(aluno);
	}
	
	@Transactional
	public void associarCurso(Long alunoId, Long cursoId) {
		Aluno aluno = acharOuFalhar(alunoId);
		Curso curso = cursoService.acharOuFalhar(cursoId);
		aluno.addCurso(curso);
	}
	
	@Transactional
	public void dissociarCurso(Long alunoId, Long cursoId) {
		Aluno aluno = acharOuFalhar(alunoId);
		Curso curso = cursoService.acharOuFalhar(cursoId);
		aluno.delCurso(curso);
	}
}
