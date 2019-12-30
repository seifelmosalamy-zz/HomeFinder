package com.example.homefinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {

    private EditText InputName ,InputEmail, InputPassword;
    private FirebaseAuth firebaseAuth ;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firebaseAuth = FirebaseAuth.getInstance();
        InputEmail = (EditText) findViewById(R.id.email);
        InputPassword = (EditText) findViewById(R.id.password);
        InputName = (EditText) findViewById(R.id.name);


        Button CreateAccountButton = (Button) findViewById(R.id.submitBTN);

        CreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signupButtonPressed();
            }
        });

    }


    public void CreateUser(String email,String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Success", "createUserWithEmail:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Error", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });

    }
    public void signupButtonPressed(){
        String username = InputName.getText().toString();
        String password = InputPassword.getText().toString();
        String email = InputEmail.getText().toString();




        if(TextUtils.isEmpty(username))
        {
            Toast.makeText(this,"Please write you name",Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this,"Please write you email",Toast.LENGTH_SHORT).show();
        }
        else  if ( !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this,"Enter Correct EMAIL",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this,"Please write a password",Toast.LENGTH_SHORT).show();
        }
        else if (password.length() < 6)
        {
            Toast.makeText(this,"Password Should be at least 6 chars",Toast.LENGTH_SHORT).show();
        }

        else {
            ValidateUser(username,email,password);
        }

}






    private void ValidateUser( final String username, final  String email,  final String password) {
        final int hashedPass = password.hashCode();

        final DatabaseReference RootRef;
        CreateUser(email,password);
        RootRef = FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!(dataSnapshot.child("Users").child(username).exists())){
                    HashMap<String,Object> userDataMap = new HashMap<>();
                    userDataMap.put("Email",email);
                    userDataMap.put("Password",hashedPass);
                    userDataMap.put("Name", username);
                    RootRef.child("Users").child(username).updateChildren(userDataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(SignUpActivity.this, "Congratulations! Your Account Has Been Created.", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                                startActivity(intent);
                            }
                            else {


                                Toast.makeText(SignUpActivity.this, "It seems to be a small issue with your Network", Toast.LENGTH_SHORT).show();


                            }
                        }
                    });



                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });
    }

}
