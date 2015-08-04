package com.example.artofnumbers;

import android.content.Context;

/**
 * Created by Peto-1 on 7/19/2015.
 */

//ALERTA HE
public class EquationCalculadora extends MainActivity{

    public String raw1;


public EquationCalculadora(String lacarnita){

    raw1 = lacarnita;

}

    public String CalculaEcuacion(String raw){

        final DatabaseHand dbcerebro = new DatabaseHand(this);

        raw1 = raw;

        StringBuilder lacarne = new StringBuilder();
        char[] characterderaw1 = new char[raw1.length()];
        raw1.getChars(0, raw1.length(), characterderaw1, 0);
        int i;
        int contparenabier=0;
        int contparencerra=0;
        int contsuma = 0;
        int contresta = 0;
        int contmulti = 0;
        int contdivi = 0;

        for(i=0; i<characterderaw1.length; i++){

        switch (characterderaw1[i]){

            case '(':
        dbcerebro.addParenAbier(i);
        contparenabier = contparenabier+1;
                break;

            case ')':
                dbcerebro.addParenCerrado(i);
                contparencerra = contparencerra+1;
                break;

            case '+':
                dbcerebro.addSuma(i);
                contsuma = contsuma+1;
                break;

            case '-':
                dbcerebro.addResta(i);
                contresta = contresta+1;
                break;

            case '/':
                dbcerebro.addDivision(i);
                contdivi=contdivi+1;

                default:
        }

        }



    }


}
