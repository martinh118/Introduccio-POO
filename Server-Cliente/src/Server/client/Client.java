package Server.client;

import Server.model.Missatge;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {

        //Host del servidor
        final String HOST = "10.94.254.12";
        //Puerto del servidor
        final int PUERTO = 5000;
        ObjectInputStream in;
        ObjectOutputStream out;

        Missatge m1 = new Missatge("Hola que tal - Cliente");

        try {
            //Creo el socket para conectarme con el servidor
            Socket sc = new Socket(HOST, PUERTO);

            //Envio un mensaje al cliente
            out = new ObjectOutputStream(sc.getOutputStream());
            out.writeObject(m1);

            //Recibo el mensaje del servidor
            in = new ObjectInputStream(new BufferedInputStream(sc.getInputStream()));
            Missatge mensServer = (Missatge)in.readObject();
            System.out.println(mensServer.getTexto());

            sc.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}