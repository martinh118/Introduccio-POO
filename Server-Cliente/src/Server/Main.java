package Server;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static char[][] tauler = new char[9][9];

    public static void main(String[] args) {

        mostrarTabla();

        while(true){
            actualizarTablaX();
            buscarGanador();
            actualizarTabla0();
            buscarGanador();

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

    public static void actualizarTablaX(){
        int num = 0;
        fichaX(num);

        tablaActualizada();


    }

    public static void actualizarTabla0(){
        int num = 0;
        ficha0(num);

        tablaActualizada();


    }

    public static void fichaX(int num){
        num = 0;

        do{
            System.out.println("Elige una fila: X");
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
    }

    public static void ficha0(int num){
        num = 0;

        do{
            System.out.println("Elige una fila: 0");
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
            tauler[h][num] = '0';

        }
    }

    public static void tablaActualizada(){
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


    public static void buscarGanador(){

        comprobarVerticalX();
        comprobarVertical0();

        comprobarHorizontalX();

        int linea = 0;
/*

    for (int i = 1; i < tauler.length -1; i++) {
        for (int j = 1; j < tauler[0].length -1; j++) {


            int hor = i;
            int ver = j;
            linea = 0;

            //Comprobar linea horizontal
            hor = i;
            ver = j;
            linea = 0;
            while (tauler[hor+1][ver] == 'X') {
                linea++;
                hor++;
                if (linea == 4) {
                    System.out.println("4 en raya Vertical X");
                }
            }

            hor = i;
            ver = j;
            linea = 0;
            while (tauler[hor+1][ver] == '0') {
                linea++;
                hor++;
                if (linea == 4) {
                    System.out.println("4 en raya Vertical 0");
                }
            }


        }
    }
    */

    }


    static void comprobarVerticalX(){
        int linea = 0;

        for (int i = 1; i < tauler.length -1; i++) {
            for (int j = 1; j < tauler[0].length - 1; j++) {
                //Comprobar linea vertical de X (FUNCIONA)
                int hor = i;
                int ver = j;
                linea = 0;
                while (tauler[hor+1][ver] == 'X') {
                    linea++;
                    hor++;
                    if (linea == 4) {
                        System.out.println("4 en raya Vertical X");
                        System.exit(0);
                    }
                }
            }
        }

    }

    static void comprobarVertical0(){
        int linea = 0;


        for (int i = 1; i < tauler.length -1; i++) {
            for (int j = 1; j < tauler[0].length - 1; j++) {
                //Comprobar linea vertical de 0 (FUNCIONA)
                int hor = i;
                int ver = j;
                linea = 0;
                while (tauler[hor+1][ver] == '0') {
                    linea++;
                    hor++;
                    if (linea == 4) {
                        System.out.println("4 en raya Vertical 0");
                        System.exit(0);
                    }
                }


            }
        }

    }

    static void comprobarHorizontalX(){
        int linea = 0;


        for (int i = 0; i < tauler.length -1; i++) {
            for (int j = 0; j < tauler[0].length - 1; j++) {
                //Comprobar linea horizontal de X
                int hor = i;
                int ver = j;
                linea = 0;
                while (tauler[hor][ver + 1] == 'X') {
                    linea++;
                    hor++;
                    if (linea == 4) {
                        System.out.println("4 en raya Vertical X");
                        System.exit(0);
                    }
                }


            }
        }
    }

    }

