CREATE TABLE orcamento (
	codigo_orcamento BIGINT PRIMARY KEY IDENTITY,
	data DATE NOT NULL,
	data_validade DATE NOT NULL,
	valor DECIMAL(10,2) NOT NULL
);