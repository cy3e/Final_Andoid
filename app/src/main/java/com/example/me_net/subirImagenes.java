package com.example.me_net;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.Random;

public class subirImagenes  extends MainActivity
{

    FirebaseStorage storage = FirebaseStorage.getInstance();


    EditText cap = findViewById(R.id.caption);
    ImageButton pic = findViewById(R.id.subir);
    ImageButton vol = findViewById(R.id.reg);
    ImageView vip = findViewById(R.id.vimage);

    String alagos[] = {"oh que foto mas mona tenemos ","que divertitda foto vemos aqui jajsds"," encerio subiste eso ","Dios mio que fotazo"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subirmeme);
        subir();
        mosimage();
        votones();
    }

    private void mosimage()
    {
        // aqui va la funcion de mostrar la imagen en el imageView



    }

    private void subir()
     {
         Random rand = new Random();
         int i =0;
         i = rand.nextInt(4);
         subimagen();
         Intent inte = new Intent (subirImagenes.this,PERFIL.class);
         startActivity(inte);
         Toast.makeText(getApplicationContext(), alagos[i], Toast.LENGTH_LONG).show();
     }

     private void votones() {
         {
             vip.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     //en esta debo pedir la imagen par luego mandarla a la clase subir memes
                     Intent imageintent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                     imageintent.setType("image/");
                     startActivityIfNeeded(imageintent.createChooser(imageintent, "Seleccione la app"), 10);
                 }
             });

         }
     }

     protected void onActivityResult(int requestC,int resultC,Intent data) {
         super.onActivityResult(requestC, resultC, data);
         if (resultC == RESULT_OK)
         {
             Uri path = data.getData();
             vip.setImageURI(path);

         }
     }

     private void subimagen()
     {
         Uri file = Uri.fromFile(new File("path/to/images/rivers.jpg"));
         StorageReference riversRef = storageRef.child("images/"+file.getLastPathSegment());
         UploadTask uploadTask = riversRef.putFile(file);

// Register observers to listen for when the download is done or if it fails
         uploadTask.addOnFailureListener(new OnFailureListener() {
             @Override
             public void onFailure(@NonNull Exception exception) {
                 // Handle unsuccessful uploads

                 Toast.makeText(getApplicationContext(),"no se pudo enviar la imagen reintente mas tarde",Toast.LENGTH_LONG);

             }
         }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
             @Override
             public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                 // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                 // ...
                 Intent volver = new Intent(subirImagenes.this,PERFIL.class);
                 startActivity(volver);

             }
         });
     }

}
