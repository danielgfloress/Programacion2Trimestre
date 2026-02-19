package proyectoLiga.liga;

import proyectoLiga.partidos.Partido;

import java.util.List;
import java.util.Objects;

public class Jornada {

    private int numero;
    private List<Partido> partidos;
    private boolean jugada;

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
