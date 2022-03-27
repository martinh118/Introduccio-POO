package Server.model;

import java.io.Serializable;

public class Numero implements Serializable {

    int num;


    //Constructor
    public Numero(int _num){
        num = _num;
    }

    //Setter
    public void setNumero(int _num){
        num = _num;

    }

    //Getter
    public int getNumero(){return num;}

}
