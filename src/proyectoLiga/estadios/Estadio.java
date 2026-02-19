package proyectoLiga.estadios;

import java.util.Objects;

public class Estadio {

    private String nombre;
    private String lugar;
    private int capacidad;
    private String equipoLocal;

    public Estadio(String nombre, String lugar, int capacidad, String equipoLocal) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.capacidad = capacidad;
        this.equipoLocal = equipoLocal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", lugar='" + lugar + '\'' +
                ", capacidad=" + capacidad +
                ", equipoLocal='" + equipoLocal;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Estadio estadio = (Estadio) o;
        return Objects.equals(nombre, estadio.nombre) && Objects.equals(lugar, estadio.lugar) && Objects.equals(equipoLocal, estadio.equipoLocal);
    }

}
