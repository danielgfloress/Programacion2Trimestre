package proyectoLiga.partidos;

import proyectoLiga.liga.Equipo;
import proyectoLiga.liga.Jornada;

import java.util.List;
import java.util.Objects;

public class Partido {

    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int golesLocal;
    private int golesVisitante;
    private Jornada jornada;
    private List<Gol> goles;
    private List<TarjetaAmarilla> tarjetasAmarillas;
    private List<TarjetaRoja> tarjetasRojas;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante, int golesLocal, int golesVisitante, Jornada jornada, List<Gol> goles, List<TarjetaAmarilla> tarjetasAmarillas, List<TarjetaRoja> tarjetasRojas) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.jornada = jornada;
        this.goles = goles;
        this.tarjetasAmarillas = tarjetasAmarillas;
        this.tarjetasRojas = tarjetasRojas;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public List<Gol> getGoles() {
        return goles;
    }

    public void setGoles(List<Gol> goles) {
        this.goles = goles;
    }

    public List<TarjetaAmarilla> getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public void setTarjetasAmarillas(List<TarjetaAmarilla> tarjetasAmarillas) {
        this.tarjetasAmarillas = tarjetasAmarillas;
    }

    public List<TarjetaRoja> getTarjetasRojas() {
        return tarjetasRojas;
    }

    public void setTarjetasRojas(List<TarjetaRoja> tarjetasRojas) {
        this.tarjetasRojas = tarjetasRojas;
    }

    @Override
    public String toString() {
        return "equipoLocal=" + equipoLocal +
                ", equipoVisitante=" + equipoVisitante +
                ", golesLocal=" + golesLocal +
                ", golesVisitante=" + golesVisitante +
                ", jornada=" + jornada +
                ", goles=" + goles +
                ", tarjetasAmarillas=" + tarjetasAmarillas +
                ", tarjetasRojas=" + tarjetasRojas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Partido that = (Partido) o;
        return Objects.equals(equipoLocal, that.equipoLocal) && Objects.equals(equipoVisitante, that.equipoVisitante);
    }

}