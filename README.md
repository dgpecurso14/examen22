Para dar de alta un servicio con escalado a 3 se instala rancher


docker run -d --restart=unless-stopped -p 8080:8080 rancher/server

Nos esperamos unos 3 minutos en lo que el servicio de rancher se inicia, posteriormente nos logeamos con la url

http://ip:8080

Para agregar un docker cliente nos vamos a "infraestructure" y elegimos "add host" y le decismo save, despues nos   da el comando
sudo docker run --rm --privileged -v /var/run/docker.sock:/var/run/docker.sock -v /var/lib/rancher:/var/lib/rancher rancher/agent:v1.2.10 http://192.168.1.124:8080/v1/scripts/D50CD0EFAA63ED7B4AA4:1514678400000:Pn9EH46n7axdSNcpHEsPqAixM
con el cual corremos un agente docker que pone a nuestro equipo para poner disponer de sus recursos

Esto provoca que cuando nos vamos de nuevo al menu "Infraestructure" nos aparece el equipo y podemos ver sus caracterìsticas

Aqui nos vamos al menu a la izquierda "Default"

Le indicamos "Define a service" 

Le ponemos el nombre en este caso digitosfactorial, abajo en el "Image name" le indicamos "mmorgado/examen2" que es el docker que esta en dockerhub


abajo en la opciòn de "user" le indicamos "none"
En la secciòn de "Security/host" le decimos que el "logdriver" es json-file en formato JSON y le decimos crear

Pasara un tiempo en lo que lo levanta, cuando ya este activo  en el menu derecho le decimos agregar un balanceo, en este menu
le indicamos el puerto donde va a contestar el balanceador (request host, port) en este caso el 9090, despues seleccionamos el nombre del servicio (que es el que creamos anteriormente) y le indicamos el puerto donde nuestra vertical corre (target port), en este caso el 8080,escogemos el nombre "BALANCEADOR"  y finalmente le indicamos crear.
De nueva cuena el balanceador se tardarà en levantar, cuando este activo vamos vamos a ir al servicio en el signo de informaciòn, nos aparecerà las opciones en la parte de abajo de la pantalla y en la opción escalar le decimos la opción "+" hasta que levante 3

Finalmente nos vamos a la opciòn  "Infraestructure" y aquí seleccionamos la IP del host que tiene el servicio y veremos que tiene el balanceador y los 3 servicios corriendo    

Finalemente ponemos la url del host que tiene el serivicio desplegado con el puerto de balanceo en este caso
http://192.168.1.124:9090/api/factorial?b=2	

y veremos que nos responde

