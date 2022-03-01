package EJ1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TresEnRaya jugar = new TresEnRaya();
        int p1, p2, cont = 0;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println(jugar.toString());
            System.out.println("Inicia X");
            System.out.print("P1: ");
            p1 = scan.nextInt();
            System.out.print("P2: ");
            p2 = scan.nextInt();
            jugar.jugadaJ1(p1,p2);
            if (!jugar.ganador()){
                System.out.println("Inicia O");
                System.out.print("P1: ");
                p1 = scan.nextInt();
                System.out.print("P2: ");
                p2 = scan.nextInt();
                jugar.jugadaJ2(p1,p2);
            }
            cont++;
        }while (!jugar.ganador() && cont != 9);
        jugar.ganador();
    }


}
