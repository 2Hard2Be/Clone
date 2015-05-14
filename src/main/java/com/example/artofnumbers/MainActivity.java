package com.example.artofnumbers;

import android.app.Activity;
import android.app.ListActivity;
import android.location.GpsStatus;
import android.sax.StartElementListener;
import android.support.v7.app.ActionBarActivity;

import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

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

    "millisecond","s(second)","min(minute)","hr(hour)","d(day)","month","yr(year)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// ATENCION TODO LO QUE ESTA DENTRO DE ESTE COMENTARIO ES DE LA BASE DE DATOS

final DatabaseHand dbcerebro = new DatabaseHand(this);
        dbcerebro.borraLaspreguntasviejas();
        dbcerebro.borraLasrespuestasviejas();


//*******************AQUI TERMINA LA SECCION DE LA BASE DE DATOS *****************



//Atencion textView (multiautocompletext) es declarado final

       final MultiAutoCompleteTextView textView = (MultiAutoCompleteTextView)findViewById(R.id.auto);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, UNIDADES);


//LEE EL AUTOCOMPLETE EN BUSCA DEL TOKEN PARA ESTE CASO ES UN ESPACIO
        textView.setTokenizer(new MultiAutoCompleteTextView.Tokenizer() {
            @Override
            public int findTokenStart(CharSequence text, int cursor) {
               int i = cursor;
                while (i>0 && text.charAt(i-1)!=' '){
                    i--;
                }
               while (i < cursor && text.charAt(i)== ' '){
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



final Button botonigual = (Button)findViewById(R.id.botonaso);
        botonigual.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                dbcerebro.borraLaspreguntasviejas();
                dbcerebro.borraLasrespuestasviejas();

            String informacion = textView.getText().toString();
            StringBuilder numeros = new StringBuilder();
            StringBuilder unidades = new StringBuilder();
            StringBuilder unidadesto = new StringBuilder();

                char[] texto = new char[informacion.length()];
                informacion.getChars(0, informacion.length(),texto, 0 );

                int i;
                int ii;
                int iii;

                for (i = 0; i < texto.length; i++) {
                    if (texto[i] != ' ') {
                        numeros.append(texto[i]).toString();
                    }
                    else {


                        for (ii = i+1; ii < texto.length; ii++){
                           if(texto[ii] != ' ') {
                               unidades.append(texto[ii]).toString();
                           }
                            else{


                        for (iii = ii+1; iii < texto.length; iii++) {

                            unidadesto.append(texto[iii]).toString();
                        }

                            i = texto.length;
                            String numero = numeros.toString();
                            String unidad = unidades.toString();
                            String unidadto = unidadesto.toString();
                            convertidor conversor = new convertidor(numero, unidad, unidadto);

                            String respuesto = conversor.convierte(numero, unidad, unidadto);
                            String pregunto = numero + " " + unidad + " to " + unidadto;

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
                            resultados.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, respuestastodas));
                            preguntas.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, preguntastodas));
                            break;


    }}

                }
                }

            }});

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
}
