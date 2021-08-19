package com.example.me_net;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class crear extends MainActivity
{
    private FirebaseAuth mAuth;

    DB admin = new DB(this, "me-net", null, 1);
    SQLiteDatabase bd = admin.getWritableDatabase();

    Button Crear = findViewById(R.id.createee);
    ImageButton reg = findViewById(R.id.backkk);
    EditText confirm = findViewById(R.id.cofima);



    String psw,confi;
    private GoogleSignInClient mGoogleSignInClient;
    // Set the dimensions of the sign-in button.
     SignInButton signInButton = findViewById(R.id.sign_in_button);



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        onStart();
        Funciones();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);
    }

    public void Funciones ()
    {
        Crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                psw = passsw.getText().toString();
                confi = confirm.getText().toString();

                if (psw == confi)
                {
                    googlesign();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "las contraseñas no coinciden ", Toast.LENGTH_LONG).show();
                }
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(crear.this, MainActivity.class);
                startActivity(inte);
            }
        });


    }

    public void googlesign()
    {
        mAuth.createUserWithEmailAndPassword(mail,psw)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }

                    private void updateUI(FirebaseUser user) {
                    }
                });
    }
}

