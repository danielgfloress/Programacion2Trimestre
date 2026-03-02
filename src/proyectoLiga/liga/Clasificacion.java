package proyectoLiga.liga;

import proyectoLiga.partidos.Partido;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Clasificacion {

    private List<Equipo> equiposOrdenados;
    private String jornadaActual;
    Partido partido = new Partido();

    public Clasificacion() {
    }

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

    public static void mostrarClasificacionSoloPuntos(List<Equipo> equipos) {

        for (int i = 0; i < equipos.size() - 1; i++) {
            for (int j = 0; j < equipos.size() - 1 - i; j++) {

                if (equipos.get(j).getPuntos() < equipos.get(j + 1).getPuntos()) {

                    Equipo temp = equipos.get(j);
                    equipos.set(j, equipos.get(j + 1));
                    equipos.set(j + 1, temp);

                }
            }
        }

        System.out.println("\n=== CLASIFICACIÓN ===");
        System.out.printf("%-3s %-20s %-5s%n", "Pos", "Equipo", "Pts");

        int pos = 1;

        for (Equipo e : equipos) {
            System.out.printf("%-3d %-20s %-5d%n",
                    pos,
                    e.getNombre(),
                    e.getPuntos());
            pos++;
        }
    }

    public void puntosResto(List<Equipo> equipos, Partido partidoSeleccionado) {

        List<Equipo> equipos1 = new ArrayList<>(equipos);
        Random golesFavor = new Random();
        Random golesContra = new Random();
        Partido partidoCreado;
        equipos1.remove(partidoSeleccionado.getEquipoLocal());
        equipos1.remove(partidoSeleccionado.getEquipoVisitante());

        java.util.Collections.shuffle(equipos1);



        for (int i = 0; i < equipos1.size(); i+=2) {

            Equipo equipoLocal = equipos1.get(i);
            Equipo equipoVisitante = equipos1.get(i+1);

            partidoCreado = new Partido(equipoLocal, equipoVisitante);

            if (equipoLocal.getMedia() + 10 > equipoVisitante.getMedia()) {

                int golesAFavor = golesFavor.nextInt(7);
                int golesEnContra = golesContra.nextInt(3);
                partidoCreado.getEquipoLocal().setGolesFavor(golesAFavor);
                partidoCreado.getEquipoLocal().setGolesContra(golesEnContra);
                partidoCreado.getEquipoVisitante().setGolesFavor(golesEnContra);
                partidoCreado.getEquipoVisitante().setGolesContra(golesAFavor);
                partidoCreado.setGolesLocal(golesAFavor);
                partidoCreado.setGolesVisitante(golesEnContra);
                Partido.puntosPartido(partidoCreado, partidoCreado.getEquipoLocal(), partidoCreado.getEquipoVisitante());

            }else if (equipoLocal.getMedia() > equipoVisitante.getMedia()) {

                int golesAFavor = golesFavor.nextInt(6);
                int golesEnContra = golesContra.nextInt(3);
                partidoCreado.getEquipoLocal().setGolesFavor(golesAFavor);
                partidoCreado.getEquipoLocal().setGolesContra(golesEnContra);
                partidoCreado.getEquipoVisitante().setGolesFavor(golesEnContra);
                partidoCreado.getEquipoVisitante().setGolesContra(golesAFavor);
                partidoCreado.setGolesLocal(golesAFavor);
                partidoCreado.setGolesVisitante(golesEnContra);
                Partido.puntosPartido(partidoCreado, partidoCreado.getEquipoLocal(), partidoCreado.getEquipoVisitante());

            }else if (equipoLocal.getMedia() == equipoVisitante.getMedia()) {

                int golesAFavor = golesFavor.nextInt(4);
                int golesEnContra = golesContra.nextInt(4);
                partidoCreado.getEquipoLocal().setGolesFavor(golesAFavor);
                partidoCreado.getEquipoLocal().setGolesContra(golesEnContra);
                partidoCreado.getEquipoVisitante().setGolesFavor(golesEnContra);
                partidoCreado.getEquipoVisitante().setGolesContra(golesAFavor);
                partidoCreado.setGolesLocal(golesAFavor);
                partidoCreado.setGolesVisitante(golesEnContra);
                Partido.puntosPartido(partidoCreado, partidoCreado.getEquipoLocal(), partidoCreado.getEquipoVisitante());

            }else if (equipoLocal.getMedia() < equipoVisitante.getMedia()) {

                int golesAFavor = golesFavor.nextInt(3);
                int golesEnContra = golesContra.nextInt(4);
                partidoCreado.getEquipoLocal().setGolesFavor(golesAFavor);
                partidoCreado.getEquipoLocal().setGolesContra(golesEnContra);
                partidoCreado.getEquipoVisitante().setGolesFavor(golesEnContra);
                partidoCreado.getEquipoVisitante().setGolesContra(golesAFavor);
                partidoCreado.setGolesLocal(golesAFavor);
                partidoCreado.setGolesVisitante(golesEnContra);
                Partido.puntosPartido(partidoCreado, partidoCreado.getEquipoLocal(), partidoCreado.getEquipoVisitante());

            }else if (equipoLocal.getMedia() < equipoVisitante.getMedia() + 10) {

                int golesAFavor = golesFavor.nextInt(3);
                int golesEnContra = golesContra.nextInt(5);
                partidoCreado.getEquipoLocal().setGolesFavor(golesAFavor);
                partidoCreado.getEquipoLocal().setGolesContra(golesEnContra);
                partidoCreado.getEquipoVisitante().setGolesFavor(golesEnContra);
                partidoCreado.getEquipoVisitante().setGolesContra(golesAFavor);
                partidoCreado.setGolesLocal(golesAFavor);
                partidoCreado.setGolesVisitante(golesEnContra);
                Partido.puntosPartido(partidoCreado, partidoCreado.getEquipoLocal(), partidoCreado.getEquipoVisitante());

            }

        }


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
