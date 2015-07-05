package com.example.artofnumbers;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.location.GpsStatus;
import android.os.Handler;
import android.sax.StartElementListener;
import android.support.v7.app.ActionBarActivity;

import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;


public class MainActivity extends Activity {



    private static final String[] UNIDADES = new String[] {

            "l(liter)","m3(cubic_meter)","gal(US_gallon)","cm3(cubic_centimeter)"
       ,"ml(milliliter)","hl(hectoliter)","barrel(US)","ft3(cubic_foot)",
            "in3(cubic inch)","microliter","oz(US_liquid_ounce)",

    "g(gram)","kg(kilogram)", "lb(pound)","ton(metric_ton)","mg(milligram)","ounce",

    "cm(centimeter)","ft(feet)","in(inch)", "km(kilometer)", "m(meter)", "mi(mile)", "mm(millimeter)", "yd(yard)",

    "hp(horsepower_international)","kW(kilowatt)","W(Watt)","ton(refrigeration)",

    "atm(standard_atmosphere)","bar","inHg(inches_of_mercury_0C)","inH2O(inches_of_water_4C)","kPa(kilopascal)","Pa(pascal)",
    "hPa(hectopascal)","Torr",
    "mbar(milibar)","mmHg(milimeter_of_mercury_0C)","mmH2O(milimeter_of_water_4C)","decibar(dbar)","psi(pounds_per_square_inch)",

   "Celcius","Fahrenheit","Rankine","Kelvin",

    "BTU(British thermal unit)","j(joule)","cal(calorie)","kcal(kilocalorie)","kj(kilojoule)",

    "ms(millisecond)","s(second)","min(minute)","h(hour)","d(day)","month","yr(year)",

    "help",

    "Mass","Volume","Time","Energy","Length","Power","Pressure","Temperature"};

    public final static String EXTRA_MESSAGE = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_main);


// ATENCION TODO LO QUE ESTA DENTRO DE ESTE COMENTARIO ES DE LA BASE DE DATOS

final DatabaseHand dbcerebro = new DatabaseHand(this);
        dbcerebro.borraLaspreguntasviejas();
        dbcerebro.borraLasrespuestasviejas();


         ArrayList<String> respuestastodas = dbcerebro.getAllrespuestas();
        ArrayList<String> preguntastodas = dbcerebro.getAllpreguntas();



//*******************AQUI TERMINA LA SECCION DE LA BASE DE DATOS *****************



//Atencion textView (multiautocompletext) es declarado final

       final MultiAutoCompleteTextView textView = (MultiAutoCompleteTextView)findViewById(R.id.auto);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, UNIDADES);


       final ListView resultados = (ListView) findViewById(R.id.list);
        final ListView preguntas = (ListView) findViewById(R.id.list2);

        resultados.setAdapter(new CustomListAdapter2(respuestastodas,this));
        preguntas.setAdapter(new CustomListAdapter1(preguntastodas,this));

// HACIENDO LOS LISTVIEW QUE SE PUEDAN APRETAR

        resultados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {


                        String previously = textView.getText().toString();
                        String item = resultados.getItemAtPosition(position).toString();
                        String novotexto = previously+item;
                        char[] resultadoatextview = novotexto.toCharArray();
                        textView.setText(resultadoatextview, 0, resultadoatextview.length);
                        textView.setText(textView.getText(), TextView.BufferType.NORMAL);
                        textView.setSelection(textView.getText().length());

                    }
                });

        preguntas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {


                String previously = textView.getText().toString();
                String item = preguntas.getItemAtPosition(position).toString();
                String novotexto = previously+item;
                char [] preguntaatextview = novotexto.toCharArray();
                textView.setText(preguntaatextview,0,preguntaatextview.length);
                textView.setText(textView.getText(), TextView.BufferType.NORMAL);
                textView.setSelection(textView.getText().length());



            }
        });
// FIN DE HACIENDO LOS LISTVIEW QUE SE PUEDAN APRETAR

//LEE EL AUTOCOMPLETE EN BUSCA DEL TOKEN PARA ESTE CASO ES UN ESPACIO
        textView.setTokenizer(new MultiAutoCompleteTextView.Tokenizer() {
            @Override
            public int findTokenStart(CharSequence text, int cursor) {
                int i = cursor;
                while (i > 0 && text.charAt(i - 1) != ' ') {
                    i--;
                }
                while (i < cursor && text.charAt(i) == ' ') {
                    i++;
                }
                return i;
            }

            @Override
            public int findTokenEnd(CharSequence text, int cursor) {
                int i = cursor;
                int len = text.length();

                while (i < len) {
                    if (text.charAt(i) == ' ') {
                        return i;
                    } else {
                        i++;
                    }
                }

                return len;
            }


            @Override
            public CharSequence terminateToken(CharSequence text) {
                int i = text.length();

                while (i > 0 && text.charAt(i - 1) == ' ') {
                    i--;
                }

                if (i > 0 && text.charAt(i - 1) == ' ') {
                    return text;
                } else {
                    if (text instanceof Spanned) {

//                        AQUI SE PUEDE MEJORAR A QUE SALGA AUTOMATICAMENTE EL ESPACIO Y NO SE DEBA ESCRIBIR

                        SpannableStringBuilder sp = new SpannableStringBuilder(text);
                        TextUtils.copySpansFrom((Spanned) text, 0, text.length(),
                                Object.class, sp, 0);
                        String result = sp.toString();
                        return result;
                    } else {
                        String result2 = text.toString();
                        return result2;
                    }
                }
            }
        });

        textView.setAdapter(adapter);


        final Button botonigual = (Button) findViewById(R.id.botonaso);




        textView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {


                if (actionId == EditorInfo.IME_ACTION_GO) {


                    dbcerebro.borraLaspreguntasviejas();
                    dbcerebro.borraLasrespuestasviejas();

                    String informacion = textView.getText().toString();
                   
                    StringBuilder comando1 = new StringBuilder();
                    StringBuilder numeros = new StringBuilder();
                    StringBuilder unidades = new StringBuilder();
                    StringBuilder unidadesto = new StringBuilder();

                    char[] texto = new char[informacion.length()];
                    informacion.getChars(0, informacion.length(), texto, 0);

                    int i;
                    int ii;
                    int iii;
                    int iv;


                    for (i = 0; i < texto.length; i++) {

                        for (iv = i; iv < texto.length; iv++) {

                            comando1.append(texto[iv]).toString();
                        }


                        String comando = comando1.toString();
                        ComandoReader comandoreader = new ComandoReader(comando);
                        String comandoleido = comandoreader.identificaQueEs(comando);


                        switch (comandoleido) {
                            case "q":

                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(0);
                                break;

                            case "c":
                                dbcerebro.deleteTodasPreguntas();
                                dbcerebro.deleteTodasRespuestas();
                                ArrayList<String> respuestastodas2 = dbcerebro.getAllrespuestas();
                                ArrayList<String> preguntastodas2 = dbcerebro.getAllpreguntas();
                                resultados.setAdapter(new CustomListAdapter2(respuestastodas2, MainActivity.this));
                                preguntas.setAdapter(new CustomListAdapter1(preguntastodas2, MainActivity.this));

                                break;

                            case "help":


                                Intent intentayuda = new Intent(MainActivity.this, DisplayMessageActivity.class);

                                String textoayuda = getResources().getString(R.string.help);
                                intentayuda.putExtra(EXTRA_MESSAGE, textoayuda);
                                startActivity(intentayuda);
                                break;

                            case "suma":
                            case "resta":
                            case "multiplicacion":
                            case "division":


                                Calculadora calculadora = new Calculadora(comandoleido, comando);

                                String respuesto1 = calculadora.calcula(comandoleido, comando);
                                String pregunto1 = comando;

//                ATENCION MANEJO DE LA BASE DE DATOS
                                dbcerebro.addRespuesta(new RespuestaClass(respuesto1));
                                ArrayList<String> respuestastodas1 = dbcerebro.getAllrespuestas();

                                dbcerebro.addPregunta(new PreguntaClass(pregunto1));
                                ArrayList<String> preguntastodas1 = dbcerebro.getAllpreguntas();


//          FIN DE SECCION MANEJO DE DATOS EN LA BASE
                                TextView resultado1 = (TextView) findViewById(R.id.resultado);
                                ListView resultados1 = (ListView) findViewById(R.id.list);
                                ListView preguntas1 = (ListView) findViewById(R.id.list2);

//                Ver anotaciones al final de clase convertidor, es mejor colocar las fraces
//                "is equivalente to" en la clase convertidor para tener versatilidad en respuestas
                                resultado1.setText(pregunto1 + " = " + respuesto1);
                                resultados1.setAdapter(new CustomListAdapter2(respuestastodas1, MainActivity.this));
                                preguntas1.setAdapter(new CustomListAdapter1(preguntastodas1, MainActivity.this));
                                i = texto.length;
                                break;

                            case "tablero":

                                convertidor conversor1 = new convertidor(comando);
                                ArrayList<String> key = conversor1.convierte1(comando);


                                String mensaje = "Type the number and choose the" + " "+ comando + " "+ "units";


                                TextView resultado11 = (TextView) findViewById(R.id.resultado);
                                resultado11.setText(mensaje);

                                ListView resultados11 = (ListView) findViewById(R.id.list);
                                ListView preguntas11 = (ListView) findViewById(R.id.list2);

                                resultados11.setAdapter(new CustomListAdapter3(key , MainActivity.this));
                                preguntas11.setAdapter(new CustomListAdapter4(key , MainActivity.this));


                                break;

                            default:

//                               DESDE AQUI BORRA ***********************

//                                LA REVISION DE CUANTOS ESPACIOS TIENE

                                int vi;
                                int posespacio = 0;
                                int locker1 = 0;
                                int contadorespacio=0;
                                for (vi = 0; vi < texto.length; vi++) {

                                    if (texto[vi] == ' ') {

                                        contadorespacio = contadorespacio + 1;

                                        if (locker1 == 0) {

                                                posespacio = vi;
                                                locker1 = 1;

                                        }
                                    }

                                }
//                                HASTA AQUI REVISO CUANTOS EASPACIOS TIENE

//                                AQUI INICIARA UNA EVALUACION DE SI TIENE UN SOLO ESPACIO EL COMANDO PARA PODER GENERAR
//                                LOS METODOS DE UN SOLO ESPACIO DE LISTAS

                                if (contadorespacio == 1){



                                    StringBuilder numerounespacio = new StringBuilder();
                                    StringBuilder comandounespacio = new StringBuilder();
                                    int vii ;
                                    int viii;

                                    for (vii = 0; vii < posespacio ; vii++) {

                                        numerounespacio.append(texto[vii]).toString();

                                    }

                                    for (viii = posespacio+1 ; viii < texto.length ; viii++) {

                                        comandounespacio.append(texto[viii]).toString();

                                    }

                                    String stringnumeroespacio = numerounespacio.toString();
                                    String stringcomandounespacio = comandounespacio.toString();





                                    convertidor conversor2 = new convertidor(stringnumeroespacio, stringcomandounespacio);
                                    ArrayList<String> key2 = conversor2.convierte2(stringnumeroespacio, stringcomandounespacio);


                                        String mensaje2 = "Choose the" + " "+ comandounespacio + " "+ "units";


                                    TextView resultado2 = (TextView) findViewById(R.id.resultado);
                                    resultado2.setText(mensaje2);

                                    ListView resultados2 = (ListView) findViewById(R.id.list);
                                    ListView preguntas2 = (ListView) findViewById(R.id.list2);

                                    resultados2.setAdapter(new CustomListAdapter3(key2 , MainActivity.this));
                                    preguntas2.setAdapter(new CustomListAdapter4(key2 , MainActivity.this));

                                }

                                else {



//                                HASTA AQUI BORRA ********************************************


                                    if (texto[i] != ' ') {
                                        numeros.append(texto[i]).toString();
                                    } else {


                                        for (ii = i + 1; ii <= texto.length; ii++) {
                                            if (texto[ii] != ' ') {


                                                unidades.append(texto[ii]).toString();

                                            } else {


//LO QUE ESTA ADENTRO DE ESTE FOR ES EL TEXTO ORGINAL
                                                for (iii = ii + 1; iii < texto.length; iii++) {

                                                    unidadesto.append(texto[iii]).toString();
                                                }

                                                i = texto.length;
                                                String numero = numeros.toString();
                                                String unidad = unidades.toString();
                                                String unidadto = unidadesto.toString();
                                                convertidor conversor = new convertidor(numero, unidad, unidadto);

                                                String respuesto = conversor.convierte(numero, unidad, unidadto);
                                                String pregunto = numero + " " + unidad + " " + unidadto;

//                ATENCION MANEJO DE LA BASE DE DATOS
                                                dbcerebro.addRespuesta(new RespuestaClass(respuesto));
                                                ArrayList<String> respuestastodas = dbcerebro.getAllrespuestas();

                                                dbcerebro.addPregunta(new PreguntaClass(pregunto));
                                                ArrayList<String> preguntastodas = dbcerebro.getAllpreguntas();


//          FIN DE SECCION MANEJO DE DATOS EN LA BASE
                                                TextView resultado = (TextView) findViewById(R.id.resultado);
                                                ListView resultados = (ListView) findViewById(R.id.list);
                                                ListView preguntas = (ListView) findViewById(R.id.list2);

//                Ver anotaciones al final de clase convertidor, es mejor colocar las fraces
//                "is equivalente to" en la clase convertidor para tener versatilidad en respuestas
                                                resultado.setText(numeros + " " + unidades + " " + "is equivalent to" + " " + respuesto + " " + unidadesto);
                                                resultados.setAdapter(new CustomListAdapter2(respuestastodas, MainActivity.this));
                                                preguntas.setAdapter(new CustomListAdapter1(preguntastodas, MainActivity.this));


// HASTA AQUI PROBABLEMNTE SINO DA UN ERROR DE LLAVES
                                                break;


                                            }
                                        }
                                    }
                                }
                        }
                    }
                    textView.setText("");
                    return true;
                }
                return false;
            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

public void sendMessage(View view){

    Intent intentayuda = new Intent (this, DisplayMessageActivity.class);
    TextView mensajeayuda = (TextView) findViewById(R.id.ayuda);
    String textoayuda = mensajeayuda.getText().toString();
    intentayuda.putExtra(EXTRA_MESSAGE, textoayuda);
    startActivity(intentayuda);
}
}
