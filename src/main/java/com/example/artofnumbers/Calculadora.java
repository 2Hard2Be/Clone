package com.example.artofnumbers;

import android.widget.Switch;

import java.util.Collections;
import java.util.Vector;

/**
 * Created by Peto-1 on 5/17/2015.
 */
public class Calculadora {

    public String calculostr;
    public Double calculodouble;
    public String operacion;
    public String raw;
    public String arg1string;
    public String arg2string;




    public Calculadora (String vieneoperacion, String lacarnita ){

        operacion = vieneoperacion;
        raw = lacarnita;
    }

    public String calcula(String op, String raw1){

        StringBuilder argumento1 = new StringBuilder();
        StringBuilder argumento2 = new StringBuilder();
        operacion = op;
        raw = raw1;
        Vector<Integer> contsimbolominus = new Vector<Integer>();


        char [] lecturaraw = new char[raw.length()];
        raw.getChars(0,raw.length(),lecturaraw,0);

        int i;
        int ii;
        int iii;
        int sumas=0;
        int restas=0;
        int multiplicacion=0;
        int division=0;
        int posigno=0;
        int posignomas = 0;
        int posignomenos = 0;
        int posignomulti = 0;
        int posignodivi = 0;
        int longitudstring=0;
        int validaciondesignos = 0;
        int vectorsize = 0;
        int comparadorlong=0;

        for(i=0; i<lecturaraw.length; i++){


            switch(lecturaraw[i]){

                case'+':
                    sumas = sumas+1;
                    posigno = i;
                    posignomas = i;
                    break;

                case '-':
                    restas = restas+1;
                    posigno=i;
                    contsimbolominus.add(i);
                    posignomenos = i;
                    break;

                case '*':
                    multiplicacion = multiplicacion+1;
                    posigno = i;
                    posignomulti = i;
                    break;

                case '/':
                    division= division +1;
                    posigno=i;
                    posignodivi = i;
                    break;

                default:
                    longitudstring = longitudstring+1;


            }


        }

        validaciondesignos = sumas+restas+multiplicacion+division;
        comparadorlong = lecturaraw.length-longitudstring;


        switch (validaciondesignos) {


            case 1:
                if (posigno != 0 && posigno != lecturaraw.length - 1) {

                    for (ii = 0; ii < posigno; ii++) {
                        argumento1.append(lecturaraw[ii]).toString();


                    }
                    iii = posigno + 1;
                    while (iii < lecturaraw.length) {

                        argumento2.append(lecturaraw[iii]).toString();
                        iii = iii + 1;
                    }

                    String arg1string = argumento1.toString();
                    String arg2string = argumento2.toString();

                    if (isDouble(arg1string) && isDouble(arg2string)) {

                        Double arg1double = Double.valueOf(arg1string);
                        Double arg2double = Double.valueOf(arg2string);


                        switch (operacion) {
                            case "suma":
                                calculodouble = arg1double + arg2double;
                                calculostr = calculodouble.toString();
                                break;

                            case "resta":
                                calculodouble = arg1double - arg2double;
                                calculostr = calculodouble.toString();
                                break;

                            case "multiplicacion":
                                calculodouble = arg1double * arg2double;
                                calculostr = calculodouble.toString();
                                break;

                            case "division":
                                calculodouble = arg1double / arg2double;
                                calculostr = calculodouble.toString();
                                break;

                            default:
                                calculostr = "error";


                        }


                    } else {

                        calculostr = "3 use numbers for calculations"+operacion+" "+raw;

                    }

                } else {

                    calculostr = " ";
                }
                break;

            case 2:
            case 3:

                if (sumas < 2 && multiplicacion < 2 && division < 2) {

                    Collections.sort(contsimbolominus);
                    vectorsize = contsimbolominus.size();
                    if (vectorsize <= 3) {

                        if (vectorsize > 0) {

                            if (posigno != lecturaraw.length - 1) {

//                                Evaluacion que posigno es igual a alguna posicion de contsimbolominus
//                                En cuyo caso quiere decir que un simbolo menos es el ultimo, lo dejo por si sirve de algo

                                for (ii = 0; ii < contsimbolominus.size(); ii++){

                                    if (contsimbolominus.get(ii)== posigno){
                                        comparadorlong = 1;

                                    }

                                }

//                                Switch de revision si contsimbolominus contiene solo un valor o dos
                                switch(contsimbolominus.size()){

//                                    Case 1 indica que solo hay un simbolo menos, por lo tanto o esta al principio
//                                    o junto al simbolo interior, si esta junto al interior, para el caso de suma
//                                    puede estar al lado izquierdo o derecho, para el caso de resta no puede ser
//                                    pues ya quedo claro que solo hay un negativo, resta no existe, multiplicacion y
//                                    division el negativo solo puede estar al lado derecho del signo.

//                                    OJO POSIBLEMENTE SEA NECESARIO REVISAR EL LECTOR DE COMANDO PARA QUE CUANDO
//                                    VEA SIGNO NEGATIVO DETERMINE QUE ES RESTA SI EL SIGNO - ES SOLO UNO, SI ES MAS
//                                    DE UNO DEBE REVISAR QUE EL ADICIONAL SOLO PUEDE SER -

                                    case 1:

//                                        Caso que el negativo esta al inicio, mas facil, que adjunte las expresiones del
//                                        raw desde posicion 1 y al final solo agrega a la respuesta el caracter "-"
                                      if (contsimbolominus.get(0) == 0){

                                          for (ii = 0; ii < posigno; ii++) {
                                              argumento1.append(lecturaraw[ii]).toString();


                                          }
                                          iii = posigno + 1;
                                          while (iii < lecturaraw.length) {

                                              argumento2.append(lecturaraw[iii]).toString();
                                              iii = iii + 1;
                                          }

                                          String arg1string = argumento1.toString();
                                          String arg2string = argumento2.toString();

                                          if (isDouble(arg1string) && isDouble(arg2string)) {

                                              Double arg1double = Double.valueOf(arg1string);
                                              Double arg2double = Double.valueOf(arg2string);


                                              switch (operacion) {
                                                  case "suma":


                                                      calculodouble = arg1double + arg2double;
                                                      calculostr = calculodouble.toString();
                                                      break;

                                                  case "resta":

                                                      calculodouble = arg1double + arg2double;
                                                      calculostr = calculodouble.toString();
                                                      break;

                                                  case "multiplicacion":
                                                      calculodouble = arg1double * arg2double;
                                                      calculostr = calculodouble.toString();
                                                      break;

                                                  case "division":
                                                      calculodouble = arg1double / arg2double;
                                                      calculostr = calculodouble.toString();
                                                      break;

                                                  default:
                                                      calculostr = "error";


                                              }


                                          } else {

                                              calculostr = "2 use numbers for calculations";

                                          }

                                      }
//                                        Caso que el negativo esta adentro debe estar en la posicion correcta o es error
//                                      ver comentarios de arriba
                                        else {


                                      }
                                        break;

                                    case 2:
                                    case 3:

                                        if (contsimbolominus.get(0) == 0) {

                                            if (posigno == contsimbolominus.get(1)){

                                                for (ii = 0; ii < posigno-1; ii++) {

                                                    argumento1.append(lecturaraw[ii]).toString();


                                                }
                                            iii = posigno+1;
                                            while (iii < lecturaraw.length) {

                                                argumento2.append(lecturaraw[iii]).toString();
                                                iii = iii + 1;
                                            }

                                            String arg1string = argumento1.toString();
                                            String arg2string = argumento2.toString();

                                            if (isDouble(arg1string) && isDouble(arg2string)) {

                                                Double arg1double = Double.valueOf(arg1string);
                                                Double arg2double = Double.valueOf(arg2string);


                                                switch (operacion) {
                                                    case "suma":


                                                        calculodouble = arg1double - arg2double;
                                                        calculostr = calculodouble.toString();
                                                        break;

                                                    case "resta":

                                                        calculodouble = arg1double + arg2double;
                                                        calculostr = calculodouble.toString();
                                                        break;

                                                    case "multiplicacion":
                                                        calculodouble = arg1double * arg2double*(-1);
                                                        calculostr = calculodouble.toString();
                                                        break;

                                                    case "division":
                                                        calculodouble = arg1double / arg2double*(-1);
                                                        calculostr = calculodouble.toString();
                                                        break;

                                                    default:
                                                        calculostr = "error";


                                                }


                                            } else {

                                                calculostr = "1 use numbers for calculations";

                                            }
                                        }

                                            else {
                                                calculostr = "1 check operator position";
                                            }
                                        }
//                                        Caso que el negativo esta adentro debe estar en la posicion correcta o es error
//                                      ver comentarios de arriba
                                        else {


                                        }
                                        break;



                                    default:

                                        calculostr = "2 check operator position";

                                }




                            }

                        else {calculostr = "3 check operator position";
                                      }



                    }
//                        SE SUPONE QUE ESTE ES EL ELSE DE QUE NO HAY SIMBOLOS "-" POR LO TANTO ES ERROR
                        else{


                             calculostr = "4 check operator position";


//                            El corchete de abajo es el del Else de que hay signos negativos

                        }



//                    otro else aqui
                } else {
                    calculostr = "5 check operator position";

                }
        }

                else { calculostr = "6 check operator position";

        }

                break;



                    default:

                        calculostr = "check the syntax"+"raw"+raw+"#"+contsimbolominus+"operacion="+operacion;


                }



        return calculostr;

    }

    public boolean isDouble( String str ){
        try{
            Double.parseDouble( str );
            return true;
        }
        catch( Exception e ){
            return false;
        }
    }
}

