INSERT INTO categoria (nome) VALUES ('ENTRADA');
INSERT INTO categoria (nome) VALUES ('SAIDA');

INSERT INTO pessoa (nome, data_aniversario, tipo_sanguineo, endereco, cpf)
VALUES ('Maria dos Santos', '2000-01-10', 'A+', 'Avenida do Brasil', '509.282.630-45');

INSERT INTO pessoa (nome, data_aniversario, tipo_sanguineo, endereco, cpf)
VALUES ('João da Silva', '1965-06-20', 'A-', 'Avenida das Américas', '890.940.110-93');

INSERT INTO produto (descricao,unidade_medida,data_vencimento)
VALUES ('Refrigerante coca-cola','UN','2023-06-15');

INSERT INTO produto (descricao,unidade_medida,data_vencimento)
VALUES ('Carne bovina costela ripa','KG','2023-04-20');

INSERT INTO venda (quantidade, valor_total, unidade_medida, data_venda, codigo_produto)
VALUES (10.000, 380.00, 'UN', '2023-04-10', 1);

INSERT INTO venda (quantidade, valor_total, unidade_medida, data_venda, codigo_produto)
VALUES (12.500, 420.00, 'KG', '2023-04-12', 2);

INSERT INTO venda (quantidade, valor_total, unidade_medida, data_venda, codigo_produto)
VALUES (12.500, 420.00, 'UN', '2023-04-12', 1);