CREATE TABLE pedido(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	codigo_pedido VARCHAR(36) NOT NULL,
	data_emissao DATETIME NOT NULL,
	valor DECIMAL(10,2) NOT NULL,
	cliente_id BIGINT NOT NULL,
	funcionario_id BIGINT NOT NULL,
	
	CONSTRAINT pedido_cliente
	FOREIGN KEY(cliente_id)
	REFERENCES cliente(id),
	
	CONSTRAINT pedido_funcionario
	FOREIGN KEY(funcionario_id)
	REFERENCES funcionario(id)
);

CREATE TABLE item(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	quantidade INT NOT NULL,
	valor_total DECIMAL(10,2) NOT NULL,
	valor_unitario DECIMAL(10,2) NOT NULL,
	livro_id BIGINT NOT NULL,
	pedido_id BIGINT NOT NULL,	
	
	CONSTRAINT item_livro
	FOREIGN KEY(livro_id)
	REFERENCES livro(id),
	
	CONSTRAINT item_pedido
	FOREIGN KEY(pedido_id)
	REFERENCES pedido(id)
);