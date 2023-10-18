CREATE TABLE cliente(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    endereco_cep VARCHAR(10) NOT NULL,
    endereco_bairro VARCHAR(255) NOT NULL,
	endereco_localidade VARCHAR(255) NOT NULL,
	endereco_logradouro VARCHAR(255) NOT NULL,
    endereco_complemento VARCHAR(255) NOT NULL
);

CREATE TABLE funcionario(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    endereco_cep VARCHAR(10) NOT NULL,
    endereco_bairro VARCHAR(255) NOT NULL,
	endereco_localidade VARCHAR(255) NOT NULL,
	endereco_logradouro VARCHAR(255) NOT NULL,
    endereco_complemento VARCHAR(255) NOT NULL
);

CREATE TABLE cliente_funcionario(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    funcionario_id BIGINT NOT NULL,
    cliente_id BIGINT NOT NULL,
    
    CONSTRAINT cliente_funcionario_cliente
    FOREIGN KEY (funcionario_id)
    REFERENCES funcionario(id),
    
    CONSTRAINT cliente_funcionario_funcionario
    FOREIGN KEY (cliente_id)
    REFERENCES cliente(id)
);

CREATE TABLE livro(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    isbn VARCHAR(13) NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    data_publicacao VARCHAR(10) NOT NULL,
    descricao VARCHAR(10000) NOT NULL,
    lingua VARCHAR(255) NOT NULL,
    qtdPags BIGINT NOT NULL,
    cliente_id BIGINT NOT NULL,
    
    CONSTRAINT livro_cliente
    FOREIGN KEY (cliente_id)
    REFERENCES cliente(id)
);