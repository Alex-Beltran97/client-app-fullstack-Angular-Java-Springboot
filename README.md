# NTT Data - Prueba Tecnica
## __Introduccion__
A continaucion dejo para ustedes la entrega de la prueba tecnica, la cual consiste en desarrollar un servicio API Rest, y dentro de la cual podran encontrar los siguientes entregables:
  * El presente archivo README.dm donde se encuentra cada explicacion del funcionamiento del programa
  * Archivo .jar del build de la API elaborada con Java Spring Boot
  * El codigo dividido en las capaz:
    * client (FronEnd)
    * server (BackEnd)
   
## Tecnologias
  ### FronEnd
    * Angular v17
    * Bootstrap v5
    * Alertifyjs

  ### Backend
    * Java v17
    * Springboot v3.2
    * Maven
    * PostgreSQL:Latest
    * Docker y docker-compose
    
## __Indicaciones para ejecutar este proyecto__
  1. clonar este repositorio desde las opciones de __GitHub__
  2. Una vez clonado ejecutaremos en el siguiente orden:
    2.1. Nos ubicamos en la carpeta __"server"__ y desde la terminal ejecutamos el comando...
     ```
     docker-compose up -d
     ```
      Se habilitara el backend, entro del cual podemos ejecutar desde __"Postman"__ las 2 siguientes peticiones HTTP.
       - GET: http://localhost:8090/api/v1/clients (Obtener todos los clientes)
       - GET: http://localhost:8090/api/v1/clients/c/23445322 (Obtener todos los clientes)
    2.2. Nos ubicamos en la carpeta __"server"__ y desde la terminal  ejecutamos el comando...
         ```
          ng serve -o
         ```
 ## __Uso de la vista de la aplicación__

![Alt text](https://res.cloudinary.com/duzyd4ju7/image/upload/v1718975219/Screenshot_2024-06-21_080547_sikhn0.png "Home Page")

![Alt text](https://res.cloudinary.com/duzyd4ju7/image/upload/v1718975219/Screenshot_2024-06-21_080547_sikhn0.png "Client Page")


# Muchas gracias por su atencion prestada




