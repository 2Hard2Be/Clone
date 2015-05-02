package com.example.artofnumbers;

/**
 * Created by Peto-1 on 4/22/2015.
 */
public class RespuestaClass {

//    Private variables

    int _id;
    String _anwort;

//    Constructores

    public RespuestaClass(){

    }

    public RespuestaClass(int id, String respuesta){

        _id=id;
        _anwort= respuesta;

    }

    public RespuestaClass(String respuesta){

        _anwort=respuesta;
    }

//    get the id

    public int getID(){

        return _id;
    }

//    set the id

    public void setID(int id){
        _id=id;
    }

//    get the respuesta

    public String getRespuesta(){

        return _anwort;
    }

// set the respuesta

    public void setRespuesta(String respuesta){
        _anwort = respuesta;
    }

}
