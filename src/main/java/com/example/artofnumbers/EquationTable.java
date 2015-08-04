package com.example.artofnumbers;

/**
 * Created by Peto-1 on 7/26/2015.
 */
public class EquationTable {

    int _id;
    int _position;
    float _floatrespuesta;

//    Constructores

    public EquationTable() {

    }

    public EquationTable(int id, int pos) {

        _id = id;
        _position = pos;

    }

    public EquationTable(int pos) {

        _position = pos;
    }

    public EquationTable(int id, float flotante) {

        _id = id;
        _floatrespuesta = flotante;

    }

    public EquationTable(float flotante) {

        _floatrespuesta = flotante;

    }

//    getters

    public int getID() {

        return _id;
    }

    public int getposition() {

        return _position;
    }

    public float getRespuestaEq() {

        return _floatrespuesta;

    }

//    setters

    public void setID(int id) {
        _id = id;
    }

    public void setPosition(int pos) {
        _position = pos;

    }

    public void setRespuestaEq(float resp) {
        _floatrespuesta = resp;

    }

}