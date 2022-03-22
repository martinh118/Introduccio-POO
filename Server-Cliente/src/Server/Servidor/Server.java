package Server.Servidor;

import Server.model.Missatge;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {

    static ObjectInputStream in1;
    static ObjectOutputStream out1;
    static Socket s1;

    static ObjectInputStream in2;
    static ObjectOutputStream out2;
    static Socket s2;

    public static void main(String[] args) throws IOException {

        conexion();
        //recibirMensaje1();




    }

    static void conexion() throws IOException {

        final int port = 5000;
        ServerSocket Server;

        //Conecta el servidor en otro servidor conocido.
        s1 = new Socket("www.google.com", 80);
        //Obtener direccion IP del servidor.
        String ServerIP = s1.getLocalAddress().getHostAddress();


        Server = new ServerSocket(port);
        System.out.println("Server started at " + "\u001b[32m" + ServerIP + ":" + port);

        try {
            //Estara escuchando hasta que se conecte un segundo cliente
            while (s1 != Server.accept()) {
                //Espero a que un cliente se conecte
                s1 = Server.accept();
                //Obtener datos enviados por el cliente
                in1 = new ObjectInputStream(new BufferedInputStream(s1.getInputStream()));
                out1 = new ObjectOutputStream(s1.getOutputStream());
                System.out.println("Jugador 1 conectado");
                out1.writeObject("Esperando a otro jugador...");
            }

            while (s2 != Server.accept()) {
                s2 = Server.accept();
                //Obtener datos enviados por el cliente
                in2 = new ObjectInputStream(new BufferedInputStream(s2.getInputStream()));
                out2 = new ObjectOutputStream(s2.getOutputStream());
                System.out.println("Jugador 2 conectado");
                out2.writeObject("2 jugadores conectados.");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void recibirMensaje1() throws IOException {


        try {
            //Leo el mensaje que me envia
            Missatge mensCliente = (Missatge) in1.readObject();
            System.out.println(mensCliente.getTexto());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    static void enviarMensaje(){



    }
    static void mostrarTabla(char [][] taula){
        

    }
}
