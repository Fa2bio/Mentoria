package org.edu.unidep.domain.model.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import io.smallrye.common.constraint.NotNull;

@Entity
@Table(name = "curso")
public class Curso {	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @NotNull
    @Column(name = "nome", length = 100)
	private String nome;

    @ManyToMany(mappedBy = "cursos", cascade = CascadeType.ALL)
    private List<Aluno> alunos = new ArrayList<>();
    
    public void addAluno(Aluno aluno) {
    	this.alunos.add(aluno);
    	aluno.getCursos().add(this);
    }
    
    public void delAluno(Aluno aluno) {
    	this.alunos.add(aluno);
    	aluno.getCursos().remove(this);
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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
 
}
