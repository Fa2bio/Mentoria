CREATE TABLE aluno(
	cod_mat BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    endereco VARCHAR(1000) NOT NULL,
	cidade VARCHAR(100) NOT NULL
);

CREATE TABLE disciplina(
	cod_disc VARCHAR(5) PRIMARY KEY NOT NULL,
    nome VARCHAR(50) NOT NULL,
    carga_hor BIGINT NOT NULL
);

CREATE TABLE professor(
	cod_prof BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
    endereco VARCHAR(1000) NOT NULL,
	cidade VARCHAR(100) NOT NULL
);

CREATE TABLE turma(
	cod_turma BIGINT PRIMARY KEY NOT NULL,
    cod_disc VARCHAR(5) NOT NULL,
    cod_prof BIGINT NOT NULL,
    ano BIGINT NOT NULL,
    horario VARCHAR(8) NOT NULL,
    
	CONSTRAINT fk_turma_disciplina FOREIGN KEY (cod_disc) REFERENCES disciplina(cod_disc),
    CONSTRAINT fk_turma_professor FOREIGN KEY (cod_prof) REFERENCES professor(cod_prof)
);

CREATE TABLE historico(
	cod_historico BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    cod_mat BIGINT NOT NULL,
    cod_turma BIGINT NOT NULL,
    frequencia BIGINT NOT NULL,
    nota DECIMAL(10,2),
    
	CONSTRAINT fk_historico_aluno FOREIGN KEY (cod_mat) REFERENCES aluno(cod_mat),
    CONSTRAINT fk_historico_turma FOREIGN KEY (cod_turma) REFERENCES turma(cod_turma)
);