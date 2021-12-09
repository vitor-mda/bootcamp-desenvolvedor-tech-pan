# 🍃 Desafio Final — *back-end*

## 📃 Sobre

Servidor *back-end* de uma aplicação de pedido de comida — atividade proposta no **[Desafio Final](../)** do **[Bootcamp Desenvolvedor Tech PAN](../../../../)**. Provê uma API de gerenciamento de pedidos e consulta de produtos através de operações de CRUD implementadas utilizando métodos HTTP escrita em Java com Spring Boot. O projeto adere ao padrão de camadas.

O sistema foi criado do zero, utilizando apenas dois arquivos providenciados pelo professor: `schema.sql` e `data.sql`. O primeiro define o *schema* do banco de dados, já o segundo contém um *script* SQL que irá popular a tabela `Produtos`. Esses arquivos foram alterados, sendo definidos para serem executados somente quando o banco de dados *in-memory* H2 estiver sendo utilizado através do perfil Spring `dev`.

### 🔋 Ferramentas e dependências

- IntelliJ 2021.1.3
- Java 11
- Spring Boot 2.6.1
- Gradle
- Spring Web
- Spring Data JPA
- H2 Database
- Spring Boot DevTools
- PostgreSQL Driver

### 📍 *Endpoints*

- #### `GET`   `/cardapio`

Obtém uma lista com todos os registros de `Produto`.

> Exemplo de resposta (*status code* `200`):
>
> ```json
> [
>     {
>         "id": 1,
>         "categoria": "Sanduiches de Boi",
>         "descricao": "Hamburguer",
>         "preco": 14.5
>     },
>     {
>         "id": 2,
>         "categoria": "Sanduiches de Boi",
>         "descricao": "X - Burguer",
>         "preco": 16.0
>     }
> ]
> ```

- #### `GET`   `/pedido`

Obtém uma lista com todos os registros de `Pedido`.

> Exemplo de resposta (*status code* `200`):
>
> ```json
> [
>     {
>         "id": 100,
>         "dataHora": "2021-12-07T15:04:38.705",
>         "situacao": "AGUARDANDO",
>         "itens": [
>             {
>                 "idProduto": 2,
>                 "quantidade": 2
>             },
>             {
>                 "idProduto": 7,
>                 "quantidade": 3
>             }
>         ]
>     }
> ]
> ```

- #### `GET`   `/pedido/{id}`

Obtém um registro de `Pedido` especificado pelo `id`.

> Exemplo de resposta (*status code* `200`):
>
> ```json
> {
>     "id": 100,
>     "dataHora": "2021-12-07T15:04:38.705",
>     "situacao": "AGUARDANDO",
>     "itens": [
>         {
>             "idProduto": 2,
>             "quantidade": 2
>         },
>         {
>             "idProduto": 7,
>             "quantidade": 3
>         }
>     ]
> }
> ```

- #### `POST` `/pedido`

Cria um novo registro de `Pedido`.

> Exemplo de requisição:
>
> ```json
> {
>     "dataHora": "2021-12-07T15:04:38.705Z",
>     "situacao": "AGUARDANDO",
>     "itens": [
>         {
>             "idProduto": 2,
>             "quantidade": 2
>         },
>         {
>             "idProduto": 7,
>             "quantidade": 3
>         }
>     ]
> }
> ```
>
> Exemplo de resposta (*status code* `201`):
>
> ```json
> {
>     "id": 100,
>     "dataHora": "2021-12-07T15:04:38.705",
>     "situacao": "AGUARDANDO",
>     "itens": [
>         {
>             "idProduto": 2,
>             "quantidade": 2
>         },
>         {
>             "idProduto": 7,
>             "quantidade": 3
>         }
>     ]
> }
> ```

- #### `PUT`   `/pedido/{id}`

Atualiza o status de um registro de `Pedido` especificado pelo `id`.

> Exemplo de requisição:
>
> ```json
> {
>     "dataHora": "2021-12-07T15:04:38.705Z",
>     "situacao": "ENTREGUE",
>     "itens": [
>         {
>             "idProduto": 2,
>             "quantidade": 2
>         },
>         {
>             "idProduto": 7,
>             "quantidade": 3
>         }
>     ]
> }
> ```
>
> Exemplo de resposta (*status code* `200`):
>
> ```json
> {
>     "id": 100,
>     "dataHora": "2021-12-07T15:04:38.705",
>     "situacao": "ENTREGUE",
>     "itens": [
>         {
>             "idProduto": 2,
>             "quantidade": 2
>         },
>         {
>             "idProduto": 7,
>             "quantidade": 3
>         }
>     ]
> }
> ```