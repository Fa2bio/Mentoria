CREATE TABLE produto (
	codigo_produto BIGINT PRIMARY KEY IDENTITY,
	nome VARCHAR(100) NOT NULL,
	categoria VARCHAR(100) NOT NULL,
	codigo_ean VARCHAR(13) NOT NULL,
	data_validade DATE NOT NULL
);