package com.example.artofnumbers;

/**
 * Created by Peto-1 on 2/19/2015.
 */
public class Volumen {

    public Double number;
    public String unidades;
    public String unidadesto;

    public Volumen(Double vienenumber, String vieneunidades, String vieneunidadesto) {

        Double number = vienenumber;
        String unidades = vieneunidades;
        String unidadesto = vieneunidadesto;

    }

    public Volumen(Double vienenumber, String vieneunidades) {

        Double number = vienenumber;
        String unidades = vieneunidades;

    }

    public  String calculaUnVolumen(Double valor, String units, String unitst) {

        number = valor;
        unidades = units;
        unidadesto = unitst;
        Double respuestan;
        String respuestastr;
        String errorto = "0.000";
        String errorunits = "0.0000";

        switch (unidades) {

            case "l":
            case "l(liter)":
            case "lt":
                switch (unidadesto) {
                    case "l":
                    case "l(liter)":
                    case "lt":
                        respuestan = 1 * number;
                        break;
                    case "m3":
                    case "m3(cubic_meter)":
                              respuestan = 0.001 * number;
                        break;
                    case "gal":
                    case "gal(US_gallon)":
                        respuestan = 0.2641 * number;
                        break;
                    case "cm3":
                    case "cm3(cubic_centimeter)":
                    case "ml":
                    case "ml(milliliter)":
                    case "cc":
                        respuestan = 1000 * number;
                        break;
                    case "hl(hectoliter)":
                    case "hl":
                        respuestan = 0.01 * number;
                        break;
                    case "barrel(US)":
                    case "barrel":
                        respuestan = 0.0083864 * number;
                        break;
                    case "ft3(cubic_foot)":
                    case "ft3":
                        respuestan =  0.0353147 * number;
                        break;
                    case "in3(cubic inch)":
                    case "in3":
                        respuestan =  61.023744 * number;
                        break;
                    case "microliter":
                    case "ul":
                        respuestan =  1000000 * number;
                        break;
                    case "oz(US_liquid_ounce)":
                    case "oz":
                        respuestan =  33.814022 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                 break;

            case "m3":
            case "m3(cubic_meter)":
                switch (unidadesto) {
                    case "l":
                    case "l(liter)":
                    case "lt":
                        respuestan = 1000 * number;
                        break;
                    case "m3":
                    case "m3(cubic_meter)":
                        respuestan = 1 * number;
                        break;
                    case "gal":
                    case "gal(US_gallon)":
                        respuestan = 264.172052 * number;
                        break;
                    case "cm3":
                    case "cm3(cubic_centimeter)":
                    case "ml":
                    case "ml(milliliter)":
                    case "cc":
                        respuestan = 1000000 * number;
                        break;
                    case "hl(hectoliter)":
                    case "hl":
                        respuestan = 10 * number;
                        break;
                    case "barrel(US)":
                    case "barrel":
                        respuestan = 8.386414 * number;
                        break;
                    case "ft3(cubic_foot)":
                    case "ft3":
                        respuestan =  35.314666 * number;
                        break;
                    case "in3(cubic inch)":
                    case "in3":
                        respuestan =  61023.744095 * number;
                        break;
                    case "microliter":
                    case "ul":
                        respuestan =  1000000000  * number;
                        break;
                    case "oz(US_liquid_ounce)":
                    case "oz":
                        respuestan =  33814.022701 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);
                }
                break;

            case "gal":
            case "gal(US_gallon)":
                switch (unidadesto) {
                    case "l":
                    case "l(liter)":
                    case "lt":
                        respuestan = 3.785411 * number;
                        break;
                    case "m3":
                    case "m3(cubic_meter)":
                        respuestan =  0.003785 * number;
                        break;
                    case "gal":
                    case "gal(US_gallon)":
                        respuestan = 1 * number;
                        break;
                    case "cm3":
                    case "cm3(cubic_centimeter)":
                    case "ml":
                    case "ml(milliliter)":
                    case "cc":
                        respuestan = 3785.411784 * number;
                        break;
                    case "hl(hectoliter)":
                    case "hl":
                        respuestan =  0.037854 * number;
                        break;
                    case "barrel(US)":
                    case "barrel":
                        respuestan = 0.031746 * number;
                        break;
                    case "ft3(cubic_foot)":
                    case "ft3":
                        respuestan =   0.133680 * number;
                        break;
                    case "in3(cubic inch)":
                    case "in3":
                        respuestan =  231 * number;
                        break;
                    case "microliter":
                    case "ul":
                        respuestan =   3785411.784  * number;
                        break;
                    case "oz(US_liquid_ounce)":
                    case "oz":
                        respuestan =  128 * number;
                        break;
                    default:
                        respuestan = Double.parseDouble(errorto);
                }
                break;
            case "cm3":
            case "cm3(cubic_centimeter)":
            case "ml":
            case "ml(milliliter)":
            case "cc":
                switch (unidadesto) {
                    case "l":
                    case "l(liter)":
                    case "lt":
                        respuestan = 0.001 * number;
                        break;
                    case "m3":
                    case "m3(cubic_meter)":
                        respuestan =  0.000001 * number;
                        break;
                    case "gal":
                    case "gal(US_gallon)":
                        respuestan = 0.000264 * number;
                        break;
                    case "cm3":
                    case "cm3(cubic_centimeter)":
                    case "ml":
                    case "ml(milliliter)":
                    case "cc":
                        respuestan = 1 * number;
                        break;
                    case "hl(hectoliter)":
                    case "hl":
                        respuestan =  0.00001 * number;
                        break;
                    case "barrel(US)":
                    case "barrel":
                        respuestan = 0.000008386414 * number;
                        break;
                    case "ft3(cubic_foot)":
                    case "ft3":
                        respuestan =   0.000035 * number;
                        break;
                    case "in3(cubic inch)":
                    case "in3":
                        respuestan =   0.061023 * number;
                        break;
                    case "microliter":
                    case "ul":
                        respuestan =   1000  * number;
                        break;
                    case "oz(US_liquid_ounce)":
                    case "oz":
                        respuestan =  0.033814 * number;
                        break;
                    default:
                        respuestan = Double.parseDouble(errorto);
                }
                break;

            case "hl(hectoliter)":
            case "hl":
                switch (unidadesto) {
                    case "l":
                    case "l(liter)":
                    case "lt":
                        respuestan = 100 * number;
                        break;
                    case "m3":
                    case "m3(cubic_meter)":
                        respuestan =  0.1 * number;
                        break;
                    case "gal":
                    case "gal(US_gallon)":
                        respuestan = 26.417205 * number;
                        break;
                    case "cm3":
                    case "cm3(cubic_centimeter)":
                    case "ml":
                    case "ml(milliliter)":
                    case "cc":
                        respuestan = 100000 * number;
                        break;
                    case "hl(hectoliter)":
                    case "hl":
                        respuestan =  1 * number;
                        break;
                    case "barrel(US)":
                    case "barrel":
                        respuestan =  0.838641 * number;
                        break;
                    case "ft3(cubic_foot)":
                    case "ft3":
                        respuestan =   3.531466 * number;
                        break;
                    case "in3(cubic inch)":
                    case "in3":
                        respuestan =   6102.374409 * number;
                        break;
                    case "microliter":
                    case "ul":
                        respuestan =   100000000  * number;
                        break;
                    case "oz(US_liquid_ounce)":
                    case "oz":
                        respuestan =   3381.402270 * number;
                        break;
                    default:
                        respuestan = Double.parseDouble(errorto);
                }
                break;
            case "barrel(US)":
            case "barrel":
                switch (unidadesto) {
                    case "l":
                    case "l(liter)":
                    case "lt":
                        respuestan =  119.240471 * number;
                        break;
                    case "m3":
                    case "m3(cubic_meter)":
                        respuestan =   0.119240 * number;
                        break;
                    case "gal":
                    case "gal(US_gallon)":
                        respuestan = 31.500000 * number;
                        break;
                    case "cm3":
                    case "cm3(cubic_centimeter)":
                    case "ml":
                    case "ml(milliliter)":
                    case "cc":
                        respuestan = 119240.4712 * number;
                        break;
                    case "hl(hectoliter)":
                    case "hl":
                        respuestan =   1.192404 * number;
                        break;
                    case "barrel(US)":
                    case "barrel":
                        respuestan =  1 * number;
                        break;
                    case "ft3(cubic_foot)":
                    case "ft3":
                        respuestan =    4.210937 * number;
                        break;
                    case "in3(cubic inch)":
                    case "in3":
                        respuestan =   7276.500000 * number;
                        break;
                    case "microliter":
                    case "ul":
                        respuestan =   119240471.2  * number;
                        break;
                    case "oz(US_liquid_ounce)":
                    case "oz":
                        respuestan =   4032.000000 * number;
                        break;
                    default:
                        respuestan = Double.parseDouble(errorto);
                }
                break;

            case "ft3(cubic_foot)":
            case "ft3":
                switch (unidadesto) {
                    case "l":
                    case "l(liter)":
                    case "lt":
                        respuestan =  28.316846 * number;
                        break;
                    case "m3":
                    case "m3(cubic_meter)":
                        respuestan =   0.028316 * number;
                        break;
                    case "gal":
                    case "gal(US_gallon)":
                        respuestan = 7.480519 * number;
                        break;
                    case "cm3":
                    case "cm3(cubic_centimeter)":
                    case "ml":
                    case "ml(milliliter)":
                    case "cc":
                        respuestan = 28316.846592 * number;
                        break;
                    case "hl(hectoliter)":
                    case "hl":
                        respuestan =   0.283168 * number;
                        break;
                    case "barrel(US)":
                    case "barrel":
                        respuestan =  0.237476 * number;
                        break;
                    case "ft3(cubic_foot)":
                    case "ft3":
                        respuestan =    1 * number;
                        break;
                    case "in3(cubic inch)":
                    case "in3":
                        respuestan =   1728.000 * number;
                        break;
                    case "microliter":
                    case "ul":
                        respuestan =   28316846.592  * number;
                        break;
                    case "oz(US_liquid_ounce)":
                    case "oz":
                        respuestan =    957.506493 * number;
                        break;
                    default:
                        respuestan = Double.parseDouble(errorto);
                }
                break;

            case "in3(cubic inch)":
            case "in3":
                switch (unidadesto) {
                    case "l":
                    case "l(liter)":
                    case "lt":
                        respuestan =  0.016387 * number;
                        break;
                    case "m3":
                    case "m3(cubic_meter)":
                        respuestan =   0.000016 * number;
                        break;
                    case "gal":
                    case "gal(US_gallon)":
                        respuestan =  0.004329 * number;
                        break;
                    case "cm3":
                    case "cm3(cubic_centimeter)":
                    case "ml":
                    case "ml(milliliter)":
                    case "cc":
                        respuestan = 16.387064 * number;
                        break;
                    case "hl(hectoliter)":
                    case "hl":
                        respuestan =    0.000163 * number;
                        break;
                    case "barrel(US)":
                    case "barrel":
                        respuestan =  0.000137 * number;
                        break;
                    case "ft3(cubic_foot)":
                    case "ft3":
                        respuestan =     0.000578 * number;
                        break;
                    case "in3(cubic inch)":
                    case "in3":
                        respuestan =   1 * number;
                        break;
                    case "microliter":
                    case "ul":
                        respuestan =   16387.064  * number;
                        break;
                    case "oz(US_liquid_ounce)":
                    case "oz":
                        respuestan =   0.554112 * number;
                        break;
                    default:
                        respuestan = Double.parseDouble(errorto);
                }
                break;
            case "microliter":
            case "ul":
                switch (unidadesto) {
                    case "l":
                    case "l(liter)":
                    case "lt":
                        respuestan =   0.000001 * number;
                        break;
                    case "m3":
                    case "m3(cubic_meter)":
                        respuestan =   1.0e-9 * number;
                        break;
                    case "gal":
                    case "gal(US_gallon)":
                        respuestan =  2.6417205236e-7 * number;
                        break;
                    case "cm3":
                    case "cm3(cubic_centimeter)":
                    case "ml":
                    case "ml(milliliter)":
                    case "cc":
                        respuestan = 0.001 * number;
                        break;
                    case "hl(hectoliter)":
                    case "hl":
                        respuestan =     1.0e-8 * number;
                        break;
                    case "barrel(US)":
                    case "barrel":
                        respuestan =  8.3864143603e-9 * number;
                        break;
                    case "ft3(cubic_foot)":
                    case "ft3":
                        respuestan =     3.5314666721e-8 * number;
                        break;
                    case "in3(cubic inch)":
                    case "in3":
                        respuestan =   0.0000610 * number;
                        break;
                    case "microliter":
                    case "ul":
                        respuestan =   1  * number;
                        break;
                    case "oz(US_liquid_ounce)":
                    case "oz":
                        respuestan =    0.000033814 * number;
                        break;
                    default:
                        respuestan = Double.parseDouble(errorto);
                }
                break;
            case "oz(US_liquid_ounce)":
            case "oz":
                switch (unidadesto) {
                    case "l":
                    case "l(liter)":
                    case "lt":
                        respuestan =    0.029573 * number;
                        break;
                    case "m3":
                    case "m3(cubic_meter)":
                        respuestan =    0.000029 * number;
                        break;
                    case "gal":
                    case "gal(US_gallon)":
                        respuestan =   0.007812 * number;
                        break;
                    case "cm3":
                    case "cm3(cubic_centimeter)":
                    case "ml":
                    case "ml(milliliter)":
                    case "cc":
                        respuestan =  29.573529 * number;
                        break;
                    case "hl(hectoliter)":
                    case "hl":
                        respuestan =      0.000295 * number;
                        break;
                    case "barrel(US)":
                    case "barrel":
                        respuestan =  0.000248 * number;
                        break;
                    case "ft3(cubic_foot)":
                    case "ft3":
                        respuestan =      0.001044 * number;
                        break;
                    case "in3(cubic inch)":
                    case "in3":
                        respuestan =    1.804687 * number;
                        break;
                    case "microliter":
                    case "ul":
                        respuestan =    29573.529563  * number;
                        break;
                    case "oz(US_liquid_ounce)":
                    case "oz":
                        respuestan =    1 * number;
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