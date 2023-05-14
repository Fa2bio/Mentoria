CREATE TABLE transferencia(
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	data_transferencia TIMESTAMP NOT NULL,
	valor DECIMAL(10,2) NOT NULL, 
	tipo VARCHAR(15) NOT NULL,
	nome_operador_transacao VARCHAR(100),
	conta_id BIGINT NOT NULL,

	CONSTRAINT fk_conta FOREIGN KEY(conta_id) REFERENCES conta(id_conta)
);