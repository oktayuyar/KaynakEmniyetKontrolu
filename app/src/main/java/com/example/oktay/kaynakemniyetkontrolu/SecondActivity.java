package com.example.oktay.kaynakemniyetkontrolu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;


public class SecondActivity extends AppCompatActivity {
    private EditText edtkuvvet,edtcekme,edtegilme,edtkayma,edtemniyet;
    Integer gelenKuvvet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        edtkuvvet=(EditText)findViewById(R.id.edtkuvvet);
        edtcekme=(EditText)findViewById(R.id.edtcekme);
        edtegilme=(EditText)findViewById(R.id.edtegilme);
        edtkayma=(EditText)findViewById(R.id.edtkayma);
        edtemniyet=(EditText)findViewById(R.id.edtemniyet);

        edtkuvvet.setText(getIntent().getExtras().getString("veri")+"  Newton");
        gelenKuvvet = Integer.parseInt((getIntent().getExtras().getString("veri")));


    }
}
