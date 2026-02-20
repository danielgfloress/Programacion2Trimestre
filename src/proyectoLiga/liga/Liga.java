package proyectoLiga.liga;

import java.util.Objects;

public class Liga {

    private String nombre;
    private String pais;
    private String tipo;

    public Liga(String nombre, String pais, String tipo) {
        this.nombre = nombre;
        this.pais = pais;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "pais='" + pais + '\'' +
                ", tipo='" + tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Liga liga = (Liga) o;
        return Objects.equals(pais, liga.pais) && Objects.equals(tipo, liga.tipo);
    }

}
