package com.example.me_net;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class PERFIL extends MainActivity
{
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
    }

}
