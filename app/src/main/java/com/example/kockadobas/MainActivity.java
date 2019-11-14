package com.example.kockadobas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnDobas;
    private AlertDialog alertDialog;
    private AlertDialog.Builder alertDialogBuilder;
    private TextView txtEredmeny;
    private ImageView imgJatekos,imgGep;
    private Random rand;
    private int jatekosPontszam,gepPontszam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        btnDobas.setOnClickListener(this);
    }

    private void init(){
        btnDobas=findViewById(R.id.Dobas);
        txtEredmeny=findViewById(R.id.Eredmeny);
        imgJatekos=findViewById(R.id.JatekosKocka);
        imgGep=findViewById(R.id.GepKocka);
        jatekosPontszam=0;
        gepPontszam=0;
        rand = new Random();
        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

    }

    @Override
    public void onClick(View v) {



       int dobas1 =  rand.nextInt(6);
       if(dobas1==1){
           imgJatekos.setImageResource(R.drawable.kocka1);
       }
       else if(dobas1==2){
           imgJatekos.setImageResource(R.drawable.kocka2);
       }
       else if(dobas1==3){
           imgJatekos.setImageResource(R.drawable.kocka3);
       }
       else if(dobas1==4){
           imgJatekos.setImageResource(R.drawable.kocka4);
       }
       else if(dobas1==5){
           imgJatekos.setImageResource(R.drawable.kocka5);
       }
       else{
           imgJatekos.setImageResource(R.drawable.kocka6);
       }


        int dobas2 =  rand.nextInt(6);
        if(dobas2==1){
            imgGep.setImageResource(R.drawable.kocka1);
        }
        else if(dobas2==2){
            imgGep.setImageResource(R.drawable.kocka2);
        }
        else if(dobas2==3){
            imgGep.setImageResource(R.drawable.kocka3);
        }
        else if(dobas2==4){
            imgGep.setImageResource(R.drawable.kocka4);
        }
        else if(dobas2==5){
            imgGep.setImageResource(R.drawable.kocka5);
        }
        else{
            imgGep.setImageResource(R.drawable.kocka6);
        }

        String uzenet = "";
        if (dobas1>dobas2){
            jatekosPontszam++;
        }
        else if(dobas2>dobas1){
            gepPontszam++;
        }


        txtEredmeny.setText(String.format("Eredmény: Gép: %d - Játékos: %d",
                gepPontszam, jatekosPontszam));

        if(jatekosPontszam==3)
        {
            alertDialogBuilder.setTitle("Gratulálok Nyertél!!");
            alertDialogBuilder.setMessage("Újra akarod kezdeni a játékot?");
            alertDialogBuilder.setPositiveButton("igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    init();
                    txtEredmeny.setText(String.format("Eredmény: Gép: 0 - Játékos: 0"));
                }
            });
            alertDialogBuilder.setNegativeButton("nem", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alertDialogBuilder.setCancelable(false);
            alertDialog=alertDialogBuilder.create();
            alertDialog.show();
        }
        else if(gepPontszam==3){

            alertDialogBuilder.setTitle("Sajnos vesztettél!!");
            alertDialogBuilder.setMessage("Újra akarod kezdeni a játékot?");
            alertDialogBuilder.setPositiveButton("igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    init();
                    txtEredmeny.setText(String.format("Eredmény: Gép: 0 - Játékos: 0"));
                }
            });
            alertDialogBuilder.setNegativeButton("nem", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alertDialogBuilder.setCancelable(false);
            alertDialog=alertDialogBuilder.create();
            alertDialog.show();

        }

    }
}
