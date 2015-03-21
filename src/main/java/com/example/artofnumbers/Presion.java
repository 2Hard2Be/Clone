package com.example.artofnumbers;

/**
 * Created by Peto-1 on 3/21/2015.
 */
public class Presion {

    public Double number;
    public String unidades;
    public String unidadesto;

    public Presion (Double vienenumber, String vieneunidades, String vieneunidadesto) {

        Double number = vienenumber;
        String unidades = vieneunidades;
        String unidadesto = vieneunidadesto;

    }

    public Presion(Double vienenumber, String vieneunidades) {

        Double number = vienenumber;
        String unidades = vieneunidades;

    }

    public  String calculaUnaPotencia(Double valor, String units, String unitst) {

        number = valor;
        unidades = units;
        unidadesto = unitst;
        Double respuestan;
        String respuestastr;
        String errorto = "0.000";
        String errorunits = "0.0000";

        switch (unidades) {

            case  "atm(standard_atmosphere)":
            case "atm":

                switch (unidadesto) {

                    case  "atm(standard_atmosphere)":
                    case "atm":
                        respuestan = 1 * number;
                        break;

                    case  "bar":
                        respuestan = 1 * number;
                        break;

                    case "inHg(inches_of_mercury_0C)":
                    case "inHg":

                        respuestan =  0.74569987 * number;
                        break;

                    case "inH2O(inches_of_water_4C)":
                    case "inH2O":
                        respuestan =   745.69987 * number;
                        break;

                    case "kPa(kilopascal)":
                    case "kPa":
                        respuestan = 0.212036131   * number;
                        break;

                    case "Pa(pascal)":
                    case "Pa":
                        respuestan = 0.212036131   * number;
                        break;

                    case "hPa(hectopascal":
                    case "hPa":
                        respuestan = 0.212036131   * number;
                        break;

                    case "msw(metre_sea_water)":
                    case "msw":
                        respuestan = 0.212036131   * number;
                        break;

                    case "fsw(feet_sea_water)":
                    case "fsw":
                        respuestan = 0.212036131   * number;
                        break;

                    case "Torr":
                    case "torr":
                        respuestan = 0.212036131   * number;
                        break;

                    case  "mbar(milibar)":
                    case "mbar":
                        respuestan = 0.212036131   * number;
                        break;

                    case  "mmHg(milimeter_of_mercury_0C":
                    case "mmHg":
                        respuestan = 0.212036131   * number;
                        break;

                    case  "mmH2O(milimeter_of_water_4C":
                    case "mmH2O":
                        respuestan = 0.212036131   * number;
                        break;

                    case  "decibar(dbar)":
                    case "dbar":
                        respuestan = 0.212036131   * number;
                        break;

                    case  "psi(pounds_per_square_inch)":
                    case "psi":
                        respuestan = 0.212036131   * number;
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
