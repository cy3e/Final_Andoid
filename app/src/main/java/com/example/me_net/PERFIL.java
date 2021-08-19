package com.example.me_net;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

import java.nio.file.Path;

public class PERFIL extends MainActivity
{
    ImageView perfil = findViewById(R.id.perfil);
    ImageView portda = findViewById(R.id.portada);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);
        botones();
        posts();
        subim();
    }

    public void botones ()
    {

        FirebaseAuth.getInstance().signOut();

    }
    private void posts()
    {
        //en esta tengo que buscar las imageenes con los captions de la bd



    }

    private void cambiar()
    {
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imageintent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                imageintent.setType("image/");
                startActivityIfNeeded(imageintent.createChooser(imageintent,"Seleccione la app"),10);

                Intent cambiar = new Intent(PERFIL.this,subirImagenes.class);
                startActivity(cambiar);

            }
        });
    }
    private void subim()
    {

    }

}
