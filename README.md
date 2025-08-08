# Projeto Back-end: Sistema de Produtos

É uma aplicação desenvolvida para gerenciar o cadastro, consulta, atualização e exclusão de produtos em uma empresa. Ele permite o controle eficiente do estoque, facilitando o registro de informações detalhadas sobre cada produto, como nome, categoria, preço, quantidade disponível e fornecedor. O sistema oferece uma interface intuitiva para os usuários, possibilitando a busca rápida de produtos, geração de relatórios e integração com outros módulos empresariais. Seu objetivo é otimizar a gestão de produtos, reduzir erros operacionais e fornecer dados precisos para a tomada de decisões estratégicas.

## Tecnicologias Utilizadas 

Utilizei as seguintes tecnologias no Projeto para fazer a API Back-end desse sistema, que são: 

<div align="left">
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" width="100" />
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original.svg" width="90" />
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/hibernate/hibernate-original.svg" width="90"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/docker/docker-original.svg" width="90"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/sqlite/sqlite-original.svg" width="90"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/postman/postman-original.svg" width="90"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/swagger/swagger-original.svg" width="90"/>
</div>

<br>

- Java
- Spring Boot
- Hibernate
- Docker
- SQLite
- Postman
- Swagger

## Imagem do modelo Conceitual do Banco de dados 

Foi criado o modelo diagramal do banco de dados para entender sua estrutura como se encaixaria dentro do projeto que esta sendo criado, dessa forma abaixo que esta presente ai:.

<img src="src/main/java/com/igor_nascimento/sistema_produtos/docs/Sistema de Produtos.png"/>

<br>

Clicando aqui tambem vc poder ver o PDF de forma mais detalhada o Diagrama de Tabelas e seus campos
[Diagrama em PDF](/src/main/java/com/igor_nascimento/sistema_produtos/docs/Tabelas%20do%20Banco%20de%20dados%20do%20sistema%20de%20Produtos.pdf)

## Pré-requisitos 
Para rodar este projeto em qualquer máquina após clonar o repositório, certifique-se de ter os seguintes pré-requisitos:

1. **Java JDK 21 ou superior** instalado e configurado na variável de ambiente `PATH`.
2. **Maven** instalado (ou utilize o wrapper `mvnw`/`mvnw.cmd` já presente no projeto).
3. **Git** instalado para clonar o repositório.
4. (Opcional) **Docker** e **Docker Compose**, caso queira rodar dependências via containers.
5. Não é necessário instalar banco de dados manualmente, pois o projeto utiliza **SQLite** (arquivo já incluso no repositório).

## Passos para rodar o projeto

Siga os passos abaixo para configurar e rodar o backend da aplicação:

1. **Clone o repositório:**
	```bash
	git clone https://github.com/[seu-usuario]/[nome-do-repositorio].git
	cd [nome-do-repositorio]
	```

2. **(Opcional) Navegue até o diretório do projeto Spring Boot:**
	Caso o projeto esteja em uma subpasta, navegue até ela. Neste caso, já está na raiz correta.

3. **Banco de dados:**
	- O projeto utiliza SQLite, então não é necessário criar o banco manualmente. O arquivo `database.sqlite` já está incluso e será utilizado automaticamente.
	- Caso deseje alterar configurações, edite o arquivo `application.yml` em `src/main/resources`.

4. **Execute a aplicação Spring Boot usando Maven:**
	- **No Windows:**
	  ```shell
	  mvnw.cmd spring-boot:run
	  ```
	- **No Linux/Mac:**
	  ```shell
	  ./mvnw spring-boot:run
	  ```

O backend estará disponível em `http://localhost:8080` (ou na porta configurada em seu `application.yml`).

## 📑 Documentação Interativa da API (Swagger)
<br>
<div align="center">
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/swagger/swagger-original.svg" width="90"/>
</div>
<br>
Este projeto conta com uma documentação interativa gerada automaticamente pelo Swagger, onde você pode visualizar, testar e entender todos os endpoints disponíveis da API.

Após iniciar a aplicação, acesse:

👉 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Ou, dependendo da configuração:

👉 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

Nessa interface, é possível realizar requisições diretamente pelo navegador, explorar os métodos disponíveis e ver exemplos de payloads e respostas.

## 🐳 Como rodar com Docker
<br>
<div align="center">
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/docker/docker-original.svg" width="90"/>
</div>
<br>
Você pode executar o sistema de produtos facilmente usando Docker ou Docker Compose. Isso garante que o ambiente esteja padronizado e pronto para uso, sem necessidade de instalar dependências manualmente.

### Usando Docker Compose

1. Certifique-se de ter o Docker e o Docker Compose instalados em sua máquina.
2. Gere o arquivo JAR do projeto (caso ainda não tenha):
	```bash
	./mvnw clean package
	# ou no Windows
	mvnw.cmd clean package
	```
3. Execute o comando abaixo na raiz do projeto:
	```bash
	docker-compose up --build
	```
4. O backend estará disponível em: [http://localhost:3000](http://localhost:3000)

### Usando apenas Docker

1. Gere o arquivo JAR do projeto (caso ainda não tenha):
	```bash
	./mvnw clean package
	# ou no Windows
	mvnw.cmd clean package
	```
2. Construa a imagem Docker:
	```bash
	docker build -t sistema_produtos .
	```
3. Rode o container:
	```bash
	docker run -p 3000:8080 --name sistema_produtos sistema_produtos
	```
4. O backend estará disponível em: [http://localhost:3000](http://localhost:3000)

> **Obs.:** O arquivo JAR gerado deve estar em `./target/sistema_produtos-0.0.1-SNAPSHOT.jar` para que o Docker funcione corretamente.


