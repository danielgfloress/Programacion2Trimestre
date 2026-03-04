# ⚽ GoalTech java

## 👥 Integrantes

* **Berta Díaz** - Zamora, equipoGoleador y Campeon
* **Carlos Munoz** - Zarra, trofeosAdicionales, txt, simuladorJornada, serieA, laLiga, equipos y Premier
* **Daniel Flores** - resetear, premier, posiciones, metodoVirtual, menu, liga, crearObjetos y atributos
* **Diego Carnicero** -README, VelocidadDeTexto y Posición (enumeración)

## 📋 Descripción del proyecto

La UEFA ha contratado nuestros servicios para 
desarrollar una aplicación que gestione toda la
liga de fútbol de esta temporada. 

## ⚙️ Estructura básica del proyecto 🧱

El equipo de programadores encargado del desarrollo
del programa ha creado un archivo de datos, donde
recogen la información de jugadores, entrenadores,
equipos y estadios, diferentes según la liga.
Han desarrollado un archivo de enumeración para 
las posiciones de los jugadores (portero, delantero, ...).

Un archivo para los estadios, que recogen los datos
sobre este. Un archivo liga que recoge la información
de la clasificación, equipo y jornada. Otro archivo
vinculado a los equipos y jugadores. Un archivo
personas que recoge la información de la gente 
relacionada con la liga (jugadores, entrenadores, ...).
Un archivo con clases que se conectan a otras clases o
que son donde se muestran el programa.
Y un archivo que controla la velocidad en que se
muestra el programa en la terminal.

## 📁 Estructura del proyecto

```Texto
 Proyecto liga/
 ├─📂 .idea/
 ├─📂 out/
 ├─📂 src/
 │     ├─📂 data/
 │     │    ├─📂 bundesliga/
 │     │    │      ├─ENTRENADORES.TXT
 │     │    │      ├─EQUIPOS.TXT
 │     │    │      ├─ESTADIOS.TXT
 │     │    │      └─JUGADORES.TXT
 │     │    ├─📂 LigaEspañola/
 │     │    │      ├─ENTRENADORES.TXT
 │     │    │      ├─EQUIPOS.TXT
 │     │    │      ├─ESTADIOS.TXT
 │     │    │      └─JUGADORES.TXT
 │     │    ├─📂 Ligue1/
 │     │    │      ├─ENTRENADORES.TXT
 │     │    │      ├─EQUIPOS.TXT
 │     │    │      ├─ESTADIOS.TXT
 │     │    │      └─JUGADORES.TXT 
 │     │    ├─📂 PrimerLeague/
 │     │    │      ├─ENTRENADORES.TXT
 │     │    │      ├─EQUIPOS.TXT
 │     │    │      ├─ESTADIOS.TXT
 │     │    │      └─JUGADORES.TXT
 │     │    └─📂 SerieA/
 │     │           ├─ENTRENADORES.TXT
 │     │           ├─EQUIPOS.TXT
 │     │           ├─ESTADIOS.TXT
 │     │           └─JUGADORES.TXT
 │     │
 │     ├─📂 enumerador/
 │     │     ├─Posición.JAVA
 │     │     └─Resultado.JAVA`
 │     │
 │     ├─📂 estadio/
 │     │     └─Estadio.JAVA
 │     │
 │     ├─📂 liga/
 │     │     ├─Clasificación.JAVA
 │     │     ├─Equipo.JAVA
 │     │     ├─Jornada.JAVA
 │     │     └─Liga.JAVA
 │     │
 │     ├─📂 partidos/
 │     │     ├─Gol.JAVA
 │     │     ├─Partido.JAVA
 │     │     ├─TarjetaAmarilla.JAVA
 │     │     └─TarjetaRoja.JAVA
 │     │
 │     ├─📂 personas/
 │     │     ├─AbstractPersona.JAVA
 │     │     ├─Entrenador.JAVA
 │     │     └─Jugador.JAVA
 │     │
 │     ├─📂 programas/
 │     │     ├─CreaciónObjetos.JAVA
 │     │     ├─Errores.JAVA
 │     │     ├─Main.JAVA
 │     │     └─Menu.JAVA
 │     │
 │     └─📂 velocidadDeTexto/
 │           └─VelocidadDeTexto.JAVA
 ├─.gitignore
 └─Proyecto2Programación.iml
