SET FOREIGN_KEY_CHECKS = 0;

DELETE FROM cliente;
DELETE FROM funcionario;
DELETE FROM cliente_funcionario;
DELETE FROM livro;
DELETE FROM Livro_autores;

SET FOREIGN_KEY_CHECKS = 1;

ALTER TABLE cliente_funcionario AUTO_INCREMENT = 1;
ALTER TABLE livro AUTO_INCREMENT = 1;
ALTER TABLE Livro_autores AUTO_INCREMENT = 1;

INSERT INTO cliente (id, nome, cpf, endereco_cep,endereco_bairro, endereco_localidade, endereco_logradouro, endereco_complemento)
VALUES(1,"Fabio", "419.797.000-52","20.090-907","Copacabana","Rio De Janeiro","Av Nossa Senhora de Copacabana","apt 3001");

INSERT INTO cliente(id, nome, cpf, endereco_cep, endereco_bairro, endereco_localidade, endereco_logradouro, endereco_complemento)
VALUES(2,"Rosangela", "029.339.800-37","20.040-906","Centro","Rio De Janeiro","Avenida Rio Branco","Lado ímpar");

INSERT INTO cliente(id, nome, cpf, endereco_cep, endereco_bairro, endereco_localidade, endereco_logradouro, endereco_complemento)
VALUES(3,"Pedro", "870.269.330-51","20.040-972","Centro","Rio De Janeiro","Avenida Rio Branco","156");

INSERT INTO funcionario(id, nome, cpf, endereco_cep, endereco_bairro, endereco_localidade, endereco_logradouro, endereco_complemento)
VALUES(1,"Paulo", "363.123.030-39","20.251-901","Rio Comprido", "Rio de Janeiro", "Rua Itapiru","151");

INSERT INTO funcionario(id, nome, cpf, endereco_cep, endereco_bairro, endereco_localidade, endereco_logradouro, endereco_complemento)
VALUES(2,"Roberto", "030.251.600-04","20.010-974","Centro", "Rio de Janeiro", "Rua Primeiro de Março","64");

INSERT INTO funcionario(id, nome, cpf, endereco_cep, endereco_bairro, endereco_localidade, endereco_logradouro, endereco_complemento)
VALUES(3,"Caludio", "070.719.400-88","20.031-923","Centro", "Rio de Janeiro", "Rua Senador Dantas","250");

INSERT INTO cliente_funcionario(id, funcionario_id, cliente_id) VALUES(1,1,1);
INSERT INTO cliente_funcionario(id, funcionario_id, cliente_id) VALUES(2,1,2);
INSERT INTO cliente_funcionario(id, funcionario_id, cliente_id) VALUES(3,2,1);

INSERT INTO livro(id, isbn_10, isbn_13, titulo,data_publicacao, descricao, lingua, qtdPags, cliente_id) 
VALUES(1,"8535914846","0000000000000","1984","21-06-2009","Winston, herói de 1984, último romance de George Orwell","pt-BR", 400,1);

INSERT INTO livro(id, isbn_10, isbn_13, titulo,data_publicacao, descricao, lingua, qtdPags, cliente_id) 
VALUES(2,"8535909559","0000000000000","Fazenda Dos Animais","18-05-2009","Depois das profundas transformações políticas que mudaram a fisionomia do planeta nas últimas décadas","pt-BR", 200,2);

INSERT INTO livro(id, isbn_10, isbn_13, titulo,data_publicacao, descricao, lingua, qtdPags, cliente_id) 
VALUES(3,"8594318596","0000000000000","Arte da Guerra","10-09-2005	","A guerra é um assunto de importância vital para o Estado; o reino da vida ou da morte; o caminho para a sobrevivência ou a ruína. É indispensável estudá-la profundamente. Sun Tzu","pt-BR", 150,2);

INSERT INTO Livro_autores(Livro_id, autores) VALUES(1,"George Orwell");
INSERT INTO Livro_autores(Livro_id, autores) VALUES(1,"Ruth Rendell");
INSERT INTO Livro_autores(Livro_id, autores) VALUES(2,"George Orwell");
INSERT INTO Livro_autores(Livro_id, autores) VALUES(3,"Sun Tzu");
