ALTER TABLE tarefa 
ADD COLUMN id_usuario BIGINT(20) NOT NULL AFTER id;

ALTER TABLE tarefa ADD CONSTRAINT fk_tarefa_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id);