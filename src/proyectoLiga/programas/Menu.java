package proyectoLiga.programas;

import proyectoLiga.estadios.Estadio;
import proyectoLiga.liga.Equipo;
import proyectoLiga.liga.Jornada;
import proyectoLiga.partidos.Partido;
import proyectoLiga.personas.Jugador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    List<Estadio> estadios = CreacionObjetos.cargarEstadios();
    List<Equipo> equiposLiga = CreacionObjetos.cargarEquipos(estadios);
    List<Partido> partidosLiga = new ArrayList<>();
    List<Jugador> jugadoresLiga = CreacionObjetos.cargarJugadores(equiposLiga);
    Errores errores = new Errores();
    Jornada jornada = new Jornada();
    Partido partido =  new Partido();
    Scanner sc = new Scanner(System.in);
    int contadorJornadas = 0;


    public void Liga(){

        int opciones;
        Equipo equipo = null;
        Equipo equipoSeleccionado = null;
        if (jugadoresLiga == null || jugadoresLiga.isEmpty()) {
            throw new IllegalStateException("ERROR: jugadoresLiga está vacía. Revisa CreacionObjetos.cargarJugadores()");
        }


        do {

            System.out.println("¿Qué competición quieres jugar?");
            System.out.println("1. Liga");
            System.out.println("2. Champions");
            System.out.println("3. Copa del Rey");
            System.out.println("4. Mundial");
            System.out.println("5. Salir");
            opciones = errores.numeroEntero(sc);

            switch (opciones) {
                case 1:
                    do {

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

                        int puntosSeleccionado = 0;


                            for (int i = 0; i<38; i++){

                                Partido partidoJornada = Jornada.mostrarJornadaSinRepetir(equiposLiga, equipoSeleccionado,partidosLiga);
                                    partidosLiga.add(partidoJornada);
                                puntosSeleccionado += partido.puntosSeleccionado(partidoJornada,equipoSeleccionado,puntosSeleccionado);

                                do {

                                    System.out.println("\n\n1. Ver Siguiente Partido");
                                    System.out.println("2. Simular Partido");
                                    System.out.println("3. Simular Partido Rápido");
                                    System.out.println("4. Ver Clasificación");
                                    opciones = errores.numeroEntero(sc);

                                    switch (opciones){

                                        case 1:

                                            System.out.println("\n\n" + partidoJornada.getEquipoLocal().getNombre() + " - " + partidoJornada.getEquipoVisitante().getNombre());


                                            break;

                                        case 2:

                                            Partido.simularPartido(partidoJornada,jugadoresLiga,equipoSeleccionado, puntosSeleccionado);


                                            break;

                                        case 3:

                                            partido.partidoRapido(partidoJornada, equipoSeleccionado);
                                            puntosSeleccionado += partido.puntosSeleccionado(partidoJornada,equipoSeleccionado,puntosSeleccionado);
                                            System.out.println("Llevas "+ puntosSeleccionado + " puntos");

                                            break;

                                        case 4:



                                            break;

                                        default:
                                            System.out.println("Juega un partido para pasar de Jornada");



                                    }

                            }while(opciones != 2 && opciones != 3);

                            }

                            contadorJornadas++;
                    }while(contadorJornadas != 38);
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:
                    System.out.println("¿PORQUÉ NO TE ATREVES A JUGAR NINGÚN MODO?");
                    break;

                default:
                    System.out.println("VENGA ANDA ELIGE UN MODO DE JUEGO");
                    break;
            }


        }while (opciones<5 || opciones > 0);

    }


    public static Equipo elegirEquipo(int a, List<Equipo> equipos, Equipo equipoSeleccionado){


        for (int i=0;i<equipos.size();i++){

            if (i==a){

                equipoSeleccionado=equipos.get(i);

                return equipoSeleccionado;}

        }

        return null;}

}
