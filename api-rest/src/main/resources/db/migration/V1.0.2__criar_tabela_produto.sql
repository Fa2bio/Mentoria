CREATE TABLE produto (
	codigo_produto BIGINT AUTO_INCREMENT PRIMARY KEY,
	descricao VARCHAR(80) NOT NULL,
	unidade_medida VARCHAR(4) NOT NULL,
	data_vencimento DATE
);