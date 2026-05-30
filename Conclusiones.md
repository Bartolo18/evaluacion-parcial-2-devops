Conclusión Marco Suarez:

En este proyecto implementamos una arquitectura de microservicios con Spring Boot para gestionar préstamos de libros en una biblioteca, no fue solo hacer código y subirlo. Levantamos el microservicio, lo probamos, levantamos los contenedores Docker y luego conectamos a GitHub Actions.
Una de las cosas que más nos quitó tiempo fue reparar errores pequeños que nos consumían mucho tiempo. Por ejemplo, el Dockerfile al comienzo no encontraba Maven y la configuración de workflows con Snyk, JaCoCo y SonarCloud, este último dando muchos problemas por temas de organización y secretos. Es ahí cuando me di cuenta de que DevOps no es solamente saber usar herramientas, sino también entender los mensajes de error y no empezar a cambiar cosas al lote.
Fue un buen repaso por Git, usamos ramas separadas por trabajo técnico, como Docker, Actions y Seguridad. Eso ayudó a ordenar el avance.
Creo que si tuviera que hacerlo otra vez comenzaría ordenando los repositorios, ramas y los secretos de una vez, porque eso nos quitó mucho tiempo, no obstante el resultado nos deja contentos y conformes, el proyecto terminó corriendo con Docker Compose y el pipeline quedó pasando con pruebas.

---------------------------------------------------------------------------------------

Conclusión Barbara Tolorza:

