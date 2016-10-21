package com.example.oktay.kaynakemniyetkontrolu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.oktay.kaynakemniyetkontrolu.SecondActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnHesapla;
    private EditText edtKuvvet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtKuvvet=(EditText)findViewById(R.id.editText);
        onclick();
    }

    private void onclick() {
        btnHesapla=(Button)findViewById(R.id.button);
        btnHesapla.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.oktay.kaynakemniyetkontrolu.SecondActivity");
                        intent.putExtra("veri", edtKuvvet.getText().toString());
                        startActivity(intent);
                    }
                }
        );
    }


}
