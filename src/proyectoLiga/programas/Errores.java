package proyectoLiga.programas;

import java.util.Scanner;

public class Errores {

    Scanner sc = new Scanner(System.in);

    public void numeroEntero(){

        while (!sc.hasNextInt()) {
            System.out.println("Error: introduce un número entero.");
            sc.next();
        }

    }

}
