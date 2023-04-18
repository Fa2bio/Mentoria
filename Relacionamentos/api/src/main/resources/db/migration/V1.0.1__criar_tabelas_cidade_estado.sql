CREATE TABLE estado (
  id bigint NOT NULL AUTO_INCREMENT,
  nome varchar(100) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE cidade (
  id bigint NOT NULL AUTO_INCREMENT,
  nome varchar(100) DEFAULT NULL,
  estado_id bigint DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_cidade_estado FOREIGN KEY (estado_id) REFERENCES estado (id)
);