package com.example.myapplication;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class MainActivity4 extends AppCompatActivity {

    //widgets

    private Button uploadBtn;
    private ImageView imageView;
    private ProgressBar progressBar;
    private EditText etwname,etaddress,etage,etmobile,etsal,etupi;

    //vars
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference("Image");
    private StorageReference reference = FirebaseStorage.getInstance().getReference();
    private Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        uploadBtn = findViewById(R.id.upload_btn);

        progressBar = findViewById(R.id.progressBar);
        imageView = findViewById(R.id.imageView);
        etwname = findViewById(R.id.etwname);
        etaddress = findViewById(R.id.etwaddress);
        etage = findViewById(R.id.etWage);
        etmobile = findViewById(R.id.etWno);
        etsal = findViewById(R.id.etsal);
        etupi = findViewById(R.id.etupi);

        progressBar.setVisibility(View.INVISIBLE);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent();
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent , 2);
            }
        });

        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (imageUri != null){
                    String wname = etwname.getText().toString().trim();
                    String mobile = etmobile.getText().toString().trim();
                    String address = etaddress.getText().toString().trim();
                    String age = etage.getText().toString().trim();
                    String upi = etupi.getText().toString().trim();
                    int sal =Integer.parseInt(etsal.getText().toString());

                    uploadToFirebase(imageUri , wname,mobile,address,age,sal,upi);
                }else{
                    Toast.makeText(MainActivity4.this, "Please Select Image", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode ==2 && resultCode == RESULT_OK && data != null){

            imageUri = data.getData();
            imageView.setImageURI(imageUri);

        }
    }

    private void uploadToFirebase(Uri uri, String wname,String mobile , String address, String age , int sal , String upi){

        final StorageReference fileRef = reference.child(System.currentTimeMillis() + "." + getFileExtension(uri));
        fileRef.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {


                        Model2 model = new Model2(uri.toString(),wname,mobile,address,age,sal,upi);
                        String modelId = root.push().getKey();
                        root.child(modelId).setValue(model);
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(MainActivity4.this, "Uploaded Successfully", Toast.LENGTH_SHORT).show();
                        imageView.setImageResource(R.drawable.ic_ip);

                    }
                });
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                progressBar.setVisibility(View.VISIBLE);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity4.this, "Uploading Failed !!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getFileExtension(Uri mUri){

        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(mUri));

    }


}











