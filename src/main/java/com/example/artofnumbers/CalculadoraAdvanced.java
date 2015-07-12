package com.example.artofnumbers;

import java.util.Arrays;

/**
 * Created by Peto-1 on 7/4/2015.
 */
public class CalculadoraAdvanced {

    public String calculostr;
    public Double calculodouble;
    public String operacion;
    public String raw;
    public String arg1string;
    public String arg2string;




    public CalculadoraAdvanced (String lacarnita ){


        raw = lacarnita;
    }

    public String calculaAdvanced(String raw1) {

        StringBuilder argumento1 = new StringBuilder();
        StringBuilder argumento2 = new StringBuilder();

        raw = raw1;


        char[] lecturaraw = new char[raw.length()];
        raw.getChars(0, raw.length(), lecturaraw, 0);

        int i=0;
        int ii;
        int operacion = 0;
        int tester;
        int tester2;


        String digasenor;
        String numerostring;

        int numeroref = 0;
        Float numerofloat;


        while (i < lecturaraw.length) {
            numeroref = i+1;

            if (Arrays.asList('+', '-', '*', '/').contains(lecturaraw[i])) {
                operacion = operacion+1;
            }

            if (i<lecturaraw.length-1){
                if (Arrays.asList('+', '-', '*', '/').contains(lecturaraw[numeroref])) {
                    operacion = operacion+1;
                }

            }

            if (Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ',', '.', '+', '-', '*', '/').contains(lecturaraw[i])) {
                argumento1.append(lecturaraw[i]).toString();
            }

            if (operacion == 3 || i==lecturaraw.length-1) {
                String arg1string = argumento1.toString();
                ComandoReader comando = new ComandoReader(arg1string);
                digasenor = comando.identificaQueEs(arg1string);
                Calculadora calculadora = new Calculadora(digasenor,arg1string);
                numerostring = calculadora.calcula(digasenor, arg1string);
                char[] lecturaraw2 = new char[numerostring.length()];
                numerostring.getChars(0, numerostring.length(), lecturaraw2, 0);
                argumento1.setLength(0);
                for (ii = 0; ii < lecturaraw2.length; ii++) {
                    argumento1.append(lecturaraw2[ii]).toString();
                }
                operacion = 1;
            }



            i = i+1;
        }
        String arg1string = argumento1.toString();
        return arg1string;
    }
}
