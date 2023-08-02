SELECT * FROM produto;

SELECT p.id_nf, p.id_item, p.cod_prod, p.valor_unit 
FROM produto as p;

SELECT p.id_nf, p.id_item, p.cod_prod, p.valor_unit,
ROUND(SUM(p.valor_unit - (p.valor_unit*(p.desconto/100))),2) AS valor_vendido 
FROM produto as p 
GROUP BY p.id;

UPDATE produto set desconto=0 WHERE desconto is null;

SELECT p.id_nf, p.id_item, p.cod_prod, p.valor_unit,p.desconto,
ROUND(SUM(p.valor_unit - (p.valor_unit*(p.desconto/100))),2) AS valor_vendido,
ROUND(SUM(p.quantidade * p.valor_unit),2) AS valor_total
FROM produto as p 
GROUP BY p.id;

SELECT p.id_nf,
ROUND(SUM(p.quantidade * p.valor_unit)) AS valor_total
FROM produto as p
GROUP BY p.id_nf
ORDER BY valor_total DESC;

SELECT p.id_nf,
ROUND(SUM(p.quantidade * p.valor_unit)) AS valor_total,
ROUND(SUM((p.valor_unit - (p.valor_unit*(p.desconto/100)))*p.quantidade),2) AS valor_vendido
FROM produto as p
GROUP BY p.id_nf
ORDER BY valor_total DESC;

SELECT p.cod_prod, MAX(p.quantidade) 
FROM produto AS p 
GROUP BY p.cod_prod
ORDER BY valor_total DESC;