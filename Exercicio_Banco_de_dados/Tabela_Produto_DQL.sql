SELECT * FROM produto;

SELECT p.id_nf, p.id_item, p.cod_prod, p.valor_unit 
FROM produto as p;

SELECT p.id_nf, p.id_item, p.cod_prod, p.valor_unit, ROUND(SUM(p.valor_unit - (p.valor_unit*(p.desconto/100))),2) AS valor_vedido 
FROM produto as p 
GROUP BY p.id;

UPDATE produto set desconto=0 WHERE desconto is null;
