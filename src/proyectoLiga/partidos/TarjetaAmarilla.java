package proyectoLiga.partidos;

import proyectoLiga.personas.Jugador;

import java.util.Objects;

public class TarjetaAmarilla {

    private Jugador jugador;
    private int minuto;

    public TarjetaAmarilla(Jugador jugador, int minuto) {
        this.jugador = jugador;
        this.minuto = minuto;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    @Override
    public String toString() {
        return "jugador=" + jugador +
                ", minuto=" + minuto;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TarjetaAmarilla that = (TarjetaAmarilla) o;
        return minuto == that.minuto && Objects.equals(jugador, that.jugador);
    }

}
