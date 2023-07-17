CREATE TABLE venda (
	codigo_venda BIGINT IDENTITY(1,1) PRIMARY KEY,
	quantidade DECIMAL(10,3) NOT NULL,
	valor_total DECIMAL(15,2),
	unidade_medida VARCHAR(80),
	data_venda DATE,
	codigo_produto BIGINT NOT NULL,
	CONSTRAINT fk_venda_produto
    		FOREIGN KEY (codigo_produto)
    		REFERENCES produto (codigo_produto)
);