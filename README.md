# Projeto MVC

Utilizamos de um enredo já elaborado para desenvolver esse projeto e aplicar as técnicas ensinadas em aula no 3º semestre de DSM.

## Aplicação

**Tecnologias Utilizadas**

Conforme orientado, as ferramentas para o desenvolvimento do sistema, são:

- Java;
- JSP (Java Server Pages);
- Servlets;
- Banco de dados MySQL;
- Padrão MVC (Model-View-Controller);

Para conseguirmos realizar o projeto é preciso preparar o ambiente para desenvolvimento e execução, vejamos o que será necessário:

- Eclipse IDE for Entreprise Java and Web 2023-12 ou mais recente.
- JDK 21.0.2 Hotspot ou mais recente;
- Apache TomCat 10- no disco local C: ;
- MySQL Server;

***Para adquirir essas ferramentas basta acessar a página oficial dos distribuidores e realizar o download***

## Preparando o ambiente

Para preparar o ambiente de desenvolvimento e execução recomendamos que assista o vídeo a seguir e siga as instruções contidas nele:

https://www.youtube.com/watch?v=dVRYwQc8uYc&list=PLbEOwbQR9lqz9AnwhrrOLz9cz1-TxoiUg&index=4

***Caso tenha disponível as ferramentas para execução, basta ativar o TomCat (que também é explicado no vídeo) e executar o projeto.***

## Conectando o banco de dados

Para realizar a conexão do banco de dados MySQL com o eclipse é importante seguir alguns passos; é preciso ter disponível um conector que interliga ambas ferramentas.

Para isso precisamos fazer o download do conector no site oficial:  https://dev.mysql.com/downloads/connector/j/ (a versão que utilizamos foi a j-8.3.0)

Após o download, que será baixado como zip, extraia o arquivo todo, porque vamos utiliza-lo para integração.

Na raiz do projeto é preciso adicionar à Biblioteca o conector MySQL.jar que você acabou de baixar e está na pasta extraída,

Botão direito do mouse no projeto >> Java Settings>>Libraries>>Add External JARs>> escolha o conector que você acabou de baixar>>Finish.

Pronto o conector essa na raiz do projeto.

## Funcionalidades Aplicadas

Aqui temos o que o projeto executará, seguindo as solicitações:

**1 - Cadastro de Usuário**

O usuário será cadastrado com informações básicas que serão armazenadas no banco de dados; posteriormente esse cadastro será utilizado para realizar o login e/ou  autenticação para acesso ao sistema.

**2 - Autenticação de Usuários**

A autenticação do usuário acontecerá quando o mesmo tiver login e senha cadastrados no banco de dados;

**3 - Gerenciamento de Tarefas**

Os usuários, mediante autenticação prévia, poderão criar uma nova tarefa acessando a página de “Nova Tarefa” localizada na parte superior da tela, e preencher um formulário respectivo;

**4 - Listagem de Tarefas**

Na página de visualização, será possível visualizar as tarefas cadastradas pelos usuários em geral.

Ao executar o projeto as funcionalidade acima citadas serão de fácil visualização e fácil execução.