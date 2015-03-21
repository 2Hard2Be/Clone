package com.example.artofnumbers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Peto-1 on 2/18/2015.
 */
public class convertidor {

    public String cifra;
    public String unidad;
    public String unidadto;
    public String respuestastring;

    public convertidor(String vienecifra, String vieneunidad) {

        String cifra = vienecifra;
        String unidad = vieneunidad;

    }

    public convertidor(String vienecifra, String vieneunidad, String vieneunidadto) {

        String cifra = vienecifra;
        String unidad = vieneunidad;
        String unidadto = vieneunidadto;


    }
//Por el momento solo volumen, agregar switchboard para elegir unidades u
// y detro un if en cada entrada del switch para descartar unidades desconocidas en el else interno
// para elegir entre unidades y dimensiones

    public String convierte(String c, String u, String uto) {

        cifra = c;
        unidad = u;
        unidadto = uto;


        Double numero = Double.valueOf(cifra);

        switch (unidad) {
//    volumen
            case "l":
            case "l(liter)":
            case "lt":
            case "m3":
            case "m3(cubic_meter)":
            case "gal":
            case "gal(US_gallon)":
            case "cm3":
            case "cm3(cubic_centimeter)":
            case "ml":
            case "ml(milliliter)":
            case "cc":
            case "hl(hectoliter)":
            case "hl":
            case "barrel(US)":
            case "barrel":
            case "ft3(cubic_foot)":
            case "ft3":
            case "in3(cubic inch)":
            case "in3":
            case "microliter":
            case "ul":
            case "oz(US_liquid_ounce)":
            case "oz":

//                HashSet contine los parametros para evaluar las unidades to
                  final Set<String> valuesv = new HashSet<String>(Arrays.asList("l","l(liter)","lt","m3","m3(cubic_meter)",
                          "gal","gal(US_gallon)","cm3","cm3(cubic_centimeter)","ml","ml(milliliter)","cc","hl(hectoliter)",
                          "hl","barrel(US)","barrel","ft3(cubic_foot)","ft3","in3(cubicinch)","in3","microliter","ul",
                          "oz(US_liquid_ounce)","oz"));

                if (valuesv.contains(unidadto)) {

                    Volumen volumetrickey = new Volumen(numero, unidad, unidadto);
                    respuestastring = volumetrickey.calculaUnVolumen(numero, unidad, unidadto);

                } else {
                    respuestastring = "Unknown units to convert";
                }
                break;
//      MASA
            case "g(gram)":
            case "gm":
            case "g":
            case "kg(kilogram)":
            case "kg":
            case "lb":
            case "lbs":
            case "lb(pound)":
            case "ton(metric_ton)":
            case "ton":
            case "mg(milligram)":
            case "ounce":
            case "mg":


//                HashSet contine los parametros para evaluar las unidades to
                final Set<String> valuesm = new HashSet<String>(Arrays.asList("g(gram)","gm","g","kg(kilogram)","kg","lb","lbs",
                        "lb(pound)","ton","mg",
                        "ton(metric_ton)","mg(milligram)","ounce"));

                if (valuesm.contains(unidadto)) {

                    Mass masstrickey = new Mass(numero, unidad, unidadto);
                    respuestastring = masstrickey.calculaUnaMasa(numero, unidad, unidadto);

                } else {
                    respuestastring = "Unknown units to convert";
                }
                break;
//      LONGITUD

            case "cm(centimeter)":
            case "cm":
            case "ft(feet)":
            case "ft":
            case "in(inch)":
            case "in":
            case "km(kilometer)":
            case "km":
            case "m(meter)":
            case "m":
            case "mi(mile)":
            case "mi":
            case "mile":
            case "miles":
            case "mm(millimeter)":
            case "mm":
            case "yd(yard)":
            case "yd":


//                HashSet contine los parametros para evaluar las unidades to
                final Set<String> valuesl = new HashSet<String>(Arrays.asList("cm(centimeter)","cm",
                        "ft(feet)","ft","in(inch)","in","km(kilometer)","km","m(meter)","m",
                        "mi(mile)","mi","mile","miles","mm(millimeter)","mm","yd(yard)","yd"));

                if (valuesl.contains(unidadto)) {

                    Longitud longitudtrickey = new Longitud(numero, unidad, unidadto);
                    respuestastring = longitudtrickey.calculaUnaLongitud(numero, unidad, unidadto);

                } else {
                    respuestastring = "Unknown units to convert";
                }
                break;

//        POTENCIA


            case  "hp(horsepower_international)":
            case "hp":
            case "kW(kilowatt)":
            case "kw":
            case "kW":
            case "Watt":
            case "W(Watt)":
            case "W":
            case "w":
            case "ton(refrigeration)":


//                HashSet contine los parametros para evaluar las unidades to
                final Set<String> valuespower = new HashSet<String>(Arrays.asList("hp(horsepower_international)","hp",
                        "kW(kilowatt)",
                        "kw","kW","Watt","W(Watt)","W","w","ton(refrigeration)"));

                if (valuespower.contains(unidadto)) {

                    Potencia potenciatrickey = new Potencia(numero, unidad, unidadto);
                    respuestastring = potenciatrickey.calculaUnaPotencia(numero, unidad, unidadto);

                } else {
                    respuestastring = "Unknown units to convert";
                }
                break;
            default:

                respuestastring =  "Unknown units";
        }





//Evaluar si conviene mejor colocar aqui las respuestas del string como y no en main para que tenga
//        versatilidad en el texto resultado
        return respuestastring;

    }

}
