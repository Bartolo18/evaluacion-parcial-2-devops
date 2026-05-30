Conclusión Marco Suarez:

En este proyecto implementamos una arquitectura de microservicios con Spring Boot para gestionar préstamos de libros en una biblioteca, no fue solo hacer código y subirlo. Levantamos el microservicio, lo probamos, levantamos los contenedores Docker y luego conectamos a GitHub Actions.
Una de las cosas que más nos quitó tiempo fue reparar errores pequeños que nos consumían mucho tiempo. Por ejemplo, el Dockerfile al comienzo no encontraba Maven y la configuración de workflows con Snyk, JaCoCo y SonarCloud, este último dando muchos problemas por temas de organización y secretos. Es ahí cuando me di cuenta de que DevOps no es solamente saber usar herramientas, sino también entender los mensajes de error y no empezar a cambiar cosas al lote.
Fue un buen repaso por Git, usamos ramas separadas por trabajo técnico, como Docker, Actions y Seguridad. Eso ayudó a ordenar el avance.
Creo que si tuviera que hacerlo otra vez comenzaría ordenando los repositorios, ramas y los secretos de una vez, porque eso nos quitó mucho tiempo, no obstante el resultado nos deja contentos y conformes, el proyecto terminó corriendo con Docker Compose y el pipeline quedó pasando con pruebas.

---------------------------------------------------------------------------------------

Conclusión Barbara Tolorza:

En esta evaluación pude ver que en DevOps no todo es programar, también es importante dejar el proyecto ordenado y bien explicado. Aunque la parte técnica fue lo más complejo, la documentación igual es necesaria, porque si el README no está claro, cuesta entender cómo correr el proyecto o qué cosas se hicieron.

Mi aporte fue más por el lado de la documentación, revisar la información del proyecto, ordenar los comandos, las responsabilidades y apoyar en el cierre del repositorio. También pude entender mejor para qué sirven herramientas como GitHub Actions, Docker, JaCoCo, Snyk y SonarCloud, ya que cada una ayuda en una parte distinta del proceso.

Algo que me quedó claro es que el pipeline permite revisar varias cosas automáticamente, como las pruebas, la cobertura, la seguridad y el build. Eso hace que el proyecto no dependa solo de que alguien lo pruebe manualmente, sino que queda una forma más ordenada de validar los cambios.

Para una próxima entrega creo que sería mejor definir desde el comienzo qué hará cada integrante y qué archivos se van a entregar, porque al final siempre se junta todo y puede ser confuso. Aun así, creo que el trabajo quedó bien encaminado, con el código funcionando y la documentación necesaria para que el profesor pueda revisar el repositorio.