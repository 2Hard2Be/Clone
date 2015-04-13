package com.example.artofnumbers;

/**
 * Created by Peto-1 on 4/12/2015.
 */
public class Respuestas {

    private long id;
    private String respuesta;

    public long getId(){
        return id;
    }

    public void setId(long id) {
     this.id = id;
    }

    public String getRespuesta(){
    return respuesta;
    }

    public void setRespuesta(String respuesta) {

        this.respuesta = respuesta;
    }

    @Override

    public String toString(){
      return respuesta;

    }
}
