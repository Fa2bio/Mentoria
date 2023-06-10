CREATE TABLE item (
	codigo_item BIGINT PRIMARY KEY IDENTITY,
	quantidade INT NOT NULL,
	valor_unitario DECIMAL(10,2) NOT NULL,
	valor_total DECIMAL(10,2) NOT NULL,	
	produto_codigo_produto BIGINT DEFAULT NULL,
	codigo_orcamento BIGINT DEFAULT NULL,
	
	CONSTRAINT fk_item_produto FOREIGN KEY (produto_codigo_produto) REFERENCES produto (codigo_produto),
	CONSTRAINT fk_item_orcamento FOREIGN KEY (codigo_orcamento) REFERENCES orcamento (codigo_orcamento)
);
	