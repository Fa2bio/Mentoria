CREATE TABLE aluno (
  id bigint NOT NULL AUTO_INCREMENT,
  nome varchar(100) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE curso (
  id bigint NOT NULL AUTO_INCREMENT,
  nome varchar(100) DEFAULT NULL,
  PRIMARY KEY (id)
);