package proyectoLiga.velocidadDeTexto;

public class VelocidadDeTexto {
    public static void escribirLento(String texto, int velocidad) {
        for (char c : texto.toCharArray()) {
            System.out.print(c);
            System.out.flush();
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    public static void pausar(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {}
    }
}
