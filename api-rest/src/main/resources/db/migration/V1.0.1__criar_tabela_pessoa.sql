CREATE TABLE pessoa (
	codigo_pessoa BIGINT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(80) NOT NULL,
	data_aniversario DATE,
    tipo_sanguineo VARCHAR(5),
    endereco VARCHAR(120)
);