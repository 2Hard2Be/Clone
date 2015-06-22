package com.example.artofnumbers;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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

//           PRESION

            case  "atm(standard_atmosphere)":
            case "atm":
            case  "bar":
            case "inHg(inches_of_mercury_0C)":
            case "inhg":
            case "inH2O(inches_of_water_4C)":
            case "inh2o":
            case "kPa(kilopascal)":
            case "kPa":
            case "Pa(pascal)":
            case "Pa":
            case "hPa(hectopascal)":
            case "hPa":
            case "Torr":
            case "torr":
            case  "mbar(milibar)":
            case "mbar":
            case  "mmHg(milimeter_of_mercury_0C)":
            case "mmhg":
            case  "mmH2O(milimeter_of_water_4C)":
            case "mmh2o":
            case  "decibar(dbar)":
            case "dbar":
            case  "psi(pounds_per_square_inch)":
            case "psi":


//                HashSet contine los parametros para evaluar las unidades to
                final Set<String> valuespressure = new HashSet<String>(Arrays.asList("atm(standard_atmosphere)",
                        "atm","bar","inHg(inches_of_mercury_0C)","inhg","inH2O(inches_of_water_4C)",
                        "inh2o","kPa(kilopascal)","kPa","Pa(pascal)","Pa","hPa(hectopascal)","hPa",
                        "Torr","torr","mbar(milibar)","mbar","mmHg(milimeter_of_mercury_0C)","mmhg",
                        "mmH2O(milimeter_of_water_4C)","mmh2o","decibar(dbar)","dbar",
                        "psi(pounds_per_square_inch)","psi"));

                if (valuespressure.contains(unidadto)) {

                    Presion presiontrickey = new Presion(numero, unidad, unidadto);
                    respuestastring = presiontrickey.calculaUnaPresion(numero, unidad, unidadto);

                } else {
                    respuestastring = "Unknown units to convert";
                }
                break;


//            TEMPERATURA

            case  "Celcius":
            case "c":
            case "Fahrenheit":
            case "f":
            case "Rankine":
            case "r":
            case "Kelvin":
            case "k":


//                HashSet contine los parametros para evaluar las unidades to
                final Set<String> valuestemperatura = new HashSet<String>(Arrays.asList("Celcius","c",
                        "Fahrenheit","f","Rankine","r","Kelvin","k"));

                if (valuestemperatura.contains(unidadto)) {

                    Temperatura temperaturatrickey = new Temperatura(numero, unidad, unidadto);
                    respuestastring = temperaturatrickey.calculaUnaTemperatura(numero, unidad, unidadto);

                } else {
                    respuestastring = "Unknown units to convert";
                }
                break;


//            Energia


            case  "BTU(British thermal unit)":
            case "btu":
            case "BTU":
            case "j(joule)":
            case "j":
            case "joule":
            case "cal(calorie)":
            case "cal":
            case "Cal":
            case "kcal(kilocalorie)":
            case "kcal":
            case "kj(kilojoule)":
            case "kj":


//                HashSet contine los parametros para evaluar las unidades to
                final Set<String> valuesenergia = new HashSet<String>(Arrays.asList("BTU(Britishthermalunit)",
                        "btu","BTU","j(joule)","j","joule","cal(calorie)","cal","Cal","kcal(kilocalorie)",
                        "kcal","kj(kilojoule)","kj"));

                if (valuesenergia.contains(unidadto)) {

                    Energia energiatrickey = new Energia(numero, unidad, unidadto);
                    respuestastring = energiatrickey.calculaUnaEnergia(numero, unidad, unidadto);

                } else {
                    respuestastring = "Unknown units to convert";
                }
                break;

            //            Tiempo


            case  "ms(millisecond)":
            case "msec":
            case "ms":
            case "s(second)":
            case "s":
            case "sec":
            case "min(minute)":
            case "min":
            case "h(hour)":
            case "hr":
            case "h":
            case "d(day)":
            case "d":
            case "month":
            case "yr(year)":
            case "year":
            case "yr":


//                HashSet contine los parametros para evaluar las unidades to
                final Set<String> valuestiempo = new HashSet<String>(Arrays.asList("ms(millisecond)",
                        "msec","ms","s(second)","s","sec","min(minute)","min","h(hour)","hr","h",
                        "d(day)","d","month","yr(year)","year","yr"));

                if (valuestiempo.contains(unidadto)) {

                    Tiempo tiempotrickey = new Tiempo(numero, unidad, unidadto);
                    respuestastring = tiempotrickey.calculaUnTiempo(numero, unidad, unidadto);

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


    public String convierte1(String c, String u) {

//        El constructor de solo dos argumentos devolvera el string correspondiente de la magnitud deseada mediante
//       switch , ese string sera el que disparara la lista deseada dentro de
//        main, el cual ejecutara el llamado a la lista de unidades de esa magnitud para las unidades de la cifra
//        al dar clic debera enviar la seleccionada a la pantalla y desplegar la otra lista de las unidades a convertir
//        al dar clic a la segunda lista se desplegara la respuesta, posiblemente se necesite otra clase para manejar listas unicamente
//        probar si al mismo tiempo se colocan mensajes de instrucciones en una de las pantallas, por ejemplo
//        para "select units for the data"
//        antes validar que la primera String c, sea realmente un numero para no perder el tiempo

        cifra = c;
        unidad = u;
        Double numero = Double.valueOf(cifra);
        switch (unidad) {

            case "mass":
            case "Mass":
                respuestastring = "masa";
                break;

            case "Volume":
            case "volume":
                respuestastring = "volumen";
                break;

            case "Energy":
            case "energy":
                respuestastring = "energia";
                break;

            case "Length":
            case "length":
                respuestastring = "longitud";
                break;

            case "Power":
            case "power":
                respuestastring= "potencia";
                break;

            case "Pressure":
            case "pressure":
                respuestastring= "presion";
                break;

            case "Temperature":
            case "temperature":
                respuestastring = "temperatura";
                break;

            case "Time":
            case "time":
                respuestastring = "tiempo";
                break;

            default:
                respuestastring = "more than two";
        }
        return respuestastring;
    }
}
