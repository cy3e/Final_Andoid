package com.example.me_net;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.FirebaseAppCheck;
import com.google.firebase.appcheck.safetynet.SafetyNetAppCheckProviderFactory;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.StorageReference;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class MainActivity extends AppCompatActivity
{
    public float x1,x2,y1,y2;
    public static int Min_Distance = 150;
    public GestureDetector gd;

    // for horizontal swipes
    float valueX = x2 - x1;
    // for vertical swipes
    float valueY = y2 - y1;


    private AtomicMarkableReference<Object> storage;
    StorageReference storageRef = (StorageReference) storage.getReference();

    //  StorageReference storef = storage.getReference();
    private FirebaseAuth mAuth;
// ...
//  Initialize Firebase Auth
//  mAuth = FirebaseAuth.getInstance();

    Button crear = findViewById(R.id.crearB);
    Button inicir = findViewById(R.id.iniciarB);

    EditText nick = findViewById(R.id.emaill);
    EditText emai = findViewById(R.id.nick);
    EditText passsw = findViewById(R.id.passsw);


    String mail,psw;

    boolean verificacion = false;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        //app check firebase
        FirebaseApp.initializeApp(this);
        FirebaseAppCheck firebaseAppCheck = FirebaseAppCheck.getInstance();
        firebaseAppCheck.installAppCheckProviderFactory(
                SafetyNetAppCheckProviderFactory.getInstance());

        onStart();
    }

    /////////////////////////////////////////////////////////////////////////////////
                           //Funciones de la base de datos

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
    }


    /////////////////////////////////////////////////////////////////////////////////

    public void inicio()
    {
        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(MainActivity.this, crear.class);
                startActivity(inte);
            }
        });
        inicir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(MainActivity.this, iniciar.class);
                startActivity(inte);
            }
        });

    }

    ////////////////////////////////////FIREBASE/////////////////////////////////////////////////

    public void updateUI(GoogleSignInAccount account){

        if(account != null){
            Toast.makeText(this,"U Signed In successfully",Toast.LENGTH_LONG).show();
            startActivity(new Intent(this,PERFIL.class));

        }else {
            Toast.makeText(this,"U Didnt signed in",Toast.LENGTH_LONG).show();
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////////////

    /*
    public void  verify() {

            // aqui va la funcion de revisar a la base de datos si hay  algun usuario
            for (int i; verificacion = true; i++)
            {
                if

            }
    }
     */
}


/*
LO QUE TENGO HECHO DEL PROJECTO

-LAS FUNCIONES BASICAS DE  NAVEGACION
-LAS FUNCIONES BASICAS DE ALERTAS
-LAS FUNCIONES BASE DE GUARDADO
-LAS FUNCIONES BASE DE VERIFICACION
-LOS LAYOUTS NECESARIOS
-LAS CLASES NECESARIAS
-LOS ITEMS QUE SE USARAN
-LOS EDITTEXT NECESARIOS
-LOS CONTENT VIEWS E IMAGEVIEWS NECESARIOS
-EL SIGN IN  - EL LOGIN  ME FALTA REPARRLO

--------------------------------------------

LO QUE ME FALTA

pt 1
-INCRUSTAR LA BASE DE DATOS A LA APLICACION (solo el login y el de crear tengo hecho) -esta hecho parcial mente solo falta retocarlo
-FINALIZAR EL MODELO DE INSERCCION DE USUARIOS *esta en proceso solo falta retocarlo

pt2
-HACER QUE EL PERFIL MUESTRE LAS IMAGENES QUE SE INSERTE POR EL USUSARIO - en curso
-HACER QUE EL FEED MUESTRE LAS PUBLICACIONES DE UNA CUENTA RANDOM -en curso

pt3
-HACER QUE SE AJUSTE EL CONTENIDO AL LAYOUT -hecho

-PONER A FUNCIONAR EL TABB - se elimino para usar una navegacicon por swipe
 */

