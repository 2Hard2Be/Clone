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
            case "Q":
                quees = "q";
                break;

            case "c":
            case "C":
                quees = "c";
                break;

            case "h":
            case "H":
                quees = "help";
                break;

            case "mass":
            case "Mass":
            case "Volume":
            case "volume":
            case "Time":
            case "time":
            case "Energy":
            case "energy":
            case "Length":
            case "length":
            case "Power":
            case "power":
            case "Pressure":
            case "pressure":
            case "Temperature":
            case "temperature":
                quees = "tablero";
                break;

            default:

            int i;
            int ii;

//                Atencion modificacion importante, le quite que lea el primer simbolo por si es un signo negativo
//                realmente non le debe importar cual es el primero sino solo dar el criterio de que operacion se trata

            for (i = 1; i < comandolectura.length; i++) {

                switch (comandolectura[i]) {

                    case '+':

                        quees = "suma";
                        i=comandolectura.length+1;
                        break;

                    case '-':
                        quees = "resta";
                        i=comandolectura.length+1;
                        break;

                    case '*':
                        quees = "multiplicacion";
                        i=comandolectura.length+1;
                        break;

                    case '/':
                        quees = "division";
                        i=comandolectura.length+1;
                        break;



                    default:
                        quees = "nada";


                }


            }
        }
        return quees;


    }

}
