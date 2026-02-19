package proyectoLiga.partidos;

import proyectoLiga.liga.Equipo;
import proyectoLiga.personas.Jugador;

import java.util.Objects;

public class Gol {

    private Jugador autor;
    private int minuto;
    private Equipo equipo;

    public Gol(Jugador autor, int minuto, Equipo equipo) {
        this.autor = autor;
        this.minuto = minuto;
        this.equipo = equipo;
    }

    public Jugador getAutor() {
        return autor;
    }

    public void setAutor(Jugador autor) {
        this.autor = autor;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "autor=" + autor +
                ", minuto=" + minuto +
                ", equipo=" + equipo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Gol gol = (Gol) o;
        return minuto == gol.minuto && Objects.equals(autor, gol.autor) && Objects.equals(equipo, gol.equipo);
    }

}
