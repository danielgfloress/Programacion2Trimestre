package proyectoLiga.programas;

import java.util.Scanner;

public class Errores {

    Scanner sc = new Scanner(System.in);

    public int numeroEntero(Scanner sc){

        while (!sc.hasNextInt()) {
            System.out.println("Introduce el número correspondiente");
            sc.next();
        }

    return sc.nextInt();}

}
