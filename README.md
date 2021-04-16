# TODO-LIST API 

API RESTful para controle de tarefas.

## API endpoints

```shell
POST http://localhost:8080/oauth/token [obter token de autenticação]

GET http://localhost:8080/tarefas?usuarioId=2 [retorna a lista de tarefas do usuário]
GET http://localhost:8080/tarefas?usuarioId=2&status=PENDENTE [retorna a lista de tarefas do usuário filtrando pelo status]
GET http://localhost:8080/tarefas/1 [busca uma tarefa pelo id]
POST http://localhost:8080/tarefas [cria uma nova tarefa]
DELETE http://localhost:8080/tarefas [exclui uma tarefa]
PUT http://localhost:8080/tarefas/1 [atualiza uma tarefa]
```

## Pré-requisitos

Para compilar e executar a aplicação localmente você vai precisar:

- [JDK 1.8](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html)
- [MySQL 8.0](https://dev.mysql.com/downloads/mysql/)
- [Spring Tools](https://spring.io/tools) (recomendado)
- [Lombok](https://projectlombok.org/download)

## Configuração

Faça o clone do projeto:

```shell
git clone https://github.com/wallacerlima/todo-list-api.git
```

Alterar o arquivo application.properties do projeto com as informações de conexão do banco de dados.

```shell
spring.datasource.url=jdbc:mysql://{SEU_HOST}:{SUA_PORTA}/simians?createDatabaseIfNotExist=true
spring.datasource.username={SEU_USUARIO}
spring.datasource.password={SUA_SENHA}
```

Para compilar o projeto:
```shell
mvn spring-boot:run
```

Para executar o projeto:
```shell
mvn spring-boot:run
```
