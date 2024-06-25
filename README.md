# BarberShop

Este é um projeto de sistema de gerenciamento para uma barbearia, desenvolvido em Java e utilizando PostgreSQL como banco de dados. O desenvolvimento foi realizado utilizando o IDE NetBeans.

## Descrição

O projeto BarberShop foi criado para gerenciar agendamentos, clientes, serviços e funcionários de uma barbearia. Com este sistema, é possível realizar cadastros, atualizações, exclusões e consultas de dados relacionados à barbearia, além de facilitar o controle de horários e a organização do estabelecimento.

## Tecnologias Utilizadas

- **Java:** Linguagem de programação utilizada para desenvolver a aplicação.
- **PostgreSQL:** Sistema de gerenciamento de banco de dados relacional utilizado para armazenar os dados da aplicação.
- **NetBeans:** Ambiente de desenvolvimento integrado (IDE) utilizado para o desenvolvimento do projeto.

## Funcionalidades

- Cadastro de clientes
- Cadastro de funcionários
- Cadastro de serviços
- Agendamento de horários
- Consulta e atualização de dados
- Relatórios de atendimentos

## Requisitos

- **Java 11 ou superior**
- **PostgreSQL 12 ou superior**
- **NetBeans 12 ou superior**

## Instalação

1. Clone o repositório para a sua máquina local:
    ```bash
    git clone https://github.com/seu-usuario/barberShop.git
    ```

2. Abra o NetBeans e importe o projeto:
    - Vá em `File` > `Open Project` e selecione o diretório onde o projeto foi clonado.

3. Configure o banco de dados PostgreSQL:
    - Crie um banco de dados chamado `barbershop`:
      ```sql
      CREATE DATABASE barbershop;
      ```

    - Execute o script SQL de criação das tabelas (localizado em `sql/create_tables.sql`):
      ```bash
      psql -U seu_usuario -d barbershop -f sql/create_tables.sql
      ```

4. Configure as credenciais do banco de dados no arquivo `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/barbershop
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    ```

5. Compile e execute a aplicação pelo NetBeans:
    - Clique com o botão direito no projeto e selecione `Clean and Build`.
    - Após a compilação, clique com o botão direito no projeto novamente e selecione `Run`.

## Uso

1. Abra o navegador e acesse `http://localhost:8080` para acessar a interface do sistema.
2. Utilize os menus para navegar pelas funcionalidades disponíveis, como cadastro de clientes, agendamento de horários, etc.

## Contribuição

Se você deseja contribuir com o projeto, siga os passos abaixo:

1. Faça um fork do repositório.
2. Crie uma branch para sua feature ou correção:
    ```bash
    git checkout -b minha-feature
    ```
3. Faça commit das suas alterações:
    ```bash
    git commit -m 'Minha nova feature'
    ```
4. Envie para o repositório remoto:
    ```bash
    git push origin minha-feature
    ```
5. Abra um Pull Request no GitHub.




