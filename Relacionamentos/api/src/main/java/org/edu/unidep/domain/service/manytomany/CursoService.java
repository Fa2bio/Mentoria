package org.edu.unidep.domain.service.manytomany;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.edu.unidep.domain.exception.manytomany.CursoNaoEncontradoException;
import org.edu.unidep.domain.model.manytomany.Aluno;
import org.edu.unidep.domain.model.manytomany.Curso;
import org.edu.unidep.domain.repository.manytomany.CursoRepository;

@ApplicationScoped
public class CursoService {

	@Inject
	private CursoRepository cursoRepository;
	
	@Inject
	private AlunoService alunoService;
	
	public Curso acharOuFalhar(Long id) {
		return cursoRepository.buscarCursoPorId(id)
				.orElseThrow(()-> new CursoNaoEncontradoException(id));
	}
	
	@Transactional
	public void registrar(Curso curso) {
		cursoRepository.salvar(curso);
	}
	
	@Transactional
	public void excluirCurso(Long id) {		
		Curso curso = acharOuFalhar(id);
		cursoRepository.excluir(curso);
	}
	
	@Transactional
	public void associarAluno(Long cursoId, Long alunoId) {
		Curso curso = acharOuFalhar(cursoId);
		Aluno aluno = alunoService.acharOuFalhar(alunoId);
		curso.addAluno(aluno);
	}
	
	@Transactional
	public void dissociarAluno(Long cursoId, Long alunoId) {
		Curso curso = acharOuFalhar(cursoId);
		Aluno aluno = alunoService.acharOuFalhar(alunoId);
		curso.delAluno(aluno);
	}

}
