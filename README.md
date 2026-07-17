# App para Simulación de Aeropuertos mediante Hilos en Java

## Autores
*David Romero Oñoro y Guillermo González Martínez*

## Descripción del Proyecto
Este repositorio contiene el código fuente de la Práctica de Laboratorio (PECL) de la asignatura Programación Avanzada. La aplicación es una simulación del funcionamiento y la interacción entre los aeropuertos de Madrid y Barcelona. 

El proyecto desarrolla en Java un entorno complejo haciendo uso exhaustivo de técnicas de **programación concurrente** y **programación distribuida**.

## Características Principales
* **Simulación Concurrente:** Ciclo de vida de los aviones y autobuses, implementados como hilos de ejecución `Threads` independientes.
* **Control de Infraestructura:** Gestión en tiempo real de aerovías, hangares, talleres, plataformas, puertas de embarque, pistas y zonas de rodaje.
* **Interfaz Gráfica Integrada:** Desarrollada con `Swing`, permite la monitorización visual del estado de todos los elementos, así como pausar y reanudar el sistema.
* **Sistema Distribuido de Estadísticas:** Panel cliente independiente conectado a la simulación para consultar datos en tiempo real y ejecutar acciones de control.
* **Registro Log:** Registro de eventos en un fichero de texto de forma sincronizada y segura entre todos los hilos .

## Tecnologías y Técnicas Utilizadas

### Programación Concurrente
Para la gestión de recursos compartidos (aforo, puertas de embarque, pistas, mecánicos del taller, etc.) se han empleado diversas herramientas :
* **Lock y Condition (`ReentrantLock`):** Para proteger la escritura concurrente en el fichero de log y gestionar el botón de pausa general de la simulación .
* **Clases Atómicas (`AtomicInteger`, `AtomicBoolean`):** Para llevar la cuenta del aforo total de los aeropuertos y el estado de disponibilidad de las pistas y embarques libres de condiciones de carrera .
* **Sincronización (`Synchronized`):** Para garantizar el acceso exclusivo a zonas críticas de la interfaz, el acceso a listas y la puerta del taller .
* **Semáforos (`Semaphore`):** Uso de semáforos justos para limitar y ordenar la entrada de un único avión a la vez a través de la puerta del taller .

### Programación Distribuida
* **Arquitectura Cliente-Servidor:** Implementada mediante paso de mensajes usando **Sockets Stream (TCP)** .
* **Manejo concurrente de peticiones:** El `ServidorSocketTCP` delega las peticiones entrantes a un pool de hilos de tamaño fijo gestionado por `ExecutorService` .
* **Envío de comandos:** El cliente (interfaz de estadísticas) permite tanto consultar datos remotos como enviar acciones al servidor (control de apertura y cierre de pistas de aterrizaje) .

## Estructura del Proyecto
El código está organizado en los siguientes paquetes principales :
* **parte1**: Contiene toda la lógica concurrente, incluyendo las clases base (`Aeropuerto`, `Aerovia`, `Avion`, `Bus`, dependencias de las áreas como `Taller` o `Rodaje`), generadores de hilos, listas sincronizadas y las clases de Interfaz principal .
* **parte2.socketsTCP**: Contiene el modelo distribuido, alojando el `ServidorSocketTCP`, las respuestas al servidor, y el `ClienteSocketTCP` (GUI de Estadísticas) .
* **pecl**: Alberga la clase principal que actúa como punto de entrada, encargada de instanciar e inicializar todos los componentes de alto nivel en el orden adecuado .
