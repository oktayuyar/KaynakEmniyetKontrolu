package com.example.oktay.kaynakemniyetkontrolu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oktay.kaynakemniyetkontrolu.SecondActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnHesapla;
    private EditText edtkuvvet,edtyukseklik,edten,edtboy,edtaci,edtsinir,edtuzaklik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtkuvvet=(EditText)findViewById(R.id.edtkuvvet);
        edtyukseklik=(EditText)findViewById(R.id.edtkesit);
        edten=(EditText)findViewById(R.id.edten);
        edtboy=(EditText)findViewById(R.id.edtboy);
        edtaci=(EditText)findViewById(R.id.edtaci);
        edtsinir=(EditText)findViewById(R.id.edtsinir);
        edtuzaklik=(EditText)findViewById(R.id.edtuzaklik);


        onclick();
    }

    public void onclick() {
        btnHesapla=(Button)findViewById(R.id.button);
        btnHesapla.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!edtkuvvet.getText().toString().equals("")&& !edtyukseklik.getText().toString().equals("")
                                && !edten.getText().toString().equals("")&& !edtboy.getText().toString().equals("")
                                && !edtaci.getText().toString().equals("") && !edtsinir.getText().toString().equals("")
                                && !edtuzaklik.getText().toString().equals("")){

                            Intent intent = new Intent("com.example.oktay.kaynakemniyetkontrolu.SecondActivity");
                            intent.putExtra("kuvvet", edtkuvvet.getText().toString());
                            intent.putExtra("yukseklik", edtyukseklik.getText().toString());
                            intent.putExtra("en", edten.getText().toString());
                            intent.putExtra("boy", edtboy.getText().toString());
                            intent.putExtra("aci", edtaci.getText().toString());
                            intent.putExtra("sinir", edtsinir.getText().toString());
                            intent.putExtra("kuzakligi", edtuzaklik.getText().toString());
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(MainActivity.this,"Boş alan bırakamazsınız!!",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }


}
