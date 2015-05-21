package com.example.artofnumbers;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class DisplayMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        "@android:style/Theme.Translucent.NoTitleBar"
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        super.onCreate(savedInstanceState);


        Intent intent = getIntent();
        String Message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textview = new TextView(this);


        textview.setTextSize(getResources().getDimension(R.dimen.tamanoletras));


        textview.setText(Message);

        setContentView(textview);

    }



}
