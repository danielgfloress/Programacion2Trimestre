package proyectoLiga.personas;

import proyectoLiga.liga.Equipo;

import java.util.Date;
import java.util.Objects;

public abstract class AbstractPersona {

    protected String nombre;
    protected String apellido;
    protected Equipo equipo;
    protected String nacionalidad;
    protected java.util.Date fechaNacimiento;

    protected AbstractPersona(String nombre, String apellido, Equipo equipo, String nacionalidad, Date fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.equipo = equipo;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", equipo=" + equipo +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", fechaNacimiento=" + fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPersona that = (AbstractPersona) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(fechaNacimiento, that.fechaNacimiento);
    }

}
