**chuOK** es una aplicación web diseñada como un refugio digital para combatir el estrés cotidiano y el burnout, especialmente en el sector tecnológico. Su nombre proviene del término coreano "추억" (chu-eok), que significa "recuerdo", evocando una experiencia nostálgica, relajante y enriquecedora. Su misión es transformar el tiempo libre en una aventura de aprendizaje activo y entretenimiento consciente.

## Tecnologías utilizadas

### Frontend
- Angular 17
- TypeScript
- HTML5 / CSS3
- Angular CLI
- JWT (para autenticación)
- Diseño responsive y enfocado en UX

### Backend
- Java 17
- Spring Boot 3
- Spring Security (con JWT)
- Spring Data JPA
- Maven

### Base de datos
- MySQL (contenedor Docker)
- Hibernate (ORM automático)

---

## Estructura del proyecto

```

chuOK/
├── chuok-frontend/       # SPA en Angular
└── chuok-backend/        # API RESTful en Spring Boot

````

---

## Instalación y ejecución

### Requisitos previos

- Node.js v18+ y npm v10+
- Java JDK 17
- Maven
- Docker
- Navegador moderno (Chrome, Firefox, Edge, Safari)

### 1. Base de datos con Docker

```bash
docker run --name mysql-chuok -e MYSQL_ROOT_PASSWORD=rootpass \
-e MYSQL_DATABASE=chuok_db -e MYSQL_USER=chuok -e MYSQL_PASSWORD=chuokpass \
-p 3306:3306 -d mysql:8.0
```

### 2. Backend (Spring Boot)

```bash
cd chuok-backend
mvn spring-boot:run
```

Por defecto se ejecuta en `http://localhost:8080`.

### 3. Frontend (Angular)

```bash
cd chuok-frontend
npm install
ng serve
```

Por defecto se ejecuta en `http://localhost:4200`.

---

## Funcionalidades principales

### Modo Relajado

* Acceso a frases célebres, artículos breves y datos curiosos.
* Navegación visual tipo cartelera.

### Modo Aventura

* Mundos temáticos (Literatura, Ciencia, Naturaleza).
* Niveles con preguntas tipo test.
* Progreso guardado por usuario.
* Desbloqueo progresivo de contenido.

### Centro de Usuario

* Estadísticas de uso y progreso.
* Configuración de cuenta y preferencias.

### Administración

* Panel para gestionar contenido.
* Acceso restringido por rol.

---

## Autenticación

* Registro e inicio de sesión con email y contraseña.
* Token JWT guardado en `localStorage`.
* Rutas protegidas según rol de usuario.
* Guards en Angular + validaciones de sesión.

---

## Documentación adicional

Toda la arquitectura del sistema, el diseño lógico, análisis del modelo de datos, E/R, autenticación y conexión entre capas se detalla en el documento `chuOK-Documentación.pdf` incluido en este repositorio.

---

## Próximas mejoras

* Ampliación de mundos temáticos.
* Sistema de notificaciones.
* Integración con API externa para contenido dinámico.
* Mejora del sistema de logros y recompensas.

---

## Autor

Samuel Tineo Herrera
I.E.S. Kursaal — Curso 2024/2025
