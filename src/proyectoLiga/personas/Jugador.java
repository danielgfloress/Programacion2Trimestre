package proyectoLiga.personas;

import proyectoLiga.liga.Equipo;

import java.util.Date;
import java.util.Objects;

public class Jugador extends AbstractPersona {

    private String posicion;
    private int dorsal;
    private int goles;
    private int asistencias;
    private int tarjetasAmarillas;
    private int tarjetasRojas;

    public Jugador(String nombre, String apellido, Equipo equipo, String nacionalidad, Date fechaNacimiento, String posicion, int dorsal, int goles, int asistencias, int tarjetasAmarillas, int tarjetasRojas) {
        super(nombre, apellido, equipo, nacionalidad, fechaNacimiento);
        this.posicion = posicion;
        this.dorsal = dorsal;
        this.goles = goles;
        this.asistencias = asistencias;
        this.tarjetasAmarillas = tarjetasAmarillas;
        this.tarjetasRojas = tarjetasRojas;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public void setTarjetasAmarillas(int tarjetasAmarillas) {
        this.tarjetasAmarillas = tarjetasAmarillas;
    }

    public int getTarjetasRojas() {
        return tarjetasRojas;
    }

    public void setTarjetasRojas(int tarjetasRojas) {
        this.tarjetasRojas = tarjetasRojas;
    }

    @Override
    public String toString() {
        return "posicion='" + posicion + '\'' +
                ", dorsal=" + dorsal +
                ", goles=" + goles +
                ", asistencias=" + asistencias +
                ", tarjetasAmarillas=" + tarjetasAmarillas +
                ", tarjetasRojas=" + tarjetasRojas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Jugador jugador = (Jugador) o;
        return dorsal == jugador.dorsal && Objects.equals(posicion, jugador.posicion);
    }

}
