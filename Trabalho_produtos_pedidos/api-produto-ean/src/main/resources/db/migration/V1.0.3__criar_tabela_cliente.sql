CREATE TABLE cliente (
	codigo_cliente BIGINT PRIMARY KEY IDENTITY,
	nome VARCHAR(100) NOT NULL,
	email VARCHAR(100) UNIQUE NOT NULL
);
