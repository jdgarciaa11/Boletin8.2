package EJ4;

public class CuadradoMagico {
    private int[][] cuadrado;
    private int size;

    public CuadradoMagico() {
        this.size = 3;
        this.cuadrado = new int[size][size];
        generadorCuadrado();
    }

    public CuadradoMagico(int size) {
        this.size = size;
        this.cuadrado = new int[size][size];
        generadorCuadrado();
    }

    public void generadorCuadrado() {
        int fil = 0, col = size / 2;
        int filAnterior = 0, colAnterior = 0;
        this.cuadrado[fil][col] = 1;
        for (int i = 2; i <= (this.size * this.size); i++) {
            if (fil - 1 < 0) {
                fil = size - 1;
            } else {
                fil--;
            }
            if (col - 1 < 0) {
                col = size - 1;
            } else {
                col--;
            }
            if (this.cuadrado[fil][col] == 0) {
                this.cuadrado[fil][col] = i;
                filAnterior = fil;
                colAnterior = col;
            } else {
                fil = filAnterior + 1;
                col = colAnterior;
                this.cuadrado[fil][col] = i;
            }

        }
    }

    public void imprimir() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.print(this.cuadrado[i][j] + "\t");
            }
            System.out.println();

        }
    }
}


