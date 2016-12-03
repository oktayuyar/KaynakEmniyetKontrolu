package com.example.oktay.kaynakemniyetkontrolu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EmniyetActivity extends AppCompatActivity {
    TextView txtsonucEgilme,txtsonucCekme,txtsonucKayma,txtsinir,txtSonuc;
    String sSonuc,sSinir;
    double sonuc,sinir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emniyet);

        txtsonucEgilme=(TextView)findViewById(R.id.txtegilme);
        txtsonucCekme=(TextView)findViewById(R.id.txtcekme);
        txtsonucKayma=(TextView)findViewById(R.id.txtkayma);
        txtsinir=(TextView)findViewById(R.id.txtsinir);
        txtSonuc=(TextView)findViewById(R.id.txtSonuc);

        txtsonucEgilme.setText(getIntent().getExtras().getString("sCekme"));
        txtsonucCekme.setText(getIntent().getExtras().getString("sEgilme"));
        txtsonucKayma.setText(getIntent().getExtras().getString("sKayma"));
        txtsinir.setText(getIntent().getExtras().getString("sinir"));

        sSonuc=getIntent().getExtras().getString("sonuc");
        sSinir=getIntent().getExtras().getString("sinir");

        sonuc=Double.parseDouble(sSonuc);
        sinir=Double.parseDouble(sSinir);
        if(sonuc<=sinir){
            txtSonuc.setText(sSonuc+" <= "+sSinir+  "\nkaynak dikişi tutar!");
        }
        else {
            txtSonuc.setText(sSonuc+" > "+sSinir+  "\nkaynak dikişi tutmaz!");
        }
    }
}
