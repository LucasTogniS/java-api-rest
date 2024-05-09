# api-java
API with Java and Spring Boot

## DOCUMENTAÇÃO
Este projeto é uma API com a funcionalidade de resgitro e busca de produtos, utilizando Java e Spring Boot.  
A classe Controller funciona como porta de entrada para a aplicação, recebendo todas as requisições do  
cliente, ela interpreta as requisições e determina qual ação deve ser executada.  
A classe Request representa os dados enviados pelo cliente para a API em uma requisição, com parâmetros  
que a API espera receber e validam esses dados.  
A classe Response representa os dados que a API retorna ao cliente como resposta da requisição.  
A classe Repository é responsável por gerenciar e interagir com o banco de dados, onde armazenará os  
dados da aplicação.

## URL
GET - http://127.0.0.1:8081/api/products  
GET - http://127.0.0.1:8081/api/products/1  
DELETE - http://127.0.0.1:8081/api/products/1  
POST - http://127.0.0.1:8081/api/products

## Exemplo do arquivo Json usado na requisição POST
{
"name": "Limpol",
"description": "Detergente",
"price": 1.69
}

