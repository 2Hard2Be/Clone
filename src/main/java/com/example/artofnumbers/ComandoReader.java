package com.example.artofnumbers;

/**
 * Created by Peto-1 on 5/17/2015.
 */
public class ComandoReader {

public String comando;

    public ComandoReader(String vienecomando){

        String comando = vienecomando;

    }

    public String identificaQueEs(String comando1){

        comando = comando1;
        String quees = null;


        char [] comandolectura = new char[comando.length()];
        comando.getChars(0,comando.length(),comandolectura,0);


        switch(comando) {
            case "q":
                quees = "q";
                break;

            default:

            int i;
            int ii;
            for (i = 0; i < comandolectura.length; i++) {

                switch (comandolectura[i]) {

                    case '+':

                        quees = "suma";
                        i=comandolectura.length;
                        break;

                    case '-':
                        quees = "resta";
                        i=comandolectura.length;
                        break;

                    case '*':
                        quees = "multiplicacion";
                        i=comandolectura.length;
                        break;

                    case '/':
                        quees = "division";
                        i=comandolectura.length;
                        break;

                    default:
                        quees = "nada";


                }


            }
        }
        return quees;


    }

}
