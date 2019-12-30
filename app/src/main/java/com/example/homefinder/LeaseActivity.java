package com.example.homefinder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class LeaseActivity extends AppCompatActivity {

    ImageView mImageView;
    Button mChooseBtn;

    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISIION_CODE = 1001;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lease);


        //VIEWS
        mImageView = findViewById(R.id.imageView);
        mChooseBtn = findViewById(R.id.photos);

        //handle button click
        mChooseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check runtime permission
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                    if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_DENIED){
                        //permission not granted, request it.
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        //show popup for runtime permission
                        requestPermissions(permissions, PERMISIION_CODE);

                    }
                    else {
                        //permission already granted
                        pickImageFromGallery();


                    }
                }
                else {
                    //system os is less than marshmello
                    pickImageFromGallery();

                }


            }
        });



    }

    private void pickImageFromGallery() {
        //intent to pick image
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

    //handle result of runtime permission
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISIION_CODE: {
                if (grantResults.length >0 && grantResults[0] ==
                PackageManager.PERMISSION_GRANTED) {
                  //PERMISSION WAS GRANTED
                    pickImageFromGallery();
                }
                else {
                    //permission was denied
                    Toast.makeText(this, "Permission denied..!!", Toast.LENGTH_SHORT).show();
                }
            }

        }

    }

    //handle result of picked image

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE){
            //set image to image view
            mImageView.setImageURI(data.getData());
        }
    }
}
