# 🎓 Aluno Online — API REST com Spring Boot

API REST completa para sistema acadêmico da UNIESP.  
Desenvolvida com Java 21 + Spring Boot + PostgreSQL.

---

## 🚀 Pré-requisitos

- Java 21 instalado
- Maven instalado (ou use o `./mvnw` incluído)
- PostgreSQL instalado e rodando

---

## ⚙️ Configuração do Banco de Dados

1. Abra o pgAdmin ou psql e crie o banco:
```sql
CREATE DATABASE aluno_online;
```

2. Verifique o arquivo `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/aluno_online
spring.datasource.username=postgres
spring.datasource.password=123
```
> Ajuste `username` e `password` conforme sua instalação do PostgreSQL.

---

## ▶️ Como rodar

```bash
# Na pasta raiz do projeto:
./mvnw spring-boot:run

# Ou com Maven instalado:
mvn spring-boot:run
```

A API sobe em: **http://localhost:8080**  
Swagger UI em: **http://localhost:8080/swagger-ui.html**

---

## 📋 Endpoints para testar no Insomnia

### 👨‍🎓 Alunos

| Método | URL | Body | Retorno |
|--------|-----|------|---------|
| POST | `/alunos` | `{"nome":"Maria Silva","cpf":"111.222.333-44","email":"maria@email.com"}` | 201 |
| GET | `/alunos` | — | 200 + lista |
| GET | `/alunos/{id}` | — | 200 + aluno |
| PUT | `/alunos/{id}` | `{"nome":"Maria S.","cpf":"111.222.333-44","email":"maria@email.com"}` | 204 |
| DELETE | `/alunos/{id}` | — | 204 |

### 👨‍🏫 Professores

| Método | URL | Body | Retorno |
|--------|-----|------|---------|
| POST | `/professores` | `{"nome":"Prof. Carlos","email":"carlos@uniesp.edu.br","cpf":"999.888.777-66"}` | 201 |

### 📖 Disciplinas

| Método | URL | Body | Retorno |
|--------|-----|------|---------|
| POST | `/disciplinas` | `{"nome":"Backend Spring","cargaHoraria":80,"professor":{"id":1}}` | 201 |
| GET | `/disciplinas/professor/{professorId}` | — | 200 + lista |

### 📝 Matrículas

| Método | URL | Body | Retorno |
|--------|-----|------|---------|
| POST | `/matriculas` | `{"aluno":{"id":1},"disciplina":{"id":1}}` | 201 |
| PATCH | `/matriculas/trancar/{id}` | — | 204 |
| PATCH | `/matriculas/atualizar-notas/{id}` | `{"nota1":8.0,"nota2":7.5}` | 204 |
| GET | `/matriculas/emitir-historico/{alunoId}` | — | 200 + histórico |

---

## 🧪 Fluxo de teste sugerido no Insomnia

1. **POST** `/professores` → cria professor (anote o `id`)
2. **POST** `/disciplinas` → cria disciplina vinculada ao professor
3. **POST** `/alunos` → cria aluno (anote o `id`)
4. **POST** `/matriculas` → matricula o aluno na disciplina
5. **PATCH** `/matriculas/atualizar-notas/{id}` → lança as notas
6. **GET** `/matriculas/emitir-historico/{alunoId}` → vê o histórico completo

---

## 📂 Estrutura do projeto

```
src/main/java/br/com/alunoonline/api/
├── AlunoOnlineApplication.java
├── model/          → Entidades JPA
├── repository/     → Acesso ao banco
├── service/        → Regras de negócio
├── controller/     → Endpoints REST
├── dtos/           → DTOs de request e response
└── enums/          → MatriculaAlunoStatusEnum
```
