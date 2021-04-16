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

- [JDK 11+](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
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
spring.datasource.url=jdbc:mysql://{SEU_HOST}:{SUA_PORTA}/todolistapi?createDatabaseIfNotExist=true&serverTimezone=UTC
spring.datasource.username={SEU_USUARIO}
spring.datasource.password={SUA_SENHA}
```

Para compilar o projeto:
```shell
mvn clean install
```

Para executar o projeto:
```shell
mvn spring-boot:run
```

## Exemplos em CURL:

Obter token:
```shell
curl --location --request POST 'http://localhost:8080/oauth/token' \
--header 'Authorization: Basic YXBwLXRvZG9saXN0OnNlbmhhYXBw' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'client=app-todolist' \
--data-urlencode 'username=wallacereislima@gmail.com' \
--data-urlencode 'password=wallace' \
--data-urlencode 'grant_type=password'
```

Obter lista de tarefas pendentes:
```shell
curl --location --request GET 'http://localhost:8080/tarefas?usuarioId=2&status=PENDENTE' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MTg1OTI3NTQsInVzZXJfbmFtZSI6IndhbGxhY2VyZWlzbGltYUBnbWFpbC5jb20iLCJhdXRob3JpdGllcyI6WyJST0xFX0NBREFTVFJBUl9UQVJFRkEiLCJST0xFX1BFU1FVSVNBUl9UQVJFRkEiLCJST0xFX1JFTU9WRVJfVEFSRUZBIl0sImp0aSI6IjQ1NDgzNWUwLWYxODEtNDg5MS1hYWNiLWQxMWMyM2ZkN2Q0ZiIsImNsaWVudF9pZCI6ImFwcC10b2RvbGlzdCIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdfQ.MM3vaR2ef7fEV1m8bY-EOtJ7m2TjSuyQTVAIgP_keGQ' \
--data-raw ''
```

Criar uma nova tarefa:
```shell
curl --location --request POST 'http://localhost:8080/tarefas' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MTg1OTI3NTQsInVzZXJfbmFtZSI6IndhbGxhY2VyZWlzbGltYUBnbWFpbC5jb20iLCJhdXRob3JpdGllcyI6WyJST0xFX0NBREFTVFJBUl9UQVJFRkEiLCJST0xFX1BFU1FVSVNBUl9UQVJFRkEiLCJST0xFX1JFTU9WRVJfVEFSRUZBIl0sImp0aSI6IjQ1NDgzNWUwLWYxODEtNDg5MS1hYWNiLWQxMWMyM2ZkN2Q0ZiIsImNsaWVudF9pZCI6ImFwcC10b2RvbGlzdCIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdfQ.MM3vaR2ef7fEV1m8bY-EOtJ7m2TjSuyQTVAIgP_keGQ' \
--header 'Content-Type: application/json' \
--data-raw '{
    "resumo":"teste",
    "descricao":"teste",
    "status": "COMPLETA"
}'
````

Excluir uma tarefa:
```shell
curl --location --request DELETE 'http://localhost:8080/tarefas/2' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MTg1OTI3NTQsInVzZXJfbmFtZSI6IndhbGxhY2VyZWlzbGltYUBnbWFpbC5jb20iLCJhdXRob3JpdGllcyI6WyJST0xFX0NBREFTVFJBUl9UQVJFRkEiLCJST0xFX1BFU1FVSVNBUl9UQVJFRkEiLCJST0xFX1JFTU9WRVJfVEFSRUZBIl0sImp0aSI6IjQ1NDgzNWUwLWYxODEtNDg5MS1hYWNiLWQxMWMyM2ZkN2Q0ZiIsImNsaWVudF9pZCI6ImFwcC10b2RvbGlzdCIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdfQ.MM3vaR2ef7fEV1m8bY-EOtJ7m2TjSuyQTVAIgP_keGQ' \
--data-raw ''
```
