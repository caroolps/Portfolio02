## 📚 Seções Portfólios

<h4 align="left"><a href="https://github.com/caroolps/Portfolio01">PROJETO 1º SEMESTRE: Mapeador de Criminalidade ao Redor da FATEC</a></h4>
<h4 align="left"><a href="https://github.com/caroolps/Portfolio02">PROJETO 2º SEMESTRE: Gantt Chart</a></h4>
<h4 align="left"><a href="https://github.com/caroolps/Portfolio03">PROJETO 3º SEMESTRE: Cadastro Positivo</a></h4>
<h4 align="left"><a href="https://github.com/caroolps/Portfolio04">PROJETO 4º SEMESTRE: Projeto04</a></h4>
<h4 align="left"><a href="https://github.com/caroolps/Portfolio05">PROJETO 5º SEMESTRE: Projeto05</a></h4>

![image](https://user-images.githubusercontent.com/61089745/158082449-894548ea-e14d-4de7-896d-12d2a9ec1d74.png)

## FATEC & NECTO - GANTT CHART:chart_with_upwards_trend:

### **I - RESUMO DO PROJETO**:page_facing_up: 

Neste segundo Projeto Integrador a FATEC trouxe o primeiro Cliente "NECTO" para que pudéssemos achar uma solução tecnológica para sanar e atender às necessidades do cliente. 
 
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

### Proposta:

A solução proposta pela equipe consiste numa aplicação visual de planejamento estratégico e gerenciamento de tempo dos seus recursos humanos em projetos de desenvolvimento de softwares (seu core business).

Nesse passo, como característica principal, da qual decorrem as funcionalidades (requisitos), a aplicação deve possibilitar a alocação dos recursos humanos em um gráfico de GANTT (tarefas em linhas de tempo), gerando métricas sobre a ocupação e o tempo disponível da equipe para novos projetos e contingências. 

A GUI (Graphical User Interface) permitirá o planejamento colaborativo sobre o uso do tempo, v.g. mudanças de pessoas em tarefas/projetos, cobertura de ausências/férias de colaboradores, determinação de data de início de novos projetos, carga de trabalho por colaborador etc. Será utilizado o Java como linguagem de programação.

 
 1- Estrutura do projeto dividido em camadas:
 
 ![Estrutura](https://user-images.githubusercontent.com/61089745/141656917-4c7bceb8-5ca6-4b42-8643-a97302af5c39.PNG)

2- Modelagem Conceitual para ser implantada no Banco de Dados MYSQL.

![image](https://user-images.githubusercontent.com/61089745/159168697-161066df-df89-4150-8130-134cf4fcb36e.png)

3- Modelagem utilizada no Banco de Dados no MYSQL

![ModelagemBD](https://user-images.githubusercontent.com/61089745/141656954-10700f13-b26b-4513-b51b-a5a20a4429e6.PNG)

4- Tela de Login.

![Login](https://user-images.githubusercontent.com/61089745/141656980-681987ac-1e9d-4fe9-bceb-9d83434fb975.PNG)

5- Tela de Cadastro do Projeto com possibilidade de editar, excluir e cadastrar um novo projeto conectado ao banco de dados.

![CadastroProjetosII](https://user-images.githubusercontent.com/61089745/141657004-75236913-3a62-4006-990a-4f89f0475a45.PNG)

6- Tela de Cadastro do Funcionário com possibilidade de editar, excluir e cadastrar um novo funcionário conectado ao banco de dados.

![CadastroFuncionarios](https://user-images.githubusercontent.com/61089745/141657014-8a8603a8-4cef-4aad-8837-1d5aa535aebd.PNG)

7- Tela de Cadastro da Tarefa com possibilidade de editar, excluir e cadastrar uma nova tarefa conectado ao banco de dados.

![CadastroTarefa](https://user-images.githubusercontent.com/61089745/141657029-41bfd888-73e2-4c8c-a9d2-26a065968dc2.PNG)

8- Gráfico de Gantt interativo sendo exibido conforme o projeto selecionado e apresentando cada tarefa com a data de início e final e suas dependências. Seu atrativo é a interação do usuário por meio de arrastar e soltar e redimensionar as tarefas.

![Gantt2](https://user-images.githubusercontent.com/61089745/141657083-849746d2-3416-47e8-b1b2-66174241bb95.PNG)

### **II - TECNOLOGIAS**:iphone:

Para conciliar o aprendizado com as matérias lecionadas na FATEC, escolhemos a linguagem Java para desenvolver o backend e o Banco de Dados MySQL.

Desta forma, contamos com a orientação dos Docentes e muita pesquisa em fóruns virtuais especializados para implementar blocos de códigos com propósito específico.

As bibliotecas e tecnologias utilizadas foram:

![image](https://user-images.githubusercontent.com/61089745/159168843-037664ad-a6e9-4904-bbe2-1c6550074487.png)
- JavaFx: É uma ferramenta utilizada para desenvolver aplicações desktop em java, usamos essa tecnologia para desenvolver o front-end do projeto. Por termos pouco conhecimento em JAVA e o medo de não consegui integrar o back-end com o um front-end web, após pesquisas e decisão da maioria do grupo optamos em desenvolver nosso front através dessa ferramenta por acharmos ser mais fácil o aprendizado.

![image](https://user-images.githubusercontent.com/61089745/159168925-40f2b5c3-7045-4e25-9001-95c5b0265a07.png)
- Gantt / Nebula: É uma biblioteca java que usamos para gerar o gráfico de GANTT totalmente personalizável para exibir qualquer coisa, desde um gráfico simples até permitir a interação do usuário por meio de arrastar e soltar e redimensionar, bem como interação de dependência. Essa foi a segunda biblioteca que testamos e deu certo. Mas primeiramente tentamos implementar JFreeCharts porém não obtemos sucesso. 

![image](https://user-images.githubusercontent.com/61089745/159169361-0272df44-578c-44f1-8e5a-b782d6d8d9aa.png)

![image](https://user-images.githubusercontent.com/61089745/159169018-69d92f91-43cd-4b91-a263-dc388bea6206.png)
- Calendar: Essa biblioteca pode produzir os valores de todos os campos de calendário necessários para implementar a formatação de data e hora, para uma determinada língua e estilo de calendário. Usamos juntamente com o Gantt para mostrarmos a data de início e final de cada tarefa e dependência no gráfico de Gantt.

![image](https://user-images.githubusercontent.com/61089745/159169623-6ea5e2bb-e02d-44d6-ac19-b1dd2f28bcdb.png)

![image](https://user-images.githubusercontent.com/61089745/159169090-839cbec0-693a-4082-b88d-d949e0fefe38.png)
- Java: É uma linguagem de programação orientada a objetos utilizamos em nosso back-end.

![image](https://user-images.githubusercontent.com/61089745/159169148-5692d55d-ca9e-4895-be96-625d263b0669.png)
- Eclipse: Eclipse é uma IDE para desenvolvimento Java.

![image](https://user-images.githubusercontent.com/61089745/159169211-28a70adb-35f2-4903-a540-f82d9a705f12.png)
- MySQL: É um sistema de gerenciamento de banco de dados, que utiliza a linguagem SQL como interface. É atualmente um dos sistemas de gerenciamento de bancos de dados mais populares da Oracle Corporation. Por isso, escolhemos esse sistema para integrar com o nosso backend em java.

![image](https://user-images.githubusercontent.com/61089745/159169247-e093f789-1d04-4b26-a505-0a63e103854f.png)
- Scrum: Continuamos a usar a metodologia scrum aprendida no primeiro semestre para realizar as entregas do projeto.


### **III - CONTRIBUIÇÕES INDIVIDUAIS**:bow:

No segundo semestre iniciamos o aprendizado de Linguagem De Programação I, onde estava sendo lecionado sobre a linguagem JAVA, com isso foi possível conciliar o que estávamos aprendendo em aula e aplicar em nosso projeto, eu contribuí com o projeto criando as principais camadas do backend como:
- Entidades: Fiquei responsável pelas classes Projeto, Tarefa, Cadastro de tarefa e Cadastro de projeto orientada ao objeto utilizando os métodos getters, setters e o serializable é o processo no qual a instância de um objeto é transformada em uma sequência de bytes e é útil quando precisamos enviar objetos pela rede, salvar no disco, ou comunicar de uma JVM com outra;

![image](https://user-images.githubusercontent.com/61089745/159169699-dfe50252-5231-4f46-9f50-59818fe1d29a.png)

- Controller: Criei as classes controller do Projeto, Tarefa e Cadastros. Como estávamos usando a aplicação desktop tive que fazer duas classes controller para cada entidade uma com a extensão .java e outra com extensão .fxml para realizar a conexão com o javaFx nosso front-end. 

![image](https://user-images.githubusercontent.com/61089745/159169759-8a539543-a237-4916-a401-51d76b18337b.png)

- Service: Criei as classes Tarefa Service e Cadastro Service definindo seus métodos na interface DAO.

![image](https://user-images.githubusercontent.com/61089745/159169814-d3fb6451-1ff3-4020-9180-986632f29b24.png)

 
- Service implements: Criei as classes Tarefa e Cadastro e implementei os métodos definidos no Service com inteface DAO usando o JDBC.

Java Database Connectivity (JDBC) é um conjunto de classes e interfaces escritas em Java que fazem o envio de instruções SQL para qualquer banco de dados relacional; 

![image](https://user-images.githubusercontent.com/61089745/159169869-cdce5c98-f316-4d85-92cd-ef6443e27b18.png)


- Classes DAO para conexão com o Banco de Dados: Criei as classes Tarefas e Cadastros para passar os métodos insert, delete, update e lista nas classes.

![image](https://user-images.githubusercontent.com/61089745/159169945-ab313558-718b-4325-b564-60f6e6f67230.png)


JAVAFX: Desenhei as telas para exibição do cadastro, edição e deleção da classe Tarefa, Projeto e Funcionário.

![CadastroTarefa](https://user-images.githubusercontent.com/61089745/141662165-caf52ddc-0949-4b67-92d0-59bc7fb3d766.PNG)

MYSQL:Tive meu primeiro contato com o banco de dados, conseguimos conciliar o aprendizado da matéria Arquitetura e Modelagem de Banco de Dados e aplicarmos em nosso projeto. Eu contribuí criando as tabelas Funcionário, Tarefa e Projetos, passando seus atributos e dimensões.

![image](https://user-images.githubusercontent.com/61089745/141662257-f06ecc37-cb7f-4212-a92e-0aaef1580655.png)



### **IV - APRENDIZADOS EFETIVOS**:closed_book:

**Hard Skills Efetivamente Desenvolvidas:**

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

- O comando ALTER é utilizado quando precisamos alterar a estrutura de um objeto que já existe na base de dados.

Conhecemos outra ferramenta de repositório o GIT Hub, tinhamos a vivência com a o GIT Lab e resolvemos conhecer outra ferramenta para aumentar nossas perspectivas e efetivar nossos aprendizados. Conseguimos aplicar os comando aprendidos no GIT Lab, reforçando os códigos via terminal (CMD).

- Conhecimento referente a IDE Eclipse.

**Soft Skills Efetivamente Desenvolvidas:**

E no final do projeto, com um semestre conturbado de incertezas e pandemia aprendemos mais sobre o soft skill, sabendo trabalhar em grupo, lidar melhor com os colegas e respeitar as limitações de cada um. Tivemos dois integrantes da equipe que deixaram o grupo por questões de saúde e consequentimente nos redobramos para entregar as sprints. Além desse desafio foi nosso primeiro contato com o cliente externo e conseguimos aperfeiçoar a comunicação, entendimento, criação de requisitos, definições de prioridade e como elaborar uma boa apresentação.
