# 📃 Sobre

Trabalho Prático do **[Módulo 4: Java para WEB](../)**.

Consiste em uma API básica de leitura e cadastro de alunos provido por um *back-end* local feito com Spring Boot. Possibilita a leitura de registros através do método HTTP `GET` e criação de registros com o método HTTP `POST`. Ao invés de uma `List`, como pedido no enunciado, foi utilizado o banco de dados *in-memory* H2 para salvar registros da `@Entity` `Aluno`. Também foram criadas uma classe anotada com `@Service` e um repositório de `Aluno`s (`AlunoRepository extends JpaRepository`), estruturados de forma a exercitar o padrão de camadas.

### 📍 *Endpoints*

- `GET` `/aluno`
  - Listagem de todos os registros de alunos.
- `GET` `/aluno/{id}`
  - Listagem de um registro de aluno pelo ID.
- `POST` `/aluno`
  - Criação de um registro de aluno.

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
> - Criar endpoints.
> - Bancos de dados (Memória temporária – List/Map).
>
> ### Enunciado
>
> Partindo dos conhecimentos adquiridos até agora, o aluno deve criar dois endpoints utilizando o Spring Boot Java, um para salvar e o outro para listar.
>
> ### Atividades
>
> Os alunos deverão desempenhar as seguintes atividades:
>
> 1. Criar uma classe Aluno que contenha: matrícula, nome, curso;
> 2. Criar um repositório de métodos (salvar e listar) e salvar tudo em um List/Map;
> 3. Criar uma classe controller para exibir os dados no navegador.