# MyHotel Test
Test de código para MyHotel.

El proyecto está dockerizado, solamente hay que ejecutar el `docker-compose` y este ejecutara el servidor MySql, cargará los datos en la BDD y ejecutará el Spring Boot.

El proyecto está organizado en dos "módulos".

En `cl.myhotel.demo.vehicles` esta el modulo de arriendo de vehiculos con el CRUD de vehículos y el sistema de mantenimientos.

En `cl.myhotel.demo.mysql` está el módulo de la empresa en el que se puede obtener la información de los empleados.

## Uso
Se incluye una colección de Postman (`MyHotel Test.postman_collection.json`) para ejecutar los distintos endpoints del proyecto.

Tambien se puede acceder a la coleccion de Postman y el detalle de los endpoints [aqui](https://documenter.getpostman.com/view/4507942/2s93CKPuXj)


## Run
Para correr el proyecto ejecuta:

`docker-compose up --build`

Es posible que al inicio, SpringBoot se reinicie varias veces hasta que se concrete la conexión a la base de datos.
