package proyectoLiga.liga;

import proyectoLiga.partidos.Partido;
import proyectoLiga.personas.Jugador;
import proyectoLiga.programas.Errores;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static proyectoLiga.liga.Clasificacion.mostrarClasificacionSoloPuntos;
import static proyectoLiga.programas.Menu.elegirEquipo;

public class Liga {

    private String pais;
    private List<Equipo> equipos;
    private List<Partido> partidos;
    private List<Jugador> jugadores;
    private int jornadaActual;

    static Errores errores = new Errores();
    Jornada jornada = new Jornada();
    static Partido partido =  new Partido();
    Equipo equipo = new Equipo();
    static Jugador jugador = new Jugador();
    static Clasificacion clasificacion = new Clasificacion();
    static Scanner sc = new Scanner(System.in);

    public Liga() {}
    public Liga(String pais, List<Equipo> equipos, List<Jugador> jugadores, List<Partido> partidos) {

        this.pais = pais;
        this.equipos = equipos;
        this.jugadores = jugadores;
        this.partidos = partidos;

    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public int getJornadaActual() {
        return jornadaActual;
    }

    public void setJornadaActual(int jornadaActual) {
        this.jornadaActual = jornadaActual;
    }

    public static void jugarLiga(Liga liga) {


        liga.partidos.clear();
        int opciones;
        Equipo equipo = null;
        Equipo equipoSeleccionado = null;

        System.out.println("Elige un equipo: ");
        for (int i = 0; i < liga.equipos.size(); i++) {


            System.out.println((i + 1) + ". " + liga.equipos.get(i).getNombre());

        }

        opciones = errores.numeroEntero(sc);

        if (opciones <21 && opciones > 0){
            equipoSeleccionado = elegirEquipo(opciones - 1, liga.equipos, equipo);
            System.out.println("\n\n\nHas elegido al " + equipoSeleccionado.getNombre() + " para ser su entrenador esta temporada, prepárate para darlo todo este año.\n\n");
        }else {
            System.out.println("Elige el número de un equipo válido");
        }

        for (int i = 0; i<38; i++){

            Partido partidoJornada = Jornada.mostrarJornadaSinRepetir(liga.equipos, equipoSeleccionado,liga.partidos, (i));

            liga.partidos.add(partidoJornada);

            do {

                System.out.println("\n\n1. Ver Siguiente Partido");
                System.out.println("2. Simular Partido");
                System.out.println("3. Simular Partido Rápido");
                System.out.println("4. Ver Clasificación");
                opciones = errores.numeroEntero(sc);

                switch (opciones){

                    case 1:

                        System.out.println("\n\nJORNADA " + (i+1));
                        System.out.println(partidoJornada.getEquipoLocal().getNombre() + " - " + partidoJornada.getEquipoVisitante().getNombre() + "\nEstadio: "+partidoJornada.getEquipoLocal().getEstadio().getNombre());

                        break;

                    case 2:

                        Partido.simularPartido(partidoJornada,liga.jugadores,equipoSeleccionado);
                        clasificacion.puntosResto(liga.equipos, partidoJornada, liga.jugadores);
                        Partido.puntosPartido(partidoJornada,partidoJornada.getEquipoLocal(),partidoJornada.getEquipoVisitante());
                        System.out.println("Tus puntos: " + equipoSeleccionado.getPuntos());

                        break;

                    case 3:

                        partido.partidoRapido(partidoJornada, equipoSeleccionado, liga.jugadores);
                        clasificacion.puntosResto(liga.equipos, partidoJornada, liga.jugadores);


                        break;

                    case 4:

                        mostrarClasificacionSoloPuntos(liga.equipos);

                        break;

                    default:
                        System.out.println("Juega un partido para pasar de Jornada");
                        break;



                }

            }while(opciones != 2 && opciones != 3);

        }

        mostrarClasificacionSoloPuntos(liga.equipos);
        System.out.println("\n\nPremios:");
        System.out.println("Pichichi: " + Jugador.pichichi(liga.equipos).getNombre() + " " + Jugador.pichichi(liga.equipos).getApellido() + " del " + Jugador.pichichi(liga.equipos).getEquipo().getNombre() + " con " + Jugador.pichichi(liga.equipos).getGoles() + " goles");
        System.out.println("Zarra: " + Jugador.zarra(liga, liga.equipos).getNombre() + " " + Jugador.zarra(liga, liga.equipos).getApellido() + " del " + Jugador.zarra(liga, liga.equipos).getEquipo().getNombre() + " con " + Jugador.zarra(liga, liga.equipos).getGoles() + " goles");

        Jugador.resetearJugadores(liga.jugadores);
        Equipo.resetearTodo(liga.equipos);

    }

    @Override
    public String toString() {
        return "pais='" + pais + '\'' +
                ", equipos=" + equipos +
                ", jugadores=" + jugadores +
                ", jornadaActual=" + jornadaActual +
                ", partidos=" + partidos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Liga liga = (Liga) o;
        return Objects.equals(pais, liga.pais);
    }

}
