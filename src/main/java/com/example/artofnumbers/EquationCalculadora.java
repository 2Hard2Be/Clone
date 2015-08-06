package com.example.artofnumbers;

import android.content.Context;

import java.util.List;
import java.util.Vector;

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


        StringBuilder paracalcular = new StringBuilder();
        String calcular;
        String respuestaintermedia;
        char[] characterderaw1 = new char[raw1.length()];
        raw1.getChars(0, raw1.length(), characterderaw1, 0);
        String respuesta=" ";
        Vector<Integer> contsimbolo = new Vector<Integer>();
        int i;
        int ii;
        int iii;
        int contparenabier=0;
        int contparencerra=0;
        int contsuma = 0;
        int contresta = 0;
        int contmulti = 0;
        int contdivi = 0;
        int matadorciclorevision = 0;
        int posab = 0;
        int poscer = 0;
        int poscerfinder = 0;
        int parencerrado=1;
        int a = 0;
        int b = 0;

        EquationTable ET = new EquationTable(0);

//        FOR PARA LLENAR LA TABLA ECUACION

        for(i=0; i<characterderaw1.length; i++){
         ET.setID(i);
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
                poscerfinder = posab+1;

//                    WHILE EN BUSCA DEL PARENTESIS CERRADO MAS CERCANO
                    while (parencerrado>0){
//                        IF DE COMPARACION DEL DATO EN VECTOR DE DATOS PARA VER SI ES PARENTESIS CERRADO
                        if(characterderaw1[poscerfinder]==')'){
                            poscer = poscerfinder;
                            parencerrado = parencerrado+1;
                        }
                      poscerfinder = poscerfinder+1;
                    }

                   a = posab+1;
                   b = poscer-1;

//                    IF DE REVISION SI LOS VALORES QUE SE ENCUENTRAN EN a Y b NO SON PARENTESIS

                    if (characterderaw1[a]!='('&& characterderaw1[a]!=')'
                            && characterderaw1[b]!=')'&& characterderaw1[b]!='('){

//                        FOR PARA ADJUNTAR LOS VALORES EN MEDIO DE PARENTESIS PARA CALCULARLOS
//                        DE UN SOLO LLENA EL VECTOR CONTSIMBOLO AUNQUE NO LO USEMOS DENTRO DE ESTE CASO
                        for (ii=a; ii<b; ii++){
                        paracalcular.append(characterderaw1[ii]).toString();
                            if (characterderaw1[ii]=='+'){
                                contsimbolo.add(ii);
                            }
                            if (characterderaw1[ii]=='-'){
                                contsimbolo.add(ii);
                            }
                            if (characterderaw1[ii]=='*'){
                                contsimbolo.add(ii);
                            }
                            if (characterderaw1[ii]=='/'){
                                contsimbolo.add(ii);
                            }


                        }

                     calcular = paracalcular.toString();
                        CalculadoraAdvanced calculadora= new CalculadoraAdvanced(calcular);
                     respuestaintermedia = calculadora.calculaAdvanced(calcular);
                     dbcerebro.addRespeqUpdated(respuestaintermedia,posab);




                    }

//                    ELSE DE REVISION SI LOS VALORES QUE SE ENCUENTRAN EN a Y b NO SON PARENTESIS
//                    AQUI ENTRARA AL ENCONTRAR PARENTESIS CON POSIBILIDAD DE SALIR DEL CICLO

                    else {

                    }

//                    BORRANDO LOS SIMOBOLOS ENTRE A Y B
                    dbcerebro.blankParenAbierto(posab);
                    dbcerebro.blankParenCerrado(poscer);

//                    FOR DE BORRADO DE SIMOBOLOS EN COLUMNAS DE SIMBOLOS ENTRE a Y b

                    for (iii=a; iii<b; iii++){

                       if (characterderaw1[iii]=='+'){
                           dbcerebro.blankSuma(iii);
                       }
                        if (characterderaw1[iii]=='-'){
                            dbcerebro.blankResta(iii);
                        }
                        if (characterderaw1[iii]=='*'){
                            dbcerebro.blankMultiplicacion(iii);
                        }
                        if (characterderaw1[iii]=='/'){
                            dbcerebro.blankDivision(iii);
                        }

                    }

                    contsimbolo.clear();
                    matadorciclorevision = matadorciclorevision-1;
                    a=0;
                    b=0;
                    parencerrado=1;


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
