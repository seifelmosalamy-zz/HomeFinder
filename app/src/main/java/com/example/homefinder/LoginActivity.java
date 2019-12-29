package com.example.homefinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText InputEmail, InputPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        InputEmail = (EditText) findViewById(R.id.emailLogin);
        InputPassword = (EditText) findViewById(R.id.passwordLogin);

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

    public void loginButtonPressed(View v){
        String password = InputPassword.getText().toString();
        String email = InputEmail.getText().toString();


        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Success", "signInWithEmail:success");

                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(LoginActivity.this, "Welcome Back!",
                                    Toast.LENGTH_SHORT).show();


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Failed", "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed Enter Valid data.",
                                    Toast.LENGTH_SHORT).show();

                        }


                    }
                });


    }
}
