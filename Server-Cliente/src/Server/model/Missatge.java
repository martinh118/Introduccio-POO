package Server.model;

import java.io.Serializable;

public class Missatge implements Serializable {

    String texto;


    //Constructor
    public Missatge(String _texto){
        texto = _texto;

    }

    //Setter
    public void setMissatge(String _texto){
        texto = _texto;

    }

    //Getter
    public String getTexto(){return texto;}

}
