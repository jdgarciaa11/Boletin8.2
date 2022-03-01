package EJ1;

import java.util.Scanner;

public class TableroEspe {
        static final Character CIRCULO = 'O';
        static final Character CRUZ = 'X';
        static final Character VACIO = ' ';
        static final String JUGADOR1 = "JUGADOR 1";
        static final String JUGADOR2 = "JUGADOR 2";
        static final String FILA = "Fila";
        static final String COLUMNA = "Columna";
        static final String DIAGONAL = "DIAGONAL";
        static char nulo;
        static Scanner scanner = new Scanner(System.in);

        private char[][] tablero = new char[3][3];
        private boolean jugador = true;//true es el jugador1 y false el jugador2

        public TableroEspe() {//el constructor limpia el tablero y da el turno al primer jugador
            // limpiarTablero(tablero);
            jugador = true;

        }

        public boolean isJugador() {//getter del booleano JUgador
            return jugador;
        }

        public void setJugador(boolean jugador) {
            this.jugador = jugador;
        }

        public void limpiarTablero(Character[][] tablero) {
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[0].length; j++) {
                    tablero[i][j] = VACIO;
                }
            }
        }

        public void mostrar() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("el estado actual del tablero es el siguiente:\n");
            stringBuilder.append("   1 2 3 \n");
            for (int i = 0; i < tablero.length; i++) {
                stringBuilder.append(" "+ (i+1)+ " ");
                for (int j = 0; j < tablero[0].length; j++) {
                    stringBuilder.append(this.tablero[i][j] + " ");
                }
                stringBuilder.append("\n");
            }
            System.out.println(stringBuilder);
        }

        /**
         * en este método se le avisa al jugador que tiene que mover
         *
         * @param jugador
        public void avisaAJugador(boolean jugador) {
        }*/

        /**
         * se le pide al jugador que toque que introduzca un dato válido de fila y comlumna
         *
         * @param jugador
         */
        public void mueveJugador(boolean jugador) {
            boolean tiradaValida = false;//servirá para ver si el jugador  ha seleccionado una celda ya ocupada
            String filaColumna = ""; //valdra Fila o Columna para no repetir código
            int fila = 0, columna = 0;
            if (jugador) {
                System.out.println("Es el turno del " + JUGADOR1);
            } else {
                System.out.println("Es el turno del " + JUGADOR2);
            }
            while (!tiradaValida) {
                filaColumna = FILA;//fila
                fila = pedirDato(filaColumna);//se pide la fila
                filaColumna = COLUMNA;//columna
                columna = pedirDato(filaColumna);//se pide la columna
                if (this.tablero[fila-1][columna-1] == nulo) {//no han tirado a una posición ya ocupada
                    tiradaValida = true;
                } else {
                    System.out.println("Esa celda ya está ocupada");
                    mostrar();
                }
            }
            if (jugador) {
                this.tablero[fila-1][columna-1] = CIRCULO;
            } else {
                this.tablero[fila-1][columna-1] = CRUZ;
            }
        }


        private int pedirDato(String filaColumna) {
            boolean valida = false;
            int tirada = 0;
            while (!valida) {
                System.out.println("indique la " + filaColumna + ", valores válidos 1,2 y 3");
                try {
                    tirada = scanner.nextInt();
                    if (tirada < 1 || tirada > 3) {
                        System.out.println("introduzca valores válidos de la " + filaColumna + " entre 1 y 3");
                    } else {
                        valida = true;
                    }
                } catch (Exception e) {
                    System.out.println("introduzca valores válidos de la " + filaColumna + " entre 1 y 3");
                    scanner.nextLine();
                }

            }
            return tirada;
        }

        public boolean comprobarSiGanador(boolean jugador) {
            boolean ganador = false;
            ganador = recorre(jugador, FILA);
            if (!ganador) {
                ganador = recorre(jugador, COLUMNA);
                if (!ganador) {
                    ganador = recorre(jugador, DIAGONAL);
                }
            }
            return ganador;

        }


        /**
         * Recorro las filas, columnas y diagonales del tablero pero antes veo el carácter que tengo que buscar
         *
         * @param jugador
         * @return
         */
        private boolean recorre(boolean jugador, String filaColumnaDiagonal) {
            boolean encontradoTres = false;

            if (filaColumnaDiagonal == FILA) {// recorre la fila
                for (int i = 0; i < this.tablero.length && !encontradoTres; i++) {
                    if (this.tablero[i][0] != nulo &&
                            this.tablero[i][0] == this.tablero[i][1] &&
                            this.tablero[i][1] == this.tablero[i][2]) {
                        encontradoTres = true;
                    }
                }
            } else if (filaColumnaDiagonal == COLUMNA) {// recorre la columna
                for (int i = 0; i < this.tablero[0].length && !encontradoTres; i++) {
                    if (this.tablero[0][i] != nulo &&
                            this.tablero[0][i] == this.tablero[1][i] &&
                            this.tablero[1][i] == this.tablero[2][i]) {
                        encontradoTres = true;
                    }
                }
            }
            if (filaColumnaDiagonal == DIAGONAL) {// recorre la columna
                if (this.tablero[1][1] != nulo &&
                        this.tablero[0][0] == this.tablero[1][1] &&
                        this.tablero[1][1] == this.tablero[2][2]) {
                    encontradoTres = true;
                } else {
                    if (this.tablero[2][0] != nulo &&
                            this.tablero[2][0] == this.tablero[1][1] &&
                            this.tablero[1][1] == this.tablero[0][2]) {
                        encontradoTres = true;
                    }
                }
            }
            return encontradoTres;
        }

        public boolean comprobarSiLleno() {
            boolean lleno = true;
            for (int i = 0; i < this.tablero.length; i++) {
                for (int j = 0; j < this.tablero[0].length; j++) {
                    if (this.tablero[i][j] == nulo){
                        lleno = false;}
                }
            }
            return lleno;
        }

        public boolean compruebaEstadoJuego(boolean jugador) {
            boolean hayGanador = false, tableroLleno = false, finPartida = false;

            hayGanador = comprobarSiGanador(jugador);//se comprueba si con la última jugada hay algún ganador
            if (hayGanador) {
                ganador(jugador);//sacamos un mensaje de ganador
                finPartida = true;
            } else {             //si no hay ganador se comprueba si el tablero está lleno
                tableroLleno = comprobarSiLleno();//si no hay ganador se comprueba si el tablero ya está lleno
                if (tableroLleno) {
                    finPartida = true;
                    seHaLLenado();
                }else {//si no está lleno y no hay ganador, cambiamos al otro jugador
                    this.jugador = !jugador;
                    System.out.println("el tablero no está lleno, se puede seguir jugando");
                    mostrar();
                }
            }
            return finPartida;
        }

        public void ganador(boolean jugador) {
            StringBuilder stringBuilder = new StringBuilder();
            mostrar();
            stringBuilder.append("¡¡¡¡¡¡¡¡  Ya hay tres en raya !!!!!!!!!\n");
            stringBuilder.append("¡¡¡¡¡¡¡¡  EL GANADOR ES       !!!!!!!!!\n");
            stringBuilder.append("¡¡¡¡¡¡¡¡  EL JUGADOR........  !!!!!!!!!\n");
            if (jugador) {
                stringBuilder.append("¡¡¡¡¡¡¡¡  "+ JUGADOR1 + "!!!!!!!!!\n");
            } else {
                stringBuilder.append("¡¡¡¡¡¡¡¡  "+ JUGADOR2 + "!!!!!!!!!\n");
            }
            stringBuilder.append("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡!!!!!!!!!\n");
            System.out.println(stringBuilder);
        }
        public void seHaLLenado() {
            StringBuilder stringBuilder = new StringBuilder();
            mostrar();
            stringBuilder.append("¡¡¡¡¡¡¡¡  el tablero se ha llenado !!!!!!!!!\n");
            stringBuilder.append("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡!!!!!!!!!\n");
            System.out.println(stringBuilder);
        }
}
