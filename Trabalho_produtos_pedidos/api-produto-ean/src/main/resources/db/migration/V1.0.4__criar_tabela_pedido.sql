CREATE TABLE pedido (
	codigo_pedido BIGINT PRIMARY KEY IDENTITY,
	data_emissao DATE NOT NULL,
	codigo_cliente BIGINT DEFAULT NULL,
	codigo_orcamento BIGINT DEFAULT NULL,
	
	CONSTRAINT fk_pedido_cliente FOREIGN KEY (codigo_cliente) REFERENCES cliente (codigo_cliente),
	CONSTRAINT fk_pedido_orcamento FOREIGN KEY (codigo_orcamento) REFERENCES orcamento (codigo_orcamento)
);
	