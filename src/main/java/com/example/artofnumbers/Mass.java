package com.example.artofnumbers;

/**
 * Created by Peto-1 on 3/1/2015.
 */
public class Mass {

    public Double number;
    public String unidades;
    public String unidadesto;

    public Mass(Double vienenumber, String vieneunidades, String vieneunidadesto) {

        Double number = vienenumber;
        String unidades = vieneunidades;
        String unidadesto = vieneunidadesto;

    }

    public Mass(Double vienenumber, String vieneunidades) {

        Double number = vienenumber;
        String unidades = vieneunidades;

    }

    public  String calculaUnaMasa(Double valor, String units, String unitst) {

        number = valor;
        unidades = units;
        unidadesto = unitst;
        Double respuestan;
        String respuestastr;
        String errorto = "0.000";
        String errorunits = "0.0000";

        switch (unidades) {

            case "g(gram)":
            case "gm":
            case "g":
                switch (unidadesto) {
                    case "g(gram)":
                    case "gm":
                    case "g":
                        respuestan = 1 * number;
                        break;

                    case "kg(kilogram)":
                    case "kg":
                        respuestan =  0.001 * number;
                        break;
                    case "lb(pound)":
                    case "lb":
                    case "lbs":
                        respuestan = 0.0022046 * number;
                        break;
                    case "ton(metric_ton)":
                    case "ton":

                        respuestan = 0.000001 * number;
                        break;
                    case "mg(milligram)":
                    case "mg":
                        respuestan = 1000 * number;
                        break;
                    case "ounce":

                        respuestan =  0.035273 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "kg(kilogram)":
            case "kg":
                switch (unidadesto) {
                    case "g(gram)":
                    case "gm":
                    case "g":
                        respuestan = 1000 * number;
                        break;

                    case "kg(kilogram)":
                    case "kg":
                        respuestan =  1 * number;
                        break;
                    case "lb(pound)":
                    case "lb":
                    case "lbs":
                        respuestan = 2.204622 * number;
                        break;
                    case "ton(metric_ton)":
                    case "ton":

                        respuestan = 0.001 * number;
                        break;
                    case "mg(milligram)":
                    case "mg":
                        respuestan = 1000000 * number;
                        break;
                    case "ounce":

                        respuestan =  35.273961 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "lb(pound)":
            case "lb":
            case "lbs":
                switch (unidadesto) {
                    case "g(gram)":
                    case "gm":
                    case "g":
                        respuestan = 453.59237 * number;
                        break;

                    case "kg(kilogram)":
                    case "kg":
                        respuestan =  0.453592 * number;
                        break;
                    case "lb(pound)":
                    case "lb":
                    case "lbs":
                        respuestan = 1 * number;
                        break;
                    case "ton(metric_ton)":
                    case "ton":

                        respuestan =  0.000453 * number;
                        break;
                    case "mg(milligram)":
                    case "mg":
                        respuestan = 453592.37 * number;
                        break;
                    case "ounce":

                        respuestan =  16 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "ton(metric_ton)":
            case "ton":
                switch (unidadesto) {
                    case "g(gram)":
                    case "gm":
                    case "g":
                        respuestan = 1000000 * number;
                        break;

                    case "kg(kilogram)":
                    case "kg":
                        respuestan =  1000 * number;
                        break;
                    case "lb(pound)":
                    case "lb":
                    case "lbs":
                        respuestan = 2204.622621 * number;
                        break;
                    case "ton(metric_ton)":
                    case "ton":

                        respuestan =  1 * number;
                        break;
                    case "mg(milligram)":
                    case "mg":
                        respuestan = 1000000000 * number;
                        break;
                    case "ounce":

                        respuestan =  35273.961 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "mg(milligram)":
            case "mg":
                switch (unidadesto) {
                    case "g(gram)":
                    case "gm":
                    case "g":
                        respuestan = 0.001 * number;
                        break;

                    case "kg(kilogram)":
                    case "kg":
                        respuestan =   0.000001 * number;
                        break;
                    case "lb(pound)":
                    case "lb":
                    case "lbs":
                        respuestan = 0.000002204 * number;
                        break;
                    case "ton(metric_ton)":
                    case "ton":

                        respuestan =  1.0e-9 * number;
                        break;
                    case "mg(milligram)":
                    case "mg":
                        respuestan = 1 * number;
                        break;
                    case "ounce":

                        respuestan =  0.000035274 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "ounce":

                switch (unidadesto) {
                    case "g(gram)":
                    case "gm":
                    case "g":
                        respuestan =  28.349523 * number;
                        break;

                    case "kg(kilogram)":
                    case "kg":
                        respuestan =    0.028349 * number;
                        break;
                    case "lb(pound)":
                    case "lb":
                    case "lbs":
                        respuestan = 0.0625 * number;
                        break;
                    case "ton(metric_ton)":
                    case "ton":

                        respuestan =  0.000028 * number;
                        break;
                    case "mg(milligram)":
                    case "mg":
                        respuestan = 28349.523125 * number;
                        break;
                    case "ounce":

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
