package com.example.artofnumbers;

/**
 * Created by Peto-1 on 5/7/2015.
 */
public class PreguntaClass {

    //    Private variables

    int _id;
    String _fragen;

//    Constructores

    public PreguntaClass(){

    }

    public PreguntaClass(int id, String pregunta){

        _id=id;
        _fragen= pregunta;

    }

    public PreguntaClass(String pregunta){

        _fragen=pregunta;
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

    public String getPregunta(){

        return _fragen;
    }

// set the respuesta

    public void setPregunta(String pregunta){
        _fragen = pregunta;
    }
}
