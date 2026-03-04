package proyectoLiga.liga;

import proyectoLiga.estadios.Estadio;
import proyectoLiga.personas.Jugador;

import java.util.Objects;

import java.util.List;

public class Equipo {

    private String nombre;
    private Estadio estadio;
    private int media;
    private List<Jugador> plantilla;
    private int puntos;
    private int partidosJugados;
    private int victorias;
    private int empates;
    private int derrotas;
    private int golesFavor;
    private int golesContra;

    public Equipo() {}
    public Equipo(String nombre, Estadio estadio, int media, List<Jugador> plantilla, int puntos, int partidosJugados, int victorias, int empates, int derrotas, int golesFavor, int golesContra) {
        this.nombre = nombre;
        this.estadio = estadio;
        this.media = media;
        this.plantilla = plantilla;
        this.puntos = puntos;
        this.partidosJugados = partidosJugados;
        this.victorias = victorias;
        this.empates = empates;
        this.derrotas = derrotas;
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public int getMedia() {
        return media;
    }

    public void setMedia(int media) {
        this.media = media;
    }

    public List<Jugador> getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(List<Jugador> plantilla) {
        this.plantilla = plantilla;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    public static void resetearTodo (List<Equipo> equipos) {

        for (Equipo equipo : equipos) {

            equipo.setPuntos(0);
            equipo.setVictorias(0);
            equipo.setEmpates(0);
            equipo.setDerrotas(0);
            equipo.setGolesFavor(0);
            equipo.setGolesContra(0);

        }

    }

    public static Equipo campeon(Liga liga) {

        Equipo equipoCampeon = null;

        for(Equipo equipo : liga.getEquipos()) {

            if(equipoCampeon == null || equipo.getPuntos()>equipoCampeon.getPuntos()) {

                equipoCampeon = equipo;

            }

        }

    return equipoCampeon;}

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", estadio=" + estadio +
                ", plantilla=" + plantilla +
                ", puntos=" + puntos +
                ", partidosJugados=" + partidosJugados +
                ", victorias=" + victorias +
                ", empates=" + empates +
                ", derrotas=" + derrotas +
                ", golesFavor=" + golesFavor +
                ", golesContra=" + golesContra;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return Objects.equals(nombre, equipo.nombre) && Objects.equals(estadio, equipo.estadio) && Objects.equals(plantilla, equipo.plantilla);
    }

}
