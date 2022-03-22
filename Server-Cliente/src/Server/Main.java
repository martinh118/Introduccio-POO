package Server;


public class Main {
    static char[][] tauler = new char[6][6];
    static char[][] taulerActualitzat;
    static void mostrarTabla(char [][] taula){
        int c = 1;

        System.out.print("  ");
        for(int n = 1;n  < tauler[0].length - 1; ++n) {
            System.out.printf("%-3d", n );


        }
        System.out.println();

        System.out.print("  ");


        for(int i = 1; i < tauler.length - 1; ++i) {
            for(int j = 1; j < tauler[0].length - 1; ++j) {
                // Lletres
                tauler[i][j] = '.';
                System.out.print(tauler[i][j]  + "  ");
            }
            System.out.println();

            if(i < tauler.length - 2) {
                System.out.print("  ");
            }
        }
    }


    public static void main(String[] args) {
	mostrarTabla(tauler);
    }


}
