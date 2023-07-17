CREATE TABLE pessoa (
	codigo_pessoa BIGINT IDENTITY(1,1) PRIMARY KEY,
	nome VARCHAR(80) NOT NULL,
	data_aniversario DATE,
    tipo_sanguineo VARCHAR(5),
    endereco VARCHAR(120)
);