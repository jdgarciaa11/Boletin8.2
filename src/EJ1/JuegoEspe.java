package EJ1;

import java.util.Scanner;

public class JuegoEspe {private static final char NO = 'n';
    private static final char SI = 's';
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        TableroEspe tablero = new TableroEspe();//creamos un tablero
        boolean jugar = pedirOpcion();//pedimos al usuario si quiere jugar o no
        boolean hayGanador = false, tableroLleno = false, finPartida = false;

        while (jugar) {//mientras quiera seguir jugando partidas
            tablero.mostrar();//mostramos el tablero
            while (!finPartida) {////mientras el tablero no esté lleno o no haya ningún ganador

                tablero.mueveJugador(tablero.isJugador());//avisa al jugador para que mueva y el jugador...
                //...mueve. Se valida que el movimiento sea válido y se modifica el tablero

                finPartida = tablero.compruebaEstadoJuego(tablero.isJugador());//se comprueba si ha finalizado la partida
                if (!finPartida) {
                    tablero.mueveJugador(tablero.isJugador());//avisa al otro jugador para que mueva
                    finPartida = tablero.compruebaEstadoJuego(tablero.isJugador());
                }
            }
            jugar = pedirOpcion();          //preguntamos  al usuario si quiere seguir jugando o no
            if (jugar) {                    //si quiere seguir jugando se limpiar el tablero
                tablero = new TableroEspe();
                finPartida=false;
            }
        }
        System.out.println("GAME OVER");
    }


    private static boolean pedirOpcion() {
        System.out.println("Desea Jugar al tres en raya?, diga Sí o No");
        boolean jugar = true, opcValida = false;
        char teclado;
        while (!opcValida) {
            try {
                teclado = Character.toLowerCase(sc.nextLine().charAt(0));
                if (teclado == NO) {
                    jugar = false;
                    opcValida = true;
                } else {
                    if (teclado == SI) {
                        opcValida = true;
                    } else {
                        System.out.println("introduzca Sí o No");
                    }
                }
            } catch (Exception e) {
                System.out.println("introduzca sí o no");
            }
        }
        return jugar;
    }
}
