# SpotiFEI 

![Java](https://img.shields.io/badge/Java-17-orange?logo=java&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-GUI-blue)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-13-blue?logo=postgresql&logoColor=white)
![MVC](https://img.shields.io/badge/Arquitetura-MVC-success)

#### Um projeto Java que simula uma plataforma de streaming musical, permitindo operações como cadastro, login, busca por músicas, curtir/descurtir faixas, visualizar histórico e gerenciar playlists.

## 📋 Sobre o Projeto
#### Este projeto foi desenvolvido como parte do curso de  Arquitetura De Software e Programação Orientada a Objetos e tem como objetivo simular o funcionamento básico de um sistema musical completo. O sistema é interativo e possui interface gráfica (Java Swing), permitindo aos usuários:

- Cadastrar e acessar suas contas.
- Pesquisar músicas por nome, artista ou gênero.
- Curtir e descurtir músicas.
- Visualizar histórico de ações recentes.
- Criar e excluir playlists personalizadas.
- Adicionar músicas às playlists.

## 🚀 Funcionalidades

### 1. Cadastro e Login
- O usuário pode se cadastrar informando nome e senha.
- A senha é validada no login, e os dados são verificados via banco PostgreSQL.
- Após login, o usuário acessa a TelaPrincipal com todas as opções disponíveis.

### 2. Busca de Músicas
- Pesquisa dinâmica por nome de música, nome do artista ou gênero.
- Exibe os resultados com botões de “Curtir/Descurtir” e “Adicionar à Playlist”.

### 3. Curtir/Descurtir Músicas
- Permite marcar músicas como curtidas ou descurtidas.
- O status é salvo no banco e refletido automaticamente na interface.

### 4. Histórico do Usuário
- Exibe as últimas 10 músicas buscadas, curtidas e descurtidas.

### 5. Gerenciamento de Playlists
- Criar, visualizar e excluir playlists personalizadas.
- Cada usuário gerencia suas próprias playlists.
- As músicas adicionadas a uma playlist são salvas em uma tabela de relacionamento.

## 🛠️ Como Executar o Projeto

### Pré-requisitos:
- Java 17 ou superior
- PostgreSQL instalado
- IDE Java (NetBeans, IntelliJ, Eclipse)

### Passos para execução:
1. Clone o repositório:
   `git clone https://github.com/LucasGalvano/SpotiFEI-Git.git`

2. Configure o banco:
   - Execute o script SQL disponível na pasta `/database`.
   - Atualize as credenciais no arquivo `Conexao.java`.

3. Compile e execute:
   - Execute `LoginFrame.java` como aplicação.
   - Faça login ou crie um novo usuário para começar.

 ## 👨‍💻 Autor
Lucas Galvano de Paula  
Desenvolvido como parte do curso de Arquitetura De Software e Programação Orientada a Objetos – Centro Universitário FEI

