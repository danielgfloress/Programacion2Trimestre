package proyectoLiga.partidos;

import proyectoLiga.enumeradores.Posicion;
import proyectoLiga.enumeradores.Resultado;
import proyectoLiga.liga.Equipo;
import proyectoLiga.liga.Jornada;
import proyectoLiga.personas.AbstractPersona;
import proyectoLiga.personas.Entrenador;
import proyectoLiga.personas.Jugador;
import proyectoLiga.velocidadDeTexto.VelocidadDeTexto;

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
    private int jornada;
    private boolean jugado;
    private List<Gol> goles;
    private List<TarjetaAmarilla> tarjetasAmarillas;
    private List<TarjetaRoja> tarjetasRojas;
    VelocidadDeTexto imprimir = new VelocidadDeTexto();

    public Partido() {

    }

    public Partido(Equipo equipoLocal, Equipo equipoVisitante, boolean jugado) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.jugado = jugado;
    }

    public Partido(Equipo equipoLocal, Equipo equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    public Partido(Equipo equipoLocal, Equipo equipoVisitante, int golesLocal, int golesVisitante, int jornada, List<Gol> goles, List<TarjetaAmarilla> tarjetasAmarillas, List<TarjetaRoja> tarjetasRojas) {
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

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    public boolean isJugado() {
        return jugado;
    }

    public void setJugado(boolean jugado) {
        this.jugado = jugado;
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
        }else if (probabilidad < 70) {
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

    public static void puntosPartido(Partido partido, Equipo equipoLocal, Equipo equipoVisitante) {

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

        AbstractPersona persona;
        persona = new Jugador();
        persona.hablar();

        persona = new Entrenador();
        persona.hablar();

        if (partido.getEquipoLocal().equals(equipoSeleccionado)){

            int golesFavor = 0;
            int golesContra = 0;

            for (int i =0; i<jugadores.size();i++){

                jugadores.get(i).setTarjetasRojas(0);
                jugadores.get(i).setTarjetasAmarillas(0);

            }

            for (int i= 1; i <=90 ; i++){

                Jugador jugadorClaveLocal = jugadoresLocal.get(jugadorRandom.nextInt(jugadoresLocal.size()));
                Jugador jugadorClaveVisitante = jugadoresVisitante.get(jugadorRandom.nextInt(jugadoresVisitante.size()));

                int opciones = oportunidades.nextInt(0,701);
                int opcionesRoja = rojas.nextInt(1000);

                if (opciones <= 17 ){

                    if (jugadorClaveLocal.getTarjetasRojas()==1 || jugadorClaveLocal.getPosicion().equals(Posicion.PORTERO)){

                        VelocidadDeTexto.escribirLento("Minuto " + i,10);

                    }else {

                        golesFavor++;
                        partido.setGolesLocal(golesFavor);
                        jugadorClaveLocal.setGoles(1 + jugadorClaveLocal.getGoles());
                        partido.getEquipoLocal().setGolesFavor(1 + partido.getEquipoLocal().getGolesFavor());
                        partido.getEquipoVisitante().setGolesContra(1 + partido.getEquipoVisitante().getGolesContra());
                        VelocidadDeTexto.escribirLento(AZUL + "Minuto " + i + " Gol del " + equipoSeleccionado.getNombre() + ", gol de " + jugadorClaveLocal.getNombre() + " " + jugadorClaveLocal.getApellido() + RESET,10);

                    }

                } else if (opciones > 20 && opciones <26) {
                    if (jugadorClaveVisitante.getTarjetasRojas()==1 || jugadorClaveVisitante.getPosicion().equals(Posicion.PORTERO)){

                        VelocidadDeTexto.escribirLento("Minuto " + i,10);

                    }else {

                        golesContra++;
                        partido.setGolesVisitante(golesContra);
                        jugadorClaveVisitante.setGoles(1 + jugadorClaveVisitante.getGoles());
                        partido.getEquipoVisitante().setGolesFavor(1 + partido.getEquipoVisitante().getGolesFavor());
                        partido.getEquipoLocal().setGolesContra(1 + partido.getEquipoLocal().getGolesContra());
                        VelocidadDeTexto.escribirLento(ROJO + "Minuto " + i + " Gol del " + partido.getEquipoVisitante().getNombre() + ", gol de " + jugadorClaveVisitante.getNombre() + " " + jugadorClaveVisitante.getApellido() + RESET,10);

                    }

                } else if (opciones >=26 && opciones <36) {

                    if (jugadorClaveLocal.getTarjetasRojas()==1) {

                        VelocidadDeTexto.escribirLento("Minuto " + i,10);

                    }else if (jugadorClaveLocal.getTarjetasAmarillas()==0) {
                        jugadorClaveLocal.setTarjetasAmarillas(1);
                        VelocidadDeTexto.escribirLento(AMARILLO + "Minuto " + i + " amarilla para el " + equipoSeleccionado.getNombre() + ", al jugador " + jugadorClaveLocal.getNombre() + " " + jugadorClaveLocal.getApellido() + RESET,10);
                    }else if (jugadorClaveLocal.getTarjetasAmarillas()==1) {

                        jugadorClaveLocal.setTarjetasAmarillas(2);
                        jugadorClaveLocal.setTarjetasRojas(1);
                        VelocidadDeTexto.escribirLento(ROJO +"Minuto "+i+ " Expulsión a " + jugadorClaveLocal.getNombre() + " por doble amarilla por protestar" + RESET,10);

                        if (jugadorClaveLocal.getPosicion().equals(Posicion.PORTERO)){

                            jugadorClaveLocal = jugadoresLocal.get(jugadorRandom.nextInt(jugadoresLocal.size()));

                            VelocidadDeTexto.escribirLento("En sustitución al portero expulsado ocupara su lugar en la porteria " + jugadorClaveLocal.getNombre() + " "+ jugadorClaveLocal.getApellido(),10);

                        }

                    } else if (jugadorClaveLocal.getTarjetasRojas()==1) {

                        VelocidadDeTexto.escribirLento("Minuto " + i,10);

                    }else{

                        VelocidadDeTexto.escribirLento("Minuto " + i,10);

                    }

                }else if (opciones>=36 && opciones<46) {

                    if (jugadorClaveVisitante.getTarjetasRojas()==1) {

                        VelocidadDeTexto.escribirLento("Minuto " + i,10);

                    }else if(jugadorClaveVisitante.getTarjetasAmarillas()==0) {
                        jugadorClaveVisitante.setTarjetasAmarillas(1);
                        VelocidadDeTexto.escribirLento(AMARILLO + "Minuto " + i + " amarilla para el " + partido.getEquipoVisitante().getNombre() + ", al jugador " + jugadorClaveVisitante.getNombre() + " " + jugadorClaveVisitante.getApellido() + RESET,10);
                    }else if (jugadorClaveVisitante.getTarjetasAmarillas()==1) {

                        jugadorClaveVisitante.setTarjetasAmarillas(2);
                        jugadorClaveVisitante.setTarjetasRojas(1);
                        VelocidadDeTexto.escribirLento(ROJO +"Minuto "+i+ " Expulsión a " + jugadorClaveVisitante.getNombre() + " por doble amarilla por protestar" + RESET,10);

                        if (jugadorClaveVisitante.getPosicion().equals(Posicion.PORTERO)){

                            jugadorClaveVisitante = jugadoresVisitante.get(jugadorRandom.nextInt(jugadoresVisitante.size()));

                            VelocidadDeTexto.escribirLento("En sustitución al portero expulsado ocupara su lugar en la porteria " + jugadorClaveVisitante.getNombre() + " "+ jugadorClaveVisitante.getApellido(),10);

                        }

                    }else if (jugadorClaveVisitante.getTarjetasRojas()==1) {

                        VelocidadDeTexto.escribirLento("Minuto " + i,10);

                    } else {

                        VelocidadDeTexto.escribirLento("Minuto " + i,10);

                    }

                } else if (opcionesRoja<3 && opcionesRoja>=2) {

                    if (jugadorClaveLocal.getTarjetasRojas()==0) {

                        jugadorClaveLocal.setTarjetasRojas(1);
                        VelocidadDeTexto.escribirLento(ROJO + "Minuto " + i + " ROJA DIRECTA PARA EL " + equipoSeleccionado.getNombre() + " para el jugador " + jugadorClaveLocal.getNombre() + " " + jugadorClaveLocal.getApellido() + RESET,10);

                        if (jugadorClaveLocal.getPosicion().equals(Posicion.PORTERO)){

                            jugadorClaveLocal = jugadoresLocal.get(jugadorRandom.nextInt(jugadoresLocal.size()));

                            VelocidadDeTexto.escribirLento("En sustitución al portero expulsado ocupara su lugar en la porteria " + jugadorClaveLocal.getNombre() + " "+ jugadorClaveLocal.getApellido(),10);

                        }

                    }else {

                        VelocidadDeTexto.escribirLento("Minuto " + i,10);

                    }

                }else if (opcionesRoja<=1) {

                    if (jugadorClaveVisitante.getTarjetasRojas()==0) {

                        jugadorClaveVisitante.setTarjetasRojas(1);
                        VelocidadDeTexto.escribirLento(ROJO + "Minuto " + i + " ROJA DIRECTA PARA EL " + partido.getEquipoVisitante().getNombre() + " para el jugador " + jugadorClaveVisitante.getNombre() + " " + jugadorClaveVisitante.getApellido() + RESET,10);

                        if (jugadorClaveVisitante.getPosicion().equals(Posicion.PORTERO)){

                            jugadorClaveVisitante = jugadoresVisitante.get(jugadorRandom.nextInt(jugadoresVisitante.size()));

                            VelocidadDeTexto.escribirLento("En sustitución al portero expulsado ocupara su lugar en la porteria " + jugadorClaveVisitante.getNombre() + " "+ jugadorClaveVisitante.getApellido(),10);

                        }

                    }else{

                        VelocidadDeTexto.escribirLento("Minuto " + i,10);

                    }

                }else {

                    VelocidadDeTexto.escribirLento("Minuto " + i,10);

                }

            }

            VelocidadDeTexto.escribirLento("\n\n" + equipoSeleccionado.getNombre() + " " + golesFavor + " - " + golesContra + " " + partido.getEquipoVisitante().getNombre(),100);


        }else if (partido.getEquipoVisitante().equals(equipoSeleccionado)){

            int golesFavor = 0;
            int golesContra = 0;

            for (int i =0; i<jugadores.size();i++){

                jugadores.get(i).setTarjetasRojas(0);
                jugadores.get(i).setTarjetasAmarillas(0);

            }


            for (int i= 1; i <=90 ; i++){

                Jugador jugadorClaveLocal = jugadoresLocal.get(jugadorRandom.nextInt(jugadoresLocal.size()));
                Jugador jugadorClaveVisitante = jugadoresVisitante.get(jugadorRandom.nextInt(jugadoresVisitante.size()));

                int opciones = oportunidades.nextInt(0,701);
                int opcionesRoja = rojas.nextInt(1000);


                if (opciones<=14){

                    if (jugadorClaveVisitante.getTarjetasRojas()==1 || jugadorClaveVisitante.getPosicion().equals(Posicion.PORTERO)){

                        VelocidadDeTexto.escribirLento("Minuto " + i,10);

                    }else {

                        golesFavor++;
                        partido.setGolesVisitante(golesFavor);
                        jugadorClaveVisitante.setGoles(1 + jugadorClaveVisitante.getGoles());
                        partido.getEquipoVisitante().setGolesFavor(1 + partido.getEquipoVisitante().getGolesFavor());
                        partido.getEquipoLocal().setGolesContra(1 + partido.getEquipoLocal().getGolesContra());
                        VelocidadDeTexto.escribirLento(AZUL + "Minuto " + i + " Gol del " + equipoSeleccionado.getNombre() + ", gol de " + jugadorClaveVisitante.getNombre() + " " + jugadorClaveVisitante.getApellido() + RESET,10);

                    }

                } else if (opciones>18 && opciones<24) {

                    if (jugadorClaveLocal.getTarjetasRojas()==1 || jugadorClaveLocal.getPosicion().equals(Posicion.PORTERO)){

                        VelocidadDeTexto.escribirLento("Minuto " + i,10);

                    }else {

                        golesContra++;
                        partido.setGolesLocal(golesContra);
                        jugadorClaveLocal.setGoles(1 + jugadorClaveLocal.getGoles());
                        partido.getEquipoLocal().setGolesFavor(1 + partido.getEquipoLocal().getGolesFavor());
                        partido.getEquipoVisitante().setGolesContra(1 + partido.getEquipoVisitante().getGolesContra());
                        VelocidadDeTexto.escribirLento(ROJO + "Minuto " + i + " Gol del " + partido.getEquipoLocal().getNombre() + ", gol de " + jugadorClaveLocal.getNombre() + " " + jugadorClaveLocal.getApellido() + RESET,10);

                    }

                } else if (opciones>=24 && opciones<32) {

                    if (jugadorClaveVisitante.getTarjetasRojas()==1) {

                        VelocidadDeTexto.escribirLento("Minuto " + i,10);

                    }else if (jugadorClaveVisitante.getTarjetasAmarillas()==0) {

                        jugadorClaveVisitante.setTarjetasAmarillas(1);
                        VelocidadDeTexto.escribirLento(AMARILLO + "Minuto " + i + " amarilla para el " + equipoSeleccionado.getNombre() + ", al jugador " + jugadorClaveVisitante.getNombre() + " " + jugadorClaveVisitante.getApellido() + RESET,10);

                    }else if (jugadorClaveVisitante.getTarjetasAmarillas()==1) {

                        jugadorClaveVisitante.setTarjetasAmarillas(2);
                        jugadorClaveVisitante.setTarjetasRojas(1);
                        VelocidadDeTexto.escribirLento(ROJO + "Minuto " +i+ " Expulsión a " + jugadorClaveVisitante.getNombre() + " por doble amarilla por protestar" + RESET,10);

                        if (jugadorClaveVisitante.getPosicion().equals(Posicion.PORTERO)){

                            jugadorClaveVisitante = jugadoresVisitante.get(jugadorRandom.nextInt(jugadoresVisitante.size()));

                            VelocidadDeTexto.escribirLento("En sustitución al portero expulsado ocupara su lugar en la porteria " + jugadorClaveVisitante.getNombre() + " "+ jugadorClaveVisitante.getApellido(),10);

                        }

                    }else {

                        VelocidadDeTexto.escribirLento("Minuto " + i,10);

                    }

                }else if (opciones>=32 && opciones<38) {

                    if (jugadorClaveLocal.getTarjetasRojas()==1) {

                        VelocidadDeTexto.escribirLento("Minuto " + i,10);

                    }else if (jugadorClaveLocal.getTarjetasAmarillas()==0) {

                        jugadorClaveLocal.setTarjetasAmarillas(1);
                        VelocidadDeTexto.escribirLento(AMARILLO + "Minuto " + i + " amarilla para el " + partido.getEquipoLocal().getNombre() + ", al jugador " + jugadorClaveLocal.getNombre() + " " + jugadorClaveLocal.getApellido() + RESET,10);

                    }else if (jugadorClaveLocal.getTarjetasAmarillas()==1) {

                        jugadorClaveLocal.setTarjetasAmarillas(2);
                        jugadorClaveLocal.setTarjetasRojas(1);
                        VelocidadDeTexto.escribirLento(ROJO + "Minuto " +i+ " Expulsión a " + jugadorClaveLocal.getNombre() + " por doble amarilla por protestar" + RESET,10);

                        if (jugadorClaveLocal.getPosicion().equals(Posicion.PORTERO)){

                            jugadorClaveLocal = jugadoresLocal.get(jugadorRandom.nextInt(jugadoresLocal.size()));

                            VelocidadDeTexto.escribirLento("En sustitución al portero expulsado ocupara su lugar en la porteria " + jugadorClaveLocal.getNombre() + " "+ jugadorClaveLocal.getApellido(),10);

                        }

                    }else {

                        VelocidadDeTexto.escribirLento("Minuto " + i,10);

                    }

                } else if (opcionesRoja<=1) {

                    if (jugadorClaveLocal.getTarjetasRojas()==0) {

                        jugadorClaveLocal.setTarjetasRojas(1);
                        VelocidadDeTexto.escribirLento(ROJO + "Minuto " + i + " ROJA DIRECTA PARA EL " + equipoSeleccionado.getNombre() + " para el jugador " + jugadorClaveVisitante.getNombre() + " " + jugadorClaveVisitante.getApellido() + RESET,10);

                        if (jugadorClaveVisitante.getPosicion().equals(Posicion.PORTERO)){

                            jugadorClaveVisitante = jugadoresVisitante.get(jugadorRandom.nextInt(jugadoresVisitante.size()));

                            VelocidadDeTexto.escribirLento("En sustitución al portero expulsado ocupara su lugar en la porteria " + jugadorClaveVisitante.getNombre() + " "+ jugadorClaveVisitante.getApellido(),10);

                        }

                    }else{

                        VelocidadDeTexto.escribirLento("Minuto " + i,10);

                    }

                }else if (opcionesRoja<3 && opcionesRoja>=2) {

                    if (jugadorClaveVisitante.getTarjetasRojas()==0) {

                        jugadorClaveVisitante.setTarjetasRojas(1);
                        VelocidadDeTexto.escribirLento(ROJO + "Minuto " + i + " ROJA DIRECTA PARA EL " + partido.getEquipoLocal().getNombre() + " para el jugador " + jugadorClaveLocal.getNombre() + " " + jugadorClaveLocal.getApellido() + RESET,10);

                        if (jugadorClaveLocal.getPosicion().equals(Posicion.PORTERO)){

                            jugadorClaveLocal = jugadoresLocal.get(jugadorRandom.nextInt(jugadoresLocal.size()));

                            VelocidadDeTexto.escribirLento("En sustitución al portero expulsado ocupara su lugar en la porteria " + jugadorClaveLocal.getNombre() + " "+ jugadorClaveLocal.getApellido(),10);

                        }

                    }else{

                        VelocidadDeTexto.escribirLento("Minuto " + i,10);

                    }

                }else {

                    VelocidadDeTexto.escribirLento("Minuto " + i,10);

                }



            }

            VelocidadDeTexto.escribirLento ("\n\n" + partido.getEquipoLocal().getNombre() + " " + partido.getGolesLocal()+ " - " + partido.getGolesVisitante() + " " + equipoSeleccionado.getNombre(),100);

        }


    }

    public void partidoRapido(Partido partido, Equipo equipoSeleccionado, List<Jugador> jugadores){

        Random goles = new Random();

        if (equipoSeleccionado.equals(partido.getEquipoLocal())){

            int golesAFavor;
            int golesEnContra;
            List<Jugador> jugadoresLocal;
            List<Jugador> jugadoresVisitante;
            Random jugadorRandom = new Random();

            jugadoresLocal = new ArrayList<>(partido.getEquipoLocal().getPlantilla());
            jugadoresVisitante = new ArrayList<>(partido.getEquipoVisitante().getPlantilla());

            jugadoresLocal.removeIf(j -> j.getPosicion() == Posicion.PORTERO);
            jugadoresVisitante.removeIf(j -> j.getPosicion() == Posicion.PORTERO);

            if (jugadoresLocal.isEmpty()){

                jugadoresLocal = new ArrayList<>(partido.getEquipoLocal().getPlantilla());

            }
            if (jugadoresVisitante.isEmpty()){

                jugadoresVisitante = new ArrayList<>(partido.getEquipoVisitante().getPlantilla());

            }

            if (partido.getEquipoLocal().getMedia() > partido.getEquipoVisitante().getMedia()){

                golesAFavor = goles.nextInt(6);
                golesEnContra = goles.nextInt(3);

                for (int i = 0; i < golesAFavor ; i++){

                    List<Jugador> jugadoresGoleadores = new ArrayList<>();
                    for (Jugador j : jugadoresLocal) {
                        int probabilidadGol = 1;
                        if (j.getPosicion().equals(Posicion.DELANTERO)){

                            probabilidadGol = 4;

                        }
                        else if (j.getPosicion().equals(Posicion.CENTRO_CAMPISTA)){

                            probabilidadGol = 2;

                        }
                        for (int k = 0; k < probabilidadGol; k++){

                            jugadoresGoleadores.add(j);
                        }
                    }
                    if (jugadoresGoleadores.isEmpty()) {
                        jugadoresGoleadores.addAll(jugadoresLocal);
                    }
                    Jugador jugadorClaveLocal = jugadoresGoleadores.get(jugadorRandom.nextInt(jugadoresGoleadores.size()));


                    jugadorClaveLocal.setGoles(1 + jugadorClaveLocal.getGoles());

                }

                for (int i=0; i<golesEnContra;i++){

                    List<Jugador> jugadoresGoleadores = new ArrayList<>();
                    for (Jugador j : jugadoresVisitante) {
                        int probabilidadGol = 1;
                        if (j.getPosicion().equals(Posicion.DELANTERO)){

                            probabilidadGol = 4;

                        }
                        else if (j.getPosicion().equals(Posicion.CENTRO_CAMPISTA)){

                            probabilidadGol = 2;

                        }
                        for (int k = 0; k < probabilidadGol; k++){

                            jugadoresGoleadores.add(j);
                        }
                    }
                    if (jugadoresGoleadores.isEmpty()) {
                        jugadoresGoleadores.addAll(jugadoresVisitante);
                    }
                    Jugador jugadorClaveVisitante = jugadoresGoleadores.get(jugadorRandom.nextInt(jugadoresGoleadores.size()));

                    jugadorClaveVisitante.setGoles(1 + jugadorClaveVisitante.getGoles());

                }


                partido.getEquipoLocal().setGolesFavor(golesAFavor + partido.getEquipoLocal().getGolesFavor());
                partido.getEquipoLocal().setGolesContra(golesEnContra +  partido.getEquipoLocal().getGolesContra());
                partido.getEquipoVisitante().setGolesFavor(golesEnContra + partido.getEquipoVisitante().getGolesFavor());
                partido.getEquipoVisitante().setGolesContra(golesAFavor + partido.getEquipoVisitante().getGolesContra());
                partido.setGolesLocal(golesAFavor);
                partido.setGolesVisitante(golesEnContra);

            }else if (partido.getEquipoLocal().getMedia() == partido.getEquipoVisitante().getMedia()){

                golesAFavor = goles.nextInt(6);
                golesEnContra = goles.nextInt(4);



                for (int i = 0; i < golesAFavor ; i++){

                    List<Jugador> jugadoresGoleadores = new ArrayList<>();
                    for (Jugador j : jugadoresLocal) {
                        int probabilidadGol = 1;
                        if (j.getPosicion().equals(Posicion.DELANTERO)){

                            probabilidadGol = 4;

                        }
                        else if (j.getPosicion().equals(Posicion.CENTRO_CAMPISTA)){

                            probabilidadGol = 2;

                        }
                        for (int k = 0; k < probabilidadGol; k++){

                            jugadoresGoleadores.add(j);
                        }
                    }
                    if (jugadoresGoleadores.isEmpty()) {
                        jugadoresGoleadores.addAll(jugadoresLocal);
                    }
                    Jugador jugadorClaveLocal = jugadoresGoleadores.get(jugadorRandom.nextInt(jugadoresGoleadores.size()));


                    jugadorClaveLocal.setGoles(1 + jugadorClaveLocal.getGoles());

                }

                for (int i=0; i<golesEnContra;i++){

                    List<Jugador> jugadoresGoleadores = new ArrayList<>();
                    for (Jugador j : jugadoresVisitante) {
                        int probabilidadGol = 1;
                        if (j.getPosicion().equals(Posicion.DELANTERO)){

                            probabilidadGol = 4;

                        }
                        else if (j.getPosicion().equals(Posicion.CENTRO_CAMPISTA)){

                            probabilidadGol = 2;

                        }
                        for (int k = 0; k < probabilidadGol; k++){

                            jugadoresGoleadores.add(j);
                        }
                    }
                    if (jugadoresGoleadores.isEmpty()) {
                        jugadoresGoleadores.addAll(jugadoresVisitante);
                    }
                    Jugador jugadorClaveVisitante = jugadoresGoleadores.get(jugadorRandom.nextInt(jugadoresGoleadores.size()));

                    jugadorClaveVisitante.setGoles(1 + jugadorClaveVisitante.getGoles());

                }

                partido.getEquipoLocal().setGolesFavor(golesAFavor + partido.getEquipoLocal().getGolesFavor());
                partido.getEquipoLocal().setGolesContra(golesEnContra +  partido.getEquipoLocal().getGolesContra());
                partido.getEquipoVisitante().setGolesFavor(golesEnContra + partido.getEquipoVisitante().getGolesFavor());
                partido.getEquipoVisitante().setGolesContra(golesAFavor + partido.getEquipoVisitante().getGolesContra());
                partido.setGolesLocal(golesAFavor);
                partido.setGolesVisitante(golesEnContra);

            }else {

                golesAFavor = goles.nextInt(4);
                golesEnContra = goles.nextInt(4);

                for (int i = 0; i < golesAFavor ; i++){

                    List<Jugador> posibilidadAumentadaLocal = new ArrayList<>();
                    for (Jugador j : jugadoresLocal) {

                        int probabilidad = 1;
                        if (j.getPosicion().equals(Posicion.DELANTERO)) probabilidad = 4;
                        else if (j.getPosicion().equals(Posicion.CENTRO_CAMPISTA)) probabilidad = 2;
                        for (int k = 0; k < probabilidad; k++) posibilidadAumentadaLocal.add(j);

                    }
                    if (posibilidadAumentadaLocal.isEmpty()) {
                        posibilidadAumentadaLocal.addAll(jugadoresLocal);
                    }
                    Jugador jugadorClaveLocal = posibilidadAumentadaLocal.get(jugadorRandom.nextInt(posibilidadAumentadaLocal.size()));

                    jugadorClaveLocal.setGoles(1 + jugadorClaveLocal.getGoles());

                }

                for (int i=0; i<golesEnContra;i++){

                    List<Jugador> posibilidadAumentadaVisitante = new ArrayList<>();
                    for (Jugador j : jugadoresVisitante) {

                        int probabilidad = 1;
                        if (j.getPosicion().equals(Posicion.DELANTERO)) probabilidad = 4;
                        else if (j.getPosicion().equals(Posicion.CENTRO_CAMPISTA)) probabilidad = 2;
                        for (int k = 0; k < probabilidad; k++) posibilidadAumentadaVisitante.add(j);

                    }
                    if (posibilidadAumentadaVisitante.isEmpty()) {
                        posibilidadAumentadaVisitante.addAll(jugadoresVisitante);
                    }
                    Jugador jugadorClaveVisitante = posibilidadAumentadaVisitante.get(jugadorRandom.nextInt(posibilidadAumentadaVisitante.size()));


                    jugadorClaveVisitante.setGoles(1 + jugadorClaveVisitante.getGoles());

                }

                partido.getEquipoLocal().setGolesFavor(golesAFavor + partido.getEquipoLocal().getGolesFavor());
                partido.getEquipoLocal().setGolesContra(golesEnContra +  partido.getEquipoLocal().getGolesContra());
                partido.getEquipoVisitante().setGolesFavor(golesEnContra + partido.getEquipoVisitante().getGolesFavor());
                partido.getEquipoVisitante().setGolesContra(golesAFavor + partido.getEquipoVisitante().getGolesContra());
                partido.setGolesLocal(golesAFavor);
                partido.setGolesVisitante(golesEnContra);

            }


            System.out.println("\n\n" + equipoSeleccionado.getNombre() + " " + golesAFavor + " - " + golesEnContra + " " + partido.getEquipoVisitante().getNombre());

            puntosPartido(partido, partido.getEquipoLocal(), partido.getEquipoVisitante());
            System.out.println("Tus puntos: " + equipoSeleccionado.getPuntos());

        }else{

            int golesAFavor;
            int golesEnContra;

            if (partido.getEquipoLocal().getMedia() > partido.getEquipoVisitante().getMedia()){

                golesAFavor = goles.nextInt(4);
                golesEnContra = goles.nextInt(4);

                List<Jugador> jugadoresLocal;
                List<Jugador> jugadoresVisitante;
                Random jugadorRandom = new Random();


                jugadoresLocal = new ArrayList<>(partido.getEquipoLocal().getPlantilla());
                jugadoresVisitante = new ArrayList<>(partido.getEquipoVisitante().getPlantilla());

                jugadoresLocal.removeIf(j -> j.getPosicion() == Posicion.PORTERO);
                jugadoresVisitante.removeIf(j -> j.getPosicion() == Posicion.PORTERO);

                if (jugadoresLocal.isEmpty()) jugadoresLocal = new ArrayList<>(partido.getEquipoLocal().getPlantilla());
                if (jugadoresVisitante.isEmpty()) jugadoresVisitante = new ArrayList<>(partido.getEquipoVisitante().getPlantilla());

                for (int i = 0; i < golesAFavor ; i++){

                    List<Jugador> posibilidadAumentadaLocal = new ArrayList<>();
                    for (Jugador j : jugadoresLocal) {

                        int probabilidad = 1;
                        if (j.getPosicion().equals(Posicion.DELANTERO)) probabilidad = 4;
                        else if (j.getPosicion().equals(Posicion.CENTRO_CAMPISTA)) probabilidad = 2;
                        for (int k = 0; k < probabilidad; k++) posibilidadAumentadaLocal.add(j);

                    }
                    if (posibilidadAumentadaLocal.isEmpty()) {
                        posibilidadAumentadaLocal.addAll(jugadoresLocal);
                    }
                    Jugador jugadorClaveLocal = posibilidadAumentadaLocal.get(jugadorRandom.nextInt(posibilidadAumentadaLocal.size()));

                    jugadorClaveLocal.setGoles(1 + jugadorClaveLocal.getGoles());

                }

                for (int i=0; i<golesEnContra;i++){

                    List<Jugador> posibilidadAumentadaVisitante = new ArrayList<>();
                    for (Jugador j : jugadoresVisitante) {

                        int probabilidad = 1;
                        if (j.getPosicion().equals(Posicion.DELANTERO)) probabilidad = 4;
                        else if (j.getPosicion().equals(Posicion.CENTRO_CAMPISTA)) probabilidad = 2;
                        for (int k = 0; k < probabilidad; k++) posibilidadAumentadaVisitante.add(j);

                    }
                    if (posibilidadAumentadaVisitante.isEmpty()) {
                        posibilidadAumentadaVisitante.addAll(jugadoresVisitante);
                    }
                    Jugador jugadorClaveVisitante = posibilidadAumentadaVisitante.get(jugadorRandom.nextInt(posibilidadAumentadaVisitante.size()));

                    jugadorClaveVisitante.setGoles(1 + jugadorClaveVisitante.getGoles());

                }

                partido.getEquipoLocal().setGolesFavor(golesAFavor + partido.getEquipoLocal().getGolesFavor());
                partido.getEquipoLocal().setGolesContra(golesEnContra +  partido.getEquipoLocal().getGolesContra());
                partido.getEquipoVisitante().setGolesFavor(golesEnContra + partido.getEquipoVisitante().getGolesFavor());
                partido.getEquipoVisitante().setGolesContra(golesAFavor + partido.getEquipoVisitante().getGolesContra());
                partido.setGolesLocal(golesAFavor);
                partido.setGolesVisitante(golesEnContra);

            }else if (partido.getEquipoLocal().getMedia() == partido.getEquipoVisitante().getMedia()){

                golesAFavor = goles.nextInt(4);
                golesEnContra = goles.nextInt(5);

                List<Jugador> jugadoresLocal = new ArrayList<>(jugadores);
                List<Jugador> jugadoresVisitante = new ArrayList<>(jugadores);
                Random jugadorRandom = new Random();
                jugadoresLocal = partido.getEquipoLocal().getPlantilla();
                jugadoresVisitante = partido.getEquipoVisitante().getPlantilla();

                jugadoresLocal.removeIf(j -> j.getPosicion() == Posicion.PORTERO);
                jugadoresVisitante.removeIf(j -> j.getPosicion() == Posicion.PORTERO);

                if (jugadoresLocal.isEmpty()){

                    jugadoresLocal = new ArrayList<>(partido.getEquipoLocal().getPlantilla());

                }
                if (jugadoresVisitante.isEmpty()){

                    jugadoresVisitante = new ArrayList<>(partido.getEquipoVisitante().getPlantilla());

                }

                for (int i = 0; i < golesAFavor ; i++){

                    List<Jugador> posibilidadAumentadaLocal = new ArrayList<>();
                    for (Jugador j : jugadoresLocal) {

                        int probabilidad = 1;
                        if (j.getPosicion().equals(Posicion.DELANTERO)) probabilidad = 4;
                        else if (j.getPosicion().equals(Posicion.CENTRO_CAMPISTA)) probabilidad = 2;
                        for (int k = 0; k < probabilidad; k++) posibilidadAumentadaLocal.add(j);

                    }
                    if (posibilidadAumentadaLocal.isEmpty()) {
                        posibilidadAumentadaLocal.addAll(jugadoresLocal);
                    }
                    Jugador jugadorClaveLocal = posibilidadAumentadaLocal.get(jugadorRandom.nextInt(posibilidadAumentadaLocal.size()));


                    jugadorClaveLocal.setGoles(1 + jugadorClaveLocal.getGoles());

                }

                for (int i=0; i<golesEnContra;i++){

                    List<Jugador> posibilidadAumentadaVisitante = new ArrayList<>();
                    for (Jugador j : jugadoresVisitante) {

                        int probabilidad = 1;
                        if (j.getPosicion().equals(Posicion.DELANTERO)) probabilidad = 4;
                        else if (j.getPosicion().equals(Posicion.CENTRO_CAMPISTA)) probabilidad = 2;
                        for (int k = 0; k < probabilidad; k++) posibilidadAumentadaVisitante.add(j);

                    }
                    if (posibilidadAumentadaVisitante.isEmpty()) {
                        posibilidadAumentadaVisitante.addAll(jugadoresVisitante);
                    }
                    Jugador jugadorClaveVisitante = posibilidadAumentadaVisitante.get(jugadorRandom.nextInt(posibilidadAumentadaVisitante.size()));

                    jugadorClaveVisitante.setGoles(1 + jugadorClaveVisitante.getGoles());

                }

                partido.getEquipoLocal().setGolesFavor(golesAFavor + partido.getEquipoLocal().getGolesFavor());
                partido.getEquipoLocal().setGolesContra(golesEnContra +  partido.getEquipoLocal().getGolesContra());
                partido.getEquipoVisitante().setGolesFavor(golesEnContra + partido.getEquipoVisitante().getGolesFavor());
                partido.getEquipoVisitante().setGolesContra(golesAFavor + partido.getEquipoVisitante().getGolesContra());
                partido.setGolesLocal(golesAFavor);
                partido.setGolesVisitante(golesEnContra);

            }else {

                golesAFavor = goles.nextInt(3);
                golesEnContra = goles.nextInt(5);

                List<Jugador> jugadoresLocal = new ArrayList<>(jugadores);
                List<Jugador> jugadoresVisitante = new ArrayList<>(jugadores);
                Random jugadorRandom = new Random();
                jugadoresLocal = new ArrayList<>(partido.getEquipoLocal().getPlantilla());
                jugadoresVisitante = new ArrayList<>(partido.getEquipoVisitante().getPlantilla());

                jugadoresLocal.removeIf(j -> j.getPosicion() == Posicion.PORTERO);
                jugadoresVisitante.removeIf(j -> j.getPosicion() == Posicion.PORTERO);

                if (jugadoresLocal.isEmpty()) jugadoresLocal = new ArrayList<>(partido.getEquipoLocal().getPlantilla());
                if (jugadoresVisitante.isEmpty()) jugadoresVisitante = new ArrayList<>(partido.getEquipoVisitante().getPlantilla());

                for (int i = 0; i < golesAFavor ; i++){

                    List<Jugador> posibilidadAumentadaLocal = new ArrayList<>();
                    for (Jugador j : jugadoresLocal) {

                        int probabilidad = 1;
                        if (j.getPosicion().equals(Posicion.DELANTERO)) probabilidad = 4;
                        else if (j.getPosicion().equals(Posicion.CENTRO_CAMPISTA)) probabilidad = 2;
                        for (int k = 0; k < probabilidad; k++) posibilidadAumentadaLocal.add(j);

                    }
                    if (posibilidadAumentadaLocal.isEmpty()) {
                        posibilidadAumentadaLocal.addAll(jugadoresLocal);
                    }
                    Jugador jugadorClaveLocal = posibilidadAumentadaLocal.get(jugadorRandom.nextInt(posibilidadAumentadaLocal.size()));


                    jugadorClaveLocal.setGoles(1 + jugadorClaveLocal.getGoles());

                }

                for (int i=0; i<golesEnContra;i++){

                    List<Jugador> posibilidadAumentadaVisitante = new ArrayList<>();
                    for (Jugador j : jugadoresVisitante) {

                        int probabilidad = 1;
                        if (j.getPosicion().equals(Posicion.DELANTERO)) probabilidad = 4;
                        else if (j.getPosicion().equals(Posicion.CENTRO_CAMPISTA)) probabilidad = 2;
                        for (int k = 0; k < probabilidad; k++) posibilidadAumentadaVisitante.add(j);

                    }
                    if (posibilidadAumentadaVisitante.isEmpty()) {
                        posibilidadAumentadaVisitante.addAll(jugadoresVisitante);
                    }
                    Jugador jugadorClaveVisitante = posibilidadAumentadaVisitante.get(jugadorRandom.nextInt(posibilidadAumentadaVisitante.size()));

                    jugadorClaveVisitante.setGoles(1 + jugadorClaveVisitante.getGoles());

                }

                partido.getEquipoLocal().setGolesFavor(golesAFavor + partido.getEquipoLocal().getGolesFavor());
                partido.getEquipoLocal().setGolesContra(golesEnContra +  partido.getEquipoLocal().getGolesContra());
                partido.getEquipoVisitante().setGolesFavor(golesEnContra + partido.getEquipoVisitante().getGolesFavor());
                partido.getEquipoVisitante().setGolesContra(golesAFavor + partido.getEquipoVisitante().getGolesContra());
                partido.setGolesLocal(golesAFavor);
                partido.setGolesVisitante(golesEnContra);

            }

            System.out.println("\n\n" + partido.getEquipoLocal().getNombre() + " " + golesAFavor + " - " + golesEnContra + " " + equipoSeleccionado.getNombre());

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