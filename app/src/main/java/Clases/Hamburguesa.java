package Clases;

import java.io.Serializable;
import java.security.PrivateKey;

public class Hamburguesa implements Serializable { //Herada los rasgos publicos de una interfaz "Serializable"
                                                   //La interface solo hereda elementos poblicos  (Metodos y Atributos)

    //Atributos
    private String tipo;  //** tipo Local
    private boolean cebolla;

   //como son privados no los voy a poder acceder, entonces debo crear el constructor
    public Hamburguesa(String tipo, Boolean cebolla){      //Metodo que no retorna nada pero si va a recibir, cargar.
        this.tipo = tipo; // el this indica que es el tipo local **
        this.cebolla = cebolla;
    }

    public String getTipo() {
        return tipo;
    }
    public boolean  getCebolla(){
        return cebolla;
    }
}
