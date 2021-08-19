package com.example.me_net;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class feed  extends MainActivity
{
    private RecyclerView recy;
    private RecycleviewAdapter adap;
    
    String like [] = {"uuuyy que gusto tienes","esta muy apero","de vedad te gusta eso?","... oka"};

    ImageButton fe = findViewById(R.id.fee);
    ImageButton pe = findViewById(R.id.rec);
    ImageButton he = findViewById(R.id.heart);
    CardView cv = findViewById(R.id.cardoo);
    

    ConstraintLayout feedconst = findViewById(R.id.feedlayout);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed);

        recy = (RecyclerView) findViewById(R.id.rec);
        recy.setLayoutManager(new LinearLayoutManager(this));
        adap = new RecycleviewAdapter(mostrar());
        recy.setAdapter(adap);

        /// implementaciones de los metodos
        buttons();
        LF();

    }

    private void buttons()
    {
        //aqui va la funcion del swioe up recacrgar el swipe rigth para  ir al perfil

        fe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent il = new Intent(feed.this,PERFIL.class);
                startActivity(il);
            }
        });

        pe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pel = new Intent(feed.this,PERFIL.class);
                startActivity(pel);
            }
        });

    }
    private List<data> mostrar()
    {
        List<data> dat = new ArrayList<>();
        //aqui va la funcion de mostrar de los datos de Firebase



        return dat;
    }
    private void LF() //OPCIONAL
    {
        Random rand = new Random();
        int i = rand.nextInt(4);

        //aqui se implementara la funcion de like y follow

        ////////////////////////////////////LIKE////////////////////////////////////////////////////
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                he.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(),like[i],Toast.LENGTH_SHORT).show();
            }
        });

        ///////////////////////////////////FOLLOW///////////////////////////////////////////////////

        //esta en proceso de ser implementad



    }
/*
    private void descarrgar()
    {
        // to download file

        // Create a reference with an initial file path and name
        StorageReference pathReference = storageRef.child("images/stars.jpg");

        // Create a reference to a file from a Cloud Storage URI
        StorageReference gsReference = storage.getReferenceFromUrl("gs://bucket/images/stars.jpg");

        // Create a reference from an HTTPS URL
        // Note that in the URL, characters are URL escaped!
        StorageReference httpsReference = storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/b/bucket/o/images%20stars.jpg");
    }*/
}
