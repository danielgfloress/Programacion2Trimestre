package proyectoLiga.personas;

import java.util.Date;
import java.util.Objects;

public class Entrenador extends AbstractPersona {

    private int experienciaAnios;
    private String estilo;

    public Entrenador(String nombre, String apellido, String nacionalidad, Date fechaNacimiento, int experienciaAnios, String estilo) {
        super(nombre, apellido, nacionalidad, fechaNacimiento);
        this.experienciaAnios = experienciaAnios;
        this.estilo = estilo;
    }

    public int getExperienciaAnios() {
        return experienciaAnios;
    }

    public void setExperienciaAnios(int experienciaAnios) {
        this.experienciaAnios = experienciaAnios;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    @Override
    public String toString() {
        return "experienciaAnios=" + experienciaAnios +
                ", estilo='" + estilo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Entrenador that = (Entrenador) o;
        return experienciaAnios == that.experienciaAnios && Objects.equals(estilo, that.estilo);
    }

}
