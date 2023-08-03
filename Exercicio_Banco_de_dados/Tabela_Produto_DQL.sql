SELECT * FROM produto_nf_nf;

SELECT p.id_nf, p.id_item,p.cod_prod,p.valor_unit
FROM produto_nf_nf AS p
WHERE desconto is null;

SELECT p.id_nf, p.id_item,p.cod_prod,p.valor_unit,
ROUND(SUM(p.valor_unit - (p.valor_unit*(p.desconto/100))),2) AS valor_vendido
FROM produto_nf_nf AS p
WHERE desconto is not null
GROUP BY p.id;

UPDATE produto_nf set desconto=0 WHERE desconto is null;

SELECT p.id_nf, p.id_item, p.cod_prod, p.valor_unit,p.desconto,
ROUND(SUM(p.valor_unit - (p.valor_unit*(p.desconto/100))),2) AS valor_vendido,
ROUND(SUM(p.quantidade * p.valor_unit),2) AS valor_total
FROM produto_nf as p
GROUP BY p.id;

SELECT p.id_nf,
ROUND(SUM(p.quantidade * p.valor_unit)) AS valor_total
FROM produto_nf as p
GROUP BY p.id_nf
ORDER BY valor_total DESC;

SELECT p.id_nf,
ROUND(SUM(p.quantidade * p.valor_unit)) AS valor_total,
ROUND(SUM((p.valor_unit - (p.valor_unit*(p.desconto/100)))*p.quantidade),2) AS valor_vendido
FROM produto_nf as p
GROUP BY p.id_nf
ORDER BY valor_total DESC;

SELECT p.cod_prod, MAX(p.quantidade) AS mais_vendidos
FROM produto_nf AS p
GROUP BY p.cod_prod
ORDER BY mais_vendidos DESC;

SELECT * FROM produto_nf;

SELECT p.id_nf, p.cod_prod
FROM produto_nf AS p
WHERE p.quantidade > 10
GROUP BY p.id_nf, p.cod_prod;

SELECT p.id_nf,
ROUND(SUM(p.quantidade * p.valor_unit),2) AS valor_total
FROM produto_nf AS p
GROUP BY p.id_nf
HAVING valor_total>200;

SELECT p.cod_prod, 
ROUND(AVG(p.desconto),2) AS media
FROM produto_nf AS p
GROUP BY p.cod_prod;

SELECT p.cod_prod,
MIN(p.desconto) AS menor_desconto,
MAX(p.desconto) AS maior_desconto,
ROUND(AVG(p.desconto),2) AS media
FROM produto_nf AS p
GROUP BY p.cod_prod;

SELECT p.id_nf,
COUNT(p.id_item) AS qtd_itens
FROM produto_nf AS p
GROUP BY p.id_nf
HAVING qtd_itens >= 3;
