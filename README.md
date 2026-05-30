# Proyecto Biblioteca DUOC - Microservicio de Gestión de Préstamos

## Descripción del Microservicio
bibliotecaduoc es un microservicio desarrollado en Spring Boot 3.5.0 y Java 21, diseñado para la administración de solicitudes de préstamos de libros dentro de la biblioteca de la institución.

El servicio gestiona los registros en memoria (a través de colecciones de Java) y calcula campos clave como el RUT del solicitante, el código del libro, las fechas de solicitud/entrega, los días de préstamo y las multas. Es una solución ligera y autocontenida que sirve para validar un ciclo completo de integración continua y despliegue automatizado.

## Tecnologías Utilizadas
* Lenguaje: Java 21 (Eclipse Temurin)
* Framework: Spring Boot 3.5.0
* Gestor de dependencias: Maven
* Contenedores: Docker y Docker Compose
* Integración Continua (CI): GitHub Actions
* Análisis de Cobertura: JaCoCo
* Escaneo de Seguridad: Snyk Security Scan
* Calidad de Código: SonarCloud

## Requisitos Previos
* JDK 21 instalado localmente.
* Apache Maven 3.9+ instalado.
* Docker Desktop activo en tu sistema.

## Instrucciones de Ejecución y Compilación Local

### 1. Ejecución con Maven
Para compilar, validar y levantar la aplicación de manera nativa en tu máquina:

* Ejecutar pruebas unitarias:
  ```bash
  mvn clean test
  ```

* Ejecutar pruebas y generar cobertura (JaCoCo):
  ```bash
  mvn clean verify
  ```
  (El reporte HTML de cobertura quedará disponible localmente en target/site/jacoco/index.html).

* Construir el archivo empaquetado (JAR):
  ```bash
  mvn clean package
  ```
  (Genera el archivo ejecutable en target/bibliotecaduoc-0.0.1-SNAPSHOT.jar).

### 2. Ejecución con Docker (Contenedor Individual)
Para empaquetar y ejecutar el microservicio en un contenedor aislado:

* Construir la imagen de Docker:
  ```bash
  docker build -t bibliotecaduoc:latest .
  ```

* Ejecutar el contenedor expuesto en el puerto 8082:
  ```bash
  docker run -d -p 8082:8082 --name bibliotecaduoc-container bibliotecaduoc:latest
  ```

### 3. Ejecución con Docker Compose (Orquestación)
Para levantar el microservicio de manera reproducible y limpia:

* Levantar el entorno completo:
  ```bash
  docker compose up --build
  ```

* Detener y limpiar los contenedores:
  ```bash
  docker compose down
  ```

## Endpoints Disponibles y Pruebas (Curl)

Una vez que la aplicación esté corriendo (ya sea con Maven o con Docker Compose) en el puerto 8082, puedes utilizar los siguientes comandos curl en tu terminal para probar que responde correctamente:

* Listar todas las solicitudes de préstamo (Endpoint Principal):
  ```bash
  curl http://localhost:8082/api/v1/solicitudes
  ```
  Respuesta esperada: [] (indica que el arreglo en memoria se inició correctamente vacío).

* Listar solicitudes ordenadas por su ID de préstamo:
  ```bash
  curl http://localhost:8082/api/v1/solicitudes/ordenados
  ```

## Explicación del Pipeline CI/CD (GitHub Actions)

El archivo .github/workflows/main.yml contiene la automatización de la integración continua que se gatilla ante cada push o Pull Request en las ramas main, develop y feature/**. El pipeline consta de 4 etapas secuenciales:

Flujo del pipeline:
Snyk Security Scan -> Run Tests with JaCoCo -> SonarCloud Analysis -> Build JAR

Detalle de las Etapas:
1. Snyk Security Scan: Escanea el archivo pom.xml en busca de dependencias vulnerables con severidad alta. Utiliza la bandera continue-on-error: true para registrar el reporte de seguridad sin bloquear las compilaciones locales del estudiante.
2. Run Tests with JaCoCo: Ejecuta mvn clean verify en el servidor de integración, corriendo las pruebas automáticas y subiendo el reporte de cobertura (jacoco-report) como un artefacto descargable.
3. SonarCloud Analysis: Analiza el código fuente y las métricas de cobertura, enviando los resultados al dashboard del proyecto en SonarCloud para evaluar duplicidad, mantenibilidad y bugs.
4. Build JAR: Compila el empaquetado final (mvn clean package), valida la construcción de la imagen local con docker build y verifica la estructura de orquestación local con docker compose config.

## Estrategia de Ramas en Git
Utilizamos una estrategia simple para mantener el orden y asegurar el flujo de la entrega:
* main: Contiene el código completamente estable de la entrega final.
* develop: Rama de integración donde se consolidaron los avances.
* feature/*: Ramas de desarrollo temporal donde trabajamos las tareas técnicas por separado (feature/docker-compose, feature/github-actions, feature/seguridad-cobertura).

## Declaración de Uso de Inteligencia Artificial

Durante la preparación de esta entrega, se utilizaron herramientas de Inteligencia Artificial (ChatGPT, Antigravity y Gemini) como soporte para sugerir la estructura de la documentación, la orientación conceptual de comandos Docker/Maven y la corrección de la sintaxis del archivo YAML del pipeline.

Toda configuración y código sugerido fue minuciosamente revisado, corregido y validado por los integrantes del equipo. Las reflexiones y aportes de la entrega fueron desarrollados de manera manual y 100% humana por cada integrante, sin uso de texto sintético.

## Instrucción de Entrega
Para realizar la entrega formal de esta evaluación, asegúrate de realizar el merge final de tus cambios a la rama main, verificar que el pipeline de GitHub Actions haya pasado exitosamente en verde, y subir el enlace del repositorio de GitHub en la plataforma AVA de DUOC UC.
