package proyectoLiga.programas;

import proyectoLiga.estadios.Estadio;
import proyectoLiga.liga.Equipo;
import proyectoLiga.liga.Jornada;
import proyectoLiga.partidos.Partido;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    List<Estadio> estadios = CreacionObjetos.cargarEstadios();
    List<Equipo> equiposLiga = CreacionObjetos.cargarEquipos(estadios);
    List<Partido> partidosLiga = new ArrayList<>();
    Errores errores = new Errores();
    Jornada jornada = new Jornada();
    Scanner sc = new Scanner(System.in);

    public void Liga(){

        int opciones;
        Equipo equipo = null;
        Equipo equipoSeleccionado = null;

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

                            for (int i = 0; i<38; i++){

                                do {

                                    System.out.println("1. Ver siguiente partido");
                                    System.out.println("2. Simular Partido");
                                    opciones = errores.numeroEntero(sc);

                                    switch (opciones){

                                        case 1:

                                            Partido partidoJornada = Jornada.mostrarJornadaSinRepetir(equiposLiga, equipoSeleccionado,partidosLiga);
                                            partidosLiga.add(partidoJornada);
                                            System.out.println(partidoJornada.getEquipoLocal().getNombre() + " - " + partidoJornada.getEquipoVisitante().getNombre());


                                            break;


                                    }

                            }while(opciones != 2 && opciones!=3);

                            }

                    }while(opciones<1 || opciones>20);
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
