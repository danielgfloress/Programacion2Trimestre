package proyectoLiga.liga;

import java.util.List;
import java.util.Objects;

public class Clasificacion {

    private List<Equipo> equiposOrdenados;
    private String jornadaActual;

    public Clasificacion(List<Equipo> equiposOrdenados, String jornadaActual) {
        this.equiposOrdenados = equiposOrdenados;
        this.jornadaActual = jornadaActual;
    }

    public List<Equipo> getEquiposOrdenados() {
        return equiposOrdenados;
    }

    public void setEquiposOrdenados(List<Equipo> equiposOrdenados) {
        this.equiposOrdenados = equiposOrdenados;
    }

    public String getJornadaActual() {
        return jornadaActual;
    }

    public void setJornadaActual(String jornadaActual) {
        this.jornadaActual = jornadaActual;
    }

    @Override
    public String toString() {
        return "equiposOrdenados=" + equiposOrdenados +
                ", jornadaActual='" + jornadaActual;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Clasificacion that = (Clasificacion) o;
        return Objects.equals(jornadaActual, that.jornadaActual);
    }

}
