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

### 1. Tela Principal
- Exibe **3 sugestões aleatórias de músicas** ao abrir.
- Permite tocar, curtir, buscar e navegar.
- Botão “Curtir” registra a música atual como curtida.

### 2. Buscar Músicas
- Busca por nome, gênero ou artista.
- Resultados exibidos com botões:
  - **Curtir/Descurtir**
  - **Adicionar à Playlist**
- Armazena no histórico do usuário.

### 3. Histórico
- Exibe as últimas 10:
  - Músicas buscadas
  - Músicas curtidas
  - Músicas descurtidas

### 4. Músicas Curtidas
- Mostra as últimas 10 músicas curtidas.

### 5. Playlists
- Criar e excluir playlists
- Adicionar músicas diretamente da tela de busca
- Ver músicas de cada playlist

---

## 🧱 Estrutura do Banco de Dados (MER)

O banco segue este modelo:

- `usuario (user_id, name, password)`
- `artista (artist_id, artist_name)`
- `music (music_id, music_name, genre, duration, artist_id)`
- `playlist (playlist_id, playlist_name, user_id)`
- `playlist_music (playlist_id, music_id)`
- `liked_music (user_id, music_id, liked)`
- `search_history (user_id, music_id, data_busca)`

**Relações:**
- Um artista possui várias músicas.
- Um usuário pode ter várias playlists e músicas curtidas.
- As interações de buscar são registradas com `timestamp`.

---

## 🧠 Arquitetura MVC + DAO

Este projeto adota o padrão **MVC** com extensão **DAO**:

- **Model**: Classes de negócio (Usuario, Musica, Playlist)
- **View**: Telas Java Swing (TelaPrincipal, ResultadoBusca, etc)
- **Control**: Lógica de interação e manipulação da UI
- **DAO**: Responsável por interações com o banco (inserir, buscar, curtir, etc)

---

## 🛠 Como Executar

### Pré-requisitos
- Java 11 ou superior
- PostgreSQL 13+
- IDE com suporte a Java Swing (NetBeans, IntelliJ, Eclipse)

### Configuração do Banco de Dados
> ⚠️ A conexão é feita via JDBC. Edite o arquivo `Conexao.java` para usar seu usuário e senha local:

```java
DriverManager.getConnection("jdbc:postgresql://localhost:5432/BD-SpotFEI", "seu_usuario", "sua_senha");
```

---

## 👨‍💻 Autor
Lucas Galvano de Paula  
Desenvolvido como parte do curso de Arquitetura De Software e Programação Orientada a Objetos – Centro Universitário FEI
