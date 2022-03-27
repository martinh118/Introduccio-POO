package Server.Servidor;

import Server.model.Missatge;
import Server.model.Numero;
import Server.Main;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {

    static ObjectInputStream in1;
    static ObjectOutputStream out1;
    static Socket s1;
    static String j1 = "X";

    static ObjectInputStream in2;
    static ObjectOutputStream out2;
    static Socket s2;
    static String j2 = "0";

    public static void main(String[] args) throws IOException {

        conexion();
        while(true){

            peticionJugador1();
            Main.buscarGanador();
            peticionJugador2();
            Main.buscarGanador();
        }
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

                //Espero a que un cliente se conecte
                s1 = Server.accept();
                //Obtener datos enviados por el cliente
                in1 = new ObjectInputStream(new BufferedInputStream(s1.getInputStream()));
                out1 = new ObjectOutputStream(s1.getOutputStream());
                System.out.println("Jugador 1 conectado (X)");
                Missatge jugador1 = new Missatge("Esperando a otro jugador...");
                out1.writeObject(jugador1);


                s2 = Server.accept();
                //Obtener datos enviados por el cliente
                in2 = new ObjectInputStream(new BufferedInputStream(s2.getInputStream()));
                out2 = new ObjectOutputStream(s2.getOutputStream());
                System.out.println("Jugador 2 conectado (0)");
                Missatge jugador2 = new Missatge("2 jugadores conectados.");
                out2.writeObject(jugador2);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void peticionJugador1() throws IOException {


        try {
            //Envio mensaje cliente 2
            String espera = "Es el turno del otro jugador.";
            Missatge waiting = new Missatge(espera);
            out2.writeObject(waiting);

            //Envio mensaje a cliente 1
            String mov = "¿En que columna quieres poner la ficha?";
            Missatge movimiento = new Missatge(mov);
            out1.writeObject(movimiento);

            //Leo el mensaje que me envía
            Numero mensCliente = (Numero) in1.readObject();
            System.out.println(mensCliente.getNumero());

            Main.fichaX(mensCliente.getNumero());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    static void peticionJugador2() throws IOException {


        try {
            //Envio mensaje a cliente 1
            String espera = "Es el turno del otro jugador.";
            Missatge waiting = new Missatge(espera);
            out1.writeObject(waiting);

            //Envio mensaje cliente 2
            String mov = "¿En que columna quieres poner la ficha?";
            Missatge movimiento = new Missatge(mov);
            out2.writeObject(movimiento);

            //Leo el mensaje que me envía
            Numero mensCliente = (Numero) in2.readObject();
            System.out.println(mensCliente.getNumero());

            Main.ficha0(mensCliente.getNumero());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
