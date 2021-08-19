package com.example.me_net;

import static android.service.controls.ControlsProviderService.TAG;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
        loguear();
    }

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

}
