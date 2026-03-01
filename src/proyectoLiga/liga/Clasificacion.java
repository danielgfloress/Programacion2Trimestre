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

    public static void mostrarClasificacionSoloPuntos(List<Equipo> equipos) {

        for (int i = 0; i < equipos.size() - 1; i++) {
            for (int j = 0; j < equipos.size() - 1 - i; j++) {

                if (equipos.get(j).getPuntos() < equipos.get(j + 1).getPuntos()) {

                    // Intercambiar posiciones
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
