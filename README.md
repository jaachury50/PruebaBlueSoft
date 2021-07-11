# PruebaBlueSoft
Prueba Jorge Achury

A) INSTRUCCIONES PARA EJECUTAR LA APLICACIÓN:

1)El archivo comprimo se puede abrir desde cualquier ide de android studio y desde el mismo correr la app.

2)Se construyó un APK para poder correr la app de manera rápido, la cual se ejecuta de la siguiente forma:

Dentro de la carpeta Blue Bank, abrir la carpeta app luego la carpeta release en donde se encontrará la app para ser instalada en un movil.

B)SUPUESTOS DE NEGOCIO Y TECNOLOGIA QUE REALIZÓ PARA SOLUCIONAR EL PROBLEMA:

Se realizo un aplicativo con el nombre Blue Bank, esto con el fin de facilitar a sus empleados la creación y gestión de las cuentas de ahorro, en donde se podrán realizar diferentes tareas como lo son: 
Crear cuentas nuevas, realizar consignaciones, realizar retiros y consultar los saldos de las cuentas disponibles en las bases de datos. 
Manteniendo una rápida respuesta dentro de los servidores utilizados y optimizando al máximo el código e interfaces implementadas en esta, ayudando con una rápida respuesta.

C)EXPLICACIÓN DE LA ARQUITECTURA EMPLEADA:

Se utilizo el tipo de arquitectura Modelo Vista Presentador (MVP)
Modelo: Esta capa gestiona los datos.
Vista:  Se encarga de mostrar los datos. Aquí se encuentran los Fragmentos y Vistas.
Presentador: Se sitúa entre el modelo y la vista, permitiendo conectar la interfaz gráfica con los datos.

Esta arquitectura es muy utilizado en el desarrollo de aplicaciones nativas de Android, se empleo este tipo de arquitectura para permitir un mantenimiento y escalamiento mucho más facil en el aplicativo.

D)EXPLICACIÓN DE TECNOLOGIAS EMPLEADAS PARA LA SOLUCIÓN:

Se utilizo el software de Android Studio el cual es el entorno de desarrollo integrado oficial para la plataforma Android empleando la libreria de 
Volley para realizar la conexión, a las bases de datos, a su vez para el almacenamiento de datos se utilizó un servidor gratuito esto por cuestiones de pruebas, el servidor 
gratuito proporciona un hosting el cual almacena una base de datos SQL y se realiza la conexión a esta mediante PHP.

E)QUÉ HARIA MEJOR O COMO PODRIA ATACAR MEJOR EL PROBLEMA SI TUVIERA MAS TIEMPO

Implementaria mejores interfaces las cuales generen un mejor ambiente al aplicativo, tambien se implementaria una interface de login para los trabajadores del banco esto con el
fin de mejorar la seguridad de la aplicación y ser mucho más ordenado en su ejecución, por ultimo implementaria más seguridad en el ambiente de retiro y consignación de dinero
generando codigos por SMS para confirmar que la persona esta de acuerdo con la acción y a su vez informarle que se estan realizando movimientos en su cuenta.

3)VIDEO DEMOSTRACIÓN APLICATIVO:

El video se puede encontrar en el siguiente link: https://youtu.be/Cflb8boG150
