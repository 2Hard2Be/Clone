package com.example.artofnumbers;

import android.content.Context;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * Created by Peto-1 on 7/19/2015.
 */

//ALERTA HE
public class EquationCalculadora{

    public String raw1;


public EquationCalculadora(String lacarnita){

    raw1 = lacarnita;

}

    public String CalculaEcuacion(String raw){


        final DatabaseHand dbcerebro = DatabaseHand.getInstance(theContext.getContext());
        raw1 = raw;


        StringBuilder paracalcular = new StringBuilder();
        StringBuilder expresionenparentesis = new StringBuilder();
        String calcular = new String();
        String respuestaintermedia;
        char[] characterderaw1 = new char[raw1.length()];
        raw1.getChars(0, raw1.length(), characterderaw1, 0);
        String respuesta = new String();
        Vector<Integer> contsimbolo = new Vector<Integer>();
        int i;
        int ii;
        int iii;
        int iv;
        int v;
        int vi;
        int contparenabier=0;
        int contparencerra=0;
        int contsuma = 0;
        int contresta = 0;
        int contmulti = 0;
        int contdivi = 0;
        int matadorciclorevision = 0;
        int posab = 0;
        int poscer = 0;
        int posabb = 0;
        int poscerfinder = 0;
        int parencerrado=1;
        int a = 0;
        int b = 0;




//        FOR PARA LLENAR LA TABLA ECUACION

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
                break;

            case '*':
                dbcerebro.addMultiplicacion(i);

                contmulti=contmulti+1;
                break;

                default:
                    dbcerebro.addNulls();
        }

        }

        matadorciclorevision = contparenabier;

//        IF DE REVISION QUE EXISTA UN NUMERO PAR DE PARENTESIS ABIERTOS Y CERRADOS

        if (contparenabier==contparencerra){

//        IF DE REVISION SI HAY PARENTESIS
            if (contparenabier>0){

//                CICLO WHILE PARA TERMINAR LOS PARENTESIS DE LA EXPRESION, EL MATADOR MANDA, PASO 3

                while (matadorciclorevision>0){
//                 paso 3, busca el parentesis abierto mas internon o el maximo

                posab = dbcerebro.getParenAbierMax();
                posabb = dbcerebro.getParenAbierMax();
                poscerfinder = posab+1;

//                    WHILE EN BUSCA DEL PARENTESIS CERRADO MAS CERCANO
                    while (parencerrado>0){
//                        IF DE COMPARACION DEL DATO EN VECTOR DE DATOS PARA VER SI ES PARENTESIS CERRADO
                        if(characterderaw1[poscerfinder]==')'){
                            poscer = poscerfinder;
                            parencerrado = parencerrado-1;
                        }
                      poscerfinder = poscerfinder+1;
                    }

                   a = posab+1;
                   b = poscer-1;

//                    IF DE REVISION SI LOS VALORES QUE SE ENCUENTRAN EN a Y b NO SON PARENTESIS PASO 6

                    if (characterderaw1[a]!='('&& characterderaw1[a]!=')'
                            && characterderaw1[b]!=')'&& characterderaw1[b]!='(') {

//                        FOR PARA ADJUNTAR LOS VALORES EN MEDIO DE PARENTESIS PARA CALCULARLOS
//                        DE UN SOLO LLENA EL VECTOR CONTSIMBOLO AUNQUE NO LO USEMOS DENTRO DE ESTE CASO, PASO 7
                        for (ii=a; ii<poscer; ii++){
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
                     respuesta = calculadora.calculaAdvanced(calcular);
//                        El update borra el valor donde estaba el parentesis abierto e ingresa el de respeq
                     dbcerebro.addRespeqUpdated(respuesta, posab + 1);
                        contparenabier = contparenabier-1;





                    }

//                    ELSE DE REVISION SI LOS VALORES QUE SE ENCUENTRAN EN a Y b NO SON PARENTESIS
//                    AQUI ENTRARA AL ENCONTRAR PARENTESIS CON POSIBILIDAD DE SALIR DEL CICLO, PASO 14

                    else {

                        for (ii=a; ii<poscer; ii++){

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
//                     Ordena el vector contsimbolo en orden ascendente
                        Collections.sort(contsimbolo);

//                       FOR QUE BARRERA COLUMNA RESPEQ DE TABLA EQUATION EN BUSCAR DE VALORES PASO 18
                        for (ii=a; ii<poscer; ii++){

                        if (dbcerebro.getRespuestaEq(ii + 1)== null){

                            expresionenparentesis.append(characterderaw1[ii]).toString();
                        }

                        else {
                            expresionenparentesis.append(dbcerebro.getRespuestaEq(ii+1)).toString();

                            if(ii<Collections.max(contsimbolo)) {
                                for (iv = 0; iv < contsimbolo.size(); iv++) {

                                    if (ii < contsimbolo.get(iv)) {

                                        ii = contsimbolo.get(iv);
                                    }
                                }

                            }

                            else {ii=b;}

                        }


                        }

                        calcular = expresionenparentesis.toString();
                        CalculadoraAdvanced calculadora= new CalculadoraAdvanced(calcular);
                        respuesta = calculadora.calculaAdvanced(calcular);
                        dbcerebro.addRespeqUpdated(respuesta, posab);
                        contparenabier=contparenabier-1;
                        expresionenparentesis.setLength(0);

                    }

//                    BORRANDO LOS SIMOBOLOS ENTRE A Y B, atencion revisar que el parentesis abierto ya fue cerrado
//                    el parentesis cerrado se borra mediante la siguiente expresion

                    dbcerebro.addBlanksUpdated(poscer + 1);

//                    FOR DE BORRADO DE SIMOBOLOS EN COLUMNAS DE SIMBOLOS ENTRE a Y b

                    for (iii=a; iii<poscer; iii++){

                       if (characterderaw1[iii]=='+'){
                           dbcerebro.addBlanksUpdated(iii+1);
                       }
                        if (characterderaw1[iii]=='-'){
                            dbcerebro.addBlanksUpdated(iii+1);
                        }
                        if (characterderaw1[iii]=='*'){
                            dbcerebro.addBlanksUpdated(iii+1);
                        }
                        if (characterderaw1[iii]=='/'){
                            dbcerebro.addBlanksUpdated(iii+1);
                        }

                    }



                    a=0;
                    b=0;
                    parencerrado=1;
                    paracalcular.setLength(0);
                    matadorciclorevision = matadorciclorevision-1;

                    if (contparenabier==0){matadorciclorevision = matadorciclorevision-1;}
//                    El unico stringbuilder que se hace cero antes es el de los parentesis EXPRESIONENPARENTESIS


//EL DE ABAJO ES EL CORCHETE DEL WHILE DE REVISION PRINCIPAL
                }

                contsimbolo.clear();
                for (v=1; v<characterderaw1.length; v++){

                    if (dbcerebro.getBooleanSuma(v+1)==Boolean.TRUE){
                        if (dbcerebro.getSuma(v+1)==v){
                            contsimbolo.add(v);
                        }}

                    if (dbcerebro.getBooleanResta(v+1)==Boolean.TRUE){
                        if (dbcerebro.getResta(v+1)==v){
                            contsimbolo.add(v);
                        }}

                    if (dbcerebro.getBooleanMulti(v+1)==Boolean.TRUE){
                        if (dbcerebro.getMultiplicacion(v+1)==v){
                            contsimbolo.add(v);
                        }}

                    if (dbcerebro.getBooleanDivi(v+1)==Boolean.TRUE){
                        if (dbcerebro.getDivision(v+1)==v){
                            contsimbolo.add(v);
                        }}

                }


                if (contsimbolo.isEmpty()){

                    respuesta= "Error";


                }

                else{

//                     Ordena el vector contsimbolo en orden ascendente
                    Collections.sort(contsimbolo);}

//                       FOR QUE BARRERA COLUMNA RESPEQ DE TABLA EQUATION EN BUSCAR DE VALORES PASO 24
                for (vi=0; vi<characterderaw1.length; vi++){

//                    ESTA LANZANDO UN NUMERO DE MAS, SE VERIFICO QUE REALIZA LAS OPERACIONES, CAMBIAR
//                    O QUITAR LA EXPRESION DE ABAJO EN EL IF MAS INTERNO PARA VERIFICAR
//                    expresionenparentesis.append(characterderaw1[vi]).toString();
//                    ESTA EXPRESION ES LA QUE AGREGA EL SIMBOLO
//                    POR EJEMPLO (7+6)-(8-2)=1366, SIENDO (7+6)=13 Y (8-2)=6, REPITE EL 6 DE NUEVO
//                    SI COLOCO EXPRESION (7+2)+(8-2)+(6-2) IGNORA EL (8-2), AUNQUE IDENTIFICA LAS POSICIONES
//                    DE LOS SIMBOLOS EN [5,11], LA RESPUESTA SERA PARA ESTE CASO 944 LO CUAL ES ERRONEO
//                    ESTA RETORNANDO VALORES DE getRespuestaEq que tienen null, y por ello retorna cero
//                    Y REPITE EL ULTIMO VALOR. POSIBLEMENTE EL ERROR ESTE EN EL IF DE COLLECTIONS MAX
//                    O EN LA EXPRESION dbcerebro.getRespuestaEq(vi+1)==null, PUES RETORNA STRINGS
//                    Y CUANDO EL VALOR ES NULL EN EL RECORD ENTONCES DEVUELVE 0 (CERO) NO NULL, TAL VEZ
//                    MODIFICANDO EL METODO getRespuestaEq() PARA QUE DEVUELVA FLOATS O NUMEROS O UN STRING
//                    QUE DIGA QUE NO TIENE VALOR, PROBAR CON EL METODO getRespuestaEqHechiza(), EL CUAL LO CREE PARA PROBAR ESTE METODO

                    if (dbcerebro.getRespuestaEq(vi + 1)== null){

                        expresionenparentesis.append(characterderaw1[vi]).toString();
                    }

                    else {
                        expresionenparentesis.append(dbcerebro.getRespuestaEq(vi+1)).toString();

                        if (contsimbolo.isEmpty() == Boolean.FALSE){
                            if (vi < Collections.max(contsimbolo)) {
                                for (iv = 0; iv < contsimbolo.size(); iv++) {

                                    if (vi < contsimbolo.get(iv)) {

                                        vi = contsimbolo.get(iv)-1;
//                                        ESTA EXPRESION AGREGA EL SIMBOLO

                                        iv = contsimbolo.size()+1;
                                    }
                                }

                            }
                            else {vi=characterderaw1.length+1;}
                        }

                        else {vi=characterderaw1.length+1;}

                    }


                }

                calcular = expresionenparentesis.toString();
                CalculadoraAdvanced calculadora = new CalculadoraAdvanced(calcular);
                respuesta = calculadora.calculaAdvanced(calcular);
                dbcerebro.addRespeqUpdated(respuesta,posab);
                expresionenparentesis.setLength(0);



            }
//            ELSE DE QUE NO HAY PARENTESIS, SE DEBE TRATAR COMO UNA ECUACION NORMAL, paso 22
            else {
                for (v=1; v<characterderaw1.length; v++){

                    if (dbcerebro.getBooleanSuma(v+1)==Boolean.TRUE){
                    if (dbcerebro.getSuma(v+1)==v){
                        contsimbolo.add(v);
                    }}

                    if (dbcerebro.getBooleanResta(v+1)==Boolean.TRUE){
                    if (dbcerebro.getResta(v+1)==v){
                        contsimbolo.add(v);
                    }}

                    if (dbcerebro.getBooleanMulti(v+1)==Boolean.TRUE){
                    if (dbcerebro.getMultiplicacion(v+1)==v){
                        contsimbolo.add(v);
                    }}

                    if (dbcerebro.getBooleanDivi(v+1)==Boolean.TRUE){
                    if (dbcerebro.getDivision(v+1)==v){
                        contsimbolo.add(v);
                    }}

                }


                if (contsimbolo.isEmpty()){

                 respuesta= "Error";


                }

                else{

//                     Ordena el vector contsimbolo en orden ascendente
                Collections.sort(contsimbolo);}

//                       FOR QUE BARRERA COLUMNA RESPEQ DE TABLA EQUATION EN BUSCAR DE VALORES PASO 24
                for (vi=0; vi<characterderaw1.length; vi++){

                    if (dbcerebro.getRespuestaEq(vi+1)== null){

                        expresionenparentesis.append(characterderaw1[vi]).toString();
                    }

                    else {
                        expresionenparentesis.append(dbcerebro.getRespuestaEq(vi+1)).toString();

                        if (contsimbolo.isEmpty() == Boolean.FALSE){
                            if (vi < Collections.max(contsimbolo)) {
                                for (iv = 0; iv < contsimbolo.size(); iv++) {

                                    if (vi < contsimbolo.get(iv)) {

                                        vi = contsimbolo.get(iv);
                                    }
                                }

                            }
                    }

                        else {vi=characterderaw1.length;}

                    }


                }

                calcular = expresionenparentesis.toString();
                CalculadoraAdvanced calculadora = new CalculadoraAdvanced(calcular);
                respuesta = calculadora.calculaAdvanced(calcular);
                dbcerebro.addRespeqUpdated(respuesta,posab);
                expresionenparentesis.setLength(0);
            }


            }


//        EL ELSE DE LA REVISION DEL NUMERO DE PARENTESIS ABIERTOS Y CERRADOS
       else {

            respuesta = "Check the parenthesis one could be missing";
         }

        Integer ultimo = dbcerebro.getSuma(1);
        dbcerebro.deleteTodasEquations();

        return respuesta+" "+contsimbolo+" "+ultimo;
    }

}
