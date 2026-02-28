package proyectoLiga.partidos;

import proyectoLiga.liga.Equipo;
import proyectoLiga.liga.Jornada;
import proyectoLiga.personas.Jugador;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Partido {

    public static final String RESET = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";

    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int golesLocal;
    private int golesVisitante;
    private Jornada jornada;
    private List<Gol> goles;
    private List<TarjetaAmarilla> tarjetasAmarillas;
    private List<TarjetaRoja> tarjetasRojas;

    public Partido() {

    }

    public Partido(Equipo equipoLocal, Equipo equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

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

    public static void simularPartido(Partido partido, List<Jugador> jugadores, Equipo equipoSeleccionado){

        List<Jugador> jugadoresLocal = new ArrayList<>(jugadores);
        List<Jugador> jugadoresVisitante = new ArrayList<>(jugadores);
        Random oportunidades = new Random();
        Random jugadorRandom = new Random();
        Random rojas = new Random();


        if (partido.getEquipoLocal().equals(equipoSeleccionado)){

            int golesFavor = 0;
            int golesContra = 0;

            for (int i= 1; i <=90 ; i++){

                jugadoresLocal = partido.getEquipoLocal().getPlantilla();
                jugadoresVisitante = partido.getEquipoVisitante().getPlantilla();
                Jugador jugadorClaveLocal = jugadoresLocal.get(jugadorRandom.nextInt(jugadoresLocal.size()));
                Jugador jugadorClaveVisitante = jugadoresVisitante.get(jugadorRandom.nextInt(jugadoresVisitante.size()));


                if (oportunidades.nextInt(701)<=10){

                    golesFavor++;
                    equipoSeleccionado.setGolesFavor(golesFavor);
                    System.out.println(AZUL + "Minuto "+i+" Gol del "+equipoSeleccionado.getNombre()+", gol de "+ jugadorClaveLocal.getNombre() + " " + jugadorClaveLocal.getApellido() + RESET);

                } else if (oportunidades.nextInt(701)>10 && oportunidades.nextInt(701)<16) {

                    golesContra++;
                    equipoSeleccionado.setGolesContra(golesContra);
                    System.out.println(ROJO + "Minuto "+i+" Gol del "+partido.getEquipoVisitante().getNombre()+", gol de "+ jugadorClaveVisitante.getNombre()+ " "+  jugadorClaveVisitante.getApellido() + RESET);

                } else if (oportunidades.nextInt(701)>=16 && oportunidades.nextInt(701)<20) {

                    if (jugadorClaveLocal.getTarjetasRojas()==1) {

                        System.out.println("Minuto " + i);

                    }else if (jugadorClaveLocal.getTarjetasAmarillas()==0) {
                        jugadorClaveLocal.setTarjetasAmarillas(1);
                        System.out.println(AMARILLO + "Minuto " + i + " amarilla para el " + equipoSeleccionado.getNombre() + ", al jugador " + jugadorClaveLocal.getNombre() + " " + jugadorClaveLocal.getApellido() + RESET);
                    }else if (jugadorClaveLocal.getTarjetasAmarillas()==1) {

                        jugadorClaveLocal.setTarjetasAmarillas(2);
                        jugadorClaveLocal.setTarjetasRojas(1);
                        System.out.println(ROJO +"Minuto "+i+ " Expulsión a " + jugadorClaveLocal.getNombre() + " por doble amarilla por protestar" + RESET);

                    } else if (jugadorClaveLocal.getTarjetasRojas()==1) {

                        System.out.println("Minuto " + i);

                    }else{

                        System.out.println("Minuto " + i);

                    }

                }else if (oportunidades.nextInt(701)>=20 && oportunidades.nextInt(701)<22) {

                    if (jugadorClaveVisitante.getTarjetasRojas()==1) {

                        System.out.println("Minuto " + i);

                    }else if(jugadorClaveVisitante.getTarjetasAmarillas()==0) {
                        jugadorClaveVisitante.setTarjetasAmarillas(1);
                        System.out.println(AMARILLO + "Minuto " + i + " amarilla para el " + partido.getEquipoVisitante().getNombre() + ", al jugador " + jugadorClaveVisitante.getNombre() + " " + jugadorClaveVisitante.getApellido() + RESET);
                    }else if (jugadorClaveVisitante.getTarjetasAmarillas()==1) {

                        jugadorClaveVisitante.setTarjetasAmarillas(2);
                        jugadorClaveVisitante.setTarjetasRojas(1);
                        System.out.println(ROJO +"Minuto "+i+ " Expulsión a " + jugadorClaveVisitante.getNombre() + " por doble amarilla por protestar" + RESET);

                    }else if (jugadorClaveVisitante.getTarjetasRojas()==1) {

                        System.out.println("Minuto " + i);

                    } else {

                        System.out.println("Minuto " + i);

                    }

                } else if (rojas.nextInt(1000)<3 && rojas.nextInt(1000)>=2) {

                    if (jugadorClaveLocal.getTarjetasRojas()==0) {

                        jugadorClaveLocal.setTarjetasRojas(1);
                        System.out.println(ROJO + "Minuto " + i + " ROJA DIRECTA PARA EL " + equipoSeleccionado.getNombre() + " para el jugador " + jugadorClaveLocal.getNombre() + " " + jugadorClaveLocal.getApellido() + RESET);

                    }else {

                        System.out.println("Minuto " + i);

                    }

                }else if (rojas.nextInt(1000)<=1) {

                    if (jugadorClaveVisitante.getTarjetasRojas()==0) {

                        jugadorClaveVisitante.setTarjetasRojas(1);
                        System.out.println(ROJO + "Minuto " + i + " ROJA DIRECTA PARA EL " + partido.getEquipoVisitante().getNombre() + " para el jugador " + jugadorClaveVisitante.getNombre() + " " + jugadorClaveVisitante.getApellido() + RESET);

                    }else{

                        System.out.println("Minuto " + i);

                    }

                }else {

                    System.out.println("Minuto " + i);

                }

            }

            System.out.println(equipoSeleccionado.getNombre().toUpperCase() + " " + equipoSeleccionado.getGolesFavor() + " - " + partido.getEquipoVisitante().getNombre().toUpperCase() + " " + equipoSeleccionado.getGolesContra());

        }else if (partido.getEquipoVisitante().equals(equipoSeleccionado)){

            int golesFavor = 0;
            int golesContra = 0;

            for (int i= 1; i <=90 ; i++){

                jugadoresLocal = partido.getEquipoVisitante().getPlantilla();
                jugadoresVisitante = partido.getEquipoLocal().getPlantilla();
                Jugador jugadorClaveLocal = jugadoresLocal.get(jugadorRandom.nextInt(jugadoresLocal.size()));
                Jugador jugadorClaveVisitante = jugadoresVisitante.get(jugadorRandom.nextInt(jugadoresVisitante.size()));


                if (oportunidades.nextInt(701)<=7){

                    golesFavor++;
                    equipoSeleccionado.setGolesFavor(golesFavor);
                    System.out.println(AZUL + "Minuto "+i+" Gol del "+equipoSeleccionado.getNombre()+", gol de "+ jugadorClaveLocal.getNombre() + " " + jugadorClaveLocal.getApellido() + RESET);

                } else if (oportunidades.nextInt(701)>7 && oportunidades.nextInt(701)<12) {

                    golesContra++;
                    equipoSeleccionado.setGolesContra(golesContra);
                    System.out.println(ROJO + "Minuto "+i+" Gol del "+partido.getEquipoLocal().getNombre()+", gol de "+ jugadorClaveVisitante.getNombre() + " " + jugadorClaveVisitante.getApellido() + RESET);

                } else if (oportunidades.nextInt(701)>=14 && oportunidades.nextInt(701)<17) {

                    if (jugadorClaveLocal.getTarjetasRojas()==1) {

                        System.out.println("Minuto " + i);

                    }else if (jugadorClaveLocal.getTarjetasAmarillas()==1) {

                        jugadorClaveLocal.setTarjetasAmarillas(1);
                        System.out.println(AMARILLO + "Minuto " + i + " amarilla para el " + equipoSeleccionado.getNombre() + ", al jugador " + jugadorClaveLocal.getNombre() + " " + jugadorClaveLocal.getApellido() + RESET);

                    }else if (jugadorClaveLocal.getTarjetasAmarillas()==1) {

                        jugadorClaveLocal.setTarjetasAmarillas(2);
                        jugadorClaveLocal.setTarjetasRojas(1);
                        System.out.println(ROJO + "Minuto " +i+ " Expulsión a " + jugadorClaveLocal.getNombre() + " por doble amarilla por protestar" + RESET);

                    } else if (jugadorClaveLocal.getTarjetasRojas()==1) {

                        System.out.println("Minuto " + i);

                    }else {

                        System.out.println("Minuto " + i);

                    }

                }else if (oportunidades.nextInt(701)>=17 && oportunidades.nextInt(701)<20) {

                    if (jugadorClaveVisitante.getTarjetasRojas()==1) {

                        System.out.println("Minuto " + i);

                    }else if (jugadorClaveVisitante.getTarjetasAmarillas()==0) {

                        jugadorClaveVisitante.setTarjetasAmarillas(1);
                        System.out.println(AMARILLO + "Minuto " + i + " amarilla para el " + partido.getEquipoLocal().getNombre() + ", al jugador " + jugadorClaveVisitante.getNombre() + " " + jugadorClaveVisitante.getApellido() + RESET);

                    }else if (jugadorClaveVisitante.getTarjetasAmarillas()==1) {

                        jugadorClaveVisitante.setTarjetasAmarillas(2);
                        jugadorClaveVisitante.setTarjetasRojas(1);
                        System.out.println(ROJO + "Minuto " +i+ " Expulsión a " + jugadorClaveVisitante.getNombre() + " por doble amarilla por protestar" + RESET);

                    } else if (jugadorClaveVisitante.getTarjetasRojas()==1) {

                        System.out.println("Minuto " + i);

                    } else {

                        System.out.println("Minuto " + i);

                    }

                } else if (rojas.nextInt(1000)<=1) {

                    if (jugadorClaveLocal.getTarjetasRojas()==0) {

                        jugadorClaveLocal.setTarjetasRojas(1);
                        System.out.println(ROJO + "Minuto " + i + " ROJA DIRECTA PARA EL " + equipoSeleccionado.getNombre() + " para el jugador " + jugadorClaveLocal.getNombre() + " " + jugadorClaveLocal.getApellido() + RESET);

                    }else{

                        System.out.println("Minuto " + i);

                    }

                }else if (rojas.nextInt(1000)<3 && rojas.nextInt(1000)>=2) {

                    if (jugadorClaveVisitante.getTarjetasRojas()==0) {

                        jugadorClaveVisitante.setTarjetasRojas(1);
                        System.out.println(ROJO + "Minuto " + i + " ROJA DIRECTA PARA EL " + partido.getEquipoLocal().getNombre() + " para el jugador " + jugadorClaveVisitante.getNombre() + " " + jugadorClaveVisitante.getApellido() + RESET);

                    }else{

                        System.out.println("Minuto " + i);

                    }

                }else {

                    System.out.println("Minuto " + i);

                }

                System.out.println (partido.getEquipoLocal().getNombre().toUpperCase() + " " + golesContra+ " - " + equipoSeleccionado.getNombre().toUpperCase() + " " + equipoSeleccionado.getGolesFavor() );

            }



        }


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