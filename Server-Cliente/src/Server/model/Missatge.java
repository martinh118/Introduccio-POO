package Server.model;

import java.io.Serializable;

public class Missatge implements Serializable {

    int linea;


    //Constructor
    public Missatge(int _linea){
        linea = _linea;

    }

    //Setter
    public void setMissatge(int _linea){
        linea = _linea;

    }

    //Getter
    public int getTexto(){return linea;}

}
