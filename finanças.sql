CREATE DATABASE financas
GO 
USE financas
/*
CREATE TABLE renda
(
 id INT IDENTITY NOT NULL,
 valor FLOAT NOT NULL,
 data_renda VARCHAR(10) NOT NULL,
 descricao VARCHAR(60),
 PRIMARY KEY(id)
)
CREATE TABLE despesa
(
 id INT IDENTITY(10000, 1) NOT NULL,
 valor FLOAT NOT NULL,
 data_despesa VARCHAR(10) NOT NULL,
 descricao VARCHAR(60),
 parcela INT NOT NULL,
 PRIMARY KEY(id)
)
*/

INSERT INTO renda VALUES
(1138.69, '16/12/2017', 'Valor em conta')

INSERT INTO despesa VALUES
(379.21, '16/12/2017', 'NuBank', 2)

SELECT * FROM despesa
SELECT * FROM renda

SELECT positivo-negativo AS saldo from (SELECT SUM(renda.valor) AS positivo FROM renda) renda, (SELECT SUM(despesa.valor) AS negativo FROM despesa)  despesa

select sum(valor) from renda


SELECT CASE WHEN (SUM(renda.valor) > 0) 
THEN  (SELECT positivo-negativo FROM (SELECT SUM(renda.valor) AS positivo FROM renda)renda, (SELECT SUM(despesa.valor) AS negativo FROM despesa)despesa)
ELSE 0.0 END / 5 AS limite FROM renda, despesa

SELECT CASE WHEN (SUM(renda.valor) > 0) 
THEN CASE WHEN(SUM(despesa.valor) > 0)
	THEN (SELECT positivo-negativo FROM (SELECT SUM(renda.valor) AS positivo FROM renda)renda, (SELECT SUM(despesa.valor) AS negativo FROM despesa)despesa)
ELSE SUM(renda.valor) END
ELSE 0.0 END FROM renda, despesa


SELECT id, valor, descricao, data_despesa FROM despesa



SELECT valor, data_despesa, descricao FROM despesa ORDER BY data_despesa DESC












SELECT CASE WHEN (positivo IS NOT NULL)
THEN CASE WHEN (negativo IS NOT NULL) THEN positivo - negativo 
ELSE positivo END ELSE 0.0 END AS saldo 
FROM (SELECT SUM(renda.valor) AS positivo FROM renda)renda, (SELECT SUM(despesa.valor) AS negativo FROM despesa)despesa
