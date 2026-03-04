# ⚽ GoalTech BD

## 👥 Integrantes

* **Berta Díaz** - Físico y Base de Datos (MySQL, + DDL y DML)
* **Carlos Munoz** - Entidad-relación
* **Daniel Flores** - Logico y normalización
* **Diego Carnicero** - Logico y README

## 📋 Descripción del proyecto
El proyecto empieza con el modelo Entidad-Relación,
hecho en Draw.io. Las entidades están compuestas por
atributos, todos ellos con un identificador único
que es la Primary Key y otros atributos secundarios.
Las clases se relacionan por cardinalidades 1:1, 
1:N o N:N.

Le sigue el modelo Lógico y la normalización, 
en el modelo Lógico hemos creado tablas que contienen
la información de los atributos de cada clase. 
Y la normalización muestra datos más concretos
de los atributos, reduciendolos para evitar que
se repita información y tenga mayor coherencia.

También tenemos el modelo Físico, el cual 
cuenta la unión entre las clases.

Y por último la implementación en base de datos 
y los errores forzados.
# 📁 Estructura del proyecto

```texto 
Entidad-Relación/                  Logico/                   Normalización/
     ├─Jugadores/                    ├─Jugador/                  ├─Jugadores
     │    ├─nombre_completo          │    ├─DNI                  │   └─Jugador-Numero_teléfono
     │    ├─posición                 │    ├─nombre               │               └─tipo_numero
     │    ├─dorsal                   │    ├─apellido             │
     │    ├─TarjetaAmarilla          │    ├─dorsal               └─Jornada
     │    ├─TarjetaRoja              │    ├─equipo                    └─Jornada-Partido
     │    ├─Goles                    │    ├─posición
     │    ├─Asistencias              │    ├─fecha_nacimiento
     │    ├─FechaNacimiento          │    ├─nacionalidad           Físico/
     │    ├─nacionalidad             │    ├─goles                    ├─partido/
     │    └─equipo                   │    ├─asistencias              │   ├─id_partido
     │                               │    ├─tarjetasAmarillas        │   ├─id_jornada
     ├─Entrenador/                   │    ├─tarjetasRojas            │   ├─id_equipo_local
     │    ├─nombreCompleto           │    ├─numerotelefono           │   ├─id_equipo_visitante
     │    ├─equipo                   │    └─tipo numero              │   ├─gol_local
     │    ├─nacionalidad             │                               │   └─gol_visitante
     │    ├─fecha_nacimiento         ├─Partido/                      │
     │    ├─ExperienciaAnios         │    ├─golesVisitantes          ├─Entrenador/
     │    └─estilo                   │    ├─golesLocales             │   ├─id_entrenador
     │                               │    └─id_partido               │   ├─id_equipo
     ├─Equipo/                       │                               │   ├─nombre
     │    ├─nombre                   ├─Liga/                         │   ├─apellido
     │    ├─puntos                   │    ├─id_liga                  │   │
     │    │                          │    ├─nombre                   │   ├─nacionalidad
     │    ├─partidosjugados          │    ├─país                     │   ├─fecha_nacimiento
     │    ├─victorias                │    └─tipo                     │   ├─anio_experiencia
     │    ├─empates                  │                               │   └─estilo
     │    ├─derrotas                 ├─Entrenador/                   │
     │    ├─golesAFavor              │    ├─DNI                      ├─Jugadores/
     │    └─golesEnContra            │    ├─nombre                   │   ├─id_jugadores
     │                               │    ├─apellido                 │   ├─id_equipo
     ├─Clasificación/                │    ├─equipo                   │   ├─nombre
     │    └─jornadaActual            │    ├─nacionalidad             │   ├─apellido
     │                               │    ├─fechaNacimiento          │   ├─nacionalidad
     ├─liga/                         │    ├─experienciaAnios         │   ├─fecha_nacimiento
     │    ├─id_liga                  │    │                          │   │
     │    ├─nombre                   │    └─estilo                   │   ├─posición
     │    ├─país                     │                               │   ├─dorsal
     │    └─tipo                     ├─Jornada/                      │   ├─gol
     │                               │     ├─Número                  │   ├─tarjetaAmarilla
     ├─Jornada/                      │     ├─Partidos                │   ├─tarjetaRoja
     │    ├─número                   │     └─Jugada                  │   └─asistencias
     │    ├─partidos                 │                               │
     │    └─jugada                   ├─Equipo/                       ├─Clasificación/
     │                               │     ├─Nombre                  │   ├─id_clasificación
     └─Partida/                      │     ├─Puntos                  │   ├─id_liga
          ├─id_partido               │     ├─PartidosJugados         │   ├─id_equipo
          ├─golesVisitantes          │     ├─victorias               │   ├─nombre
          └─golesLocal               │     ├─derrotas                │   └─jornada_clase
                                     │     ├─empates                 │
                                     │     ├─goles_a_favor           ├─Jornadas/
                                     │     └─goles_en_contra         │   ├─id_jornada
                                     │                               │   ├─id_liga
                                     └─Tablas intermedias/           │   ├─partidos
                                           ├─Jugador-Partido         │   ├─número
                                           ├─Partido-Liga            │   └─jugada
                                           └─Jugador-Equipo          │
                                                                     ├─Equipo/
                                                                     │   ├─id_equipo
                                                                     │   ├─id_liga
                                                                     │   ├─nombre
                                                                     │   ├─puntos
                                                                     │   ├─partido_jugado
                                                                     │   ├─victoria
                                                                     │   ├─empate
                                                                     │   ├─derrota
                                                                     │   ├─goles_favor
                                                                     │   └─goles_en_contra
                                                                     │
                                                                     └─Liga/
                                                                         ├─id_liga
                                                                         ├─nombre
                                                                         ├─tipo
                                                                         └─país
