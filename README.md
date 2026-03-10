# CRUD de Funcionários em Java

Projeto simples de CRUD (Create, Read, Update e Delete) desenvolvido em Java utilizando JDBC e PostgreSQL.  
A ideia do projeto é praticar conceitos de Java, orientação a objetos e conexão com banco de dados.

## Funcionalidades

O sistema permite:

- Cadastrar um funcionário
- Listar todos os funcionários
- Atualizar dados de um funcionário
- Excluir um funcionário do banco de dados

## Tecnologias utilizadas

- Java
- JDBC
- PostgreSQL
- IntelliJ IDEA

## Estrutura do projeto

O projeto foi organizado em algumas camadas para facilitar a organização do código:
connection
└── ConnectionFactory (responsável pela conexão com o banco)

model
└── Funcionario (classe que representa o funcionário)

repository
└── FuncionarioRepository (responsável pelas operações no banco)

service
└── FuncionarioService (regras de negócio)

Main
└── Classe principal que executa o sistema

## Banco de dados

Foi utilizado PostgreSQL com a seguinte tabela:

```sql
CREATE TABLE pessoas (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50),
    idade INT,
    sexo CHAR(1),
    email VARCHAR(40)
);
