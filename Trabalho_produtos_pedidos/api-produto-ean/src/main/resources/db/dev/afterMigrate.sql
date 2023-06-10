INSERT INTO produto (nome, categoria, codigo_ean, data_validade)
VALUES ('Carne bovina costela ripa','Carne Bovina','7893480900013','2023-04-20');

INSERT INTO produto (nome, categoria, codigo_ean, data_validade)
VALUES ('Carne suína picanha','Carne Suína','7893480900020','2023-04-20');

INSERT INTO orcamento (data, data_validade, valor)
VALUES ('2023-04-20','2023-04-27',399.00);

INSERT INTO orcamento (data, data_validade, valor)
VALUES ('2023-03-20','2023-03-27',199.00);

INSERT INTO item (quantidade, valor_unitario, valor_total, produto_codigo_produto, codigo_orcamento)
VALUES (10,39.90,399.00,1,1);

insert into cliente(nome, email) values ('Rosangela','rosangela@teste.com');
insert into cliente(nome, email) values ('Maria','Maria@teste.com');

insert into pedido(data_emissao, codigo_cliente, codigo_orcamento) values ('2023-06-10',1,1);
insert into pedido(data_emissao, codigo_cliente, codigo_orcamento) values ('2023-06-10',2,2);
