package proyectoLiga.partidos;

import proyectoLiga.enumerador.Posicion;
import proyectoLiga.enumerador.Resultado;
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

    public static Resultado simularResultado () {

        Random r = new Random();
        int probabilidad = r.nextInt(100);

        if (probabilidad < 45) {
            return Resultado.LOCAL_GANA;
        }
        if (probabilidad < 70) {
            return Resultado.EMPATE;
        }

        return Resultado.VISITANTE_GANA;

    }

    public static void aplicarResultado (Equipo equipoLocal, Equipo equipoVisitante, Resultado resultado) {

        if (resultado == Resultado.LOCAL_GANA) {
            equipoLocal.setPuntos(equipoLocal.getPuntos() + 3);
        } else if (resultado == Resultado.VISITANTE_GANA) {
            equipoVisitante.setPuntos(equipoVisitante.getPuntos() + 3);
        } else {
            equipoLocal.setPuntos(equipoLocal.getPuntos() + 1);
            equipoVisitante.setPuntos(equipoVisitante.getPuntos() + 1);
        }

    }

    //funcion esta mal
    public static void simularJornada(List<Partido> jornada, Equipo equipoSeleccionado) {

        boolean juegaSeleccionado = false;

        for (Partido partido : jornada) {

            if (partido.getEquipoLocal().equals(equipoSeleccionado) || partido.getEquipoVisitante().equals(equipoSeleccionado)) {

                juegaSeleccionado = true;
                break;
            }

        }

        if (juegaSeleccionado) {
            return;
        }

        for (Partido partido : jornada) {

            Resultado resultado = simularResultado();
            aplicarResultado(partido.getEquipoLocal(), partido.getEquipoVisitante(), resultado);

        }

    }

    public void puntosPartido(Partido partido, Equipo equipoLocal, Equipo equipoVisitante) {

        if (partido.getGolesLocal() > partido.getGolesVisitante()) {
            Resultado resultado = Resultado.LOCAL_GANA;
            aplicarResultado(equipoLocal, equipoVisitante, resultado);
        } else if (partido.getGolesLocal() < partido.getGolesVisitante()) {
            Resultado resultado = Resultado.VISITANTE_GANA;
            aplicarResultado(equipoLocal, equipoVisitante, resultado);
        } else {
            Resultado resultado = Resultado.EMPATE;
            aplicarResultado(equipoLocal, equipoVisitante, resultado);
        }

    }

    public static void simularPartido(Partido partido, List<Jugador> jugadores, Equipo equipoSeleccionado){

        List<Jugador> jugadoresLocal = new ArrayList<>(jugadores);
        List<Jugador> jugadoresVisitante = new ArrayList<>(jugadores);
        jugadoresLocal = partido.getEquipoLocal().getPlantilla();
        jugadoresVisitante = partido.getEquipoVisitante().getPlantilla();
        Random oportunidades = new Random();
        Random jugadorRandom = new Random();
        Random rojas = new Random();


        if (partido.getEquipoLocal().equals(equipoSeleccionado)){

            int golesFavor = 0;
            int golesContra = 0;
            partido.setGolesLocal(0);
            partido.setGolesVisitante(0);

            for (int i =0; i<jugadores.size();i++){

                jugadores.get(i).setTarjetasRojas(0);
                jugadores.get(i).setTarjetasAmarillas(0);

            }

            for (int i= 1; i <=90 ; i++){

                Jugador jugadorClaveLocal = jugadoresLocal.get(jugadorRandom.nextInt(jugadoresLocal.size()));
                Jugador jugadorClaveVisitante = jugadoresVisitante.get(jugadorRandom.nextInt(jugadoresVisitante.size()));


                if (oportunidades.nextInt(701)<=6){

                    if (jugadorClaveLocal.getTarjetasRojas()==1){

                        System.out.println("Minuto " + i);

                    }else {

                        golesFavor++;
                        partido.setGolesLocal(golesFavor);
                        partido.getEquipoLocal().setGolesFavor(golesFavor);
                        partido.getEquipoVisitante().setGolesContra(golesFavor);
                        System.out.println(AZUL + "Minuto " + i + " Gol del " + equipoSeleccionado.getNombre() + ", gol de " + jugadorClaveLocal.getNombre() + " " + jugadorClaveLocal.getApellido() + RESET);

                    }

                } else if (oportunidades.nextInt(701)>10 && oportunidades.nextInt(701)<13) {
                    if (jugadorClaveVisitante.getTarjetasRojas()==1){

                        System.out.println("Minuto " + i);

                    }else {

                        golesContra++;
                        partido.setGolesVisitante(golesContra);
                        partido.getEquipoVisitante().setGolesFavor(golesContra);
                        partido.getEquipoLocal().setGolesContra(golesContra);
                        System.out.println(ROJO + "Minuto " + i + " Gol del " + partido.getEquipoVisitante().getNombre() + ", gol de " + jugadorClaveVisitante.getNombre() + " " + jugadorClaveVisitante.getApellido() + RESET);

                    }

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

                        if (jugadorClaveLocal.getPosicion().equals(Posicion.PORTERO)){

                            jugadorClaveLocal = jugadoresLocal.get(jugadorRandom.nextInt(jugadoresLocal.size()));

                            System.out.println("En sustitución al portero expulsado ocupara su lugar en la porteria " + jugadorClaveLocal.getNombre() + " "+ jugadorClaveLocal.getApellido());

                        }

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

                        if (jugadorClaveVisitante.getPosicion().equals(Posicion.PORTERO)){

                            jugadorClaveVisitante = jugadoresVisitante.get(jugadorRandom.nextInt(jugadoresVisitante.size()));

                            System.out.println("En sustitución al portero expulsado ocupara su lugar en la porteria " + jugadorClaveVisitante.getNombre() + " "+ jugadorClaveVisitante.getApellido());

                        }

                    }else if (jugadorClaveVisitante.getTarjetasRojas()==1) {

                        System.out.println("Minuto " + i);

                    } else {

                        System.out.println("Minuto " + i);

                    }

                } else if (rojas.nextInt(1000)<3 && rojas.nextInt(1000)>=2) {

                    if (jugadorClaveLocal.getTarjetasRojas()==0) {

                        jugadorClaveLocal.setTarjetasRojas(1);
                        System.out.println(ROJO + "Minuto " + i + " ROJA DIRECTA PARA EL " + equipoSeleccionado.getNombre() + " para el jugador " + jugadorClaveLocal.getNombre() + " " + jugadorClaveLocal.getApellido() + RESET);

                        if (jugadorClaveLocal.getPosicion().equals(Posicion.PORTERO)){

                            jugadorClaveLocal = jugadoresLocal.get(jugadorRandom.nextInt(jugadoresLocal.size()));

                            System.out.println("En sustitución al portero expulsado ocupara su lugar en la porteria " + jugadorClaveLocal.getNombre() + " "+ jugadorClaveLocal.getApellido());

                        }

                    }else {

                        System.out.println("Minuto " + i);

                    }

                }else if (rojas.nextInt(1000)<=1) {

                    if (jugadorClaveVisitante.getTarjetasRojas()==0) {

                        jugadorClaveVisitante.setTarjetasRojas(1);
                        System.out.println(ROJO + "Minuto " + i + " ROJA DIRECTA PARA EL " + partido.getEquipoVisitante().getNombre() + " para el jugador " + jugadorClaveVisitante.getNombre() + " " + jugadorClaveVisitante.getApellido() + RESET);

                        if (jugadorClaveVisitante.getPosicion().equals(Posicion.PORTERO)){

                            jugadorClaveVisitante = jugadoresVisitante.get(jugadorRandom.nextInt(jugadoresVisitante.size()));

                            System.out.println("En sustitución al portero expulsado ocupara su lugar en la porteria " + jugadorClaveVisitante.getNombre() + " "+ jugadorClaveVisitante.getApellido());

                        }

                    }else{

                        System.out.println("Minuto " + i);

                    }

                }else {

                    System.out.println("Minuto " + i);

                }

            }

            System.out.println(equipoSeleccionado.getNombre() + " " + partido.getGolesLocal() + " - " + partido.getEquipoVisitante().getNombre() + " " + partido.getGolesVisitante());


        }else if (partido.getEquipoVisitante().equals(equipoSeleccionado)){

            int golesFavor = 0;
            int golesContra = 0;
            partido.setGolesLocal(0);
            partido.setGolesVisitante(0);

            for (int i =0; i<jugadores.size();i++){

                jugadores.get(i).setTarjetasRojas(0);
                jugadores.get(i).setTarjetasAmarillas(0);

            }


            for (int i= 1; i <=90 ; i++){

                Jugador jugadorClaveLocal = jugadoresLocal.get(jugadorRandom.nextInt(jugadoresLocal.size()));
                Jugador jugadorClaveVisitante = jugadoresVisitante.get(jugadorRandom.nextInt(jugadoresVisitante.size()));


                if (oportunidades.nextInt(701)<=5){

                    if (jugadorClaveVisitante.getTarjetasRojas()==1){

                        System.out.println("Minuto " + i);

                    }else {

                        golesFavor++;
                        partido.setGolesVisitante(golesFavor);
                        partido.getEquipoVisitante().setGolesFavor(golesFavor);
                        partido.getEquipoLocal().setGolesContra(golesFavor);
                        System.out.println(AZUL + "Minuto " + i + " Gol del " + equipoSeleccionado.getNombre() + ", gol de " + jugadorClaveVisitante.getNombre() + " " + jugadorClaveVisitante.getApellido() + RESET);

                    }

                } else if (oportunidades.nextInt(701)>7 && oportunidades.nextInt(701)<10) {

                    if (jugadorClaveLocal.getTarjetasRojas()==1){

                        System.out.println("Minuto " + i);

                    }else {

                        golesContra++;
                        partido.setGolesLocal(golesContra);
                        partido.getEquipoLocal().setGolesFavor(golesContra);
                        partido.getEquipoVisitante().setGolesContra(golesContra);
                        System.out.println(ROJO + "Minuto " + i + " Gol del " + partido.getEquipoLocal().getNombre() + ", gol de " + jugadorClaveLocal.getNombre() + " " + jugadorClaveLocal.getApellido() + RESET);

                    }

                } else if (oportunidades.nextInt(701)>=14 && oportunidades.nextInt(701)<17) {

                    if (jugadorClaveVisitante.getTarjetasRojas()==1) {

                        System.out.println("Minuto " + i);

                    }else if (jugadorClaveVisitante.getTarjetasAmarillas()==0) {

                        jugadorClaveVisitante.setTarjetasAmarillas(1);
                        System.out.println(AMARILLO + "Minuto " + i + " amarilla para el " + equipoSeleccionado.getNombre() + ", al jugador " + jugadorClaveVisitante.getNombre() + " " + jugadorClaveVisitante.getApellido() + RESET);

                    }else if (jugadorClaveVisitante.getTarjetasAmarillas()==1) {

                        jugadorClaveVisitante.setTarjetasAmarillas(2);
                        jugadorClaveVisitante.setTarjetasRojas(1);
                        System.out.println(ROJO + "Minuto " +i+ " Expulsión a " + jugadorClaveVisitante.getNombre() + " por doble amarilla por protestar" + RESET);

                        if (jugadorClaveVisitante.getPosicion().equals(Posicion.PORTERO)){

                            jugadorClaveVisitante = jugadoresVisitante.get(jugadorRandom.nextInt(jugadoresVisitante.size()));

                            System.out.println("En sustitución al portero expulsado ocupara su lugar en la porteria " + jugadorClaveVisitante.getNombre() + " "+ jugadorClaveVisitante.getApellido());

                        }

                    }else {

                        System.out.println("Minuto " + i);

                    }

                }else if (oportunidades.nextInt(701)>=17 && oportunidades.nextInt(701)<20) {

                    if (jugadorClaveLocal.getTarjetasRojas()==1) {

                        System.out.println("Minuto " + i);

                    }else if (jugadorClaveLocal.getTarjetasAmarillas()==0) {

                        jugadorClaveLocal.setTarjetasAmarillas(1);
                        System.out.println(AMARILLO + "Minuto " + i + " amarilla para el " + partido.getEquipoLocal().getNombre() + ", al jugador " + jugadorClaveLocal.getNombre() + " " + jugadorClaveLocal.getApellido() + RESET);

                    }else if (jugadorClaveLocal.getTarjetasAmarillas()==1) {

                        jugadorClaveLocal.setTarjetasAmarillas(2);
                        jugadorClaveLocal.setTarjetasRojas(1);
                        System.out.println(ROJO + "Minuto " +i+ " Expulsión a " + jugadorClaveLocal.getNombre() + " por doble amarilla por protestar" + RESET);

                        if (jugadorClaveLocal.getPosicion().equals(Posicion.PORTERO)){

                            jugadorClaveLocal = jugadoresLocal.get(jugadorRandom.nextInt(jugadoresLocal.size()));

                            System.out.println("En sustitución al portero expulsado ocupara su lugar en la porteria " + jugadorClaveLocal.getNombre() + " "+ jugadorClaveLocal.getApellido());

                        }

                    }else {

                        System.out.println("Minuto " + i);

                    }

                } else if (rojas.nextInt(1000)<=1) {

                    if (jugadorClaveLocal.getTarjetasRojas()==0) {

                        jugadorClaveLocal.setTarjetasRojas(1);
                        System.out.println(ROJO + "Minuto " + i + " ROJA DIRECTA PARA EL " + equipoSeleccionado.getNombre() + " para el jugador " + jugadorClaveVisitante.getNombre() + " " + jugadorClaveVisitante.getApellido() + RESET);

                        if (jugadorClaveVisitante.getPosicion().equals(Posicion.PORTERO)){

                            jugadorClaveVisitante = jugadoresVisitante.get(jugadorRandom.nextInt(jugadoresVisitante.size()));

                            System.out.println("En sustitución al portero expulsado ocupara su lugar en la porteria " + jugadorClaveVisitante.getNombre() + " "+ jugadorClaveVisitante.getApellido());

                        }

                    }else{

                        System.out.println("Minuto " + i);

                    }

                }else if (rojas.nextInt(1000)<3 && rojas.nextInt(1000)>=2) {

                    if (jugadorClaveVisitante.getTarjetasRojas()==0) {

                        jugadorClaveVisitante.setTarjetasRojas(1);
                        System.out.println(ROJO + "Minuto " + i + " ROJA DIRECTA PARA EL " + partido.getEquipoLocal().getNombre() + " para el jugador " + jugadorClaveLocal.getNombre() + " " + jugadorClaveLocal.getApellido() + RESET);

                        if (jugadorClaveLocal.getPosicion().equals(Posicion.PORTERO)){

                            jugadorClaveLocal = jugadoresLocal.get(jugadorRandom.nextInt(jugadoresLocal.size()));

                            System.out.println("En sustitución al portero expulsado ocupara su lugar en la porteria " + jugadorClaveLocal.getNombre() + " "+ jugadorClaveLocal.getApellido());

                        }

                    }else{

                        System.out.println("Minuto " + i);

                    }

                }else {

                    System.out.println("Minuto " + i);

                }



            }

            System.out.println (partido.getEquipoLocal().getNombre() + " " + partido.getGolesLocal()+ " - " + equipoSeleccionado.getNombre() + " " + partido.getGolesVisitante());

        }


    }

    public void partidoRapido(Partido partido, Equipo equipoSeleccionado){

        Random golesFavor = new Random();
        Random golesContra = new Random();

        if (equipoSeleccionado.equals(partido.getEquipoLocal())){

            int golesAFavor = golesFavor.nextInt(5);
            int golesEnContra = golesContra.nextInt(4);
            partido.getEquipoLocal().setGolesFavor(golesAFavor);
            partido.getEquipoLocal().setGolesContra(golesEnContra);
            partido.getEquipoVisitante().setGolesFavor(golesEnContra);
            partido.getEquipoVisitante().setGolesContra(golesAFavor);
            partido.setGolesLocal(golesAFavor);
            partido.setGolesVisitante(golesEnContra);

            System.out.println("\n\n" + equipoSeleccionado.getNombre() + " " + golesAFavor + " - " + golesEnContra + " " + partido.getEquipoVisitante().getNombre());

            puntosPartido(partido, partido.getEquipoLocal(), partido.getEquipoVisitante());
            System.out.println("Tus puntos: " + equipoSeleccionado.getPuntos());

        }else{

            int golesAFavor = golesFavor.nextInt(4);
            int golesEnContra = golesContra.nextInt(4);
            partido.getEquipoLocal().setGolesFavor(golesAFavor);
            partido.getEquipoLocal().setGolesContra(golesEnContra);
            partido.getEquipoVisitante().setGolesFavor(golesEnContra);
            partido.getEquipoVisitante().setGolesContra(golesAFavor);
            partido.setGolesLocal(golesEnContra);
            partido.setGolesVisitante(golesAFavor);

            System.out.println("\n\n" + partido.getEquipoLocal().getNombre() + " " + golesEnContra + " - " + golesAFavor + " " + equipoSeleccionado.getNombre());

            puntosPartido(partido, partido.getEquipoLocal(), partido.getEquipoVisitante());
            System.out.println("Tus puntos: " + equipoSeleccionado.getPuntos());

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