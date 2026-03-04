package proyectoLiga.programas;

import proyectoLiga.estadios.Estadio;
import proyectoLiga.liga.Clasificacion;
import proyectoLiga.liga.Equipo;
import proyectoLiga.liga.Jornada;
import proyectoLiga.liga.Liga;
import proyectoLiga.partidos.Partido;
import proyectoLiga.personas.Jugador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    List<Estadio> estadios = CreacionObjetos.cargarEstadiosEspanola();
    List<Equipo> equiposLiga = CreacionObjetos.cargarEquiposEspanola(estadios);
    List<Partido> partidosLiga = new ArrayList<>();
    List<Jugador> jugadoresLiga = CreacionObjetos.cargarJugadoresEspanola(equiposLiga);

    List<Estadio> estadiosPremier = CreacionObjetos.cargarEstadiosPremier();
    List<Equipo> equiposPremier = CreacionObjetos.cargarEquiposPremier(estadiosPremier);
    List<Partido> partidosPremier = new ArrayList<>();
    List<Jugador> jugadoresPremier = CreacionObjetos.cargarJugadoresPremier(equiposPremier);

    List<Estadio> estadiosSerieA = CreacionObjetos.cargarEstadiosSerieA();
    List<Equipo> equiposSerieA = CreacionObjetos.cargarEquiposSerieA(estadiosSerieA);
    List<Partido> partidosSerieA = new ArrayList<>();
    List<Jugador> jugadoresSerieA = CreacionObjetos.cargarJugadoresSerieA(equiposSerieA);

    List<Estadio> estadiosBundesliga = CreacionObjetos.cargarEstadiosBundesliga();
    List<Equipo> equiposBundesliga = CreacionObjetos.cargarEquiposBundesliga(estadiosBundesliga);
    List<Partido> partidosBundesliga = new ArrayList<>();
    List<Jugador> jugadoresBundesliga = CreacionObjetos.cargarJugadoresBundesliga(equiposBundesliga);

    List<Estadio> estadiosLigue1 = CreacionObjetos.cargarEstadiosLigue1();
    List<Equipo> equiposLigue1 = CreacionObjetos.cargarEquiposLigue1(estadiosLigue1);
    List<Partido> partidosLigue1 = new ArrayList<>();
    List<Jugador> jugadoresLigue1 = CreacionObjetos.cargarJugadoresLigue1(equiposLigue1);

    Liga ligaEspanola = new Liga("España", equiposLiga, jugadoresLiga, partidosLiga);

    Liga premier = new Liga("Inglaterra", equiposPremier, jugadoresPremier, partidosPremier);

    Liga serieA = new Liga("Italia", equiposSerieA, jugadoresSerieA, partidosSerieA);

    Liga bundesliga = new Liga("Alemania", equiposBundesliga, jugadoresBundesliga, partidosBundesliga);

    Liga ligue1 = new Liga("Francia", equiposLigue1, jugadoresLigue1, partidosLigue1);

    Errores errores = new Errores();
    Scanner sc = new Scanner(System.in);

    public void Liga(){

        int opciones;

        do {

            System.out.println("\n\n\n¿Qué competición quieres jugar?");
            System.out.println("1. Liga Española");
            System.out.println("2. Premier League");
            System.out.println("3. Serie A");
            System.out.println("4. Bundesliga");
            System.out.println("5. Ligue 1");
            System.out.println("6. Salir");
            opciones = errores.numeroEntero(sc);

            switch(opciones) {
                case 1:

                    Liga.jugarLiga(ligaEspanola);
                    break;

                case 2:

                    Liga.jugarLiga(premier);
                    break;

                case 3:

                    Liga.jugarLiga(serieA);
                    break;

                case 4:

                    Liga.jugarLiga(bundesliga);
                    break;

                case 5:

                    Liga.jugarLiga(ligue1);
                    break;

                case 6:

                    break;

                default:

                    System.out.println("¿Por que no te atreves a jugar una liga?");

            }

        }while (opciones != 6);

    }


    public static Equipo elegirEquipo(int a, List<Equipo> equipos, Equipo equipoSeleccionado){


        for (int i=0;i<equipos.size();i++){

            if (i==a){

                equipoSeleccionado=equipos.get(i);

                return equipoSeleccionado;}

        }

        return null;}

}
