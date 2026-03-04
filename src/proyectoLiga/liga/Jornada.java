package proyectoLiga.liga;

import proyectoLiga.partidos.Partido;

import java.util.*;

public class Jornada {

    private int numero;
    private List<Partido> partidos;
    private boolean jugada;
    private static final Random equipoRandom = new Random();

    public Jornada() {}

    public Jornada(int numero, List<Partido> partidos, boolean jugada) {
        this.numero = numero;
        this.partidos = partidos;
        this.jugada = jugada;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public boolean isJugada() {
        return jugada;
    }

    public void setJugada(boolean jugada) {
        this.jugada = jugada;
    }


    public static Partido mostrarJornadaSinRepetir(
            List<Equipo> equipos,
            Equipo equipoSeleccionado,
            List<Partido> partidosLiga,
            int jornadaActual
    ) {
        int partidosIda = equipos.size() - 1;

        if (partidosLiga.size() >= partidosIda) {

            int indiceIda = partidosLiga.size() - partidosIda;
            Partido ida = partidosLiga.get(indiceIda);

            Partido vuelta = new Partido(
                    ida.getEquipoVisitante(),
                    ida.getEquipoLocal(),
                    false
            );
            vuelta.setJornada(jornadaActual);
            return vuelta;
        }

        List<Equipo> rivalesDisponibles = new ArrayList<>();

        for (int i = 0; i < equipos.size(); i++) {
            Equipo candidato = equipos.get(i);

            if (candidato.equals(equipoSeleccionado)) {
                continue;
            }

            boolean yaJugadoContraEse = false;

            for (int j = 0; j < partidosLiga.size(); j++) {
                Partido p = partidosLiga.get(j);

                if (equipoSeleccionado.equals(p.getEquipoLocal())) {
                    if (candidato.equals(p.getEquipoVisitante())) {
                        yaJugadoContraEse = true;
                        break;
                    }
                }

                else if (equipoSeleccionado.equals(p.getEquipoVisitante())) {
                    if (candidato.equals(p.getEquipoLocal())) {
                        yaJugadoContraEse = true;
                        break;
                    }
                }
            }

            if (!yaJugadoContraEse) {
                rivalesDisponibles.add(candidato);
            }
        }

        if (rivalesDisponibles.size() == 0) {
            Partido ida = partidosLiga.get(0);
            Partido vuelta = new Partido(ida.getEquipoVisitante(), ida.getEquipoLocal(), false);
            vuelta.setJornada(jornadaActual);
            return vuelta;
        }

        Equipo rival = rivalesDisponibles.get(equipoRandom.nextInt(rivalesDisponibles.size()));

        Partido partido;
        int local = equipoRandom.nextInt(2);

        if (local == 0) {
            partido = new Partido(equipoSeleccionado, rival, false);
        } else {
            partido = new Partido(rival, equipoSeleccionado, false);
        }

        partido.setJornada(jornadaActual);
        return partido;
    }


    @Override
    public String toString() {
        return "numero=" + numero +
                ", partidos=" + partidos +
                ", jugada=" + jugada;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Jornada jornada = (Jornada) o;
        return numero == jornada.numero;
    }

}
