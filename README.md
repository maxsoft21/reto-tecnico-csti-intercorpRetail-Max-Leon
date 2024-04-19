# reto-tecnico-max-leon
# Descripción

Este proyecto es una aplicación Java basada en la arquitectura hexagonal, code first, programación funcional, desarrollada en Java 17 y utiliza diversas tecnologías para crear una solución robusta y eficiente. A continuación, se describen los aspectos clave del proyecto.

## Requisitos

Asegúrate de tener instalados los siguientes componentes antes de ejecutar el proyecto:

- Java 17
- Lombok
- Apache Maven 3.8.7
- kafka
- Docker (opcional para ejecutar en contenedor)

## Detalles del Proyecto

- **Arquitectura Hexagonal**

- **Mensajeria apache Kafka**

- **Programación Funcional**

- **MicroMeter**

- **Lombok para Mayor Claridad del Código**

- **Base de Datos posgresql**

- **Docker para la Portabilidad**: El proyecto incluye un archivo Docker para ejecutar la aplicación en un contenedor Docker. Los comandos para construir y ejecutar la imagen del contenedor son los siguientes:

Nota: para el correcto funcionamiento se debe copiar el porperties en la ruta: 
/data/mcs/reto-tecnico-max-leon-msc1/application-dev.yml
/data/mcs/reto-tecnico-max-leon-msc2/application-dev.yml
/data/mcs/reto-tecnico-max-leon-msc3/application-dev.yml

    ```bash
	docker build -t microservice1:latest .
	docker run -d -p 9090:9090 microservice1:latest
	
	docker build -t microservice2:latest .
	docker run -d -p 9091:9091 microservice2:latest
	
	docker build -t microservice3:latest .
	docker run -d -p 9092:9092 microservice3:latest
    ```
	
	Tambien se incluye un archivo docker-compose.yml recomendable ejecutar este ya que contiene todos los componentes dockerizados:
	 ```bash
    docker-compose up -d --build
    ```

## Instalación

Sigue estos pasos para ejecutar la aplicación en tu entorno local:
1. tener instalado lombok
2. tener instalado posgresql
3. importar el proyecto springboot maven en un ide (intelliJ fue el que se utilizó para su desarrollo)
4. ejecutar los servicios

Diagrama solución:


![Image text](Diagrama%20solucion.jpg)