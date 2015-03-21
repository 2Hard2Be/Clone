package com.example.artofnumbers;

/**
 * Created by Peto-1 on 3/4/2015.
 */
public class Longitud {

    public Double number;
    public String unidades;
    public String unidadesto;

    public Longitud (Double vienenumber, String vieneunidades, String vieneunidadesto) {

        Double number = vienenumber;
        String unidades = vieneunidades;
        String unidadesto = vieneunidadesto;

    }

    public Longitud(Double vienenumber, String vieneunidades) {

        Double number = vienenumber;
        String unidades = vieneunidades;

    }

    public  String calculaUnaLongitud(Double valor, String units, String unitst) {

        number = valor;
        unidades = units;
        unidadesto = unitst;
        Double respuestan;
        String respuestastr;
        String errorto = "0.000";
        String errorunits = "0.0000";

        switch (unidades) {

            case  "cm(centimeter)":
            case "cm":

                switch (unidadesto) {
                    case "cm(centimeter)":
                    case "cm":

                        respuestan = 1 * number;
                        break;

                    case "ft(feet)":
                    case "ft":
                        respuestan =  0.032808 * number;
                        break;


                    case "in(inch)":
                    case "in":
                        respuestan =  0.393700 * number;
                        break;

                    case "km(kilometer)":
                    case "km":

                        respuestan = 0.00001 * number;
                        break;
                    case "m(meter)":
                    case "m":
                        respuestan = 0.01 * number;
                        break;

                    case "mi(mile)":
                    case "mi":
                    case "mile":
                    case "miles":

                        respuestan =   0.0000062 * number;
                        break;

                    case "mm(millimeter)":
                    case "mm":

                        respuestan =   10 * number;
                        break;

                    case "yd(yard)":
                    case "yd":

                        respuestan =   0.010936 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case  "ft(feet":
            case "ft":

                switch (unidadesto) {
                    case "cm(centimeter)":
                    case "cm":

                        respuestan = 30.48 * number;
                        break;

                    case "ft(feet)":
                    case "ft":
                        respuestan =  1 * number;
                        break;


                    case "in(inch)":
                    case "in":
                        respuestan =  12 * number;
                        break;

                    case "km(kilometer)":
                    case "km":

                        respuestan = 0.0003048 * number;
                        break;
                    case "m(meter)":
                    case "m":
                        respuestan = 0.3048 * number;
                        break;
                    case "mi(mile)":
                    case "mi":
                    case "mile":
                    case "miles":

                        respuestan =   0.000189393 * number;
                        break;

                    case "mm(millimeter)":
                    case "mm":

                        respuestan =   304.8 * number;
                        break;

                    case "yd(yard)":
                    case "yd":

                        respuestan =   0.333333 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "in(inch)":
            case "in":

                switch (unidadesto) {
                    case "cm(centimeter)":
                    case "cm":

                        respuestan = 2.54 * number;
                        break;

                    case "ft(feet)":
                    case "ft":
                        respuestan =   0.083333333 * number;
                        break;


                    case "in(inch)":
                    case "in":
                        respuestan =  1 * number;
                        break;

                    case "km(kilometer)":
                    case "km":

                        respuestan =  0.0000254 * number;
                        break;
                    case "m(meter)":
                    case "m":
                        respuestan = 0.0254 * number;
                        break;
                    case "mi(mile)":
                    case "mi":
                    case "mile":
                    case "miles":

                        respuestan =    0.000015782 * number;
                        break;

                    case "mm(millimeter)":
                    case "mm":

                        respuestan =   25.4 * number;
                        break;

                    case "yd(yard)":
                    case "yd":

                        respuestan =    0.027777777 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "km(kilometer)":
            case "km":

                switch (unidadesto) {
                    case "cm(centimeter)":
                    case "cm":

                        respuestan = 100000 * number;
                        break;

                    case "ft(feet)":
                    case "ft":
                        respuestan =   3280.839895  * number;
                        break;


                    case "in(inch)":
                    case "in":
                        respuestan =  39370.07874 * number;
                        break;

                    case "km(kilometer)":
                    case "km":

                        respuestan =  1 * number;
                        break;
                    case "m(meter)":
                    case "m":
                        respuestan = 1000 * number;
                        break;
                    case "mi(mile)":
                    case "mi":
                    case "mile":
                    case "miles":

                        respuestan =     0.621371192 * number;
                        break;

                    case "mm(millimeter)":
                    case "mm":

                        respuestan =   1000000 * number;
                        break;

                    case "yd(yard)":
                    case "yd":

                        respuestan = 1093.6132983 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "m(meter)":
            case "m":

                switch (unidadesto) {
                    case "cm(centimeter)":
                    case "cm":

                        respuestan = 100 * number;
                        break;

                    case "ft(feet)":
                    case "ft":
                        respuestan =   3.280839895  * number;
                        break;


                    case "in(inch)":
                    case "in":
                        respuestan =   39.37007874 * number;
                        break;

                    case "km(kilometer)":
                    case "km":

                        respuestan =  0.001 * number;
                        break;
                    case "m(meter)":
                    case "m":
                        respuestan = 1 * number;
                        break;
                    case "mi(mile)":
                    case "mi":
                    case "mile":
                    case "miles":

                        respuestan = 0.000621371 * number;
                        break;

                    case "mm(millimeter)":
                    case "mm":

                        respuestan =   1000 * number;
                        break;

                    case "yd(yard)":
                    case "yd":

                        respuestan = 1.093613298 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "mi(mile)":
            case "mi":
            case "mile":
            case "miles":

                switch (unidadesto) {
                    case "cm(centimeter)":
                    case "cm":

                        respuestan = 160934.4 * number;
                        break;

                    case "ft(feet)":
                    case "ft":
                        respuestan =   5280  * number;
                        break;


                    case "in(inch)":
                    case "in":
                        respuestan =   63360 * number;
                        break;

                    case "km(kilometer)":
                    case "km":

                        respuestan =  1.609344 * number;
                        break;
                    case "m(meter)":
                    case "m":
                        respuestan = 1609.344 * number;
                        break;
                    case "mi(mile)":
                    case "mi":
                    case "mile":
                    case "miles":

                        respuestan = 1 * number;
                        break;

                    case "mm(millimeter)":
                    case "mm":

                        respuestan =   1609344 * number;
                        break;

                    case "yd(yard)":
                    case "yd":

                        respuestan = 1760 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "mm(millimeter)":
            case "mm":

                switch (unidadesto) {
                    case "cm(centimeter)":
                    case "cm":

                        respuestan = 0.1 * number;
                        break;

                    case "ft(feet)":
                    case "ft":
                        respuestan =   0.003280839  * number;
                        break;


                    case "in(inch)":
                    case "in":
                        respuestan =   0.039370078 * number;
                        break;

                    case "km(kilometer)":
                    case "km":

                        respuestan =   0.000001 * number;
                        break;
                    case "m(meter)":
                    case "m":
                        respuestan = 0.001 * number;
                        break;
                    case "mi(mile)":
                    case "mi":
                    case "mile":
                    case "miles":

                        respuestan = 6.2137119224e-7 * number;
                        break;

                    case "mm(millimeter)":
                    case "mm":

                        respuestan =   1 * number;
                        break;

                    case "yd(yard)":
                    case "yd":

                        respuestan =  0.001093613 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "yd(yard)":
            case "yd":

                switch (unidadesto) {
                    case "cm(centimeter)":
                    case "cm":

                        respuestan = 91.44 * number;
                        break;

                    case "ft(feet)":
                    case "ft":
                        respuestan =   3  * number;
                        break;


                    case "in(inch)":
                    case "in":
                        respuestan =   36 * number;
                        break;

                    case "km(kilometer)":
                    case "km":

                        respuestan =   0.0009144 * number;
                        break;
                    case "m(meter)":
                    case "m":
                        respuestan = 0.9144 * number;
                        break;
                    case "mi(mile)":
                    case "mi":
                    case "mile":
                    case "miles":

                        respuestan =  0.000568181 * number;
                        break;

                    case "mm(millimeter)":
                    case "mm":

                        respuestan =   914.4 * number;
                        break;

                    case "yd(yard)":
                    case "yd":

                        respuestan =  1 * number;
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
