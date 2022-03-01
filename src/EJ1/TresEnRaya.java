package EJ1;

import java.util.Arrays;
import java.util.Objects;

public class TresEnRaya {
    private String[][] juego;
    private static final int TAM = 3;

    public TresEnRaya() {
        this.juego = new String[][]{{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    }

    public void jugadaJ1(int p1, int p2) {
        if (this.juego[p1][p2] == " ") {
            this.juego[p1][p2] = "X";
        } else {
            System.out.println("Casilla ocupada, pierde el turno");
        }
        System.out.println(this);
    }

    public void jugadaJ2(int p1, int p2) {
        if (this.juego[p1][p2] == " ") {
            this.juego[p1][p2] = "O";
        } else {
            System.out.println("Casilla ocupada, pierde el turno");
        }
        System.out.println(this);
    }

    public boolean ganador() {
        boolean salir = false;
        if (this.juego[0][0] == "X" && this.juego[0][1] == "X" && this.juego[0][2] == "X" ||
                this.juego[0][0] == "X" && this.juego[1][1] == "X" && this.juego[2][2] == "X" ||
                this.juego[0][0] == "X" && this.juego[1][0] == "X" && this.juego[2][0] == "X") {
            System.out.println("Jugador 1 a ganado!");
            salir = true;
        } else if (this.juego[0][0] == "O" && this.juego[0][1] == "O" && this.juego[0][2] == "O" ||
                this.juego[0][0] == "O" && this.juego[1][1] == "O" && this.juego[2][2] == "O" ||
                this.juego[0][0] == "O" && this.juego[1][0] == "O" && this.juego[2][0] == "O") {
            System.out.println("Jugador 2 a ganado!");
            salir = true;
        } else {
            System.out.println("Ninguno ganando");
        }
        return salir;
    }


    @Override
    public String toString() {
        return "\t" + 0 + "\t" + 1 + "\t" + 2
                + "\n" + 0 + "\t" + this.juego[0][0] + "\t" + this.juego[0][1] + "\t" + this.juego[0][2]
                + "\n" + 1 + "\t" + this.juego[1][0] + "\t" + this.juego[1][1] + "\t" + this.juego[1][2]
                + "\n" + 2 + "\t" + this.juego[2][0] + "\t" + this.juego[2][1] + "\t" + this.juego[2][2];

    }
}
