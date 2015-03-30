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

                        respuestan =  (9/5) * number+32;
                        break;


                    case "Rankine":
                    case "r":

                        respuestan =(number+273.15)*(9/5);
                        break;

                    case "Kelvin":
                    case "k":
                        respuestan = 273.15 + number;
                        break;


                   default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

//            
            case "Fahrenheit":
            case "f":

                switch (unidadesto) {
                    case  "Celcius":
                    case "c":

                        respuestan = 1 * number;
                        break;

                    case "Fahrenheit":
                    case "f":

                        respuestan =  (9/5) * number+32;
                        break;


                    case "Rankine":
                    case "r":

                        respuestan =(number+273.15)*(9/5);
                        break;

                    case "Kelvin":
                    case "k":
                        respuestan = 273.15 + number;
                        break;


                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "kW(kilowatt)":
            case "kw":
            case "kW":

                switch (unidadesto) {
                    case  "hp(horsepower_international)":
                    case "hp":

                        respuestan =  1.341022092 * number;
                        break;

                    case "kW(kilowatt)":
                    case "kw":
                    case "kW":
                        respuestan =  1 * number;
                        break;


                    case "Watt":
                    case "W(Watt)":
                    case "W":
                    case "w":
                        respuestan =   1000 * number;
                        break;

                    case "ton(refrigeration)":
                        respuestan = 0.284345   * number;
                        break;



                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "Watt":
            case "W(Watt)":
            case "W":
            case "w":

                switch (unidadesto) {
                    case  "hp(horsepower_international)":
                    case "hp":

                        respuestan =  0.001341 * number;
                        break;

                    case "kW(kilowatt)":
                    case "kw":
                    case "kW":
                        respuestan =  0.001 * number;
                        break;


                    case "Watt":
                    case "W(Watt)":
                    case "W":
                    case "w":
                        respuestan =   1 * number;
                        break;

                    case "ton(refrigeration)":
                        respuestan =  0.000284345   * number;
                        break;



                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "ton(refrigeration)":

                switch (unidadesto) {
                    case  "hp(horsepower_international)":
                    case "hp":

                        respuestan =   4.716177354 * number;
                        break;

                    case "kW(kilowatt)":
                    case "kw":
                    case "kW":
                        respuestan =  3.516852 * number;
                        break;


                    case "Watt":
                    case "W(Watt)":
                    case "W":
                    case "w":
                        respuestan =    3516.852 * number;
                        break;

                    case "ton(refrigeration)":
                        respuestan =  1   * number;
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
