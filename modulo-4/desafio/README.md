# 📃 Sobre

Desafio do **[Módulo 4: Java para WEB](../)**.

Consiste em uma API básica de leitura e cadastro de vendas e vendedores provido por um *back-end* local feito com Spring Boot.

Foram criadas duas entidades: `Venda` e `Vendedor`, modeladas com relacionamento **N:1**, respectivamente. Para exercitar o padrão de camadas, foram criados dois *controllers* (`VendaController` e `VendedorController`), dois *services* (`VendaService` e `VendedorService`), dois *repositories* (`VendaRepository` e `VendedorRepository`) e quatro *DTO*s (`VendaRequest`, `VendedorRequest`, `VendaResponse` e `VendedorResponse`).

Por praticidade, foi utilizado o banco de dados *in-memory* H2 ao invés do proposto MySQL. O banco de dados é iniciado com uma carga de dados de amostra presente no arquivo `src/main/resources/data.sql`.

### 📍 *Endpoints*

- `GET` `/venda`

  Listagem de todos os registros de venda.

  > Exemplo de resposta:
  > `Status: 200 OK`
  >
  > ```json
  > [
  >     {
  >         "id": 1,
  >         "data": "1970-01-01",
  >         "valor": 1.99,
  >         "vendedorId": 1
  >     },
  >     {
  >         "id": 2,
  >         "data": "1970-01-02",
  >         "valor": 2.99,
  >         "vendedorId": 2
  >     }
  > ]
  > ```

- `GET` `/venda/{id}`

  Listagem de um único registro de venda pelo ID.

  > Exemplo de resposta:
  >
  > `Status: 200 OK`
  >
  > ```json
  > {
  >     "id": 1,
  >     "data": "1970-01-01",
  >     "valor": 1.99,
  >     "vendedorId": 1
  > }
  > ```

- `GET` `/vendedor`

  Listagem de todos os registros de vendedor.

  > Exemplo de resposta:
  >
  > `Status: 200 OK`
  >
  > ```json
  > [
  >     {
  >         "id": 1,
  >         "nome": "John Doe",
  >         "vendas": [
  >             {
  >                 "id": 1,
  >                 "data": "1970-01-01",
  >                 "valor": 1.99,
  >                 "vendedorId": 1
  >             }
  >         ]
  >     },
  >     {
  >         "id": 2,
  >         "nome": "Jane Doe",
  >         "vendas": [
  >             {
  >                 "id": 2,
  >                 "data": "1970-01-02",
  >                 "valor": 2.99,
  >                 "vendedorId": 2
  >             }
  >         ]
  >     }
  > ]
  > ```

- `GET` `/vendedor/{id}`

  Listagem de um único registro de vendedor pelo ID.

  > Exemplo de resposta: 
  >
  > `Status: 200 OK`
  >
  > ```json
  > {
  >     "id": 1,
  >     "nome": "John Doe",
  >     "vendas": [
  >         {
  >             "id": 1,
  >             "data": "1970-01-01",
  >             "valor": 1.99,
  >             "vendedorId": 1
  >         }
  >     ]
  > }
  > ```

- `GET` `/vendedor/ranking`

  Listagem de todos os registros de vendedor ordenados pela valor total de vendas.

  > Exemplo de resposta:
  >
  > `Status: 200 OK`
  >
  > ```json
  > [
  >     {
  >         "id": 2,
  >         "nome": "Jane Doe",
  >         "vendas": [
  >             {
  >                 "id": 1,
  >                 "data": "1970-01-02",
  >                 "valor": 2.99,
  >                 "vendedorId": 2
  >             }
  >         ]
  >     },
  >     {
  >         "id": 1,
  >         "nome": "John Doe",
  >         "vendas": [
  >             {
  >                 "id": 1,
  >                 "data": "1970-01-01",
  >                 "valor": 1.99,
  >                 "vendedorId": 1
  >             }
  >         ]
  >     }
  > ]
  > ```

- `POST` `/venda`

  Criação de um registro de venda.

  > Exemplo de requisição:
  >
  > ```json
  > {
  >     "data": "2021-11-25",
  >     "valor": 340.0,
  >     "vendedorId": 3
  > }
  > ```
  >
  > Exemplo de resposta:
  >
  > `Status: 201 Created`
  >
  > ```json
  > {
  >     "id": 3,
  >     "data": "2021-11-25",
  >     "valor": 340.0,
  >     "vendedorId": 3
  > }
  > ```

- `POST` `/vendedor`

  Criação de um registro de vendedor.

  > Exemplo de requisição:
  >
  > ```json
  > {
  >     "nome": "Ciro Bottini"
  > }
  > ```
  >
  > Exemplo de resposta:
  >
  > `Status: 201 Created`
  >
  > ```json
  > {
  >     "id": 3,
  >     "nome": "Ciro Bottini",
  >     "vendas": []
  > }
  > ```

### 🔋 Dependências

- Spring Web;
- Spring Boot DevTools;
- H2 Database;
- Spring Data JPA;

## 👨‍🏫 Enunciado

> ### Objetivos
>
> Exercitar os seguintes conceitos trabalhados no Módulo:
>
> - Criar entidades.
> - Usar o JPA para a persistência dos dados.
> - Paginação de dados.
> - Requisições HTTP.
> - Criar endpoints.
>
> ### Enunciado
>
> Construa uma API com Spring Boot que contenha 5 endpoints que faça a busca no banco de dados MySQL:
>
> - Salvar Vendedor
> - Salvar Vendas
> - Listar Vendas
> - Listar Vendedores
> - Listar taxa de sucesso em ordem por vendedor
>
> ### Atividades
>
> Os alunos deverão desempenhar as seguintes atividades:
>
> 1. Crie duas entidades Venda e Vendedor com JPA;
>
>    Os atributos da classe Venda serão:
>
>    - ID
>    - Nome do vendedor (Relacionamento de Muitos para um)
>    - Valor da venda
>    - Data da venda
>
>    Os atributos da classe Vendedor serão:
>
>    - Id
>    - Nome
>    - Vendas (Relacionamento de Um para Muitos)
>
> 2. Use arquitetura de camadas (Services, DTO, Repositories, entities e controllers);
>
> 3. Crie dois controllers, um para Vendas e o outro para vendedor;
>
> 4. Crie um endpoint que mostre em ordem os vendedores com maiores taxas de sucesso em vendas;
>
> 5. Crie os outros endpoints de listar e salvar, tanto para Vendas como Vendedores;
>
> 6. Faça o teste no Postman;
>
> 7. Faça a configuração das propriedades do MySQL no projeto.