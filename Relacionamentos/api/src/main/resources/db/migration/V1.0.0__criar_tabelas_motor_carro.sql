CREATE TABLE motor (
  id bigint NOT NULL AUTO_INCREMENT,
  nome varchar(100) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE carro (
  id bigint NOT NULL AUTO_INCREMENT,
  modelo varchar(100),
  motor_id bigint,
  PRIMARY KEY (id),
  CONSTRAINT fk_carro_motor FOREIGN KEY (motor_id) REFERENCES motor (id)
);