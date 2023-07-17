insert into fornecedor values (1, "Rafael Toledo", "Telefone: 552199999-9999, Email: rafael_toledo@teste.com");
insert into fornecedor values (2, "Fabiano Lima", "Telefone: 552191112-0022, Email: fabiano_lima@teste.com");

insert into produto values (1, "Shampoo Para Gatos", "Anti-pulga", 15.99, 30,1);
insert into produto values (2, "Shampoo Para Cães", "Anti-pulga", 18.99, 15,2);

insert into cliente values (1, "Rosa Maria", "Rua Augusta, 39, São Paulo, São Paulo", "552191313-1122");
insert into cliente values (2, "Paula Carvalho", "Rua Aleatoria, 40, Santos, São Paulo", "552190231-1057");

insert into servico values (1,"Tosa", 39.90, "00:10:00.00", true);
insert into servico values (2,"Banho", 29.90, "00:15:00.00", true);

insert into compras values (1,"2023-01-05", 1,1,null);
insert into compras values (2,"2023-02-10", 2,1,null);
insert into compras values (3,"2022-12-08", 2,2,null);
insert into compras values (4,"2022-12-08", null,2,1);
insert into compras values (5,"2022-12-08", null,1,2);