# API de Geração de Orçamentos - Like Sistema

Este projeto consiste em uma API para geração de orçamentos, desenvolvida para o teste técnico  Like Sistema.

## Tecnologias Utilizadas

- ![Java](https://img.shields.io/badge/Java-blue.svg)
- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-green.svg)
- ![Maven](https://img.shields.io/badge/Maven-brown.svg)
- ![Banco de Dados H2 em Memória](https://img.shields.io/badge/H2%20Database-orange.svg)
- ![Testes Unitários](https://img.shields.io/badge/JUnit-blueviolet.svg)
- ![Swagger](https://img.shields.io/badge/Swagger-orange.svg)
- ![DTO (Data Transfer Object)](https://img.shields.io/badge/DTO-Implemented-brightgreen.svg)
- ![Modelos MVC](https://img.shields.io/badge/MVC-Implemented-brightgreen.svg)

## Para executar a Aplicação
- ![GitHub](https://img.shields.io/badge/Git%20Hub-orange.svg)
- ![Java](https://img.shields.io/badge/JavaJDK-21-blue.svg)
- ![Clone](https://img.shields.io/badge/Clone%20o%20Projeto-blue.svg)

Ao executar o projeto o Maven instalará as dependencias necessárias.

## Visualização do Swagger
```Com a aplicação em EXECUÇÃO , acesse a url: http://localhost:3000/swagger-ui/index.html#/```

## Entidade Orçamento

A entidade de orçamento possui os seguintes campos:

- `id`: Identificador único do orçamento (gerado automaticamente).
- `nomeCliente`: Nome do cliente para quem o orçamento está sendo gerado.
- `data`: Data em que o orçamento foi criado.

## Entidade Produto de Orçamento


A entidade de produto de orçamento possui os seguintes campos:

- `id`: Identificador único do produto de orçamento (gerado automaticamente).
- `nome`: Nome do produto.
- `valor`: Valor unitário do produto.
- `quantidade`: Quantidade do produto.
- `orcamento_id`: Chave estrangeira 

Ambas as entidades são mapeadas como entidades JPA para persistência no banco de dados.

## Configuração do Banco de Dados H2
```
# Dados de conexão com o banco H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

# Configuração do cliente web do banco H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Configuração para mostrar o SQL no console
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## Para conectar e visualizar as Tabelas 

```
Execeute a url : http://localhost:8080/h2-console 
```


## Exemplos de Solicitação 
#### Criação de Orçamento

`POST http://localhost:8080/api/orcamento/criar` 

`Request`

```jsx
{
	"nomeCliente":"Exemplo Nome",
	"produtos":[{
		"nome":"Produto1",
		"valor":"20.00",
		"quantidade":"1"
	},
	{
		"nome":"Produto2",
		"valor":"20.00",
		"quantidade":"1"
	}],
	"data":"2024-02-26",
}
```

`Response`
```  201```

#### Proposta de Orçamento

`POST http://localhost:8080/api/proposta` 

`Request`

```jsx
{
	"nomeCliente":"Exemplo Nome",
	"produtos":[{
		"nome":"Produto1",
		"valor":"20.00",
		"quantidade":"1"
	},
	{
		"nome":"Produto2",
		"valor":"20.00",
		"quantidade":"1"
	}],
	"data":"2024-02-26"
}
```
`Response`
```jsx
{
	"nomeCliente":"Exemplo Nome",
	"produtos":[{
		"nome":"Produto1",
		"valor":"20.00",
		"quantidade":"1"
	},
	{
		"nome":"Produto2",
		"valor":"20.00",
		"quantidade":"1"
	}],
	"data":"2024-02-26",
	"total":"40.00"
	
}
```

#### Busca por Todos os Orçamentos Existentes

`GET http://localhost:8080/api/orcamento/buscar` 

`Response`

```jsx
{
	"nomeCliente":"Exemplo Nome",
	"produtos":[{
		"nome":"Produto1",
		"valor":"20.00",
		"quantidade":"1"
	},
	{
		"nome":"Produto2",
		"valor":"20.00",
		"quantidade":"1"
	}],
	"data":"2024-02-26",
	"total":"40.00"
	
}
```
#### Busca por Orçamento por Identificação

`GET http://localhost:8080/api/orcamento/busca/1` 

`Response`
```jsx
{
	"nomeCliente":"Exemplo Nome",
	"produtos":[{
		"nome":"Produto1",
		"valor":"20.00",
		"quantidade":"1"
	},
	{
		"nome":"Produto2",
		"valor":"20.00",
		"quantidade":"1"
	}],
	"data":"2024-02-26",
	"total":"40.00"
	
}
```
#### Exclusão de Orçamento

`DELETE http://localhost:8080/api/orcamento/excluir/1` 

`Request`
```jsx
{
	"nomeCliente":"Exemplo Nome",
	"produtos":[{
		"nome":"Produto1",
		"valor":"20.00",
		"quantidade":"1"
	},
	{
		"nome":"Produto2",
		"valor":"20.00",
		"quantidade":"1"
	}],
	"data":"2024-02-26",
	"total":"40.00"
	
}
```
`Response`
```  202```






