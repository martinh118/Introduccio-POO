package Server.clients;

import Server.Main;
import Server.model.Missatge;
import Server.model.Numero;
import java.util.Scanner;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client_1 {

    static Scanner scan = new Scanner(System.in);

    //Host del servidor
    final static String HOST = "10.94.254.12";
    //Puerto del servidor
    final static int PUERTO = 5000;
    static ObjectInputStream in;
    static ObjectOutputStream out;

    public static void main(String[] args) throws IOException{


        conexionServer();
        Main.mostrarTabla();
        while(true){
            movimiento();
            Main.tablaActualizada();
        }

    }


    static void conexionServer(){
        try {
            //Creo el socket para conectarme con el servidor
            Socket sc = new Socket(HOST, PUERTO);

            //Envío un mensaje al cliente
            out = new ObjectOutputStream(sc.getOutputStream());

            //Recibo el mensaje del servidor
            in = new ObjectInputStream(new BufferedInputStream(sc.getInputStream()));

            Missatge mensServer = (Missatge)in.readObject();
            System.out.println(mensServer.getTexto());



        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void movimiento() throws IOException {
        try{
            Missatge mensServer = (Missatge)in.readObject();
            System.out.println(mensServer.getTexto());

            int num = scan.nextInt();
            Numero movimiento = new Numero(num);
            out.writeObject(movimiento);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
