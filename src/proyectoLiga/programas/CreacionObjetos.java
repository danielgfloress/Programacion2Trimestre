package proyectoLiga.programas;

import proyectoLiga.enumerador.Posicion;
import proyectoLiga.estadios.Estadio;
import proyectoLiga.liga.Equipo;
import proyectoLiga.personas.Entrenador;
import proyectoLiga.personas.Jugador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public final class CreacionObjetos {

    public static List<Estadio> cargarEstadios() {
        List<Estadio> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/proyectoLiga/data/ligaEspanola/ESTADIOS.txt"))) {
            String linea;

            while ((linea = br.readLine()) != null) {

                String[] d = linea.split(";");

                String nombre = d[1];
                String ciudad = d[2];
                int capacidad = Integer.parseInt(d[3]);
                String equipo = d[4];

                lista.add(new Estadio(nombre, ciudad, capacidad, equipo));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static List<Equipo> cargarEquipos(List<Estadio> estadios) {
        List<Equipo> lista = new ArrayList<>();

        Path ruta = Paths.get("src/proyectoLiga/data/ligaEspanola/EQUIPOS.txt");

        try (BufferedReader br = Files.newBufferedReader(ruta)) {
            String linea;

            while ((linea = br.readLine()) != null) {

                if (linea.isBlank()) continue;

                String[] d = linea.split(";");

                String nombre = d[1];
                String nombreEstadio = d[2];

                Estadio estadio = null;
                for (Estadio e : estadios) {
                    if (e.getNombre().equals(nombreEstadio)) {
                        estadio = e;
                        break;
                    }
                }

                Equipo eq = new Equipo(
                        nombre,
                        estadio,
                        new ArrayList<>(), 0, 0, 0, 0, 0, 0, 0
                );

                lista.add(eq);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static List<Entrenador> cargarEntrenadores(List<Equipo> equipos) {
        List<Entrenador> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/proyectoLiga/data/ligaEspanola/ENTRENADORES.txt"))) {
            String linea;

            while ((linea = br.readLine()) != null) {

                String[] d = linea.split(";");

                String nombre = d[1];
                String apellido = d[2];
                String nombreEquipo = d[3];
                String nacionalidad = d[4];
                LocalDate fecha = LocalDate.parse(d[5]);
                int experiencia = Integer.parseInt(d[6]);
                String estilo = d[7];

                Equipo equipo = null;
                for (Equipo e : equipos) {
                    if (e.getNombre().equals(nombreEquipo)) {
                        equipo = e;
                        break;
                    }
                }

                String fechaTxt = d[5];
                LocalDate fechaNacimiento = LocalDate.parse(fechaTxt);

                Entrenador ent = new Entrenador(
                        nombre, apellido, equipo, nacionalidad, fechaNacimiento, experiencia, estilo
                );

                lista.add(ent);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static List<Jugador> cargarJugadores(List<Equipo> equipos) {
        List<Jugador> listaJugadores = new ArrayList<>();

        Path ruta = Paths.get("src/proyectoLiga/data/ligaEspanola/JUGADORES.txt");

        try {
            List<String> lineas = Files.readAllLines(ruta);

            for (String linea : lineas) {
                if (linea.isBlank()) continue;

                String[] d = linea.split(";");

                String nombre = d[1];
                String apellido = d[2];
                String nombreEquipo = d[3];
                String nacionalidad = d[4];
                String fechaTxt = d[5];
                LocalDate fechaNacimiento = LocalDate.parse(fechaTxt);
                Posicion posicion = Posicion.valueOf(d[6]);
                int numero = Integer.parseInt(d[7]);

                int goles = Integer.parseInt(d[8]);
                int asistencias = Integer.parseInt(d[9]);
                int tarjetasAmarillas = Integer.parseInt(d[10]);
                int tarjetasRojas = Integer.parseInt(d[11]);

                Equipo equipo = null;
                for (Equipo e : equipos) {
                    if (e.getNombre().equals(nombreEquipo)) {
                        equipo = e;
                        break;
                    }
                }

                if (equipo == null) {
                    System.out.println("⚠ Equipo no encontrado para jugador: " + nombre + " " + apellido);
                    continue;
                }

                Jugador jugador = new Jugador(
                        nombre, apellido, equipo, nacionalidad,
                        fechaNacimiento, posicion, numero,
                        goles, asistencias, tarjetasAmarillas, tarjetasRojas
                );

                equipo.getPlantilla().add(jugador);

                listaJugadores.add(jugador);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaJugadores;
    }

}
