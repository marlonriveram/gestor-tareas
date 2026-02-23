# 📝 Gestor de Tareas API

API REST desarrollada con Spring Boot para la gestión de tareas con autenticación JWT y control de acceso por roles.

La aplicación está completamente contenerizada con Docker y desplegada en producción usando Render.

---

## 🚀 Descripción

Gestor de Tareas es una API backend que permite:

- Registro de usuarios
- Autenticación con JWT
- CRUD completo de tareas
- Seguridad con Spring Security
- Persistencia en PostgreSQL
- Contenerización con Docker

---

## 🛠 Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- BCrypt
- PostgreSQL
- Docker
- Docker Compose
- pgAdmin
- Render (deploy)

---

## 🔐 Autenticación

La API utiliza autenticación basada en JWT.

### Flujo:

1. El usuario se registra.
2. Hace login.
3. El servidor genera un token JWT.
4. El cliente debe enviar el token en cada request protegida:


---

## 🌍 Deploy en producción

La API está desplegada en Render: https://gestor-tareas-lc9r.onrender.com


---

## 📌 Endpoints principales

### 🔑 Auth

#### Registrar usuario
POST /auth/register

#### Login
POST /auth/login

Devuelve un JWT.

---

### 📋 Tareas (requiere JWT)

#### Crear tarea
POST /tasks

#### Obtener tareas
GET /tasks
El rol user solo puede ver sus tareas el admin puede ver todas

#### Obtener tarea por id
GET /tasks/{idTarea}
#### Actualizar tarea
PUT /tasks/{idTarea}

#### Eliminar tarea
DELETE /tasks/{idTarea}

---

## 🐳 Ejecutar el proyecto con Docker

### 1️⃣ Clonar repositorio

https://github.com/marlonriveram/gestor-tareas


---

### 2️⃣ Levantar contenedores
docker-compose up --build


Esto levantará:

- PostgreSQL (puerto 5432)
- pgAdmin (http://localhost:5050)
- Backend (http://localhost:8080)

---

## 🗄 Configuración de base de datos

### PostgreSQL

- DB: gestor_tareas
- User: marlon
- Password: 1234
- Puerto: 5432

---

### pgAdmin

- URL: http://localhost:5050
- Email: admin@admin.com
- Password: admin123

---

## ⚙ Variables de entorno

La aplicación usa variables de entorno para la conexión a la base de datos:
DB_URL
DB_USERNAME
DB_PASSWORD


Ejemplo en docker-compose:
DB_URL=jdbc:postgresql://postgres:5432/gestor_tareas
DB_USERNAME=marlon
DB_PASSWORD=1234


## 📂 Estructura del proyecto

src/main/java
├── controller
├── service
├── repository
├── security
└── config


---

## 🧪 Cómo probar la API

Se puede probar usando:

- Postman
- Insomnia
- Thunder Client

### Ejemplo Login

---

## 🧪 Cómo probar la API

Se puede probar usando:

- Postman
- Insomnia
- Thunder Client

### Ejemplo Login

POST /auth/login

{
"email": "user@email.com
",
"password": "123456"
}
retorna tokek
Luego usar el token en los endpoints protegidos.

## 📌 Autor

Marlon Mosquera Rivera  
Backend Developer

⚠ Las credenciales mostradas son solo para entorno local.


