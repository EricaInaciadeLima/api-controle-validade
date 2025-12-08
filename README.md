
# 🧪 Backend – Sistema de Controle de Validade de Produtos

Este é o **backend** do sistema de controle de validade, responsável pelo gerenciamento de produtos, categorias, empresas, perfis de acesso e autenticação.  
Foi desenvolvido em **Spring Boot 3**, utilizando **JPA**, **MySQL**, **JWT** e **Spring Security**.

---

## 📌 Objetivo do Sistema

O sistema foi desenvolvido para **automatizar o controle de validade**, reduzindo perdas e melhorando a gestão de estoque.  
Baseado em:

- Entrevista com a proprietária do estabelecimento;  
- Análise das perdas e falhas do controle manual;  
- Identificação de limitações como falta de alertas, registros inconsistentes e ausência de rastreamento;  
- Proposta de um sistema digital com **alertas antecipados**, cadastros estruturados e autenticação segura.

---

## 🏛️ Arquitetura do Backend

O backend segue boas práticas:

- Arquitetura em camadas (Controller, Service, Repository, Model)
- Entidades representando tabela no banco:
  - **Perfil**
  - **Empresa**
  - **Categoria**
  - **Produto**
- Autenticação com **JWT**
- Perfis de usuário (Administrador e Usuário)
- Integração com MySQL

---

## 🔧 Tecnologias Utilizadas

### **Linguagem e Framework**
- Java 17
- Spring Boot 3.5.7

### **Módulos Spring**
- Spring Web
- Spring Data JPA
- Spring Security
- Spring Boot Validation

### **Banco de Dados**
- MySQL 8
- (H2 como banco em memória para testes)

### **Bibliotecas Extras**
- Lombok
- Java JWT (Auth0)
- DevTools

---

## 📦 Arquivo `pom.xml`

Principais dependências incluídas:

- **JPA**  
- **Web**  
- **Spring Security**  
- **JWT (Auth0)**  
- **MySQL Connector**  
- **H2 (runtime)**  
- **Lombok**  
- **Spring Boot Test**  

---

## ⚙️ Configuração do `application.properties`

Exemplo recomendado:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/controlevalidadedb?useSSL=true&serverTimezone=America/Sao_Paulo
spring.datasource.username=root
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

spring.servlet.multipart.max-file-size=20MB
spring.servlet.multipart.max-request-size=20MB
```

---

## 🗄️ Script SQL Inicial (MySQL)

O SQL completo das tabelas está no arquivo `/sql/init.sql`, mas pode ser gerado automaticamente pelo JPA.  
O banco utilizado é:

```
controlevalidadedb
```

---

## 🚀 Como Executar o Projeto

### **1. Clonar o repositório**

```bash
git clone https://github.com/seu-repo/controlevalidade-backend.git
```

### **2. Configurar MySQL**

Criar banco:

```sql
CREATE DATABASE controlevalidadedb;
```

### **3. Instalar dependências**

```bash
mvn clean install
```

### **4. Iniciar o servidor**

```bash
mvn spring-boot:run
```

Servidor rodará em:

```
http://localhost:8080
```

---

## 🔒 Autenticação e Segurança

O sistema utiliza:

- **Spring Security**
- **Tokens JWT**
- Perfis:
  - `ADMINISTRADOR`  
  - `USUARIO`

O usuário administrador tem permissões ampliadas (criação de empresa, categorias, gerenciar perfis).


---

## 🔔 Funcionalidades Principais

- Cadastro de empresas  
- Cadastro de categorias  
- Cadastro e gerenciamento de produtos  
- Registro de data de fabricação e validade  
- Geração automática de data de alerta  
- Perfis com permissões diferentes  
- Login e geração de token JWT  
- Filtros por validade, empresa, categoria  

