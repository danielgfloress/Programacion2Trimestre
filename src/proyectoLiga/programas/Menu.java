package proyectoLiga.programas;

import proyectoLiga.estadios.Estadio;
import proyectoLiga.liga.Equipo;

import java.util.List;
import java.util.Scanner;

public class Menu {

    List<Estadio> estadios = CreacionObjetos.cargarEstadios();
    List<Equipo> equipos = CreacionObjetos.cargarEquipos(estadios);
    Scanner sc = new Scanner(System.in);

    public void Liga(){

        int opciones;
        Equipo equipo = null;
        Equipo equipoSeleccionado;

        do {

            System.out.println("Elige un equipo: ");
            for (int i = 0; i < equipos.size(); i++) {


                System.out.println((i + 1) + ". " + equipos.get(i).getNombre());

            }

            opciones = sc.nextInt();


            equipoSeleccionado = elegirEquipo(opciones - 1, equipos, equipo);

            System.out.println("Has elegido a " + equipoSeleccionado.getNombre());
        }while(opciones<1 || opciones>20);


    }


    public Equipo elegirEquipo(int a, List<Equipo> equipos, Equipo equipoSeleccionado){


        for (int i=0;i<equipos.size();i++){

            if (i==a){

                equipoSeleccionado=equipos.get(i);

                return equipoSeleccionado;}

        }

        return null;}

}
