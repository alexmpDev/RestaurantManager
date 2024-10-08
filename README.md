# RestaurantManager

>[!WARNING]
> 
>*Tenga en cuenta que el proyecto aún no está en su fase final, por lo que algunas de las funcionalidades mencionadas aún no están operativas."*
>

## Descripción del Proyecto

**RestaurantManager** es una iniciativa personal diseñada para demostrar mis habilidades en Java. Este proyecto permite a los restaurantes crear y gestionar su carta o menú, los cuales pueden ser visualizados por los clientes a través de un código QR.

## Tecnologías Utilizadas

El proyecto se ha desarrollado utilizando las siguientes tecnologías:

- **Java**
- **SpringBoot Framework**
- **Docker**
- **Postgres**
- **Swagger**
- **Hibernate**

## Buenas Prácticas y Principios

En el desarrollo de **RestaurantManager** se han aplicado las buenas prácticas de programación y se han seguido los principios SOLID para asegurar un código limpio, mantenible y escalable.

## Características

- **Gestión de Menús**: Los restaurantes pueden crear, actualizar y eliminar elementos del menú.
- **Visualización mediante QR**: Los clientes pueden escanear un código QR para visualizar el menú en sus dispositivos.
- **Interfaz Amigable**: Diseño intuitivo para facilitar la navegación y uso del sistema.

## Instalación y Configuración

1. Clonar el repositorio:
    ```bash
    git clone https://github.com/alexmpDev/RestaurantManager.git
    ```
2. Navegar al directorio del proyecto:
    ```bash
    cd RestaurantManager
    ```
3. Construir el proyecto con Maven:
    ```bash
    mvn clean install
    ```
4. Ejecutar el proyecto con Docker:
    ```bash
    docker-compose up
    ```
   
   docker-compose.yaml
   ```
   version: '2'
   
   services:
     userdb:
       image: postgres:14-alpine
       ports:
         - 5432:5432
       environment:
         - POSTGRES_PASSWORD=root
         - POSTGRES_USER=postgres
         - POSTGRES_DB=UserManager
     restaurantdb:
       image: postgres:14-alpine
       ports:
         - 54321:5432
       environment:
         - POSTGRES_PASSWORD=root
         - POSTGRES_USER=postgres
         - POSTGRES_DB=RestaurantManager
     users:
       build:
         context: ./UserManager
         dockerfile: Dockerfile
       ports:
         - 80:8080
       environment:
         - POSTGRES_URL=userdb
       depends_on:
         - userdb
       restart: always
     restaurants:
       build:
         context: ./RestaurantManager
         dockerfile: Dockerfile
       ports:
         - 81:8080
       environment:
         - POSTGRES_URL=restaurantdb:5432
       depends_on:
         - restaurantdb
       restart: always
   ```

## Uso

Una vez que el proyecto esté en funcionamiento, los restaurantes pueden acceder al panel de administración para gestionar su menú y generar los códigos QR correspondientes.

## Documentación

La documentación de la API se puede consultar a través de Swagger en la siguiente URL:
http://localhost:8080/swagger-ui.html

