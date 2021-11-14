LISTA DOS PORTFÓLIOS:

[PROJECT-SEMESTRE-01-2019.2 - * DANZO - Mapeador de Criminalidade ao Redor da FATEC *](https://github.com/caroolps/Portfolio01) 

[PROJECT-SEMESTRE-02-2020.1 - * GANTT Chart *](https://github.com/caroolps/Portfolio02)

[PROJECT-SEMESTRE-03-2020.2 - * Cadastro Positivo *](https://github.com/caroolps/Portfolio03) 

[PROJECT-SEMESTRE-04-2021.1 - * Oracle HR Solution  for searching candidates via API * ](https://github.com/caroolps/Portfolio04) 

[PROJECT-SEMESTRE-05-2021.2 - * Pentaho & Data Warehouse Analytics of Education * ](https://github.com/caroolps/Portfolio05) 


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

- Gantt / Nebula: é uma biblioteca java que usamos para gerar o gráfico de GANTT totalmente personalizável para exibir qualquer coisa, desde um gráfico simples até permitir a interação do usuário por meio de arrastar e soltar e redimensionar, bem como interação de dependência.

![ShowGantt](https://user-images.githubusercontent.com/61089745/141659977-db3e03ec-18c6-4e8a-90c6-8d080fc8f9ff.PNG)

- Calendar: Essa classe pode produzir os valores de todos os campos de calendário necessários para implementar a formatação de data e hora, para uma determinada língua e estilo de calendário. Usamos juntamente com o Gantt para mostrarmos a data de início e final de cada tarefa e dependência  no gráfico de Gantt.

![CalendarBiblioteca](https://user-images.githubusercontent.com/61089745/141659932-dcffb9a5-21fe-48b8-869d-d3da453b7d90.PNG)

![CalendarCodigo](https://user-images.githubusercontent.com/61089745/141659947-761d230f-4b7b-4def-94eb-ed2a676ca744.PNG)

- Java: é uma linguagem de programação orientada a objetos utilizamos em nosso back-end.

- MySQL: é um sistema de gerenciamento de banco de dados, que utiliza a linguagem SQL como interface. É atualmente um dos sistemas de gerenciamento de bancos de dados mais populares da Oracle Corporation. Por isso, escolhemos esse sistema para integrar com o nosso backend em java, para criar, deletar, editar e visualizar os dados através do java.

- Scrum: Continuamos a usar a metodologia scrum aprendida no primeiro semestre para realizar as entregas do projeto.


### III - CONTRIBUIÇÕES INDIVIDUAS/PESSOAIS 

No segundo semestre iniciamos o aprendizado de Linguagem De Programação I, onde estava sendo lecionado sobre a linguagem JAVA, com isso foi possível conciliar o que estavámos aprendendo em aula e aplicar em nosso projeto, eu contribui com o projeto criando as principais camadas do backend como:
- Entidades: Fiquei responsável pelas classes Projeto, Tarefa, Cadastro de tarefa e Cadastro de projeto orientada ao objeto utilizando os métodos getters, setters e o serializable é o processo no qual a instância de um objeto é transformada em uma sequência de bytes e é útil quando precisamos enviar objetos pela rede, salvar no disco, ou comunicar de uma JVM com outra;

![Entities](https://user-images.githubusercontent.com/61089745/141661748-853192b1-eb41-4289-8833-2fe22a038937.PNG)

- Controller: Crie as classes controller do Projeto, Tarefa e cadastros. Como estávamos usando a aplicação desktop tive que fazer duas classes controller para cada entidade uma com a extensão .java e outra com extensão .fxml para realizar a conexão com o javaFx nosso front-end. 

![ExtensaoClasses](https://user-images.githubusercontent.com/61089745/141661946-5d4840d6-5ee6-4b17-b782-789d3cbadacb.PNG)

- Service: Criei as classes Tarefa Service e Cadastro service e defini seus métodos na interface DAO.

![Service](https://user-images.githubusercontent.com/61089745/141662039-8927ae32-78c8-43e3-b233-13e15c97767e.PNG)

 
- Service implements: Criei as classes Tarefa e Cadastro e implementei os métodos definidos no Service com inteface DAO usando o JDBC.

![image](https://user-images.githubusercontent.com/61089745/141662145-fe473c43-cd2f-467e-98cc-0d08ac044fd7.png)


- Classes DAO para conexão com o Banco de Dados: Criei as classes Tarefas e Cadastros para passar os métodos insert, delete, update e lista nas classes.

![DAO](https://user-images.githubusercontent.com/61089745/141662133-a50122f1-c75f-4d30-b7a7-942af643caa7.PNG)


JAVAFX: Desenhei as telas para exibição do cadastro, edição e deleção da classe Tarefa, Projeto e Funcionário.

![CadastroTarefa](https://user-images.githubusercontent.com/61089745/141662165-caf52ddc-0949-4b67-92d0-59bc7fb3d766.PNG)

MYSQL:Tive meu primeiro contato com o banco de dados, conseguimos conciliar o aprendizado da matéria Arquitetura e Modelagem de Banco de Dados e aplicarmos em nosso projeto. Eu contribui criando as tabelas Funcionário, Tarefa e Projetos, passando seus atributos e dimensões.

![image](https://user-images.githubusercontent.com/61089745/141662257-f06ecc37-cb7f-4212-a92e-0aaef1580655.png)



### IIII - APRENDIZADOS EFETIVOS

Através do API, consegui programar pela primeira vez utilizando JAVA.

- JAVA: Java é uma linguagem de programação orientada a objetos desenvolvida na década de 90 por uma equipe de programadores chefiada por James Gosling, na empresa Sun Microsystems.

Através dessa linguagem aprendi sobre as principais camadas para construir uma aplicação como: Entidade, Service, Service implements, DAO e Controller. Uma estrutura que pode ser aplicada em qualquer projeto e inclusive estamos usando até os dias atuais. 

![image](https://user-images.githubusercontent.com/61089745/141662816-3e911c89-d405-43c9-9daa-60db2f6c1ec3.png)


No API anterior utilizamos o front-end web para integrar com a nossa aplicação em Python. Nesse novo projeto pude obter novo conhecimento e a vivência de realizar um projeto em desktop, com o desafio em realizar o front-end usando a ferramenta JavaFX. Para quem não conhecia nada sobre o mundo de tecnologia, juntamente com a FATEC pude aprender essas duas formas de aplicação.

![FX](https://user-images.githubusercontent.com/61089745/141662854-8bcebc08-1a5f-4cbb-b200-9bc2c57e8858.PNG)


Tive meu primeiro contato com o Banco de Dados conhecendo os principais comandos como criar uma Database, Tabelas utilizando o método CRUD (Create, Read, Update e Delete) é uma sigla utilizada para se referir às quatro operações básicas realizadas em banco de dados relacionais que são consulta, inclusão, alteração e exclusão dos registros. É um conhecimento básico que todo programador deve saber e com esses comandos é possível replicar em outros bancos de dados. Segue explanação de alguns comandos:

- O comando INSERT é usado para inserir dados em uma tabela do banco;

- O comando UPDATE é o responsável por fazer edições em registros que já constam no banco. Essa instrução é muito importante já que ela permite corrigir ou complementar os dados, garantindo que o banco tenha sempre informações atualizadas;

- O comando DELETE é utilizado para excluir informações da nossa base de dados;

- O comando SELECT é um dos comandos SQL mais importantes, pois com ele podemos elaborar diversas consultas aos registros da nossa base de dados;

- O comando CREATE é usado sempre que precisamos criar novos objetos na base de dados;

- o comando ALTER é utilizado quando precisamos alterar a estrutura de um objeto que já existe na base de dados.

Conhecemos outra ferramenta de repositório o GIT Hub, tinhamos a vivência com a o GIT Lab e resolvemos conhecer outra ferramenta para aumentar nossas perspectivas e efetivar nossos aprendizados. Conseguimos aplicar os comando aprendidos no GIT Lab, reforçando os códigos via terminal (CMD).

