CREATE DATABASE trabalho_ads;
USE trabalho_ads;

create table fornecedor(
	id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    info_contato VARCHAR(1000) NOT NULL,
    
    PRIMARY KEY (id)
);

create table produto(
	id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(1000) NOT NULL,
	preco DECIMAL(10,2) NOT NULL,
    estoque_disponivel BIGINT NOT NULL,
    fornecedor_id BIGINT NOT NULL,
    
    PRIMARY KEY (id),
    CONSTRAINT fk_produto_fornecedor FOREIGN KEY (fornecedor_id) REFERENCES fornecedor (id)
);

create table cliente(
	id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(1000) NOT NULL,
    telefone VARCHAR(16) NOT NULL,
    
    PRIMARY KEY (id)
);

create table compras(
    data_compra DATE NOT NULL,
    produto_id BIGINT NOT NULL,
    cliente_id BIGINT NOT NULL,
    
    CONSTRAINT fk_compras_produto FOREIGN KEY (produto_id) REFERENCES produto (id),
    CONSTRAINT fk_compras_cliente FOREIGN KEY (cliente_id) REFERENCES cliente (id)
);

create table servico(
	id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    duracao TIME NOT NULL,
	disponibilidade TINYINT,
    
    PRIMARY KEY (id)
);