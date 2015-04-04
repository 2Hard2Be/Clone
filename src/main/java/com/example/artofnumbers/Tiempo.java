package com.example.artofnumbers;

/**
 * Created by Peto-1 on 4/4/2015.
 */
public class Tiempo {

    public Double number;
    public String unidades;
    public String unidadesto;

    public Tiempo (Double vienenumber, String vieneunidades, String vieneunidadesto) {

        Double number = vienenumber;
        String unidades = vieneunidades;
        String unidadesto = vieneunidadesto;

    }

    public Tiempo(Double vienenumber, String vieneunidades) {

        Double number = vienenumber;
        String unidades = vieneunidades;

    }

    public  String calculaUnTiempo(Double valor, String units, String unitst) {

        number = valor;
        unidades = units;
        unidadesto = unitst;
        Double respuestan;
        String respuestastr;
        String errorto = "0.000";
        String errorunits = "0.0000";

        switch (unidades) {

            case  "ms(millisecond)":
            case "msec":
            case "ms":

                switch (unidadesto) {
                    case  "ms(millisecond)":
                    case "msec":
                    case "ms":

                        respuestan = 1 * number;
                        break;

                    case "s(second)":
                    case "s":
                    case "sec":

                        respuestan = 0.001 * number;
                        break;


                    case "min(minute)":
                    case "min":

                        respuestan = 0.000016666667 * number;
                        break;

                    case "h(hour)":
                    case "hr":
                    case "h":
                        respuestan = 2.7777777778e-7 * number;
                        break;

                    case "d(day)":
                    case "d":
                        respuestan = 1.1574074074e-8 * number;
                        break;

                    case "month":

                        respuestan = 3.8051750381e-10 * number;
                        break;

                    case "yr(year)":
                    case "year":
                    case "yr":

                        respuestan = 3.1709791984e-11 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);
                }
                break;

            case "s(second)":
            case "s":
            case "sec":

                switch (unidadesto) {
                    case  "ms(millisecond)":
                    case "msec":
                    case "ms":

                        respuestan = 1000 * number;
                        break;

                    case "s(second)":
                    case "s":
                    case "sec":

                        respuestan = 1 * number;
                        break;


                    case "min(minute)":
                    case "min":

                        respuestan = 0.016666667 * number;
                        break;

                    case "h(hour)":
                    case "hr":
                    case "h":
                        respuestan = 0.000277777778 * number;
                        break;

                    case "d(day)":
                    case "d":
                        respuestan = 0.000011574074074 * number;
                        break;

                    case "month":

                        respuestan = 3.8051750381e-7 * number;
                        break;

                    case "yr(year)":
                    case "year":
                    case "yr":

                        respuestan = 3.1709791984e-8 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);
                }
                break;

            case "min(minute)":
            case "min":

                switch (unidadesto) {
                    case  "ms(millisecond)":
                    case "msec":
                    case "ms":

                        respuestan = 60000 * number;
                        break;

                    case "s(second)":
                    case "s":
                    case "sec":

                        respuestan = 60 * number;
                        break;


                    case "min(minute)":
                    case "min":

                        respuestan = 1 * number;
                        break;

                    case "h(hour)":
                    case "hr":
                    case "h":
                        respuestan = 0.016666666667 * number;
                        break;

                    case "d(day)":
                    case "d":
                        respuestan = 0.000694444444 * number;
                        break;

                    case "month":

                        respuestan =  0.000022831050 * number;
                        break;

                    case "yr(year)":
                    case "year":
                    case "yr":

                        respuestan = 0.000001902587519 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);
                }
                break;

            case "h(hour)":
            case "hr":
            case "h":

                switch (unidadesto) {
                    case  "ms(millisecond)":
                    case "msec":
                    case "ms":

                        respuestan = 3600000 * number;
                        break;

                    case "s(second)":
                    case "s":
                    case "sec":

                        respuestan = 3600 * number;
                        break;


                    case "min(minute)":
                    case "min":

                        respuestan = 60 * number;
                        break;

                    case "h(hour)":
                    case "hr":
                    case "h":
                        respuestan = 1 * number;
                        break;

                    case "d(day)":
                    case "d":
                        respuestan = 0.041666666667 * number;
                        break;

                    case "month":

                        respuestan =  0.0013698630137 * number;
                        break;

                    case "yr(year)":
                    case "year":
                    case "yr":

                        respuestan = 0.000114155251 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);
                }
                break;

            case "d(day)":
            case "d":

                switch (unidadesto) {
                    case  "ms(millisecond)":
                    case "msec":
                    case "ms":

                        respuestan = 86400000 * number;
                        break;

                    case "s(second)":
                    case "s":
                    case "sec":

                        respuestan = 86400 * number;
                        break;


                    case "min(minute)":
                    case "min":

                        respuestan = 1440 * number;
                        break;

                    case "h(hour)":
                    case "hr":
                    case "h":
                        respuestan = 24 * number;
                        break;

                    case "d(day)":
                    case "d":
                        respuestan = 1 * number;
                        break;

                    case "month":

                        respuestan =  0.032876712329 * number;
                        break;

                    case "yr(year)":
                    case "year":
                    case "yr":

                        respuestan = 0.002739726027 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);
                }
                break;

            case "month":

                switch (unidadesto) {
                    case  "ms(millisecond)":
                    case "msec":
                    case "ms":

                        respuestan = 2628e6 * number;
                        break;

                    case "s(second)":
                    case "s":
                    case "sec":

                        respuestan = 2628000 * number;
                        break;


                    case "min(minute)":
                    case "min":

                        respuestan = 43800 * number;
                        break;

                    case "h(hour)":
                    case "hr":
                    case "h":
                        respuestan = 730 * number;
                        break;

                    case "d(day)":
                    case "d":
                        respuestan = 30.416666667 * number;
                        break;

                    case "month":

                        respuestan =  1 * number;
                        break;

                    case "yr(year)":
                    case "year":
                    case "yr":

                        respuestan = 0.083333333333 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);
                }
                break;

            case "yr(year)":
            case "year":
            case "yr":

                switch (unidadesto) {
                    case  "ms(millisecond)":
                    case "msec":
                    case "ms":

                        respuestan = 3.15e10 * number;
                        break;

                    case "s(second)":
                    case "s":
                    case "sec":

                        respuestan = 31536000 * number;
                        break;


                    case "min(minute)":
                    case "min":

                        respuestan =  525600 * number;
                        break;

                    case "h(hour)":
                    case "hr":
                    case "h":
                        respuestan = 8760 * number;
                        break;

                    case "d(day)":
                    case "d":
                        respuestan = 365 * number;
                        break;

                    case "month":

                        respuestan =  12 * number;
                        break;

                    case "yr(year)":
                    case "year":
                    case "yr":

                        respuestan = 1 * number;
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
