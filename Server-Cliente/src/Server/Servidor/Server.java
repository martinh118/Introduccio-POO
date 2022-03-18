package Server.Servidor;

import Server.model.Missatge;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server{



    public static void main(String[] args) {

        final int port = 5000;
        ServerSocket Server;
        ObjectInputStream in;
        ObjectOutputStream out;

        Missatge m2 = new Missatge("Hola que tal - Servidor");

        try{
            //Conecta el servidor en otro servidor conocido.
            Socket s = new Socket("www.google.com", 80);
            //Obtener direccion IP del servidor.
            String ServerIP = s.getLocalAddress().getHostAddress();
            s.close();


            Server = new ServerSocket(port);
            System.out.println("Server started at " + "\u001b[32m" + ServerIP + ":" + port);

            //Siempre estara escuchando peticiones
            while(true){
                //Espero a que un cliente se conecte
                s = Server.accept();

                System.out.println("Cliente conectado");
                //Obtener datos enviados por el cliente
                in = new ObjectInputStream(new BufferedInputStream(s.getInputStream()));

                //Leo el mensaje que me envia
                Missatge mensCliente = (Missatge)in.readObject();
                System.out.println(mensCliente.getTexto());

                //Le envio un mensaje
                out = new ObjectOutputStream(s.getOutputStream());
                out.writeObject(m2);


                //Cierro el socket
                s.close();
                System.out.println("Cliente desconectado");

            }


        }  catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
