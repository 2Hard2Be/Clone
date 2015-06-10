package com.example.artofnumbers;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

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

    public  String calculaUnaPresion(Double valor, String units, String unitst) {

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
                        respuestan = 1.01325 * number;
                        break;

                    case "inHg(inches_of_mercury_0C)":
                    case "inhg":

                        respuestan =  29.921331924 * number;
                        break;

                    case "inH2O(inches_of_water_4C)":
                    case "inh2o":
                        respuestan =   406.793746638 * number;
                        break;

                    case "kPa(kilopascal)":
                    case "kPa":
                        respuestan = 101.32501   * number;
                        break;

                    case "Pa(pascal)":
                    case "Pa":
                        respuestan = 101325.01   * number;
                        break;

                    case "hPa(hectopascal)":
                    case "hPa":
                        respuestan = 1013.2501   * number;
                        break;


                    case "Torr":
                    case "torr":
                        respuestan = 760.000066   * number;
                        break;

                    case  "mbar(milibar)":
                    case "mbar":
                        respuestan =  1013.250   * number;
                        break;

                    case  "mmHg(milimeter_of_mercury_0C)":
                    case "mmhg":
                        respuestan = 759.999952   * number;
                        break;

                    case  "mmH2O(milimeter_of_water_4C)":
                    case "mmh2o":
                        respuestan = 10332.275548   * number;
                        break;

                    case  "decibar(dbar)":
                    case "dbar":
                        respuestan = 10.132501   * number;
                        break;

                    case  "psi(pounds_per_square_inch)":
                    case "psi":
                        respuestan = 14.695950   * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case  "bar":
                switch (unidadesto) {

                    case  "atm(standard_atmosphere)":
                    case "atm":
                        respuestan = 0.986923169 * number;
                        break;

                    case  "bar":
                        respuestan = 1 * number;
                        break;

                    case "inHg(inches_of_mercury_0C)":
                    case "inhg":

                        respuestan =  29.529983 * number;
                        break;

                    case "inH2O(inches_of_water_4C)":
                    case "inh2o":
                        respuestan =   401.463078 * number;
                        break;

                    case "kPa(kilopascal)":
                    case "kPa":
                        respuestan = 100   * number;
                        break;

                    case "Pa(pascal)":
                    case "Pa":
                        respuestan = 100000   * number;
                        break;

                    case "hPa(hectopascal)":
                    case "hPa":
                        respuestan = 1000   * number;
                        break;


                    case "Torr":
                    case "torr":
                        respuestan = 750.061673    * number;
                        break;

                    case  "mbar(milibar)":
                    case "mbar":
                        respuestan =  1000   * number;
                        break;

                    case  "mmHg(milimeter_of_mercury_0C)":
                    case "mmhg":
                        respuestan = 750.061561   * number;
                        break;

                    case  "mmH2O(milimeter_of_water_4C)":
                    case "mmh2o":
                        respuestan = 10197.16213   * number;
                        break;

                    case  "decibar(dbar)":
                    case "dbar":
                        respuestan = 10   * number;
                        break;

                    case  "psi(pounds_per_square_inch)":
                    case "psi":
                        respuestan = 14.503773   * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "inHg(inches_of_mercury_0C)":
            case "inhg":
                switch (unidadesto) {

                    case  "atm(standard_atmosphere)":
                    case "atm":
                        respuestan = 0.033421 * number;
                        break;

                    case  "bar":
                        respuestan =  0.033863 * number;
                        break;

                    case "inHg(inches_of_mercury_0C)":
                    case "inhg":

                        respuestan =  1 * number;
                        break;

                    case "inH2O(inches_of_water_4C)":
                    case "inh2o":
                        respuestan =   13.595100 * number;
                        break;

                    case "kPa(kilopascal)":
                    case "kPa":
                        respuestan = 3.386388   * number;
                        break;

                    case "Pa(pascal)":
                    case "Pa":
                        respuestan =  3386.388666   * number;
                        break;

                    case "hPa(hectopascal)":
                    case "hPa":
                        respuestan = 33.863886   * number;
                        break;


                    case "Torr":
                    case "torr":
                        respuestan = 25.40    * number;
                        break;

                    case  "mbar(milibar)":
                    case "mbar":
                        respuestan =   33.863886   * number;
                        break;

                    case  "mmHg(milimeter_of_mercury_0C)":
                    case "mmhg":
                        respuestan = 25.399999   * number;
                        break;

                    case  "mmH2O(milimeter_of_water_4C)":
                    case "mmh2o":
                        respuestan = 345.315542   * number;
                        break;

                    case  "decibar(dbar)":
                    case "dbar":
                        respuestan = 0.338638866   * number;
                        break;

                    case  "psi(pounds_per_square_inch)":
                    case "psi":
                        respuestan =  0.491154152   * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "inH2O(inches_of_water_4C)":
            case "inh2o":
                switch (unidadesto) {

                    case  "atm(standard_atmosphere)":
                    case "atm":
                        respuestan = 0.002458 * number;
                        break;

                    case  "bar":
                        respuestan =  0.002490889 * number;
                        break;

                    case "inHg(inches_of_mercury_0C)":
                    case "inhg":

                        respuestan =   0.073555 * number;
                        break;

                    case "inH2O(inches_of_water_4C)":
                    case "inh2o":
                        respuestan =   1 * number;
                        break;

                    case "kPa(kilopascal)":
                    case "kPa":
                        respuestan =  0.249088   * number;
                        break;

                    case "Pa(pascal)":
                    case "Pa":
                        respuestan =  249.088908   * number;
                        break;

                    case "hPa(hectopascal)":
                    case "hPa":
                        respuestan = 2.490889 * number;
                        break;


                    case "Torr":
                    case "torr":
                        respuestan = 1.868320* number;
                        break;

                    case  "mbar(milibar)":
                    case "mbar":
                        respuestan = 2.490889 * number;
                        break;

                    case  "mmHg(milimeter_of_mercury_0C)":
                    case "mmhg":
                        respuestan = 1.868320 * number;
                        break;

                    case  "mmH2O(milimeter_of_water_4C)":
                    case "mmh2o":
                        respuestan = 25.399999   * number;
                        break;

                    case  "decibar(dbar)":
                    case "dbar":
                        respuestan = 0.024908 * number;
                        break;

                    case  "psi(pounds_per_square_inch)":
                    case "psi":
                        respuestan =  0.036127291   * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "kPa(kilopascal)":
            case "kPa":
                switch (unidadesto) {

                    case  "atm(standard_atmosphere)":
                    case "atm":
                        respuestan = 0.009869 * number;
                        break;

                    case  "bar":
                        respuestan =  0.01 * number;
                        break;

                    case "inHg(inches_of_mercury_0C)":
                    case "inhg":

                        respuestan =   0.295299 * number;
                        break;

                    case "inH2O(inches_of_water_4C)":
                    case "inh2o":
                        respuestan =    4.014630 * number;
                        break;

                    case "kPa(kilopascal)":
                    case "kPa":
                        respuestan =  1   * number;
                        break;

                    case "Pa(pascal)":
                    case "Pa":
                        respuestan =  1000   * number;
                        break;

                    case "hPa(hectopascal)":
                    case "hPa":
                        respuestan = 10 * number;
                        break;


                    case "Torr":
                    case "torr":
                        respuestan = 7.500616* number;
                        break;

                    case  "mbar(milibar)":
                    case "mbar":
                        respuestan = 10 * number;
                        break;

                    case  "mmHg(milimeter_of_mercury_0C)":
                    case "mmhg":
                        respuestan = 7.500615  * number;
                        break;

                    case  "mmH2O(milimeter_of_water_4C)":
                    case "mmh2o":
                        respuestan = 101.971621   * number;
                        break;

                    case  "decibar(dbar)":
                    case "dbar":
                        respuestan = 0.1 * number;
                        break;

                    case  "psi(pounds_per_square_inch)":
                    case "psi":
                        respuestan =  0.145037738   * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "Pa(pascal)":
            case "Pa":
                switch (unidadesto) {

                    case  "atm(standard_atmosphere)":
                    case "atm":
                        respuestan = 0.000009869 * number;
                        break;

                    case  "bar":
                        respuestan =  0.00001 * number;
                        break;

                    case "inHg(inches_of_mercury_0C)":
                    case "inhg":

                        respuestan =  0.000295299 * number;
                        break;

                    case "inH2O(inches_of_water_4C)":
                    case "inh2o":
                        respuestan = 0.004014630 * number;
                        break;

                    case "kPa(kilopascal)":
                    case "kPa":
                        respuestan =  0.001   * number;
                        break;

                    case "Pa(pascal)":
                    case "Pa":
                        respuestan =  1   * number;
                        break;

                    case "hPa(hectopascal)":
                    case "hPa":
                        respuestan = 0.01 * number;
                        break;


                    case "Torr":
                    case "torr":
                        respuestan =  0.007500 * number;
                        break;

                    case  "mbar(milibar)":
                    case "mbar":
                        respuestan = 0.01 * number;
                        break;

                    case  "mmHg(milimeter_of_mercury_0C)":
                    case "mmhg":
                        respuestan = 0.007500  * number;
                        break;

                    case  "mmH2O(milimeter_of_water_4C)":
                    case "mmh2o":
                        respuestan = 0.101971   * number;
                        break;

                    case  "decibar(dbar)":
                    case "dbar":
                        respuestan = 0.0001 * number;
                        break;

                    case  "psi(pounds_per_square_inch)":
                    case "psi":
                        respuestan =  0.000145037   * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;


            case "hPa(hectopascal)":
            case "hPa":
                switch (unidadesto) {

                    case  "atm(standard_atmosphere)":
                    case "atm":
                        respuestan =  0.000986923 * number;
                        break;

                    case  "bar":
                        respuestan =  0.001 * number;
                        break;

                    case "inHg(inches_of_mercury_0C)":
                    case "inhg":

                        respuestan =  0.029529 * number;
                        break;

                    case "inH2O(inches_of_water_4C)":
                    case "inh2o":
                        respuestan =  0.401463 * number;
                        break;

                    case "kPa(kilopascal)":
                    case "kPa":
                        respuestan =  0.1   * number;
                        break;

                    case "Pa(pascal)":
                    case "Pa":
                        respuestan =  100   * number;
                        break;

                    case "hPa(hectopascal)":
                    case "hPa":
                        respuestan = 1 * number;
                        break;


                    case "Torr":
                    case "torr":
                        respuestan =  0.750061673 * number;
                        break;

                    case  "mbar(milibar)":
                    case "mbar":
                        respuestan = 1 * number;
                        break;

                    case  "mmHg(milimeter_of_mercury_0C)":
                    case "mmhg":
                        respuestan =  0.750061561  * number;
                        break;

                    case  "mmH2O(milimeter_of_water_4C)":
                    case "mmh2o":
                        respuestan = 10.197162   * number;
                        break;

                    case  "decibar(dbar)":
                    case "dbar":
                        respuestan = 0.01 * number;
                        break;

                    case  "psi(pounds_per_square_inch)":
                    case "psi":
                        respuestan =  0.014503773   * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "Torr":
            case "torr":
                switch (unidadesto) {

                    case  "atm(standard_atmosphere)":
                    case "atm":
                        respuestan =   0.001315789 * number;
                        break;

                    case  "bar":
                        respuestan =  0.001333223 * number;
                        break;

                    case "inHg(inches_of_mercury_0C)":
                    case "inhg":

                        respuestan =  0.039370073 * number;
                        break;

                    case "inH2O(inches_of_water_4C)":
                    case "inh2o":
                        respuestan =  0.535240091 * number;
                        break;

                    case "kPa(kilopascal)":
                    case "kPa":
                        respuestan =   0.133322   * number;
                        break;

                    case "Pa(pascal)":
                    case "Pa":
                        respuestan =  133.32237 * number;
                        break;

                    case "hPa(hectopascal)":
                    case "hPa":
                        respuestan = 1.333223 * number;
                        break;


                    case "Torr":
                    case "torr":
                        respuestan =  1 * number;
                        break;

                    case  "mbar(milibar)":
                    case "mbar":
                        respuestan = 1.333223 * number;
                        break;

                    case  "mmHg(milimeter_of_mercury_0C)":
                    case "mmhg":
                        respuestan =  0.9999998  * number;
                        break;

                    case  "mmH2O(milimeter_of_water_4C)":
                    case "mmh2o":
                        respuestan = 13.595098224   * number;
                        break;

                    case  "decibar(dbar)":
                    case "dbar":
                        respuestan = 0.013332237 * number;
                        break;

                    case  "psi(pounds_per_square_inch)":
                    case "psi":
                        respuestan =  0.019336774   * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case  "mbar(milibar)":
            case "mbar":
                switch (unidadesto) {

                    case  "atm(standard_atmosphere)":
                    case "atm":
                        respuestan =  0.000986923 * number;
                        break;

                    case  "bar":
                        respuestan =  0.001 * number;
                        break;

                    case "inHg(inches_of_mercury_0C)":
                    case "inhg":

                        respuestan = 0.029529983 * number;
                        break;

                    case "inH2O(inches_of_water_4C)":
                    case "inh2o":
                        respuestan = 0.401463078 * number;
                        break;

                    case "kPa(kilopascal)":
                    case "kPa":
                        respuestan =   0.1   * number;
                        break;

                    case "Pa(pascal)":
                    case "Pa":
                        respuestan =  100 * number;
                        break;

                    case "hPa(hectopascal)":
                    case "hPa":
                        respuestan = 1 * number;
                        break;

                    case "Torr":
                    case "torr":
                        respuestan =   0.750061673 * number;
                        break;

                    case  "mbar(milibar)":
                    case "mbar":
                        respuestan = 1 * number;
                        break;

                    case  "mmHg(milimeter_of_mercury_0C)":
                    case "mmhg":
                        respuestan =   0.75006156  * number;
                        break;

                    case  "mmH2O(milimeter_of_water_4C)":
                    case "mmh2o":
                        respuestan = 10.19716213 * number;
                        break;

                    case  "decibar(dbar)":
                    case "dbar":
                        respuestan = 0.01 * number;
                        break;

                    case  "psi(pounds_per_square_inch)":
                    case "psi":
                        respuestan =   0.014503773   * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;


            case  "mmHg(milimeter_of_mercury_0C)":
            case "mmhg":
                switch (unidadesto) {

                    case  "atm(standard_atmosphere)":
                    case "atm":
                        respuestan = 0.001315789 * number;
                        break;

                    case  "bar":
                        respuestan =  0.001333223 * number;
                        break;

                    case "inHg(inches_of_mercury_0C)":
                    case "inhg":

                        respuestan = 0.039370079 * number;
                        break;

                    case "inH2O(inches_of_water_4C)":
                    case "inh2o":
                        respuestan = 0.535240171 * number;
                        break;

                    case "kPa(kilopascal)":
                    case "kPa":
                        respuestan =    0.13332239 * number;
                        break;

                    case "Pa(pascal)":
                    case "Pa":
                        respuestan =  133.32239 * number;
                        break;

                    case "hPa(hectopascal)":
                    case "hPa":
                        respuestan = 1.3332239 * number;
                        break;

                    case "Torr":
                    case "torr":
                        respuestan = 1.00000015 * number;
                        break;

                    case  "mbar(milibar)":
                    case "mbar":
                        respuestan = 1.3332239 * number;
                        break;

                    case  "mmHg(milimeter_of_mercury_0C)":
                    case "mmhg":
                        respuestan =   1  * number;
                        break;

                    case  "mmH2O(milimeter_of_water_4C)":
                    case "mmh2o":
                        respuestan = 13.595100264 * number;
                        break;

                    case  "decibar(dbar)":
                    case "dbar":
                        respuestan =  0.013332239 * number;
                        break;

                    case  "psi(pounds_per_square_inch)":
                    case "psi":
                        respuestan =  0.019336777871 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;


            case  "mmH2O(milimeter_of_water_4C)":
            case "mmh2o":
                switch (unidadesto) {

                    case  "atm(standard_atmosphere)":
                    case "atm":
                        respuestan = 0.000096784100 * number;
                        break;

                    case  "bar":
                        respuestan = 0.0000980665 * number;
                        break;

                    case "inHg(inches_of_mercury_0C)":
                    case "inhg":

                        respuestan = 0.002895902 * number;
                        break;

                    case "inH2O(inches_of_water_4C)":
                    case "inh2o":
                        respuestan = 0.039370079 * number;
                        break;

                    case "kPa(kilopascal)":
                    case "kPa":
                        respuestan = 0.00980665 * number;
                        break;

                    case "Pa(pascal)":
                    case "Pa":
                        respuestan = 9.80665 * number;
                        break;

                    case "hPa(hectopascal)":
                    case "hPa":
                        respuestan = 0.0980665 * number;
                        break;

                    case "Torr":
                    case "torr":
                        respuestan = 0.073555923 * number;
                        break;

                    case  "mbar(milibar)":
                    case "mbar":
                        respuestan = 0.0980665 * number;
                        break;

                    case  "mmHg(milimeter_of_mercury_0C)":
                    case "mmhg":
                        respuestan =    0.073555912  * number;
                        break;

                    case  "mmH2O(milimeter_of_water_4C)":
                    case "mmh2o":
                        respuestan = 1 * number;
                        break;

                    case  "decibar(dbar)":
                    case "dbar":
                        respuestan = 0.000980665 * number;
                        break;

                    case  "psi(pounds_per_square_inch)":
                    case "psi":
                        respuestan = 0.0014223343334 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;



            case  "decibar(dbar)":
            case "dbar":
                switch (unidadesto) {

                    case  "atm(standard_atmosphere)":
                    case "atm":
                        respuestan = 0.098692316 * number;
                        break;

                    case  "bar":
                        respuestan = 0.1 * number;
                        break;

                    case "inHg(inches_of_mercury_0C)":
                    case "inhg":

                        respuestan = 2.952998307 * number;
                        break;

                    case "inH2O(inches_of_water_4C)":
                    case "inh2o":
                        respuestan = 40.146307867 * number;
                        break;

                    case "kPa(kilopascal)":
                    case "kPa":
                        respuestan = 10 * number;
                        break;

                    case "Pa(pascal)":
                    case "Pa":
                        respuestan = 10000 * number;
                        break;

                    case "hPa(hectopascal)":
                    case "hPa":
                        respuestan = 100 * number;
                        break;

                    case "Torr":
                    case "torr":
                        respuestan = 75.006167382 * number;
                        break;

                    case  "mbar(milibar)":
                    case "mbar":
                        respuestan = 100 * number;
                        break;

                    case  "mmHg(milimeter_of_mercury_0C)":
                    case "mmhg":
                        respuestan = 75.00615613  * number;
                        break;

                    case  "mmH2O(milimeter_of_water_4C)":
                    case "mmh2o":
                        respuestan = 1019.716213 * number;
                        break;

                    case  "decibar(dbar)":
                    case "dbar":
                        respuestan = 1 * number;
                        break;

                    case  "psi(pounds_per_square_inch)":
                    case "psi":
                        respuestan = 1.450377380 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;


            case  "psi(pounds_per_square_inch)":
            case "psi":
                switch (unidadesto) {

                    case  "atm(standard_atmosphere)":
                    case "atm":
                        respuestan = 0.068045957064 * number;
                        break;

                    case  "bar":
                        respuestan =  0.068947572  * number;
                        break;

                    case "inHg(inches_of_mercury_0C)":
                    case "inhg":

                        respuestan =  2.036020657 * number;
                        break;

                    case "inH2O(inches_of_water_4C)":
                    case "inh2o":
                        respuestan = 27.679904843 * number;
                        break;

                    case "kPa(kilopascal)":
                    case "kPa":
                        respuestan = 6.89475728 * number;
                        break;

                    case "Pa(pascal)":
                    case "Pa":
                        respuestan = 6894.75728 * number;
                        break;

                    case "hPa(hectopascal)":
                    case "hPa":
                        respuestan = 68.9475728 * number;
                        break;

                    case "Torr":
                    case "torr":
                        respuestan =  51.71493186 * number;
                        break;

                    case  "mbar(milibar)":
                    case "mbar":
                        respuestan = 68.9475728 * number;
                        break;

                    case  "mmHg(milimeter_of_mercury_0C)":
                    case "mmhg":
                        respuestan = 51.714924102  * number;
                        break;

                    case  "mmH2O(milimeter_of_water_4C)":
                    case "mmh2o":
                        respuestan =  703.0695783 * number;
                        break;

                    case  "decibar(dbar)":
                    case "dbar":
                        respuestan = 0.689475728 * number;
                        break;

                    case  "psi(pounds_per_square_inch)":
                    case "psi":
                        respuestan = 1 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;


            default:
                respuestan = Double.parseDouble(errorunits);

        }
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
        otherSymbols.setDecimalSeparator('.');
        otherSymbols.setGroupingSeparator(',');

        DecimalFormat numberFormat = new DecimalFormat("#.####",otherSymbols);
        respuestastr = String.valueOf(numberFormat.format(respuestan));
        return respuestastr;

    }
}
