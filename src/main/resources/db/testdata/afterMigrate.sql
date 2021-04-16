set foreign_key_checks = 0;

delete from usuario_permissao;
delete from tarefa;
delete from usuario;
delete from permissao;

set foreign_key_checks = 1;

alter table tarefa auto_increment = 1;
alter table usuario auto_increment = 1;
alter table permissao auto_increment = 1;

insert into usuario (id, nome, email, senha) values (1, 'Administrador', 'admin@admin.com.br', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
insert into usuario (id, nome, email, senha) values (2, 'Wallace Lima', 'wallacereislima@gmail.com', '$2a$04$6BVv4FyZkiXEvjZ88GKn9OtBto/KY.cCUlT4fGC17P3OB1g/9nNTi');
insert into usuario (id, nome, email, senha) values (3, 'Marcela Campos', 'marcelacampos@gmail.com', '$2a$04$6TYU2rvFc94ESphEyt9sCeEFHZAIMj7XG8F.Tg1eRLJpzitWJyvN6');

insert into permissao (id, descricao) values (1, 'ROLE_ADMINISTRADOR');
insert into permissao (id, descricao) values (2, 'ROLE_CADASTRAR_TAREFA');
insert into permissao (id, descricao) values (3, 'ROLE_REMOVER_TAREFA');
insert into permissao (id, descricao) values (4, 'ROLE_PESQUISAR_TAREFA');

-- administrador
insert into usuario_permissao (id_usuario, id_permissao) values (1, 1);

-- wallace
insert into usuario_permissao (id_usuario, id_permissao) values (2, 2);
insert into usuario_permissao (id_usuario, id_permissao) values (2, 3);
insert into usuario_permissao (id_usuario, id_permissao) values (2, 4);

-- marcela
insert into usuario_permissao (id_usuario, id_permissao) values (3, 2);
insert into usuario_permissao (id_usuario, id_permissao) values (3, 3);
insert into usuario_permissao (id_usuario, id_permissao) values (3, 4);

-- tarefas wallace
insert into tarefa (id, id_usuario, data_inclusao, resumo, descricao, status, data_alteracao) values (1, 2, now(), 'Lavar o carro', 'Lavar o carro por dentro e por fora', 'PENDENTE', now());
insert into tarefa (id, id_usuario, data_inclusao, resumo, descricao, status, data_alteracao) values (2, 2, now(), 'Arrumar a casa', 'Arrumar toda a casa', 'PENDENTE', now());
insert into tarefa (id, id_usuario, data_inclusao, resumo, descricao, status, data_alteracao) values (3, 2, now(), 'Estudar', 'Estudar para a prova da faculdade', 'COMPLETA', now());

-- tarefas marcela
insert into tarefa (id, id_usuario, data_inclusao, resumo, descricao, status, data_alteracao) values (4, 3, now(), 'Escrever artigo', 'Escrever artigo para meu blog', 'PENDENTE', now());
insert into tarefa (id, id_usuario, data_inclusao, resumo, descricao, status, data_alteracao) values (5, 3, now(), 'Comprar presentes', 'Comprar presentes de natal para a familia', 'PENDENTE', now());
insert into tarefa (id, id_usuario, data_inclusao, resumo, descricao, status, data_alteracao) values (6, 3, now(), 'Entregar pesquisa', 'Entegar a pesquisa do mestrado', 'COMPLETA', now());