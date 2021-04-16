CREATE TABLE tarefa (
	id bigint(20) PRIMARY KEY auto_increment,
	data_inclusao datetime not null,
	resumo varchar(60) not null,
	descricao varchar(300) not null,
	status varchar(10) not null,
	data_alteracao datetime not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;