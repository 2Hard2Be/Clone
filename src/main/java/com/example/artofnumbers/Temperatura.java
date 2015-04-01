package com.example.artofnumbers;

/**
 * Created by Peto-1 on 3/29/2015.
 */
public class Temperatura {

    public Double number;
    public String unidades;
    public String unidadesto;

    public Temperatura (Double vienenumber, String vieneunidades, String vieneunidadesto) {

        Double number = vienenumber;
        String unidades = vieneunidades;
        String unidadesto = vieneunidadesto;

    }

    public Temperatura (Double vienenumber, String vieneunidades) {

        Double number = vienenumber;
        String unidades = vieneunidades;

    }

    public  String calculaUnaTemperatura(Double valor, String units, String unitst) {

        number = valor;
        unidades = units;
        unidadesto = unitst;
        Double respuestan;
        String respuestastr;
        String errorto = "0.000";
        String errorunits = "0.0000";

        switch (unidades) {

            case  "Celcius":
            case "c":

                switch (unidadesto) {
                    case  "Celcius":
                    case "c":

                        respuestan = 1 * number;
                        break;

                    case "Fahrenheit":
                    case "f":

                        respuestan =  (1.8*number)+32;
                        break;


                    case "Rankine":
                    case "r":

                        respuestan =(number+273.15)*(1.8);
                        break;

                    case "Kelvin":
                    case "k":
                        respuestan = 273.15 + number;
                        break;


                   default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;


            case "Fahrenheit":
            case "f":

                switch (unidadesto) {
                    case  "Celcius":
                    case "c":

                        respuestan =  (number-32)*(1.8);
                        break;

                    case "Fahrenheit":
                    case "f":

                        respuestan =  number*1;
                        break;


                    case "Rankine":
                    case "r":

                        respuestan =(number+459.67);
                        break;

                    case "Kelvin":
                    case "k":
                        respuestan = (number+459.67)*(0.555556);
                        break;


                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "Rankine":
            case "r":

                switch (unidadesto) {
                    case  "Celcius":
                    case "c":

                        respuestan =  (number-491.67)*(0.555556);
                        break;

                    case "Fahrenheit":
                    case "f":

                        respuestan =  number-459.67;
                        break;


                    case "Rankine":
                    case "r":

                        respuestan =(number*1);
                        break;

                    case "Kelvin":
                    case "k":
                        respuestan = (number)*(0.555556);
                        break;


                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "Kelvin":
            case "k":

                switch (unidadesto) {
                    case  "Celcius":
                    case "c":

                        respuestan =  (number-273.15);
                        break;

                    case "Fahrenheit":
                    case "f":

                        respuestan =  number*(1.8)-459.67;
                        break;


                    case "Rankine":
                    case "r":

                        respuestan =number*(1.8);
                        break;

                    case "Kelvin":
                    case "k":
                        respuestan = (number)*1;
                        break;


                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;


            default:
                respuestan = Double.parseDouble(errorunits);

        }

        respuestastr = String.valueOf(respuestan);
        return respuestastr;

    }
}
