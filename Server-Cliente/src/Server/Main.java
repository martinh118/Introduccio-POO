package Server;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static char[][] tauler = new char[9][9];


    public static void main(String[] args) {
        mostrarTabla();
        while(true){
            actualizarTabla();
        }

    }

    public static void mostrarTabla(){

        System.out.print("  ");
        for(int n = 1;n  < tauler[0].length - 1; ++n) {
            System.out.printf("%-3d", n );

        }

        System.out.println();

        System.out.print("  ");


        for(int i = 1; i < tauler.length - 1; ++i) {
            for(int j = 1; j < tauler[0].length - 1; ++j) {
                // Tabla con puntos
                tauler[i][j] = '.';
                System.out.print(tauler[i][j]  + "  ");
            }
            System.out.println();

            if(i < tauler.length - 2) {
                System.out.print("  ");
            }
        }

    }

    public static void actualizarTabla(){
        int num = 0;

        do{
            System.out.println("Elige una fila");
            num = scan.nextInt();
        }while(num < 1 || num > 7);

        int h = 0;
        while(tauler[h+1][num] == '.'){
            ++h;
        }
        if(h == 0){
            System.out.println("Columna plena");
        }
        else{
            tauler[h][num] = 'X';

        }


        System.out.print("  ");
        for(int n = 1;n  < tauler[0].length - 1; ++n) {
            System.out.printf("%-3d", n );

        }
        System.out.println();

        System.out.print("  ");

        for(int i = 1; i < tauler.length - 1; ++i) {
            for(int j = 1; j < tauler[0].length - 1; ++j) {
                // Lletres
                System.out.print(tauler[i][j]  + "  ");
            }
            System.out.println();

            if(i < tauler.length - 2) {
                System.out.print("  ");
            }
        }

    }

}