package com.example.me_net;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class iniciar extends MainActivity
{
    private FirebaseAuth mAuth;
// ...
//  Initialize Firebase Auth
//  mAuth = FirebaseAuth.getInstance();

    Button Log = findViewById(R.id.logear);
    ImageButton reg = findViewById(R.id.backkk2);
    EditText email = findViewById(R.id.Email);
    EditText pass = findViewById(R.id.Pswd);

    String Em, Pass;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciar);
       // loguear();
    }
/*
    public void loguear()
    {
        Em = email.getText().toString();
        Pass = pass.getText().toString();
        mAuth.signInWithEmailAndPassword(Em,Pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

 */


}



/*
                public void loguear()
                {
                    mAuth.signInWithEmailAndPassword(email, psw)
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        android.util.Log.d(TAG, "signInWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        updateUI(user);
                                        Intent intent = new Intent(iniciar.this, MainActivity.class);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        android.util.Log.w(TAG, "signInWithEmail:failure", task.getException());
                                        Toast.makeText(iniciar.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                        updateUI(null);
                                    }
                                }
                            });
                }
            }*/