package proyectoLiga.programas;

import proyectoLiga.estadios.Estadio;
import proyectoLiga.liga.Clasificacion;
import proyectoLiga.liga.Equipo;
import proyectoLiga.liga.Jornada;
import proyectoLiga.partidos.Partido;
import proyectoLiga.personas.Jugador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static proyectoLiga.liga.Clasificacion.mostrarClasificacionSoloPuntos;

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

    Errores errores = new Errores();
    Jornada jornada = new Jornada();
    Partido partido =  new Partido();
    Clasificacion clasificacion = new Clasificacion();
    Scanner sc = new Scanner(System.in);
    int contadorJornadas = 0;


    public void Liga(){

        int opciones;
        Equipo equipo = null;
        Equipo equipoSeleccionado = null;

        do {

            System.out.println("\n\n\n¿Qué competición quieres jugar?");
            System.out.println("1. Liga Española");
            System.out.println("2. Premier League");
            System.out.println("3. Serie A");
            System.out.println("4. Mundial");
            System.out.println("5. Salir");
            opciones = errores.numeroEntero(sc);

            switch (opciones) {
                case 1:

                        System.out.println("Elige un equipo: ");
                        for (int i = 0; i < equiposLiga.size(); i++) {


                            System.out.println((i + 1) + ". " + equiposLiga.get(i).getNombre());

                        }

                        opciones = errores.numeroEntero(sc);

                        if (opciones <21 && opciones > 0){
                            equipoSeleccionado = elegirEquipo(opciones - 1, equiposLiga, equipo);
                            System.out.println("\n\n\nHas elegido al " + equipoSeleccionado.getNombre() + " para ser su entrenador esta temporada, prepárate para darlo todo este año.\n\n");
                        }else {
                            System.out.println("Elige el número de un equipo válido");
                        }

                            for (int i = 0; i<38; i++){

                                Partido partidoJornada = Jornada.mostrarJornadaSinRepetir(equiposLiga, equipoSeleccionado,partidosLiga, (i));
                                if (partidoJornada == null) {

                                    i--;
                                    continue;

                                }

                                partidosLiga.add(partidoJornada);

                                do {

                                    System.out.println("\n\n1. Ver Siguiente Partido");
                                    System.out.println("2. Simular Partido");
                                    System.out.println("3. Simular Partido Rápido");
                                    System.out.println("4. Ver Clasificación");
                                    opciones = errores.numeroEntero(sc);

                                    switch (opciones){

                                        case 1:

                                            System.out.println("\n\nJORNADA " + (i+1));
                                            System.out.println(partidoJornada.getEquipoLocal().getNombre() + " - " + partidoJornada.getEquipoVisitante().getNombre() + "\nEstadio: "+partidoJornada.getEquipoLocal().getEstadio().getNombre());

                                            break;

                                        case 2:

                                            Partido.simularPartido(partidoJornada,jugadoresLiga,equipoSeleccionado);
                                            clasificacion.puntosResto(equiposLiga, partidoJornada);
                                            Partido.puntosPartido(partidoJornada,partidoJornada.getEquipoLocal(),partidoJornada.getEquipoVisitante());
                                            System.out.println("Tus puntos: " + equipoSeleccionado.getPuntos());

                                            break;

                                        case 3:

                                            partido.partidoRapido(partidoJornada, equipoSeleccionado);
                                            clasificacion.puntosResto(equiposLiga, partidoJornada);


                                            break;

                                        case 4:

                                            mostrarClasificacionSoloPuntos(equiposLiga);

                                            break;

                                        default:
                                            System.out.println("Juega un partido para pasar de Jornada");
                                            break;



                                    }

                            }while(opciones != 2 && opciones != 3);

                            }

                    mostrarClasificacionSoloPuntos(equiposLiga);

                    break;

                case 2:

                        contadorJornadas = 1;
                        System.out.println("Elige un equipo: ");
                        for (int i = 0; i < equiposPremier.size(); i++) {

                            System.out.println((i + 1) + ". " + equiposPremier.get(i).getNombre());

                        }

                        opciones = errores.numeroEntero(sc);

                        if (opciones <21 && opciones > 0){
                            equipoSeleccionado = elegirEquipo(opciones - 1, equiposPremier, equipo);
                            System.out.println("\n\n\nHas elegido al " + equipoSeleccionado.getNombre() + " para ser su entrenador esta temporada, prepárate para darlo todo este año.\n\n");
                        }else {
                            System.out.println("Elige el número de un equipo válido");
                        }


                        for (int i = 0; i<38; i++){

                            Partido partidoJornada = Jornada.mostrarJornadaSinRepetir(equiposPremier, equipoSeleccionado,partidosPremier,(i));
                            partidosPremier.add(partidoJornada);

                            do {

                                System.out.println("\n\n1. Ver Siguiente Partido");
                                System.out.println("2. Simular Partido");
                                System.out.println("3. Simular Partido Rápido");
                                System.out.println("4. Ver Clasificación");
                                opciones = errores.numeroEntero(sc);

                                switch (opciones){

                                    case 1:

                                        System.out.println("\n\nJORNADA " + (i+1));
                                        System.out.println(partidoJornada.getEquipoLocal().getNombre() + " - " + partidoJornada.getEquipoVisitante().getNombre() + "\n\nEstadio " + partidoJornada.getEquipoLocal().getEstadio().getNombre());


                                        break;

                                    case 2:

                                        Partido.simularPartido(partidoJornada,jugadoresPremier,equipoSeleccionado);
                                        Partido.puntosPartido(partidoJornada,partidoJornada.getEquipoLocal(),partidoJornada.getEquipoVisitante());
                                        System.out.println("Tus puntos: " + equipoSeleccionado.getPuntos());


                                        break;

                                    case 3:

                                        partido.partidoRapido(partidoJornada, equipoSeleccionado);

                                        break;

                                    case 4:

                                        mostrarClasificacionSoloPuntos(equiposPremier);

                                        break;

                                    default:
                                        System.out.println("Juega un partido para pasar de Jornada");



                                }

                            }while(opciones != 2 && opciones != 3);

                        }

                    mostrarClasificacionSoloPuntos(equiposLiga);

                    break;

                case 3:

                        System.out.println("Elige un equipo: ");
                        for (int i = 0; i < equiposSerieA.size(); i++) {

                            System.out.println((i + 1) + ". " + equiposSerieA.get(i).getNombre());

                        }

                        opciones = errores.numeroEntero(sc);

                        if (opciones <21 && opciones > 0){
                            equipoSeleccionado = elegirEquipo(opciones - 1, equiposSerieA, equipo);
                            System.out.println("\n\n\nHas elegido al " + equipoSeleccionado.getNombre() + " para ser su entrenador esta temporada, prepárate para darlo todo este año.\n\n");
                        }else {
                            System.out.println("Elige el número de un equipo válido");
                        }


                        for (int i = 0; i<38; i++){

                            Partido partidoJornada = Jornada.mostrarJornadaSinRepetir(equiposSerieA, equipoSeleccionado,partidosSerieA,(i));
                            partidosSerieA.add(partidoJornada);

                            do {

                                System.out.println("\n\n1. Ver Siguiente Partido");
                                System.out.println("2. Simular Partido");
                                System.out.println("3. Simular Partido Rápido");
                                System.out.println("4. Ver Clasificación");
                                opciones = errores.numeroEntero(sc);

                                switch (opciones){

                                    case 1:

                                        System.out.println("\n\nJORNADA " + (i+1));
                                        System.out.println(partidoJornada.getEquipoLocal().getNombre() + " - " + partidoJornada.getEquipoVisitante().getNombre() + "\n\nEstadio " + partidoJornada.getEquipoLocal().getEstadio().getNombre());


                                        break;

                                    case 2:

                                        Partido.simularPartido(partidoJornada,jugadoresSerieA,equipoSeleccionado);
                                        Partido.puntosPartido(partidoJornada,partidoJornada.getEquipoLocal(),partidoJornada.getEquipoVisitante());
                                        System.out.println("Tus puntos: " + equipoSeleccionado.getPuntos());


                                        break;

                                    case 3:

                                        partido.partidoRapido(partidoJornada, equipoSeleccionado);

                                        break;

                                    case 4:

                                        mostrarClasificacionSoloPuntos(equiposSerieA);

                                        break;

                                    default:
                                        System.out.println("Juega un partido para pasar de Jornada");



                                }

                            }while(opciones != 2 && opciones != 3);

                        }

                    mostrarClasificacionSoloPuntos(equiposLiga);

                    break;

                case 4:

                    contadorJornadas = 0;

                    break;

                case 5:
                    System.out.println("¿PORQUÉ NO TE ATREVES A JUGAR NINGÚN MODO?");
                    break;

                default:
                    System.out.println("VENGA ANDA ELIGE UN MODO DE JUEGO");
                    break;
            }


        }while (opciones != 5);

    }


    public static Equipo elegirEquipo(int a, List<Equipo> equipos, Equipo equipoSeleccionado){


        for (int i=0;i<equipos.size();i++){

            if (i==a){

                equipoSeleccionado=equipos.get(i);

                return equipoSeleccionado;}

        }

        return null;}

}
