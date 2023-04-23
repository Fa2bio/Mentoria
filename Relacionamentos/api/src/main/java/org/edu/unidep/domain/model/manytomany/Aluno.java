package org.edu.unidep.domain.model.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import io.smallrye.common.constraint.NotNull;

@Entity
@Table(name = "aluno")
public class Aluno {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @NotNull
    @Column(name = "nome", length = 100)
	private String nome;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "aluno_curso", joinColumns = @JoinColumn(name = "aluno_id"),
    		inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private List<Curso> cursos = new ArrayList<>();
    
    public void addCurso(Curso curso) {
    	this.cursos.add(curso);
    	curso.getAlunos().add(this);
    }
    
    public void delCurso(Curso curso) {
    	this.cursos.remove(curso);
    	curso.getAlunos().remove(this);
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

}
