## Automatización de E2E Evaluación
Proyecto de evaluación de automatización de servicios.  

## Requisitos
- Tener instalado **JDK 17**
- Tener instalado **última versión** de **Maven**
- Plugin Cucumber for java
- Plugin Gerking

## Ejecución
Para ejecutar la prueba, descargue el proyecto, abrir la terminal y en el directorio base del proyecto correr el siguiente comando.
``` 
  mvn clean verify -Denvironment=uat "-Dcucumber.filter.tag=@Compra"
``` 

## Ver los reportes
Una vez que el comando se ejecuta al finalizar se creará un reporte de Serenity Framework en el directorio `target/site/serenity/index.html`.

Puede revisar un reporte de de Serenity ya ejecutado dentro del archivo `target .zip` descomprimalo
y abra el archivo `target/site/serenity/index.html`.

