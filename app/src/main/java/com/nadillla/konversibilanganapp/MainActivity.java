package com.nadillla.konversibilanganapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textAngka;
    EditText editText;

    Button btnKonv;
    String bilang = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textAngka =  findViewById(R.id.tvAngka);
        editText = findViewById(R.id.edAngka);
        btnKonv = findViewById(R.id.btnkon);

        btnKonv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                konversi();
            }
        });

        }




    private void konversi() {
        int angka = 0;
        try{
            angka = Integer.parseInt(editText.getText().toString());

        }catch (NumberFormatException e){
            Log.d("TAG", "konversi: gagal");
        }


        String[] ribu = {"","Seribu","Dua Ribu","Tiga Ribu","Empat Ribu","Lima Ribu","Enam Ribu","Tujuh Ribu","Delapan Ribu","Sembilan Ribu"};
        String[] ratus = {"","Seratus","Dua Ratus","Tiga Ratus","Empat Ratus","Lima Ratus","Enam Ratus","Tujuh Ratus","Delapan Ratus"," Sembilan Ratus"};
        String[] puluh = {"", "Belas", " Dua Puluh", " Tiga Puluh", " Empat Puluh", " Lima Puluh", " Enam Puluh", " Tujuh Puluh", " Delapan Puluh", " Sembilan Puluh"};
        String[] satuan = {"", " Satu", " Dua", " Tiga", " Empat", " Lima", " Enam", " Tujuh", " Delapan", " Sembilan"};
//        String[] juta = {"","Sejuta","Dua Juta","Tiga Juta","Lima Juta","Enam Juta","Tujuh Juta","Delapan Juta","Sembilan Juta"};
//        String[] miliar = {"","Miliar","Dua Miliar","Tiga Miliar","Lima Miliar","Enam Miliar","Tujuh Miliar","Delapan Miliar","Sembilan Miliar"};
//        String[] triliun = {"","Triliun","Dua Triliun","Tiga Triliun","Lima Triliun","Enam Triliun","Tujuh Triliun","Delapan Triliun","Sembilan Triliun"};

        if(angka<9999&& angka>0){
            int tr,mr,jt,rt,rb,pl,st;


            rb = angka/1000;
            rt = (angka%1000)/100;
            pl = (angka%100)/10;
            st = angka%10;

            if(pl==1){
                if(st==1){
                   bilang = ribu[rb] + ratus[rt] + "Se" + puluh[pl];
                }else if(st==0){
                   bilang= ribu[rb] + ratus[rt] + " Sepuluh";
                }else {
                    bilang = ribu[rb] + ratus[rt] + satuan[st] + puluh[pl];
                }
            } else {
               bilang= ribu[rb] + ratus[rt] + puluh[pl] + satuan[st];
            }
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),"Error, Mencapai batas maksimum",Toast.LENGTH_SHORT);
            toast.show();
                }

        textAngka.setText(bilang);


    }








    }
