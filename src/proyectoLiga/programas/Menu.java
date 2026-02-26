package proyectoLiga.programas;

import proyectoLiga.estadios.Estadio;
import proyectoLiga.liga.Equipo;

import java.util.List;
import java.util.Scanner;

public class Menu {

    List<Estadio> estadios = CreacionObjetos.cargarEstadios();
    List<Equipo> equipos = CreacionObjetos.cargarEquipos(estadios);
    Errores errores = new Errores();
    Scanner sc = new Scanner(System.in);

    public void Liga(){

        int opciones;
        Equipo equipo = null;
        Equipo equipoSeleccionado;

        do {

            System.out.println("¿Qué competición quieres jugar?");
            System.out.println("1. Liga");
            System.out.println("2. Champions");
            System.out.println("3. Copa del Rey");
            System.out.println("4. Mundial");
            opciones = errores.numeroEntero(sc);

            switch (opciones) {
                case 1:
                    do {

                        System.out.println("Elige un equipo: ");
                        for (int i = 0; i < equipos.size(); i++) {


                            System.out.println((i + 1) + ". " + equipos.get(i).getNombre());

                        }

                        opciones = errores.numeroEntero(sc);

                        if (opciones <21 && opciones > 0){
                            equipoSeleccionado = elegirEquipo(opciones - 1, equipos, equipo);
                            System.out.println("Has elegido al " + equipoSeleccionado.getNombre() + " para ser su entrenador esta temporada, prepárate para darlo todo este año.");
                        }else {
                            System.out.println("Elige el número de un equipo válido");
                        }

                    }while(opciones<1 || opciones>20);
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

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
