# Concurrencia 
 
este programa es una muestra de los diferentes sockets de java. como ejemplo podra encontrar sokets de tipo
 - HTTPServer


se muestran mediante ejemplos en los cuales puede hacer la solcitud mediante un browser.


## requsites
    -java version 1.7+
    -maven installed

## Installation
 ```sh
$ git clone https://github.com/danielGomez1703/ARSW-Lab4-
$ cd ARSW-Lab4
$ mvn package
```

# MANUAL
  una vez instalado el programa debe ejecutar el programa de acuerdo al servidor que desee probar primero sera el servidor y luego el cliente
 
    servidor web    java -cp target/TallerNet-1.0-SNAPSHOT.jar  co/edu/escuelaing/arsw/tallernet/sockets/HTTPServer
  
  el siguiente paso sera hacer el request en su navegador, puede ser cualquiera y colocar la direccion local.
 
   http://localhost:35000/prueba2.html
 

   para este caso usamos el puerto 35000, esto esta configurado por defecto el codigo
## Modelo
![Modelo](https://github.com/danielGomez1703/ARSW-Lab4-/blob/master/resources/Modelo.PNG)

el modelo es algo simple de primera impresion, depende del servidor y el cliente web, este servidor es un servidor concurrente para atender varios procesos o solicitudes al mismo tiempo
    
    
# Pruebas 
  
Esta evidencia es  la prueba al ejecutar una solicitud, la capacidad de crear 100 mas de acuerdo al pool establecido.

![socket1](https://github.com/danielGomez1703/ARSW-Lab4-/blob/master/resources/evidence1.PNG)

como se puede observar el limite se las solicutudes es correcto ya que su limite es 100 sockets para ese pool.

![socket101](https://github.com/danielGomez1703/ARSW-Lab4-/blob/master/resources/evidence3.PNG)

## Descripion

el objetivo del programa es abrir sockets para la comunicacion, esto se hace mediante un servidor y uno o mas clientes
para el caso del servidor web es el unico caso que alno ser concurrente puede atender mas de un cliente en diferentes momentos.

hay una clase que hace los procesos de envio de imagenes o de archivos html. esto para que se visualicen de forma correcta en el navegador al recibir el GET.

en cuanto a los servidores restantes hacen operaciones matematicas con los valores dados arrancando inicialmente con el coseno, si lo desea cambiar es poner el nombre de a funcion y el compilador lo interpretara como un cambio de funcion.
posteriormente en consola se evidenciara el resultado de las operaciones

En adicion a esto, el servidor web ahora atendera mas de un solo proceso a la vez, esto mediante el uso de hilos (Threads) Los cuales permiten abrir diferentes procesos al mismo tiempo, realizar acciones al mismo tiempo dentro de un solo servidor.
las preubas se haran con llamados desde clientes , mediante una peticion GET.

## DOCUMENTACION

la documentacion se encuentra adjunta en el repositorio 
[aqui encontrara la documentacion](https://github.com/danielGomez1703/ARSW-Lab4-/tree/master/site/apidocs)

## Author
    Daniel Felipe Gomez Suarez - [daniegomez1703](https://github.com/danielGomez1703)
    
## BUILT IN
   Proyecto construido en [Maven](https://maven.apache.org/)
## License
----
para consultar su licencia vaya al link 
[leer aqui](https://github.com/danielGomez1703/ARSW-Primer/blob/master/LICENSE.txt)
