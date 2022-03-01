package EJ4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static final int TAM_MINIMO = 2;
    public static final int TAM_MAXIMO = 10;

    public static void main(String[] args) {
        int tam;
        do {
            System.out.println("Introduce un tamaño: ");
            tam = validarDatosNumericos();
        } while (tam % 2 == 0 || tam <= TAM_MINIMO || tam >= TAM_MAXIMO && tam % 2 != 0);
        CuadradoMagico cuadrado = new CuadradoMagico(tam);
        cuadrado.imprimir();
    }

    private static int validarDatosNumericos() {
        Scanner scan = new Scanner(System.in);
        int numero = -1;
        try {
            numero = scan.nextInt();
            if (numero != 0) {
                if (numero <= TAM_MINIMO) {
                    System.err.println("ERROR! Dato numerico menor que 3");
                } else if (numero >= TAM_MAXIMO) {
                    System.err.println("ERROR! Dato numerico menor que 9");
                } else if (numero % 2 == 0) {
                    System.err.println("ERROR! Dato numerico no es impar");
                }
            }
        } catch (InputMismatchException e) {
            System.err.println("Dato introducido no numerico");
            scan.next();
        }
        return numero;
    }
}
