package proyectoLiga.programas;

import proyectoLiga.estadios.Estadio;
import proyectoLiga.liga.Equipo;
import proyectoLiga.personas.Entrenador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Menu {

    private List<Estadio> estadios = new ArrayList<>(List.of(
            new Estadio("Santiago Bernabéu", "Madrid", 85000, "Real Madrid"),
            new Estadio("Spotify Camp Nou", "Barcelona", 99000, "FC Barcelona"),
            new Estadio("Metropolitano", "Madrid", 68000, "Atlético de Madrid"),
            new Estadio("Reale Arena", "San Sebastián", 40000, "Real Sociedad"),
            new Estadio("San Mamés", "Bilbao", 53000, "Athletic Club"),
            new Estadio("Benito Villamarín", "Sevilla", 60000, "Real Betis"),
            new Estadio("Ramón Sánchez-Pizjuán", "Sevilla", 43000, "Sevilla FC"),
            new Estadio("Mestalla", "Valencia", 49000, "Valencia CF"),
            new Estadio("La Cerámica", "Villarreal", 23500, "Villarreal CF"),
            new Estadio("Cívitas Nuevo Mirandilla", "Cádiz", 20000, "Cádiz CF"),
            new Estadio("Coliseum Alfonso Pérez", "Getafe", 17000, "Getafe CF"),
            new Estadio("Montilivi", "Girona", 14500, "Girona FC"),
            new Estadio("Abanca Balaídos", "Vigo", 29000, "Celta de Vigo"),
            new Estadio("Los Cármenes", "Granada", 19500, "Granada CF"),
            new Estadio("El Sadar", "Pamplona", 23500, "CA Osasuna"),
            new Estadio("Mendizorroza", "Vitoria", 19840, "Deportivo Alavés"),
            new Estadio("Vallecas", "Madrid", 14700, "Rayo Vallecano"),
            new Estadio("Ipurua", "Eibar", 8100, "SD Eibar"),
            new Estadio("José Zorrilla", "Valladolid", 26500, "Real Valladolid"),
            new Estadio("Gran Canaria", "Las Palmas", 32500, "UD Las Palmas")
    ));

    private List<Equipo> equipos = new ArrayList<>(List.of(
            new Equipo("Real Madrid", estadios.get(0), new ArrayList<>(), 0,0,0,0,0,0,0),
            new Equipo("FC Barcelona", estadios.get(1), new ArrayList<>(), 0,0,0,0,0,0,0),
            new Equipo("Atlético de Madrid", estadios.get(2), new ArrayList<>(), 0,0,0,0,0,0,0),
            new Equipo("Real Sociedad", estadios.get(3), new ArrayList<>(), 0,0,0,0,0,0,0),
            new Equipo("Athletic Club", estadios.get(4), new ArrayList<>(), 0,0,0,0,0,0,0),
            new Equipo("Real Betis", estadios.get(5), new ArrayList<>(), 0,0,0,0,0,0,0),
            new Equipo("Sevilla FC", estadios.get(6), new ArrayList<>(), 0,0,0,0,0,0,0),
            new Equipo("Valencia CF", estadios.get(7), new ArrayList<>(), 0,0,0,0,0,0,0),
            new Equipo("Villarreal CF", estadios.get(8), new ArrayList<>(), 0,0,0,0,0,0,0),
            new Equipo("Cádiz CF", estadios.get(9), new ArrayList<>(), 0,0,0,0,0,0,0),
            new Equipo("Getafe CF", estadios.get(10), new ArrayList<>(), 0,0,0,0,0,0,0),
            new Equipo("Girona FC", estadios.get(11), new ArrayList<>(), 0,0,0,0,0,0,0),
            new Equipo("Celta de Vigo", estadios.get(12), new ArrayList<>(), 0,0,0,0,0,0,0),
            new Equipo("Granada CF", estadios.get(13), new ArrayList<>(), 0,0,0,0,0,0,0),
            new Equipo("CA Osasuna", estadios.get(14), new ArrayList<>(), 0,0,0,0,0,0,0),
            new Equipo("Deportivo Alavés", estadios.get(15), new ArrayList<>(), 0,0,0,0,0,0,0),
            new Equipo("Rayo Vallecano", estadios.get(16), new ArrayList<>(), 0,0,0,0,0,0,0),
            new Equipo("SD Eibar", estadios.get(17), new ArrayList<>(), 0,0,0,0,0,0,0),
            new Equipo("Real Valladolid", estadios.get(18), new ArrayList<>(), 0,0,0,0,0,0,0),
            new Equipo("UD Las Palmas", estadios.get(19), new ArrayList<>(), 0,0,0,0,0,0,0)
    ));

    private List<Entrenador> entrenadores = new ArrayList<>(List.of(
            new Entrenador("Carlo", "Ancelotti", equipos.get(0), "Italia", new Date(1959-1900, 5, 10), 25, "Posesión"),
            new Entrenador("Xavi", "Hernández", equipos.get(1), "España", new Date(1980-1900, 0, 25), 8, "Tiki-Taka"),
            new Entrenador("Diego", "Simeone", equipos.get(2), "Argentina", new Date(1970-1900, 3, 28), 15, "Defensivo"),
            new Entrenador("Imanol", "Alguacil", equipos.get(3), "España", new Date(1971-1900, 6, 4), 10, "Presión alta"),
            new Entrenador("Ernesto", "Valverde", equipos.get(4), "España", new Date(1964-1900, 1, 9), 20, "Equilibrado"),
            new Entrenador("Manuel", "Pellegrini", equipos.get(5), "Chile", new Date(1953-1900, 8, 16), 30, "Ofensivo"),
            new Entrenador("Quique", "Flores", equipos.get(6), "España", new Date(1965-1900, 1, 5), 18, "Defensa ordenada"),
            new Entrenador("Rubén", "Baraja", equipos.get(7), "España", new Date(1975-1900, 6, 11), 6, "Transiciones"),
            new Entrenador("Marcelino", "García", equipos.get(8), "España", new Date(1965-1900, 7, 14), 22, "Vertical"),
            new Entrenador("Sergio", "González", equipos.get(9), "España", new Date(1976-1900, 2, 10), 8, "Defensivo"),
            new Entrenador("José", "Bordalás", equipos.get(10), "España", new Date(1964-1900, 2, 5), 15, "Intensidad"),
            new Entrenador("Míchel", "Sánchez", equipos.get(11), "España", new Date(1975-1900, 1, 30), 7, "Ofensivo"),
            new Entrenador("Rafa", "Benítez", equipos.get(12), "España", new Date(1960-1900, 3, 16), 25, "Orden táctico"),
            new Entrenador("Alexander", "Medina", equipos.get(13), "Uruguay", new Date(1978-1900, 7, 8), 5, "Presión"),
            new Entrenador("Jagoba", "Arrasate", equipos.get(14), "España", new Date(1978-1900, 3, 22), 10, "Equilibrado"),
            new Entrenador("Luis", "García", equipos.get(15), "España", new Date(1972-1900, 5, 1), 12, "Ofensivo"),
            new Entrenador("Francisco", "Rodríguez", equipos.get(16), "España", new Date(1978-1900, 8, 19), 9, "Vertical"),
            new Entrenador("Gaizka", "Garitano", equipos.get(17), "España", new Date(1975-1900, 6, 9), 14, "Defensivo"),
            new Entrenador("Paulo", "Pezzolano", equipos.get(18), "Uruguay", new Date(1983-1900, 3, 25), 6, "Presión alta"),
            new Entrenador("García", "Pimienta", equipos.get(19), "España", new Date(1974-1900, 7, 18), 10, "Posesión")
    ));
}
