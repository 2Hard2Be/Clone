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
        String respuesta=" ";
        int i;
        int ii;
        int contparenabier=0;
        int contparencerra=0;
        int contsuma = 0;
        int contresta = 0;
        int contmulti = 0;
        int contdivi = 0;
        int matadorciclorevision = 0;
        int posab = 0;
        int parencerrado=1;

        EquationTable ET = new EquationTable(0);

//        FOR PARA LLENAR LA TABLA ECUACION

        for(i=0; i<characterderaw1.length; i++){
         ET.setID(i);
        switch (characterderaw1[i]){

            case '(':
        dbcerebro.addParenAbier(i);
        contparenabier = contparenabier+1;
        posab = i;
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

            case '*':
                dbcerebro.addMultiplicacion(i);
                contmulti=contmulti+1;

                default:
                dbcerebro.addBlankRespeq(ET);
        }

        }

        matadorciclorevision = contparenabier;

//        IF DE REVISION QUE EXISTA UN NUMERO PAR DE PARENTESIS ABIERTOS Y CERRADOS

        if (contparenabier==contparencerra){

//        IF DE REVISION SI HAY PARENTESIS
            if (contparenabier>0){

//                CICLO WHILE PARA TERMINAR LOS PARENTESIS DE LA EXPRESION, EL MATADOR MANDA

                while (matadorciclorevision>0){

                posab = dbcerebro.getParenAbierMax();

//                    WHILE EN BUSCA DEL PARENTESIS CERRADO MAS CERCANO
                    while (parencerrado>1){
                        

                    }


                }

            }

//            ELSE DE QUE NO HAY PARENTESIS, SE DEBE TRATAR COMO UNA ECUACION NORMAL
            else {

            }

        }

//        EL ELSE DE LA REVISION DEL NUMERO DE PARENTESIS ABIERTOS Y CERRADOS
       else {

            respuesta = "Check the parenthesis one could be missing";
         }

        return respuesta;

    }

}
