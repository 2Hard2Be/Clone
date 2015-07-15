package com.example.artofnumbers;

import android.widget.Switch;

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
        int longitudstring=0;
        int validaciondesignos = 0;
        int comparadorlong=0;

        for(i=0; i<lecturaraw.length; i++){


            switch(lecturaraw[i]){

                case'+':
                    sumas = sumas+1;
                    posigno = i;
                    break;

                case '-':
                    restas = restas+1;
                    posigno=i;
                    break;

                case '*':
                    multiplicacion = multiplicacion+1;
                    posigno = i;
                    break;

                case '/':
                    division= division +1;
                    posigno=i;
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


                    }

                    else{

                        calculostr = "use numbers for calculations";

                    }

                    } else {

                        calculostr = " ";
                    }
                    break;

            case 2:

                if (lecturaraw[0]=='-'){

                if (posigno != lecturaraw.length - 1) {

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


                    }

                    else{

                        calculostr = "use numbers for calculations";

                    }

                } else {

                    calculostr = " ";
                }}

                else { calculostr = "check operator position";}

                break;



                    default:

                        calculostr = "check the syntax"+" "+validaciondesignos+" "+longitudstring+" "+raw;


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

