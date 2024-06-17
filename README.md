## Automatización de E2E Evaluación
Proyecto de evaluación de automatización de servicios.  

## Requisitos
- Tener instalado **JDK 17**
- Tener instalado **última versión** de **Maven**
- Plugin Cucumber for java
- Plugin Gerking

## Ejecución
Para ejecutar la prueba, abrir la terminal y en el directorio base del proyecto correr el siguiente comando.
``` 
  mvn clean verify -Denvironment=uat "-Dcucumber.filter.tag=@Compra"
``` 

## Ver los reportes
La ejecución de la prueba, producirá un reporte de Serenity Framework en el directorio `target/site/serenity/index.html`.

