🚀 Desenvolvedor Java & Angular: Sistema de Controle de Tarefas (To-Do)
Este projeto é um sistema simples de Controle de Tarefas (To-Do) com funcionalidades de cadastro, listagem e gerenciamento de status. A aplicação foi desenvolvida de forma full-stack, dividida em dois serviços independentes: Front-end (Angular) e Back-end (Spring Boot).

📁 Estrutura do Projeto
O repositório está dividido em dois diretórios principais:

backend-todo: Contém a API REST desenvolvida em Java/Spring Boot.

frontend-todo: Contém a aplicação web desenvolvida em Angular.

💻 Back-end: Tecnologias e Configuração
O Back-end é responsável pela lógica de negócio e persistência de dados.

🛠️ Tecnologias Envolvidas
Java com Spring Boot 2.1 (ou versão compatível)

Banco de Dados: PostgreSQL

Migração de Banco: Flyway

Persistência: JPA (Java Persistence API)

Documentação: Swagger http://localhost:8080/swagger-ui/index.html

⚙️ Como Executar o Back-end
1. Configuração do Banco de Dados
É obrigatório criar um banco de dados local chamado todo no seu servidor PostgreSQL.

Nome do Banco de Dados: todo

Após a criação, é necessário ajustar as credenciais de acesso (usuário e senha) no arquivo de configuração do Spring Boot, geralmente application.properties ou application.yml, dentro do diretório backend-todo.

2. Inicialização do Projeto
Baixar Dependências: Ao abrir o projeto no IntelliJ IDEA (ou IDE de sua preferência), o Maven deve baixar automaticamente as dependências listadas no arquivo pom.xml.

Executar:

Opção 1 (IntelliJ): Procure pelo botão 'Play' (verde) no topo da IDE e clique para rodar a aplicação.

Opção 2 (Manual): Navegue até a classe ...Application.java (a classe main do Spring Boot) e execute-a a partir da IDE.

🖼️ Front-end: Configuração e Execução
(Adicione informações sobre as tecnologias Angular e as instruções para rodar o front-end, como npm install e ng serve)

🗺️ Funcionalidades
Cadastro de Tarefas: Adicionar novas tarefas.

Listagem: Visualizar todas as tarefas cadastradas.

Gerenciamento de Status: Atualizar o status da tarefa (e.g., Pendente, Em Progresso, Concluída).