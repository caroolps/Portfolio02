![Fatec-logo-9710C99301-seeklogo com](https://user-images.githubusercontent.com/61067500/81480184-54e16600-91fe-11ea-86d6-dbae737cefa1.png)   <img align="left" width="100" height="100" src="https://user-images.githubusercontent.com/61067500/81479704-434a8f00-91fb-11ea-8d71-0cf029bc25ab.png">


### I- RESUMO DO PROJETO

O presente documento visa apresentar a solução tecnológica proposta pela equipe para atender às necessidades do cliente NECTO, possibilitando a identificação e classificação dos requisitos, que nortearão o desenvolvimento do projeto.
 
A solução consiste numa aplicação visual de planejamento estratégico e gerenciamento de tempo dos seus recursos humanos em projetos de desenvolvimento de softwares (seu core business).

Nesse passo, como característica principal, da qual decorrem as funcionalidades (requisitos), a aplicação deve possibilitar a alocação dos recursos humanos em um gráfico de GANTT (tarefas em linhas de tempo), gerando métricas sobre a ocupação e o tempo disponível da equipe para novos projetos e contingências. 

A GUI (Graphical User Interface) permitirá o planejamento colaborativo sobre o uso do tempo, v.g. mudanças de pessoas em tarefas/projetos, cobertura de ausências/férias de colaboradores, determinação de data de início de novos projetos, carga de trabalho por colaborador etc. Será utilizado o Java como linguagem de programação.

 ### Descrição:
 
A cliente NECTO busca melhorar o gerenciamento de seus projetos e consequentemente de sua equipe no dia a dia, buscando a melhor alocação de tempo possível porém, de forma humanizada, respeitando limite de tempo diário de trabalho, descanso semanal, férias,  ausências por motivos particulares e de saúde de cada colaborador.

Com base nesse briefing, solicita um programa simples e funcional, de baixa manutenção, para a realização de seu planejamento, especialmente:

* Gerenciar as cargas horárias em cada tarefa dos colaboradores;
* Distribuir mais uniformemente as tarefas para os colaboradores;
* Equilibrar a relação custo x receita dos projetos;
* Obter previsibilidade de faturamento e de ações comerciais;
* Gerenciar a quantidade de tarefas e projetos possíveis com uma determinada equipe;
* Limitar a quantidade de horas trabalhadas por colaborador a fim de evitar sobrecargas.
* Permitir a divisão de uma tarefa por dia (um dia = unidade mínima de tempo);
* Exportar arquivo para envio a terceiros (cliente e outros stakeholders, em PDF ou HTML ou GDOCs);
* Gerar Relatório;


## Proposta

 A seguinte proposta visa entregar um  sistema que gere diagrama interativo (Gráfico de Gantt) de controle de tarefas, projetos e carga horária de cada recurso, trazendo uma interface intuitiva e amigável ao usuário.
 
 1- Estrutura do projeto divido em camadas:
 
 ![Estrutura](https://user-images.githubusercontent.com/61089745/141656917-4c7bceb8-5ca6-4b42-8643-a97302af5c39.PNG)

2- Modelagem Conceitual para ser implantada no Banco de Dados MYSQL

![ModelagemConceitual](https://user-images.githubusercontent.com/61089745/141656940-7af9ae17-2bdd-4853-acbf-d6ee7405a267.PNG)

3- Modelagem utilizada no Banco de Dados no MYSQL

![ModelagemBD](https://user-images.githubusercontent.com/61089745/141656954-10700f13-b26b-4513-b51b-a5a20a4429e6.PNG)

4- Tela de Login

![Login](https://user-images.githubusercontent.com/61089745/141656980-681987ac-1e9d-4fe9-bceb-9d83434fb975.PNG)

5- Tela de Cadastro do Projeto com possibilidade de editar, excluir e cadastrar um novo projeto interligado ao banco de dados

![CadastroProjetosII](https://user-images.githubusercontent.com/61089745/141657004-75236913-3a62-4006-990a-4f89f0475a45.PNG)

6- Tela de Cadastro do Funcionário com possibilidade de editar, excluir e cadastrar um novo funcionário interligado ao banco de dados

![CadastroFuncionarios](https://user-images.githubusercontent.com/61089745/141657014-8a8603a8-4cef-4aad-8837-1d5aa535aebd.PNG)

7- Tela de Cadastro da Tarefa com possibilidade de editar, excluir e cadastrar uma nova tarefa interligado ao banco de dados

![CadastroTarefa](https://user-images.githubusercontent.com/61089745/141657029-41bfd888-73e2-4c8c-a9d2-26a065968dc2.PNG)

8- Gráfico de Gantt sendo exibido conforme o projeto, tarefa e data de inicio e fim de cada dependência

![Gantt2](https://user-images.githubusercontent.com/61089745/141657083-849746d2-3416-47e8-b1b2-66174241bb95.PNG)

### II - TECNOLOGIAS ADOTADAS NA SOLUÇÃO 

- JavaFx: é utizado para desenvolver aplicações desktop com java, usamos essa ferramenta para desenvolver o front-end do nosso projeto.

- Gantt / Nebula:É uma biblioteca java que usamos para gerar o gráfico de GANTT totalmente personalizável para exibir qualquer coisa, desde um gráfico simples até permitir a interação do usuário por meio de arrastar e soltar e redimensionar, bem como interação de dependência.

![ShowGantt](https://user-images.githubusercontent.com/61089745/141659977-db3e03ec-18c6-4e8a-90c6-8d080fc8f9ff.PNG)

- Calendar: Essa classe pode produzir os valores de todos os campos de calendário necessários para implementar a formatação de data e hora, para uma determinada língua e estilo de calendário. Usamos juntamente com o Gantt para mostrarmos a data de início e final de cada tarefa e dependência  no gráfico de Gantt.

![CalendarBiblioteca](https://user-images.githubusercontent.com/61089745/141659932-dcffb9a5-21fe-48b8-869d-d3da453b7d90.PNG)

![CalendarCodigo](https://user-images.githubusercontent.com/61089745/141659947-761d230f-4b7b-4def-94eb-ed2a676ca744.PNG)

- Java: é uma linguagem de programação orientada a objetos utilizamos em nosso back-end.

- MySQL: O MySQL é um sistema de gerenciamento de banco de dados, que utiliza a linguagem SQL como interface. É atualmente um dos sistemas de gerenciamento de bancos de dados mais populares da Oracle Corporation. Por isso, escolhemos esse sistema para integrar com o nosso backend em java, para criar, deletar, editar e visualizar os dados através do java.

- Scrum: Continuamos a usar a metodologia scrum aprendida no primeiro semestre para realizar as entregas do projeto.


### CONTRIBUIÇÕES INDIVIDUAS/PESSOAIS 

No segundo semestre demos início no aprendizado na Linguagem De Programação I, onde estava sedo incinado a utilizar a linguagem JAVA, com isso consegui aplicar o que estavamos aprendendo em aula em nosso projeto, criamos as entidades orientada a objetos, criamos 

JAVAFX

MYSQL
CRUD 
JDBC


### APRENDIZADOS EFETIVOS

JAVA
CLASSES

ORIENTAÇÃO A OBJETOS

JPA

DAO

MODEL

CONTROLLER

SERVICES

EXCEPTIONS

BANCO DE DADOS

JAVAFX

GIT HUB

