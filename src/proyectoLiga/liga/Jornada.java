package proyectoLiga.liga;

import proyectoLiga.partidos.Partido;

import java.util.*;

public class Jornada {

    private int numero;
    private List<Partido> partidos;
    private boolean jugada;
    private static final Random equipoRandom = new Random();

    public Jornada() {

    }

    public Jornada(int numero, List<Partido> partidos, boolean jugada) {
        this.numero = numero;
        this.partidos = partidos;
        this.jugada = jugada;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public boolean isJugada() {
        return jugada;
    }

    public void setJugada(boolean jugada) {
        this.jugada = jugada;
    }

    public static boolean compararPartidos(List<Partido> partidos, Partido partido){

        for (int i= 0; i < partidos.size(); i++){

            Partido partidoVuelta =  partidos.get(i);

            if (partido.getEquipoLocal().equals(partidoVuelta.getEquipoLocal()) && partido.getEquipoVisitante().equals(partidoVuelta.getEquipoVisitante())){

            return false;}

        }


    return true;}


    public static Partido mostrarJornadaSinRepetir(List<Equipo> equipos,Equipo equipoSeleccionado, List<Partido> partidosLiga) {

        Partido partido;

        do {
            Equipo rival;
            do {
                rival = equipos.get(equipoRandom.nextInt(equipos.size()));
            } while (rival.equals(equipoSeleccionado));

            if (equipoRandom.nextInt(2) == 0) {
                partido = new Partido(equipoSeleccionado, rival);
            } else {
                partido = new Partido(rival, equipoSeleccionado);
            }


        } while (!compararPartidos(partidosLiga, partido));

        return partido;
    }


    @Override
    public String toString() {
        return "numero=" + numero +
                ", partidos=" + partidos +
                ", jugada=" + jugada;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Jornada jornada = (Jornada) o;
        return numero == jornada.numero;
    }

}
