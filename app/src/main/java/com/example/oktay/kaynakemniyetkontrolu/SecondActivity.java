package com.example.oktay.kaynakemniyetkontrolu;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.*;

public class SecondActivity extends AppCompatActivity {
    private EditText edtcekme,edtegilme,edtkayma,edtemniyet;
    String sKuvvet,sYukseklik,sEn,sBoy,sAci,sSinir,sUzaklik,ssonucCekme,ssonucEgilme,ssonucKayma;
    double f,h,a,b,x,F,A,We,L,sinir,sonucCekme,sonucEgilme,sonucKayma,sonucKontrol,sonuc;
    Button btncekme,btnegilme,btnkayma,btnemniyet;
    TextView txtSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        edtcekme=(EditText)findViewById(R.id.edtcekme);
        edtegilme=(EditText)findViewById(R.id.edtegilme);
        edtkayma=(EditText)findViewById(R.id.edtkayma);
        edtemniyet=(EditText)findViewById(R.id.edtemniyet);
        txtSonuc=(TextView)findViewById(R.id.txtsonuc);

        sKuvvet=getIntent().getExtras().getString("kuvvet");
        sYukseklik=getIntent().getExtras().getString("yukseklik");
        sEn=getIntent().getExtras().getString("en");
        sBoy=getIntent().getExtras().getString("boy");
        sAci=getIntent().getExtras().getString("aci");
        sSinir=getIntent().getExtras().getString("sinir");
        sUzaklik=getIntent().getExtras().getString("kuzakligi");

        f=Double.parseDouble(sKuvvet);
        h=Double.parseDouble(sYukseklik);
        a=Double.parseDouble(sEn);
        b=Double.parseDouble(sBoy);
        x=Double.parseDouble(sAci);
        sinir=Double.parseDouble(sSinir);
        L=Double.parseDouble(sUzaklik);

        F=(f*(Math.cos(Math.toRadians(x))));
        A=(b+2*a)*(h+2*a)-(b*h);
        We=(b+2*a)*(h+(2*a))*(h+(2*a))*(h+(2*a)) / ((h+2*a)*6) - (b*Math.pow(h,2)/6);

        cekmeGerilimi();
        egilmeGerilimi();
        kaymaGerilimi();
        emniyetKontrolu();
        addButtonCekmeClickListener();
        addButtonEgilmeClickListener();
        addButtonKaymaClickListener();
        addButtonEmniyetClickListener();

    }

    private void cekmeGerilimi() {
        sonucCekme=F/A;
        edtcekme.setText(Double.toString(sonucCekme).toString());
    }
    private void egilmeGerilimi(){
        sonucEgilme=((f*(Math.sin(Math.toRadians(x))))*L)/We;
        edtegilme.setText(Double.toString(sonucEgilme).toString());
    }
    private void kaymaGerilimi() {
        sonucKayma=f*(Math.sin(Math.toRadians(x)))/A;
        edtkayma.setText(Double.toString(sonucKayma).toString());
    }
    private void emniyetKontrolu() {
        sonucKontrol=(sonucEgilme+sonucCekme)*(sonucEgilme+sonucCekme) + 3*sonucKayma*sonucKayma;
        sonuc=Math.sqrt(sonucKontrol);
        edtemniyet.setText(Double.toString(sonuc).toString());
        if(sonuc<=sinir){
            txtSonuc.setText("kaynak dikişi tutar!");
        }
        else {
            txtSonuc.setText("kaynak dikişi tutmaz!");
        }
    }

    private void addButtonCekmeClickListener() {
        btncekme = (Button)findViewById(R.id.btncekme);
        btncekme.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new
                                Intent("com.example.oktay.kaynakemniyetkontrolu.CekmeActivity");
                        intent.putExtra("aci", sAci);
                        intent.putExtra("kuvvet", sKuvvet);
                        intent.putExtra("en", sEn);
                        intent.putExtra("boy", sBoy);
                        intent.putExtra("yukseklik", sYukseklik);
                        startActivity(intent);
                    }
                }
        );
    }

    private void addButtonEgilmeClickListener() {
        btnegilme = (Button)findViewById(R.id.btnegilme);
        btnegilme.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new
                                Intent("com.example.oktay.kaynakemniyetkontrolu.EgilmeActivity");
                        intent.putExtra("aci", sAci);
                        intent.putExtra("kuvvet", sKuvvet);
                        intent.putExtra("en", sEn);
                        intent.putExtra("boy", sBoy);
                        intent.putExtra("yukseklik", sYukseklik);
                        intent.putExtra("uzaklik", sUzaklik);
                        startActivity(intent);
                    }
                }
        );
    }

    private void addButtonKaymaClickListener() {
        btnkayma = (Button)findViewById(R.id.btnkayma);
        btnkayma.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new
                                Intent("com.example.oktay.kaynakemniyetkontrolu.KaymaActivity");
                        intent.putExtra("aci", sAci);
                        intent.putExtra("kuvvet", sKuvvet);
                        intent.putExtra("en", sEn);
                        intent.putExtra("boy", sBoy);
                        intent.putExtra("yukseklik", sYukseklik);
                        intent.putExtra("uzaklik", sUzaklik);
                        startActivity(intent);
                    }
                }
        );
    }

    private void addButtonEmniyetClickListener() {
        btnemniyet = (Button)findViewById(R.id.btnemniyet);
        btnemniyet.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new
                                Intent("com.example.oktay.kaynakemniyetkontrolu.EmniyetActivity");
                        intent.putExtra("sCekme", Double.toString(sonucCekme).toString());
                        intent.putExtra("sEgilme", Double.toString(sonucEgilme).toString());
                        intent.putExtra("sKayma",  Double.toString(sonucKayma).toString());
                        intent.putExtra("sonuc",  Double.toString(sonuc).toString());
                        intent.putExtra("sinir", sSinir);
                        startActivity(intent);
                    }
                }
        );
    }
}

