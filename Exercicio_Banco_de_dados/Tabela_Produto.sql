CREATE DATABASE aula_bd;
USE aula_bd;

CREATE TABLE produto(
	id_nf BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_item BIGINT NOT NULL,
    cod_prod BIGINT NOT NULL,
    valor_unit DECIMAL(10,2) NOT NULL,
    quantidade BIGINT NOT NULL,
	desconto BIGINT DEFAULT NULL
);