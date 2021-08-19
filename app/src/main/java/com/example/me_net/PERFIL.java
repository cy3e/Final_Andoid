package com.example.me_net;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

import java.nio.file.Path;

public class PERFIL extends MainActivity
{
    ImageView imagin = findViewById(R.id.vimage);
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
    private void subim()
    {
        //en esta debo pedir la imagen par luego mandarla a la clase subir memes
        Intent imageintent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        imageintent.setType("image/");
        startActivityIfNeeded(imageintent.createChooser(imageintent,"Seleccione la app"),10);

        Intent cambiar = new Intent(PERFIL.this,subirImagenes.class);
        startActivity(cambiar);
    }

    protected void onActivityResult(int requestC,int resultC,Intent data) {
        super.onActivityResult(requestC, resultC, data);
        if (resultC == RESULT_OK)
        {
            Uri path = data.getData();
            imagin.setImageURI(path);

        }
    }

}
