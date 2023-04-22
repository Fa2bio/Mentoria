CREATE TABLE aluno_curso (
  aluno_id bigint NOT NULL,
  curso_id bigint NOT NULL,
  CONSTRAINT fk_aluno_curso_aluno FOREIGN KEY (aluno_id) REFERENCES aluno (id),
  CONSTRAINT fk_aluno_curso_curso FOREIGN KEY (curso_id) REFERENCES curso (id)
);