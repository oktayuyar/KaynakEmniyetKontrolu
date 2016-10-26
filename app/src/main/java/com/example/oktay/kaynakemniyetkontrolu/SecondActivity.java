package com.example.oktay.kaynakemniyetkontrolu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.*;


public class SecondActivity extends AppCompatActivity {
    private EditText edtcekme,edtegilme,edtkayma,edtemniyet;
    String sKuvvet,sYukseklik,sEn,sBoy,sAci,sSinir,sUzaklik;
    double f,h,a,b,x,F,A,We,L,sinir,sonucCekme,sonucEgilme,sonucKayma,sonucKontrol,sonuc;
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


}