package proyectoLiga.personas;

import proyectoLiga.liga.Equipo;

import java.util.Date;
import java.util.Objects;

public class AbstractPersona {

    private String nombre;
    private String apellido;
    private Equipo equipo;
    private String nacionalidad;
    private java.util.Date fechaNacimiento;

    public AbstractPersona(String nombre, String apellido, Equipo equipo, String nacionalidad, Date fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.equipo = equipo;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
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
