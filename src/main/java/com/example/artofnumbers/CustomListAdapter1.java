package com.example.artofnumbers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Peto-1 on 5/21/2015.
 */
public class CustomListAdapter1 extends ArrayAdapter<String> {

    private List<String> Lista1;
    private Context context;

    public CustomListAdapter1(List<String> Lista1, Context ctx){

        super(ctx, R.layout.row_layout1, Lista1);
        this.Lista1 = Lista1;
        this.context = ctx;
    }

    public View getView(int position, View convertView, ViewGroup parent){


//        verificando si contexto no es null
        if(convertView==null){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =inflater.inflate(R.layout.row_layout1, parent, false);
        }

//        Rellenando layout con los valores correctos

        TextView textView = (TextView)convertView.findViewById(R.id.layoutpreg);
        String pregunta = Lista1.get(position);
        textView.setText(pregunta);

        return convertView;

    }


}
