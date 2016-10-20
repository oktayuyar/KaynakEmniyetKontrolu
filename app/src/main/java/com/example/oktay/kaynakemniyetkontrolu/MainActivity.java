package com.example.oktay.kaynakemniyetkontrolu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnHesapla,btnIncele;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onclick();
    }

    private void onclick() {
        btnHesapla=(Button)findViewById(R.id.button);
        btnHesapla.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.oktay.kaynakemniyetkontrolu.SecondActivity");
                        startActivity(intent);
                    }
                }
        );
    }


}