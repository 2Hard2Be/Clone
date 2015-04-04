package com.example.artofnumbers;

/**
 * Created by Peto-1 on 4/1/2015.
 */
public class Energia {

    public Double number;
    public String unidades;
    public String unidadesto;

    public Energia (Double vienenumber, String vieneunidades, String vieneunidadesto) {

        Double number = vienenumber;
        String unidades = vieneunidades;
        String unidadesto = vieneunidadesto;

    }

    public Energia(Double vienenumber, String vieneunidades) {

        Double number = vienenumber;
        String unidades = vieneunidades;

    }

    public  String calculaUnaEnergia(Double valor, String units, String unitst) {

        number = valor;
        unidades = units;
        unidadesto = unitst;
        Double respuestan;
        String respuestastr;
        String errorto = "0.000";
        String errorunits = "0.0000";

        switch (unidades) {

            case  "BTU(British thermal unit)":
            case "btu":
            case "BTU":

                switch (unidadesto) {
                    case  "BTU(British thermal unit)":
                    case "btu":
                    case "BTU":

                        respuestan = 1 * number;
                        break;

                    case "j(joule)":
                    case "j":
                    case "joule":
                        respuestan = 1055.0559 * number;
                        break;


                    case "cal(calorie)":
                    case "cal":
                    case "Cal":

                        respuestan =   252.164401 * number;
                        break;

                    case "kcal(kilocalorie)":
                    case "kcal":
                        respuestan = 0.252164412 * number;
                        break;

                    case "kj(kilojoule)":
                    case "kj":
                        respuestan = 1.0550559 * number;
                        break;



                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "j(joule)":
            case "j":
            case "joule":

                switch (unidadesto) {
                    case  "BTU(British thermal unit)":
                    case "btu":
                    case "BTU":

                        respuestan =  0.000947817077 * number;
                        break;

                    case "j(joule)":
                    case "j":
                    case "joule":
                        respuestan = 1 * number;
                        break;


                    case "cal(calorie)":
                    case "cal":
                    case "Cal":

                        respuestan = 0.239005736 * number;
                        break;

                    case "kcal(kilocalorie)":
                    case "kcal":
                        respuestan = 0.000239005736 * number;
                        break;

                    case "kj(kilojoule)":
                    case "kj":
                        respuestan = 0.001 * number;
                        break;



                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "cal(calorie)":
            case "cal":
            case "Cal":

                switch (unidadesto) {
                    case  "BTU(British thermal unit)":
                    case "btu":
                    case "BTU":

                        respuestan =  0.003965666 * number;
                        break;

                    case "j(joule)":
                    case "j":
                    case "joule":
                        respuestan = 4.184 * number;
                        break;


                    case "cal(calorie)":
                    case "cal":
                    case "Cal":

                        respuestan = 1 * number;
                        break;

                    case "kcal(kilocalorie)":
                    case "kcal":
                        respuestan = 0.001 * number;
                        break;

                    case "kj(kilojoule)":
                    case "kj":
                        respuestan =  0.004184 * number;
                        break;



                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "kcal(kilocalorie)":
            case "kcal":

                switch (unidadesto) {
                    case  "BTU(British thermal unit)":
                    case "btu":
                    case "BTU":

                        respuestan = 3.9656666533 * number;
                        break;

                    case "j(joule)":
                    case "j":
                    case "joule":
                        respuestan = 4184 * number;
                        break;


                    case "cal(calorie)":
                    case "cal":
                    case "Cal":

                        respuestan = 1000 * number;
                        break;

                    case "kcal(kilocalorie)":
                    case "kcal":
                        respuestan = 1 * number;
                        break;

                    case "kj(kilojoule)":
                    case "kj":
                        respuestan =  4.184 * number;
                        break;

                    default:
                        respuestan = Double.parseDouble(errorto);

                }
                break;

            case "kj(kilojoule)":
            case "kj":

                switch (unidadesto) {
                    case  "BTU(British thermal unit)":
                    case "btu":
                    case "BTU":

                        respuestan =  0.947817077 * number;
                        break;

                    case "j(joule)":
                    case "j":
                    case "joule":
                        respuestan = 1000 * number;
                        break;


                    case "cal(calorie)":
                    case "cal":
                    case "Cal":

                        respuestan = 239.00573614 * number;
                        break;

                    case "kcal(kilocalorie)":
                    case "kcal":
                        respuestan = 0.239005736 * number;
                        break;

                    case "kj(kilojoule)":
                    case "kj":
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
