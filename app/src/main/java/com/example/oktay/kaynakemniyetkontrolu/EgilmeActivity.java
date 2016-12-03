package com.example.oktay.kaynakemniyetkontrolu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EgilmeActivity extends AppCompatActivity {
    TextView txtaci,txtf,txta,txtb,txth,txtl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egilme);


        txtaci=(TextView)findViewById(R.id.txtaci);
        txtf=(TextView)findViewById(R.id.txtkuvvet);
        txta=(TextView)findViewById(R.id.txta);
        txtb=(TextView)findViewById(R.id.txtb);
        txth=(TextView)findViewById(R.id.txth);
        txtl=(TextView)findViewById(R.id.txtL);

        txtaci.setText(getIntent().getExtras().getString("aci"));
        txtf.setText(getIntent().getExtras().getString("kuvvet"));
        txta.setText(getIntent().getExtras().getString("en"));
        txtb.setText(getIntent().getExtras().getString("boy"));
        txth.setText(getIntent().getExtras().getString("yukseklik"));
        txtl.setText(getIntent().getExtras().getString("uzaklik"));
    }
}
