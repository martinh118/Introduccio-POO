package Server.model;

import java.io.Serializable;

public class Missatge implements Serializable {

    String linea;


    //Constructor
    public Missatge(String _linea){
        linea = _linea;

    }

    //Setter
    public void setMissatge(String _linea){
        linea = _linea;

    }

    //Getter
    public String getTexto(){return linea;}

}
