CREATE DATABASE trabalho_ads;
USE trabalho_ads;

create table fornecedor(
	codigo_fornecedor BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    info_contato VARCHAR(1000) NOT NULL,
    
    PRIMARY KEY (codigo_fornecedor)
);

create table produto(
	codigo_produto BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(1000) NOT NULL,
	preco DECIMAL(10,2) NOT NULL,
    estoque_disponivel BIGINT NOT NULL,
    fornecedor_id BIGINT NOT NULL,
    
    PRIMARY KEY (codigo_produto),
    CONSTRAINT fk_produto_fornecedor FOREIGN KEY (fornecedor_id) REFERENCES fornecedor (codigo_fornecedor)
);

create table cliente(
	codigo_cliente BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(1000) NOT NULL,
    telefone VARCHAR(16) NOT NULL,
    
    PRIMARY KEY (codigo_cliente)
);

create table servico(
	codigo_servico BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    duracao TIME NOT NULL,
	disponibilidade TINYINT,
    
    PRIMARY KEY (codigo_servico)
);

create table compras(
	codigo_compra BIGINT NOT NULL AUTO_INCREMENT,
    data_compra DATE NOT NULL,
    produto_codigo BIGINT,
    cliente_codigo BIGINT NOT NULL,
    servico_codigo BIGINT,
    
    PRIMARY KEY (codigo_compra),
    CONSTRAINT fk_compras_produto FOREIGN KEY (produto_codigo) REFERENCES produto (codigo_produto),
    CONSTRAINT fk_compras_cliente FOREIGN KEY (cliente_codigo) REFERENCES cliente (codigo_cliente),
    CONSTRAINT fk_compras_servico FOREIGN KEY (servico_codigo) REFERENCES servico (codigo_servico)
);

