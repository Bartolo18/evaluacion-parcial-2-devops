# Proyecto Biblioteca DUOC - Microservicio de Gestión de Préstamos

## Descripción del Microservicio

`bibliotecaduoc` es un microservicio desarrollado en **Spring Boot 3.5.0** y **Java 21**, diseñado para la administración de solicitudes de préstamos de libros dentro de la biblioteca de la institución.

El servicio gestiona los registros en memoria mediante colecciones de Java y calcula campos clave como el RUT del solicitante, el código del libro, las fechas de solicitud y entrega, los días de préstamo y las multas.

Es una solución ligera y autocontenida que permite validar un ciclo completo de integración continua, análisis de calidad, seguridad, contenerización y despliegue automatizado.

---

## Tecnologías Utilizadas

* **Java 21** / Eclipse Temurin
* **Spring Boot 3.5.0**
* **Maven**
* **Docker**
* **Docker Compose**
* **Git**
* **GitHub**
* **GitHub Actions**
* **JaCoCo**
* **Snyk Security Scan**
* **SonarCloud**

---

## Requisitos Previos

Para ejecutar el proyecto localmente se requiere:

* JDK 21 instalado.
* Apache Maven 3.9 o superior.
* Docker Desktop instalado y activo.
* Git instalado.
* Acceso al repositorio en GitHub.

---

## Instrucciones de Ejecución y Compilación Local

### 1. Ejecución con Maven

Para compilar, validar y levantar la aplicación de manera local:

#### Ejecutar pruebas unitarias

```bash
mvn clean test
```

#### Ejecutar pruebas y generar cobertura con JaCoCo

```bash
mvn clean verify
```

El reporte HTML de cobertura queda disponible en:

```text
target/site/jacoco/index.html
```

#### Construir el archivo JAR

```bash
mvn clean package
```

Esto genera el archivo ejecutable en la carpeta `target`.

---

## Ejecución con Docker

### 1. Construir la imagen Docker

```bash
docker build -t bibliotecaduoc:latest .
```

### 2. Ejecutar el contenedor

```bash
docker run -d -p 8082:8082 --name bibliotecaduoc-container bibliotecaduoc:latest
```

---

## Ejecución con Docker Compose

Docker Compose permite levantar el microservicio de forma reproducible y ordenada.

### Levantar el entorno

```bash
docker compose up --build
```

### Detener y limpiar los contenedores

```bash
docker compose down
```

---

## Endpoints Disponibles y Pruebas con Curl

Una vez que la aplicación esté corriendo en el puerto `8082`, se pueden ejecutar las siguientes pruebas desde la terminal.

### Listar todas las solicitudes de préstamo

```bash
curl http://localhost:8082/api/v1/solicitudes
```

Respuesta esperada inicial:

```json
[]
```

Esto indica que el arreglo en memoria se inició correctamente vacío.

### Listar solicitudes ordenadas por ID de préstamo

```bash
curl http://localhost:8082/api/v1/solicitudes/ordenados
```

---

## Pipeline CI/CD con GitHub Actions

El proyecto cuenta con un pipeline de integración continua configurado en GitHub Actions.

El workflow se encuentra en:

```text
.github/workflows/main.yml
```

El pipeline se ejecuta ante eventos como:

* `push` a la rama `main`
* `push` a la rama `develop`
* `push` a ramas `feature/**`
* `pull_request` hacia ramas principales del proyecto

---

## Flujo del Pipeline

El pipeline contempla las siguientes etapas:

```text
Snyk Security Scan → Run Tests with JaCoCo → SonarCloud Analysis → Build JAR / Docker
```

---

## Detalle de las Etapas del Pipeline

### 1. Snyk Security Scan

Escanea el archivo `pom.xml` en busca de dependencias vulnerables, especialmente aquellas con severidad alta.

Se utiliza para apoyar el análisis de seguridad del proyecto dentro del flujo de integración continua.

### 2. Run Tests with JaCoCo

Ejecuta las pruebas automatizadas mediante Maven:

```bash
mvn clean verify
```

Además, genera un reporte de cobertura con JaCoCo y lo deja disponible como artefacto descargable dentro de GitHub Actions.

### 3. SonarCloud Analysis

Analiza el código fuente y las métricas del proyecto mediante SonarCloud.

Este análisis permite revisar:

* Calidad del código.
* Mantenibilidad.
* Bugs.
* Duplicación.
* Seguridad.
* Cobertura asociada a las pruebas.

### 4. Build JAR

Compila el empaquetado final del microservicio:

```bash
mvn clean package
```

### 5. Docker Build

Valida que el microservicio pueda ser contenerizado correctamente mediante:

```bash
docker build -t bibliotecaduoc:latest .
```

### 6. Docker Compose Config

Verifica que la configuración de orquestación sea válida:

```bash
docker compose config
```

---

## Estrategia de Ramas en Git

Se utilizó una estrategia simple para mantener el orden del desarrollo.

### Ramas principales

* `main`: contiene el código estable de la entrega final.
* `develop`: rama de integración donde se consolidaron los avances antes de pasarlos a `main`.

### Ramas de trabajo

* `feature/docker-compose`
* `feature/github-actions`
* `feature/seguridad-cobertura`
* `feature/security`

Estas ramas permitieron separar las tareas técnicas del proyecto y mantener una trazabilidad más clara del avance.

---

## Calidad y Seguridad

El proyecto incorpora herramientas para mejorar la calidad y seguridad del microservicio:

* Pruebas automatizadas con Maven.
* Cobertura de pruebas con JaCoCo.
* Análisis de calidad con SonarCloud.
* Escaneo de dependencias con Snyk.
* Construcción de imagen Docker.
* Validación de Docker Compose.
* Ejecución automática del pipeline en GitHub Actions.

---

## Contenerización y Orquestación

El proyecto incluye:

```text
Dockerfile
docker-compose.yml
```

El `Dockerfile` permite construir una imagen del microservicio.

El archivo `docker-compose.yml` permite orquestar la ejecución del contenedor de forma reproducible, facilitando el despliegue simulado solicitado en la evaluación.

---

## Trazabilidad del Proyecto

La trazabilidad se garantiza mediante:

* Historial de commits.
* Uso de ramas por tipo de tarea.
* Pull Requests.
* Pipeline ejecutado en GitHub Actions.
* Reportes de cobertura.
* Análisis en SonarCloud.
* Escaneo de seguridad con Snyk.
* Documentación en README.

Esto permite seguir el recorrido del proyecto desde el desarrollo hasta la validación final.

---

## Declaración de Uso de Inteligencia Artificial

Durante la preparación de esta entrega se utilizaron herramientas de Inteligencia Artificial como apoyo para:

* Ordenar la documentación.
* Revisar comandos de Docker y Maven.
* Corregir sintaxis del archivo YAML del pipeline.
* Apoyar la comprensión de errores técnicos.

Toda configuración y código sugerido fue revisado, corregido y validado por los integrantes del equipo.

Las reflexiones y conclusiones personales fueron desarrolladas manualmente por cada integrante.

---

## Instrucción de Entrega

Para realizar la entrega formal de esta evaluación se debe:

1. Verificar que todos los cambios estén integrados en la rama `main`.
2. Confirmar que el pipeline de GitHub Actions esté exitoso.
3. Revisar que el README y las conclusiones estén incluidos.
4. Subir el enlace del repositorio de GitHub en la plataforma AVA de DUOC UC.

---

## Integrantes

* Marco Suárez
* Bárbara Tolorza
